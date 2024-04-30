package l1;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f5263a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5264b;

    /* renamed from: c  reason: collision with root package name */
    public final Serializable f5265c;

    /* JADX WARN: Type inference failed for: r0v1, types: [l1.a[], java.io.Serializable] */
    public a() {
        this.f5265c = new a[256];
        this.f5263a = 0;
        this.f5264b = 0;
    }

    public a(int i4, int i5) {
        this.f5265c = null;
        this.f5263a = i4;
        int i6 = i5 & 7;
        this.f5264b = i6 == 0 ? 8 : i6;
    }

    public a(int i4, int i5, String str) {
        this.f5265c = str;
        this.f5263a = i4;
        this.f5264b = i5;
    }
}