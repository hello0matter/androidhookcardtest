package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class n implements Executor, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: b  reason: collision with root package name */
    public Runnable f109b;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f111d;

    /* renamed from: a  reason: collision with root package name */
    public final long f108a = SystemClock.uptimeMillis() + 10000;

    /* renamed from: c  reason: collision with root package name */
    public boolean f110c = false;

    public n(ComponentActivity componentActivity) {
        this.f111d = componentActivity;
    }

    public final void a(View view) {
        if (this.f110c) {
            return;
        }
        this.f110c = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f109b = runnable;
        View decorView = this.f111d.getWindow().getDecorView();
        if (!this.f110c) {
            decorView.postOnAnimation(new d(1, this));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z4;
        Runnable runnable = this.f109b;
        if (runnable != null) {
            runnable.run();
            this.f109b = null;
            q qVar = this.f111d.f66i;
            synchronized (qVar.f115a) {
                z4 = qVar.f116b;
            }
            if (!z4) {
                return;
            }
        } else if (SystemClock.uptimeMillis() <= this.f108a) {
            return;
        }
        this.f110c = false;
        this.f111d.getWindow().getDecorView().post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f111d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}