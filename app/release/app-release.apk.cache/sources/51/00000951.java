package q0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h implements a {

    /* renamed from: l  reason: collision with root package name */
    public static final e f6300l = new e("scaleX", 8);

    /* renamed from: m  reason: collision with root package name */
    public static final e f6301m = new e("scaleY", 9);

    /* renamed from: n  reason: collision with root package name */
    public static final e f6302n = new e("rotation", 10);

    /* renamed from: o  reason: collision with root package name */
    public static final e f6303o = new e("rotationX", 11);

    /* renamed from: p  reason: collision with root package name */
    public static final e f6304p = new e("rotationY", 12);

    /* renamed from: q  reason: collision with root package name */
    public static final e f6305q = new e("alpha", 2);

    /* renamed from: a  reason: collision with root package name */
    public float f6306a;

    /* renamed from: b  reason: collision with root package name */
    public float f6307b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6308c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f6309d;

    /* renamed from: e  reason: collision with root package name */
    public final g0.i f6310e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6311f;

    /* renamed from: g  reason: collision with root package name */
    public final float f6312g;

    /* renamed from: h  reason: collision with root package name */
    public long f6313h;

    /* renamed from: i  reason: collision with root package name */
    public final float f6314i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f6315j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f6316k;

    public h(Object obj) {
        float f4;
        h2.h hVar = h2.i.f4844q;
        this.f6306a = 0.0f;
        this.f6307b = Float.MAX_VALUE;
        this.f6308c = false;
        this.f6311f = false;
        this.f6312g = -3.4028235E38f;
        this.f6313h = 0L;
        this.f6315j = new ArrayList();
        this.f6316k = new ArrayList();
        this.f6309d = obj;
        this.f6310e = hVar;
        if (hVar != f6302n && hVar != f6303o && hVar != f6304p) {
            if (hVar == f6305q || hVar == f6300l || hVar == f6301m) {
                this.f6314i = 0.00390625f;
                return;
            }
            f4 = 1.0f;
        } else {
            f4 = 0.1f;
        }
        this.f6314i = f4;
    }

    public final void a(float f4) {
        this.f6310e.d(this.f6309d, f4);
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f6316k;
            if (i4 < arrayList.size()) {
                if (arrayList.get(i4) == null) {
                    i4++;
                } else {
                    androidx.activity.j.f(arrayList.get(i4));
                    throw null;
                }
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
        }
    }
}