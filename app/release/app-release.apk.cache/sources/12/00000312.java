package androidx.recyclerview.widget;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a  reason: collision with root package name */
    public int f2235a;

    /* renamed from: b  reason: collision with root package name */
    public int f2236b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2237c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2238d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2239e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f2240f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f2241g;

    public p1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f2241g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f2235a = -1;
        this.f2236b = Integer.MIN_VALUE;
        this.f2237c = false;
        this.f2238d = false;
        this.f2239e = false;
        int[] iArr = this.f2240f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}