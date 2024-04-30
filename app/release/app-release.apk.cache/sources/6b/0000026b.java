package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1703a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1704b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1705c;

    public /* synthetic */ g(int i4, Object obj, Object obj2) {
        this.f1703a = i4;
        this.f1704b = obj;
        this.f1705c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f1703a;
        Object obj = this.f1705c;
        switch (i4) {
            case 0:
                u0.b((ArrayList) obj, 4);
                return;
            case 1:
                ((j) obj).a();
                return;
            default:
                ((g1) obj).c();
                return;
        }
    }
}