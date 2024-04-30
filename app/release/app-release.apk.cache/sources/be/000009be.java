package t3;

import androidx.fragment.app.m0;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class o extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f6765e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f6766f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List f6767g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, s sVar, int i4, List list, boolean z4) {
        super(str, true);
        this.f6765e = sVar;
        this.f6766f = i4;
        this.f6767g = list;
    }

    @Override // p3.a
    public final long a() {
        m0 m0Var = this.f6765e.f6788l;
        List list = this.f6767g;
        m0Var.getClass();
        com.google.common.collect.c.F(list, "responseHeaders");
        try {
            this.f6765e.f6801y.C(this.f6766f, ErrorCode.f6038g);
            synchronized (this.f6765e) {
                this.f6765e.A.remove(Integer.valueOf(this.f6766f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}