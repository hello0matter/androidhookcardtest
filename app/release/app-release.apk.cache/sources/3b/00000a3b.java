package x1;

import android.util.Property;

/* loaded from: classes.dex */
public final class e extends Property {

    /* renamed from: a  reason: collision with root package name */
    public static final e f7138a = new Property(Integer.class, "circularRevealScrimColor");

    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((g) obj).getCircularRevealScrimColor());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((g) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
    }
}