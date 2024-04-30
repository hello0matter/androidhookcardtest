package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.activity.j;
import androidx.annotation.Nullable;
import m1.a;
import m1.b;

@Deprecated
/* loaded from: classes.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements b {

    /* renamed from: a  reason: collision with root package name */
    public final a f2855a;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(j1.a aVar) {
        a aVar2 = this.f2855a;
        j.f(aVar2.f5449f.getAndSet(aVar));
        aVar2.f5444a.requestRender();
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f2855a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public b getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}