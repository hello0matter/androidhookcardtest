package androidx.profileinstaller;

import android.content.Context;
import androidx.appcompat.app.l0;
import java.util.Collections;
import java.util.List;
import l2.f;
import x0.g;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements a1.b {
    @Override // a1.b
    public final List a() {
        return Collections.emptyList();
    }

    @Override // a1.b
    public final Object b(Context context) {
        g.a(new l0(2, this, context.getApplicationContext()));
        return new f(20, 0);
    }
}