package g3;

import java.util.Random;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public final b f4789c = new b(0);

    @Override // g3.a
    public final Random a() {
        Object obj = this.f4789c.get();
        com.google.common.collect.c.E(obj, "implStorage.get()");
        return (Random) obj;
    }
}