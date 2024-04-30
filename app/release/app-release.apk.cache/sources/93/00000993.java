package s3;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import m3.m;
import m3.o;
import m3.s;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: d  reason: collision with root package name */
    public final o f6543d;

    /* renamed from: e  reason: collision with root package name */
    public long f6544e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6545f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h f6546g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar, o oVar) {
        super(hVar);
        com.google.common.collect.c.F(oVar, "url");
        this.f6546g = hVar;
        this.f6543d = oVar;
        this.f6544e = -1L;
        this.f6545f = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6538b) {
            return;
        }
        if (this.f6545f && !n3.b.h(this, TimeUnit.MILLISECONDS)) {
            this.f6546g.f6554b.k();
            x();
        }
        this.f6538b = true;
    }

    @Override // s3.b, y3.t
    public final long w(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "sink");
        if (j4 >= 0) {
            if (!this.f6538b) {
                if (!this.f6545f) {
                    return -1L;
                }
                long j5 = this.f6544e;
                int i4 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
                h hVar = this.f6546g;
                if (i4 == 0 || j5 == -1) {
                    if (j5 != -1) {
                        hVar.f6555c.n();
                    }
                    try {
                        this.f6544e = hVar.f6555c.t();
                        String obj = kotlin.text.b.C2(hVar.f6555c.n()).toString();
                        if (this.f6544e >= 0 && (obj.length() <= 0 || l3.g.o2(obj, ";", false))) {
                            if (this.f6544e == 0) {
                                this.f6545f = false;
                                hVar.f6559g = hVar.f6558f.a();
                                s sVar = hVar.f6553a;
                                com.google.common.collect.c.C(sVar);
                                m mVar = hVar.f6559g;
                                com.google.common.collect.c.C(mVar);
                                r3.e.b(sVar.f5586j, this.f6543d, mVar);
                                x();
                            }
                            if (!this.f6545f) {
                                return -1L;
                            }
                        } else {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f6544e + obj + '\"');
                        }
                    } catch (NumberFormatException e4) {
                        throw new ProtocolException(e4.getMessage());
                    }
                }
                long w4 = super.w(fVar, Math.min(j4, this.f6544e));
                if (w4 != -1) {
                    this.f6544e -= w4;
                    return w4;
                }
                hVar.f6554b.k();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                x();
                throw protocolException;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }
}