package androidx.appcompat.app;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class h0 extends androidx.activity.p implements m {

    /* renamed from: d  reason: collision with root package name */
    public f0 f279d;

    /* renamed from: e  reason: collision with root package name */
    public final g0 f280e;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.app.g0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h0(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 2130903391(0x7f03015f, float:1.7413599E38)
            if (r6 != 0) goto L15
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L16
        L15:
            r2 = r6
        L16:
            r4.<init>(r5, r2)
            androidx.appcompat.app.g0 r2 = new androidx.appcompat.app.g0
            r3 = r4
            androidx.appcompat.app.j r3 = (androidx.appcompat.app.j) r3
            r2.<init>()
            r4.f280e = r2
            androidx.appcompat.app.q r2 = r4.d()
            if (r6 != 0) goto L37
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L37:
            r5 = r2
            androidx.appcompat.app.f0 r5 = (androidx.appcompat.app.f0) r5
            r5.T = r6
            r2.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h0.<init>(android.content.Context, int):void");
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f0 f0Var = (f0) d();
        f0Var.w();
        ((ViewGroup) f0Var.A.findViewById(16908290)).addView(view, layoutParams);
        f0Var.f240m.a(f0Var.f239l.getCallback());
    }

    public final q d() {
        if (this.f279d == null) {
            m0 m0Var = q.f312a;
            this.f279d = new f0(getContext(), getWindow(), this, this);
        }
        return this.f279d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        d().f();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return i0.o.b(this.f280e, getWindow().getDecorView(), this, keyEvent);
    }

    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i4) {
        f0 f0Var = (f0) d();
        f0Var.w();
        return f0Var.f239l.findViewById(i4);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        d().c();
    }

    @Override // androidx.activity.p, android.app.Dialog
    public void onCreate(Bundle bundle) {
        d().a();
        super.onCreate(bundle);
        d().e();
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void onStop() {
        super.onStop();
        f0 f0Var = (f0) d();
        f0Var.A();
        u0 u0Var = f0Var.f242o;
        if (u0Var != null) {
            u0Var.f363t = false;
            f.n nVar = u0Var.f362s;
            if (nVar != null) {
                nVar.a();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setContentView(int i4) {
        d().i(i4);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i4) {
        super.setTitle(i4);
        d().l(getContext().getString(i4));
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        d().j(view);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().l(charSequence);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d().k(view, layoutParams);
    }
}