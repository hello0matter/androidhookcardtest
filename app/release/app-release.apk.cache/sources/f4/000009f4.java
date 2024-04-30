package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final float f6979a;

    /* renamed from: b  reason: collision with root package name */
    public final List f6980b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6981c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6982d;

    public j(float f4, ArrayList arrayList, int i4, int i5) {
        this.f6979a = f4;
        this.f6980b = Collections.unmodifiableList(arrayList);
        this.f6981c = i4;
        this.f6982d = i5;
    }

    public final i a() {
        return (i) this.f6980b.get(this.f6981c);
    }

    public final i b() {
        return (i) this.f6980b.get(0);
    }

    public final i c() {
        return (i) this.f6980b.get(this.f6982d);
    }

    public final i d() {
        List list = this.f6980b;
        return (i) list.get(list.size() - 1);
    }
}