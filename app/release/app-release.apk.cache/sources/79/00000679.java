package e0;

import android.os.Trace;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class i {
    @DoNotInline
    public static void a(String str) {
        Trace.beginSection(str);
    }

    @DoNotInline
    public static void b() {
        Trace.endSection();
    }
}