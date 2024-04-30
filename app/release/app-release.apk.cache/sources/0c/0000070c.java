package h0;

import androidx.annotation.DoNotInline;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class b {
    @DoNotInline
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @DoNotInline
    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }
}