package f0;

import a0.p;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4510a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4511b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4512c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f4513d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i4) {
        this.f4510a = i4;
        this.f4513d = obj;
        this.f4511b = obj2;
        this.f4512c = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2 = this.f4513d;
        Object obj3 = this.f4512c;
        Object obj4 = this.f4511b;
        switch (this.f4510a) {
            case 0:
                Typeface typeface = (Typeface) obj3;
                p pVar = ((b0.g) ((l) obj4)).f2497a;
                if (pVar != null) {
                    pVar.d(typeface);
                    return;
                }
                return;
            case 1:
                ((g) ((h0.a) obj4)).b(obj3);
                return;
            case 2:
                try {
                    obj = ((Callable) obj4).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) obj2).post(new a(this, (h0.a) obj3, obj, 1));
                return;
            default:
                ((q1.a) obj2).i((View) obj4, (FrameLayout) obj3);
                return;
        }
    }
}