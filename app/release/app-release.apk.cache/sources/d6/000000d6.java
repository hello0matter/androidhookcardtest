package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final m0 f312a = new m0(new Object());

    /* renamed from: b  reason: collision with root package name */
    public static final int f313b = -100;

    /* renamed from: c  reason: collision with root package name */
    public static e0.f f314c = null;

    /* renamed from: d  reason: collision with root package name */
    public static e0.f f315d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f316e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f317f = false;

    /* renamed from: g  reason: collision with root package name */
    public static final l.c f318g = new l.c();

    /* renamed from: h  reason: collision with root package name */
    public static final Object f319h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static final Object f320i = new Object();

    public static boolean d(Context context) {
        if (f316e == null) {
            try {
                int i4 = AppLocalesMetadataHolderService.f184a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), k0.a() | 128).metaData;
                if (bundle != null) {
                    f316e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f316e = Boolean.FALSE;
            }
        }
        return f316e.booleanValue();
    }

    public static void g(q qVar) {
        synchronized (f319h) {
            try {
                Iterator it = f318g.iterator();
                while (it.hasNext()) {
                    q qVar2 = (q) ((WeakReference) it.next()).get();
                    if (qVar2 == qVar || qVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void c();

    public abstract void e();

    public abstract void f();

    public abstract boolean h(int i4);

    public abstract void i(int i4);

    public abstract void j(View view);

    public abstract void k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void l(CharSequence charSequence);
}