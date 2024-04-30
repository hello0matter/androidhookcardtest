package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.appcompat.app.o0;
import com.google.common.collect.c;
import java.io.File;
import x0.e;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        int i4;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            e.b(context, new h.a(2), new o0(20, this), true);
        } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    o0 o0Var = new o0(20, this);
                    try {
                        e.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                        o0Var.l(10, null);
                    } catch (PackageManager.NameNotFoundException e4) {
                        o0Var.l(7, e4);
                    }
                } else if ("DELETE_SKIP_FILE".equals(string)) {
                    o0 o0Var2 = new o0(20, this);
                    new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                    o0Var2.l(11, null);
                }
            }
        } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            Process.sendSignal(Process.myPid(), 10);
            Log.d("ProfileInstaller", "");
            setResultCode(12);
        } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
            String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
            o0 o0Var3 = new o0(20, this);
            if ("DROP_SHADER_CACHE".equals(string2)) {
                if (c.h0(context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
                    i4 = 14;
                } else {
                    i4 = 15;
                }
                o0Var3.l(i4, null);
                return;
            }
            o0Var3.l(16, null);
        }
    }
}