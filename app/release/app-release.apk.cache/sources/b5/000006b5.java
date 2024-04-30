package f0;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class n implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f4541a;

    /* renamed from: b  reason: collision with root package name */
    public int f4542b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new m(runnable, this.f4541a, this.f4542b);
    }
}