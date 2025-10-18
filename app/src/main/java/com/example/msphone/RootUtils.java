package com.example.msphone;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class RootUtils {

    private static final String TAG = "RootUtils";

    // 用于保存最后一次执行时产生的错误信息
    private static String lastError = "";

    /**
     * 获取上一次执行Root命令时产生的错误信息。
     * @return 错误信息字符串，如果没有错误则为空字符串。
     */
    public static String getLastError() {
        return lastError;
    }

    /**
     * 以Root权限执行一条或多条Shell命令。
     *
     * @param commands 要执行的命令数组 (可变参数)。
     * @return 如果所有命令都成功执行（退出码为0且无错误输出），则返回 true；否则返回 false。
     */
    public static boolean executeAsRoot(String... commands) {
        // 每次执行前，清空上次的错误记录
        lastError = "";
        Process process = null;
        DataOutputStream os = null;
        BufferedReader errorReader = null;

        try {
            // 请求Root权限，执行su命令
            process = Runtime.getRuntime().exec("su");

            os = new DataOutputStream(process.getOutputStream());
            errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // 遍历传入的所有命令，并逐一写入到shell中
            for (String command : commands) {
                Log.d(TAG, "Executing command: " + command);
                os.writeBytes(command + "\n");
            }

            // 写入退出命令，结束shell会话
            os.writeBytes("exit\n");
            os.flush();

            // 等待进程执行完毕
            int exitCode = process.waitFor();

            // 读取可能发生的任何错误输出
            StringBuilder errorBuilder = new StringBuilder();
            String line;
            while ((line = errorReader.readLine()) != null) {
                errorBuilder.append(line).append("\n");
            }
            lastError = errorBuilder.toString().trim();

            // 如果错误信息不为空，也打印到Logcat，方便调试
            if (!lastError.isEmpty()) {
                Log.e(TAG, "Root command execution error:\n" + lastError);
            }

            // 只有当退出码为0 (表示最后一条命令成功)，并且没有任何错误输出时，才认为执行成功
            return exitCode == 0 && lastError.isEmpty();

        } catch (Exception e) {
            // 捕获Java层面的异常，例如 "su" 命令不存在或被拒绝
            lastError = e.getMessage();
            Log.e(TAG, "Exception while executing root command.", e);
            return false;
        } finally {
            // 确保所有流都被关闭
            try {
                if (os != null) {
                    os.close();
                }
                if (errorReader != null) {
                    errorReader.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                // 忽略关闭流时的异常
            }
        }
    }
}