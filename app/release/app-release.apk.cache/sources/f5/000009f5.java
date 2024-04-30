package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final j f6983a;

    /* renamed from: b  reason: collision with root package name */
    public final List f6984b;

    /* renamed from: c  reason: collision with root package name */
    public final List f6985c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f6986d;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f6987e;

    /* renamed from: f  reason: collision with root package name */
    public final float f6988f;

    /* renamed from: g  reason: collision with root package name */
    public final float f6989g;

    public k(j jVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f6983a = jVar;
        this.f6984b = Collections.unmodifiableList(arrayList);
        this.f6985c = Collections.unmodifiableList(arrayList2);
        float f4 = ((j) arrayList.get(arrayList.size() - 1)).b().f6975a - jVar.b().f6975a;
        this.f6988f = f4;
        float f5 = jVar.d().f6975a - ((j) arrayList2.get(arrayList2.size() - 1)).d().f6975a;
        this.f6989g = f5;
        this.f6986d = a(f4, arrayList, true);
        this.f6987e = a(f5, arrayList2, false);
    }

    public static float[] a(float f4, ArrayList arrayList, boolean z4) {
        float f5;
        float f6;
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i4 = 1; i4 < size; i4++) {
            int i5 = i4 - 1;
            j jVar = (j) arrayList.get(i5);
            j jVar2 = (j) arrayList.get(i4);
            if (z4) {
                f5 = jVar2.b().f6975a - jVar.b().f6975a;
            } else {
                f5 = jVar.d().f6975a - jVar2.d().f6975a;
            }
            float f7 = f5 / f4;
            if (i4 == size - 1) {
                f6 = 1.0f;
            } else {
                f6 = fArr[i5] + f7;
            }
            fArr[i4] = f6;
        }
        return fArr;
    }

    public static j b(j jVar, int i4, int i5, float f4, int i6, int i7) {
        boolean z4;
        ArrayList arrayList = new ArrayList(jVar.f6980b);
        arrayList.add(i5, (i) arrayList.remove(i4));
        h hVar = new h(jVar.f6979a);
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            i iVar = (i) arrayList.get(i8);
            float f5 = iVar.f6978d;
            float f6 = (f5 / 2.0f) + f4;
            if (i8 >= i6 && i8 <= i7) {
                z4 = true;
            } else {
                z4 = false;
            }
            hVar.a(f6, iVar.f6977c, f5, z4);
            f4 += iVar.f6978d;
        }
        return hVar.b();
    }
}