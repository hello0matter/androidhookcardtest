package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.i0;
import c0.c;
import com.example.msphone.R;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;
import g0.l;
import g0.m;
import i0.g0;
import i0.h0;
import i0.y0;
import i2.g;
import j2.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import l2.a0;
import l2.p;
import w1.b;
import w1.d;
import w1.e;
import w1.f;

/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements e, a0, i {

    /* renamed from: x  reason: collision with root package name */
    public static final Rect f3212x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f3213y = {16842913};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f3214z = {16842911};

    /* renamed from: e  reason: collision with root package name */
    public f f3215e;

    /* renamed from: f  reason: collision with root package name */
    public InsetDrawable f3216f;

    /* renamed from: g  reason: collision with root package name */
    public RippleDrawable f3217g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f3218h;

    /* renamed from: i  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f3219i;

    /* renamed from: j  reason: collision with root package name */
    public h f3220j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3221k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3222l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3223m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3224n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3225o;

    /* renamed from: p  reason: collision with root package name */
    public int f3226p;

    /* renamed from: q  reason: collision with root package name */
    public int f3227q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f3228r;

    /* renamed from: s  reason: collision with root package name */
    public final d f3229s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3230t;

    /* renamed from: u  reason: collision with root package name */
    public final Rect f3231u;

    /* renamed from: v  reason: collision with root package name */
    public final RectF f3232v;

    /* renamed from: w  reason: collision with root package name */
    public final b f3233w;

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f3232v;
        rectF.setEmpty();
        if (d() && this.f3218h != null) {
            f fVar = this.f3215e;
            Rect bounds = fVar.getBounds();
            rectF.setEmpty();
            if (fVar.d0()) {
                float f4 = fVar.f7029d0 + fVar.f7028c0 + fVar.O + fVar.f7027b0 + fVar.f7026a0;
                if (c.a(fVar) == 0) {
                    float f5 = bounds.right;
                    rectF.right = f5;
                    rectF.left = f5 - f4;
                } else {
                    float f6 = bounds.left;
                    rectF.left = f6;
                    rectF.right = f6 + f4;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        Rect rect = this.f3231u;
        rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return rect;
    }

    @Nullable
    private g getTextAppearance() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7036k0.f3540g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z4) {
        if (this.f3223m != z4) {
            this.f3223m = z4;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z4) {
        if (this.f3222l != z4) {
            this.f3222l = z4;
            refreshDrawableState();
        }
    }

    public final void c(int i4) {
        int i5;
        this.f3227q = i4;
        int i6 = 0;
        if (!this.f3225o) {
            InsetDrawable insetDrawable = this.f3216f;
            if (insetDrawable != null) {
                if (insetDrawable != null) {
                    this.f3216f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr = a.f5097a;
                    g();
                    return;
                }
                return;
            }
            int[] iArr2 = a.f5097a;
            g();
            return;
        }
        int max = Math.max(0, i4 - ((int) this.f3215e.f7053z));
        int max2 = Math.max(0, i4 - this.f3215e.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.f3216f;
            if (insetDrawable2 != null) {
                if (insetDrawable2 != null) {
                    this.f3216f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr3 = a.f5097a;
                    g();
                    return;
                }
                return;
            }
            int[] iArr4 = a.f5097a;
            g();
            return;
        }
        if (max2 > 0) {
            i5 = max2 / 2;
        } else {
            i5 = 0;
        }
        if (max > 0) {
            i6 = max / 2;
        }
        int i7 = i6;
        if (this.f3216f != null) {
            Rect rect = new Rect();
            this.f3216f.getPadding(rect);
            if (rect.top == i7 && rect.bottom == i7 && rect.left == i5 && rect.right == i5) {
                int[] iArr5 = a.f5097a;
                g();
                return;
            }
        }
        if (getMinHeight() != i4) {
            setMinHeight(i4);
        }
        if (getMinWidth() != i4) {
            setMinWidth(i4);
        }
        this.f3216f = new InsetDrawable((Drawable) this.f3215e, i5, i7, i5, i7);
        int[] iArr6 = a.f5097a;
        g();
    }

    public final boolean d() {
        Drawable drawable;
        f fVar = this.f3215e;
        if (fVar != null) {
            Drawable drawable2 = fVar.L;
            if (drawable2 != null) {
                drawable = com.google.common.collect.c.e2(drawable2);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f3230t ? super.dispatchHoverEvent(motionEvent) : this.f3229s.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
        if (r7 == false) goto L48;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f3230t
            if (r0 != 0) goto L9
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L9:
            w1.d r0 = r9.f3229s
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 1
            if (r1 == r2) goto L89
            int r1 = r10.getKeyCode()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 61
            r5 = 0
            if (r1 == r4) goto L6c
            r4 = 66
            if (r1 == r4) goto L55
            switch(r1) {
                case 19: goto L28;
                case 20: goto L28;
                case 21: goto L28;
                case 22: goto L28;
                case 23: goto L55;
                default: goto L27;
            }
        L27:
            goto L89
        L28:
            boolean r6 = r10.hasNoModifiers()
            if (r6 == 0) goto L89
            r6 = 19
            if (r1 == r6) goto L40
            r6 = 21
            if (r1 == r6) goto L3d
            r6 = 22
            if (r1 == r6) goto L42
            r4 = 130(0x82, float:1.82E-43)
            goto L42
        L3d:
            r4 = 17
            goto L42
        L40:
            r4 = 33
        L42:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r2
            r6 = 0
            r7 = r6
        L49:
            if (r6 >= r1) goto L82
            boolean r8 = r0.q(r4, r5)
            if (r8 == 0) goto L82
            int r6 = r6 + 1
            r7 = r2
            goto L49
        L55:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L89
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L89
            int r1 = r0.f5708l
            if (r1 == r3) goto L84
            r4 = 16
            boolean r1 = r0.s(r1, r4, r5)
            goto L84
        L6c:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L78
            r1 = 2
            boolean r7 = r0.q(r1, r5)
            goto L82
        L78:
            boolean r1 = r10.hasModifiers(r2)
            if (r1 == 0) goto L89
            boolean r7 = r0.q(r2, r5)
        L82:
            if (r7 == 0) goto L89
        L84:
            int r0 = r0.f5708l
            if (r0 == r3) goto L89
            return r2
        L89:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, boolean] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f3215e;
        if (fVar != null && f.E(fVar.L)) {
            f fVar2 = this.f3215e;
            ?? isEnabled = isEnabled();
            int i4 = isEnabled;
            if (this.f3224n) {
                i4 = isEnabled + 1;
            }
            int i5 = i4;
            if (this.f3223m) {
                i5 = i4 + 1;
            }
            int i6 = i5;
            if (this.f3222l) {
                i6 = i5 + 1;
            }
            int i7 = i6;
            if (isChecked()) {
                i7 = i6 + 1;
            }
            int[] iArr = new int[i7];
            int i8 = 0;
            if (isEnabled()) {
                iArr[0] = 16842910;
                i8 = 1;
            }
            if (this.f3224n) {
                iArr[i8] = 16842908;
                i8++;
            }
            if (this.f3223m) {
                iArr[i8] = 16843623;
                i8++;
            }
            if (this.f3222l) {
                iArr[i8] = 16842919;
                i8++;
            }
            if (isChecked()) {
                iArr[i8] = 16842913;
            }
            if (!Arrays.equals(fVar2.f7052y0, iArr)) {
                fVar2.f7052y0 = iArr;
                if (fVar2.d0() && fVar2.G(fVar2.getState(), iArr)) {
                    invalidate();
                }
            }
        }
    }

    public final boolean e() {
        f fVar = this.f3215e;
        if (fVar != null && fVar.Q) {
            return true;
        }
        return false;
    }

    public final void f() {
        boolean z4;
        f fVar;
        if (d() && (fVar = this.f3215e) != null && fVar.K && this.f3218h != null) {
            y0.p(this, this.f3229s);
            z4 = true;
        } else {
            y0.p(this, null);
            z4 = false;
        }
        this.f3230t = z4;
    }

    public final void g() {
        this.f3217g = new RippleDrawable(a.c(this.f3215e.D), getBackgroundDrawable(), null);
        f fVar = this.f3215e;
        if (fVar.f7054z0) {
            fVar.f7054z0 = false;
            fVar.A0 = null;
            fVar.onStateChange(fVar.getState());
        }
        RippleDrawable rippleDrawable = this.f3217g;
        WeakHashMap weakHashMap = y0.f4999a;
        g0.q(this, rippleDrawable);
        h();
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f3228r)) {
            return this.f3228r;
        }
        if (e()) {
            ViewParent parent = getParent();
            if (!(parent instanceof ChipGroup) || !((ChipGroup) parent).f3237h.f3472d) {
                return "android.widget.Button";
            }
            return "android.widget.RadioButton";
        } else if (isClickable()) {
            return "android.widget.Button";
        } else {
            return "android.view.View";
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f3216f;
        return insetDrawable == null ? this.f3215e : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.S;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.T;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7051y;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return Math.max(0.0f, fVar.C());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f3215e;
    }

    public float getChipEndPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7029d0;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        f fVar = this.f3215e;
        if (fVar == null || (drawable = fVar.G) == null) {
            return null;
        }
        return com.google.common.collect.c.e2(drawable);
    }

    public float getChipIconSize() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.I;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.H;
        }
        return null;
    }

    public float getChipMinHeight() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7053z;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.W;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.B;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.C;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable;
        f fVar = this.f3215e;
        if (fVar == null || (drawable = fVar.L) == null) {
            return null;
        }
        return com.google.common.collect.c.e2(drawable);
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.P;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7028c0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.O;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7027b0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.N;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.C0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f3230t) {
            d dVar = this.f3229s;
            if (dVar.f5708l == 1 || dVar.f5707k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    @Nullable
    public p1.f getHideMotionSpec() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.V;
        }
        return null;
    }

    public float getIconEndPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.Y;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.X;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.D;
        }
        return null;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        return this.f3215e.f5310a.f5288a;
    }

    @Nullable
    public p1.f getShowMotionSpec() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.U;
        }
        return null;
    }

    public float getTextEndPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.f7026a0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f fVar = this.f3215e;
        if (fVar != null) {
            return fVar.Z;
        }
        return 0.0f;
    }

    public final void h() {
        f fVar;
        if (!TextUtils.isEmpty(getText()) && (fVar = this.f3215e) != null) {
            int B = (int) (fVar.B() + fVar.f7029d0 + fVar.f7026a0);
            f fVar2 = this.f3215e;
            int A = (int) (fVar2.A() + fVar2.W + fVar2.Z);
            if (this.f3216f != null) {
                Rect rect = new Rect();
                this.f3216f.getPadding(rect);
                A += rect.left;
                B += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            WeakHashMap weakHashMap = y0.f4999a;
            h0.k(this, A, paddingTop, B, paddingBottom);
        }
    }

    public final void i() {
        TextPaint paint = getPaint();
        f fVar = this.f3215e;
        if (fVar != null) {
            paint.drawableState = fVar.getState();
        }
        g textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.f3233w);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.R1(this, this.f3215e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f3213y);
        }
        if (e()) {
            View.mergeDrawableStates(onCreateDrawableState, f3214z);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        if (this.f3230t) {
            d dVar = this.f3229s;
            int i5 = dVar.f5708l;
            if (i5 != Integer.MIN_VALUE) {
                dVar.j(i5);
            }
            if (z4) {
                dVar.q(i4, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i4;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            int i5 = -1;
            if (chipGroup.f3447c) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    if (i6 < chipGroup.getChildCount()) {
                        View childAt = chipGroup.getChildAt(i6);
                        if ((childAt instanceof Chip) && chipGroup.getChildAt(i6).getVisibility() == 0) {
                            if (((Chip) childAt) == this) {
                                break;
                            }
                            i7++;
                        }
                        i6++;
                    } else {
                        i7 = -1;
                        break;
                    }
                }
                i4 = i7;
            } else {
                i4 = -1;
            }
            Object tag = getTag(R.id.row_index_key);
            if (tag instanceof Integer) {
                i5 = ((Integer) tag).intValue();
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) i0.i(i5, 1, i4, 1, false, isChecked()).f2125a);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i4) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        if (this.f3226p != i4) {
            this.f3226p = i4;
            h();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r0 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4b
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L44
            goto L51
        L21:
            boolean r0 = r5.f3222l
            if (r0 == 0) goto L51
            if (r1 != 0) goto L57
            r5.setCloseIconPressed(r2)
            goto L57
        L2b:
            boolean r0 = r5.f3222l
            if (r0 == 0) goto L44
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f3218h
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            boolean r0 = r5.f3230t
            if (r0 == 0) goto L42
            w1.d r0 = r5.f3229s
            r0.x(r3, r3)
        L42:
            r0 = r3
            goto L45
        L44:
            r0 = r2
        L45:
            r5.setCloseIconPressed(r2)
            if (r0 != 0) goto L57
            goto L51
        L4b:
            if (r1 == 0) goto L51
            r5.setCloseIconPressed(r3)
            goto L57
        L51:
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L58
        L57:
            r2 = r3
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.f3228r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f3217g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f3217g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i4) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.H(z4);
        }
    }

    public void setCheckableResource(@BoolRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.H(fVar.f7030e0.getResources().getBoolean(i4));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        f fVar = this.f3215e;
        if (fVar == null) {
            this.f3221k = z4;
        } else if (fVar.Q) {
            super.setChecked(z4);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.I(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z4) {
        setCheckedIconVisible(z4);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i4) {
        setCheckedIconVisible(i4);
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.I(com.google.common.collect.c.t0(fVar.f7030e0, i4));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.J(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.J(z.e.b(fVar.f7030e0, i4));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.K(fVar.f7030e0.getResources().getBoolean(i4));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        f fVar = this.f3215e;
        if (fVar != null && fVar.f7051y != colorStateList) {
            fVar.f7051y = colorStateList;
            fVar.onStateChange(fVar.getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i4) {
        ColorStateList b5;
        f fVar = this.f3215e;
        if (fVar != null && fVar.f7051y != (b5 = z.e.b(fVar.f7030e0, i4))) {
            fVar.f7051y = b5;
            fVar.onStateChange(fVar.getState());
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.L(f4);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.L(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    public void setChipDrawable(@NonNull f fVar) {
        f fVar2 = this.f3215e;
        if (fVar2 != fVar) {
            if (fVar2 != null) {
                fVar2.B0 = new WeakReference(null);
            }
            this.f3215e = fVar;
            fVar.D0 = false;
            fVar.B0 = new WeakReference(this);
            c(this.f3227q);
        }
    }

    public void setChipEndPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null && fVar.f7029d0 != f4) {
            fVar.f7029d0 = f4;
            fVar.invalidateSelf();
            fVar.F();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            float dimension = fVar.f7030e0.getResources().getDimension(i4);
            if (fVar.f7029d0 != dimension) {
                fVar.f7029d0 = dimension;
                fVar.invalidateSelf();
                fVar.F();
            }
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.M(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z4) {
        setChipIconVisible(z4);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i4) {
        setChipIconVisible(i4);
    }

    public void setChipIconResource(@DrawableRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.M(com.google.common.collect.c.t0(fVar.f7030e0, i4));
        }
    }

    public void setChipIconSize(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.N(f4);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.N(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.O(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.O(z.e.b(fVar.f7030e0, i4));
        }
    }

    public void setChipIconVisible(@BoolRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.P(fVar.f7030e0.getResources().getBoolean(i4));
        }
    }

    public void setChipMinHeight(float f4) {
        f fVar = this.f3215e;
        if (fVar != null && fVar.f7053z != f4) {
            fVar.f7053z = f4;
            fVar.invalidateSelf();
            fVar.F();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            float dimension = fVar.f7030e0.getResources().getDimension(i4);
            if (fVar.f7053z != dimension) {
                fVar.f7053z = dimension;
                fVar.invalidateSelf();
                fVar.F();
            }
        }
    }

    public void setChipStartPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null && fVar.W != f4) {
            fVar.W = f4;
            fVar.invalidateSelf();
            fVar.F();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            float dimension = fVar.f7030e0.getResources().getDimension(i4);
            if (fVar.W != dimension) {
                fVar.W = dimension;
                fVar.invalidateSelf();
                fVar.F();
            }
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.Q(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.Q(z.e.b(fVar.f7030e0, i4));
        }
    }

    public void setChipStrokeWidth(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.R(f4);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.R(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i4) {
        setText(getResources().getString(i4));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.S(drawable);
        }
        f();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        g0.c cVar;
        f fVar = this.f3215e;
        if (fVar != null && fVar.P != charSequence) {
            String str = g0.c.f4768d;
            Locale locale = Locale.getDefault();
            int i4 = m.f4786a;
            if (l.a(locale) == 1) {
                cVar = g0.c.f4771g;
            } else {
                cVar = g0.c.f4770f;
            }
            fVar.P = cVar.c(charSequence, cVar.f4774c);
            fVar.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z4) {
        setCloseIconVisible(z4);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i4) {
        setCloseIconVisible(i4);
    }

    public void setCloseIconEndPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.T(f4);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.T(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    public void setCloseIconResource(@DrawableRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.S(com.google.common.collect.c.t0(fVar.f7030e0, i4));
        }
        f();
    }

    public void setCloseIconSize(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.U(f4);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.U(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    public void setCloseIconStartPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.V(f4);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.V(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.W(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.W(z.e.b(fVar.f7030e0, i4));
        }
    }

    public void setCloseIconVisible(@BoolRes int i4) {
        setCloseIconVisible(getResources().getBoolean(i4));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.n(f4);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f3215e == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            f fVar = this.f3215e;
            if (fVar != null) {
                fVar.C0 = truncateAt;
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z4) {
        this.f3225o = z4;
        c(this.f3227q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i4) {
        if (i4 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i4);
        }
    }

    public void setHideMotionSpec(@Nullable p1.f fVar) {
        f fVar2 = this.f3215e;
        if (fVar2 != null) {
            fVar2.V = fVar;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.V = p1.f.b(fVar.f7030e0, i4);
        }
    }

    public void setIconEndPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.Y(f4);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.Y(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    public void setIconStartPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.Z(f4);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.Z(fVar.f7030e0.getResources().getDimension(i4));
        }
    }

    @Override // com.google.android.material.internal.i
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setInternalOnCheckedChangeListener(@Nullable h hVar) {
        this.f3220j = hVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i4) {
        if (this.f3215e == null) {
            return;
        }
        super.setLayoutDirection(i4);
    }

    @Override // android.widget.TextView
    public void setLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i4);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i4);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i4) {
        super.setMaxWidth(i4);
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.E0 = i4;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i4);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3219i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f3218h = onClickListener;
        f();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.a0(colorStateList);
        }
        if (!this.f3215e.f7054z0) {
            g();
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.a0(z.e.b(fVar.f7030e0, i4));
            if (!this.f3215e.f7054z0) {
                g();
            }
        }
    }

    @Override // l2.a0
    public void setShapeAppearanceModel(@NonNull p pVar) {
        this.f3215e.setShapeAppearanceModel(pVar);
    }

    public void setShowMotionSpec(@Nullable p1.f fVar) {
        f fVar2 = this.f3215e;
        if (fVar2 != null) {
            fVar2.U = fVar;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.U = p1.f.b(fVar.f7030e0, i4);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z4) {
        if (!z4) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z4);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        f fVar = this.f3215e;
        if (fVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (fVar.D0) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        f fVar2 = this.f3215e;
        if (fVar2 != null && !TextUtils.equals(fVar2.E, charSequence)) {
            fVar2.E = charSequence;
            fVar2.f7036k0.f3538e = true;
            fVar2.invalidateSelf();
            fVar2.F();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i4) {
        super.setTextAppearance(i4);
        f fVar = this.f3215e;
        if (fVar != null) {
            Context context = fVar.f7030e0;
            fVar.f7036k0.c(new g(context, i4), context);
        }
        i();
    }

    public void setTextAppearanceResource(@StyleRes int i4) {
        setTextAppearance(getContext(), i4);
    }

    public void setTextEndPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null && fVar.f7026a0 != f4) {
            fVar.f7026a0 = f4;
            fVar.invalidateSelf();
            fVar.F();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            float dimension = fVar.f7030e0.getResources().getDimension(i4);
            if (fVar.f7026a0 != dimension) {
                fVar.f7026a0 = dimension;
                fVar.invalidateSelf();
                fVar.F();
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i4, float f4) {
        super.setTextSize(i4, f4);
        f fVar = this.f3215e;
        if (fVar != null) {
            float applyDimension = TypedValue.applyDimension(i4, f4, getResources().getDisplayMetrics());
            d0 d0Var = fVar.f7036k0;
            g gVar = d0Var.f3540g;
            if (gVar != null) {
                gVar.f5060k = applyDimension;
                d0Var.f3534a.setTextSize(applyDimension);
                fVar.a();
            }
        }
        i();
    }

    public void setTextStartPadding(float f4) {
        f fVar = this.f3215e;
        if (fVar != null && fVar.Z != f4) {
            fVar.Z = f4;
            fVar.invalidateSelf();
            fVar.F();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            float dimension = fVar.f7030e0.getResources().getDimension(i4);
            if (fVar.Z != dimension) {
                fVar.Z = dimension;
                fVar.invalidateSelf();
                fVar.F();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.X(z4);
        }
        f();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Chip(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 938
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.K(z4);
        }
    }

    public void setChipIconVisible(boolean z4) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.P(z4);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        f fVar = this.f3215e;
        if (fVar != null) {
            Context context2 = fVar.f7030e0;
            fVar.f7036k0.c(new g(context2, i4), context2);
        }
        i();
    }

    public void setTextAppearance(@Nullable g gVar) {
        f fVar = this.f3215e;
        if (fVar != null) {
            fVar.f7036k0.c(gVar, fVar.f7030e0);
        }
        i();
    }
}