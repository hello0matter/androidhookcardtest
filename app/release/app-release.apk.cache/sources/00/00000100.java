package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f520i = {16843505};

    /* renamed from: a  reason: collision with root package name */
    public final w f521a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f522b;

    /* renamed from: c  reason: collision with root package name */
    public final k f523c;

    /* renamed from: d  reason: collision with root package name */
    public SpinnerAdapter f524d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f525e;

    /* renamed from: f  reason: collision with root package name */
    public final q0 f526f;

    /* renamed from: g  reason: collision with root package name */
    public int f527g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f528h;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public boolean f529a;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.f529a ? (byte) 1 : (byte) 0);
        }
    }

    public AppCompatSpinner(@NonNull Context context) {
        this(context, null);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i4 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i5 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i5 = Math.max(i5, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.f528h;
            drawable.getPadding(rect);
            return i5 + rect.left + rect.right;
        }
        return i5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f521a;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        q0 q0Var = this.f526f;
        return q0Var != null ? q0Var.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        q0 q0Var = this.f526f;
        return q0Var != null ? q0Var.g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f526f != null ? this.f527g : super.getDropDownWidth();
    }

    @VisibleForTesting
    public final q0 getInternalPopup() {
        return this.f526f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        q0 q0Var = this.f526f;
        return q0Var != null ? q0Var.h() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f522b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        q0 q0Var = this.f526f;
        return q0Var != null ? q0Var.i() : super.getPrompt();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f521a;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f521a;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q0 q0Var = this.f526f;
        if (q0Var == null || !q0Var.b()) {
            return;
        }
        q0Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f526f == null || View.MeasureSpec.getMode(i4) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i4)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f529a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new g.f(3, this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, androidx.appcompat.widget.AppCompatSpinner$SavedState] */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z4;
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        q0 q0Var = this.f526f;
        if (q0Var != null && q0Var.b()) {
            z4 = true;
        } else {
            z4 = false;
        }
        baseSavedState.f529a = z4;
        return baseSavedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        k kVar = this.f523c;
        if (kVar == null || !kVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        q0 q0Var = this.f526f;
        if (q0Var != null) {
            if (!q0Var.b()) {
                this.f526f.e(j0.b(this), j0.a(this));
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f521a;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f521a;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i4) {
        q0 q0Var = this.f526f;
        if (q0Var == null) {
            super.setDropDownHorizontalOffset(i4);
            return;
        }
        q0Var.p(i4);
        q0Var.c(i4);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i4) {
        q0 q0Var = this.f526f;
        if (q0Var != null) {
            q0Var.n(i4);
        } else {
            super.setDropDownVerticalOffset(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i4) {
        if (this.f526f != null) {
            this.f527g = i4;
        } else {
            super.setDropDownWidth(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        q0 q0Var = this.f526f;
        if (q0Var != null) {
            q0Var.l(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i4) {
        setPopupBackgroundDrawable(com.google.common.collect.c.t0(getPopupContext(), i4));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        q0 q0Var = this.f526f;
        if (q0Var != null) {
            q0Var.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f521a;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f521a;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.appcompat.widget.m0, android.widget.ListAdapter, java.lang.Object] */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f525e) {
            this.f524d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        q0 q0Var = this.f526f;
        if (q0Var != 0) {
            Context context = this.f522b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            ?? obj = new Object();
            obj.f815a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                obj.f816b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                k0.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            q0Var.o(obj);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r6 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            r11 = this;
            r11.<init>(r12, r13, r14)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r11.f528h = r0
            android.content.Context r0 = r11.getContext()
            androidx.appcompat.widget.m3.a(r11, r0)
            int[] r0 = c.a.f2566x
            r1 = 0
            androidx.appcompat.widget.q3 r2 = androidx.appcompat.widget.q3.f(r12, r13, r0, r14, r1)
            androidx.appcompat.widget.w r3 = new androidx.appcompat.widget.w
            r3.<init>(r11)
            r11.f521a = r3
            r3 = 4
            android.content.res.TypedArray r4 = r2.f879b
            int r3 = r4.getResourceId(r3, r1)
            if (r3 == 0) goto L30
            f.f r5 = new f.f
            r5.<init>(r12, r3)
            r11.f522b = r5
            goto L32
        L30:
            r11.f522b = r12
        L32:
            r3 = -1
            r5 = 0
            int[] r6 = androidx.appcompat.widget.AppCompatSpinner.f520i     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            android.content.res.TypedArray r6 = r12.obtainStyledAttributes(r13, r6, r14, r1)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            boolean r7 = r6.hasValue(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            if (r7 == 0) goto L4b
            int r3 = r6.getInt(r1, r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            goto L4b
        L45:
            r12 = move-exception
            r5 = r6
            goto Lce
        L49:
            r7 = move-exception
            goto L54
        L4b:
            r6.recycle()
            goto L5e
        L4f:
            r12 = move-exception
            goto Lce
        L52:
            r7 = move-exception
            r6 = r5
        L54:
            java.lang.String r8 = "AppCompatSpinner"
            java.lang.String r9 = "Could not read android:spinnerMode"
            android.util.Log.i(r8, r9, r7)     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L5e
            goto L4b
        L5e:
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L96
            if (r3 == r7) goto L65
            goto La3
        L65:
            androidx.appcompat.widget.o0 r3 = new androidx.appcompat.widget.o0
            android.content.Context r8 = r11.f522b
            r3.<init>(r11, r8, r13, r14)
            android.content.Context r8 = r11.f522b
            androidx.appcompat.widget.q3 r0 = androidx.appcompat.widget.q3.f(r8, r13, r0, r14, r1)
            android.content.res.TypedArray r8 = r0.f879b
            r9 = 3
            r10 = -2
            int r8 = r8.getLayoutDimension(r9, r10)
            r11.f527g = r8
            android.graphics.drawable.Drawable r8 = r0.b(r7)
            r3.l(r8)
            java.lang.String r6 = r4.getString(r6)
            r3.C = r6
            r0.g()
            r11.f526f = r3
            androidx.appcompat.widget.k r0 = new androidx.appcompat.widget.k
            r0.<init>(r11, r11, r3, r7)
            r11.f523c = r0
            goto La3
        L96:
            androidx.appcompat.widget.l0 r0 = new androidx.appcompat.widget.l0
            r0.<init>(r11)
            r11.f526f = r0
            java.lang.String r3 = r4.getString(r6)
            r0.f811c = r3
        La3:
            java.lang.CharSequence[] r0 = r4.getTextArray(r1)
            if (r0 == 0) goto Lba
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r12, r3, r0)
            r12 = 2131427434(0x7f0b006a, float:1.8476484E38)
            r1.setDropDownViewResource(r12)
            r11.setAdapter(r1)
        Lba:
            r2.g()
            r11.f525e = r7
            android.widget.SpinnerAdapter r12 = r11.f524d
            if (r12 == 0) goto Lc8
            r11.setAdapter(r12)
            r11.f524d = r5
        Lc8:
            androidx.appcompat.widget.w r12 = r11.f521a
            r12.e(r13, r14)
            return
        Lce:
            if (r5 == 0) goto Ld3
            r5.recycle()
        Ld3:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}