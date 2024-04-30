package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.o;
import c.a;
import g.b;
import g.c;
import g.e0;
import g.p;
import g.r;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements e0, View.OnClickListener, o {

    /* renamed from: h  reason: collision with root package name */
    public r f375h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f376i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f377j;

    /* renamed from: k  reason: collision with root package name */
    public g.o f378k;

    /* renamed from: l  reason: collision with root package name */
    public b f379l;

    /* renamed from: m  reason: collision with root package name */
    public c f380m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f381n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f382o;

    /* renamed from: p  reason: collision with root package name */
    public final int f383p;

    /* renamed from: q  reason: collision with root package name */
    public int f384q;

    /* renamed from: r  reason: collision with root package name */
    public final int f385r;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.o
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.o
    public final boolean b() {
        if ((!TextUtils.isEmpty(getText())) && this.f375h.getIcon() == null) {
            return true;
        }
        return false;
    }

    @Override // g.e0
    public final void c(r rVar) {
        int i4;
        this.f375h = rVar;
        setIcon(rVar.getIcon());
        setTitle(rVar.getTitleCondensed());
        setId(rVar.f4722a);
        if (rVar.isVisible()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        setVisibility(i4);
        setEnabled(rVar.isEnabled());
        if (rVar.hasSubMenu() && this.f379l == null) {
            this.f379l = new b(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // g.e0
    public r getItemData() {
        return this.f375h;
    }

    public final boolean m() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        return i4 >= 480 || (i4 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void n() {
        CharSequence charSequence;
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f376i);
        if (this.f377j != null && ((this.f375h.f4746y & 4) != 4 || (!this.f381n && !this.f382o))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        CharSequence charSequence2 = null;
        if (z6) {
            charSequence = this.f376i;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence3 = this.f375h.f4738q;
        if (TextUtils.isEmpty(charSequence3)) {
            if (z6) {
                charSequence3 = null;
            } else {
                charSequence3 = this.f375h.f4726e;
            }
        }
        setContentDescription(charSequence3);
        CharSequence charSequence4 = this.f375h.f4739r;
        if (TextUtils.isEmpty(charSequence4)) {
            if (!z6) {
                charSequence2 = this.f375h.f4726e;
            }
            com.google.common.collect.c.V1(this, charSequence2);
            return;
        }
        com.google.common.collect.c.V1(this, charSequence4);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g.o oVar = this.f378k;
        if (oVar != null) {
            oVar.a(this.f375h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f381n = m();
        n();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        boolean z4 = !TextUtils.isEmpty(getText());
        if (z4 && (i7 = this.f384q) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int measuredWidth = getMeasuredWidth();
        int i8 = this.f383p;
        if (mode == Integer.MIN_VALUE) {
            i6 = Math.min(size, i8);
        } else {
            i6 = i8;
        }
        if (mode != 1073741824 && i8 > 0 && measuredWidth < i6) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
        }
        if (!z4 && this.f377j != null) {
            super.setPadding((getMeasuredWidth() - this.f377j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f375h.hasSubMenu() && (bVar = this.f379l) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f382o != z4) {
            this.f382o = z4;
            r rVar = this.f375h;
            if (rVar != null) {
                p pVar = rVar.f4735n;
                pVar.f4705k = true;
                pVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f377j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i4 = this.f385r;
            if (intrinsicWidth > i4) {
                intrinsicHeight = (int) (intrinsicHeight * (i4 / intrinsicWidth));
                intrinsicWidth = i4;
            }
            if (intrinsicHeight > i4) {
                intrinsicWidth = (int) (intrinsicWidth * (i4 / intrinsicHeight));
            } else {
                i4 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i4);
        }
        setCompoundDrawables(drawable, null, null, null);
        n();
    }

    public void setItemInvoker(g.o oVar) {
        this.f378k = oVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f384q = i4;
        super.setPadding(i4, i5, i6, i7);
    }

    public void setPopupCallback(c cVar) {
        this.f380m = cVar;
    }

    public void setShortcut(boolean z4, char c4) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f376i = charSequence;
        n();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Resources resources = context.getResources();
        this.f381n = m();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f2545c, i4, 0);
        this.f383p = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f385r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f384q = -1;
        setSaveEnabled(false);
    }
}