package androidx.fragment.app;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class t0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1827a = 2;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1828b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1829c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1830d;

    public t0(k kVar, ArrayList arrayList, f1 f1Var) {
        this.f1830d = kVar;
        this.f1828b = arrayList;
        this.f1829c = f1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f1827a;
        Object obj = this.f1830d;
        Object obj2 = this.f1829c;
        Object obj3 = this.f1828b;
        switch (i4) {
            case 0:
                ((d0) obj3).b((t) obj2, (e0.c) obj);
                return;
            case 1:
                ((d0) obj3).b((t) obj2, (e0.c) obj);
                return;
            default:
                List list = (List) obj3;
                f1 f1Var = (f1) obj2;
                if (list.contains(f1Var)) {
                    list.remove(f1Var);
                    ((k) obj).getClass();
                    f1Var.f1695a.a(f1Var.f1697c.E);
                    return;
                }
                return;
        }
    }
}