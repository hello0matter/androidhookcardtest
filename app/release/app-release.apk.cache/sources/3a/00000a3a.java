package x1;

import android.util.Property;

/* loaded from: classes.dex */
public final class d extends Property {

    /* renamed from: a  reason: collision with root package name */
    public static final d f7137a = new Property(f.class, "circularReveal");

    @Override // android.util.Property
    public final Object get(Object obj) {
        return ((g) obj).getRevealInfo();
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((g) obj).setRevealInfo((f) obj2);
    }
}