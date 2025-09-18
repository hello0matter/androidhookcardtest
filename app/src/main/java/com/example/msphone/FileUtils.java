package com.example.msphone;// FileUtils.java

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.UUID;

public class FileUtils {

    private static final String TAG = "FileUtils";
    private static final String DEVICE_ID_FILENAME = "device_identifier.txt"; // 定义我们的设备ID文件名

    /**
     * 获取持久化的设备唯一标识符。
     * 该方法兼容分区存储，将ID文件存储在应用的专属外部目录中，无需存储权限。
     *
     * @param context 上下文环境
     * @return 唯一的设备ID字符串
     */
    public static String getDeviceIdentifier(Context context) {
        // 1. 获取应用的专属外部文件目录
        // 这个目录在 /storage/emulated/0/Android/data/你的包名/files/
        // 不需要任何权限即可访问
        File externalFilesDir = context.getExternalFilesDir(null);

        // 健壮性检查：如果外部存储不可用，则返回一个临时ID
        if (externalFilesDir == null) {
            Log.e(TAG, "External storage is not available.");
            return UUID.randomUUID().toString();
        }

        // 2. 检查目录是否存在，如果不存在则创建
        if (!externalFilesDir.exists()) {
            if (!externalFilesDir.mkdirs()) {
                Log.e(TAG, "Failed to create directory for device identifier.");
                // 即使创建失败，也返回一个临时ID，保证程序能继续运行
                return UUID.randomUUID().toString();
            }
        }

        File idFile = new File(externalFilesDir, DEVICE_ID_FILENAME);
        String deviceId = null;

        // 3. 尝试读取文件中的ID
        if (idFile.exists()) {
            try (FileInputStream fis = new FileInputStream(idFile);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
                deviceId = reader.readLine();
            } catch (IOException e) {
                Log.e(TAG, "Failed to read device identifier file.", e);
            }
        }

        // 4. 如果文件不存在或读取到的ID为空，则生成一个新的ID并保存
        if (deviceId == null || deviceId.isEmpty()) {
            deviceId = UUID.randomUUID().toString(); // 生成一个标准的、唯一的UUID
            try (FileOutputStream fos = new FileOutputStream(idFile);
                 OutputStreamWriter writer = new OutputStreamWriter(fos)) {
                writer.write(deviceId);
                Log.i(TAG, "Generated and saved new device identifier.");
            } catch (IOException e) {
                Log.e(TAG, "Failed to write new device identifier file.", e);
            }
        }

        return deviceId;
    }

    // 您原来的 getSDDeviceTxt() 方法可以删除了
    // public static String getSDDeviceTxt() { ... }
}