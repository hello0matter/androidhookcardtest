package x0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.fragment.app.m0;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final m.g f7120a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f7121b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static m0 f7122c = null;

    public static long a(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            packageInfo = i.a(packageManager, context);
        } else {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        }
        return packageInfo.lastUpdateTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.m0, java.lang.Object] */
    public static m0 b() {
        ?? obj = new Object();
        f7122c = obj;
        m.g gVar = f7120a;
        gVar.getClass();
        if (m.f.f5427f.x(gVar, null, obj)) {
            m.f.b(gVar);
        }
        return f7122c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:24|25|26|(2:64|65)(1:28)|29|(8:36|(1:40)|(1:59)(1:47)|48|(2:55|56)|52|53|54)|(1:63)|(1:40)|(1:42)|59|48|(1:50)|55|56|52|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
        r4 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.k.c(android.content.Context, boolean):void");
    }
}