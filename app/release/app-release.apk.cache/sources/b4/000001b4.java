package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import s.b;
import s.c;
import t.k;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: d  reason: collision with root package name */
    public final c f1184d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1185e;

    /* renamed from: f  reason: collision with root package name */
    public float f1186f;

    /* renamed from: g  reason: collision with root package name */
    public float f1187g;

    /* renamed from: h  reason: collision with root package name */
    public float f1188h;

    /* renamed from: i  reason: collision with root package name */
    public Path f1189i;

    /* renamed from: j  reason: collision with root package name */
    public b f1190j;

    /* renamed from: k  reason: collision with root package name */
    public RectF f1191k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable[] f1192l;

    /* renamed from: m  reason: collision with root package name */
    public LayerDrawable f1193m;

    public ImageFilterView(Context context) {
        super(context);
        this.f1184d = new c();
        this.f1185e = true;
        this.f1186f = 0.0f;
        this.f1187g = 0.0f;
        this.f1188h = Float.NaN;
    }

    private void setOverlay(boolean z4) {
        this.f1185e = z4;
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6653f);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 3) {
                    this.f1186f = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == 8) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 7) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 2) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 5) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 6) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 4) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1185e));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f1192l = drawableArr;
                drawableArr[0] = getDrawable();
                this.f1192l[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f1192l);
                this.f1193m = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f1186f * 255.0f));
                super.setImageDrawable(this.f1193m);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f1184d.f6492d;
    }

    public float getContrast() {
        return this.f1184d.f6494f;
    }

    public float getCrossfade() {
        return this.f1186f;
    }

    public float getRound() {
        return this.f1188h;
    }

    public float getRoundPercent() {
        return this.f1187g;
    }

    public float getSaturation() {
        return this.f1184d.f6493e;
    }

    public float getWarmth() {
        return this.f1184d.f6495g;
    }

    public void setBrightness(float f4) {
        c cVar = this.f1184d;
        cVar.f6492d = f4;
        cVar.a(this);
    }

    public void setContrast(float f4) {
        c cVar = this.f1184d;
        cVar.f6494f = f4;
        cVar.a(this);
    }

    public void setCrossfade(float f4) {
        this.f1186f = f4;
        if (this.f1192l != null) {
            if (!this.f1185e) {
                this.f1193m.getDrawable(0).setAlpha((int) ((1.0f - this.f1186f) * 255.0f));
            }
            this.f1193m.getDrawable(1).setAlpha((int) (this.f1186f * 255.0f));
            super.setImageDrawable(this.f1193m);
        }
    }

    @RequiresApi(21)
    public void setRound(float f4) {
        if (Float.isNaN(f4)) {
            this.f1188h = f4;
            float f5 = this.f1187g;
            this.f1187g = -1.0f;
            setRoundPercent(f5);
            return;
        }
        boolean z4 = this.f1188h != f4;
        this.f1188h = f4;
        if (f4 != 0.0f) {
            if (this.f1189i == null) {
                this.f1189i = new Path();
            }
            if (this.f1191k == null) {
                this.f1191k = new RectF();
            }
            if (this.f1190j == null) {
                b bVar = new b(this, 1);
                this.f1190j = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f1191k.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1189i.reset();
            Path path = this.f1189i;
            RectF rectF = this.f1191k;
            float f6 = this.f1188h;
            path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f4) {
        boolean z4 = this.f1187g != f4;
        this.f1187g = f4;
        if (f4 != 0.0f) {
            if (this.f1189i == null) {
                this.f1189i = new Path();
            }
            if (this.f1191k == null) {
                this.f1191k = new RectF();
            }
            if (this.f1190j == null) {
                b bVar = new b(this, 0);
                this.f1190j = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1187g) / 2.0f;
            this.f1191k.set(0.0f, 0.0f, width, height);
            this.f1189i.reset();
            this.f1189i.addRoundRect(this.f1191k, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f4) {
        c cVar = this.f1184d;
        cVar.f6493e = f4;
        cVar.a(this);
    }

    public void setWarmth(float f4) {
        c cVar = this.f1184d;
        cVar.f6495g = f4;
        cVar.a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1184d = new c();
        this.f1185e = true;
        this.f1186f = 0.0f;
        this.f1187g = 0.0f;
        this.f1188h = Float.NaN;
        c(attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1184d = new c();
        this.f1185e = true;
        this.f1186f = 0.0f;
        this.f1187g = 0.0f;
        this.f1188h = Float.NaN;
        c(attributeSet);
    }
}