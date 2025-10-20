package com.example.msphone;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

public class SettingsProvider extends ContentProvider {

    private static final String TAG = "SettingsProvider";
    // 唯一的授权地址，用于识别我们的Provider
    private static final String AUTHORITY = "com.example.msphone.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/settings");

    // SharedPreferences 文件名
    private static final String PREFS_NAME = "XposedModulePrefs";

    // ========================================================================================
    // 【风格A：对外暴露的Key】 - 这是给 xp.java 使用的，变量名与 xp.java 内部一致
    // ========================================================================================
    private static final String KEY_CURRENT_SPEED = "currentSpeed";       // 我们决定对外提供 float 类型的速度
    private static final String KEY_ROB_DELAY_MS = "rob_delay_ms";
    private static final String KEY_ROB_DELAY_MS_DELAY = "rob_delay_ms_delay";
    private static final String KEY_TEST1 = "test1";
    private static final String KEY_TEST2 = "test2";
    private static final String KEY_TEST3 = "test3";
    private static final String KEY_XSFVS = "xsfvs";                  // 对外提供 cdkValue

    // ========================================================================================
    // 【风格B：内部存储的Key】 - 这是主App实际保存在 SharedPreferences 中的 Key
    // ========================================================================================
    private static final String INTERNAL_KEY_PROGRESS = "currentSpeed"; // 内部存的是 int 进度
    private static final String INTERNAL_KEY_CDK = "fdg341";          // 内部存 cdk 用的“迷惑”Key


    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Context context = getContext();
        if (context == null) {
//            //Log.e(TAG, "Context is null, cannot perform query.");
            return null;
        }

        try {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

            // 1. 定义对外暴露的 Cursor 的列名，顺序必须和下面的 addRow 一致
            String[] columns = {
                    KEY_CURRENT_SPEED, KEY_ROB_DELAY_MS, KEY_ROB_DELAY_MS_DELAY,
                    KEY_TEST1, KEY_TEST2, KEY_TEST3, KEY_XSFVS
            };

            MatrixCursor cursor = new MatrixCursor(columns);

            // 2. 【核心翻译逻辑】从内部存储读取，并转换为对外格式
            // 反算速度值
            int progress = prefs.getInt(INTERNAL_KEY_PROGRESS, 100);
            float speed = ((progress * 1.7f) / 170.0f) + 0.3f;

            // 3. 将所有“翻译”好的数据添加到一行中
            cursor.addRow(new Object[]{
                    speed, // KEY_CURRENT_SPEED -> 提供 float 速度值
                    prefs.getInt(KEY_ROB_DELAY_MS, 5000),
                    prefs.getInt(KEY_ROB_DELAY_MS_DELAY, 0),
                    prefs.getInt(KEY_TEST1, 0),
                    prefs.getInt(KEY_TEST2, 0),
                    prefs.getInt(KEY_TEST3, 0),
                    prefs.getInt(INTERNAL_KEY_CDK, 0) // KEY_XSFVS -> 提供 cdk 值
            });

            return cursor;
        } catch (Exception e) {
//            //Log.e(TAG, "Error while querying settings provider", e);
            return null; // 发生任何异常都安全返回 null
        }
    }

    // --- 以下方法我们用不到，保持默认实现即可 ---
    @Override
    public String getType(Uri uri) { return null; }

    @Override
    public Uri insert(Uri uri, ContentValues values) { return null; }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) { return 0; }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) { return 0; }
}