package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u3 implements g.d0 {

    /* renamed from: a  reason: collision with root package name */
    public g.p f919a;

    /* renamed from: b  reason: collision with root package name */
    public g.r f920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Toolbar f921c;

    public u3(Toolbar toolbar) {
        this.f921c = toolbar;
    }

    @Override // g.d0
    public final boolean c(g.j0 j0Var) {
        return false;
    }

    @Override // g.d0
    public final boolean e() {
        return false;
    }

    @Override // g.d0
    public final Parcelable g() {
        return null;
    }

    @Override // g.d0
    public final int getId() {
        return 0;
    }

    @Override // g.d0
    public final boolean h(g.r rVar) {
        Toolbar toolbar = this.f921c;
        toolbar.c();
        ViewParent parent = toolbar.f662h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f662h);
            }
            toolbar.addView(toolbar.f662h);
        }
        View actionView = rVar.getActionView();
        toolbar.f663i = actionView;
        this.f920b = rVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f663i);
            }
            Toolbar.LayoutParams h4 = Toolbar.h();
            h4.f177a = (toolbar.f668n & 112) | 8388611;
            h4.f681b = 2;
            toolbar.f663i.setLayoutParams(h4);
            toolbar.addView(toolbar.f663i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((Toolbar.LayoutParams) childAt.getLayoutParams()).f681b != 2 && childAt != toolbar.f655a) {
                toolbar.removeViewAt(childCount);
                toolbar.E.add(childAt);
            }
        }
        toolbar.requestLayout();
        rVar.C = true;
        rVar.f4735n.p(false);
        View view = toolbar.f663i;
        if (view instanceof f.d) {
            ((f.d) view).b();
        }
        toolbar.v();
        return true;
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
    }

    @Override // g.d0
    public final boolean j(g.r rVar) {
        Toolbar toolbar = this.f921c;
        View view = toolbar.f663i;
        if (view instanceof f.d) {
            ((f.d) view).e();
        }
        toolbar.removeView(toolbar.f663i);
        toolbar.removeView(toolbar.f662h);
        toolbar.f663i = null;
        ArrayList arrayList = toolbar.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f920b = null;
        toolbar.requestLayout();
        rVar.C = false;
        rVar.f4735n.p(false);
        toolbar.v();
        return true;
    }

    @Override // g.d0
    public final void l(Context context, g.p pVar) {
        g.r rVar;
        g.p pVar2 = this.f919a;
        if (pVar2 != null && (rVar = this.f920b) != null) {
            pVar2.d(rVar);
        }
        this.f919a = pVar;
    }

    @Override // g.d0
    public final void m(boolean z4) {
        if (this.f920b != null) {
            g.p pVar = this.f919a;
            if (pVar != null) {
                int size = pVar.f4700f.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.f919a.getItem(i4) == this.f920b) {
                        return;
                    }
                }
            }
            j(this.f920b);
        }
    }

    @Override // g.d0
    public final void a(g.p pVar, boolean z4) {
    }
}