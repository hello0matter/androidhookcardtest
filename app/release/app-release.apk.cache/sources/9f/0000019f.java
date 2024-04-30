package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.c0;
import androidx.fragment.app.m0;
import com.example.msphone.R;
import k.a;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: f */
    public static final int[] f1001f = {16842801};

    /* renamed from: g */
    public static final m0 f1002g = new Object();

    /* renamed from: a */
    public boolean f1003a;

    /* renamed from: b */
    public boolean f1004b;

    /* renamed from: c */
    public final Rect f1005c;

    /* renamed from: d */
    public final Rect f1006d;

    /* renamed from: e */
    public final c0 f1007e;

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return m0.m(this.f1007e).f5110h;
    }

    public float getCardElevation() {
        return ((CardView) this.f1007e.f726c).getElevation();
    }

    @Px
    public int getContentPaddingBottom() {
        return this.f1005c.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.f1005c.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.f1005c.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.f1005c.top;
    }

    public float getMaxCardElevation() {
        return m0.m(this.f1007e).f5107e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f1004b;
    }

    public float getRadius() {
        return m0.m(this.f1007e).f5103a;
    }

    public boolean getUseCompatPadding() {
        return this.f1003a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    public void setCardBackgroundColor(@ColorInt int i4) {
        ColorStateList valueOf = ColorStateList.valueOf(i4);
        a m4 = m0.m(this.f1007e);
        if (valueOf == null) {
            m4.getClass();
            valueOf = ColorStateList.valueOf(0);
        }
        m4.f5110h = valueOf;
        m4.f5104b.setColor(valueOf.getColorForState(m4.getState(), m4.f5110h.getDefaultColor()));
        m4.invalidateSelf();
    }

    public void setCardElevation(float f4) {
        ((CardView) this.f1007e.f726c).setElevation(f4);
    }

    public void setContentPadding(@Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        this.f1005c.set(i4, i5, i6, i7);
        f1002g.w(this.f1007e);
    }

    public void setMaxCardElevation(float f4) {
        f1002g.u(f4, this.f1007e);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i4) {
        super.setMinimumHeight(i4);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i4) {
        super.setMinimumWidth(i4);
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i4, int i5, int i6, int i7) {
    }

    public void setPreventCornerOverlap(boolean z4) {
        if (z4 != this.f1004b) {
            this.f1004b = z4;
            m0 m0Var = f1002g;
            c0 c0Var = this.f1007e;
            m0Var.u(m0.m(c0Var).f5107e, c0Var);
        }
    }

    public void setRadius(float f4) {
        a m4 = m0.m(this.f1007e);
        if (f4 != m4.f5103a) {
            m4.f5103a = f4;
            m4.b(null);
            m4.invalidateSelf();
        }
    }

    public void setUseCompatPadding(boolean z4) {
        if (this.f1003a != z4) {
            this.f1003a = z4;
            m0 m0Var = f1002g;
            c0 c0Var = this.f1007e;
            m0Var.u(m0.m(c0Var).f5107e, c0Var);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Resources resources;
        int i5;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1005c = rect;
        this.f1006d = new Rect();
        c0 c0Var = new c0(this);
        this.f1007e = c0Var;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.a.f5072a, i4, R.style.CardView);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1001f);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i5 = R.color.cardview_light_background;
            } else {
                resources = getResources();
                i5 = R.color.cardview_dark_background;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i5));
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f1003a = obtainStyledAttributes.getBoolean(7, false);
        this.f1004b = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        m0 m0Var = f1002g;
        a aVar = new a(dimension, valueOf);
        c0Var.f725b = aVar;
        ((CardView) c0Var.f726c).setBackgroundDrawable(aVar);
        CardView cardView = (CardView) c0Var.f726c;
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        m0Var.u(dimension3, c0Var);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        a m4 = m0.m(this.f1007e);
        if (colorStateList == null) {
            m4.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        m4.f5110h = colorStateList;
        m4.f5104b.setColor(colorStateList.getColorForState(m4.getState(), m4.f5110h.getDefaultColor()));
        m4.invalidateSelf();
    }
}