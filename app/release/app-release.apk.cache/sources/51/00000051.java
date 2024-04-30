package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle$Event;

/* loaded from: classes.dex */
public abstract class p extends Dialog implements androidx.lifecycle.q, x, z0.f {

    /* renamed from: a  reason: collision with root package name */
    public androidx.lifecycle.s f112a;

    /* renamed from: b  reason: collision with root package name */
    public final z0.e f113b;

    /* renamed from: c  reason: collision with root package name */
    public final w f114c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, int i4) {
        super(context, i4);
        com.google.common.collect.c.F(context, "context");
        this.f113b = l2.f.c(this);
        this.f114c = new w(new d(2, this));
    }

    public static void a(p pVar) {
        com.google.common.collect.c.F(pVar, "this$0");
        super.onBackPressed();
    }

    @Override // z0.f
    public final z0.d b() {
        return this.f113b.f7226b;
    }

    public final androidx.lifecycle.s c() {
        androidx.lifecycle.s sVar = this.f112a;
        if (sVar == null) {
            androidx.lifecycle.s sVar2 = new androidx.lifecycle.s(this);
            this.f112a = sVar2;
            return sVar2;
        }
        return sVar;
    }

    @Override // androidx.lifecycle.q
    public final androidx.lifecycle.s f() {
        return c();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f114c.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            com.google.common.collect.c.E(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            w wVar = this.f114c;
            wVar.getClass();
            wVar.f162e = onBackInvokedDispatcher;
            wVar.c(wVar.f164g);
        }
        this.f113b.b(bundle);
        c().e(Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        com.google.common.collect.c.E(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f113b.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        c().e(Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        c().e(Lifecycle$Event.ON_DESTROY);
        this.f112a = null;
        super.onStop();
    }
}