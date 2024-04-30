package androidx.fragment.app;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1844a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1845b;

    public /* synthetic */ x(int i4, Object obj) {
        this.f1844a = i4;
        this.f1845b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view;
        int i4 = this.f1844a;
        Object obj = this.f1845b;
        switch (i4) {
            case 0:
                e eVar = (e) obj;
                Object obj2 = eVar.f1680c;
                r rVar = ((t) obj2).H;
                if (rVar == null) {
                    view = null;
                } else {
                    view = rVar.f1778a;
                }
                if (view != null) {
                    ((t) obj2).g().f1778a = null;
                    ((d0) eVar.f1681d).b((t) eVar.f1680c, (e0.c) eVar.f1682e);
                    return;
                }
                return;
            case 1:
                e eVar2 = (e) obj;
                eVar2.f1679b.endViewTransition((View) eVar2.f1680c);
                ((h) eVar2.f1681d).a();
                return;
            case 2:
                p pVar = (p) obj;
                pVar.V.onDismiss(pVar.f1765d0);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                ((k0) obj).x(true);
                return;
            default:
                u0.b((ArrayList) obj, 4);
                return;
        }
    }
}