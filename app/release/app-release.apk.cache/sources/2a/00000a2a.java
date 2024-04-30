package x;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final NotificationManager f7092a;

    static {
        new HashSet();
    }

    public s(Context context) {
        this.f7092a = (NotificationManager) context.getSystemService("notification");
    }
}