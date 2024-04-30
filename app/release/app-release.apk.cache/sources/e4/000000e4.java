package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class z extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f372c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f0 f373d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f374e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(f0 f0Var, Context context) {
        super(f0Var);
        this.f373d = f0Var;
        this.f374e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object, androidx.appcompat.app.q0] */
    @Override // androidx.appcompat.app.b0
    public final int b() {
        Location location;
        boolean z4;
        long j4;
        boolean z5;
        int i4 = this.f372c;
        Object obj = this.f374e;
        switch (i4) {
            case 0:
                if (((PowerManager) obj).isPowerSaveMode()) {
                    return 2;
                }
                return 1;
            default:
                c cVar = (c) obj;
                r0 r0Var = (r0) cVar.f194c;
                if (r0Var.f328b > System.currentTimeMillis()) {
                    z5 = r0Var.f327a;
                } else {
                    Context context = (Context) cVar.f192a;
                    Location location2 = null;
                    if (com.google.common.collect.c.J(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        location = cVar.l("network");
                    } else {
                        location = null;
                    }
                    if (com.google.common.collect.c.J(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        location2 = cVar.l("gps");
                    }
                    if (location2 == null || location == null ? location2 != null : location2.getTime() > location.getTime()) {
                        location = location2;
                    }
                    if (location != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (q0.f321d == null) {
                            q0.f321d = new Object();
                        }
                        q0 q0Var = q0.f321d;
                        q0Var.a(location.getLatitude(), location.getLongitude(), currentTimeMillis - 86400000);
                        q0Var.a(location.getLatitude(), location.getLongitude(), currentTimeMillis);
                        if (q0Var.f324c == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        long j5 = q0Var.f323b;
                        long j6 = q0Var.f322a;
                        q0Var.a(location.getLatitude(), location.getLongitude(), currentTimeMillis + 86400000);
                        long j7 = q0Var.f323b;
                        if (j5 != -1 && j6 != -1) {
                            if (currentTimeMillis <= j6) {
                                if (currentTimeMillis > j5) {
                                    j7 = j6;
                                } else {
                                    j7 = j5;
                                }
                            }
                            j4 = j7 + 60000;
                        } else {
                            j4 = currentTimeMillis + 43200000;
                        }
                        r0Var.f327a = z4;
                        r0Var.f328b = j4;
                        z5 = z4;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i5 = Calendar.getInstance().get(11);
                        if (i5 < 6 || i5 >= 22) {
                            return 2;
                        }
                        return 1;
                    }
                }
                if (z5) {
                    return 2;
                }
                return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(f0 f0Var, c cVar) {
        super(f0Var);
        this.f373d = f0Var;
        this.f374e = cVar;
    }
}