package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class r extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ com.google.common.collect.c f1538q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1539r;

    public r(com.google.common.collect.c cVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f1538q = cVar;
        this.f1539r = threadPoolExecutor;
    }

    @Override // com.google.common.collect.c
    public final void k1(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f1539r;
        try {
            this.f1538q.k1(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // com.google.common.collect.c
    public final void q1(d0 d0Var) {
        ThreadPoolExecutor threadPoolExecutor = this.f1539r;
        try {
            this.f1538q.q1(d0Var);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}