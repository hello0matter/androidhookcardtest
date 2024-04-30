package h2;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.provider.Settings;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends k {

    /* renamed from: q  reason: collision with root package name */
    public static final h f4844q = new g0.i("indicatorLevel");

    /* renamed from: l  reason: collision with root package name */
    public final l f4845l;

    /* renamed from: m  reason: collision with root package name */
    public final q0.j f4846m;

    /* renamed from: n  reason: collision with root package name */
    public final q0.i f4847n;

    /* renamed from: o  reason: collision with root package name */
    public float f4848o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4849p;

    /* JADX WARN: Type inference failed for: r0v4, types: [q0.h, q0.i] */
    public i(Context context, d dVar, l lVar) {
        super(context, dVar);
        this.f4849p = false;
        this.f4845l = lVar;
        lVar.f4864b = this;
        q0.j jVar = new q0.j();
        this.f4846m = jVar;
        jVar.f6321b = 1.0f;
        jVar.f6322c = false;
        jVar.f6320a = Math.sqrt(50.0f);
        jVar.f6322c = false;
        ?? hVar = new q0.h(this);
        hVar.f6318s = Float.MAX_VALUE;
        hVar.f6319t = false;
        this.f4847n = hVar;
        hVar.f6317r = jVar;
        if (this.f4860h != 1.0f) {
            this.f4860h = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            l lVar = this.f4845l;
            Rect bounds = getBounds();
            float b5 = b();
            lVar.f4863a.a();
            lVar.a(canvas, bounds, b5);
            l lVar2 = this.f4845l;
            Paint paint = this.f4861i;
            lVar2.c(canvas, paint);
            this.f4845l.b(canvas, paint, 0.0f, this.f4848o, y1.a.a(this.f4854b.f4821c[0], this.f4862j));
            canvas.restore();
        }
    }

    @Override // h2.k
    public final boolean f(boolean z4, boolean z5, boolean z6) {
        boolean f4 = super.f(z4, z5, z6);
        a aVar = this.f4855c;
        ContentResolver contentResolver = this.f4853a.getContentResolver();
        aVar.getClass();
        float f5 = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (f5 == 0.0f) {
            this.f4849p = true;
        } else {
            this.f4849p = false;
            float f6 = 50.0f / f5;
            q0.j jVar = this.f4846m;
            jVar.getClass();
            if (f6 > 0.0f) {
                jVar.f6320a = Math.sqrt(f6);
                jVar.f6322c = false;
            } else {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
        }
        return f4;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f4845l.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f4845l.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f4847n.b();
        this.f4848o = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i4) {
        boolean z4 = this.f4849p;
        q0.i iVar = this.f4847n;
        if (z4) {
            iVar.b();
            this.f4848o = i4 / 10000.0f;
            invalidateSelf();
        } else {
            iVar.f6307b = this.f4848o * 10000.0f;
            iVar.f6308c = true;
            float f4 = i4;
            if (iVar.f6311f) {
                iVar.f6318s = f4;
            } else {
                if (iVar.f6317r == null) {
                    iVar.f6317r = new q0.j(f4);
                }
                q0.j jVar = iVar.f6317r;
                double d4 = f4;
                jVar.f6328i = d4;
                double d5 = (float) d4;
                if (d5 <= Float.MAX_VALUE) {
                    float f5 = iVar.f6312g;
                    if (d5 >= f5) {
                        double abs = Math.abs(iVar.f6314i * 0.75f);
                        jVar.f6323d = abs;
                        jVar.f6324e = abs * 62.5d;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            boolean z5 = iVar.f6311f;
                            if (!z5 && !z5) {
                                iVar.f6311f = true;
                                if (!iVar.f6308c) {
                                    iVar.f6307b = iVar.f6310e.b(iVar.f6309d);
                                }
                                float f6 = iVar.f6307b;
                                if (f6 <= Float.MAX_VALUE && f6 >= f5) {
                                    ThreadLocal threadLocal = q0.d.f6290g;
                                    if (threadLocal.get() == null) {
                                        threadLocal.set(new q0.d());
                                    }
                                    q0.d dVar = (q0.d) threadLocal.get();
                                    ArrayList arrayList = dVar.f6292b;
                                    if (arrayList.size() == 0) {
                                        if (dVar.f6294d == null) {
                                            dVar.f6294d = new q0.c(dVar.f6293c);
                                        }
                                        dVar.f6294d.e();
                                    }
                                    if (!arrayList.contains(iVar)) {
                                        arrayList.add(iVar);
                                    }
                                } else {
                                    throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                                }
                            }
                        } else {
                            throw new AndroidRuntimeException("Animations may only be started on the main thread");
                        }
                    } else {
                        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                    }
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
                }
            }
        }
        return true;
    }
}