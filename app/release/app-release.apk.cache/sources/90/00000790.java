package i2;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f5041a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5042b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5043c;

    public b(com.google.android.material.internal.c cVar, Typeface typeface) {
        this.f5041a = typeface;
        this.f5042b = cVar;
    }

    @Override // i2.h
    public final void a(int i4) {
        if (!this.f5043c) {
            com.google.android.material.internal.c cVar = (com.google.android.material.internal.c) this.f5042b;
            int i5 = cVar.f3489a;
            Typeface typeface = this.f5041a;
            com.google.android.material.internal.d dVar = cVar.f3490b;
            switch (i5) {
                case 0:
                    if (dVar.m(typeface)) {
                        dVar.i(false);
                        return;
                    }
                    return;
                default:
                    if (dVar.o(typeface)) {
                        dVar.i(false);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // i2.h
    public final void b(Typeface typeface, boolean z4) {
        if (!this.f5043c) {
            com.google.android.material.internal.c cVar = (com.google.android.material.internal.c) this.f5042b;
            int i4 = cVar.f3489a;
            com.google.android.material.internal.d dVar = cVar.f3490b;
            switch (i4) {
                case 0:
                    if (dVar.m(typeface)) {
                        dVar.i(false);
                        return;
                    }
                    return;
                default:
                    if (dVar.o(typeface)) {
                        dVar.i(false);
                        return;
                    }
                    return;
            }
        }
    }
}