package n1;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil$GlException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class g implements m1.c, a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f5752a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f5753b = new AtomicBoolean(true);

    /* renamed from: c  reason: collision with root package name */
    public final e f5754c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final b f5755d = new b();

    /* renamed from: e  reason: collision with root package name */
    public final androidx.activity.result.h f5756e = new androidx.activity.result.h();

    /* renamed from: f  reason: collision with root package name */
    public final androidx.activity.result.h f5757f = new androidx.activity.result.h();

    /* renamed from: g  reason: collision with root package name */
    public final float[] f5758g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    public final float[] f5759h = new float[16];

    /* renamed from: i  reason: collision with root package name */
    public int f5760i;

    /* renamed from: j  reason: collision with root package name */
    public SurfaceTexture f5761j;

    public final SurfaceTexture a() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            com.google.common.collect.c.B();
            this.f5754c.a();
            com.google.common.collect.c.B();
        } catch (GlUtil$GlException e4) {
            l1.c.a("Failed to initialize the renderer", e4);
        }
        if (!l1.d.a(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            com.google.common.collect.c.B();
            int i4 = iArr[0];
            com.google.common.collect.c.s(36197, i4);
            this.f5760i = i4;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f5760i);
            this.f5761j = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: n1.f
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    g.this.f5752a.set(true);
                }
            });
            return this.f5761j;
        }
        throw new Exception("No current context");
    }
}