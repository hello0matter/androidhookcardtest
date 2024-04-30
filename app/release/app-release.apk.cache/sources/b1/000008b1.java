package n1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* loaded from: classes.dex */
public final class d implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f5743a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f5744b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final float[] f5745c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    public final float[] f5746d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public final Display f5747e;

    /* renamed from: f  reason: collision with root package name */
    public final c[] f5748f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5749g;

    public d(Display display, c... cVarArr) {
        this.f5747e = display;
        this.f5748f = cVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i4;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f5743a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f5747e.getRotation();
        float[] fArr3 = this.f5744b;
        if (rotation != 0) {
            int i5 = 129;
            if (rotation != 1) {
                i4 = 130;
                if (rotation != 2) {
                    if (rotation == 3) {
                        i5 = 130;
                        i4 = 1;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            } else {
                i4 = 129;
                i5 = 2;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i5, i4, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f5746d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f4 = fArr4[2];
        Matrix.rotateM(this.f5743a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z4 = this.f5749g;
        float[] fArr5 = this.f5743a;
        if (!z4) {
            b.a(this.f5745c, fArr5);
            this.f5749g = true;
        }
        System.arraycopy(fArr5, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr5, 0, this.f5744b, 0, this.f5745c, 0);
        for (c cVar : this.f5748f) {
            cVar.a(f4, fArr2);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i4) {
    }
}