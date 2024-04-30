package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1655b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1656c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1657d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1658e;

    public a1(int i4, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1654a = i4;
        this.f1655b = arrayList;
        this.f1656c = arrayList2;
        this.f1657d = arrayList3;
        this.f1658e = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i4 = 0; i4 < this.f1654a; i4++) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.m0.v((View) this.f1655b.get(i4), (String) this.f1656c.get(i4));
            i0.m0.v((View) this.f1657d.get(i4), (String) this.f1658e.get(i4));
        }
    }
}