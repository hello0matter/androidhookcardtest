package g;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.search.SearchBar;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class g implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4623a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4624b;

    public /* synthetic */ g(int i4, Object obj) {
        this.f4623a = i4;
        this.f4624b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        int i4 = this.f4623a;
        Object obj = this.f4624b;
        switch (i4) {
            case 0:
            case 1:
                return;
            case 2:
                SearchBar searchBar = (SearchBar) obj;
                j0.c.a(searchBar.f3738j0, searchBar.f3739k0);
                return;
            default:
                com.google.android.material.textfield.l lVar = (com.google.android.material.textfield.l) obj;
                int i5 = com.google.android.material.textfield.l.f4048w;
                if (lVar.f4069u != null && (accessibilityManager = lVar.f4068t) != null) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (i0.j0.b(lVar)) {
                        j0.c.a(accessibilityManager, lVar.f4069u);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        int i4 = this.f4623a;
        Object obj = this.f4624b;
        switch (i4) {
            case 0:
                j jVar = (j) obj;
                ViewTreeObserver viewTreeObserver = jVar.f4677y;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        jVar.f4677y = view.getViewTreeObserver();
                    }
                    jVar.f4677y.removeGlobalOnLayoutListener(jVar.f4662j);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            case 1:
                i0 i0Var = (i0) obj;
                ViewTreeObserver viewTreeObserver2 = i0Var.f4648p;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        i0Var.f4648p = view.getViewTreeObserver();
                    }
                    i0Var.f4648p.removeGlobalOnLayoutListener(i0Var.f4642j);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            case 2:
                SearchBar searchBar = (SearchBar) obj;
                j0.c.b(searchBar.f3738j0, searchBar.f3739k0);
                return;
            default:
                com.google.android.material.textfield.l lVar = (com.google.android.material.textfield.l) obj;
                int i5 = com.google.android.material.textfield.l.f4048w;
                j0.d dVar = lVar.f4069u;
                if (dVar != null && (accessibilityManager = lVar.f4068t) != null) {
                    j0.c.b(accessibilityManager, dVar);
                    return;
                }
                return;
        }
    }
}