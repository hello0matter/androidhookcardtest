package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import h2.a;
import h2.b;
import h2.c;
import h2.d;
import h2.i;
import h2.k;
import h2.l;
import h2.m;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends d> extends ProgressBar {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ int f3704m = 0;

    /* renamed from: a  reason: collision with root package name */
    public final d f3705a;

    /* renamed from: b  reason: collision with root package name */
    public int f3706b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3707c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3708d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3709e;

    /* renamed from: f  reason: collision with root package name */
    public a f3710f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3711g;

    /* renamed from: h  reason: collision with root package name */
    public int f3712h;

    /* renamed from: i  reason: collision with root package name */
    public final b f3713i;

    /* renamed from: j  reason: collision with root package name */
    public final b f3714j;

    /* renamed from: k  reason: collision with root package name */
    public final c f3715k;

    /* renamed from: l  reason: collision with root package name */
    public final c f3716l;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface ShowAnimationBehavior {
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, h2.a] */
    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(p2.a.a(context, attributeSet, i4, 2131756086), attributeSet, i4);
        this.f3711g = false;
        this.f3712h = 4;
        this.f3713i = new b(this, 0);
        this.f3714j = new b(this, 1);
        this.f3715k = new c(0, this);
        this.f3716l = new c(1, this);
        Context context2 = getContext();
        this.f3705a = a(context2, attributeSet);
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.f5942d, i4, i5, new int[0]);
        d4.getInt(5, -1);
        this.f3709e = Math.min(d4.getInt(3, -1), 1000);
        d4.recycle();
        this.f3710f = new Object();
        this.f3708d = true;
    }

    @Nullable
    private l getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f4865l;
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().f4845l;
        }
    }

    public abstract d a(Context context, AttributeSet attributeSet);

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b() {
        /*
            r2 = this;
            java.util.WeakHashMap r0 = i0.y0.f4999a
            boolean r0 = i0.j0.b(r2)
            if (r0 == 0) goto L2c
            int r0 = r2.getWindowVisibility()
            if (r0 != 0) goto L2c
            r0 = r2
        Lf:
            int r1 = r0.getVisibility()
            if (r1 == 0) goto L16
            goto L2c
        L16:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L23
            int r0 = r2.getWindowVisibility()
            if (r0 != 0) goto L2c
            goto L27
        L23:
            boolean r1 = r0 instanceof android.view.View
            if (r1 != 0) goto L29
        L27:
            r0 = 1
            goto L2d
        L29:
            android.view.View r0 = (android.view.View) r0
            goto Lf
        L2c:
            r0 = 0
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.BaseProgressIndicator.b():boolean");
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f3705a.f4824f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f3705a.f4821c;
    }

    public int getShowAnimationBehavior() {
        return this.f3705a.f4823e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.f3705a.f4822d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.f3705a.f4820b;
    }

    @Px
    public int getTrackThickness() {
        return this.f3705a.f4819a;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f4866m.p(this.f3715k);
        }
        i progressDrawable = getProgressDrawable();
        c cVar = this.f3716l;
        if (progressDrawable != null) {
            i progressDrawable2 = getProgressDrawable();
            if (progressDrawable2.f4858f == null) {
                progressDrawable2.f4858f = new ArrayList();
            }
            if (!progressDrawable2.f4858f.contains(cVar)) {
                progressDrawable2.f4858f.add(cVar);
            }
        }
        if (getIndeterminateDrawable() != null) {
            m indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.f4858f == null) {
                indeterminateDrawable.f4858f = new ArrayList();
            }
            if (!indeterminateDrawable.f4858f.contains(cVar)) {
                indeterminateDrawable.f4858f.add(cVar);
            }
        }
        if (b()) {
            if (this.f3709e > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f3714j);
        removeCallbacks(this.f3713i);
        ((k) getCurrentDrawable()).e(false, false, false);
        m indeterminateDrawable = getIndeterminateDrawable();
        c cVar = this.f3716l;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().g(cVar);
            getIndeterminateDrawable().f4866m.u();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().g(cVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i4, int i5) {
        try {
            l currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i4) : currentDrawingDelegate.e() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.d() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i5) : currentDrawingDelegate.d() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i4) {
        boolean z4;
        super.onVisibilityChanged(view, i4);
        if (i4 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f3708d) {
            ((k) getCurrentDrawable()).e(b(), false, z4);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (this.f3708d) {
            ((k) getCurrentDrawable()).e(b(), false, false);
        }
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull a aVar) {
        this.f3710f = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f4855c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f4855c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i4) {
        this.f3705a.f4824f = i4;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z4) {
        try {
            if (z4 == isIndeterminate()) {
                return;
            }
            k kVar = (k) getCurrentDrawable();
            if (kVar != null) {
                kVar.e(false, false, false);
            }
            super.setIndeterminate(z4);
            k kVar2 = (k) getCurrentDrawable();
            if (kVar2 != null) {
                kVar2.e(b(), false, false);
            }
            if ((kVar2 instanceof m) && b()) {
                ((m) kVar2).f4866m.s();
            }
            this.f3711g = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof m) {
            ((k) drawable).e(false, false, false);
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{y1.a.c(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f3705a.f4821c = iArr;
            getIndeterminateDrawable().f4866m.o();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i4) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i4, false);
    }

    public void setProgressCompat(int i4, boolean z4) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f3706b = i4;
                this.f3707c = z4;
                this.f3711g = true;
                if (getIndeterminateDrawable().isVisible()) {
                    a aVar = this.f3710f;
                    ContentResolver contentResolver = getContext().getContentResolver();
                    aVar.getClass();
                    if (Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) != 0.0f) {
                        getIndeterminateDrawable().f4866m.q();
                        return;
                    }
                }
                this.f3715k.a(getIndeterminateDrawable());
                return;
            }
            return;
        }
        super.setProgress(i4);
        if (getProgressDrawable() != null && !z4) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof i) {
            i iVar = (i) drawable;
            iVar.e(false, false, false);
            super.setProgressDrawable(iVar);
            iVar.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i4) {
        this.f3705a.f4823e = i4;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i4) {
        d dVar = this.f3705a;
        if (dVar.f4822d != i4) {
            dVar.f4822d = i4;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i4) {
        d dVar = this.f3705a;
        if (dVar.f4820b != i4) {
            dVar.f4820b = Math.min(i4, dVar.f4819a / 2);
        }
    }

    public void setTrackThickness(@Px int i4) {
        d dVar = this.f3705a;
        if (dVar.f4819a != i4) {
            dVar.f4819a = i4;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i4) {
        if (i4 != 0 && i4 != 4 && i4 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f3712h = i4;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public m getIndeterminateDrawable() {
        return (m) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public i getProgressDrawable() {
        return (i) super.getProgressDrawable();
    }
}