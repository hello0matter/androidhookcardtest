package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1631a;

    /* renamed from: b  reason: collision with root package name */
    public int f1632b;

    /* renamed from: c  reason: collision with root package name */
    public int f1633c;

    /* renamed from: d  reason: collision with root package name */
    public int f1634d;

    /* renamed from: e  reason: collision with root package name */
    public int f1635e;

    /* renamed from: f  reason: collision with root package name */
    public int f1636f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1637g;

    /* renamed from: h  reason: collision with root package name */
    public String f1638h;

    /* renamed from: i  reason: collision with root package name */
    public int f1639i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1640j;

    /* renamed from: k  reason: collision with root package name */
    public int f1641k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f1642l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f1643m;

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f1644n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1645o;

    /* renamed from: p  reason: collision with root package name */
    public final k0 f1646p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f1647q;

    /* renamed from: r  reason: collision with root package name */
    public int f1648r;

    public a(k0 k0Var) {
        k0Var.D();
        w wVar = k0Var.f1738p;
        if (wVar != null) {
            wVar.f1838r.getClassLoader();
        }
        this.f1631a = new ArrayList();
        this.f1645o = false;
        this.f1648r = -1;
        this.f1646p = k0Var;
    }

    @Override // androidx.fragment.app.i0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1637g) {
            k0 k0Var = this.f1646p;
            if (k0Var.f1726d == null) {
                k0Var.f1726d = new ArrayList();
            }
            k0Var.f1726d.add(this);
            return true;
        }
        return true;
    }

    public final void b(s0 s0Var) {
        this.f1631a.add(s0Var);
        s0Var.f1795c = this.f1632b;
        s0Var.f1796d = this.f1633c;
        s0Var.f1797e = this.f1634d;
        s0Var.f1798f = this.f1635e;
    }

    public final void c(int i4) {
        s0 s0Var;
        if (!this.f1637g) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + i4);
        }
        int size = this.f1631a.size();
        for (int i5 = 0; i5 < size; i5++) {
            t tVar = ((s0) this.f1631a.get(i5)).f1794b;
            if (tVar != null) {
                tVar.f1817q += i4;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Bump nesting of " + s0Var.f1794b + " to " + s0Var.f1794b.f1817q);
                }
            }
        }
    }

    public final int d(boolean z4) {
        int i4;
        if (!this.f1647q) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new d1());
                f("  ", printWriter, true);
                printWriter.close();
            }
            this.f1647q = true;
            boolean z5 = this.f1637g;
            k0 k0Var = this.f1646p;
            if (z5) {
                i4 = k0Var.f1731i.getAndIncrement();
            } else {
                i4 = -1;
            }
            this.f1648r = i4;
            k0Var.v(this, z4);
            return this.f1648r;
        }
        throw new IllegalStateException("commit already called");
    }

    public final void e(int i4, t tVar, String str, int i5) {
        Class<?> cls = tVar.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = tVar.f1824x;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + tVar + ": was " + tVar.f1824x + " now " + str);
                }
                tVar.f1824x = str;
            }
            if (i4 != 0) {
                if (i4 != -1) {
                    int i6 = tVar.f1822v;
                    if (i6 != 0 && i6 != i4) {
                        throw new IllegalStateException("Can't change container ID of fragment " + tVar + ": was " + tVar.f1822v + " now " + i4);
                    }
                    tVar.f1822v = i4;
                    tVar.f1823w = i4;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + tVar + " with tag " + str + " to container view with no id");
                }
            }
            b(new s0(i5, tVar));
            tVar.f1818r = this.f1646p;
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final void f(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1638h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1648r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1647q);
            if (this.f1636f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1636f));
            }
            if (this.f1632b != 0 || this.f1633c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1632b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1633c));
            }
            if (this.f1634d != 0 || this.f1635e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1634d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1635e));
            }
            if (this.f1639i != 0 || this.f1640j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1639i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1640j);
            }
            if (this.f1641k != 0 || this.f1642l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1641k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1642l);
            }
        }
        if (this.f1631a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1631a.size();
        for (int i4 = 0; i4 < size; i4++) {
            s0 s0Var = (s0) this.f1631a.get(i4);
            switch (s0Var.f1793a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    str2 = "REMOVE";
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    str2 = "HIDE";
                    break;
                case VisibleForTesting.NONE /* 5 */:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + s0Var.f1793a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i4);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(s0Var.f1794b);
            if (z4) {
                if (s0Var.f1795c != 0 || s0Var.f1796d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(s0Var.f1795c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(s0Var.f1796d));
                }
                if (s0Var.f1797e != 0 || s0Var.f1798f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(s0Var.f1797e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(s0Var.f1798f));
                }
            }
        }
    }

    public final void g() {
        int size = this.f1631a.size();
        for (int i4 = 0; i4 < size; i4++) {
            s0 s0Var = (s0) this.f1631a.get(i4);
            t tVar = s0Var.f1794b;
            if (tVar != null) {
                if (tVar.H != null) {
                    tVar.g().f1780c = false;
                }
                int i5 = this.f1636f;
                if (tVar.H != null || i5 != 0) {
                    tVar.g();
                    tVar.H.f1785h = i5;
                }
                ArrayList arrayList = this.f1643m;
                ArrayList arrayList2 = this.f1644n;
                tVar.g();
                r rVar = tVar.H;
                rVar.f1786i = arrayList;
                rVar.f1787j = arrayList2;
            }
            int i6 = s0Var.f1793a;
            k0 k0Var = this.f1646p;
            switch (i6) {
                case 1:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.T(tVar, false);
                    k0Var.a(tVar);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + s0Var.f1793a);
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.O(tVar);
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.F(tVar);
                    break;
                case VisibleForTesting.NONE /* 5 */:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.T(tVar, false);
                    k0.X(tVar);
                    break;
                case 6:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.g(tVar);
                    break;
                case 7:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.T(tVar, false);
                    k0Var.c(tVar);
                    break;
                case 8:
                    k0Var.V(tVar);
                    break;
                case 9:
                    k0Var.V(null);
                    break;
                case 10:
                    k0Var.U(tVar, s0Var.f1800h);
                    break;
            }
        }
    }

    public final void h() {
        for (int size = this.f1631a.size() - 1; size >= 0; size--) {
            s0 s0Var = (s0) this.f1631a.get(size);
            t tVar = s0Var.f1794b;
            if (tVar != null) {
                if (tVar.H != null) {
                    tVar.g().f1780c = true;
                }
                int i4 = this.f1636f;
                int i5 = 8194;
                if (i4 != 4097) {
                    if (i4 != 4099) {
                        if (i4 != 8194) {
                            i5 = 0;
                        } else {
                            i5 = 4097;
                        }
                    } else {
                        i5 = 4099;
                    }
                }
                if (tVar.H != null || i5 != 0) {
                    tVar.g();
                    tVar.H.f1785h = i5;
                }
                ArrayList arrayList = this.f1644n;
                ArrayList arrayList2 = this.f1643m;
                tVar.g();
                r rVar = tVar.H;
                rVar.f1786i = arrayList;
                rVar.f1787j = arrayList2;
            }
            int i6 = s0Var.f1793a;
            k0 k0Var = this.f1646p;
            switch (i6) {
                case 1:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.T(tVar, true);
                    k0Var.O(tVar);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + s0Var.f1793a);
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.a(tVar);
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.getClass();
                    k0.X(tVar);
                    break;
                case VisibleForTesting.NONE /* 5 */:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.T(tVar, true);
                    k0Var.F(tVar);
                    break;
                case 6:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.c(tVar);
                    break;
                case 7:
                    tVar.F(s0Var.f1795c, s0Var.f1796d, s0Var.f1797e, s0Var.f1798f);
                    k0Var.T(tVar, true);
                    k0Var.g(tVar);
                    break;
                case 8:
                    k0Var.V(null);
                    break;
                case 9:
                    k0Var.V(tVar);
                    break;
                case 10:
                    k0Var.U(tVar, s0Var.f1799g);
                    break;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1648r >= 0) {
            sb.append(" #");
            sb.append(this.f1648r);
        }
        if (this.f1638h != null) {
            sb.append(" ");
            sb.append(this.f1638h);
        }
        sb.append("}");
        return sb.toString();
    }
}