package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.i0;
import com.example.msphone.R;
import i0.y0;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockFaceView extends RadialViewGroup implements d {
    public final float[] A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final String[] F;
    public float G;
    public final ColorStateList H;

    /* renamed from: t  reason: collision with root package name */
    public final ClockHandView f4127t;

    /* renamed from: u  reason: collision with root package name */
    public final Rect f4128u;

    /* renamed from: v  reason: collision with root package name */
    public final RectF f4129v;

    /* renamed from: w  reason: collision with root package name */
    public final Rect f4130w;

    /* renamed from: x  reason: collision with root package name */
    public final SparseArray f4131x;

    /* renamed from: y  reason: collision with root package name */
    public final c f4132y;

    /* renamed from: z  reason: collision with root package name */
    public final int[] f4133z;

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public final void o() {
        super.o();
        int i4 = 0;
        while (true) {
            SparseArray sparseArray = this.f4131x;
            if (i4 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i4)).setVisibility(0);
            i4++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(1, this.F.length, 1).f2125a);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        p();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.E / Math.max(Math.max(this.C / displayMetrics.heightPixels, this.D / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public final void p() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        boolean z4;
        Rect rect2;
        RadialGradient radialGradient;
        RectF rectF2 = this.f4127t.f4140g;
        float f4 = Float.MAX_VALUE;
        TextView textView = null;
        int i4 = 0;
        while (true) {
            sparseArray = this.f4131x;
            int size = sparseArray.size();
            rectF = this.f4129v;
            rect = this.f4128u;
            if (i4 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i4);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float height = rectF.height() * rectF.width();
                if (height < f4) {
                    textView = textView2;
                    f4 = height;
                }
            }
            i4++;
        }
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            TextView textView3 = (TextView) sparseArray.get(i5);
            if (textView3 != null) {
                if (textView3 == textView) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                textView3.setSelected(z4);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.f4130w);
                rectF.inset(rect2.left, rect2.top);
                if (!RectF.intersects(rectF2, rectF)) {
                    radialGradient = null;
                } else {
                    radialGradient = new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.f4133z, this.A, Shader.TileMode.CLAMP);
                }
                textView3.getPaint().setShader(radialGradient);
                textView3.invalidate();
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f4128u = new Rect();
        this.f4129v = new RectF();
        this.f4130w = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.f4131x = sparseArray;
        this.A = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5955l, i4, 2131756110);
        Resources resources = getResources();
        ColorStateList a5 = i2.d.a(context, obtainStyledAttributes, 1);
        this.H = a5;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f4127t = clockHandView;
        this.B = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = a5.getColorForState(new int[]{16842913}, a5.getDefaultColor());
        this.f4133z = new int[]{colorForState, colorForState, a5.getDefaultColor()};
        clockHandView.f4136c.add(this);
        int defaultColor = z.e.b(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a6 = i2.d.a(context, obtainStyledAttributes, 0);
        setBackgroundColor(a6 != null ? a6.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f4132y = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.F = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z4 = false;
        for (int i5 = 0; i5 < Math.max(this.F.length, size); i5++) {
            TextView textView = (TextView) sparseArray.get(i5);
            if (i5 >= this.F.length) {
                removeView(textView);
                sparseArray.remove(i5);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i5, textView);
                    addView(textView);
                }
                textView.setText(this.F[i5]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i5));
                int i6 = (i5 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i6));
                z4 = i6 > 1 ? true : z4;
                y0.p(textView, this.f4132y);
                textView.setTextColor(this.H);
            }
        }
        ClockHandView clockHandView2 = this.f4127t;
        if (clockHandView2.f4135b && !z4) {
            clockHandView2.f4146m = 1;
        }
        clockHandView2.f4135b = z4;
        clockHandView2.invalidate();
        this.C = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.D = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.E = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}