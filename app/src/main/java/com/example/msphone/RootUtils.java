package com.example.msphone;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class RootUtils {

    private static volatile Boolean rootCached = null;

    public static boolean isRooted() {
        if (Boolean.TRUE.equals(rootCached)) return true; // only cache success
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"su", "-c", "id"});
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = br.readLine();
            p.waitFor();
            boolean ok = (line != null && line.contains("uid=0"));
            if (ok) rootCached = true;
            return ok;
        } catch (Throwable t) {
            return false;
        }
    }

    /** 以 Root 权限执行命令并返回合并的 stdout+stderr 输出。*/
    public static String execAsRootWithOutput(String cmd) {
        StringBuilder out = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(cmd + "\n");
            os.writeBytes("exit\n");
            os.flush();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = stdout.readLine()) != null) out.append(line).append("\n");
            while ((line = stderr.readLine()) != null) out.append("[ERR] ").append(line).append("\n");
            process.waitFor();
        } catch (Throwable t) {
            out.append("[EXCEPTION] ").append(t.getMessage());
        } finally {
            if (process != null) try { process.destroy(); } catch (Throwable ignored) {}
        }
        return out.toString().trim();
    }

    /** 以 Root 权限执行一条或多条命令，只关心是否成功（exit=0）。*/
    public static boolean executeAsRoot(String... commands) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            for (String command : commands) os.writeBytes(command + "\n");
            os.writeBytes("exit\n");
            os.flush();
            return process.waitFor() == 0;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) try { process.destroy(); } catch (Throwable ignored) {}
        }
    }
}
