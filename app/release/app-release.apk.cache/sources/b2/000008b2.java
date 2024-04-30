package n1;

import android.opengl.GLES20;
import android.util.Log;
import com.google.android.exoplayer2.util.GlUtil$GlException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public l1.b f5750a;

    public final void a() {
        try {
            l1.b bVar = new l1.b("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f5750a = bVar;
            GLES20.glGetUniformLocation(bVar.f5266a, "uMvpMatrix");
            GLES20.glGetUniformLocation(this.f5750a.f5266a, "uTexMatrix");
            this.f5750a.b("aPosition");
            this.f5750a.b("aTexCoords");
            GLES20.glGetUniformLocation(this.f5750a.f5266a, "uTexture");
        } catch (GlUtil$GlException e4) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e4);
        }
    }
}