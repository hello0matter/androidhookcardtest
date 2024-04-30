package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class w extends com.google.common.collect.c implements androidx.lifecycle.l0, androidx.activity.x, androidx.activity.result.g, o0 {

    /* renamed from: q  reason: collision with root package name */
    public final Activity f1837q;

    /* renamed from: r  reason: collision with root package name */
    public final Context f1838r;

    /* renamed from: s  reason: collision with root package name */
    public final Handler f1839s;

    /* renamed from: t  reason: collision with root package name */
    public final l0 f1840t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f1841u;

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.fragment.app.k0, androidx.fragment.app.l0] */
    public w(FragmentActivity fragmentActivity) {
        this.f1841u = fragmentActivity;
        Handler handler = new Handler();
        this.f1840t = new k0();
        this.f1837q = fragmentActivity;
        h0.e.c(fragmentActivity, "context == null");
        this.f1838r = fragmentActivity;
        this.f1839s = handler;
    }

    @Override // androidx.fragment.app.o0
    public final void c() {
        this.f1841u.getClass();
    }

    @Override // androidx.lifecycle.l0
    public final androidx.lifecycle.k0 e() {
        return this.f1841u.e();
    }

    @Override // androidx.lifecycle.q
    public final androidx.lifecycle.s f() {
        return this.f1841u.f1585u;
    }

    @Override // com.google.common.collect.c
    public final View l1(int i4) {
        return this.f1841u.findViewById(i4);
    }

    @Override // com.google.common.collect.c
    public final boolean o1() {
        Window window = this.f1841u.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}