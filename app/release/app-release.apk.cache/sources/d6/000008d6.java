package o;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class o implements Comparable {

    /* renamed from: c  reason: collision with root package name */
    public int f5831c;

    /* renamed from: a  reason: collision with root package name */
    public float f5829a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f5830b = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f5832d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f5833e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f5834f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f5835g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f5836h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f5837i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f5838j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f5839k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f5840l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f5841m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f5842n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f5843o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f5844p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public final LinkedHashMap f5845q = new LinkedHashMap();

    public static boolean b(float f4, float f5) {
        if (!Float.isNaN(f4) && !Float.isNaN(f5)) {
            if (Math.abs(f4 - f5) <= 1.0E-6f) {
                return false;
            }
            return true;
        } else if (Float.isNaN(f4) == Float.isNaN(f5)) {
            return false;
        } else {
            return true;
        }
    }

    public final void a(HashMap hashMap, int i4) {
        String concat;
        for (String str : hashMap.keySet()) {
            e0 e0Var = (e0) hashMap.get(str);
            str.getClass();
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c4 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c4 = '\r';
                        break;
                    }
                    break;
            }
            float f4 = 1.0f;
            float f5 = 0.0f;
            switch (c4) {
                case 0:
                    if (!Float.isNaN(this.f5834f)) {
                        f5 = this.f5834f;
                    }
                    e0Var.b(i4, f5);
                    break;
                case 1:
                    if (!Float.isNaN(this.f5835g)) {
                        f5 = this.f5835g;
                    }
                    e0Var.b(i4, f5);
                    break;
                case 2:
                    if (!Float.isNaN(this.f5840l)) {
                        f5 = this.f5840l;
                    }
                    e0Var.b(i4, f5);
                    break;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    if (!Float.isNaN(this.f5841m)) {
                        f5 = this.f5841m;
                    }
                    e0Var.b(i4, f5);
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    if (!Float.isNaN(this.f5842n)) {
                        f5 = this.f5842n;
                    }
                    e0Var.b(i4, f5);
                    break;
                case VisibleForTesting.NONE /* 5 */:
                    if (!Float.isNaN(this.f5844p)) {
                        f5 = this.f5844p;
                    }
                    e0Var.b(i4, f5);
                    break;
                case 6:
                    if (!Float.isNaN(this.f5836h)) {
                        f4 = this.f5836h;
                    }
                    e0Var.b(i4, f4);
                    break;
                case 7:
                    if (!Float.isNaN(this.f5837i)) {
                        f4 = this.f5837i;
                    }
                    e0Var.b(i4, f4);
                    break;
                case '\b':
                    if (!Float.isNaN(this.f5838j)) {
                        f5 = this.f5838j;
                    }
                    e0Var.b(i4, f5);
                    break;
                case '\t':
                    if (!Float.isNaN(this.f5839k)) {
                        f5 = this.f5839k;
                    }
                    e0Var.b(i4, f5);
                    break;
                case '\n':
                    if (!Float.isNaN(this.f5833e)) {
                        f5 = this.f5833e;
                    }
                    e0Var.b(i4, f5);
                    break;
                case 11:
                    if (!Float.isNaN(this.f5832d)) {
                        f5 = this.f5832d;
                    }
                    e0Var.b(i4, f5);
                    break;
                case '\f':
                    if (!Float.isNaN(this.f5843o)) {
                        f5 = this.f5843o;
                    }
                    e0Var.b(i4, f5);
                    break;
                case '\r':
                    if (!Float.isNaN(this.f5829a)) {
                        f4 = this.f5829a;
                    }
                    e0Var.b(i4, f4);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        LinkedHashMap linkedHashMap = this.f5845q;
                        if (linkedHashMap.containsKey(str2)) {
                            t.a aVar = (t.a) linkedHashMap.get(str2);
                            if (e0Var instanceof b0) {
                                ((b0) e0Var).f5791f.append(i4, aVar);
                                break;
                            } else {
                                concat = str + " splineSet not a CustomSet frame = " + i4 + ", value" + aVar.b() + e0Var;
                            }
                        } else {
                            concat = "UNKNOWN customName " + str2;
                        }
                    } else {
                        concat = "UNKNOWN spline ".concat(str);
                    }
                    Log.e("MotionPaths", concat);
                    break;
            }
        }
    }

    public final void c(q.d dVar, androidx.constraintlayout.widget.d dVar2, int i4) {
        float f4;
        dVar.o();
        dVar.p();
        androidx.constraintlayout.widget.c g4 = dVar2.g(i4);
        t.g gVar = g4.f1312b;
        int i5 = gVar.f6631c;
        this.f5830b = i5;
        int i6 = gVar.f6630b;
        this.f5831c = i6;
        if (i6 != 0 && i5 == 0) {
            f4 = 0.0f;
        } else {
            f4 = gVar.f6632d;
        }
        this.f5829a = f4;
        t.h hVar = g4.f1315e;
        boolean z4 = hVar.f6646l;
        this.f5832d = hVar.f6647m;
        this.f5833e = hVar.f6636b;
        this.f5834f = hVar.f6637c;
        this.f5835g = hVar.f6638d;
        this.f5836h = hVar.f6639e;
        this.f5837i = hVar.f6640f;
        this.f5838j = hVar.f6641g;
        this.f5839k = hVar.f6642h;
        this.f5840l = hVar.f6643i;
        this.f5841m = hVar.f6644j;
        this.f5842n = hVar.f6645k;
        t.f fVar = g4.f1313c;
        n.e.c(fVar.f6624c);
        this.f5843o = fVar.f6628g;
        this.f5844p = g4.f1312b.f6633e;
        for (String str : g4.f1316f.keySet()) {
            t.a aVar = (t.a) g4.f1316f.get(str);
            if (aVar.f6561b != ConstraintAttribute$AttributeType.f1219e) {
                this.f5845q.put(str, aVar);
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ((o) obj).getClass();
        return Float.compare(0.0f, 0.0f);
    }
}