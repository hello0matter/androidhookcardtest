package g;

import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.o0;
import androidx.fragment.app.b1;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4626a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4627b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f4628c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f4629d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f4630e;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, Object obj4, int i4) {
        this.f4626a = i4;
        this.f4630e = obj;
        this.f4627b = obj2;
        this.f4628c = obj3;
        this.f4629d = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f4626a;
        Object obj = this.f4629d;
        Object obj2 = this.f4628c;
        Object obj3 = this.f4627b;
        switch (i4) {
            case 0:
                i iVar = (i) obj3;
                if (iVar != null) {
                    o0 o0Var = (o0) this.f4630e;
                    ((j) o0Var.f311b).A = true;
                    iVar.f4632b.c(false);
                    ((j) o0Var.f311b).A = false;
                }
                MenuItem menuItem = (MenuItem) obj2;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    ((p) obj).q(menuItem, null, 4);
                    return;
                }
                return;
            default:
                ((b1) obj3).getClass();
                b1.g((View) obj2, (Rect) obj);
                return;
        }
    }
}