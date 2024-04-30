package i0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class s1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f4979a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f4980b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f4981c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f4982d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f4979a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f4980b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f4981c = declaredField3;
            declaredField3.setAccessible(true);
            f4982d = true;
        } catch (ReflectiveOperationException e4) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e4.getMessage(), e4);
        }
    }
}