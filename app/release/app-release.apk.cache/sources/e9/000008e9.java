package o2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.n0;
import com.google.android.material.tabs.TabLayout;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f5975c = 0;

    /* renamed from: a  reason: collision with root package name */
    public ValueAnimator f5976a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabLayout f5977b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TabLayout tabLayout, Context context) {
        super(context);
        this.f5977b = tabLayout;
        setWillNotDraw(false);
    }

    public final void a(int i4) {
        TabLayout tabLayout = this.f5977b;
        if (tabLayout.S != 0 && (tabLayout.getTabSelectedIndicator().getBounds().left != -1 || tabLayout.getTabSelectedIndicator().getBounds().right != -1)) {
            return;
        }
        View childAt = getChildAt(i4);
        com.google.android.material.tabs.a aVar = tabLayout.I;
        Drawable drawable = tabLayout.f3916o;
        aVar.getClass();
        RectF a5 = com.google.android.material.tabs.a.a(tabLayout, childAt);
        drawable.setBounds((int) a5.left, drawable.getBounds().top, (int) a5.right, drawable.getBounds().bottom);
        tabLayout.f3902a = i4;
    }

    public final void b(int i4) {
        TabLayout tabLayout = this.f5977b;
        Rect bounds = tabLayout.f3916o.getBounds();
        tabLayout.f3916o.setBounds(bounds.left, 0, bounds.right, i4);
        requestLayout();
    }

    public final void c(View view, View view2, float f4) {
        TabLayout tabLayout = this.f5977b;
        if (view != null && view.getWidth() > 0) {
            tabLayout.I.b(tabLayout, view, view2, f4, tabLayout.f3916o);
        } else {
            Drawable drawable = tabLayout.f3916o;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.f3916o.getBounds().bottom);
        }
        WeakHashMap weakHashMap = y0.f4999a;
        g0.k(this);
    }

    public final void d(int i4, int i5, boolean z4) {
        TabLayout tabLayout = this.f5977b;
        if (tabLayout.f3902a == i4) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i4);
        if (childAt2 == null) {
            a(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.f3902a = i4;
        e eVar = new e(this, childAt, childAt2);
        if (z4) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f5976a = valueAnimator;
            valueAnimator.setInterpolator(tabLayout.J);
            valueAnimator.setDuration(i5);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(eVar);
            valueAnimator.start();
            return;
        }
        this.f5976a.removeAllUpdateListeners();
        this.f5976a.addUpdateListener(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            com.google.android.material.tabs.TabLayout r0 = r6.f5977b
            android.graphics.drawable.Drawable r1 = r0.f3916o
            android.graphics.Rect r1 = r1.getBounds()
            int r1 = r1.height()
            if (r1 >= 0) goto L14
            android.graphics.drawable.Drawable r1 = r0.f3916o
            int r1 = r1.getIntrinsicHeight()
        L14:
            int r2 = r0.B
            if (r2 == 0) goto L38
            r3 = 1
            r4 = 2
            if (r2 == r3) goto L29
            r3 = 0
            if (r2 == r4) goto L3f
            r1 = 3
            if (r2 == r1) goto L24
            r1 = r3
            goto L3f
        L24:
            int r1 = r6.getHeight()
            goto L3f
        L29:
            int r2 = r6.getHeight()
            int r2 = r2 - r1
            int r3 = r2 / 2
            int r2 = r6.getHeight()
            int r2 = r2 + r1
            int r1 = r2 / 2
            goto L3f
        L38:
            int r2 = r6.getHeight()
            int r3 = r2 - r1
            goto L24
        L3f:
            android.graphics.drawable.Drawable r2 = r0.f3916o
            android.graphics.Rect r2 = r2.getBounds()
            int r2 = r2.width()
            if (r2 <= 0) goto L5f
            android.graphics.drawable.Drawable r2 = r0.f3916o
            android.graphics.Rect r2 = r2.getBounds()
            android.graphics.drawable.Drawable r4 = r0.f3916o
            int r5 = r2.left
            int r2 = r2.right
            r4.setBounds(r5, r3, r2, r1)
            android.graphics.drawable.Drawable r0 = r0.f3916o
            r0.draw(r7)
        L5f:
            super.draw(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.f.draw(android.graphics.Canvas):void");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        ValueAnimator valueAnimator = this.f5976a;
        TabLayout tabLayout = this.f5977b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            d(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        if (tabLayout.f3902a == -1) {
            tabLayout.f3902a = tabLayout.getSelectedTabPosition();
        }
        a(tabLayout.f3902a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f5977b;
        if (tabLayout.f3927z == 1 || tabLayout.C == 2) {
            int childCount = getChildCount();
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() == 0) {
                    i6 = Math.max(i6, childAt.getMeasuredWidth());
                }
            }
            if (i6 <= 0) {
                return;
            }
            if (i6 * childCount <= getMeasuredWidth() - (((int) n0.c(getContext(), 16)) * 2)) {
                boolean z4 = false;
                for (int i8 = 0; i8 < childCount; i8++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i8).getLayoutParams();
                    if (layoutParams.width != i6 || layoutParams.weight != 0.0f) {
                        layoutParams.width = i6;
                        layoutParams.weight = 0.0f;
                        z4 = true;
                    }
                }
                if (!z4) {
                    return;
                }
            } else {
                tabLayout.f3927z = 0;
                tabLayout.k(false);
            }
            super.onMeasure(i4, i5);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
    }
}