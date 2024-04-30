package t3;

import androidx.fragment.app.m0;
import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class n extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f6761e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f6762f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ y3.f f6763g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6764h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, s sVar, int i4, y3.f fVar, int i5, boolean z4) {
        super(str, true);
        this.f6761e = sVar;
        this.f6762f = i4;
        this.f6763g = fVar;
        this.f6764h = i5;
    }

    @Override // p3.a
    public final long a() {
        try {
            m0 m0Var = this.f6761e.f6788l;
            y3.f fVar = this.f6763g;
            int i4 = this.f6764h;
            m0Var.getClass();
            com.google.common.collect.c.F(fVar, "source");
            fVar.h(i4);
            this.f6761e.f6801y.C(this.f6762f, ErrorCode.f6038g);
            synchronized (this.f6761e) {
                this.f6761e.A.remove(Integer.valueOf(this.f6762f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}