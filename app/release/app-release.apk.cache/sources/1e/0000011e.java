package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.example.msphone.R;

/* loaded from: classes.dex */
public abstract class b extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public final a f707a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f708b;

    /* renamed from: c  reason: collision with root package name */
    public ActionMenuView f709c;

    /* renamed from: d  reason: collision with root package name */
    public n f710d;

    /* renamed from: e  reason: collision with root package name */
    public int f711e;

    /* renamed from: f  reason: collision with root package name */
    public i0.g1 f712f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f713g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f714h;

    public b(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f707a = new a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f708b = context;
        } else {
            this.f708b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int c(View view, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), i5);
        return Math.max(0, i4 - view.getMeasuredWidth());
    }

    public static int d(int i4, int i5, int i6, View view, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = ((i6 - measuredHeight) / 2) + i5;
        if (z4) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        if (z4) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public final i0.g1 e(int i4, long j4) {
        i0.g1 g1Var = this.f712f;
        if (g1Var != null) {
            g1Var.b();
        }
        a aVar = this.f707a;
        if (i4 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            i0.g1 a5 = i0.y0.a(this);
            a5.a(1.0f);
            a5.c(j4);
            aVar.f690c.f712f = a5;
            aVar.f689b = i4;
            a5.d(aVar);
            return a5;
        }
        i0.g1 a6 = i0.y0.a(this);
        a6.a(0.0f);
        a6.c(j4);
        aVar.f690c.f712f = a6;
        aVar.f689b = i4;
        a6.d(aVar);
        return a6;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, c.a.f2543a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        n nVar = this.f710d;
        if (nVar != null) {
            nVar.f845q = f.a.a(nVar.f4610b).b();
            g.p pVar = nVar.f4611c;
            if (pVar != null) {
                pVar.p(true);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f714h = false;
        }
        if (!this.f714h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f714h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f714h = false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f713g = false;
        }
        if (!this.f713g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f713g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f713g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i4);

    @Override // android.view.View
    public void setVisibility(int i4) {
        if (i4 != getVisibility()) {
            i0.g1 g1Var = this.f712f;
            if (g1Var != null) {
                g1Var.b();
            }
            super.setVisibility(i4);
        }
    }
}