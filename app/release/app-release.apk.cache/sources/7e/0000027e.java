package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class p extends t implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler S;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f1763b0;

    /* renamed from: d0  reason: collision with root package name */
    public Dialog f1765d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f1766e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f1767f0;
    public final x T = new x(2, this);
    public final l U = new l(this);
    public final m V = new m(this);
    public int W = 0;
    public int X = 0;
    public boolean Y = true;
    public boolean Z = true;

    /* renamed from: a0  reason: collision with root package name */
    public int f1762a0 = -1;

    /* renamed from: c0  reason: collision with root package name */
    public final n f1764c0 = new n(0, this);

    /* renamed from: g0  reason: collision with root package name */
    public boolean f1768g0 = false;

    @Override // androidx.fragment.app.t
    public final void A(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.A(layoutInflater, viewGroup, bundle);
        if (this.E != null || this.f1765d0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f1765d0.onRestoreInstanceState(bundle2);
    }

    public final void H(boolean z4, boolean z5) {
        if (this.f1767f0) {
            return;
        }
        this.f1767f0 = true;
        Dialog dialog = this.f1765d0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f1765d0.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.S.getLooper()) {
                    onDismiss(this.f1765d0);
                } else {
                    this.S.post(this.T);
                }
            }
        }
        this.f1766e0 = true;
        if (this.f1762a0 >= 0) {
            k0 k4 = k();
            int i4 = this.f1762a0;
            if (i4 >= 0) {
                k4.v(new j0(k4, i4), false);
                this.f1762a0 = -1;
                return;
            }
            throw new IllegalArgumentException(androidx.activity.j.b("Bad id: ", i4));
        }
        a aVar = new a(k());
        k0 k0Var = this.f1818r;
        if (k0Var != null && k0Var != aVar.f1646p) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
        aVar.b(new s0(3, this));
        if (z4) {
            aVar.d(true);
        } else {
            aVar.d(false);
        }
    }

    public Dialog I() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(C(), this.X);
    }

    @Override // androidx.fragment.app.t
    public final com.google.common.collect.c c() {
        return new o(this, new q(this));
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f1766e0) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            H(true, true);
        }
    }

    @Override // androidx.fragment.app.t
    public final void q(Context context) {
        super.q(context);
        this.O.d(this.f1764c0);
        this.f1767f0 = false;
    }

    @Override // androidx.fragment.app.t
    public void r(Bundle bundle) {
        super.r(bundle);
        this.S = new Handler();
        this.Z = this.f1823w == 0;
        if (bundle != null) {
            this.W = bundle.getInt("android:style", 0);
            this.X = bundle.getInt("android:theme", 0);
            this.Y = bundle.getBoolean("android:cancelable", true);
            this.Z = bundle.getBoolean("android:showsDialog", this.Z);
            this.f1762a0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.t
    public final void t() {
        this.C = true;
        Dialog dialog = this.f1765d0;
        if (dialog != null) {
            this.f1766e0 = true;
            dialog.setOnDismissListener(null);
            this.f1765d0.dismiss();
            if (!this.f1767f0) {
                onDismiss(this.f1765d0);
            }
            this.f1765d0 = null;
            this.f1768g0 = false;
        }
    }

    @Override // androidx.fragment.app.t
    public final void u() {
        this.C = true;
        if (!this.f1767f0) {
            this.f1767f0 = true;
        }
        n nVar = this.f1764c0;
        androidx.lifecycle.w wVar = this.O;
        wVar.getClass();
        androidx.lifecycle.w.a("removeObserver");
        androidx.lifecycle.v vVar = (androidx.lifecycle.v) wVar.f1929b.b(nVar);
        if (vVar != null) {
            vVar.d();
            vVar.c(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:29:0x0050, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x0068), top: B:49:0x001a }] */
    @Override // androidx.fragment.app.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.LayoutInflater v(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.v(r8)
            boolean r0 = r7.Z
            r1 = 2
            java.lang.String r2 = "FragmentManager"
            if (r0 == 0) goto L9a
            boolean r3 = r7.f1763b0
            if (r3 == 0) goto L11
            goto L9a
        L11:
            if (r0 != 0) goto L14
            goto L71
        L14:
            boolean r0 = r7.f1768g0
            if (r0 != 0) goto L71
            r0 = 0
            r3 = 1
            r7.f1763b0 = r3     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.I()     // Catch: java.lang.Throwable -> L4e
            r7.f1765d0 = r4     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.Z     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L68
            int r5 = r7.W     // Catch: java.lang.Throwable -> L4e
            if (r5 == r3) goto L3b
            if (r5 == r1) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L4e
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L4e
        L3e:
            android.content.Context r4 = r7.i()     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L50
            android.app.Dialog r5 = r7.f1765d0     // Catch: java.lang.Throwable -> L4e
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L4e
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r8 = move-exception
            goto L6e
        L50:
            android.app.Dialog r4 = r7.f1765d0     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.Y     // Catch: java.lang.Throwable -> L4e
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.f1765d0     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.l r5 = r7.U     // Catch: java.lang.Throwable -> L4e
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.f1765d0     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.m r5 = r7.V     // Catch: java.lang.Throwable -> L4e
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L4e
            r7.f1768g0 = r3     // Catch: java.lang.Throwable -> L4e
            goto L6b
        L68:
            r3 = 0
            r7.f1765d0 = r3     // Catch: java.lang.Throwable -> L4e
        L6b:
            r7.f1763b0 = r0
            goto L71
        L6e:
            r7.f1763b0 = r0
            throw r8
        L71:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L8d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "get layout inflater for DialogFragment "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r1 = " from dialog context"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
        L8d:
            android.app.Dialog r0 = r7.f1765d0
            if (r0 == 0) goto L99
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r0)
        L99:
            return r8
        L9a:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto Lcc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "getting layout inflater for DialogFragment "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r1 = r7.Z
            if (r1 != 0) goto Lc4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "mShowsDialog = false: "
            r1.<init>(r3)
        Lb9:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.d(r2, r0)
            goto Lcc
        Lc4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "mCreatingDialog = true: "
            r1.<init>(r3)
            goto Lb9
        Lcc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.v(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.t
    public void w(Bundle bundle) {
        Dialog dialog = this.f1765d0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i4 = this.W;
        if (i4 != 0) {
            bundle.putInt("android:style", i4);
        }
        int i5 = this.X;
        if (i5 != 0) {
            bundle.putInt("android:theme", i5);
        }
        boolean z4 = this.Y;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.Z;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i6 = this.f1762a0;
        if (i6 != -1) {
            bundle.putInt("android:backStackId", i6);
        }
    }

    @Override // androidx.fragment.app.t
    public void x() {
        this.C = true;
        Dialog dialog = this.f1765d0;
        if (dialog != null) {
            this.f1766e0 = false;
            dialog.show();
            View decorView = this.f1765d0.getWindow().getDecorView();
            com.google.common.collect.c.F(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.t
    public void y() {
        this.C = true;
        Dialog dialog = this.f1765d0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.t
    public final void z(Bundle bundle) {
        Bundle bundle2;
        this.C = true;
        if (this.f1765d0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f1765d0.onRestoreInstanceState(bundle2);
        }
    }
}