package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import i0.g2;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f1589a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f1590b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1591c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1592d;

    public FragmentContainerView(@NonNull Context context) {
        super(context);
        this.f1592d = true;
    }

    public final void a(View view) {
        ArrayList arrayList = this.f1590b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f1589a == null) {
            this.f1589a = new ArrayList();
        }
        this.f1589a.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        t tVar;
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof t) {
            tVar = (t) tag;
        } else {
            tVar = null;
        }
        if (tVar != null) {
            super.addView(view, i4, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i4, ViewGroup.LayoutParams layoutParams, boolean z4) {
        t tVar;
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof t) {
            tVar = (t) tag;
        } else {
            tVar = null;
        }
        if (tVar != null) {
            return super.addViewInLayout(view, i4, layoutParams, z4);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        g2 j4;
        g2 h4 = g2.h(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1591c;
        if (onApplyWindowInsetsListener != null) {
            j4 = g2.h(null, onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            j4 = i0.y0.j(this, h4);
        }
        if (!j4.f4931a.m()) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                i0.y0.b(getChildAt(i4), j4);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f1592d && this.f1589a != null) {
            for (int i4 = 0; i4 < this.f1589a.size(); i4++) {
                super.drawChild(canvas, (View) this.f1589a.get(i4), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        ArrayList arrayList;
        if (!this.f1592d || (arrayList = this.f1589a) == null || arrayList.size() <= 0 || !this.f1589a.contains(view)) {
            return super.drawChild(canvas, view, j4);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.f1590b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f1589a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1592d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z4) {
        if (z4) {
            a(view);
        }
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i4) {
        a(getChildAt(i4));
        super.removeViewAt(i4);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            a(getChildAt(i6));
        }
        super.removeViews(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            a(getChildAt(i6));
        }
        super.removeViewsInLayout(i4, i5);
    }

    public void setDrawDisappearingViewsLast(boolean z4) {
        this.f1592d = z4;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@NonNull View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f1591c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1590b == null) {
                this.f1590b = new ArrayList();
            }
            this.f1590b.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        String str;
        this.f1592d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.a.f6684b);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }
}