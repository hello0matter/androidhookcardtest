package androidx.appcompat.app;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.VisibleForTesting;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.example.msphone.R;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes.dex */
public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f299a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f300b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f301c;

    public /* synthetic */ l0(int i4, Object obj, Object obj2) {
        this.f299a = i4;
        this.f300b = obj;
        this.f301c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        int i4 = this.f299a;
        Object obj = this.f301c;
        Object obj2 = this.f300b;
        switch (i4) {
            case 0:
                m0 m0Var = (m0) obj2;
                Runnable runnable = (Runnable) obj;
                m0Var.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    m0Var.a();
                }
            case 1:
                ((a0.p) obj2).d((Typeface) obj);
                return;
            case 2:
                Context context = (Context) obj;
                ((ProfileInstallerInitializer) obj2).getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = x0.h.a(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new n(context, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
            default:
                com.google.android.material.datepicker.i iVar = (com.google.android.material.datepicker.i) obj2;
                TextInputLayout textInputLayout = iVar.f3332a;
                Context context2 = textInputLayout.getContext();
                String string = context2.getString(R.string.mtrl_picker_invalid_format);
                String format = String.format(context2.getString(R.string.mtrl_picker_invalid_format_use), ((String) obj).replace(' ', (char) 160));
                String format2 = String.format(context2.getString(R.string.mtrl_picker_invalid_format_example), iVar.f3334c.format(new Date(com.google.android.material.datepicker.g0.f().getTimeInMillis())).replace(' ', (char) 160));
                textInputLayout.setError(string + "\n" + format + "\n" + format2);
                iVar.a();
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj2;
                SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
                SurfaceTexture surfaceTexture2 = sphericalGLSurfaceView.f2862g;
                Surface surface = sphericalGLSurfaceView.f2863h;
                Surface surface2 = new Surface(surfaceTexture);
                sphericalGLSurfaceView.f2862g = surfaceTexture;
                sphericalGLSurfaceView.f2863h = surface2;
                Iterator it = sphericalGLSurfaceView.f2856a.iterator();
                if (!it.hasNext()) {
                    if (surfaceTexture2 != null) {
                        surfaceTexture2.release();
                    }
                    if (surface != null) {
                        surface.release();
                        return;
                    }
                    return;
                }
                androidx.activity.j.f(it.next());
                throw null;
        }
    }
}