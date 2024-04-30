package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.b0;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.reflect.Method;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f95a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f96b;

    public /* synthetic */ d(int i4, Object obj) {
        this.f95a = i4;
        this.f96b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4;
        Object obj;
        switch (this.f95a) {
            case 0:
                ((ComponentActivity) this.f96b).invalidateOptionsMenu();
                return;
            case 1:
                n nVar = (n) this.f96b;
                Runnable runnable = nVar.f109b;
                if (runnable != null) {
                    runnable.run();
                    nVar.f109b = null;
                    return;
                }
                return;
            case 2:
                p.a((p) this.f96b);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
            case 7:
            default:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) this.f96b;
                boolean isPopupShowing = iVar.f4035h.isPopupShowing();
                iVar.t(isPopupShowing);
                iVar.f4040m = isPopupShowing;
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                Activity activity = (Activity) this.f96b;
                int i4 = x.e.f7064b;
                if (!activity.isFinishing()) {
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 28) {
                        Class cls = x.g.f7071a;
                        activity.recreate();
                        return;
                    }
                    Class cls2 = x.g.f7071a;
                    if (i5 != 26 && i5 != 27) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    Method method = x.g.f7076f;
                    if ((!z4 || method != null) && (x.g.f7075e != null || x.g.f7074d != null)) {
                        try {
                            Object obj2 = x.g.f7073c.get(activity);
                            if (obj2 != null && (obj = x.g.f7072b.get(activity)) != null) {
                                Application application = activity.getApplication();
                                x.f fVar = new x.f(activity);
                                application.registerActivityLifecycleCallbacks(fVar);
                                Handler handler = x.g.f7077g;
                                handler.post(new androidx.appcompat.widget.j(fVar, obj2, 3));
                                if (i5 != 26 && i5 != 27) {
                                    activity.recreate();
                                } else {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                }
                                handler.post(new androidx.appcompat.widget.j(application, fVar, 4));
                                return;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    activity.recreate();
                    return;
                }
                return;
            case VisibleForTesting.NONE /* 5 */:
                b0 b0Var = (b0) this.f96b;
                b0 b0Var2 = b0.f1883i;
                com.google.common.collect.c.F(b0Var, "this$0");
                if (b0Var.f1885b == 0) {
                    b0Var.f1886c = true;
                    b0Var.f1889f.e(Lifecycle$Event.ON_PAUSE);
                }
                if (b0Var.f1884a == 0 && b0Var.f1886c) {
                    b0Var.f1889f.e(Lifecycle$Event.ON_STOP);
                    b0Var.f1887d = true;
                    return;
                }
                return;
            case 6:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) this.f96b;
                Surface surface = sphericalGLSurfaceView.f2863h;
                if (surface != null) {
                    Iterator it = sphericalGLSurfaceView.f2856a.iterator();
                    if (it.hasNext()) {
                        j.f(it.next());
                        throw null;
                    }
                }
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f2862g;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                sphericalGLSurfaceView.f2862g = null;
                sphericalGLSurfaceView.f2863h = null;
                return;
            case 8:
                f2.f fVar2 = (f2.f) this.f96b;
                f2.c cVar = fVar2.f4560a;
                if (cVar != null) {
                    cVar.b(fVar2.f4561b, fVar2.f4562c, true);
                    return;
                }
                return;
            case 9:
                t1.b bVar = (t1.b) this.f96b;
                bVar.f6688c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) bVar.f6690e;
                n0.e eVar = sideSheetBehavior.f3818i;
                if (eVar != null && eVar.g()) {
                    bVar.a(bVar.f6687b);
                    return;
                } else if (sideSheetBehavior.f3817h == 2) {
                    sideSheetBehavior.x(bVar.f6687b);
                    return;
                } else {
                    return;
                }
            case 10:
                ((com.google.android.material.textfield.c) this.f96b).t(true);
                return;
        }
    }
}