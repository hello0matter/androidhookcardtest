// SettingsProvider.java
package com.example.msphone;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class SettingsProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.msphone.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/settings");

    // 定义所有配置的Key
    public static final String KEY_SPEED_FLOAT = "speed_float";
    public static final String KEY_SEEKBAR_PROGRESS_INT = "seekbar_progress_int";
    public static final String KEY_ROB_DELAY_MS_INT = "rob_delay_ms_int";
    public static final String KEY_ROB_DELAY_MS_DELAY_INT = "rob_delay_ms_delay_int";
    public static final String KEY_TEST1 = "test1";
    public static final String KEY_TEST2 = "test2";
    public static final String KEY_TEST3 = "test3";
    public static final String KEY_CDK_VALUE = "cdk_value";

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SharedPreferences prefs = getContext().getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

        MatrixCursor cursor = new MatrixCursor(new String[]{
                KEY_SPEED_FLOAT, KEY_SEEKBAR_PROGRESS_INT, KEY_ROB_DELAY_MS_INT,
                KEY_ROB_DELAY_MS_DELAY_INT, KEY_TEST1, KEY_TEST2, KEY_TEST3, KEY_CDK_VALUE
        });

        cursor.addRow(new Object[]{
                prefs.getFloat(KEY_SPEED_FLOAT, 1.0f),
                prefs.getInt(KEY_SEEKBAR_PROGRESS_INT, 100),
                prefs.getInt(KEY_ROB_DELAY_MS_INT, 1500),
                prefs.getInt(KEY_ROB_DELAY_MS_DELAY_INT, 0),
                prefs.getInt(KEY_TEST1, 0),
                prefs.getInt(KEY_TEST2, 0),
                prefs.getInt(KEY_TEST3, 0),
                prefs.getInt(KEY_CDK_VALUE, 0)
        });

        return cursor;
    }

    // 以下方法我们不需要实现，返回null或0即可
    @Override
    public String getType(Uri uri) { return null; }

    @Override
    public Uri insert(Uri uri, ContentValues values) { return null; }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) { return 0; }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) { return 0; }
}