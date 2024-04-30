package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.q3;
import androidx.appcompat.widget.s2;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.Visibility;
import c1.i0;
import com.example.msphone.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.n0;
import i0.g0;
import i0.j0;
import i0.p0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int[][] A0 = {new int[]{16842919}, new int[0]};
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public CharSequence D;
    public boolean E;
    public l2.j F;
    public l2.j G;
    public StateListDrawable H;
    public boolean I;
    public l2.j J;
    public l2.j K;
    public l2.p L;
    public boolean M;
    public final int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public final Rect V;
    public final Rect W;

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f3960a;

    /* renamed from: a0  reason: collision with root package name */
    public final RectF f3961a0;

    /* renamed from: b  reason: collision with root package name */
    public final r f3962b;

    /* renamed from: b0  reason: collision with root package name */
    public Typeface f3963b0;

    /* renamed from: c  reason: collision with root package name */
    public final l f3964c;

    /* renamed from: c0  reason: collision with root package name */
    public ColorDrawable f3965c0;

    /* renamed from: d  reason: collision with root package name */
    public EditText f3966d;

    /* renamed from: d0  reason: collision with root package name */
    public int f3967d0;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f3968e;

    /* renamed from: e0  reason: collision with root package name */
    public final LinkedHashSet f3969e0;

    /* renamed from: f  reason: collision with root package name */
    public int f3970f;

    /* renamed from: f0  reason: collision with root package name */
    public ColorDrawable f3971f0;

    /* renamed from: g  reason: collision with root package name */
    public int f3972g;

    /* renamed from: g0  reason: collision with root package name */
    public int f3973g0;

    /* renamed from: h  reason: collision with root package name */
    public int f3974h;

    /* renamed from: h0  reason: collision with root package name */
    public Drawable f3975h0;

    /* renamed from: i  reason: collision with root package name */
    public int f3976i;

    /* renamed from: i0  reason: collision with root package name */
    public ColorStateList f3977i0;

    /* renamed from: j  reason: collision with root package name */
    public final o f3978j;

    /* renamed from: j0  reason: collision with root package name */
    public ColorStateList f3979j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3980k;

    /* renamed from: k0  reason: collision with root package name */
    public int f3981k0;

    /* renamed from: l  reason: collision with root package name */
    public int f3982l;

    /* renamed from: l0  reason: collision with root package name */
    public int f3983l0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3984m;

    /* renamed from: m0  reason: collision with root package name */
    public int f3985m0;

    /* renamed from: n  reason: collision with root package name */
    public u f3986n;

    /* renamed from: n0  reason: collision with root package name */
    public ColorStateList f3987n0;

    /* renamed from: o  reason: collision with root package name */
    public AppCompatTextView f3988o;

    /* renamed from: o0  reason: collision with root package name */
    public int f3989o0;

    /* renamed from: p  reason: collision with root package name */
    public int f3990p;

    /* renamed from: p0  reason: collision with root package name */
    public int f3991p0;

    /* renamed from: q  reason: collision with root package name */
    public int f3992q;

    /* renamed from: q0  reason: collision with root package name */
    public int f3993q0;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f3994r;

    /* renamed from: r0  reason: collision with root package name */
    public int f3995r0;

    /* renamed from: s  reason: collision with root package name */
    public boolean f3996s;

    /* renamed from: s0  reason: collision with root package name */
    public int f3997s0;

    /* renamed from: t  reason: collision with root package name */
    public AppCompatTextView f3998t;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f3999t0;

    /* renamed from: u  reason: collision with root package name */
    public ColorStateList f4000u;

    /* renamed from: u0  reason: collision with root package name */
    public final com.google.android.material.internal.d f4001u0;

    /* renamed from: v  reason: collision with root package name */
    public int f4002v;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f4003v0;

    /* renamed from: w  reason: collision with root package name */
    public Fade f4004w;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f4005w0;

    /* renamed from: x  reason: collision with root package name */
    public Fade f4006x;

    /* renamed from: x0  reason: collision with root package name */
    public ValueAnimator f4007x0;

    /* renamed from: y  reason: collision with root package name */
    public ColorStateList f4008y;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f4009y0;

    /* renamed from: z  reason: collision with root package name */
    public ColorStateList f4010z;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f4011z0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface EndIconMode {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f4012c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4013d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4012c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f4013d = parcel.readInt() == 1;
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f4012c) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            TextUtils.writeToParcel(this.f4012c, parcel, i4);
            parcel.writeInt(this.f4013d ? 1 : 0);
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        int i4;
        EditText editText = this.f3966d;
        if ((editText instanceof AutoCompleteTextView) && !com.google.common.collect.c.X0(editText)) {
            int b5 = y1.a.b(R.attr.colorControlHighlight, this.f3966d);
            int i5 = this.O;
            int[][] iArr = A0;
            if (i5 == 2) {
                Context context = getContext();
                l2.j jVar = this.F;
                TypedValue c4 = i2.c.c(R.attr.colorSurface, context, "TextInputLayout");
                int i6 = c4.resourceId;
                if (i6 != 0) {
                    Object obj = z.e.f7215a;
                    i4 = z.d.a(context, i6);
                } else {
                    i4 = c4.data;
                }
                l2.j jVar2 = new l2.j(jVar.f5310a.f5288a);
                int e4 = y1.a.e(b5, 0.1f, i4);
                jVar2.o(new ColorStateList(iArr, new int[]{e4, 0}));
                jVar2.setTint(i4);
                ColorStateList colorStateList = new ColorStateList(iArr, new int[]{e4, i4});
                l2.j jVar3 = new l2.j(jVar.f5310a.f5288a);
                jVar3.setTint(-1);
                return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar2, jVar3), jVar});
            } else if (i5 == 1) {
                l2.j jVar4 = this.F;
                int i7 = this.U;
                return new RippleDrawable(new ColorStateList(iArr, new int[]{y1.a.e(b5, 0.1f, i7), i7}), jVar4, jVar4);
            } else {
                return null;
            }
        }
        return this.F;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.H == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.H = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.H.addState(new int[0], f(false));
        }
        return this.H;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.G == null) {
            this.G = f(true);
        }
        return this.G;
    }

    public static void k(ViewGroup viewGroup, boolean z4) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            childAt.setEnabled(z4);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z4);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3966d == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f3966d = editText;
            int i4 = this.f3970f;
            if (i4 != -1) {
                setMinEms(i4);
            } else {
                setMinWidth(this.f3974h);
            }
            int i5 = this.f3972g;
            if (i5 != -1) {
                setMaxEms(i5);
            } else {
                setMaxWidth(this.f3976i);
            }
            this.I = false;
            i();
            setTextInputAccessibilityDelegate(new t(this));
            Typeface typeface = this.f3966d.getTypeface();
            com.google.android.material.internal.d dVar = this.f4001u0;
            boolean m4 = dVar.m(typeface);
            boolean o4 = dVar.o(typeface);
            if (m4 || o4) {
                dVar.i(false);
            }
            float textSize = this.f3966d.getTextSize();
            if (dVar.f3513l != textSize) {
                dVar.f3513l = textSize;
                dVar.i(false);
            }
            int i6 = Build.VERSION.SDK_INT;
            float letterSpacing = this.f3966d.getLetterSpacing();
            if (dVar.f3504g0 != letterSpacing) {
                dVar.f3504g0 = letterSpacing;
                dVar.i(false);
            }
            int gravity = this.f3966d.getGravity();
            dVar.l((gravity & (-113)) | 48);
            if (dVar.f3509j != gravity) {
                dVar.f3509j = gravity;
                dVar.i(false);
            }
            this.f3966d.addTextChangedListener(new s2(this, 2));
            if (this.f3977i0 == null) {
                this.f3977i0 = this.f3966d.getHintTextColors();
            }
            if (this.C) {
                if (TextUtils.isEmpty(this.D)) {
                    CharSequence hint = this.f3966d.getHint();
                    this.f3968e = hint;
                    setHint(hint);
                    this.f3966d.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (i6 >= 29) {
                p();
            }
            if (this.f3988o != null) {
                n(this.f3966d.getText());
            }
            r();
            this.f3978j.b();
            this.f3962b.bringToFront();
            l lVar = this.f3964c;
            lVar.bringToFront();
            Iterator it = this.f3969e0.iterator();
            while (it.hasNext()) {
                ((k) it.next()).a(this);
            }
            lVar.m();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            u(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.D)) {
            this.D = charSequence;
            com.google.android.material.internal.d dVar = this.f4001u0;
            if (charSequence == null || !TextUtils.equals(dVar.G, charSequence)) {
                dVar.G = charSequence;
                dVar.H = null;
                Bitmap bitmap = dVar.K;
                if (bitmap != null) {
                    bitmap.recycle();
                    dVar.K = null;
                }
                dVar.i(false);
            }
            if (!this.f3999t0) {
                j();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z4) {
        if (this.f3996s == z4) {
            return;
        }
        if (z4) {
            AppCompatTextView appCompatTextView = this.f3998t;
            if (appCompatTextView != null) {
                this.f3960a.addView(appCompatTextView);
                this.f3998t.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f3998t;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.f3998t = null;
        }
        this.f3996s = z4;
    }

    public final void a(float f4) {
        com.google.android.material.internal.d dVar = this.f4001u0;
        if (dVar.f3493b == f4) {
            return;
        }
        if (this.f4007x0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f4007x0 = valueAnimator;
            valueAnimator.setInterpolator(com.google.common.collect.c.L1(getContext(), R.attr.motionEasingEmphasizedInterpolator, p1.a.f6129b));
            this.f4007x0.setDuration(com.google.common.collect.c.K1(getContext(), R.attr.motionDurationMedium4, 167));
            this.f4007x0.addUpdateListener(new com.google.android.material.appbar.i(3, this));
        }
        this.f4007x0.setFloatValues(dVar.f3493b, f4);
        this.f4007x0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i4, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f3960a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    public final void b() {
        int i4;
        int i5;
        int i6;
        l2.j jVar = this.F;
        if (jVar == null) {
            return;
        }
        l2.p pVar = jVar.f5310a.f5288a;
        l2.p pVar2 = this.L;
        if (pVar != pVar2) {
            jVar.setShapeAppearanceModel(pVar2);
        }
        if (this.O == 2 && (i5 = this.Q) > -1 && (i6 = this.T) != 0) {
            l2.j jVar2 = this.F;
            jVar2.u(i5);
            jVar2.t(ColorStateList.valueOf(i6));
        }
        int i7 = this.U;
        if (this.O == 1) {
            i7 = b0.a.c(this.U, y1.a.c(getContext(), R.attr.colorSurface, 0));
        }
        this.U = i7;
        this.F.o(ColorStateList.valueOf(i7));
        l2.j jVar3 = this.J;
        if (jVar3 != null && this.K != null) {
            if (this.Q > -1 && this.T != 0) {
                if (this.f3966d.isFocused()) {
                    i4 = this.f3981k0;
                } else {
                    i4 = this.T;
                }
                jVar3.o(ColorStateList.valueOf(i4));
                this.K.o(ColorStateList.valueOf(this.T));
            }
            invalidate();
        }
        s();
    }

    public final int c() {
        float e4;
        if (this.C) {
            int i4 = this.O;
            com.google.android.material.internal.d dVar = this.f4001u0;
            if (i4 == 0) {
                e4 = dVar.e();
            } else if (i4 != 2) {
                return 0;
            } else {
                e4 = dVar.e() / 2.0f;
            }
            return (int) e4;
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.transition.Transition, androidx.transition.Fade, androidx.transition.Visibility] */
    public final Fade d() {
        ?? visibility = new Visibility();
        visibility.f2353c = com.google.common.collect.c.K1(getContext(), R.attr.motionDurationShort2, 87);
        visibility.f2354d = com.google.common.collect.c.L1(getContext(), R.attr.motionEasingLinearInterpolator, p1.a.f6128a);
        return visibility;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i4) {
        EditText editText = this.f3966d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i4);
            return;
        }
        if (this.f3968e != null) {
            boolean z4 = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.f3966d.setHint(this.f3968e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i4);
                return;
            } finally {
                this.f3966d.setHint(hint);
                this.E = z4;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i4);
        onProvideAutofillVirtualStructure(viewStructure, i4);
        FrameLayout frameLayout = this.f3960a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i5 = 0; i5 < frameLayout.getChildCount(); i5++) {
            View childAt = frameLayout.getChildAt(i5);
            ViewStructure newChild = viewStructure.newChild(i5);
            childAt.dispatchProvideAutofillStructure(newChild, i4);
            if (childAt == this.f3966d) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f4011z0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f4011z0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        l2.j jVar;
        super.draw(canvas);
        boolean z4 = this.C;
        com.google.android.material.internal.d dVar = this.f4001u0;
        if (z4) {
            dVar.d(canvas);
        }
        if (this.K != null && (jVar = this.J) != null) {
            jVar.draw(canvas);
            if (this.f3966d.isFocused()) {
                Rect bounds = this.K.getBounds();
                Rect bounds2 = this.J.getBounds();
                float f4 = dVar.f3493b;
                int centerX = bounds2.centerX();
                bounds.left = p1.a.c(centerX, f4, bounds2.left);
                bounds.right = p1.a.c(centerX, f4, bounds2.right);
                this.K.draw(canvas);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f4009y0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f4009y0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.d r3 = r4.f4001u0
            if (r3 == 0) goto L2f
            r3.R = r1
            android.content.res.ColorStateList r1 = r3.f3519o
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f3517n
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.i(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f3966d
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = i0.y0.f4999a
            boolean r3 = i0.j0.c(r4)
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = r2
        L44:
            r4.u(r0, r2)
        L47:
            r4.r()
            r4.x()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.f4009y0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final boolean e() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [l2.p, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, com.google.common.collect.c] */
    public final l2.j f(boolean z4) {
        float f4;
        float dimensionPixelOffset;
        ColorStateList colorStateList;
        int i4;
        float dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (z4) {
            f4 = dimensionPixelOffset2;
        } else {
            f4 = 0.0f;
        }
        EditText editText = this.f3966d;
        if (editText instanceof MaterialAutoCompleteTextView) {
            dimensionPixelOffset = ((MaterialAutoCompleteTextView) editText).getPopupElevation();
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ?? obj = new Object();
        ?? obj2 = new Object();
        ?? obj3 = new Object();
        ?? obj4 = new Object();
        l2.f b02 = com.google.common.collect.c.b0();
        l2.f b03 = com.google.common.collect.c.b0();
        l2.f b04 = com.google.common.collect.c.b0();
        l2.f b05 = com.google.common.collect.c.b0();
        l2.a aVar = new l2.a(f4);
        l2.a aVar2 = new l2.a(f4);
        l2.a aVar3 = new l2.a(dimensionPixelOffset2);
        l2.a aVar4 = new l2.a(dimensionPixelOffset2);
        ?? obj5 = new Object();
        obj5.f5348a = obj;
        obj5.f5349b = obj2;
        obj5.f5350c = obj3;
        obj5.f5351d = obj4;
        obj5.f5352e = aVar;
        obj5.f5353f = aVar2;
        obj5.f5354g = aVar4;
        obj5.f5355h = aVar3;
        obj5.f5356i = b02;
        obj5.f5357j = b03;
        obj5.f5358k = b04;
        obj5.f5359l = b05;
        EditText editText2 = this.f3966d;
        if (editText2 instanceof MaterialAutoCompleteTextView) {
            colorStateList = ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList();
        } else {
            colorStateList = null;
        }
        Context context = getContext();
        if (colorStateList == null) {
            Paint paint = l2.j.f5309w;
            TypedValue c4 = i2.c.c(R.attr.colorSurface, context, l2.j.class.getSimpleName());
            int i5 = c4.resourceId;
            if (i5 != 0) {
                Object obj6 = z.e.f7215a;
                i4 = z.d.a(context, i5);
            } else {
                i4 = c4.data;
            }
            colorStateList = ColorStateList.valueOf(i4);
        }
        l2.j jVar = new l2.j();
        jVar.l(context);
        jVar.o(colorStateList);
        jVar.n(dimensionPixelOffset);
        jVar.setShapeAppearanceModel(obj5);
        l2.i iVar = jVar.f5310a;
        if (iVar.f5295h == null) {
            iVar.f5295h = new Rect();
        }
        jVar.f5310a.f5295h.set(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
        jVar.invalidateSelf();
        return jVar;
    }

    public final int g(int i4, boolean z4) {
        return ((z4 || getPrefixText() == null) ? (!z4 || getSuffixText() == null) ? this.f3966d.getCompoundPaddingLeft() : this.f3964c.c() : this.f3962b.a()) + i4;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3966d;
        if (editText != null) {
            return c() + getPaddingTop() + editText.getBaseline();
        }
        return super.getBaseline();
    }

    @NonNull
    public l2.j getBoxBackground() {
        int i4 = this.O;
        if (i4 != 1 && i4 != 2) {
            throw new IllegalStateException();
        }
        return this.F;
    }

    public int getBoxBackgroundColor() {
        return this.U;
    }

    public int getBoxBackgroundMode() {
        return this.O;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.P;
    }

    public float getBoxCornerRadiusBottomEnd() {
        l2.d dVar;
        boolean f4 = n0.f(this);
        RectF rectF = this.f3961a0;
        if (f4) {
            dVar = this.L.f5355h;
        } else {
            dVar = this.L.f5354g;
        }
        return dVar.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        l2.d dVar;
        boolean f4 = n0.f(this);
        RectF rectF = this.f3961a0;
        if (f4) {
            dVar = this.L.f5354g;
        } else {
            dVar = this.L.f5355h;
        }
        return dVar.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        l2.d dVar;
        boolean f4 = n0.f(this);
        RectF rectF = this.f3961a0;
        if (f4) {
            dVar = this.L.f5352e;
        } else {
            dVar = this.L.f5353f;
        }
        return dVar.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        l2.d dVar;
        boolean f4 = n0.f(this);
        RectF rectF = this.f3961a0;
        if (f4) {
            dVar = this.L.f5353f;
        } else {
            dVar = this.L.f5352e;
        }
        return dVar.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f3985m0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f3987n0;
    }

    public int getBoxStrokeWidth() {
        return this.R;
    }

    public int getBoxStrokeWidthFocused() {
        return this.S;
    }

    public int getCounterMaxLength() {
        return this.f3982l;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f3980k && this.f3984m && (appCompatTextView = this.f3988o) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f4010z;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f4008y;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.A;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.B;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f3977i0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f3966d;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f3964c.f4055g.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f3964c.f4055g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f3964c.f4061m;
    }

    public int getEndIconMode() {
        return this.f3964c.f4057i;
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f3964c.f4062n;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f3964c.f4055g;
    }

    @Nullable
    public CharSequence getError() {
        o oVar = this.f3978j;
        if (oVar.f4096q) {
            return oVar.f4095p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f3978j.f4099t;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f3978j.f4098s;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f3978j.f4097r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f3964c.f4051c.getDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        o oVar = this.f3978j;
        if (oVar.f4103x) {
            return oVar.f4102w;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f3978j.f4104y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.f4001u0.e();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.d dVar = this.f4001u0;
        return dVar.f(dVar.f3519o);
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f3979j0;
    }

    @NonNull
    public u getLengthCounter() {
        return this.f3986n;
    }

    public int getMaxEms() {
        return this.f3972g;
    }

    @Px
    public int getMaxWidth() {
        return this.f3976i;
    }

    public int getMinEms() {
        return this.f3970f;
    }

    @Px
    public int getMinWidth() {
        return this.f3974h;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3964c.f4055g.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3964c.f4055g.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f3996s) {
            return this.f3994r;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.f4002v;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f4000u;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f3962b.f4114c;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f3962b.f4113b.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f3962b.f4113b;
    }

    @NonNull
    public l2.p getShapeAppearanceModel() {
        return this.L;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f3962b.f4115d.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f3962b.f4115d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f3962b.f4118g;
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f3962b.f4119h;
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f3964c.f4064p;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f3964c.f4065q.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f3964c.f4065q;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f3963b0;
    }

    public final int h(int i4, boolean z4) {
        return i4 - ((z4 || getSuffixText() == null) ? (!z4 || getPrefixText() == null) ? this.f3966d.getCompoundPaddingRight() : this.f3962b.a() : this.f3964c.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.i():void");
    }

    public final void j() {
        float f4;
        float f5;
        float f6;
        RectF rectF;
        float f7;
        if (!e()) {
            return;
        }
        int width = this.f3966d.getWidth();
        int gravity = this.f3966d.getGravity();
        com.google.android.material.internal.d dVar = this.f4001u0;
        boolean b5 = dVar.b(dVar.G);
        dVar.I = b5;
        Rect rect = dVar.f3505h;
        if (gravity != 17 && (gravity & 7) != 1) {
            if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !b5 : b5) {
                f4 = rect.right;
                f5 = dVar.f3510j0;
            } else {
                f6 = rect.left;
                float max = Math.max(f6, rect.left);
                rectF = this.f3961a0;
                rectF.left = max;
                rectF.top = rect.top;
                if (gravity == 17 && (gravity & 7) != 1) {
                    if ((gravity & 8388613) != 8388613 && (gravity & 5) != 5) {
                        if (!dVar.I) {
                            f7 = dVar.f3510j0 + max;
                        }
                        f7 = rect.right;
                    } else {
                        if (dVar.I) {
                            f7 = max + dVar.f3510j0;
                        }
                        f7 = rect.right;
                    }
                } else {
                    f7 = (width / 2.0f) + (dVar.f3510j0 / 2.0f);
                }
                rectF.right = Math.min(f7, rect.right);
                rectF.bottom = dVar.e() + rect.top;
                if (rectF.width() <= 0.0f && rectF.height() > 0.0f) {
                    float f8 = rectF.left;
                    float f9 = this.N;
                    rectF.left = f8 - f9;
                    rectF.right += f9;
                    rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.Q);
                    g gVar = (g) this.F;
                    gVar.getClass();
                    gVar.y(rectF.left, rectF.top, rectF.right, rectF.bottom);
                    return;
                }
            }
        } else {
            f4 = width / 2.0f;
            f5 = dVar.f3510j0 / 2.0f;
        }
        f6 = f4 - f5;
        float max2 = Math.max(f6, rect.left);
        rectF = this.f3961a0;
        rectF.left = max2;
        rectF.top = rect.top;
        if (gravity == 17) {
        }
        f7 = (width / 2.0f) + (dVar.f3510j0 / 2.0f);
        rectF.right = Math.min(f7, rect.right);
        rectF.bottom = dVar.e() + rect.top;
        if (rectF.width() <= 0.0f) {
        }
    }

    public final void l(TextView textView, int i4) {
        try {
            textView.setTextAppearance(i4);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        textView.setTextAppearance(2131755415);
        Context context = getContext();
        Object obj = z.e.f7215a;
        textView.setTextColor(z.d.a(context, R.color.design_error));
    }

    public final boolean m() {
        o oVar = this.f3978j;
        if (oVar.f4094o == 1 && oVar.f4097r != null && !TextUtils.isEmpty(oVar.f4095p)) {
            return true;
        }
        return false;
    }

    public final void n(Editable editable) {
        int i4;
        boolean z4;
        int i5;
        g0.c cVar;
        ((i1.b) this.f3986n).getClass();
        if (editable != null) {
            i4 = editable.length();
        } else {
            i4 = 0;
        }
        boolean z5 = this.f3984m;
        int i6 = this.f3982l;
        String str = null;
        if (i6 == -1) {
            this.f3988o.setText(String.valueOf(i4));
            this.f3988o.setContentDescription(null);
            this.f3984m = false;
        } else {
            if (i4 > i6) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f3984m = z4;
            Context context = getContext();
            AppCompatTextView appCompatTextView = this.f3988o;
            int i7 = this.f3982l;
            if (this.f3984m) {
                i5 = R.string.character_counter_overflowed_content_description;
            } else {
                i5 = R.string.character_counter_content_description;
            }
            appCompatTextView.setContentDescription(context.getString(i5, Integer.valueOf(i4), Integer.valueOf(i7)));
            if (z5 != this.f3984m) {
                o();
            }
            String str2 = g0.c.f4768d;
            Locale locale = Locale.getDefault();
            int i8 = g0.m.f4786a;
            if (g0.l.a(locale) == 1) {
                cVar = g0.c.f4771g;
            } else {
                cVar = g0.c.f4770f;
            }
            AppCompatTextView appCompatTextView2 = this.f3988o;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i4), Integer.valueOf(this.f3982l));
            if (string == null) {
                cVar.getClass();
            } else {
                str = cVar.c(string, cVar.f4774c).toString();
            }
            appCompatTextView2.setText(str);
        }
        if (this.f3966d != null && z5 != this.f3984m) {
            u(false, false);
            x();
            r();
        }
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f3988o;
        if (appCompatTextView != null) {
            l(appCompatTextView, this.f3984m ? this.f3990p : this.f3992q);
            if (!this.f3984m && (colorStateList2 = this.f4008y) != null) {
                this.f3988o.setTextColor(colorStateList2);
            }
            if (!this.f3984m || (colorStateList = this.f4010z) == null) {
                return;
            }
            this.f3988o.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f4001u0.h(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        EditText editText;
        int max;
        super.onMeasure(i4, i5);
        EditText editText2 = this.f3966d;
        l lVar = this.f3964c;
        boolean z4 = false;
        if (editText2 != null && this.f3966d.getMeasuredHeight() < (max = Math.max(lVar.getMeasuredHeight(), this.f3962b.getMeasuredHeight()))) {
            this.f3966d.setMinimumHeight(max);
            z4 = true;
        }
        boolean q4 = q();
        if (z4 || q4) {
            this.f3966d.post(new s(this, 1));
        }
        if (this.f3998t != null && (editText = this.f3966d) != null) {
            this.f3998t.setGravity(editText.getGravity());
            this.f3998t.setPadding(this.f3966d.getCompoundPaddingLeft(), this.f3966d.getCompoundPaddingTop(), this.f3966d.getCompoundPaddingRight(), this.f3966d.getCompoundPaddingBottom());
        }
        lVar.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        setError(savedState.f4012c);
        if (savedState.f4013d) {
            post(new s(this, 0));
        }
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [l2.p, java.lang.Object] */
    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        boolean z4 = true;
        if (i4 != 1) {
            z4 = false;
        }
        if (z4 != this.M) {
            l2.d dVar = this.L.f5352e;
            RectF rectF = this.f3961a0;
            float a5 = dVar.a(rectF);
            float a6 = this.L.f5353f.a(rectF);
            float a7 = this.L.f5355h.a(rectF);
            float a8 = this.L.f5354g.a(rectF);
            l2.p pVar = this.L;
            com.google.common.collect.c cVar = pVar.f5348a;
            com.google.common.collect.c cVar2 = pVar.f5349b;
            com.google.common.collect.c cVar3 = pVar.f5351d;
            com.google.common.collect.c cVar4 = pVar.f5350c;
            l2.f b02 = com.google.common.collect.c.b0();
            l2.f b03 = com.google.common.collect.c.b0();
            l2.f b04 = com.google.common.collect.c.b0();
            l2.f b05 = com.google.common.collect.c.b0();
            l2.n.b(cVar2);
            l2.n.b(cVar);
            l2.n.b(cVar4);
            l2.n.b(cVar3);
            l2.a aVar = new l2.a(a6);
            l2.a aVar2 = new l2.a(a5);
            l2.a aVar3 = new l2.a(a8);
            l2.a aVar4 = new l2.a(a7);
            ?? obj = new Object();
            obj.f5348a = cVar2;
            obj.f5349b = cVar;
            obj.f5350c = cVar3;
            obj.f5351d = cVar4;
            obj.f5352e = aVar;
            obj.f5353f = aVar2;
            obj.f5354g = aVar4;
            obj.f5355h = aVar3;
            obj.f5356i = b02;
            obj.f5357j = b03;
            obj.f5358k = b04;
            obj.f5359l = b05;
            this.M = z4;
            setShapeAppearanceModel(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.material.textfield.TextInputLayout$SavedState, android.os.Parcelable, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z4;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        if (m()) {
            absSavedState.f4012c = getError();
        }
        l lVar = this.f3964c;
        if (lVar.f4057i != 0 && lVar.f4055g.f3439d) {
            z4 = true;
        } else {
            z4 = false;
        }
        absSavedState.f4013d = z4;
        return absSavedState;
    }

    public final void p() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.A;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue a5 = i2.c.a(context, R.attr.colorControlActivated);
            if (a5 != null) {
                int i4 = a5.resourceId;
                if (i4 != 0) {
                    colorStateList2 = z.e.b(context, i4);
                } else {
                    int i5 = a5.data;
                    if (i5 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i5);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.f3966d;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable != null) {
                textCursorDrawable2 = this.f3966d.getTextCursorDrawable();
                if ((m() || (this.f3988o != null && this.f3984m)) && (colorStateList = this.B) != null) {
                    colorStateList2 = colorStateList;
                }
                c0.b.h(textCursorDrawable2, colorStateList2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean q() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        int currentTextColor;
        EditText editText = this.f3966d;
        if (editText == null || this.O != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = o1.f857a;
        Drawable mutate = background.mutate();
        if (m()) {
            currentTextColor = getErrorCurrentTextColors();
        } else if (this.f3984m && (appCompatTextView = this.f3988o) != null) {
            currentTextColor = appCompatTextView.getCurrentTextColor();
        } else {
            mutate.clearColorFilter();
            this.f3966d.refreshDrawableState();
            return;
        }
        mutate.setColorFilter(a0.c(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public final void s() {
        EditText editText = this.f3966d;
        if (editText != null && this.F != null) {
            if ((this.I || editText.getBackground() == null) && this.O != 0) {
                EditText editText2 = this.f3966d;
                Drawable editTextBoxBackground = getEditTextBoxBackground();
                WeakHashMap weakHashMap = y0.f4999a;
                g0.q(editText2, editTextBoxBackground);
                this.I = true;
            }
        }
    }

    public void setBoxBackgroundColor(@ColorInt int i4) {
        if (this.U != i4) {
            this.U = i4;
            this.f3989o0 = i4;
            this.f3993q0 = i4;
            this.f3995r0 = i4;
            b();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i4) {
        Context context = getContext();
        Object obj = z.e.f7215a;
        setBoxBackgroundColor(z.d.a(context, i4));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f3989o0 = defaultColor;
        this.U = defaultColor;
        this.f3991p0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f3993q0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f3995r0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i4) {
        if (i4 == this.O) {
            return;
        }
        this.O = i4;
        if (this.f3966d != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i4) {
        this.P = i4;
    }

    public void setBoxCornerFamily(int i4) {
        l2.n g4 = this.L.g();
        l2.d dVar = this.L.f5352e;
        com.google.common.collect.c a02 = com.google.common.collect.c.a0(i4);
        g4.f5335a = a02;
        l2.n.b(a02);
        g4.f5339e = dVar;
        l2.d dVar2 = this.L.f5353f;
        com.google.common.collect.c a03 = com.google.common.collect.c.a0(i4);
        g4.f5336b = a03;
        l2.n.b(a03);
        g4.f5340f = dVar2;
        l2.d dVar3 = this.L.f5355h;
        com.google.common.collect.c a04 = com.google.common.collect.c.a0(i4);
        g4.f5338d = a04;
        l2.n.b(a04);
        g4.f5342h = dVar3;
        l2.d dVar4 = this.L.f5354g;
        com.google.common.collect.c a05 = com.google.common.collect.c.a0(i4);
        g4.f5337c = a05;
        l2.n.b(a05);
        g4.f5341g = dVar4;
        this.L = g4.a();
        b();
    }

    public void setBoxCornerRadii(float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        boolean f10 = n0.f(this);
        this.M = f10;
        if (f10) {
            f8 = f5;
        } else {
            f8 = f4;
        }
        if (!f10) {
            f4 = f5;
        }
        if (f10) {
            f9 = f7;
        } else {
            f9 = f6;
        }
        if (!f10) {
            f6 = f7;
        }
        l2.j jVar = this.F;
        if (jVar != null && jVar.j() == f8) {
            l2.j jVar2 = this.F;
            if (jVar2.f5310a.f5288a.f5353f.a(jVar2.h()) == f4) {
                l2.j jVar3 = this.F;
                if (jVar3.f5310a.f5288a.f5355h.a(jVar3.h()) == f9) {
                    l2.j jVar4 = this.F;
                    if (jVar4.f5310a.f5288a.f5354g.a(jVar4.h()) == f6) {
                        return;
                    }
                }
            }
        }
        l2.n g4 = this.L.g();
        g4.f5339e = new l2.a(f8);
        g4.f5340f = new l2.a(f4);
        g4.f5342h = new l2.a(f9);
        g4.f5341g = new l2.a(f6);
        this.L = g4.a();
        b();
    }

    public void setBoxCornerRadiiResources(@DimenRes int i4, @DimenRes int i5, @DimenRes int i6, @DimenRes int i7) {
        setBoxCornerRadii(getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i7), getContext().getResources().getDimension(i6));
    }

    public void setBoxStrokeColor(@ColorInt int i4) {
        if (this.f3985m0 != i4) {
            this.f3985m0 = i4;
            x();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.f3985m0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            x();
        }
        this.f3981k0 = colorStateList.getDefaultColor();
        this.f3997s0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f3983l0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f3985m0 = defaultColor;
        x();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f3987n0 != colorStateList) {
            this.f3987n0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i4) {
        this.R = i4;
        x();
    }

    public void setBoxStrokeWidthFocused(int i4) {
        this.S = i4;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i4) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i4));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i4) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i4));
    }

    public void setCounterEnabled(boolean z4) {
        if (this.f3980k != z4) {
            Editable editable = null;
            o oVar = this.f3978j;
            if (z4) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f3988o = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.f3963b0;
                if (typeface != null) {
                    this.f3988o.setTypeface(typeface);
                }
                this.f3988o.setMaxLines(1);
                oVar.a(this.f3988o, 2);
                i0.p.h((ViewGroup.MarginLayoutParams) this.f3988o.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.f3988o != null) {
                    EditText editText = this.f3966d;
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    n(editable);
                }
            } else {
                oVar.g(this.f3988o, 2);
                this.f3988o = null;
            }
            this.f3980k = z4;
        }
    }

    public void setCounterMaxLength(int i4) {
        Editable text;
        if (this.f3982l != i4) {
            if (i4 <= 0) {
                i4 = -1;
            }
            this.f3982l = i4;
            if (this.f3980k && this.f3988o != null) {
                EditText editText = this.f3966d;
                if (editText == null) {
                    text = null;
                } else {
                    text = editText.getText();
                }
                n(text);
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i4) {
        if (this.f3990p != i4) {
            this.f3990p = i4;
            o();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f4010z != colorStateList) {
            this.f4010z = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i4) {
        if (this.f3992q != i4) {
            this.f3992q = i4;
            o();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f4008y != colorStateList) {
            this.f4008y = colorStateList;
            o();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            p();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (m() || (this.f3988o != null && this.f3984m)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f3977i0 = colorStateList;
        this.f3979j0 = colorStateList;
        if (this.f3966d != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        k(this, z4);
        super.setEnabled(z4);
    }

    public void setEndIconActivated(boolean z4) {
        this.f3964c.f4055g.setActivated(z4);
    }

    public void setEndIconCheckable(boolean z4) {
        this.f3964c.f4055g.setCheckable(z4);
    }

    public void setEndIconContentDescription(@StringRes int i4) {
        l lVar = this.f3964c;
        CharSequence text = i4 != 0 ? lVar.getResources().getText(i4) : null;
        CheckableImageButton checkableImageButton = lVar.f4055g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i4) {
        l lVar = this.f3964c;
        Drawable t02 = i4 != 0 ? com.google.common.collect.c.t0(lVar.getContext(), i4) : null;
        CheckableImageButton checkableImageButton = lVar.f4055g;
        checkableImageButton.setImageDrawable(t02);
        if (t02 != null) {
            ColorStateList colorStateList = lVar.f4059k;
            PorterDuff.Mode mode = lVar.f4060l;
            TextInputLayout textInputLayout = lVar.f4049a;
            com.google.common.collect.c.m(textInputLayout, checkableImageButton, colorStateList, mode);
            com.google.common.collect.c.J1(textInputLayout, checkableImageButton, lVar.f4059k);
        }
    }

    public void setEndIconMinSize(@IntRange(from = 0) int i4) {
        l lVar = this.f3964c;
        if (i4 >= 0) {
            if (i4 != lVar.f4061m) {
                lVar.f4061m = i4;
                CheckableImageButton checkableImageButton = lVar.f4055g;
                checkableImageButton.setMinimumWidth(i4);
                checkableImageButton.setMinimumHeight(i4);
                CheckableImageButton checkableImageButton2 = lVar.f4051c;
                checkableImageButton2.setMinimumWidth(i4);
                checkableImageButton2.setMinimumHeight(i4);
                return;
            }
            return;
        }
        lVar.getClass();
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public void setEndIconMode(int i4) {
        this.f3964c.g(i4);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        l lVar = this.f3964c;
        View.OnLongClickListener onLongClickListener = lVar.f4063o;
        CheckableImageButton checkableImageButton = lVar.f4055g;
        checkableImageButton.setOnClickListener(onClickListener);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        l lVar = this.f3964c;
        lVar.f4063o = onLongClickListener;
        CheckableImageButton checkableImageButton = lVar.f4055g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        l lVar = this.f3964c;
        lVar.f4062n = scaleType;
        lVar.f4055g.setScaleType(scaleType);
        lVar.f4051c.setScaleType(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        l lVar = this.f3964c;
        if (lVar.f4059k != colorStateList) {
            lVar.f4059k = colorStateList;
            com.google.common.collect.c.m(lVar.f4049a, lVar.f4055g, colorStateList, lVar.f4060l);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        l lVar = this.f3964c;
        if (lVar.f4060l != mode) {
            lVar.f4060l = mode;
            com.google.common.collect.c.m(lVar.f4049a, lVar.f4055g, lVar.f4059k, mode);
        }
    }

    public void setEndIconVisible(boolean z4) {
        this.f3964c.h(z4);
    }

    public void setError(@Nullable CharSequence charSequence) {
        o oVar = this.f3978j;
        if (!oVar.f4096q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            oVar.c();
            oVar.f4095p = charSequence;
            oVar.f4097r.setText(charSequence);
            int i4 = oVar.f4093n;
            if (i4 != 1) {
                oVar.f4094o = 1;
            }
            oVar.i(i4, oVar.f4094o, oVar.h(oVar.f4097r, charSequence));
            return;
        }
        oVar.f();
    }

    public void setErrorAccessibilityLiveRegion(int i4) {
        o oVar = this.f3978j;
        oVar.f4099t = i4;
        AppCompatTextView appCompatTextView = oVar.f4097r;
        if (appCompatTextView != null) {
            WeakHashMap weakHashMap = y0.f4999a;
            j0.f(appCompatTextView, i4);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        o oVar = this.f3978j;
        oVar.f4098s = charSequence;
        AppCompatTextView appCompatTextView = oVar.f4097r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z4) {
        o oVar = this.f3978j;
        if (oVar.f4096q != z4) {
            oVar.c();
            TextInputLayout textInputLayout = oVar.f4087h;
            if (z4) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(oVar.f4086g);
                oVar.f4097r = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                oVar.f4097r.setTextAlignment(5);
                Typeface typeface = oVar.B;
                if (typeface != null) {
                    oVar.f4097r.setTypeface(typeface);
                }
                int i4 = oVar.f4100u;
                oVar.f4100u = i4;
                AppCompatTextView appCompatTextView2 = oVar.f4097r;
                if (appCompatTextView2 != null) {
                    textInputLayout.l(appCompatTextView2, i4);
                }
                ColorStateList colorStateList = oVar.f4101v;
                oVar.f4101v = colorStateList;
                AppCompatTextView appCompatTextView3 = oVar.f4097r;
                if (appCompatTextView3 != null && colorStateList != null) {
                    appCompatTextView3.setTextColor(colorStateList);
                }
                CharSequence charSequence = oVar.f4098s;
                oVar.f4098s = charSequence;
                AppCompatTextView appCompatTextView4 = oVar.f4097r;
                if (appCompatTextView4 != null) {
                    appCompatTextView4.setContentDescription(charSequence);
                }
                int i5 = oVar.f4099t;
                oVar.f4099t = i5;
                AppCompatTextView appCompatTextView5 = oVar.f4097r;
                if (appCompatTextView5 != null) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    j0.f(appCompatTextView5, i5);
                }
                oVar.f4097r.setVisibility(4);
                oVar.a(oVar.f4097r, 0);
            } else {
                oVar.f();
                oVar.g(oVar.f4097r, 0);
                oVar.f4097r = null;
                textInputLayout.r();
                textInputLayout.x();
            }
            oVar.f4096q = z4;
        }
    }

    public void setErrorIconDrawable(@DrawableRes int i4) {
        l lVar = this.f3964c;
        lVar.i(i4 != 0 ? com.google.common.collect.c.t0(lVar.getContext(), i4) : null);
        com.google.common.collect.c.J1(lVar.f4049a, lVar.f4051c, lVar.f4052d);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        l lVar = this.f3964c;
        CheckableImageButton checkableImageButton = lVar.f4051c;
        View.OnLongClickListener onLongClickListener = lVar.f4054f;
        checkableImageButton.setOnClickListener(onClickListener);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        l lVar = this.f3964c;
        lVar.f4054f = onLongClickListener;
        CheckableImageButton checkableImageButton = lVar.f4051c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        l lVar = this.f3964c;
        if (lVar.f4052d != colorStateList) {
            lVar.f4052d = colorStateList;
            com.google.common.collect.c.m(lVar.f4049a, lVar.f4051c, colorStateList, lVar.f4053e);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        l lVar = this.f3964c;
        if (lVar.f4053e != mode) {
            lVar.f4053e = mode;
            com.google.common.collect.c.m(lVar.f4049a, lVar.f4051c, lVar.f4052d, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i4) {
        o oVar = this.f3978j;
        oVar.f4100u = i4;
        AppCompatTextView appCompatTextView = oVar.f4097r;
        if (appCompatTextView != null) {
            oVar.f4087h.l(appCompatTextView, i4);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        o oVar = this.f3978j;
        oVar.f4101v = colorStateList;
        AppCompatTextView appCompatTextView = oVar.f4097r;
        if (appCompatTextView != null && colorStateList != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z4) {
        if (this.f4003v0 != z4) {
            this.f4003v0 = z4;
            u(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        o oVar = this.f3978j;
        if (isEmpty) {
            if (oVar.f4103x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!oVar.f4103x) {
            setHelperTextEnabled(true);
        }
        oVar.c();
        oVar.f4102w = charSequence;
        oVar.f4104y.setText(charSequence);
        int i4 = oVar.f4093n;
        if (i4 != 2) {
            oVar.f4094o = 2;
        }
        oVar.i(i4, oVar.f4094o, oVar.h(oVar.f4104y, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        o oVar = this.f3978j;
        oVar.A = colorStateList;
        AppCompatTextView appCompatTextView = oVar.f4104y;
        if (appCompatTextView != null && colorStateList != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z4) {
        o oVar = this.f3978j;
        if (oVar.f4103x != z4) {
            oVar.c();
            if (z4) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(oVar.f4086g);
                oVar.f4104y = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                oVar.f4104y.setTextAlignment(5);
                Typeface typeface = oVar.B;
                if (typeface != null) {
                    oVar.f4104y.setTypeface(typeface);
                }
                oVar.f4104y.setVisibility(4);
                AppCompatTextView appCompatTextView2 = oVar.f4104y;
                WeakHashMap weakHashMap = y0.f4999a;
                j0.f(appCompatTextView2, 1);
                int i4 = oVar.f4105z;
                oVar.f4105z = i4;
                AppCompatTextView appCompatTextView3 = oVar.f4104y;
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setTextAppearance(i4);
                }
                ColorStateList colorStateList = oVar.A;
                oVar.A = colorStateList;
                AppCompatTextView appCompatTextView4 = oVar.f4104y;
                if (appCompatTextView4 != null && colorStateList != null) {
                    appCompatTextView4.setTextColor(colorStateList);
                }
                oVar.a(oVar.f4104y, 1);
                oVar.f4104y.setAccessibilityDelegate(new androidx.appcompat.widget.t(1, oVar));
            } else {
                oVar.c();
                int i5 = oVar.f4093n;
                if (i5 == 2) {
                    oVar.f4094o = 0;
                }
                oVar.i(i5, oVar.f4094o, oVar.h(oVar.f4104y, ""));
                oVar.g(oVar.f4104y, 1);
                oVar.f4104y = null;
                TextInputLayout textInputLayout = oVar.f4087h;
                textInputLayout.r();
                textInputLayout.x();
            }
            oVar.f4103x = z4;
        }
    }

    public void setHelperTextTextAppearance(@StyleRes int i4) {
        o oVar = this.f3978j;
        oVar.f4105z = i4;
        AppCompatTextView appCompatTextView = oVar.f4104y;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i4);
        }
    }

    public void setHint(@StringRes int i4) {
        setHint(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setHintAnimationEnabled(boolean z4) {
        this.f4005w0 = z4;
    }

    public void setHintEnabled(boolean z4) {
        if (z4 != this.C) {
            this.C = z4;
            if (z4) {
                CharSequence hint = this.f3966d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f3966d.setHint((CharSequence) null);
                }
                this.E = true;
            } else {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f3966d.getHint())) {
                    this.f3966d.setHint(this.D);
                }
                setHintInternal(null);
            }
            if (this.f3966d != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i4) {
        com.google.android.material.internal.d dVar = this.f4001u0;
        dVar.k(i4);
        this.f3979j0 = dVar.f3519o;
        if (this.f3966d != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f3979j0 != colorStateList) {
            if (this.f3977i0 == null) {
                com.google.android.material.internal.d dVar = this.f4001u0;
                if (dVar.f3519o != colorStateList) {
                    dVar.f3519o = colorStateList;
                    dVar.i(false);
                }
            }
            this.f3979j0 = colorStateList;
            if (this.f3966d != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(@NonNull u uVar) {
        this.f3986n = uVar;
    }

    public void setMaxEms(int i4) {
        this.f3972g = i4;
        EditText editText = this.f3966d;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMaxEms(i4);
    }

    public void setMaxWidth(@Px int i4) {
        this.f3976i = i4;
        EditText editText = this.f3966d;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMaxWidth(i4);
    }

    public void setMaxWidthResource(@DimenRes int i4) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i4));
    }

    public void setMinEms(int i4) {
        this.f3970f = i4;
        EditText editText = this.f3966d;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMinEms(i4);
    }

    public void setMinWidth(@Px int i4) {
        this.f3974h = i4;
        EditText editText = this.f3966d;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMinWidth(i4);
    }

    public void setMinWidthResource(@DimenRes int i4) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i4));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i4) {
        l lVar = this.f3964c;
        lVar.f4055g.setContentDescription(i4 != 0 ? lVar.getResources().getText(i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i4) {
        l lVar = this.f3964c;
        lVar.f4055g.setImageDrawable(i4 != 0 ? com.google.common.collect.c.t0(lVar.getContext(), i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z4) {
        l lVar = this.f3964c;
        if (z4 && lVar.f4057i != 1) {
            lVar.g(1);
        } else if (!z4) {
            lVar.g(0);
        } else {
            lVar.getClass();
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        l lVar = this.f3964c;
        lVar.f4059k = colorStateList;
        com.google.common.collect.c.m(lVar.f4049a, lVar.f4055g, colorStateList, lVar.f4060l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        l lVar = this.f3964c;
        lVar.f4060l = mode;
        com.google.common.collect.c.m(lVar.f4049a, lVar.f4055g, lVar.f4059k, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        Editable text;
        if (this.f3998t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f3998t = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.f3998t;
            WeakHashMap weakHashMap = y0.f4999a;
            g0.s(appCompatTextView2, 2);
            Fade d4 = d();
            this.f4004w = d4;
            d4.f2352b = 67L;
            this.f4006x = d();
            setPlaceholderTextAppearance(this.f4002v);
            setPlaceholderTextColor(this.f4000u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f3996s) {
                setPlaceholderTextEnabled(true);
            }
            this.f3994r = charSequence;
        }
        EditText editText = this.f3966d;
        if (editText == null) {
            text = null;
        } else {
            text = editText.getText();
        }
        v(text);
    }

    public void setPlaceholderTextAppearance(@StyleRes int i4) {
        this.f4002v = i4;
        AppCompatTextView appCompatTextView = this.f3998t;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i4);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f4000u != colorStateList) {
            this.f4000u = colorStateList;
            AppCompatTextView appCompatTextView = this.f3998t;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        r rVar = this.f3962b;
        rVar.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        rVar.f4114c = charSequence2;
        rVar.f4113b.setText(charSequence);
        rVar.e();
    }

    public void setPrefixTextAppearance(@StyleRes int i4) {
        this.f3962b.f4113b.setTextAppearance(i4);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f3962b.f4113b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull l2.p pVar) {
        l2.j jVar = this.F;
        if (jVar != null && jVar.f5310a.f5288a != pVar) {
            this.L = pVar;
            b();
        }
    }

    public void setStartIconCheckable(boolean z4) {
        this.f3962b.f4115d.setCheckable(z4);
    }

    public void setStartIconContentDescription(@StringRes int i4) {
        setStartIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i4) {
        setStartIconDrawable(i4 != 0 ? com.google.common.collect.c.t0(getContext(), i4) : null);
    }

    public void setStartIconMinSize(@IntRange(from = 0) int i4) {
        r rVar = this.f3962b;
        if (i4 >= 0) {
            if (i4 != rVar.f4118g) {
                rVar.f4118g = i4;
                CheckableImageButton checkableImageButton = rVar.f4115d;
                checkableImageButton.setMinimumWidth(i4);
                checkableImageButton.setMinimumHeight(i4);
                return;
            }
            return;
        }
        rVar.getClass();
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        r rVar = this.f3962b;
        View.OnLongClickListener onLongClickListener = rVar.f4120i;
        CheckableImageButton checkableImageButton = rVar.f4115d;
        checkableImageButton.setOnClickListener(onClickListener);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        r rVar = this.f3962b;
        rVar.f4120i = onLongClickListener;
        CheckableImageButton checkableImageButton = rVar.f4115d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        r rVar = this.f3962b;
        rVar.f4119h = scaleType;
        rVar.f4115d.setScaleType(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        r rVar = this.f3962b;
        if (rVar.f4116e != colorStateList) {
            rVar.f4116e = colorStateList;
            com.google.common.collect.c.m(rVar.f4112a, rVar.f4115d, colorStateList, rVar.f4117f);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        r rVar = this.f3962b;
        if (rVar.f4117f != mode) {
            rVar.f4117f = mode;
            com.google.common.collect.c.m(rVar.f4112a, rVar.f4115d, rVar.f4116e, mode);
        }
    }

    public void setStartIconVisible(boolean z4) {
        this.f3962b.c(z4);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        l lVar = this.f3964c;
        lVar.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        lVar.f4064p = charSequence2;
        lVar.f4065q.setText(charSequence);
        lVar.n();
    }

    public void setSuffixTextAppearance(@StyleRes int i4) {
        this.f3964c.f4065q.setTextAppearance(i4);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f3964c.f4065q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable t tVar) {
        EditText editText = this.f3966d;
        if (editText != null) {
            y0.p(editText, tVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f3963b0) {
            this.f3963b0 = typeface;
            com.google.android.material.internal.d dVar = this.f4001u0;
            boolean m4 = dVar.m(typeface);
            boolean o4 = dVar.o(typeface);
            if (m4 || o4) {
                dVar.i(false);
            }
            o oVar = this.f3978j;
            if (typeface != oVar.B) {
                oVar.B = typeface;
                AppCompatTextView appCompatTextView = oVar.f4097r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = oVar.f4104y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f3988o;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.O != 1) {
            FrameLayout frameLayout = this.f3960a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int c4 = c();
            if (c4 != layoutParams.topMargin) {
                layoutParams.topMargin = c4;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        ColorStateList textColors;
        int i4;
        boolean isEnabled = isEnabled();
        EditText editText = this.f3966d;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z6 = true;
        } else {
            z6 = false;
        }
        EditText editText2 = this.f3966d;
        if (editText2 != null && editText2.hasFocus()) {
            z7 = true;
        } else {
            z7 = false;
        }
        ColorStateList colorStateList2 = this.f3977i0;
        com.google.android.material.internal.d dVar = this.f4001u0;
        if (colorStateList2 != null) {
            dVar.j(colorStateList2);
        }
        Editable editable = null;
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f3977i0;
            if (colorStateList3 != null) {
                i4 = colorStateList3.getColorForState(new int[]{-16842910}, this.f3997s0);
            } else {
                i4 = this.f3997s0;
            }
            dVar.j(ColorStateList.valueOf(i4));
        } else {
            if (m()) {
                AppCompatTextView appCompatTextView2 = this.f3978j.f4097r;
                if (appCompatTextView2 != null) {
                    textColors = appCompatTextView2.getTextColors();
                } else {
                    textColors = null;
                }
            } else if (this.f3984m && (appCompatTextView = this.f3988o) != null) {
                textColors = appCompatTextView.getTextColors();
            } else if (z7 && (colorStateList = this.f3979j0) != null && dVar.f3519o != colorStateList) {
                dVar.f3519o = colorStateList;
                dVar.i(false);
            }
            dVar.j(textColors);
        }
        l lVar = this.f3964c;
        r rVar = this.f3962b;
        if (!z6 && this.f4003v0 && (!isEnabled() || !z7)) {
            if (z5 || !this.f3999t0) {
                ValueAnimator valueAnimator = this.f4007x0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f4007x0.cancel();
                }
                if (z4 && this.f4005w0) {
                    a(0.0f);
                } else {
                    dVar.p(0.0f);
                }
                if (e() && (!((g) this.F).f4030x.f4028v.isEmpty()) && e()) {
                    ((g) this.F).y(0.0f, 0.0f, 0.0f, 0.0f);
                }
                this.f3999t0 = true;
                AppCompatTextView appCompatTextView3 = this.f3998t;
                if (appCompatTextView3 != null && this.f3996s) {
                    appCompatTextView3.setText((CharSequence) null);
                    i0.a(this.f3960a, this.f4006x);
                    this.f3998t.setVisibility(4);
                }
                rVar.f4121j = true;
                rVar.e();
                lVar.f4066r = true;
                lVar.n();
            }
        } else if (z5 || this.f3999t0) {
            ValueAnimator valueAnimator2 = this.f4007x0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f4007x0.cancel();
            }
            if (z4 && this.f4005w0) {
                a(1.0f);
            } else {
                dVar.p(1.0f);
            }
            this.f3999t0 = false;
            if (e()) {
                j();
            }
            EditText editText3 = this.f3966d;
            if (editText3 != null) {
                editable = editText3.getText();
            }
            v(editable);
            rVar.f4121j = false;
            rVar.e();
            lVar.f4066r = false;
            lVar.n();
        }
    }

    public final void v(Editable editable) {
        ((i1.b) this.f3986n).getClass();
        FrameLayout frameLayout = this.f3960a;
        if ((editable == null || editable.length() == 0) && !this.f3999t0) {
            if (this.f3998t != null && this.f3996s && !TextUtils.isEmpty(this.f3994r)) {
                this.f3998t.setText(this.f3994r);
                i0.a(frameLayout, this.f4004w);
                this.f3998t.setVisibility(0);
                this.f3998t.bringToFront();
                announceForAccessibility(this.f3994r);
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView = this.f3998t;
        if (appCompatTextView != null && this.f3996s) {
            appCompatTextView.setText((CharSequence) null);
            i0.a(frameLayout, this.f4006x);
            this.f3998t.setVisibility(4);
        }
    }

    public final void w(boolean z4, boolean z5) {
        int defaultColor = this.f3987n0.getDefaultColor();
        int colorForState = this.f3987n0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f3987n0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z4) {
            this.T = colorForState2;
        } else if (z5) {
            this.T = colorForState;
        } else {
            this.T = defaultColor;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.x():void");
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3962b.f4115d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f3962b.b(drawable);
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755833), attributeSet, i4);
        int colorForState;
        this.f3970f = -1;
        this.f3972g = -1;
        this.f3974h = -1;
        this.f3976i = -1;
        this.f3978j = new o(this);
        this.f3986n = new i1.b(6);
        this.V = new Rect();
        this.W = new Rect();
        this.f3961a0 = new RectF();
        this.f3969e0 = new LinkedHashSet();
        com.google.android.material.internal.d dVar = new com.google.android.material.internal.d(this);
        this.f4001u0 = dVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f3960a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = p1.a.f6128a;
        dVar.W = linearInterpolator;
        dVar.i(false);
        dVar.V = linearInterpolator;
        dVar.i(false);
        dVar.l(8388659);
        q3 e4 = h0.e(context2, attributeSet, o1.a.f5947f0, i4, 2131755833, 22, 20, 40, 45, 49);
        r rVar = new r(this, e4);
        this.f3962b = rVar;
        TypedArray typedArray = e4.f879b;
        this.C = typedArray.getBoolean(48, true);
        setHint(typedArray.getText(4));
        this.f4005w0 = typedArray.getBoolean(47, true);
        this.f4003v0 = typedArray.getBoolean(42, true);
        if (typedArray.hasValue(6)) {
            setMinEms(typedArray.getInt(6, -1));
        } else if (typedArray.hasValue(3)) {
            setMinWidth(typedArray.getDimensionPixelSize(3, -1));
        }
        if (typedArray.hasValue(5)) {
            setMaxEms(typedArray.getInt(5, -1));
        } else if (typedArray.hasValue(2)) {
            setMaxWidth(typedArray.getDimensionPixelSize(2, -1));
        }
        this.L = l2.p.c(context2, attributeSet, i4, 2131755833).a();
        this.N = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.P = typedArray.getDimensionPixelOffset(9, 0);
        this.R = typedArray.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.S = typedArray.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.Q = this.R;
        float dimension = typedArray.getDimension(13, -1.0f);
        float dimension2 = typedArray.getDimension(12, -1.0f);
        float dimension3 = typedArray.getDimension(10, -1.0f);
        float dimension4 = typedArray.getDimension(11, -1.0f);
        l2.n g4 = this.L.g();
        if (dimension >= 0.0f) {
            g4.f5339e = new l2.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            g4.f5340f = new l2.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            g4.f5341g = new l2.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            g4.f5342h = new l2.a(dimension4);
        }
        this.L = g4.a();
        ColorStateList b5 = i2.d.b(context2, e4, 7);
        if (b5 != null) {
            int defaultColor = b5.getDefaultColor();
            this.f3989o0 = defaultColor;
            this.U = defaultColor;
            if (b5.isStateful()) {
                this.f3991p0 = b5.getColorForState(new int[]{-16842910}, -1);
                this.f3993q0 = b5.getColorForState(new int[]{16842908, 16842910}, -1);
                colorForState = b5.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.f3993q0 = this.f3989o0;
                ColorStateList b6 = z.e.b(context2, R.color.mtrl_filled_background_color);
                this.f3991p0 = b6.getColorForState(new int[]{-16842910}, -1);
                colorForState = b6.getColorForState(new int[]{16843623}, -1);
            }
            this.f3995r0 = colorForState;
        } else {
            this.U = 0;
            this.f3989o0 = 0;
            this.f3991p0 = 0;
            this.f3993q0 = 0;
            this.f3995r0 = 0;
        }
        if (typedArray.hasValue(1)) {
            ColorStateList a5 = e4.a(1);
            this.f3979j0 = a5;
            this.f3977i0 = a5;
        }
        ColorStateList b7 = i2.d.b(context2, e4, 14);
        this.f3985m0 = typedArray.getColor(14, 0);
        Object obj = z.e.f7215a;
        this.f3981k0 = z.d.a(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.f3997s0 = z.d.a(context2, R.color.mtrl_textinput_disabled_color);
        this.f3983l0 = z.d.a(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (b7 != null) {
            setBoxStrokeColorStateList(b7);
        }
        if (typedArray.hasValue(15)) {
            setBoxStrokeErrorColor(i2.d.b(context2, e4, 15));
        }
        if (typedArray.getResourceId(49, -1) != -1) {
            setHintTextAppearance(typedArray.getResourceId(49, 0));
        }
        this.A = e4.a(24);
        this.B = e4.a(25);
        int resourceId = typedArray.getResourceId(40, 0);
        CharSequence text = typedArray.getText(35);
        int i5 = typedArray.getInt(34, 1);
        boolean z4 = typedArray.getBoolean(36, false);
        int resourceId2 = typedArray.getResourceId(45, 0);
        boolean z5 = typedArray.getBoolean(44, false);
        CharSequence text2 = typedArray.getText(43);
        int resourceId3 = typedArray.getResourceId(57, 0);
        CharSequence text3 = typedArray.getText(56);
        boolean z6 = typedArray.getBoolean(18, false);
        setCounterMaxLength(typedArray.getInt(19, -1));
        this.f3992q = typedArray.getResourceId(22, 0);
        this.f3990p = typedArray.getResourceId(20, 0);
        setBoxBackgroundMode(typedArray.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i5);
        setCounterOverflowTextAppearance(this.f3990p);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f3992q);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArray.hasValue(41)) {
            setErrorTextColor(e4.a(41));
        }
        if (typedArray.hasValue(46)) {
            setHelperTextColor(e4.a(46));
        }
        if (typedArray.hasValue(50)) {
            setHintTextColor(e4.a(50));
        }
        if (typedArray.hasValue(23)) {
            setCounterTextColor(e4.a(23));
        }
        if (typedArray.hasValue(21)) {
            setCounterOverflowTextColor(e4.a(21));
        }
        if (typedArray.hasValue(58)) {
            setPlaceholderTextColor(e4.a(58));
        }
        l lVar = new l(this, e4);
        this.f3964c = lVar;
        boolean z7 = typedArray.getBoolean(0, true);
        e4.g();
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, 2);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26 && i6 >= 26) {
            p0.l(this, 1);
        }
        frameLayout.addView(rVar);
        frameLayout.addView(lVar);
        addView(frameLayout);
        setEnabled(z7);
        setHelperTextEnabled(z5);
        setErrorEnabled(z4);
        setCounterEnabled(z6);
        setHelperText(text2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f3964c.f4055g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f3964c.f4055g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f3964c.i(drawable);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3964c.f4055g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        l lVar = this.f3964c;
        CheckableImageButton checkableImageButton = lVar.f4055g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = lVar.f4059k;
            PorterDuff.Mode mode = lVar.f4060l;
            TextInputLayout textInputLayout = lVar.f4049a;
            com.google.common.collect.c.m(textInputLayout, checkableImageButton, colorStateList, mode);
            com.google.common.collect.c.J1(textInputLayout, checkableImageButton, lVar.f4059k);
        }
    }
}