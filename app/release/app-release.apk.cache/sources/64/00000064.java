package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.e0;
import androidx.fragment.app.k0;
import androidx.lifecycle.Lifecycle$State;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f158a;

    /* renamed from: b  reason: collision with root package name */
    public final y2.g f159b = new y2.g();

    /* renamed from: c  reason: collision with root package name */
    public e0 f160c;

    /* renamed from: d  reason: collision with root package name */
    public final OnBackInvokedCallback f161d;

    /* renamed from: e  reason: collision with root package name */
    public OnBackInvokedDispatcher f162e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f163f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f164g;

    public w(Runnable runnable) {
        OnBackInvokedCallback a5;
        this.f158a = runnable;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            if (i4 >= 34) {
                a5 = u.f155a.a(new e3.l() { // from class: androidx.activity.OnBackPressedDispatcher$1
                    @Override // e3.l
                    public final Object c(Object obj) {
                        Object obj2;
                        com.google.common.collect.c.F((b) obj, "backEvent");
                        w wVar = w.this;
                        y2.g gVar = wVar.f159b;
                        ListIterator listIterator = gVar.listIterator(gVar.size());
                        while (true) {
                            if (listIterator.hasPrevious()) {
                                obj2 = listIterator.previous();
                                if (((e0) obj2).f1683a) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        wVar.f160c = (e0) obj2;
                        return x2.c.f7143a;
                    }
                }, new e3.l() { // from class: androidx.activity.OnBackPressedDispatcher$2
                    @Override // e3.l
                    public final Object c(Object obj) {
                        Object obj2;
                        com.google.common.collect.c.F((b) obj, "backEvent");
                        y2.g gVar = w.this.f159b;
                        ListIterator listIterator = gVar.listIterator(gVar.size());
                        while (true) {
                            if (listIterator.hasPrevious()) {
                                obj2 = listIterator.previous();
                                if (((e0) obj2).f1683a) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        e0 e0Var = (e0) obj2;
                        return x2.c.f7143a;
                    }
                }, new e3.a() { // from class: androidx.activity.OnBackPressedDispatcher$3
                    @Override // e3.a
                    public final Object a() {
                        w.this.b();
                        return x2.c.f7143a;
                    }
                }, new e3.a() { // from class: androidx.activity.OnBackPressedDispatcher$4
                    @Override // e3.a
                    public final Object a() {
                        Object obj;
                        w wVar = w.this;
                        y2.g gVar = wVar.f159b;
                        ListIterator listIterator = gVar.listIterator(gVar.size());
                        while (true) {
                            if (listIterator.hasPrevious()) {
                                obj = listIterator.previous();
                                if (((e0) obj).f1683a) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        e0 e0Var = (e0) obj;
                        wVar.f160c = null;
                        return x2.c.f7143a;
                    }
                });
            } else {
                a5 = s.f150a.a(new e3.a() { // from class: androidx.activity.OnBackPressedDispatcher$5
                    @Override // e3.a
                    public final Object a() {
                        w.this.b();
                        return x2.c.f7143a;
                    }
                });
            }
            this.f161d = a5;
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.FunctionReference, e3.a] */
    public final void a(androidx.lifecycle.q qVar, e0 e0Var) {
        com.google.common.collect.c.F(e0Var, "onBackPressedCallback");
        androidx.lifecycle.s f4 = qVar.f();
        if (f4.f1915c == Lifecycle$State.f1864a) {
            return;
        }
        e0Var.f1684b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, f4, e0Var));
        d();
        e0Var.f1685c = new FunctionReference(this);
    }

    public final void b() {
        Object obj;
        y2.g gVar = this.f159b;
        ListIterator<E> listIterator = gVar.listIterator(gVar.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                obj = listIterator.previous();
                if (((e0) obj).f1683a) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        e0 e0Var = (e0) obj;
        this.f160c = null;
        if (e0Var != null) {
            k0 k0Var = e0Var.f1686d;
            k0Var.x(true);
            if (k0Var.f1730h.f1683a) {
                k0Var.M();
                return;
            } else {
                k0Var.f1729g.b();
                return;
            }
        }
        Runnable runnable = this.f158a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void c(boolean z4) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f162e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f161d) == null) {
            return;
        }
        s sVar = s.f150a;
        if (z4 && !this.f163f) {
            sVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f163f = true;
        } else if (z4 || !this.f163f) {
        } else {
            sVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f163f = false;
        }
    }

    public final void d() {
        boolean z4 = this.f164g;
        y2.g gVar = this.f159b;
        boolean z5 = false;
        if (!(gVar instanceof Collection) || !gVar.isEmpty()) {
            Iterator it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((e0) it.next()).f1683a) {
                    z5 = true;
                    break;
                }
            }
        }
        this.f164g = z5;
        if (z5 != z4 && Build.VERSION.SDK_INT >= 33) {
            c(z5);
        }
    }
}