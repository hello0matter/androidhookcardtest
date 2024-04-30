package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final j3 R = new j3(Float.class, "thumbPos", 0);
    public static final int[] S = {16842912};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public final TextPaint I;
    public ColorStateList J;
    public StaticLayout K;
    public StaticLayout L;
    public e.a M;
    public ObjectAnimator N;
    public d0 O;
    public l3 P;
    public final Rect Q;

    /* renamed from: a  reason: collision with root package name */
    public Drawable f629a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f630b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f631c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f632d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f633e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f634f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f635g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f636h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f637i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f638j;

    /* renamed from: k  reason: collision with root package name */
    public int f639k;

    /* renamed from: l  reason: collision with root package name */
    public int f640l;

    /* renamed from: m  reason: collision with root package name */
    public int f641m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f642n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f643o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f644p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f645q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f646r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f647s;

    /* renamed from: t  reason: collision with root package name */
    public int f648t;

    /* renamed from: u  reason: collision with root package name */
    public final int f649u;

    /* renamed from: v  reason: collision with root package name */
    public float f650v;

    /* renamed from: w  reason: collision with root package name */
    public float f651w;

    /* renamed from: x  reason: collision with root package name */
    public final VelocityTracker f652x;

    /* renamed from: y  reason: collision with root package name */
    public final int f653y;

    /* renamed from: z  reason: collision with root package name */
    public float f654z;

    public SwitchCompat(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private d0 getEmojiTextViewHelper() {
        if (this.O == null) {
            this.O = new d0(this);
        }
        return this.O;
    }

    private boolean getTargetCheckedState() {
        return this.f654z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((e4.a(this) ? 1.0f - this.f654z : this.f654z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f634f;
        if (drawable != null) {
            Rect rect = this.Q;
            drawable.getPadding(rect);
            Drawable drawable2 = this.f629a;
            Rect b5 = drawable2 != null ? o1.b(drawable2) : o1.f859c;
            return ((((this.A - this.C) - rect.left) - rect.right) - b5.left) - b5.right;
        }
        return 0;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f645q = charSequence;
        d0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod t4 = ((l2.f) emojiTextViewHelper.f734b.f311b).t(this.M);
        if (t4 != null) {
            charSequence = t4.getTransformation(charSequence, this);
        }
        this.f646r = charSequence;
        this.L = null;
        if (this.f647s) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f643o = charSequence;
        d0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod t4 = ((l2.f) emojiTextViewHelper.f734b.f311b).t(this.M);
        if (t4 != null) {
            charSequence = t4.getTransformation(charSequence, this);
        }
        this.f644p = charSequence;
        this.K = null;
        if (this.f647s) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f629a;
        if (drawable != null) {
            if (this.f632d || this.f633e) {
                Drawable mutate = drawable.mutate();
                this.f629a = mutate;
                if (this.f632d) {
                    c0.b.h(mutate, this.f630b);
                }
                if (this.f633e) {
                    c0.b.i(this.f629a, this.f631c);
                }
                if (this.f629a.isStateful()) {
                    this.f629a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f634f;
        if (drawable != null) {
            if (this.f637i || this.f638j) {
                Drawable mutate = drawable.mutate();
                this.f634f = mutate;
                if (this.f637i) {
                    c0.b.h(mutate, this.f635g);
                }
                if (this.f638j) {
                    c0.b.i(this.f634f, this.f636h);
                }
                if (this.f634f.isStateful()) {
                    this.f634f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f643o);
        setTextOffInternal(this.f645q);
        requestLayout();
    }

    public final void d() {
        if (this.P == null && ((l2.f) this.O.f734b.f311b).m() && androidx.emoji2.text.o.f1526j != null) {
            androidx.emoji2.text.o a5 = androidx.emoji2.text.o.a();
            int b5 = a5.b();
            if (b5 == 3 || b5 == 0) {
                l3 l3Var = new l3(this);
                this.P = l3Var;
                a5.g(l3Var);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect;
        int i4;
        int i5;
        int i6 = this.D;
        int i7 = this.E;
        int i8 = this.F;
        int i9 = this.G;
        int thumbOffset = getThumbOffset() + i6;
        Drawable drawable = this.f629a;
        if (drawable != null) {
            rect = o1.b(drawable);
        } else {
            rect = o1.f859c;
        }
        Drawable drawable2 = this.f634f;
        Rect rect2 = this.Q;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i10 = rect2.left;
            thumbOffset += i10;
            if (rect != null) {
                int i11 = rect.left;
                if (i11 > i10) {
                    i6 += i11 - i10;
                }
                int i12 = rect.top;
                int i13 = rect2.top;
                if (i12 > i13) {
                    i4 = (i12 - i13) + i7;
                } else {
                    i4 = i7;
                }
                int i14 = rect.right;
                int i15 = rect2.right;
                if (i14 > i15) {
                    i8 -= i14 - i15;
                }
                int i16 = rect.bottom;
                int i17 = rect2.bottom;
                if (i16 > i17) {
                    i5 = i9 - (i16 - i17);
                    this.f634f.setBounds(i6, i4, i8, i5);
                }
            } else {
                i4 = i7;
            }
            i5 = i9;
            this.f634f.setBounds(i6, i4, i8, i5);
        }
        Drawable drawable3 = this.f629a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i18 = thumbOffset - rect2.left;
            int i19 = thumbOffset + this.C + rect2.right;
            this.f629a.setBounds(i18, i7, i19, i9);
            Drawable background = getBackground();
            if (background != null) {
                c0.b.f(background, i18, i7, i19, i9);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f629a;
        if (drawable != null) {
            c0.b.e(drawable, f4, f5);
        }
        Drawable drawable2 = this.f634f;
        if (drawable2 != null) {
            c0.b.e(drawable2, f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f629a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f634f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (e4.a(this)) {
            int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
            return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f641m : compoundPaddingLeft;
        }
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (e4.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f641m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.v.d(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f647s;
    }

    public boolean getSplitTrack() {
        return this.f642n;
    }

    public int getSwitchMinWidth() {
        return this.f640l;
    }

    public int getSwitchPadding() {
        return this.f641m;
    }

    public CharSequence getTextOff() {
        return this.f645q;
    }

    public CharSequence getTextOn() {
        return this.f643o;
    }

    public Drawable getThumbDrawable() {
        return this.f629a;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getThumbPosition() {
        return this.f654z;
    }

    public int getThumbTextPadding() {
        return this.f639k;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f630b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f631c;
    }

    public Drawable getTrackDrawable() {
        return this.f634f;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f635g;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f636h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f629a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f634f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.N.end();
        this.N = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, S);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f634f;
        Rect rect = this.Q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i4 = this.E;
        int i5 = this.G;
        int i6 = i4 + rect.top;
        int i7 = i5 - rect.bottom;
        Drawable drawable2 = this.f629a;
        if (drawable != null) {
            if (!this.f642n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect b5 = o1.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b5.left;
                rect.right -= b5.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.K : this.L;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.J;
            TextPaint textPaint = this.I;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i6 + i7) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f643o : this.f645q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8;
        int width;
        int i9;
        int i10;
        int i11;
        super.onLayout(z4, i4, i5, i6, i7);
        int i12 = 0;
        if (this.f629a != null) {
            Drawable drawable = this.f634f;
            Rect rect = this.Q;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b5 = o1.b(this.f629a);
            i8 = Math.max(0, b5.left - rect.left);
            i12 = Math.max(0, b5.right - rect.right);
        } else {
            i8 = 0;
        }
        if (e4.a(this)) {
            i9 = getPaddingLeft() + i8;
            width = ((this.A + i9) - i8) - i12;
        } else {
            width = (getWidth() - getPaddingRight()) - i12;
            i9 = (width - this.A) + i8 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = getPaddingTop();
            int i13 = this.B;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i13 / 2);
            i10 = i13 + height;
            i11 = height;
        } else if (gravity != 80) {
            i11 = getPaddingTop();
            i10 = this.B + i11;
        } else {
            i10 = getHeight() - getPaddingBottom();
            i11 = i10 - this.B;
        }
        this.D = i9;
        this.E = i11;
        this.G = i10;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        if (this.f647s) {
            StaticLayout staticLayout = this.K;
            TextPaint textPaint = this.I;
            if (staticLayout == null) {
                CharSequence charSequence = this.f644p;
                if (charSequence != null) {
                    i11 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
                } else {
                    i11 = 0;
                }
                this.K = new StaticLayout(charSequence, textPaint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.L == null) {
                CharSequence charSequence2 = this.f646r;
                if (charSequence2 != null) {
                    i10 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
                } else {
                    i10 = 0;
                }
                this.L = new StaticLayout(charSequence2, textPaint, i10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f629a;
        Rect rect = this.Q;
        if (drawable != null) {
            drawable.getPadding(rect);
            i6 = (this.f629a.getIntrinsicWidth() - rect.left) - rect.right;
            i7 = this.f629a.getIntrinsicHeight();
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (this.f647s) {
            i8 = (this.f639k * 2) + Math.max(this.K.getWidth(), this.L.getWidth());
        } else {
            i8 = 0;
        }
        this.C = Math.max(i8, i6);
        Drawable drawable2 = this.f634f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i12 = this.f634f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i13 = rect.left;
        int i14 = rect.right;
        Drawable drawable3 = this.f629a;
        if (drawable3 != null) {
            Rect b5 = o1.b(drawable3);
            i13 = Math.max(i13, b5.left);
            i14 = Math.max(i14, b5.right);
        }
        if (this.H) {
            i9 = Math.max(this.f640l, (this.C * 2) + i13 + i14);
        } else {
            i9 = this.f640l;
        }
        int max = Math.max(i12, i7);
        this.A = i9;
        this.B = max;
        super.onMeasure(i4, i5);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f643o : this.f645q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r1 != 3) goto L7;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        super.setChecked(z4);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f643o;
                if (obj == null) {
                    obj = getResources().getString(R.string.abc_capital_on);
                }
                WeakHashMap weakHashMap = i0.y0.f4999a;
                new i0.c0(R.id.tag_state_description, 64, 30, 2).b(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj2 = this.f645q;
            if (obj2 == null) {
                obj2 = getResources().getString(R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap2 = i0.y0.f4999a;
            new i0.c0(R.id.tag_state_description, 64, 30, 2).b(this, obj2);
        }
        float f4 = 0.0f;
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = i0.y0.f4999a;
            if (i0.j0.c(this)) {
                if (isChecked) {
                    f4 = 1.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, R, f4);
                this.N = ofFloat;
                ofFloat.setDuration(250L);
                k3.a(this.N, true);
                this.N.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (isChecked) {
            f4 = 1.0f;
        }
        setThumbPosition(f4);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
        setTextOnInternal(this.f643o);
        setTextOffInternal(this.f645q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z4) {
        this.H = z4;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z4) {
        if (this.f647s != z4) {
            this.f647s = z4;
            requestLayout();
            if (z4) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z4) {
        this.f642n = z4;
        invalidate();
    }

    public void setSwitchMinWidth(int i4) {
        this.f640l = i4;
        requestLayout();
    }

    public void setSwitchPadding(int i4) {
        this.f641m = i4;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [e.a, java.lang.Object] */
    public void setSwitchTextAppearance(Context context, int i4) {
        ColorStateList colorStateList;
        Typeface typeface;
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, c.a.f2568z);
        if (!obtainStyledAttributes.hasValue(3) || (resourceId = obtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = z.e.b(context, resourceId)) == null) {
            colorStateList = obtainStyledAttributes.getColorStateList(3);
        }
        if (colorStateList == null) {
            colorStateList = getTextColors();
        }
        this.J = colorStateList;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        if (dimensionPixelSize != 0) {
            float f4 = dimensionPixelSize;
            TextPaint textPaint = this.I;
            if (f4 != textPaint.getTextSize()) {
                textPaint.setTextSize(f4);
                requestLayout();
            }
        }
        int i5 = obtainStyledAttributes.getInt(1, -1);
        int i6 = obtainStyledAttributes.getInt(2, -1);
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        setSwitchTypeface(typeface, i6);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            Context context2 = getContext();
            ?? obj = new Object();
            obj.f4421a = context2.getResources().getConfiguration().locale;
            this.M = obj;
        } else {
            this.M = null;
        }
        setTextOnInternal(this.f643o);
        setTextOffInternal(this.f645q);
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.I;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f645q;
            if (obj == null) {
                obj = getResources().getString(R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap = i0.y0.f4999a;
            new i0.c0(R.id.tag_state_description, 64, 30, 2).b(this, obj);
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f643o;
            if (obj == null) {
                obj = getResources().getString(R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = i0.y0.f4999a;
            new i0.c0(R.id.tag_state_description, 64, 30, 2).b(this, obj);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f629a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f629a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.f654z = f4;
        invalidate();
    }

    public void setThumbResource(int i4) {
        setThumbDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setThumbTextPadding(int i4) {
        this.f639k = i4;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f630b = colorStateList;
        this.f632d = true;
        a();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f631c = mode;
        this.f633e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f634f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f634f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i4) {
        setTrackDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f635g = colorStateList;
        this.f637i = true;
        b();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f636h = mode;
        this.f638j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f629a || drawable == this.f634f;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public void setSwitchTypeface(Typeface typeface, int i4) {
        TextPaint textPaint = this.I;
        if (i4 <= 0) {
            textPaint.setFakeBoldText(false);
            textPaint.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
            return;
        }
        Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i4) : Typeface.create(typeface, i4);
        setSwitchTypeface(defaultFromStyle);
        int i5 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i4;
        textPaint.setFakeBoldText((i5 & 1) != 0);
        textPaint.setTextSkewX((i5 & 2) != 0 ? -0.25f : 0.0f);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f630b = null;
        this.f631c = null;
        this.f632d = false;
        this.f633e = false;
        this.f635g = null;
        this.f636h = null;
        this.f637i = false;
        this.f638j = false;
        this.f652x = VelocityTracker.obtain();
        this.H = true;
        this.Q = new Rect();
        m3.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = c.a.f2567y;
        q3 f4 = q3.f(context, attributeSet, iArr, i4, 0);
        i0.y0.o(this, context, iArr, attributeSet, f4.f879b, i4);
        Drawable b5 = f4.b(2);
        this.f629a = b5;
        if (b5 != null) {
            b5.setCallback(this);
        }
        Drawable b6 = f4.b(11);
        this.f634f = b6;
        if (b6 != null) {
            b6.setCallback(this);
        }
        TypedArray typedArray = f4.f879b;
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f647s = typedArray.getBoolean(3, true);
        this.f639k = typedArray.getDimensionPixelSize(8, 0);
        this.f640l = typedArray.getDimensionPixelSize(5, 0);
        this.f641m = typedArray.getDimensionPixelSize(6, 0);
        this.f642n = typedArray.getBoolean(4, false);
        ColorStateList a5 = f4.a(9);
        if (a5 != null) {
            this.f630b = a5;
            this.f632d = true;
        }
        PorterDuff.Mode c4 = o1.c(typedArray.getInt(10, -1), null);
        if (this.f631c != c4) {
            this.f631c = c4;
            this.f633e = true;
        }
        if (this.f632d || this.f633e) {
            a();
        }
        ColorStateList a6 = f4.a(12);
        if (a6 != null) {
            this.f635g = a6;
            this.f637i = true;
        }
        PorterDuff.Mode c5 = o1.c(typedArray.getInt(13, -1), null);
        if (this.f636h != c5) {
            this.f636h = c5;
            this.f638j = true;
        }
        if (this.f637i || this.f638j) {
            b();
        }
        int resourceId = typedArray.getResourceId(7, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        new y0(this).f(attributeSet, i4);
        f4.g();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f649u = viewConfiguration.getScaledTouchSlop();
        this.f653y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, i4);
        refreshDrawableState();
        setChecked(isChecked());
    }
}