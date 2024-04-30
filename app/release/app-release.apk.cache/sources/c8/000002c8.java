package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.util.Map;

/* loaded from: classes.dex */
public class w {

    /* renamed from: j  reason: collision with root package name */
    public static final Object f1927j = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f1928a;

    /* renamed from: b  reason: collision with root package name */
    public final i.g f1929b = new i.g();

    /* renamed from: c  reason: collision with root package name */
    public int f1930c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1931d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f1932e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f1933f;

    /* renamed from: g  reason: collision with root package name */
    public int f1934g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1935h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1936i;

    public w() {
        Object obj = f1927j;
        this.f1933f = obj;
        this.f1932e = obj;
        this.f1934g = -1;
    }

    public static void a(String str) {
        h.b.a().f4794a.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        throw new IllegalStateException(androidx.activity.j.d("Cannot invoke ", str, " on a background thread"));
    }

    public final void b(v vVar) {
        if (vVar.f1924b) {
            if (!vVar.e()) {
                vVar.c(false);
                return;
            }
            int i4 = vVar.f1925c;
            int i5 = this.f1934g;
            if (i4 < i5) {
                vVar.f1925c = i5;
                androidx.fragment.app.n nVar = vVar.f1923a;
                Object obj = this.f1932e;
                nVar.getClass();
                if (((q) obj) != null) {
                    androidx.fragment.app.p pVar = (androidx.fragment.app.p) nVar.f1752b;
                    if (pVar.Z) {
                        View D = pVar.D();
                        if (D.getParent() == null) {
                            if (pVar.f1765d0 != null) {
                                if (Log.isLoggable("FragmentManager", 3)) {
                                    Log.d("FragmentManager", "DialogFragment " + nVar + " setting the content view on " + pVar.f1765d0);
                                }
                                pVar.f1765d0.setContentView(D);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
            }
        }
    }

    public final void c(v vVar) {
        if (this.f1935h) {
            this.f1936i = true;
            return;
        }
        this.f1935h = true;
        do {
            this.f1936i = false;
            if (vVar != null) {
                b(vVar);
                vVar = null;
            } else {
                i.g gVar = this.f1929b;
                gVar.getClass();
                i.d dVar = new i.d(gVar);
                gVar.f4904c.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((v) ((Map.Entry) dVar.next()).getValue());
                    if (this.f1936i) {
                        break;
                    }
                }
            }
        } while (this.f1936i);
        this.f1935h = false;
    }

    public final void d(androidx.fragment.app.n nVar) {
        Object obj;
        a("observeForever");
        v vVar = new v(this, nVar);
        i.g gVar = this.f1929b;
        i.c a5 = gVar.a(nVar);
        if (a5 != null) {
            obj = a5.f4894b;
        } else {
            i.c cVar = new i.c(nVar, vVar);
            gVar.f4905d++;
            i.c cVar2 = gVar.f4903b;
            if (cVar2 == null) {
                gVar.f4902a = cVar;
            } else {
                cVar2.f4895c = cVar;
                cVar.f4896d = cVar2;
            }
            gVar.f4903b = cVar;
            obj = null;
        }
        v vVar2 = (v) obj;
        if (!(vVar2 instanceof LiveData$LifecycleBoundObserver)) {
            if (vVar2 == null) {
                vVar.c(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public final void e(Object obj) {
        a("setValue");
        this.f1934g++;
        this.f1932e = obj;
        c(null);
    }
}