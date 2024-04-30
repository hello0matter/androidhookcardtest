package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class l1 {

    /* renamed from: s  reason: collision with root package name */
    public static final List f2169s = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    public final View f2170a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference f2171b;

    /* renamed from: j  reason: collision with root package name */
    public int f2179j;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f2187r;

    /* renamed from: c  reason: collision with root package name */
    public int f2172c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f2173d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f2174e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f2175f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f2176g = -1;

    /* renamed from: h  reason: collision with root package name */
    public l1 f2177h = null;

    /* renamed from: i  reason: collision with root package name */
    public l1 f2178i = null;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f2180k = null;

    /* renamed from: l  reason: collision with root package name */
    public List f2181l = null;

    /* renamed from: m  reason: collision with root package name */
    public int f2182m = 0;

    /* renamed from: n  reason: collision with root package name */
    public b1 f2183n = null;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2184o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f2185p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f2186q = -1;

    public l1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f2170a = view;
    }

    public final void a(Object obj) {
        if (obj == null) {
            b(1024);
        } else if ((1024 & this.f2179j) == 0) {
            if (this.f2180k == null) {
                ArrayList arrayList = new ArrayList();
                this.f2180k = arrayList;
                this.f2181l = Collections.unmodifiableList(arrayList);
            }
            this.f2180k.add(obj);
        }
    }

    public final void b(int i4) {
        this.f2179j = i4 | this.f2179j;
    }

    public final int c() {
        int i4 = this.f2176g;
        return i4 == -1 ? this.f2172c : i4;
    }

    public final List d() {
        ArrayList arrayList;
        return ((this.f2179j & 1024) != 0 || (arrayList = this.f2180k) == null || arrayList.size() == 0) ? f2169s : this.f2181l;
    }

    public final boolean e(int i4) {
        return (i4 & this.f2179j) != 0;
    }

    public final boolean f() {
        View view = this.f2170a;
        return (view.getParent() == null || view.getParent() == this.f2187r) ? false : true;
    }

    public final boolean g() {
        return (this.f2179j & 1) != 0;
    }

    public final boolean h() {
        return (this.f2179j & 4) != 0;
    }

    public final boolean i() {
        if ((this.f2179j & 16) == 0) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            if (!i0.g0.i(this.f2170a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        return (this.f2179j & 8) != 0;
    }

    public final boolean k() {
        return this.f2183n != null;
    }

    public final boolean l() {
        return (this.f2179j & 256) != 0;
    }

    public final boolean m() {
        return (this.f2179j & 2) != 0;
    }

    public final void n(int i4, boolean z4) {
        if (this.f2173d == -1) {
            this.f2173d = this.f2172c;
        }
        if (this.f2176g == -1) {
            this.f2176g = this.f2172c;
        }
        if (z4) {
            this.f2176g += i4;
        }
        this.f2172c += i4;
        View view = this.f2170a;
        if (view.getLayoutParams() != null) {
            ((RecyclerView.LayoutParams) view.getLayoutParams()).f2013c = true;
        }
    }

    public final void o() {
        this.f2179j = 0;
        this.f2172c = -1;
        this.f2173d = -1;
        this.f2174e = -1L;
        this.f2176g = -1;
        this.f2182m = 0;
        this.f2177h = null;
        this.f2178i = null;
        ArrayList arrayList = this.f2180k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f2179j &= -1025;
        this.f2185p = 0;
        this.f2186q = -1;
        RecyclerView.j(this);
    }

    public final void p(boolean z4) {
        int i4;
        int i5 = this.f2182m;
        int i6 = z4 ? i5 - 1 : i5 + 1;
        this.f2182m = i6;
        if (i6 < 0) {
            this.f2182m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z4 && i6 == 1) {
            i4 = this.f2179j | 16;
        } else if (!z4 || i6 != 0) {
            return;
        } else {
            i4 = this.f2179j & (-17);
        }
        this.f2179j = i4;
    }

    public final boolean q() {
        return (this.f2179j & 128) != 0;
    }

    public final boolean r() {
        return (this.f2179j & 32) != 0;
    }

    public final String toString() {
        String simpleName;
        String str;
        if (getClass().isAnonymousClass()) {
            simpleName = "ViewHolder";
        } else {
            simpleName = getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.f2172c + " id=" + this.f2174e + ", oldPos=" + this.f2173d + ", pLpos:" + this.f2176g);
        if (k()) {
            sb.append(" scrap ");
            if (this.f2184o) {
                str = "[changeScrap]";
            } else {
                str = "[attachedScrap]";
            }
            sb.append(str);
        }
        if (h()) {
            sb.append(" invalid");
        }
        if (!g()) {
            sb.append(" unbound");
        }
        if ((this.f2179j & 2) != 0) {
            sb.append(" update");
        }
        if (j()) {
            sb.append(" removed");
        }
        if (q()) {
            sb.append(" ignored");
        }
        if (l()) {
            sb.append(" tmpDetached");
        }
        if (!i()) {
            sb.append(" not recyclable(" + this.f2182m + ")");
        }
        if ((this.f2179j & 512) != 0 || h()) {
            sb.append(" undefined adapter position");
        }
        if (this.f2170a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}