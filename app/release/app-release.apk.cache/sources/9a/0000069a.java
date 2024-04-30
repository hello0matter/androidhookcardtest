package f;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class e {
    @DoNotInline
    public static Context a(f fVar, Configuration configuration) {
        return fVar.createConfigurationContext(configuration);
    }
}