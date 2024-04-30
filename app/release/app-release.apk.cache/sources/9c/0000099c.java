package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: k0  reason: collision with root package name */
    public static final SparseIntArray f6584k0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public float P;
    public float Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public float Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6585a;

    /* renamed from: a0  reason: collision with root package name */
    public float f6586a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6587b;

    /* renamed from: b0  reason: collision with root package name */
    public int f6588b0;

    /* renamed from: c  reason: collision with root package name */
    public int f6589c;

    /* renamed from: c0  reason: collision with root package name */
    public int f6590c0;

    /* renamed from: d  reason: collision with root package name */
    public int f6591d;

    /* renamed from: d0  reason: collision with root package name */
    public int f6592d0;

    /* renamed from: e  reason: collision with root package name */
    public int f6593e;

    /* renamed from: e0  reason: collision with root package name */
    public int[] f6594e0;

    /* renamed from: f  reason: collision with root package name */
    public int f6595f;

    /* renamed from: f0  reason: collision with root package name */
    public String f6596f0;

    /* renamed from: g  reason: collision with root package name */
    public float f6597g;

    /* renamed from: g0  reason: collision with root package name */
    public String f6598g0;

    /* renamed from: h  reason: collision with root package name */
    public int f6599h;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f6600h0;

    /* renamed from: i  reason: collision with root package name */
    public int f6601i;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f6602i0;

    /* renamed from: j  reason: collision with root package name */
    public int f6603j;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f6604j0;

    /* renamed from: k  reason: collision with root package name */
    public int f6605k;

    /* renamed from: l  reason: collision with root package name */
    public int f6606l;

    /* renamed from: m  reason: collision with root package name */
    public int f6607m;

    /* renamed from: n  reason: collision with root package name */
    public int f6608n;

    /* renamed from: o  reason: collision with root package name */
    public int f6609o;

    /* renamed from: p  reason: collision with root package name */
    public int f6610p;

    /* renamed from: q  reason: collision with root package name */
    public int f6611q;

    /* renamed from: r  reason: collision with root package name */
    public int f6612r;

    /* renamed from: s  reason: collision with root package name */
    public int f6613s;

    /* renamed from: t  reason: collision with root package name */
    public int f6614t;

    /* renamed from: u  reason: collision with root package name */
    public float f6615u;

    /* renamed from: v  reason: collision with root package name */
    public float f6616v;

    /* renamed from: w  reason: collision with root package name */
    public String f6617w;

    /* renamed from: x  reason: collision with root package name */
    public int f6618x;

    /* renamed from: y  reason: collision with root package name */
    public int f6619y;

    /* renamed from: z  reason: collision with root package name */
    public float f6620z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6584k0 = sparseIntArray;
        sparseIntArray.append(38, 24);
        sparseIntArray.append(39, 25);
        sparseIntArray.append(41, 28);
        sparseIntArray.append(42, 29);
        sparseIntArray.append(47, 35);
        sparseIntArray.append(46, 34);
        sparseIntArray.append(20, 4);
        sparseIntArray.append(19, 3);
        sparseIntArray.append(17, 1);
        sparseIntArray.append(55, 6);
        sparseIntArray.append(56, 7);
        sparseIntArray.append(27, 17);
        sparseIntArray.append(28, 18);
        sparseIntArray.append(29, 19);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(43, 31);
        sparseIntArray.append(44, 32);
        sparseIntArray.append(26, 10);
        sparseIntArray.append(25, 9);
        sparseIntArray.append(59, 13);
        sparseIntArray.append(62, 16);
        sparseIntArray.append(60, 14);
        sparseIntArray.append(57, 11);
        sparseIntArray.append(61, 15);
        sparseIntArray.append(58, 12);
        sparseIntArray.append(50, 38);
        sparseIntArray.append(36, 37);
        sparseIntArray.append(35, 39);
        sparseIntArray.append(49, 40);
        sparseIntArray.append(34, 20);
        sparseIntArray.append(48, 36);
        sparseIntArray.append(24, 5);
        sparseIntArray.append(37, 76);
        sparseIntArray.append(45, 76);
        sparseIntArray.append(40, 76);
        sparseIntArray.append(18, 76);
        sparseIntArray.append(16, 76);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(21, 61);
        sparseIntArray.append(23, 62);
        sparseIntArray.append(22, 63);
        sparseIntArray.append(54, 69);
        sparseIntArray.append(33, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
    }

    public final void a(e eVar) {
        this.f6585a = eVar.f6585a;
        this.f6589c = eVar.f6589c;
        this.f6587b = eVar.f6587b;
        this.f6591d = eVar.f6591d;
        this.f6593e = eVar.f6593e;
        this.f6595f = eVar.f6595f;
        this.f6597g = eVar.f6597g;
        this.f6599h = eVar.f6599h;
        this.f6601i = eVar.f6601i;
        this.f6603j = eVar.f6603j;
        this.f6605k = eVar.f6605k;
        this.f6606l = eVar.f6606l;
        this.f6607m = eVar.f6607m;
        this.f6608n = eVar.f6608n;
        this.f6609o = eVar.f6609o;
        this.f6610p = eVar.f6610p;
        this.f6611q = eVar.f6611q;
        this.f6612r = eVar.f6612r;
        this.f6613s = eVar.f6613s;
        this.f6614t = eVar.f6614t;
        this.f6615u = eVar.f6615u;
        this.f6616v = eVar.f6616v;
        this.f6617w = eVar.f6617w;
        this.f6618x = eVar.f6618x;
        this.f6619y = eVar.f6619y;
        this.f6620z = eVar.f6620z;
        this.A = eVar.A;
        this.B = eVar.B;
        this.C = eVar.C;
        this.D = eVar.D;
        this.E = eVar.E;
        this.F = eVar.F;
        this.G = eVar.G;
        this.H = eVar.H;
        this.I = eVar.I;
        this.J = eVar.J;
        this.K = eVar.K;
        this.L = eVar.L;
        this.M = eVar.M;
        this.N = eVar.N;
        this.O = eVar.O;
        this.P = eVar.P;
        this.Q = eVar.Q;
        this.R = eVar.R;
        this.S = eVar.S;
        this.T = eVar.T;
        this.U = eVar.U;
        this.V = eVar.V;
        this.W = eVar.W;
        this.X = eVar.X;
        this.Y = eVar.Y;
        this.Z = eVar.Z;
        this.f6586a0 = eVar.f6586a0;
        this.f6588b0 = eVar.f6588b0;
        this.f6590c0 = eVar.f6590c0;
        this.f6592d0 = eVar.f6592d0;
        this.f6598g0 = eVar.f6598g0;
        int[] iArr = eVar.f6594e0;
        if (iArr != null) {
            this.f6594e0 = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.f6594e0 = null;
        }
        this.f6596f0 = eVar.f6596f0;
        this.f6600h0 = eVar.f6600h0;
        this.f6602i0 = eVar.f6602i0;
        this.f6604j0 = eVar.f6604j0;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        StringBuilder sb;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6654g);
        this.f6587b = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            SparseIntArray sparseIntArray = f6584k0;
            int i5 = sparseIntArray.get(index);
            if (i5 != 80) {
                if (i5 != 81) {
                    switch (i5) {
                        case 1:
                            this.f6610p = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6610p);
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                            this.f6609o = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6609o);
                            continue;
                        case VisibleForTesting.PROTECTED /* 4 */:
                            this.f6608n = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6608n);
                            continue;
                        case VisibleForTesting.NONE /* 5 */:
                            this.f6617w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            continue;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 8:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 9:
                            this.f6614t = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6614t);
                            continue;
                        case 10:
                            this.f6613s = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6613s);
                            continue;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 17:
                            this.f6593e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f6593e);
                            continue;
                        case 18:
                            this.f6595f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f6595f);
                            continue;
                        case 19:
                            this.f6597g = obtainStyledAttributes.getFloat(index, this.f6597g);
                            continue;
                        case 20:
                            this.f6615u = obtainStyledAttributes.getFloat(index, this.f6615u);
                            continue;
                        case 21:
                            this.f6591d = obtainStyledAttributes.getLayoutDimension(index, this.f6591d);
                            continue;
                        case 22:
                            this.f6589c = obtainStyledAttributes.getLayoutDimension(index, this.f6589c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            this.f6599h = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6599h);
                            continue;
                        case 25:
                            this.f6601i = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6601i);
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            this.f6603j = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6603j);
                            continue;
                        case 29:
                            this.f6605k = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6605k);
                            continue;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 31:
                            this.f6611q = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6611q);
                            continue;
                        case 32:
                            this.f6612r = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6612r);
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            this.f6607m = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6607m);
                            continue;
                        case 35:
                            this.f6606l = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6606l);
                            continue;
                        case 36:
                            this.f6616v = obtainStyledAttributes.getFloat(index, this.f6616v);
                            continue;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            continue;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            continue;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        default:
                            switch (i5) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    continue;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    continue;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                default:
                                    switch (i5) {
                                        case 61:
                                            this.f6618x = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6618x);
                                            continue;
                                        case 62:
                                            this.f6619y = obtainStyledAttributes.getDimensionPixelSize(index, this.f6619y);
                                            continue;
                                        case 63:
                                            this.f6620z = obtainStyledAttributes.getFloat(index, this.f6620z);
                                            continue;
                                        default:
                                            switch (i5) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f6586a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f6588b0 = obtainStyledAttributes.getInt(index, this.f6588b0);
                                                    break;
                                                case 73:
                                                    this.f6590c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f6590c0);
                                                    break;
                                                case 74:
                                                    this.f6596f0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f6604j0 = obtainStyledAttributes.getBoolean(index, this.f6604j0);
                                                    break;
                                                case 76:
                                                    sb = new StringBuilder("unused attribute 0x");
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(sparseIntArray.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 77:
                                                    this.f6598g0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    sb = new StringBuilder("Unknown attribute 0x");
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(sparseIntArray.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.f6602i0 = obtainStyledAttributes.getBoolean(index, this.f6602i0);
                }
            } else {
                this.f6600h0 = obtainStyledAttributes.getBoolean(index, this.f6600h0);
            }
        }
        obtainStyledAttributes.recycle();
    }
}