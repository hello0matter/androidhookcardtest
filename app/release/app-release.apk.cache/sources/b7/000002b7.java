package androidx.lifecycle;

/* loaded from: classes.dex */
public final class j {
    public static Lifecycle$Event a(Lifecycle$State lifecycle$State) {
        com.google.common.collect.c.F(lifecycle$State, "state");
        int ordinal = lifecycle$State.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    return null;
                }
                return Lifecycle$Event.ON_RESUME;
            }
            return Lifecycle$Event.ON_START;
        }
        return Lifecycle$Event.ON_CREATE;
    }
}