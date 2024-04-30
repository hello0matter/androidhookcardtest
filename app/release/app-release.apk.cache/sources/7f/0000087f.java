package m1;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import androidx.activity.j;
import com.google.android.exoplayer2.util.GlUtil$GlException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public final class a implements GLSurfaceView.Renderer {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f5442h = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f5443i = (FloatBuffer) ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f}).flip();

    /* renamed from: a  reason: collision with root package name */
    public final GLSurfaceView f5444a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f5445b = new int[3];

    /* renamed from: c  reason: collision with root package name */
    public final int[] f5446c = new int[3];

    /* renamed from: d  reason: collision with root package name */
    public final int[] f5447d = new int[3];

    /* renamed from: e  reason: collision with root package name */
    public final int[] f5448e = new int[3];

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference f5449f = new AtomicReference();

    /* renamed from: g  reason: collision with root package name */
    public l1.b f5450g;

    public a(GLSurfaceView gLSurfaceView) {
        this.f5444a = gLSurfaceView;
        for (int i4 = 0; i4 < 3; i4++) {
            int[] iArr = this.f5447d;
            this.f5448e[i4] = -1;
            iArr[i4] = -1;
        }
    }

    public final void a() {
        int[] iArr = this.f5445b;
        try {
            GLES20.glGenTextures(3, iArr, 0);
            for (int i4 = 0; i4 < 3; i4++) {
                l1.b bVar = this.f5450g;
                GLES20.glUniform1i(GLES20.glGetUniformLocation(bVar.f5266a, f5442h[i4]), i4);
                GLES20.glActiveTexture(33984 + i4);
                com.google.common.collect.c.s(3553, iArr[i4]);
            }
            com.google.common.collect.c.B();
        } catch (GlUtil$GlException e4) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures", e4);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        j.f(this.f5449f.getAndSet(null));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i4, int i5) {
        GLES20.glViewport(0, 0, i4, i5);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = this.f5446c;
        try {
            l1.b bVar = new l1.b("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f5450g = bVar;
            GLES20.glVertexAttribPointer(bVar.b("in_pos"), 2, 5126, false, 0, (Buffer) f5443i);
            iArr[0] = this.f5450g.b("in_tc_y");
            iArr[1] = this.f5450g.b("in_tc_u");
            iArr[2] = this.f5450g.b("in_tc_v");
            GLES20.glGetUniformLocation(this.f5450g.f5266a, "mColorConversion");
            com.google.common.collect.c.B();
            a();
            com.google.common.collect.c.B();
        } catch (GlUtil$GlException e4) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e4);
        }
    }
}