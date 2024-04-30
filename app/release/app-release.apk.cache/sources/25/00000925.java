package p;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class d implements e0.b {

    /* renamed from: e  reason: collision with root package name */
    public static d f6073e;

    /* renamed from: a  reason: collision with root package name */
    public Object f6074a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6075b;

    /* renamed from: c  reason: collision with root package name */
    public Object f6076c;

    /* renamed from: d  reason: collision with root package name */
    public Object f6077d;

    public d(int i4) {
        if (i4 != 2) {
            if (i4 != 3) {
                this.f6074a = new g(256, 0);
                this.f6075b = new g(256, 0);
                this.f6076c = new g(256, 0);
                this.f6077d = new j[32];
                return;
            }
            this.f6074a = new Object();
            this.f6075b = new Handler(Looper.getMainLooper(), new n2.e(this));
            return;
        }
        this.f6074a = new l.k();
        this.f6075b = new SparseArray();
        this.f6076c = new l.e();
        this.f6077d = new l.k();
    }

    @Override // e0.b
    public final void a() {
        ((View) this.f6074a).clearAnimation();
        ((ViewGroup) this.f6075b).endViewTransition((View) this.f6074a);
        ((androidx.fragment.app.h) this.f6076c).a();
    }
}