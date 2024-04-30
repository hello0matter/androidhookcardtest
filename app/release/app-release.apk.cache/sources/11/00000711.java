package h1;

import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.example.msphone.FloatingWindowService;

/* loaded from: classes.dex */
public final class b implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public float f4801a;

    /* renamed from: b  reason: collision with root package name */
    public float f4802b;

    /* renamed from: c  reason: collision with root package name */
    public int f4803c;

    /* renamed from: d  reason: collision with root package name */
    public int f4804d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f4805e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ FloatingWindowService f4806f;

    public b(FloatingWindowService floatingWindowService, WindowManager.LayoutParams layoutParams) {
        this.f4806f = floatingWindowService;
        this.f4805e = layoutParams;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        WindowManager.LayoutParams layoutParams = this.f4805e;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                layoutParams.x = this.f4803c + ((int) (motionEvent.getRawX() - this.f4801a));
                layoutParams.y = this.f4804d + ((int) (motionEvent.getRawY() - this.f4802b));
                FloatingWindowService floatingWindowService = this.f4806f;
                floatingWindowService.f2724d.updateViewLayout(floatingWindowService.f2721a, layoutParams);
            }
            return true;
        }
        this.f4803c = layoutParams.x;
        this.f4804d = layoutParams.y;
        this.f4801a = motionEvent.getRawX();
        this.f4802b = motionEvent.getRawY();
        return true;
    }
}