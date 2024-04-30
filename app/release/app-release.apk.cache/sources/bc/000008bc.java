package n3;

import com.google.common.collect.c;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f5782b;

    public /* synthetic */ a(String str, boolean z4) {
        this.f5781a = str;
        this.f5782b = z4;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f5781a;
        c.F(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(this.f5782b);
        return thread;
    }
}