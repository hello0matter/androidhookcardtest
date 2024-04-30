package h;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4792a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i4 = this.f4792a;
        runnable.run();
    }
}