package androidx.emoji2.text;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final r0.b f1507a;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f1508b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f1509c = new c0(1024);

    /* renamed from: d  reason: collision with root package name */
    public final Typeface f1510d;

    public d0(Typeface typeface, r0.b bVar) {
        int i4;
        int i5;
        int i6;
        boolean z4;
        this.f1510d = typeface;
        this.f1507a = bVar;
        int a5 = bVar.a(6);
        if (a5 != 0) {
            int i7 = a5 + bVar.f6451a;
            i4 = bVar.f6452b.getInt(bVar.f6452b.getInt(i7) + i7);
        } else {
            i4 = 0;
        }
        this.f1508b = new char[i4 * 2];
        int a6 = bVar.a(6);
        if (a6 != 0) {
            int i8 = a6 + bVar.f6451a;
            i5 = bVar.f6452b.getInt(bVar.f6452b.getInt(i8) + i8);
        } else {
            i5 = 0;
        }
        for (int i9 = 0; i9 < i5; i9++) {
            t tVar = new t(this, i9);
            r0.a c4 = tVar.c();
            int a7 = c4.a(4);
            if (a7 != 0) {
                i6 = c4.f6452b.getInt(a7 + c4.f6451a);
            } else {
                i6 = 0;
            }
            Character.toChars(i6, this.f1508b, i9 * 2);
            if (tVar.b() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            h0.e.a("invalid metadata codepoint length", z4);
            this.f1509c.a(tVar, 0, tVar.b() - 1);
        }
    }
}