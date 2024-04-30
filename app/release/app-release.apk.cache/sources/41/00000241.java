package androidx.emoji2.text;

/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1540a;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1540a) {
            case 0:
                try {
                    int i4 = e0.j.f4429a;
                    e0.i.a("EmojiCompat.EmojiCompatInitializer.run");
                    if (o.f1526j != null) {
                        o.a().c();
                    }
                    e0.i.b();
                    return;
                } catch (Throwable th) {
                    int i5 = e0.j.f4429a;
                    e0.i.b();
                    throw th;
                }
            default:
                try {
                    com.google.common.collect.c.u0(com.google.common.collect.c.o0());
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
        }
    }
}