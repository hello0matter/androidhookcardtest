package androidx.fragment.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import com.example.msphone.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class t implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.q, androidx.lifecycle.l0, androidx.lifecycle.h, z0.f {
    public static final Object R = new Object();
    public boolean A;
    public boolean C;
    public ViewGroup D;
    public View E;
    public boolean F;
    public r H;
    public boolean I;
    public float J;
    public boolean K;
    public androidx.lifecycle.s M;
    public c1 N;
    public z0.e P;
    public final ArrayList Q;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f1802b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray f1803c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f1804d;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f1806f;

    /* renamed from: g  reason: collision with root package name */
    public t f1807g;

    /* renamed from: i  reason: collision with root package name */
    public int f1809i;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1811k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1812l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1813m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1814n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1815o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1816p;

    /* renamed from: q  reason: collision with root package name */
    public int f1817q;

    /* renamed from: r  reason: collision with root package name */
    public k0 f1818r;

    /* renamed from: s  reason: collision with root package name */
    public w f1819s;

    /* renamed from: u  reason: collision with root package name */
    public t f1821u;

    /* renamed from: v  reason: collision with root package name */
    public int f1822v;

    /* renamed from: w  reason: collision with root package name */
    public int f1823w;

    /* renamed from: x  reason: collision with root package name */
    public String f1824x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f1825y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1826z;

    /* renamed from: a  reason: collision with root package name */
    public int f1801a = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f1805e = UUID.randomUUID().toString();

    /* renamed from: h  reason: collision with root package name */
    public String f1808h = null;

    /* renamed from: j  reason: collision with root package name */
    public Boolean f1810j = null;

    /* renamed from: t  reason: collision with root package name */
    public l0 f1820t = new k0();
    public final boolean B = true;
    public boolean G = true;
    public Lifecycle$State L = Lifecycle$State.f1868e;
    public final androidx.lifecycle.w O = new androidx.lifecycle.w();

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.fragment.app.k0, androidx.fragment.app.l0] */
    public t() {
        new AtomicInteger();
        this.Q = new ArrayList();
        this.M = new androidx.lifecycle.s(this);
        this.P = l2.f.c(this);
    }

    public void A(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1820t.L();
        this.f1816p = true;
        this.N = new c1(e());
        View s4 = s(layoutInflater, viewGroup, bundle);
        this.E = s4;
        if (s4 != null) {
            this.N.d();
            View view = this.E;
            c1 c1Var = this.N;
            com.google.common.collect.c.F(view, "<this>");
            view.setTag(R.id.view_tree_lifecycle_owner, c1Var);
            View view2 = this.E;
            c1 c1Var2 = this.N;
            com.google.common.collect.c.F(view2, "<this>");
            view2.setTag(R.id.view_tree_view_model_store_owner, c1Var2);
            View view3 = this.E;
            c1 c1Var3 = this.N;
            com.google.common.collect.c.F(view3, "<this>");
            view3.setTag(R.id.view_tree_saved_state_registry_owner, c1Var3);
            this.O.e(this.N);
        } else if (this.N.f1670b == null) {
            this.N = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    public final void B() {
        this.f1820t.s(1);
        if (this.E != null) {
            c1 c1Var = this.N;
            c1Var.d();
            if (c1Var.f1670b.f1915c.compareTo(Lifecycle$State.f1866c) >= 0) {
                this.N.c(Lifecycle$Event.ON_DESTROY);
            }
        }
        this.f1801a = 1;
        this.C = false;
        t();
        if (this.C) {
            androidx.appcompat.app.c cVar = new androidx.appcompat.app.c(e(), w0.b.f7018d);
            String canonicalName = w0.b.class.getCanonicalName();
            if (canonicalName != null) {
                l.l lVar = ((w0.b) cVar.k(w0.b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).f7019c;
                if (lVar.f5256c <= 0) {
                    this.f1816p = false;
                    return;
                } else {
                    androidx.activity.j.f(lVar.f5255b[0]);
                    throw null;
                }
            }
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        throw new AndroidRuntimeException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public final Context C() {
        Context i4 = i();
        if (i4 != null) {
            return i4;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View D() {
        View view = this.E;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void E(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.f1820t.Q(parcelable);
            l0 l0Var = this.f1820t;
            l0Var.A = false;
            l0Var.B = false;
            l0Var.H.f1759h = false;
            l0Var.s(1);
        }
    }

    public final void F(int i4, int i5, int i6, int i7) {
        if (this.H == null && i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return;
        }
        g().f1781d = i4;
        g().f1782e = i5;
        g().f1783f = i6;
        g().f1784g = i7;
    }

    public final void G(Bundle bundle) {
        k0 k0Var = this.f1818r;
        if (k0Var != null && (k0Var.A || k0Var.B)) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f1806f = bundle;
    }

    @Override // z0.f
    public final z0.d b() {
        return this.P.f7226b;
    }

    public com.google.common.collect.c c() {
        return new q(this);
    }

    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        boolean z4;
        View view;
        View view2;
        int i4;
        int i5;
        int i6;
        int i7;
        String str2;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f1822v));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f1823w));
        printWriter.print(" mTag=");
        printWriter.println(this.f1824x);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1801a);
        printWriter.print(" mWho=");
        printWriter.print(this.f1805e);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f1817q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1811k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1812l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1813m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f1814n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f1825y);
        printWriter.print(" mDetached=");
        printWriter.print(this.f1826z);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.B);
        printWriter.print(" mHasMenu=");
        printWriter.println(false);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.A);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.G);
        if (this.f1818r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f1818r);
        }
        if (this.f1819s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f1819s);
        }
        if (this.f1821u != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f1821u);
        }
        if (this.f1806f != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1806f);
        }
        if (this.f1802b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1802b);
        }
        if (this.f1803c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1803c);
        }
        if (this.f1804d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f1804d);
        }
        t tVar = this.f1807g;
        if (tVar == null) {
            k0 k0Var = this.f1818r;
            if (k0Var != null && (str2 = this.f1808h) != null) {
                tVar = k0Var.f1725c.b(str2);
            } else {
                tVar = null;
            }
        }
        if (tVar != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(tVar);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1809i);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        r rVar = this.H;
        if (rVar == null) {
            z4 = false;
        } else {
            z4 = rVar.f1780c;
        }
        printWriter.println(z4);
        r rVar2 = this.H;
        if (rVar2 != null && rVar2.f1781d != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            r rVar3 = this.H;
            if (rVar3 == null) {
                i7 = 0;
            } else {
                i7 = rVar3.f1781d;
            }
            printWriter.println(i7);
        }
        r rVar4 = this.H;
        if (rVar4 != null && rVar4.f1782e != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            r rVar5 = this.H;
            if (rVar5 == null) {
                i6 = 0;
            } else {
                i6 = rVar5.f1782e;
            }
            printWriter.println(i6);
        }
        r rVar6 = this.H;
        if (rVar6 != null && rVar6.f1783f != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            r rVar7 = this.H;
            if (rVar7 == null) {
                i5 = 0;
            } else {
                i5 = rVar7.f1783f;
            }
            printWriter.println(i5);
        }
        r rVar8 = this.H;
        if (rVar8 != null && rVar8.f1784g != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            r rVar9 = this.H;
            if (rVar9 == null) {
                i4 = 0;
            } else {
                i4 = rVar9.f1784g;
            }
            printWriter.println(i4);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.D);
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.E);
        }
        r rVar10 = this.H;
        if (rVar10 == null) {
            view = null;
        } else {
            view = rVar10.f1778a;
        }
        if (view != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            r rVar11 = this.H;
            if (rVar11 == null) {
                view2 = null;
            } else {
                view2 = rVar11.f1778a;
            }
            printWriter.println(view2);
        }
        if (i() != null) {
            androidx.appcompat.app.c cVar = new androidx.appcompat.app.c(e(), w0.b.f7018d);
            String canonicalName = w0.b.class.getCanonicalName();
            if (canonicalName != null) {
                l.l lVar = ((w0.b) cVar.k(w0.b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).f7019c;
                if (lVar.f5256c > 0) {
                    printWriter.print(str);
                    printWriter.println("Loaders:");
                    if (lVar.f5256c > 0) {
                        androidx.activity.j.f(lVar.f5255b[0]);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(lVar.f5254a[0]);
                        printWriter.print(": ");
                        throw null;
                    }
                }
            } else {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f1820t + ":");
        this.f1820t.u(androidx.activity.j.c(str, "  "), fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.lifecycle.l0
    public final androidx.lifecycle.k0 e() {
        if (this.f1818r != null) {
            if (j() != 1) {
                HashMap hashMap = this.f1818r.H.f1756e;
                androidx.lifecycle.k0 k0Var = (androidx.lifecycle.k0) hashMap.get(this.f1805e);
                if (k0Var == null) {
                    androidx.lifecycle.k0 k0Var2 = new androidx.lifecycle.k0();
                    hashMap.put(this.f1805e, k0Var2);
                    return k0Var2;
                }
                return k0Var;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.lifecycle.q
    public final androidx.lifecycle.s f() {
        return this.M;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.r, java.lang.Object] */
    public final r g() {
        if (this.H == null) {
            ?? obj = new Object();
            Object obj2 = R;
            obj.f1788k = obj2;
            obj.f1789l = obj2;
            obj.f1790m = obj2;
            obj.f1791n = 1.0f;
            obj.f1792o = null;
            this.H = obj;
        }
        return this.H;
    }

    public final k0 h() {
        if (this.f1819s != null) {
            return this.f1820t;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final Context i() {
        w wVar = this.f1819s;
        if (wVar == null) {
            return null;
        }
        return wVar.f1838r;
    }

    public final int j() {
        Lifecycle$State lifecycle$State = this.L;
        return (lifecycle$State == Lifecycle$State.f1865b || this.f1821u == null) ? lifecycle$State.ordinal() : Math.min(lifecycle$State.ordinal(), this.f1821u.j());
    }

    public final k0 k() {
        k0 k0Var = this.f1818r;
        if (k0Var != null) {
            return k0Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Object l() {
        Object obj;
        r rVar = this.H;
        if (rVar == null || (obj = rVar.f1789l) == R) {
            return null;
        }
        return obj;
    }

    public final Object m() {
        Object obj;
        r rVar = this.H;
        if (rVar == null || (obj = rVar.f1788k) == R) {
            return null;
        }
        return obj;
    }

    public final Object n() {
        Object obj;
        r rVar = this.H;
        if (rVar == null || (obj = rVar.f1790m) == R) {
            return null;
        }
        return obj;
    }

    public final boolean o() {
        t tVar = this.f1821u;
        if (tVar != null && (tVar.f1812l || tVar.o())) {
            return true;
        }
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.C = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        FragmentActivity fragmentActivity;
        w wVar = this.f1819s;
        if (wVar == null) {
            fragmentActivity = null;
        } else {
            fragmentActivity = (FragmentActivity) wVar.f1837q;
        }
        if (fragmentActivity != null) {
            fragmentActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.C = true;
    }

    public final void p(int i4, int i5, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i4 + " resultCode: " + i5 + " data: " + intent);
        }
    }

    public void q(Context context) {
        Activity activity;
        this.C = true;
        w wVar = this.f1819s;
        if (wVar == null) {
            activity = null;
        } else {
            activity = wVar.f1837q;
        }
        if (activity != null) {
            this.C = true;
        }
    }

    public void r(Bundle bundle) {
        this.C = true;
        E(bundle);
        l0 l0Var = this.f1820t;
        if (l0Var.f1737o < 1) {
            l0Var.A = false;
            l0Var.B = false;
            l0Var.H.f1759h = false;
            l0Var.s(1);
        }
    }

    public View s(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void t() {
        this.C = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f1805e);
        if (this.f1822v != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1822v));
        }
        if (this.f1824x != null) {
            sb.append(" tag=");
            sb.append(this.f1824x);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        this.C = true;
    }

    public LayoutInflater v(Bundle bundle) {
        w wVar = this.f1819s;
        if (wVar != null) {
            FragmentActivity fragmentActivity = wVar.f1841u;
            LayoutInflater cloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
            cloneInContext.setFactory2(this.f1820t.f1728f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public abstract void w(Bundle bundle);

    public void x() {
        this.C = true;
    }

    public void y() {
        this.C = true;
    }

    public void z(Bundle bundle) {
        this.C = true;
    }
}