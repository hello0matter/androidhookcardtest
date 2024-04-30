package p1;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e extends Property {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6135a = new e();

    public e() {
        super(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((Drawable) obj).getAlpha());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((Drawable) obj).setAlpha(((Integer) obj2).intValue());
    }
}