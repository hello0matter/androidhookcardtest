package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.f0;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f119b;

    public /* synthetic */ r(int i4, Object obj) {
        this.f118a = i4;
        this.f119b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f118a) {
            case 0:
                e3.a aVar = (e3.a) this.f119b;
                com.google.common.collect.c.F(aVar, "$onBackInvoked");
                aVar.a();
                return;
            case 1:
                ((f0) this.f119b).D();
                return;
            case 2:
                ((Runnable) this.f119b).run();
                return;
            default:
                ((f2.b) this.f119b).a();
                return;
        }
    }
}