package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import p.f;
import q.e;
import q.h;
import q.j;
import t.i;
import t.k;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: p  reason: collision with root package name */
    public static final /* synthetic */ int f1230p = 0;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f1231a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1232b;

    /* renamed from: c  reason: collision with root package name */
    public final e f1233c;

    /* renamed from: d  reason: collision with root package name */
    public int f1234d;

    /* renamed from: e  reason: collision with root package name */
    public int f1235e;

    /* renamed from: f  reason: collision with root package name */
    public int f1236f;

    /* renamed from: g  reason: collision with root package name */
    public int f1237g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1238h;

    /* renamed from: i  reason: collision with root package name */
    public int f1239i;

    /* renamed from: j  reason: collision with root package name */
    public d f1240j;

    /* renamed from: k  reason: collision with root package name */
    public t.d f1241k;

    /* renamed from: l  reason: collision with root package name */
    public int f1242l;

    /* renamed from: m  reason: collision with root package name */
    public HashMap f1243m;

    /* renamed from: n  reason: collision with root package name */
    public final SparseArray f1244n;

    /* renamed from: o  reason: collision with root package name */
    public final b f1245o;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        public final int C;
        public float D;
        public float E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public float N;
        public float O;
        public int P;
        public int Q;
        public int R;
        public boolean S;
        public boolean T;
        public String U;
        public boolean V;
        public boolean W;
        public boolean X;
        public boolean Y;
        public boolean Z;

        /* renamed from: a  reason: collision with root package name */
        public int f1246a;

        /* renamed from: a0  reason: collision with root package name */
        public boolean f1247a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1248b;

        /* renamed from: b0  reason: collision with root package name */
        public int f1249b0;

        /* renamed from: c  reason: collision with root package name */
        public float f1250c;

        /* renamed from: c0  reason: collision with root package name */
        public int f1251c0;

        /* renamed from: d  reason: collision with root package name */
        public int f1252d;

        /* renamed from: d0  reason: collision with root package name */
        public int f1253d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1254e;

        /* renamed from: e0  reason: collision with root package name */
        public int f1255e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1256f;

        /* renamed from: f0  reason: collision with root package name */
        public int f1257f0;

        /* renamed from: g  reason: collision with root package name */
        public int f1258g;

        /* renamed from: g0  reason: collision with root package name */
        public int f1259g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1260h;

        /* renamed from: h0  reason: collision with root package name */
        public float f1261h0;

        /* renamed from: i  reason: collision with root package name */
        public int f1262i;

        /* renamed from: i0  reason: collision with root package name */
        public int f1263i0;

        /* renamed from: j  reason: collision with root package name */
        public int f1264j;

        /* renamed from: j0  reason: collision with root package name */
        public int f1265j0;

        /* renamed from: k  reason: collision with root package name */
        public int f1266k;

        /* renamed from: k0  reason: collision with root package name */
        public float f1267k0;

        /* renamed from: l  reason: collision with root package name */
        public int f1268l;

        /* renamed from: l0  reason: collision with root package name */
        public q.d f1269l0;

        /* renamed from: m  reason: collision with root package name */
        public int f1270m;

        /* renamed from: n  reason: collision with root package name */
        public int f1271n;

        /* renamed from: o  reason: collision with root package name */
        public float f1272o;

        /* renamed from: p  reason: collision with root package name */
        public int f1273p;

        /* renamed from: q  reason: collision with root package name */
        public int f1274q;

        /* renamed from: r  reason: collision with root package name */
        public int f1275r;

        /* renamed from: s  reason: collision with root package name */
        public int f1276s;

        /* renamed from: t  reason: collision with root package name */
        public final int f1277t;

        /* renamed from: u  reason: collision with root package name */
        public int f1278u;

        /* renamed from: v  reason: collision with root package name */
        public final int f1279v;

        /* renamed from: w  reason: collision with root package name */
        public int f1280w;

        /* renamed from: x  reason: collision with root package name */
        public int f1281x;

        /* renamed from: y  reason: collision with root package name */
        public int f1282y;

        /* renamed from: z  reason: collision with root package name */
        public float f1283z;

        public LayoutParams() {
            super(-2, -2);
            this.f1246a = -1;
            this.f1248b = -1;
            this.f1250c = -1.0f;
            this.f1252d = -1;
            this.f1254e = -1;
            this.f1256f = -1;
            this.f1258g = -1;
            this.f1260h = -1;
            this.f1262i = -1;
            this.f1264j = -1;
            this.f1266k = -1;
            this.f1268l = -1;
            this.f1270m = -1;
            this.f1271n = 0;
            this.f1272o = 0.0f;
            this.f1273p = -1;
            this.f1274q = -1;
            this.f1275r = -1;
            this.f1276s = -1;
            this.f1277t = -1;
            this.f1278u = -1;
            this.f1279v = -1;
            this.f1280w = -1;
            this.f1281x = -1;
            this.f1282y = -1;
            this.f1283z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = null;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.f1247a0 = false;
            this.f1249b0 = -1;
            this.f1251c0 = -1;
            this.f1253d0 = -1;
            this.f1255e0 = -1;
            this.f1257f0 = -1;
            this.f1259g0 = -1;
            this.f1261h0 = 0.5f;
            this.f1269l0 = new q.d();
        }

        public final void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            int i4 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i4 == -2 && this.S) {
                this.V = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            int i5 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i5 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            if (i4 == 0 || i4 == -1) {
                this.V = false;
                if (i4 == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            if (i5 == 0 || i5 == -1) {
                this.W = false;
                if (i5 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f1250c == -1.0f && this.f1246a == -1 && this.f1248b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.f1269l0 instanceof h)) {
                this.f1269l0 = new h();
            }
            ((h) this.f1269l0).D(this.R);
        }

        /* JADX WARN: Code restructure failed: missing block: B:72:0x00ca, code lost:
            if (r1 > 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00cc, code lost:
            ((android.view.ViewGroup.MarginLayoutParams) r9).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00d9, code lost:
            if (r1 > 0) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x00eb  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instructions count: 249
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            String str;
            int i4;
            this.f1246a = -1;
            this.f1248b = -1;
            this.f1250c = -1.0f;
            this.f1252d = -1;
            this.f1254e = -1;
            this.f1256f = -1;
            this.f1258g = -1;
            this.f1260h = -1;
            this.f1262i = -1;
            this.f1264j = -1;
            this.f1266k = -1;
            this.f1268l = -1;
            this.f1270m = -1;
            this.f1271n = 0;
            this.f1272o = 0.0f;
            this.f1273p = -1;
            this.f1274q = -1;
            this.f1275r = -1;
            this.f1276s = -1;
            this.f1277t = -1;
            this.f1278u = -1;
            this.f1279v = -1;
            this.f1280w = -1;
            this.f1281x = -1;
            this.f1282y = -1;
            this.f1283z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = null;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.f1247a0 = false;
            this.f1249b0 = -1;
            this.f1251c0 = -1;
            this.f1253d0 = -1;
            this.f1255e0 = -1;
            this.f1257f0 = -1;
            this.f1259g0 = -1;
            this.f1261h0 = 0.5f;
            this.f1269l0 = new q.d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6649b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                int i6 = a.f1303a.get(index);
                switch (i6) {
                    case 1:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        continue;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1270m);
                        this.f1270m = resourceId;
                        if (resourceId == -1) {
                            this.f1270m = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                        this.f1271n = obtainStyledAttributes.getDimensionPixelSize(index, this.f1271n);
                        continue;
                    case VisibleForTesting.PROTECTED /* 4 */:
                        float f4 = obtainStyledAttributes.getFloat(index, this.f1272o) % 360.0f;
                        this.f1272o = f4;
                        if (f4 < 0.0f) {
                            this.f1272o = (360.0f - f4) % 360.0f;
                        } else {
                            continue;
                        }
                    case VisibleForTesting.NONE /* 5 */:
                        this.f1246a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1246a);
                        continue;
                    case 6:
                        this.f1248b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1248b);
                        continue;
                    case 7:
                        this.f1250c = obtainStyledAttributes.getFloat(index, this.f1250c);
                        continue;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1252d);
                        this.f1252d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1252d = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1254e);
                        this.f1254e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1254e = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1256f);
                        this.f1256f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1256f = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1258g);
                        this.f1258g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1258g = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1260h);
                        this.f1260h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1260h = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1262i);
                        this.f1262i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1262i = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1264j);
                        this.f1264j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1264j = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1266k);
                        this.f1266k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1266k = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1268l);
                        this.f1268l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1268l = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1273p);
                        this.f1273p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1273p = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1274q);
                        this.f1274q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1274q = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1275r);
                        this.f1275r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1275r = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1276s);
                        this.f1276s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1276s = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 21:
                        this.f1277t = obtainStyledAttributes.getDimensionPixelSize(index, this.f1277t);
                        continue;
                    case 22:
                        this.f1278u = obtainStyledAttributes.getDimensionPixelSize(index, this.f1278u);
                        continue;
                    case 23:
                        this.f1279v = obtainStyledAttributes.getDimensionPixelSize(index, this.f1279v);
                        continue;
                    case 24:
                        this.f1280w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1280w);
                        continue;
                    case 25:
                        this.f1281x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1281x);
                        continue;
                    case 26:
                        this.f1282y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1282y);
                        continue;
                    case 27:
                        this.S = obtainStyledAttributes.getBoolean(index, this.S);
                        continue;
                    case 28:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        continue;
                    case 29:
                        this.f1283z = obtainStyledAttributes.getFloat(index, this.f1283z);
                        continue;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        continue;
                    case 31:
                        int i7 = obtainStyledAttributes.getInt(index, 0);
                        this.H = i7;
                        if (i7 == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case 32:
                        int i8 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i8;
                        if (i8 == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case 33:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                            }
                        }
                    case 34:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                    case 35:
                        this.N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.N));
                        this.H = 2;
                        continue;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                    case 37:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                    case 38:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        continue;
                    default:
                        switch (i6) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i4 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.C = 1;
                                        }
                                        i4 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.B.substring(i4);
                                        if (substring2.length() > 0) {
                                            Float.parseFloat(substring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.B.substring(i4, indexOf2);
                                        String substring4 = this.B.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.C == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                continue;
                            case 46:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 47:
                                this.F = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                continue;
                            case 50:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                            case 51:
                                this.U = obtainStyledAttributes.getString(index);
                                continue;
                                continue;
                        }
                        break;
                }
                Log.e("ConstraintLayout", str);
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1246a = -1;
            this.f1248b = -1;
            this.f1250c = -1.0f;
            this.f1252d = -1;
            this.f1254e = -1;
            this.f1256f = -1;
            this.f1258g = -1;
            this.f1260h = -1;
            this.f1262i = -1;
            this.f1264j = -1;
            this.f1266k = -1;
            this.f1268l = -1;
            this.f1270m = -1;
            this.f1271n = 0;
            this.f1272o = 0.0f;
            this.f1273p = -1;
            this.f1274q = -1;
            this.f1275r = -1;
            this.f1276s = -1;
            this.f1277t = -1;
            this.f1278u = -1;
            this.f1279v = -1;
            this.f1280w = -1;
            this.f1281x = -1;
            this.f1282y = -1;
            this.f1283z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = null;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.f1247a0 = false;
            this.f1249b0 = -1;
            this.f1251c0 = -1;
            this.f1253d0 = -1;
            this.f1255e0 = -1;
            this.f1257f0 = -1;
            this.f1259g0 = -1;
            this.f1261h0 = 0.5f;
            this.f1269l0 = new q.d();
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        this.f1231a = new SparseArray();
        this.f1232b = new ArrayList(4);
        this.f1233c = new e();
        this.f1234d = 0;
        this.f1235e = 0;
        this.f1236f = Integer.MAX_VALUE;
        this.f1237g = Integer.MAX_VALUE;
        this.f1238h = true;
        this.f1239i = 263;
        this.f1240j = null;
        this.f1241k = null;
        this.f1242l = -1;
        this.f1243m = new HashMap();
        this.f1244n = new SparseArray();
        this.f1245o = new b(this);
        h(null, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x02f3 -> B:159:0x02f4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r20, android.view.View r21, q.d r22, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r23, android.util.SparseArray r24) {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a(boolean, android.view.View, q.d, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i4, layoutParams);
    }

    public final View c(int i4) {
        return (View) this.f1231a.get(i4);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f1232b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                ((ConstraintHelper) arrayList.get(i4)).k(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i6 = (int) ((parseInt / 1080.0f) * width);
                        int i7 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f4 = i6;
                        float f5 = i7;
                        float f6 = i6 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f4, f5, f6, f5, paint);
                        float parseInt4 = i7 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f6, f5, f6, parseInt4, paint);
                        canvas.drawLine(f6, parseInt4, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f4, f5, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f4, f5, f6, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f6, f5, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f1238h = true;
        super.forceLayout();
    }

    public final q.d g(View view) {
        if (view == this) {
            return this.f1233c;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f1269l0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f1237g;
    }

    public int getMaxWidth() {
        return this.f1236f;
    }

    public int getMinHeight() {
        return this.f1235e;
    }

    public int getMinWidth() {
        return this.f1234d;
    }

    public int getOptimizationLevel() {
        return this.f1233c.f6241t0;
    }

    public final void h(AttributeSet attributeSet, int i4) {
        e eVar = this.f1233c;
        eVar.W = this;
        b bVar = this.f1245o;
        eVar.f6232k0 = bVar;
        eVar.f6231j0.f6446f = bVar;
        this.f1231a.put(getId(), this);
        this.f1240j = null;
        boolean z4 = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6649b, i4, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == 9) {
                    this.f1234d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1234d);
                } else if (index == 10) {
                    this.f1235e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1235e);
                } else if (index == 7) {
                    this.f1236f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1236f);
                } else if (index == 8) {
                    this.f1237g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1237g);
                } else if (index == 89) {
                    this.f1239i = obtainStyledAttributes.getInt(index, this.f1239i);
                } else if (index == 38) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            l(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1241k = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f1240j = dVar;
                        dVar.h(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1240j = null;
                    }
                    this.f1242l = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        int i6 = this.f1239i;
        eVar.f6241t0 = i6;
        if ((i6 & 256) == 256) {
            z4 = true;
        }
        f.f6079p = z4;
    }

    public final boolean k() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, t.d] */
    public void l(int i4) {
        boolean z4;
        Context context = getContext();
        ?? obj = new Object();
        obj.f6577a = -1;
        obj.f6578b = -1;
        obj.f6581e = new SparseArray();
        obj.f6582f = new SparseArray();
        t.b bVar = null;
        obj.f6583g = null;
        obj.f6579c = this;
        XmlResourceParser xml = context.getResources().getXml(i4);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    z4 = false;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            default:
                                z4 = true;
                                break;
                        }
                        if (z4 && !z4) {
                            if (!z4) {
                                if (!z4) {
                                    if (!z4) {
                                        Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                        continue;
                                    } else {
                                        obj.c(context, xml);
                                        continue;
                                    }
                                } else {
                                    t.c cVar = new t.c(context, xml);
                                    if (bVar != null) {
                                        bVar.f6568b.add(cVar);
                                        continue;
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                bVar = new t.b(context, xml);
                                ((SparseArray) obj.f6581e).put(bVar.f6567a, bVar);
                                continue;
                            }
                        }
                    }
                } else {
                    xml.getName();
                    continue;
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
        this.f1241k = obj;
    }

    public final void m(int i4, int i5, int i6, int i7, boolean z4, boolean z5) {
        b bVar = this.f1245o;
        int i8 = bVar.f1308e;
        int resolveSizeAndState = View.resolveSizeAndState(i6 + bVar.f1307d, i4, 0);
        int min = Math.min(this.f1236f, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1237g, View.resolveSizeAndState(i7 + i8, i5, 0) & 16777215);
        if (z4) {
            min |= 16777216;
        }
        if (z5) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:361:0x0710, code lost:
        if (r8 != false) goto L278;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(q.e r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 1833
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.n(q.e, int, int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            q.d dVar = layoutParams.f1269l0;
            if ((childAt.getVisibility() != 8 || layoutParams.Y || layoutParams.Z || isInEditMode) && !layoutParams.f1247a0) {
                int o4 = dVar.o();
                int p4 = dVar.p();
                int n4 = dVar.n() + o4;
                int k4 = dVar.k() + p4;
                childAt.layout(o4, p4, n4, k4);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(o4, p4, n4, k4);
                }
            }
        }
        ArrayList arrayList = this.f1232b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                ((ConstraintHelper) arrayList.get(i9)).j();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        boolean z4;
        String resourceName;
        int id;
        q.d dVar;
        boolean k4 = k();
        e eVar = this.f1233c;
        eVar.f6233l0 = k4;
        if (this.f1238h) {
            int i6 = 0;
            this.f1238h = false;
            int childCount = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 < childCount) {
                    if (getChildAt(i7).isLayoutRequested()) {
                        z4 = true;
                        break;
                    }
                    i7++;
                } else {
                    z4 = false;
                    break;
                }
            }
            if (z4) {
                boolean isInEditMode = isInEditMode();
                int childCount2 = getChildCount();
                for (int i8 = 0; i8 < childCount2; i8++) {
                    q.d g4 = g(getChildAt(i8));
                    if (g4 != null) {
                        g4.u();
                    }
                }
                Object obj = null;
                if (isInEditMode) {
                    for (int i9 = 0; i9 < childCount2; i9++) {
                        View childAt = getChildAt(i9);
                        try {
                            resourceName = getResources().getResourceName(childAt.getId());
                            setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                            int indexOf = resourceName.indexOf(47);
                            if (indexOf != -1) {
                                resourceName = resourceName.substring(indexOf + 1);
                            }
                            id = childAt.getId();
                        } catch (Resources.NotFoundException unused) {
                        }
                        if (id != 0) {
                            View view = (View) this.f1231a.get(id);
                            if (view == null && (view = findViewById(id)) != null && view != this && view.getParent() == this) {
                                onViewAdded(view);
                            }
                            if (view != this) {
                                if (view == null) {
                                    dVar = null;
                                } else {
                                    dVar = ((LayoutParams) view.getLayoutParams()).f1269l0;
                                }
                                dVar.Y = resourceName;
                            }
                        }
                        dVar = eVar;
                        dVar.Y = resourceName;
                    }
                }
                if (this.f1242l != -1) {
                    for (int i10 = 0; i10 < childCount2; i10++) {
                        View childAt2 = getChildAt(i10);
                        if (childAt2.getId() == this.f1242l && (childAt2 instanceof Constraints)) {
                            this.f1240j = ((Constraints) childAt2).getConstraintSet();
                        }
                    }
                }
                d dVar2 = this.f1240j;
                if (dVar2 != null) {
                    dVar2.c(this);
                }
                eVar.f6229h0.clear();
                ArrayList arrayList = this.f1232b;
                int size = arrayList.size();
                if (size > 0) {
                    int i11 = 0;
                    while (i11 < size) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) arrayList.get(i11);
                        if (constraintHelper.isInEditMode()) {
                            constraintHelper.setIds(constraintHelper.f1227e);
                        }
                        j jVar = constraintHelper.f1226d;
                        if (jVar != null) {
                            jVar.f6285i0 = i6;
                            Arrays.fill(jVar.f6284h0, obj);
                            for (int i12 = i6; i12 < constraintHelper.f1224b; i12++) {
                                int i13 = constraintHelper.f1223a[i12];
                                View c4 = c(i13);
                                if (c4 == null) {
                                    Integer valueOf = Integer.valueOf(i13);
                                    HashMap hashMap = constraintHelper.f1229g;
                                    String str = (String) hashMap.get(valueOf);
                                    int d4 = constraintHelper.d(this, str);
                                    if (d4 != 0) {
                                        constraintHelper.f1223a[i12] = d4;
                                        hashMap.put(Integer.valueOf(d4), str);
                                        c4 = c(d4);
                                    }
                                }
                                if (c4 != null) {
                                    constraintHelper.f1226d.D(g(c4));
                                }
                            }
                            constraintHelper.f1226d.a();
                        }
                        i11++;
                        i6 = 0;
                        obj = null;
                    }
                }
                for (int i14 = 0; i14 < childCount2; i14++) {
                    View childAt3 = getChildAt(i14);
                    if (childAt3 instanceof Placeholder) {
                        Placeholder placeholder = (Placeholder) childAt3;
                        if (placeholder.f1298a == -1 && !placeholder.isInEditMode()) {
                            placeholder.setVisibility(placeholder.f1300c);
                        }
                        View findViewById = findViewById(placeholder.f1298a);
                        placeholder.f1299b = findViewById;
                        if (findViewById != null) {
                            ((LayoutParams) findViewById.getLayoutParams()).f1247a0 = true;
                            placeholder.f1299b.setVisibility(0);
                            placeholder.setVisibility(0);
                        }
                    }
                }
                SparseArray sparseArray = this.f1244n;
                sparseArray.clear();
                sparseArray.put(0, eVar);
                sparseArray.put(getId(), eVar);
                for (int i15 = 0; i15 < childCount2; i15++) {
                    View childAt4 = getChildAt(i15);
                    sparseArray.put(childAt4.getId(), g(childAt4));
                }
                for (int i16 = 0; i16 < childCount2; i16++) {
                    View childAt5 = getChildAt(i16);
                    q.d g5 = g(childAt5);
                    if (g5 != null) {
                        LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                        eVar.f6229h0.add(g5);
                        q.d dVar3 = g5.K;
                        if (dVar3 != null) {
                            ((e) dVar3).f6229h0.remove(g5);
                            g5.K = null;
                        }
                        g5.K = eVar;
                        a(isInEditMode, childAt5, g5, layoutParams, sparseArray);
                    }
                }
            }
            if (z4) {
                eVar.H();
            }
        }
        n(eVar, this.f1239i, i4, i5);
        m(i4, i5, eVar.n(), eVar.k(), eVar.f6242u0, eVar.f6243v0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        q.d g4 = g(view);
        if ((view instanceof Guideline) && !(g4 instanceof h)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            h hVar = new h();
            layoutParams.f1269l0 = hVar;
            layoutParams.Y = true;
            hVar.D(layoutParams.R);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.l();
            ((LayoutParams) view.getLayoutParams()).Z = true;
            ArrayList arrayList = this.f1232b;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.f1231a.put(view.getId(), view);
        this.f1238h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1231a.remove(view.getId());
        q.d g4 = g(view);
        this.f1233c.f6229h0.remove(g4);
        g4.K = null;
        this.f1232b.remove(view);
        this.f1238h = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1238h = true;
        super.requestLayout();
    }

    public void setConstraintSet(d dVar) {
        this.f1240j = dVar;
    }

    public void setDesignInformation(int i4, Object obj, Object obj2) {
        if (i4 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1243m == null) {
                this.f1243m = new HashMap();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f1243m.put(str, num);
        }
    }

    @Override // android.view.View
    public void setId(int i4) {
        int id = getId();
        SparseArray sparseArray = this.f1231a;
        sparseArray.remove(id);
        super.setId(i4);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i4) {
        if (i4 == this.f1237g) {
            return;
        }
        this.f1237g = i4;
        requestLayout();
    }

    public void setMaxWidth(int i4) {
        if (i4 == this.f1236f) {
            return;
        }
        this.f1236f = i4;
        requestLayout();
    }

    public void setMinHeight(int i4) {
        if (i4 == this.f1235e) {
            return;
        }
        this.f1235e = i4;
        requestLayout();
    }

    public void setMinWidth(int i4) {
        if (i4 == this.f1234d) {
            return;
        }
        this.f1234d = i4;
        requestLayout();
    }

    public void setOnConstraintsChanged(i iVar) {
        t.d dVar = this.f1241k;
        if (dVar != null) {
            dVar.f6583g = iVar;
        }
    }

    public void setOptimizationLevel(int i4) {
        boolean z4;
        this.f1239i = i4;
        this.f1233c.f6241t0 = i4;
        if ((i4 & 256) == 256) {
            z4 = true;
        } else {
            z4 = false;
        }
        f.f6079p = z4;
    }

    public void setState(int i4, int i5, int i6) {
        t.d dVar = this.f1241k;
        if (dVar != null) {
            dVar.e(i5, i6, i4);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1231a = new SparseArray();
        this.f1232b = new ArrayList(4);
        this.f1233c = new e();
        this.f1234d = 0;
        this.f1235e = 0;
        this.f1236f = Integer.MAX_VALUE;
        this.f1237g = Integer.MAX_VALUE;
        this.f1238h = true;
        this.f1239i = 263;
        this.f1240j = null;
        this.f1241k = null;
        this.f1242l = -1;
        this.f1243m = new HashMap();
        this.f1244n = new SparseArray();
        this.f1245o = new b(this);
        h(attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1231a = new SparseArray();
        this.f1232b = new ArrayList(4);
        this.f1233c = new e();
        this.f1234d = 0;
        this.f1235e = 0;
        this.f1236f = Integer.MAX_VALUE;
        this.f1237g = Integer.MAX_VALUE;
        this.f1238h = true;
        this.f1239i = 263;
        this.f1240j = null;
        this.f1241k = null;
        this.f1242l = -1;
        this.f1243m = new HashMap();
        this.f1244n = new SparseArray();
        this.f1245o = new b(this);
        h(attributeSet, i4);
    }
}