package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public final class h0 extends f0 {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f759d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f760e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f761f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f762g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f763h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f764i;

    public h0(SeekBar seekBar) {
        super(seekBar);
        this.f761f = null;
        this.f762g = null;
        this.f763h = false;
        this.f764i = false;
        this.f759d = seekBar;
    }

    @Override // androidx.appcompat.widget.f0
    public final void a(AttributeSet attributeSet, int i4) {
        super.a(attributeSet, i4);
        SeekBar seekBar = this.f759d;
        Context context = seekBar.getContext();
        int[] iArr = c.a.f2550h;
        q3 f4 = q3.f(context, attributeSet, iArr, i4, 0);
        i0.y0.o(seekBar, seekBar.getContext(), iArr, attributeSet, f4.f879b, i4);
        Drawable c4 = f4.c(0);
        if (c4 != null) {
            seekBar.setThumb(c4);
        }
        Drawable b5 = f4.b(1);
        Drawable drawable = this.f760e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f760e = b5;
        if (b5 != null) {
            b5.setCallback(seekBar);
            c0.c.b(b5, i0.h0.d(seekBar));
            if (b5.isStateful()) {
                b5.setState(seekBar.getDrawableState());
            }
            c();
        }
        seekBar.invalidate();
        TypedArray typedArray = f4.f879b;
        if (typedArray.hasValue(3)) {
            this.f762g = o1.c(typedArray.getInt(3, -1), this.f762g);
            this.f764i = true;
        }
        if (typedArray.hasValue(2)) {
            this.f761f = f4.a(2);
            this.f763h = true;
        }
        f4.g();
        c();
    }

    public final void c() {
        Drawable drawable = this.f760e;
        if (drawable != null) {
            if (this.f763h || this.f764i) {
                Drawable mutate = drawable.mutate();
                this.f760e = mutate;
                if (this.f763h) {
                    c0.b.h(mutate, this.f761f);
                }
                if (this.f764i) {
                    c0.b.i(this.f760e, this.f762g);
                }
                if (this.f760e.isStateful()) {
                    this.f760e.setState(this.f759d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f760e != null) {
            SeekBar seekBar = this.f759d;
            int max = seekBar.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f760e.getIntrinsicWidth();
                int intrinsicHeight = this.f760e.getIntrinsicHeight();
                int i4 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i5 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f760e.setBounds(-i4, -i5, i4, i5);
                float width = ((seekBar.getWidth() - seekBar.getPaddingLeft()) - seekBar.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(seekBar.getPaddingLeft(), seekBar.getHeight() / 2);
                for (int i6 = 0; i6 <= max; i6++) {
                    this.f760e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}