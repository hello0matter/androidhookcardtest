package d1;

import android.graphics.Paint;
import androidx.annotation.ColorInt;

/* loaded from: classes.dex */
public final class i extends l {

    /* renamed from: e  reason: collision with root package name */
    public a0.d f4269e;

    /* renamed from: f  reason: collision with root package name */
    public float f4270f;

    /* renamed from: g  reason: collision with root package name */
    public a0.d f4271g;

    /* renamed from: h  reason: collision with root package name */
    public float f4272h;

    /* renamed from: i  reason: collision with root package name */
    public float f4273i;

    /* renamed from: j  reason: collision with root package name */
    public float f4274j;

    /* renamed from: k  reason: collision with root package name */
    public float f4275k;

    /* renamed from: l  reason: collision with root package name */
    public float f4276l;

    /* renamed from: m  reason: collision with root package name */
    public Paint.Cap f4277m;

    /* renamed from: n  reason: collision with root package name */
    public Paint.Join f4278n;

    /* renamed from: o  reason: collision with root package name */
    public float f4279o;

    @Override // d1.k
    public final boolean a() {
        if (!this.f4271g.b() && !this.f4269e.b()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // d1.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(int[] r7) {
        /*
            r6 = this;
            a0.d r0 = r6.f4271g
            boolean r1 = r0.b()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1c
            android.content.res.ColorStateList r1 = r0.f14b
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f15c
            if (r1 == r4) goto L1c
            r0.f15c = r1
            r0 = r3
            goto L1d
        L1c:
            r0 = r2
        L1d:
            a0.d r1 = r6.f4269e
            boolean r4 = r1.b()
            if (r4 == 0) goto L36
            android.content.res.ColorStateList r4 = r1.f14b
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f15c
            if (r7 == r4) goto L36
            r1.f15c = r7
            r2 = r3
        L36:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.i.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f4273i;
    }

    @ColorInt
    public int getFillColor() {
        return this.f4271g.f15c;
    }

    public float getStrokeAlpha() {
        return this.f4272h;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.f4269e.f15c;
    }

    public float getStrokeWidth() {
        return this.f4270f;
    }

    public float getTrimPathEnd() {
        return this.f4275k;
    }

    public float getTrimPathOffset() {
        return this.f4276l;
    }

    public float getTrimPathStart() {
        return this.f4274j;
    }

    public void setFillAlpha(float f4) {
        this.f4273i = f4;
    }

    public void setFillColor(int i4) {
        this.f4271g.f15c = i4;
    }

    public void setStrokeAlpha(float f4) {
        this.f4272h = f4;
    }

    public void setStrokeColor(int i4) {
        this.f4269e.f15c = i4;
    }

    public void setStrokeWidth(float f4) {
        this.f4270f = f4;
    }

    public void setTrimPathEnd(float f4) {
        this.f4275k = f4;
    }

    public void setTrimPathOffset(float f4) {
        this.f4276l = f4;
    }

    public void setTrimPathStart(float f4) {
        this.f4274j = f4;
    }
}