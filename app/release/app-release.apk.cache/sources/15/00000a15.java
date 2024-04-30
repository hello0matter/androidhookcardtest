package w2;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.activity.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7061a;

    static {
        File externalStorageDirectory;
        String absolutePath;
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) {
            absolutePath = "";
        } else {
            absolutePath = externalStorageDirectory.getAbsolutePath();
        }
        if (TextUtils.isEmpty(absolutePath)) {
            File rootDirectory = Environment.getRootDirectory();
            if (rootDirectory != null) {
                str = rootDirectory.getAbsolutePath();
            }
            absolutePath = str;
        }
        f7061a = j.e(sb, absolutePath, "/.device");
    }

    public static String a() {
        File file;
        if (TextUtils.isEmpty(com.google.common.collect.c.f4202o)) {
            StringBuilder sb = new StringBuilder();
            String str = f7061a;
            String e4 = j.e(sb, str, "/.device.txt");
            if (!TextUtils.isEmpty(e4)) {
                file = new File(e4);
            } else {
                file = null;
            }
            if (file != null) {
                if (!file.exists()) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            AssetFileDescriptor openAssetFileDescriptor = com.google.common.collect.c.o0().getContentResolver().openAssetFileDescriptor(Uri.parse(e4), "r");
                            if (openAssetFileDescriptor != null) {
                                try {
                                    openAssetFileDescriptor.close();
                                } catch (IOException unused) {
                                }
                            }
                        } catch (FileNotFoundException unused2) {
                        }
                    }
                }
                File file2 = new File(j.c(str, "/.device.txt"));
                String str2 = "";
                try {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    str2 = bufferedReader.readLine();
                    if (str2 == null) {
                        fileInputStream.close();
                        inputStreamReader.close();
                        bufferedReader.close();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                com.google.common.collect.c.f4202o = str2;
                if (TextUtils.isEmpty(str2)) {
                    com.google.common.collect.c.f4202o = c.a();
                }
            }
            String a5 = c.a();
            com.google.common.collect.c.f4202o = a5;
            try {
                File file3 = new File(str);
                if (!file3.exists()) {
                    file3.mkdir();
                }
            } catch (Exception unused3) {
            }
            try {
                try {
                    File file4 = new File(str + "/.device.txt");
                    if (!file4.exists()) {
                        file4.createNewFile();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str + "/.device.txt");
                fileOutputStream.write(a5.getBytes());
                fileOutputStream.close();
            } catch (Exception unused4) {
            }
        }
        return com.google.common.collect.c.f4202o;
    }
}