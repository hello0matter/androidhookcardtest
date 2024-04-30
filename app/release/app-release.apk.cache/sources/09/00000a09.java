package w0;

import androidx.activity.j;
import androidx.lifecycle.h0;
import l.l;

/* loaded from: classes.dex */
public final class b extends h0 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f7018d = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final l f7019c = new l();

    @Override // androidx.lifecycle.h0
    public final void a() {
        l lVar = this.f7019c;
        int i4 = lVar.f5256c;
        if (i4 <= 0) {
            Object[] objArr = lVar.f5255b;
            for (int i5 = 0; i5 < i4; i5++) {
                objArr[i5] = null;
            }
            lVar.f5256c = 0;
            return;
        }
        j.f(lVar.f5255b[0]);
        throw null;
    }
}