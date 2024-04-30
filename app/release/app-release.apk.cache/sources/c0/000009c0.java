package t3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class q extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f6772e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f6773f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str, s sVar, long j4) {
        super(str, true);
        this.f6772e = sVar;
        this.f6773f = j4;
    }

    @Override // p3.a
    public final long a() {
        s sVar;
        boolean z4;
        synchronized (this.f6772e) {
            sVar = this.f6772e;
            long j4 = sVar.f6790n;
            long j5 = sVar.f6789m;
            if (j4 < j5) {
                z4 = true;
            } else {
                sVar.f6789m = j5 + 1;
                z4 = false;
            }
        }
        if (z4) {
            sVar.y(null);
            return -1L;
        }
        try {
            sVar.f6801y.B(1, 0, false);
        } catch (IOException e4) {
            sVar.y(e4);
        }
        return this.f6773f;
    }
}