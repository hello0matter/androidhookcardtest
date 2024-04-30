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
import androidx.appcompat.widget.AppCompatImageButton;
import s.a;
import s.c;
import t.k;

/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: d  reason: collision with root package name */
    public final c f1174d;

    /* renamed from: e  reason: collision with root package name */
    public float f1175e;

    /* renamed from: f  reason: collision with root package name */
    public float f1176f;

    /* renamed from: g  reason: collision with root package name */
    public float f1177g;

    /* renamed from: h  reason: collision with root package name */
    public Path f1178h;

    /* renamed from: i  reason: collision with root package name */
    public a f1179i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f1180j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable[] f1181k;

    /* renamed from: l  reason: collision with root package name */
    public LayerDrawable f1182l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1183m;

    public ImageFilterButton(Context context) {
        super(context);
        this.f1174d = new c();
        this.f1175e = 0.0f;
        this.f1176f = 0.0f;
        this.f1177g = Float.NaN;
        this.f1183m = true;
        a(null);
    }

    private void setOverlay(boolean z4) {
        this.f1183m = z4;
    }

    public final void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6653f);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 3) {
                    this.f1175e = obtainStyledAttributes.getFloat(index, 0.0f);
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
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1183m));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f1181k = drawableArr;
                drawableArr[0] = getDrawable();
                this.f1181k[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f1181k);
                this.f1182l = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f1175e * 255.0f));
                super.setImageDrawable(this.f1182l);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f1174d.f6494f;
    }

    public float getCrossfade() {
        return this.f1175e;
    }

    public float getRound() {
        return this.f1177g;
    }

    public float getRoundPercent() {
        return this.f1176f;
    }

    public float getSaturation() {
        return this.f1174d.f6493e;
    }

    public float getWarmth() {
        return this.f1174d.f6495g;
    }

    public void setBrightness(float f4) {
        c cVar = this.f1174d;
        cVar.f6492d = f4;
        cVar.a(this);
    }

    public void setContrast(float f4) {
        c cVar = this.f1174d;
        cVar.f6494f = f4;
        cVar.a(this);
    }

    public void setCrossfade(float f4) {
        this.f1175e = f4;
        if (this.f1181k != null) {
            if (!this.f1183m) {
                this.f1182l.getDrawable(0).setAlpha((int) ((1.0f - this.f1175e) * 255.0f));
            }
            this.f1182l.getDrawable(1).setAlpha((int) (this.f1175e * 255.0f));
            super.setImageDrawable(this.f1182l);
        }
    }

    @RequiresApi(21)
    public void setRound(float f4) {
        if (Float.isNaN(f4)) {
            this.f1177g = f4;
            float f5 = this.f1176f;
            this.f1176f = -1.0f;
            setRoundPercent(f5);
            return;
        }
        boolean z4 = this.f1177g != f4;
        this.f1177g = f4;
        if (f4 != 0.0f) {
            if (this.f1178h == null) {
                this.f1178h = new Path();
            }
            if (this.f1180j == null) {
                this.f1180j = new RectF();
            }
            if (this.f1179i == null) {
                a aVar = new a(this, 1);
                this.f1179i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            this.f1180j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1178h.reset();
            Path path = this.f1178h;
            RectF rectF = this.f1180j;
            float f6 = this.f1177g;
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
        boolean z4 = this.f1176f != f4;
        this.f1176f = f4;
        if (f4 != 0.0f) {
            if (this.f1178h == null) {
                this.f1178h = new Path();
            }
            if (this.f1180j == null) {
                this.f1180j = new RectF();
            }
            if (this.f1179i == null) {
                a aVar = new a(this, 0);
                this.f1179i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1176f) / 2.0f;
            this.f1180j.set(0.0f, 0.0f, width, height);
            this.f1178h.reset();
            this.f1178h.addRoundRect(this.f1180j, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f4) {
        c cVar = this.f1174d;
        cVar.f6493e = f4;
        cVar.a(this);
    }

    public void setWarmth(float f4) {
        c cVar = this.f1174d;
        cVar.f6495g = f4;
        cVar.a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1174d = new c();
        this.f1175e = 0.0f;
        this.f1176f = 0.0f;
        this.f1177g = Float.NaN;
        this.f1183m = true;
        a(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1174d = new c();
        this.f1175e = 0.0f;
        this.f1176f = 0.0f;
        this.f1177g = Float.NaN;
        this.f1183m = true;
        a(attributeSet);
    }
}