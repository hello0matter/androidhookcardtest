package t3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class r extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f6774e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f6775f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f6776g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, s sVar, int i4, long j4) {
        super(str, true);
        this.f6774e = sVar;
        this.f6775f = i4;
        this.f6776g = j4;
    }

    @Override // p3.a
    public final long a() {
        s sVar = this.f6774e;
        try {
            sVar.f6801y.D(this.f6775f, this.f6776g);
            return -1L;
        } catch (IOException e4) {
            sVar.y(e4);
            return -1L;
        }
    }
}