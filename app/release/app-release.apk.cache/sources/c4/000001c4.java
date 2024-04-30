package androidx.constraintlayout.widget;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.util.HashMap;
import t.e;
import t.f;
import t.g;
import t.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f1311a;

    /* renamed from: b  reason: collision with root package name */
    public final g f1312b;

    /* renamed from: c  reason: collision with root package name */
    public final f f1313c;

    /* renamed from: d  reason: collision with root package name */
    public final e f1314d;

    /* renamed from: e  reason: collision with root package name */
    public final h f1315e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f1316f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, t.g] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, t.f] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, t.e] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, t.h] */
    public c() {
        ?? obj = new Object();
        obj.f6629a = false;
        obj.f6630b = 0;
        obj.f6631c = 0;
        obj.f6632d = 1.0f;
        obj.f6633e = Float.NaN;
        this.f1312b = obj;
        ?? obj2 = new Object();
        obj2.f6622a = false;
        obj2.f6623b = -1;
        obj2.f6624c = null;
        obj2.f6625d = -1;
        obj2.f6626e = 0;
        obj2.f6627f = Float.NaN;
        obj2.f6628g = Float.NaN;
        this.f1313c = obj2;
        ?? obj3 = new Object();
        obj3.f6585a = false;
        obj3.f6587b = false;
        obj3.f6593e = -1;
        obj3.f6595f = -1;
        obj3.f6597g = -1.0f;
        obj3.f6599h = -1;
        obj3.f6601i = -1;
        obj3.f6603j = -1;
        obj3.f6605k = -1;
        obj3.f6606l = -1;
        obj3.f6607m = -1;
        obj3.f6608n = -1;
        obj3.f6609o = -1;
        obj3.f6610p = -1;
        obj3.f6611q = -1;
        obj3.f6612r = -1;
        obj3.f6613s = -1;
        obj3.f6614t = -1;
        obj3.f6615u = 0.5f;
        obj3.f6616v = 0.5f;
        obj3.f6617w = null;
        obj3.f6618x = -1;
        obj3.f6619y = 0;
        obj3.f6620z = 0.0f;
        obj3.A = -1;
        obj3.B = -1;
        obj3.C = -1;
        obj3.D = -1;
        obj3.E = -1;
        obj3.F = -1;
        obj3.G = -1;
        obj3.H = -1;
        obj3.I = -1;
        obj3.J = -1;
        obj3.K = -1;
        obj3.L = -1;
        obj3.M = -1;
        obj3.N = -1;
        obj3.O = -1;
        obj3.P = -1.0f;
        obj3.Q = -1.0f;
        obj3.R = 0;
        obj3.S = 0;
        obj3.T = 0;
        obj3.U = 0;
        obj3.V = -1;
        obj3.W = -1;
        obj3.X = -1;
        obj3.Y = -1;
        obj3.Z = 1.0f;
        obj3.f6586a0 = 1.0f;
        obj3.f6588b0 = -1;
        obj3.f6590c0 = 0;
        obj3.f6592d0 = -1;
        obj3.f6600h0 = false;
        obj3.f6602i0 = false;
        obj3.f6604j0 = true;
        this.f1314d = obj3;
        ?? obj4 = new Object();
        obj4.f6635a = false;
        obj4.f6636b = 0.0f;
        obj4.f6637c = 0.0f;
        obj4.f6638d = 0.0f;
        obj4.f6639e = 1.0f;
        obj4.f6640f = 1.0f;
        obj4.f6641g = Float.NaN;
        obj4.f6642h = Float.NaN;
        obj4.f6643i = 0.0f;
        obj4.f6644j = 0.0f;
        obj4.f6645k = 0.0f;
        obj4.f6646l = false;
        obj4.f6647m = 0.0f;
        this.f1315e = obj4;
        this.f1316f = new HashMap();
    }

    public final void a(ConstraintLayout.LayoutParams layoutParams) {
        e eVar = this.f1314d;
        layoutParams.f1252d = eVar.f6599h;
        layoutParams.f1254e = eVar.f6601i;
        layoutParams.f1256f = eVar.f6603j;
        layoutParams.f1258g = eVar.f6605k;
        layoutParams.f1260h = eVar.f6606l;
        layoutParams.f1262i = eVar.f6607m;
        layoutParams.f1264j = eVar.f6608n;
        layoutParams.f1266k = eVar.f6609o;
        layoutParams.f1268l = eVar.f6610p;
        layoutParams.f1273p = eVar.f6611q;
        layoutParams.f1274q = eVar.f6612r;
        layoutParams.f1275r = eVar.f6613s;
        layoutParams.f1276s = eVar.f6614t;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = eVar.D;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = eVar.E;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = eVar.F;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = eVar.G;
        layoutParams.f1281x = eVar.O;
        layoutParams.f1282y = eVar.N;
        layoutParams.f1278u = eVar.K;
        layoutParams.f1280w = eVar.M;
        layoutParams.f1283z = eVar.f6615u;
        layoutParams.A = eVar.f6616v;
        layoutParams.f1270m = eVar.f6618x;
        layoutParams.f1271n = eVar.f6619y;
        layoutParams.f1272o = eVar.f6620z;
        layoutParams.B = eVar.f6617w;
        layoutParams.P = eVar.A;
        layoutParams.Q = eVar.B;
        layoutParams.E = eVar.P;
        layoutParams.D = eVar.Q;
        layoutParams.G = eVar.S;
        layoutParams.F = eVar.R;
        layoutParams.S = eVar.f6600h0;
        layoutParams.T = eVar.f6602i0;
        layoutParams.H = eVar.T;
        layoutParams.I = eVar.U;
        layoutParams.L = eVar.V;
        layoutParams.M = eVar.W;
        layoutParams.J = eVar.X;
        layoutParams.K = eVar.Y;
        layoutParams.N = eVar.Z;
        layoutParams.O = eVar.f6586a0;
        layoutParams.R = eVar.C;
        layoutParams.f1250c = eVar.f6597g;
        layoutParams.f1246a = eVar.f6593e;
        layoutParams.f1248b = eVar.f6595f;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = eVar.f6589c;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = eVar.f6591d;
        String str = eVar.f6598g0;
        if (str != null) {
            layoutParams.U = str;
        }
        layoutParams.setMarginStart(eVar.I);
        layoutParams.setMarginEnd(eVar.H);
        layoutParams.a();
    }

    public final void b(int i4, ConstraintLayout.LayoutParams layoutParams) {
        this.f1311a = i4;
        int i5 = layoutParams.f1252d;
        e eVar = this.f1314d;
        eVar.f6599h = i5;
        eVar.f6601i = layoutParams.f1254e;
        eVar.f6603j = layoutParams.f1256f;
        eVar.f6605k = layoutParams.f1258g;
        eVar.f6606l = layoutParams.f1260h;
        eVar.f6607m = layoutParams.f1262i;
        eVar.f6608n = layoutParams.f1264j;
        eVar.f6609o = layoutParams.f1266k;
        eVar.f6610p = layoutParams.f1268l;
        eVar.f6611q = layoutParams.f1273p;
        eVar.f6612r = layoutParams.f1274q;
        eVar.f6613s = layoutParams.f1275r;
        eVar.f6614t = layoutParams.f1276s;
        eVar.f6615u = layoutParams.f1283z;
        eVar.f6616v = layoutParams.A;
        eVar.f6617w = layoutParams.B;
        eVar.f6618x = layoutParams.f1270m;
        eVar.f6619y = layoutParams.f1271n;
        eVar.f6620z = layoutParams.f1272o;
        eVar.A = layoutParams.P;
        eVar.B = layoutParams.Q;
        eVar.C = layoutParams.R;
        eVar.f6597g = layoutParams.f1250c;
        eVar.f6593e = layoutParams.f1246a;
        eVar.f6595f = layoutParams.f1248b;
        eVar.f6589c = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        eVar.f6591d = ((ViewGroup.MarginLayoutParams) layoutParams).height;
        eVar.D = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        eVar.E = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        eVar.F = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        eVar.G = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        eVar.P = layoutParams.E;
        eVar.Q = layoutParams.D;
        eVar.S = layoutParams.G;
        eVar.R = layoutParams.F;
        eVar.f6600h0 = layoutParams.S;
        eVar.f6602i0 = layoutParams.T;
        eVar.T = layoutParams.H;
        eVar.U = layoutParams.I;
        eVar.V = layoutParams.L;
        eVar.W = layoutParams.M;
        eVar.X = layoutParams.J;
        eVar.Y = layoutParams.K;
        eVar.Z = layoutParams.N;
        eVar.f6586a0 = layoutParams.O;
        eVar.f6598g0 = layoutParams.U;
        eVar.K = layoutParams.f1278u;
        eVar.M = layoutParams.f1280w;
        eVar.J = layoutParams.f1277t;
        eVar.L = layoutParams.f1279v;
        eVar.O = layoutParams.f1281x;
        eVar.N = layoutParams.f1282y;
        eVar.H = layoutParams.getMarginEnd();
        eVar.I = layoutParams.getMarginStart();
    }

    public final void c(int i4, Constraints.LayoutParams layoutParams) {
        b(i4, layoutParams);
        this.f1312b.f6632d = layoutParams.f1285m0;
        float f4 = layoutParams.f1288p0;
        h hVar = this.f1315e;
        hVar.f6636b = f4;
        hVar.f6637c = layoutParams.f1289q0;
        hVar.f6638d = layoutParams.f1290r0;
        hVar.f6639e = layoutParams.f1291s0;
        hVar.f6640f = layoutParams.f1292t0;
        hVar.f6641g = layoutParams.f1293u0;
        hVar.f6642h = layoutParams.f1294v0;
        hVar.f6643i = layoutParams.f1295w0;
        hVar.f6644j = layoutParams.f1296x0;
        hVar.f6645k = layoutParams.f1297y0;
        hVar.f6647m = layoutParams.f1287o0;
        hVar.f6646l = layoutParams.f1286n0;
    }

    public final Object clone() {
        c cVar = new c();
        cVar.f1314d.a(this.f1314d);
        cVar.f1313c.a(this.f1313c);
        g gVar = cVar.f1312b;
        gVar.getClass();
        g gVar2 = this.f1312b;
        gVar.f6629a = gVar2.f6629a;
        gVar.f6630b = gVar2.f6630b;
        gVar.f6632d = gVar2.f6632d;
        gVar.f6633e = gVar2.f6633e;
        gVar.f6631c = gVar2.f6631c;
        cVar.f1315e.a(this.f1315e);
        cVar.f1311a = this.f1311a;
        return cVar;
    }
}