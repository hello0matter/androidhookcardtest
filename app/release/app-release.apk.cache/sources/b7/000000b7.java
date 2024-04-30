package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.example.msphone.FloatingWindowService;
import com.example.msphone.xp;

/* loaded from: classes.dex */
public final class a0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f185a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f186b;

    public /* synthetic */ a0(int i4, Object obj) {
        this.f185a = i4;
        this.f186b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i4 = this.f185a;
        Object obj = this.f186b;
        switch (i4) {
            case 0:
                z zVar = (z) ((b0) obj);
                int i5 = zVar.f372c;
                f0 f0Var = zVar.f373d;
                switch (i5) {
                    case 0:
                        f0Var.m(true, true);
                        return;
                    default:
                        f0Var.m(true, true);
                        return;
                }
            case 1:
                FloatingWindowService floatingWindowService = (FloatingWindowService) obj;
                if (floatingWindowService.f2721a.getVisibility() == 0) {
                    floatingWindowService.f2721a.setVisibility(8);
                    return;
                } else {
                    floatingWindowService.f2721a.setVisibility(0);
                    return;
                }
            default:
                if ("com.example.CHANGE_PLAYBACK_SPEED".equals(intent.getAction())) {
                    xp xpVar = (xp) obj;
                    xpVar.f2728a = intent.getFloatExtra("playback_speed", 1.0f);
                    SharedPreferences.Editor edit = context.getSharedPreferences("XposedModulePrefs", 0).edit();
                    edit.putFloat("currentSpeed", xpVar.f2728a);
                    edit.apply();
                    return;
                }
                return;
        }
    }
}