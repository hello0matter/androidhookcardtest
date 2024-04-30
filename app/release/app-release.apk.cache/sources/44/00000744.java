package i0;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class f0 {
    @DoNotInline
    public static boolean a(@NonNull View view) {
        return view.hasOnClickListeners();
    }
}