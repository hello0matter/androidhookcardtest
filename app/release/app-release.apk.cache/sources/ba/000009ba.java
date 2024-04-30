package t3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class k extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f6753e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f6754f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f6755g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str, s sVar, int i4, int i5) {
        super(str, true);
        this.f6753e = sVar;
        this.f6754f = i4;
        this.f6755g = i5;
    }

    @Override // p3.a
    public final long a() {
        int i4 = this.f6754f;
        int i5 = this.f6755g;
        s sVar = this.f6753e;
        sVar.getClass();
        try {
            sVar.f6801y.B(i4, i5, true);
            return -1L;
        } catch (IOException e4) {
            sVar.y(e4);
            return -1L;
        }
    }
}