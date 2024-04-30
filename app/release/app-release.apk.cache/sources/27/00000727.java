package h3;

import com.google.common.collect.c;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public final class a extends g3.a {
    @Override // g3.a
    public final Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        c.E(current, "current()");
        return current;
    }
}