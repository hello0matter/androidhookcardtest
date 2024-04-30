package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f405a;

    /* renamed from: b  reason: collision with root package name */
    public ScrollingTabContainerView f406b;

    /* renamed from: c  reason: collision with root package name */
    public View f407c;

    /* renamed from: d  reason: collision with root package name */
    public View f408d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f409e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f410f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f411g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f412h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f413i;

    /* renamed from: j  reason: collision with root package name */
    public final int f414j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f409e;
        if (drawable != null && drawable.isStateful()) {
            this.f409e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f410f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f410f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f411g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f411g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f406b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f409e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f410f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f411g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f407c = findViewById(R.id.action_bar);
        this.f408d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f405a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z4, i4, i5, i6, i7);
        ScrollingTabContainerView scrollingTabContainerView = this.f406b;
        boolean z5 = true;
        boolean z6 = (scrollingTabContainerView == null || scrollingTabContainerView.getVisibility() == 8) ? false : true;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            int i8 = ((FrameLayout.LayoutParams) scrollingTabContainerView.getLayoutParams()).bottomMargin;
            scrollingTabContainerView.layout(i4, (measuredHeight - scrollingTabContainerView.getMeasuredHeight()) - i8, i6, measuredHeight - i8);
        }
        if (this.f412h) {
            Drawable drawable3 = this.f411g;
            if (drawable3 == null) {
                return;
            }
            drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            if (this.f409e != null) {
                if (this.f407c.getVisibility() == 0) {
                    drawable2 = this.f409e;
                    left = this.f407c.getLeft();
                    top = this.f407c.getTop();
                    right = this.f407c.getRight();
                    view = this.f407c;
                } else {
                    View view2 = this.f408d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f409e.setBounds(0, 0, 0, 0);
                    } else {
                        drawable2 = this.f409e;
                        left = this.f408d.getLeft();
                        top = this.f408d.getTop();
                        right = this.f408d.getRight();
                        view = this.f408d;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
            } else {
                z5 = false;
            }
            this.f413i = z6;
            if (z6 && (drawable = this.f410f) != null) {
                drawable.setBounds(scrollingTabContainerView.getLeft(), scrollingTabContainerView.getTop(), scrollingTabContainerView.getRight(), scrollingTabContainerView.getBottom());
            } else if (!z5) {
                return;
            }
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            android.view.View r0 = r4.f407c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            if (r0 != r1) goto L1c
            int r0 = r4.f414j
            if (r0 < 0) goto L1c
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r6 = java.lang.Math.min(r0, r6)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r1)
        L1c:
            super.onMeasure(r5, r6)
            android.view.View r5 = r4.f407c
            if (r5 != 0) goto L24
            return
        L24:
            int r5 = android.view.View.MeasureSpec.getMode(r6)
            androidx.appcompat.widget.ScrollingTabContainerView r0 = r4.f406b
            if (r0 == 0) goto L81
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L81
            r0 = 1073741824(0x40000000, float:2.0)
            if (r5 == r0) goto L81
            android.view.View r0 = r4.f407c
            if (r0 == 0) goto L50
            int r3 = r0.getVisibility()
            if (r3 == r2) goto L50
            int r0 = r0.getMeasuredHeight()
            if (r0 != 0) goto L49
            goto L50
        L49:
            android.view.View r0 = r4.f407c
        L4b:
            int r0 = a(r0)
            goto L65
        L50:
            android.view.View r0 = r4.f408d
            if (r0 == 0) goto L64
            int r3 = r0.getVisibility()
            if (r3 == r2) goto L64
            int r0 = r0.getMeasuredHeight()
            if (r0 != 0) goto L61
            goto L64
        L61:
            android.view.View r0 = r4.f408d
            goto L4b
        L64:
            r0 = 0
        L65:
            if (r5 != r1) goto L6c
            int r5 = android.view.View.MeasureSpec.getSize(r6)
            goto L6f
        L6c:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L6f:
            int r6 = r4.getMeasuredWidth()
            androidx.appcompat.widget.ScrollingTabContainerView r1 = r4.f406b
            int r1 = a(r1)
            int r1 = r1 + r0
            int r5 = java.lang.Math.min(r1, r5)
            r4.setMeasuredDimension(r6, r5)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f409e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f409e);
        }
        this.f409e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f407c;
            if (view != null) {
                this.f409e.setBounds(view.getLeft(), this.f407c.getTop(), this.f407c.getRight(), this.f407c.getBottom());
            }
        }
        boolean z4 = false;
        if (!this.f412h ? !(this.f409e != null || this.f410f != null) : this.f411g == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f411g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f411g);
        }
        this.f411g = drawable;
        boolean z4 = this.f412h;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z4 && (drawable2 = this.f411g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z4 ? !(this.f409e != null || this.f410f != null) : this.f411g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f410f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f410f);
        }
        this.f410f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f413i && (drawable2 = this.f410f) != null) {
                drawable2.setBounds(this.f406b.getLeft(), this.f406b.getTop(), this.f406b.getRight(), this.f406b.getBottom());
            }
        }
        boolean z4 = false;
        if (!this.f412h ? !(this.f409e != null || this.f410f != null) : this.f411g == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f406b;
        if (scrollingTabContainerView2 != null) {
            removeView(scrollingTabContainerView2);
        }
        this.f406b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z4) {
        this.f405a = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f409e;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f410f;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f411g;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f409e;
        boolean z4 = this.f412h;
        return (drawable == drawable2 && !z4) || (drawable == this.f410f && this.f413i) || ((drawable == this.f411g && z4) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVar = new c(this);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.g0.q(this, cVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f2543a);
        boolean z4 = false;
        this.f409e = obtainStyledAttributes.getDrawable(0);
        this.f410f = obtainStyledAttributes.getDrawable(2);
        this.f414j = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f412h = true;
            this.f411g = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f412h ? !(this.f409e != null || this.f410f != null) : this.f411g == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i4) {
        if (i4 != 0) {
            return super.startActionModeForChild(view, callback, i4);
        }
        return null;
    }
}