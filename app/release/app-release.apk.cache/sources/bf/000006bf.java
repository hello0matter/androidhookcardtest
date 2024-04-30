package f2;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.example.msphone.R;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final TimeInterpolator f4551a;

    /* renamed from: b  reason: collision with root package name */
    public final View f4552b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4553c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4554d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4555e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.activity.b f4556f;

    public a(View view) {
        this.f4552b = view;
        Context context = view.getContext();
        this.f4551a = com.google.common.collect.c.L1(context, R.attr.motionEasingStandardDecelerateInterpolator, k0.a.b(0.0f, 0.0f, 0.0f, 1.0f));
        this.f4553c = com.google.common.collect.c.K1(context, R.attr.motionDurationMedium2, 300);
        this.f4554d = com.google.common.collect.c.K1(context, R.attr.motionDurationShort3, 150);
        this.f4555e = com.google.common.collect.c.K1(context, R.attr.motionDurationShort2, 100);
    }

    public final androidx.activity.b a() {
        if (this.f4556f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = this.f4556f;
        this.f4556f = null;
        return bVar;
    }
}