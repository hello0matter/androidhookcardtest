package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import com.google.common.collect.c;

/* loaded from: classes.dex */
public final class b extends c {
    @Override // com.google.common.collect.c
    public final Intent c0(ComponentActivity componentActivity, Intent intent) {
        c.F(componentActivity, "context");
        return intent;
    }

    @Override // com.google.common.collect.c
    public final Object z1(Intent intent, int i4) {
        return new ActivityResult(intent, i4);
    }
}