package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import f1.c;
import f1.h;
import java.util.ArrayList;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f2388n = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: o  reason: collision with root package name */
    public static final int[] f2389o = {16843660};

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f2390a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f2391b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f2392c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f2393d;

    /* renamed from: e  reason: collision with root package name */
    public int f2394e;

    /* renamed from: f  reason: collision with root package name */
    public float f2395f;

    /* renamed from: g  reason: collision with root package name */
    public int f2396g;

    /* renamed from: h  reason: collision with root package name */
    public int f2397h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2398i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2399j;

    /* renamed from: k  reason: collision with root package name */
    public final c f2400k;

    /* renamed from: l  reason: collision with root package name */
    public int f2401l;

    /* renamed from: m  reason: collision with root package name */
    public int f2402m;

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.text.method.SingleLineTransformationMethod, f1.d, android.text.method.TransformationMethod] */
    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        ?? singleLineTransformationMethod = new SingleLineTransformationMethod();
        singleLineTransformationMethod.f4546a = context.getResources().getConfiguration().locale;
        textView.setTransformationMethod(singleLineTransformationMethod);
    }

    public final void a() {
        ViewPager viewPager = this.f2390a;
        if (viewPager != null) {
            this.f2394e = -1;
            this.f2395f = -1.0f;
            b(viewPager.getCurrentItem());
            requestLayout();
        }
    }

    public final void b(int i4) {
        this.f2398i = true;
        TextView textView = this.f2391b;
        textView.setText((CharSequence) null);
        TextView textView2 = this.f2392c;
        textView2.setText((CharSequence) null);
        TextView textView3 = this.f2393d;
        textView3.setText((CharSequence) null);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        textView.measure(makeMeasureSpec, makeMeasureSpec2);
        textView2.measure(makeMeasureSpec, makeMeasureSpec2);
        textView3.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f2394e = i4;
        if (!this.f2399j) {
            c(i4, this.f2395f, false);
        }
        this.f2398i = false;
    }

    public void c(int i4, float f4, boolean z4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (i4 != this.f2394e) {
            this.f2390a.getAdapter();
            b(i4);
        } else if (!z4 && f4 == this.f2395f) {
            return;
        }
        this.f2399j = true;
        TextView textView = this.f2391b;
        int measuredWidth = textView.getMeasuredWidth();
        TextView textView2 = this.f2392c;
        int measuredWidth2 = textView2.getMeasuredWidth();
        TextView textView3 = this.f2393d;
        int measuredWidth3 = textView3.getMeasuredWidth();
        int i9 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i10 = paddingRight + i9;
        int i11 = (width - (paddingLeft + i9)) - i10;
        float f5 = f4 + 0.5f;
        if (f5 > 1.0f) {
            f5 -= 1.0f;
        }
        int i12 = ((width - i10) - ((int) (i11 * f5))) - i9;
        int i13 = measuredWidth2 + i12;
        int baseline = textView.getBaseline();
        int baseline2 = textView2.getBaseline();
        int baseline3 = textView3.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i14 = max - baseline;
        int i15 = max - baseline2;
        int i16 = max - baseline3;
        int max2 = Math.max(Math.max(textView.getMeasuredHeight() + i14, textView2.getMeasuredHeight() + i15), textView3.getMeasuredHeight() + i16);
        int i17 = this.f2397h & 112;
        if (i17 == 16) {
            i5 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i17 != 80) {
            i6 = i14 + paddingTop;
            i7 = i15 + paddingTop;
            i8 = paddingTop + i16;
            textView2.layout(i12, i7, i13, textView2.getMeasuredHeight() + i7);
            int min = Math.min(paddingLeft, (i12 - this.f2396g) - measuredWidth);
            textView.layout(min, i6, measuredWidth + min, textView.getMeasuredHeight() + i6);
            int max3 = Math.max((width - paddingRight) - measuredWidth3, i13 + this.f2396g);
            textView3.layout(max3, i8, max3 + measuredWidth3, textView3.getMeasuredHeight() + i8);
            this.f2395f = f4;
            this.f2399j = false;
        } else {
            i5 = (height - paddingBottom) - max2;
        }
        i6 = i14 + i5;
        i7 = i15 + i5;
        i8 = i5 + i16;
        textView2.layout(i12, i7, i13, textView2.getMeasuredHeight() + i7);
        int min2 = Math.min(paddingLeft, (i12 - this.f2396g) - measuredWidth);
        textView.layout(min2, i6, measuredWidth + min2, textView.getMeasuredHeight() + i6);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i13 + this.f2396g);
        textView3.layout(max32, i8, max32 + measuredWidth3, textView3.getMeasuredHeight() + i8);
        this.f2395f = f4;
        this.f2399j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f2396g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            viewPager.getAdapter();
            c cVar = this.f2400k;
            viewPager.F = cVar;
            if (viewPager.G == null) {
                viewPager.G = new ArrayList();
            }
            viewPager.G.add(cVar);
            this.f2390a = viewPager;
            a();
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f2390a;
        if (viewPager != null) {
            viewPager.getAdapter();
            a();
            ViewPager viewPager2 = this.f2390a;
            h hVar = viewPager2.F;
            viewPager2.F = null;
            ArrayList arrayList = viewPager2.G;
            if (arrayList != null) {
                arrayList.remove(this.f2400k);
            }
            this.f2390a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        if (this.f2390a != null) {
            float f4 = this.f2395f;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            c(this.f2394e, f4, true);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int max;
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingBottom, -2);
        int size = View.MeasureSpec.getSize(i4);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, (int) (size * 0.2f), -2);
        this.f2391b.measure(childMeasureSpec2, childMeasureSpec);
        TextView textView = this.f2392c;
        textView.measure(childMeasureSpec2, childMeasureSpec);
        this.f2393d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            max = View.MeasureSpec.getSize(i5);
        } else {
            max = Math.max(getMinHeight(), textView.getMeasuredHeight() + paddingBottom);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i5, textView.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f2398i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i4) {
        this.f2397h = i4;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        int i4 = ((int) (f4 * 255.0f)) & 255;
        this.f2401l = i4;
        int i5 = (i4 << 24) | (this.f2402m & 16777215);
        this.f2391b.setTextColor(i5);
        this.f2393d.setTextColor(i5);
    }

    public void setTextColor(@ColorInt int i4) {
        this.f2402m = i4;
        this.f2392c.setTextColor(i4);
        int i5 = (this.f2401l << 24) | (this.f2402m & 16777215);
        this.f2391b.setTextColor(i5);
        this.f2393d.setTextColor(i5);
    }

    public void setTextSize(int i4, float f4) {
        this.f2391b.setTextSize(i4, f4);
        this.f2392c.setTextSize(i4, f4);
        this.f2393d.setTextSize(i4, f4);
    }

    public void setTextSpacing(int i4) {
        this.f2396g = i4;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2394e = -1;
        this.f2395f = -1.0f;
        this.f2400k = new c(this);
        TextView textView = new TextView(context);
        this.f2391b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f2392c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f2393d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2388n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            textView.setTextAppearance(resourceId);
            textView2.setTextAppearance(resourceId);
            textView3.setTextAppearance(resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            textView3.setTextColor(color);
        }
        this.f2397h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f2402m = textView2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView2.setEllipsize(truncateAt);
        textView3.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f2389o);
            boolean z4 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
            if (z4) {
                setSingleLineAllCaps(textView);
                setSingleLineAllCaps(textView2);
                setSingleLineAllCaps(textView3);
                this.f2396g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
            }
        }
        textView.setSingleLine();
        textView2.setSingleLine();
        textView3.setSingleLine();
        this.f2396g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}