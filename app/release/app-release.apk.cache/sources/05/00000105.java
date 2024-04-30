package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f169a})
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public TypedValue f543a;

    /* renamed from: b  reason: collision with root package name */
    public TypedValue f544b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f545c;

    /* renamed from: d  reason: collision with root package name */
    public TypedValue f546d;

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f547e;

    /* renamed from: f  reason: collision with root package name */
    public TypedValue f548f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f549g;

    /* renamed from: h  reason: collision with root package name */
    public j1 f550h;

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f547e == null) {
            this.f547e = new TypedValue();
        }
        return this.f547e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f548f == null) {
            this.f548f = new TypedValue();
        }
        return this.f548f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f545c == null) {
            this.f545c = new TypedValue();
        }
        return this.f545c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f546d == null) {
            this.f546d = new TypedValue();
        }
        return this.f546d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f543a == null) {
            this.f543a = new TypedValue();
        }
        return this.f543a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f544b == null) {
            this.f544b = new TypedValue();
        }
        return this.f544b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j1 j1Var = this.f550h;
        if (j1Var != null) {
            j1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        n nVar;
        super.onDetachedFromWindow();
        j1 j1Var = this.f550h;
        if (j1Var != null) {
            androidx.appcompat.app.f0 f0Var = ((androidx.appcompat.app.s) j1Var).f330b;
            k1 k1Var = f0Var.f245r;
            if (k1Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) k1Var;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((x3) actionBarOverlayLayout.f431e).f950a.f655a;
                if (actionMenuView != null && (nVar = actionMenuView.f458t) != null) {
                    nVar.f();
                    h hVar = nVar.f849u;
                    if (hVar != null && hVar.b()) {
                        hVar.f4606j.dismiss();
                    }
                }
            }
            if (f0Var.f250w != null) {
                f0Var.f239l.getDecorView().removeCallbacks(f0Var.f251x);
                if (f0Var.f250w.isShowing()) {
                    try {
                        f0Var.f250w.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                f0Var.f250w = null;
            }
            i0.g1 g1Var = f0Var.f252y;
            if (g1Var != null) {
                g1Var.b();
            }
            g.p pVar = f0Var.z(0).f216h;
            if (pVar != null) {
                pVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(j1 j1Var) {
        this.f550h = j1Var;
    }

    @RestrictTo({RestrictTo.Scope.f169a})
    public void setDecorPadding(int i4, int i5, int i6, int i7) {
        this.f549g.set(i4, i5, i6, i7);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (i0.j0.c(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f549g = new Rect();
    }
}