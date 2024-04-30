package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public boolean f553a;

    /* renamed from: b  reason: collision with root package name */
    public int f554b;

    /* renamed from: c  reason: collision with root package name */
    public int f555c;

    /* renamed from: d  reason: collision with root package name */
    public int f556d;

    /* renamed from: e  reason: collision with root package name */
    public int f557e;

    /* renamed from: f  reason: collision with root package name */
    public int f558f;

    /* renamed from: g  reason: collision with root package name */
    public float f559g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f560h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f561i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f562j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f563k;

    /* renamed from: l  reason: collision with root package name */
    public int f564l;

    /* renamed from: m  reason: collision with root package name */
    public int f565m;

    /* renamed from: n  reason: collision with root package name */
    public int f566n;

    /* renamed from: o  reason: collision with root package name */
    public int f567o;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void f(Canvas canvas, int i4) {
        this.f563k.setBounds(getPaddingLeft() + this.f567o, i4, (getWidth() - getPaddingRight()) - this.f567o, this.f565m + i4);
        this.f563k.draw(canvas);
    }

    public final void g(Canvas canvas, int i4) {
        this.f563k.setBounds(i4, getPaddingTop() + this.f567o, this.f564l + i4, (getHeight() - getPaddingBottom()) - this.f567o);
        this.f563k.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i4;
        if (this.f554b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.f554b;
        if (childCount > i5) {
            View childAt = getChildAt(i5);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f554b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i6 = this.f555c;
            if (this.f556d == 1 && (i4 = this.f557e & 112) != 48) {
                if (i4 == 16) {
                    i6 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f558f) / 2;
                } else if (i4 == 80) {
                    i6 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f558f;
                }
            }
            return i6 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f554b;
    }

    public Drawable getDividerDrawable() {
        return this.f563k;
    }

    public int getDividerPadding() {
        return this.f567o;
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public int getDividerWidth() {
        return this.f564l;
    }

    @GravityInt
    public int getGravity() {
        return this.f557e;
    }

    public int getOrientation() {
        return this.f556d;
    }

    public int getShowDividers() {
        return this.f566n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f559g;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: h */
    public LayoutParams generateDefaultLayoutParams() {
        int i4 = this.f556d;
        if (i4 == 0) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        if (i4 == 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: i */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LinearLayout.LayoutParams(layoutParams);
    }

    public final boolean k(int i4) {
        if (i4 == 0) {
            return (this.f566n & 1) != 0;
        } else if (i4 == getChildCount()) {
            return (this.f566n & 4) != 0;
        } else if ((this.f566n & 2) != 0) {
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                if (getChildAt(i5).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i4;
        int left2;
        int bottom;
        if (this.f563k == null) {
            return;
        }
        int i5 = 0;
        if (this.f556d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i5 < virtualChildCount) {
                View childAt = getChildAt(i5);
                if (childAt != null && childAt.getVisibility() != 8 && k(i5)) {
                    f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.f565m);
                }
                i5++;
            }
            if (k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.f565m;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                }
                f(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean a5 = e4.a(this);
        while (i5 < virtualChildCount2) {
            View childAt3 = getChildAt(i5);
            if (childAt3 != null && childAt3.getVisibility() != 8 && k(i5)) {
                LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (a5) {
                    left2 = childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f564l;
                }
                g(canvas, left2);
            }
            i5++;
        }
        if (k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 == null) {
                if (a5) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth();
                    i4 = getPaddingRight();
                    right = (left - i4) - this.f564l;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                if (a5) {
                    left = childAt4.getLeft();
                    i4 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    right = (left - i4) - this.f564l;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            }
            g(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a2  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x029d, code lost:
        if (r15 > 0) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02a0, code lost:
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02a1, code lost:
        r9.measure(r11, android.view.View.MeasureSpec.makeMeasureSpec(r15, r14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02b1, code lost:
        if (r15 < 0) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02b4, code lost:
        r12 = android.view.View.combineMeasuredStates(r12, r9.getMeasuredState() & (-256));
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02d9, code lost:
        if (((android.widget.LinearLayout.LayoutParams) r13).width == (-1)) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0700, code lost:
        if (r9 > 0) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0703, code lost:
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0704, code lost:
        r15.measure(android.view.View.MeasureSpec.makeMeasureSpec(r9, r7), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0714, code lost:
        if (r9 < 0) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0717, code lost:
        r12 = android.view.View.combineMeasuredStates(r12, r15.getMeasuredState() & (-16777216));
        r1 = r1;
        r7 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:212:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:440:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r38, int r39) {
        /*
            Method dump skipped, instructions count: 2189
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z4) {
        this.f553a = z4;
    }

    public void setBaselineAlignedChildIndex(int i4) {
        if (i4 >= 0 && i4 < getChildCount()) {
            this.f554b = i4;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f563k) {
            return;
        }
        this.f563k = drawable;
        if (drawable != null) {
            this.f564l = drawable.getIntrinsicWidth();
            this.f565m = drawable.getIntrinsicHeight();
        } else {
            this.f564l = 0;
            this.f565m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i4) {
        this.f567o = i4;
    }

    public void setGravity(@GravityInt int i4) {
        if (this.f557e != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f557e = i4;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i4) {
        int i5 = i4 & 8388615;
        int i6 = this.f557e;
        if ((8388615 & i6) != i5) {
            this.f557e = i5 | ((-8388616) & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.f560h = z4;
    }

    public void setOrientation(int i4) {
        if (this.f556d != i4) {
            this.f556d = i4;
            requestLayout();
        }
    }

    public void setShowDividers(int i4) {
        if (i4 != this.f566n) {
            requestLayout();
        }
        this.f566n = i4;
    }

    public void setVerticalGravity(int i4) {
        int i5 = i4 & 112;
        int i6 = this.f557e;
        if ((i6 & 112) != i5) {
            this.f557e = i5 | (i6 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f559g = Math.max(0.0f, f4);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f553a = true;
        this.f554b = -1;
        this.f555c = 0;
        this.f557e = 8388659;
        int[] iArr = c.a.f2558p;
        q3 f4 = q3.f(context, attributeSet, iArr, i4, 0);
        i0.y0.o(this, context, iArr, attributeSet, f4.f879b, i4);
        TypedArray typedArray = f4.f879b;
        int i5 = typedArray.getInt(1, -1);
        if (i5 >= 0) {
            setOrientation(i5);
        }
        int i6 = typedArray.getInt(0, -1);
        if (i6 >= 0) {
            setGravity(i6);
        }
        boolean z4 = typedArray.getBoolean(2, true);
        if (!z4) {
            setBaselineAligned(z4);
        }
        this.f559g = typedArray.getFloat(4, -1.0f);
        this.f554b = typedArray.getInt(3, -1);
        this.f560h = typedArray.getBoolean(7, false);
        setDividerDrawable(f4.b(5));
        this.f566n = typedArray.getInt(8, 0);
        this.f567o = typedArray.getDimensionPixelSize(6, 0);
        f4.g();
    }
}