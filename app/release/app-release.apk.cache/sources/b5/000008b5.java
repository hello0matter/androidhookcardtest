package n1;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import androidx.activity.j;
import androidx.appcompat.app.l0;
import com.google.android.exoplayer2.util.GlUtil$GlException;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public final class h implements GLSurfaceView.Renderer, c {

    /* renamed from: a  reason: collision with root package name */
    public final g f5762a;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f5765d;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f5766e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f5767f;

    /* renamed from: g  reason: collision with root package name */
    public float f5768g;

    /* renamed from: h  reason: collision with root package name */
    public float f5769h;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f5772k;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f5763b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final float[] f5764c = new float[16];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f5770i = new float[16];

    /* renamed from: j  reason: collision with root package name */
    public final float[] f5771j = new float[16];

    public h(SphericalGLSurfaceView sphericalGLSurfaceView, g gVar) {
        this.f5772k = sphericalGLSurfaceView;
        float[] fArr = new float[16];
        this.f5765d = fArr;
        float[] fArr2 = new float[16];
        this.f5766e = fArr2;
        float[] fArr3 = new float[16];
        this.f5767f = fArr3;
        this.f5762a = gVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f5769h = 3.1415927f;
    }

    @Override // n1.c
    public final synchronized void a(float f4, float[] fArr) {
        float[] fArr2 = this.f5765d;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f5 = -f4;
        this.f5769h = f5;
        Matrix.setRotateM(this.f5766e, 0, -this.f5768g, (float) Math.cos(f5), (float) Math.sin(this.f5769h), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        Object a5;
        Object a6;
        Object a7;
        synchronized (this) {
            Matrix.multiplyMM(this.f5771j, 0, this.f5765d, 0, this.f5767f, 0);
            Matrix.multiplyMM(this.f5770i, 0, this.f5766e, 0, this.f5771j, 0);
        }
        Matrix.multiplyMM(this.f5764c, 0, this.f5763b, 0, this.f5770i, 0);
        g gVar = this.f5762a;
        float[] fArr = this.f5764c;
        gVar.getClass();
        GLES20.glClear(16384);
        try {
            com.google.common.collect.c.B();
        } catch (GlUtil$GlException e4) {
            l1.c.a("Failed to draw a frame", e4);
        }
        if (gVar.f5752a.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = gVar.f5761j;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            try {
                com.google.common.collect.c.B();
            } catch (GlUtil$GlException e5) {
                l1.c.a("Failed to draw a frame", e5);
            }
            if (gVar.f5753b.compareAndSet(true, false)) {
                Matrix.setIdentityM(gVar.f5758g, 0);
            }
            long timestamp = gVar.f5761j.getTimestamp();
            androidx.activity.result.h hVar = gVar.f5756e;
            synchronized (hVar) {
                a5 = hVar.a(timestamp, false);
            }
            Long l4 = (Long) a5;
            if (l4 != null) {
                b bVar = gVar.f5755d;
                float[] fArr2 = gVar.f5758g;
                long longValue = l4.longValue();
                androidx.activity.result.h hVar2 = bVar.f5741c;
                synchronized (hVar2) {
                    a7 = hVar2.a(longValue, true);
                }
                float[] fArr3 = (float[]) a7;
                if (fArr3 != null) {
                    float f4 = fArr3[0];
                    float f5 = -fArr3[1];
                    float f6 = -fArr3[2];
                    float length = Matrix.length(f4, f5, f6);
                    int i4 = (length > 0.0f ? 1 : (length == 0.0f ? 0 : -1));
                    float[] fArr4 = bVar.f5740b;
                    if (i4 != 0) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f4 / length, f5 / length, f6 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!bVar.f5742d) {
                        b.a(bVar.f5739a, bVar.f5740b);
                        bVar.f5742d = true;
                    }
                    Matrix.multiplyMM(fArr2, 0, bVar.f5739a, 0, bVar.f5740b, 0);
                }
            }
            androidx.activity.result.h hVar3 = gVar.f5757f;
            synchronized (hVar3) {
                a6 = hVar3.a(timestamp, true);
            }
            j.f(a6);
        }
        Matrix.multiplyMM(gVar.f5759h, 0, fArr, 0, gVar.f5758g, 0);
        gVar.f5754c.getClass();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i4, int i5) {
        float f4;
        GLES20.glViewport(0, 0, i4, i5);
        float f5 = i4 / i5;
        if (f5 > 1.0f) {
            f4 = (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f5)) * 2.0d);
        } else {
            f4 = 90.0f;
        }
        Matrix.perspectiveM(this.f5763b, 0, f4, f5, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f5772k;
        sphericalGLSurfaceView.f2860e.post(new l0(4, sphericalGLSurfaceView, this.f5762a.a()));
    }
}