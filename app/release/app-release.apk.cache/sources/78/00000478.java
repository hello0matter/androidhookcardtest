package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;
import m1.c;
import n1.a;
import n1.d;
import n1.g;
import n1.h;
import n1.i;

@Deprecated
/* loaded from: classes.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f2856a;

    /* renamed from: b  reason: collision with root package name */
    public final SensorManager f2857b;

    /* renamed from: c  reason: collision with root package name */
    public final Sensor f2858c;

    /* renamed from: d  reason: collision with root package name */
    public final d f2859d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f2860e;

    /* renamed from: f  reason: collision with root package name */
    public final g f2861f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f2862g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f2863h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2864i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2865j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2866k;

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public final void a() {
        boolean z4 = this.f2864i && this.f2865j;
        Sensor sensor = this.f2858c;
        if (sensor == null || z4 == this.f2866k) {
            return;
        }
        d dVar = this.f2859d;
        SensorManager sensorManager = this.f2857b;
        if (z4) {
            sensorManager.registerListener(dVar, sensor, 0);
        } else {
            sensorManager.unregisterListener(dVar);
        }
        this.f2866k = z4;
    }

    public a getCameraMotionListener() {
        return this.f2861f;
    }

    public c getVideoFrameMetadataListener() {
        return this.f2861f;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f2863h;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2860e.post(new androidx.activity.d(6, this));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.f2865j = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.f2865j = true;
        a();
    }

    public void setDefaultStereoMode(int i4) {
        this.f2861f.getClass();
    }

    public void setUseSensorRotation(boolean z4) {
        this.f2864i = z4;
        a();
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2856a = new CopyOnWriteArrayList();
        this.f2860e = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f2857b = sensorManager;
        Sensor defaultSensor = l1.d.f5272a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f2858c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g();
        this.f2861f = gVar;
        h hVar = new h(this, gVar);
        View.OnTouchListener iVar = new i(context, hVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f2859d = new d(windowManager.getDefaultDisplay(), iVar, hVar);
        this.f2864i = true;
        setEGLContextClientVersion(2);
        setRenderer(hVar);
        setOnTouchListener(iVar);
    }
}