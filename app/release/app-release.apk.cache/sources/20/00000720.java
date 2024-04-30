package h2;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import androidx.appcompat.widget.j3;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class k extends Drawable implements Animatable {

    /* renamed from: k */
    public static final j3 f4852k = new j3(Float.class, "growFraction", 17);

    /* renamed from: a */
    public final Context f4853a;

    /* renamed from: b */
    public final d f4854b;

    /* renamed from: d */
    public ValueAnimator f4856d;

    /* renamed from: e */
    public ValueAnimator f4857e;

    /* renamed from: f */
    public ArrayList f4858f;

    /* renamed from: g */
    public boolean f4859g;

    /* renamed from: h */
    public float f4860h;

    /* renamed from: j */
    public int f4862j;

    /* renamed from: i */
    public final Paint f4861i = new Paint();

    /* renamed from: c */
    public a f4855c = new Object();

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, h2.a] */
    public k(Context context, d dVar) {
        this.f4853a = context;
        this.f4854b = dVar;
        setAlpha(255);
    }

    public final float b() {
        d dVar = this.f4854b;
        if (dVar.f4823e != 0 || dVar.f4824f != 0) {
            return this.f4860h;
        }
        return 1.0f;
    }

    public final boolean c() {
        ValueAnimator valueAnimator = this.f4857e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        ValueAnimator valueAnimator = this.f4856d;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    public final boolean e(boolean z4, boolean z5, boolean z6) {
        boolean z7;
        a aVar = this.f4855c;
        ContentResolver contentResolver = this.f4853a.getContentResolver();
        aVar.getClass();
        float f4 = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (z6 && f4 > 0.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        return f(z4, z5, z7);
    }

    public boolean f(boolean z4, boolean z5, boolean z6) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z7;
        ValueAnimator valueAnimator3 = this.f4856d;
        j3 j3Var = f4852k;
        if (valueAnimator3 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, j3Var, 0.0f, 1.0f);
            this.f4856d = ofFloat;
            ofFloat.setDuration(500L);
            this.f4856d.setInterpolator(p1.a.f6129b);
            ValueAnimator valueAnimator4 = this.f4856d;
            if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f4856d = valueAnimator4;
            valueAnimator4.addListener(new j(this, 0));
        }
        if (this.f4857e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, j3Var, 1.0f, 0.0f);
            this.f4857e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f4857e.setInterpolator(p1.a.f6129b);
            ValueAnimator valueAnimator5 = this.f4857e;
            if (valueAnimator5 != null && valueAnimator5.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.f4857e = valueAnimator5;
            valueAnimator5.addListener(new j(this, 1));
        }
        if (!isVisible() && !z4) {
            return false;
        }
        if (z4) {
            valueAnimator = this.f4856d;
        } else {
            valueAnimator = this.f4857e;
        }
        if (z4) {
            valueAnimator2 = this.f4857e;
        } else {
            valueAnimator2 = this.f4856d;
        }
        if (!z6) {
            if (valueAnimator2.isRunning()) {
                boolean z8 = this.f4859g;
                this.f4859g = true;
                new ValueAnimator[]{valueAnimator2}[0].cancel();
                this.f4859g = z8;
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                boolean z9 = this.f4859g;
                this.f4859g = true;
                new ValueAnimator[]{valueAnimator}[0].end();
                this.f4859g = z9;
            }
            return super.setVisible(z4, false);
        } else if (z6 && valueAnimator.isRunning()) {
            return false;
        } else {
            if (z4 && !super.setVisible(z4, false)) {
                z7 = false;
            } else {
                z7 = true;
            }
            d dVar = this.f4854b;
            if (!z4 ? dVar.f4824f != 0 : dVar.f4823e != 0) {
                if (!z5 && valueAnimator.isPaused()) {
                    valueAnimator.resume();
                } else {
                    valueAnimator.start();
                }
                return z7;
            }
            boolean z10 = this.f4859g;
            this.f4859g = true;
            new ValueAnimator[]{valueAnimator}[0].end();
            this.f4859g = z10;
            return z7;
        }
    }

    public final void g(c cVar) {
        ArrayList arrayList = this.f4858f;
        if (arrayList != null && arrayList.contains(cVar)) {
            this.f4858f.remove(cVar);
            if (this.f4858f.isEmpty()) {
                this.f4858f = null;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f4862j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        if (!d() && !c()) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f4862j = i4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4861i.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        return e(z4, z5, true);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        f(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        f(false, true, false);
    }
}