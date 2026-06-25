package com.example.msphone;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;

/**
 * 引导用户手动开启后台运行、自启动等特殊权限的工具类
 * 适配小米、华为、OPPO、VIVO、三星、魅族等常见机型
 */
public class PermissionGuideHelper {

    private static final String TAG = "PermissionGuideHelper";
    private static final String PREFS_NAME = "PermissionGuidePrefs";
    private static final String KEY_HAS_GUIDED = "has_guided_to_settings";

    /**
     * 检查并引导用户去设置权限。
     * 只在第一次启动时引导，之后不再打扰。
     *
     * @param context Context
     */
    public static void checkAndGuide(final Context context) {
        // 如果系统版本低于Android 6.0，不需要特殊处理
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        final SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean hasGuided = prefs.getBoolean(KEY_HAS_GUIDED, false);

        // 如果已经引导过，或者已经加入了白名单，则不再弹窗
        if (hasGuided || isIgnoringBatteryOptimizations(context)) {
            return;
        }

        new AlertDialog.Builder(context)
                .setTitle("后台运行权限提示")
                .setMessage("为了保证应用功能的稳定运行（例如及时接收消息），建议您按照以下步骤操作：\n\n1. 在即将打开的页面中，找到我们的应用。\n\n2. 开启应用的“自启动”或“允许后台运行”权限。\n\n3. 关闭“电池优化”或设为“无限制”。")
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        jumpToPermissionSettings(context);
                        // 记录已经引导过，避免重复弹窗
                        prefs.edit().putBoolean(KEY_HAS_GUIDED, true).apply();
                    }
                })
                .setNegativeButton("以后再说", null)
                .show();
    }

    /**
     * 检查本应用是否已在电池优化的白名单中
     *
     * @param context Context
     * @return true 如果在白名单中
     */
    public static boolean isIgnoringBatteryOptimizations(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            if (powerManager != null) {
                return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
            }
        }
        return true; // 对于低于M版本的系统，默认认为是true
    }


    /**
     * 根据手机厂商，跳转到对应的权限设置页面
     *
     * @param context Context
     */
    public static void jumpToPermissionSettings(Context context) {
        String manufacturer = Build.MANUFACTURER.toLowerCase();
        Log.d(TAG, "Current manufacturer: " + manufacturer);

        try {
            switch (manufacturer) {
                case "xiaomi":
                    goToXiaomi(context);
                    break;
                case "huawei":
                case "honor": // 荣耀手机与华为类似
                    goToHuawei(context);
                    break;
                case "oppo":
                    goToOppo(context);
                    break;
                case "vivo":
                    goToVivo(context);
                    break;
                case "samsung":
                    goToSamsung(context);
                    break;
                case "meizu":
                    goToMeizu(context);
                    break;
                default:
                    // 如果以上都不是，则跳转到通用的电池优化设置
                    goToGenericBatteryOptimization(context);
                    break;
            }
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "Failed to jump to specific settings, jumping to generic settings.", e);
            // 如果特定厂商的跳转失败，则尝试跳转到通用的电池优化设置
            goToGenericBatteryOptimization(context);
        }
    }

    // --- 各厂商的跳转方法 ---

    private static void goToXiaomi(Context context) {
        // 尝试跳转到小米的自启动管理页面
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
        try {
            context.startActivity(intent);
            return;
        } catch (ActivityNotFoundException e) {
            // 如果失败，尝试跳转到神隐模式（旧版MIUI）或电池优化
            intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent.putExtra("package_name", context.getPackageName());
            intent.putExtra("package_label", "应用名"); // 请替换为您的应用名
            context.startActivity(intent);
        }
    }

    private static void goToHuawei(Context context) {
        // 尝试跳转到华为的启动管理页面
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"));
        try {
            context.startActivity(intent);
            return;
        } catch (ActivityNotFoundException e) {
            // 如果失败，尝试跳转到手机管家的应用启动管理
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity"));
            context.startActivity(intent);
        }
    }

    private static void goToOppo(Context context) {
        // 尝试跳转到OPPO的自启动管理页面
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
        try {
            context.startActivity(intent);
            return;
        } catch (ActivityNotFoundException e) {
            // 如果失败，尝试跳转到旧版的自启动管理
            intent.setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity"));
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                // 再失败，尝试跳转到电池管理
                intent.setComponent(new ComponentName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"));
                context.startActivity(intent);
            }
        }
    }

    private static void goToVivo(Context context) {
        // 尝试跳转到VIVO的后台高耗电管理页面
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
        try {
            context.startActivity(intent);
            return;
        } catch (ActivityNotFoundException e) {
            // 如果失败，尝试跳转到i管家首页
            intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.SoftwareManagerActivity"));
            context.startActivity(intent);
        }
    }

    private static void goToSamsung(Context context) {
        // 尝试跳转到三星的电池管理页面 -> 睡眠应用程序列表
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity"));
        try {
            context.startActivity(intent);
            return;
        } catch (ActivityNotFoundException e) {
            // 如果失败，跳转到通用的电池优化
            goToGenericBatteryOptimization(context);
        }
    }

    private static void goToMeizu(Context context) {
        // 魅族
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("packageName", context.getPackageName());
        context.startActivity(intent);
    }


    /**
     * 跳转到安卓系统通用的“忽略电池优化”设置
     */
    private static void goToGenericBatteryOptimization(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "No activity found for ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", e);
                // 如果连这个都失败了，就跳转到应用详情页，让用户自己找
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
            }
        }
    }
}