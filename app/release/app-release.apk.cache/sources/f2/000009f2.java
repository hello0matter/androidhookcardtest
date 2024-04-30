package v1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final float f6968a;

    /* renamed from: c  reason: collision with root package name */
    public i f6970c;

    /* renamed from: d  reason: collision with root package name */
    public i f6971d;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f6969b = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public int f6972e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f6973f = -1;

    /* renamed from: g  reason: collision with root package name */
    public float f6974g = 0.0f;

    public h(float f4) {
        this.f6968a = f4;
    }

    public final void a(float f4, float f5, float f6, boolean z4) {
        if (f6 <= 0.0f) {
            return;
        }
        i iVar = new i(Float.MIN_VALUE, f4, f5, f6);
        ArrayList arrayList = this.f6969b;
        i iVar2 = this.f6970c;
        if (z4) {
            if (iVar2 == null) {
                this.f6970c = iVar;
                this.f6972e = arrayList.size();
            }
            if (this.f6973f != -1 && arrayList.size() - this.f6973f > 1) {
                throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
            }
            if (f6 == this.f6970c.f6978d) {
                this.f6971d = iVar;
                this.f6973f = arrayList.size();
            } else {
                throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
            }
        } else if (iVar2 == null && f6 < this.f6974g) {
            throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
        } else {
            if (this.f6971d != null && f6 > this.f6974g) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
        }
        this.f6974g = f6;
        arrayList.add(iVar);
    }

    public final j b() {
        if (this.f6970c != null) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (true) {
                ArrayList arrayList2 = this.f6969b;
                int size = arrayList2.size();
                float f4 = this.f6968a;
                if (i4 < size) {
                    i iVar = (i) arrayList2.get(i4);
                    arrayList.add(new i((i4 * f4) + (this.f6970c.f6976b - (this.f6972e * f4)), iVar.f6976b, iVar.f6977c, iVar.f6978d));
                    i4++;
                } else {
                    return new j(f4, arrayList, this.f6972e, this.f6973f);
                }
            }
        } else {
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }
}