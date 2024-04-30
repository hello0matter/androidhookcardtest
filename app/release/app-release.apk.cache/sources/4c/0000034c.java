package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import z.d;
import z.e;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public final int A;
    public boolean B;
    public float C;
    public float D;
    public final int E;

    /* renamed from: p  reason: collision with root package name */
    public int f2377p;

    /* renamed from: q  reason: collision with root package name */
    public final int f2378q;

    /* renamed from: r  reason: collision with root package name */
    public final int f2379r;

    /* renamed from: s  reason: collision with root package name */
    public final int f2380s;

    /* renamed from: t  reason: collision with root package name */
    public final int f2381t;

    /* renamed from: u  reason: collision with root package name */
    public final int f2382u;

    /* renamed from: v  reason: collision with root package name */
    public final Paint f2383v;

    /* renamed from: w  reason: collision with root package name */
    public final Rect f2384w;

    /* renamed from: x  reason: collision with root package name */
    public int f2385x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2386y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2387z;

    public PagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public final void c(int i4, float f4, boolean z4) {
        int height = getHeight();
        TextView textView = this.f2392c;
        int left = textView.getLeft();
        int i5 = this.f2382u;
        int i6 = height - this.f2378q;
        Rect rect = this.f2384w;
        rect.set(left - i5, i6, textView.getRight() + i5, height);
        super.c(i4, f4, z4);
        this.f2385x = (int) (Math.abs(f4 - 0.5f) * 2.0f * 255.0f);
        rect.union(textView.getLeft() - i5, i6, textView.getRight() + i5, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f2386y;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f2381t);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f2377p;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i4;
        super.onDraw(canvas);
        int height = getHeight();
        TextView textView = this.f2392c;
        int left = textView.getLeft();
        int right = textView.getRight() + this.f2382u;
        Paint paint = this.f2383v;
        paint.setColor((this.f2385x << 24) | (this.f2377p & 16777215));
        float f4 = right;
        float f5 = height;
        canvas.drawRect(left - i4, height - this.f2378q, f4, f5, paint);
        if (this.f2386y) {
            paint.setColor((this.f2377p & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.A, getWidth() - getPaddingRight(), f5, paint);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewPager viewPager;
        int currentItem;
        int action = motionEvent.getAction();
        if (action == 0 || !this.B) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            if (action == 0) {
                this.C = x4;
                this.D = y4;
                this.B = false;
            } else if (action == 1) {
                TextView textView = this.f2392c;
                int left = textView.getLeft();
                int i4 = this.f2382u;
                if (x4 < left - i4) {
                    viewPager = this.f2390a;
                    currentItem = viewPager.getCurrentItem() - 1;
                } else if (x4 > textView.getRight() + i4) {
                    viewPager = this.f2390a;
                    currentItem = viewPager.getCurrentItem() + 1;
                }
                viewPager.setCurrentItem(currentItem);
            } else if (action == 2) {
                float abs = Math.abs(x4 - this.C);
                int i5 = this.E;
                if (abs > i5 || Math.abs(y4 - this.D) > i5) {
                    this.B = true;
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        super.setBackgroundColor(i4);
        if (this.f2387z) {
            return;
        }
        this.f2386y = (i4 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2387z) {
            return;
        }
        this.f2386y = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        if (this.f2387z) {
            return;
        }
        this.f2386y = i4 == 0;
    }

    public void setDrawFullUnderline(boolean z4) {
        this.f2386y = z4;
        this.f2387z = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        int i8 = this.f2379r;
        if (i7 < i8) {
            i7 = i8;
        }
        super.setPadding(i4, i5, i6, i7);
    }

    public void setTabIndicatorColor(@ColorInt int i4) {
        this.f2377p = i4;
        this.f2383v.setColor(i4);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i4) {
        Context context = getContext();
        Object obj = e.f7215a;
        setTabIndicatorColor(d.a(context, i4));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i4) {
        int i5 = this.f2380s;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setTextSpacing(i4);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f2383v = paint;
        this.f2384w = new Rect();
        this.f2385x = 255;
        this.f2386y = false;
        this.f2387z = false;
        int i4 = this.f2402m;
        this.f2377p = i4;
        paint.setColor(i4);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2378q = (int) ((3.0f * f4) + 0.5f);
        this.f2379r = (int) ((6.0f * f4) + 0.5f);
        this.f2380s = (int) (64.0f * f4);
        this.f2382u = (int) ((16.0f * f4) + 0.5f);
        this.A = (int) ((1.0f * f4) + 0.5f);
        this.f2381t = (int) ((f4 * 32.0f) + 0.5f);
        this.E = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f2391b.setFocusable(true);
        this.f2391b.setOnClickListener(new f1.b(this, 0));
        this.f2393d.setFocusable(true);
        this.f2393d.setOnClickListener(new f1.b(this, 1));
        if (getBackground() == null) {
            this.f2386y = true;
        }
    }
}