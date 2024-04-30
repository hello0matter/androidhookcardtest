package m3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final t.d f5556a;

    /* renamed from: b  reason: collision with root package name */
    public final w1.g f5557b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f5558c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f5559d;

    /* renamed from: e  reason: collision with root package name */
    public final l0.d f5560e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5561f;

    /* renamed from: g  reason: collision with root package name */
    public final k f5562g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5563h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5564i;

    /* renamed from: j  reason: collision with root package name */
    public final k f5565j;

    /* renamed from: k  reason: collision with root package name */
    public final k f5566k;

    /* renamed from: l  reason: collision with root package name */
    public final k f5567l;

    /* renamed from: m  reason: collision with root package name */
    public final SocketFactory f5568m;

    /* renamed from: n  reason: collision with root package name */
    public final List f5569n;

    /* renamed from: o  reason: collision with root package name */
    public final List f5570o;

    /* renamed from: p  reason: collision with root package name */
    public final x3.c f5571p;

    /* renamed from: q  reason: collision with root package name */
    public final okhttp3.a f5572q;

    /* renamed from: r  reason: collision with root package name */
    public int f5573r;

    /* renamed from: s  reason: collision with root package name */
    public int f5574s;

    /* renamed from: t  reason: collision with root package name */
    public int f5575t;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, t.d] */
    public r() {
        ?? obj = new Object();
        obj.f6577a = 64;
        obj.f6578b = 5;
        obj.f6581e = new ArrayDeque();
        obj.f6582f = new ArrayDeque();
        obj.f6583g = new ArrayDeque();
        this.f5556a = obj;
        this.f5557b = new w1.g(10);
        this.f5558c = new ArrayList();
        this.f5559d = new ArrayList();
        k kVar = k.f5531d;
        byte[] bArr = n3.b.f5783a;
        this.f5560e = new l0.d(6, kVar);
        this.f5561f = true;
        k kVar2 = b.f5471a;
        this.f5562g = kVar2;
        this.f5563h = true;
        this.f5564i = true;
        this.f5565j = i.f5529b;
        this.f5566k = j.f5530c;
        this.f5567l = kVar2;
        SocketFactory socketFactory = SocketFactory.getDefault();
        com.google.common.collect.c.E(socketFactory, "getDefault()");
        this.f5568m = socketFactory;
        this.f5569n = s.A;
        this.f5570o = s.f5576z;
        this.f5571p = x3.c.f7146a;
        this.f5572q = okhttp3.a.f6004c;
        this.f5573r = 10000;
        this.f5574s = 10000;
        this.f5575t = 10000;
    }
}