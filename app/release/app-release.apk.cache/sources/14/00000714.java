package h1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.KeyEvent;
import com.example.msphone.xp;
import de.robv.android.xposed.XC_MethodHook;

/* loaded from: classes.dex */
public final class e extends XC_MethodHook {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f4811b;

    public /* synthetic */ e(f fVar, int i4) {
        this.f4810a = i4;
        this.f4811b = fVar;
    }

    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f4810a) {
            case 0:
                ((Activity) methodHookParam.thisObject).registerReceiver((BroadcastReceiver) ((f) this.f4811b.f4814c).f4813b, new IntentFilter("com.example.CHANGE_PLAYBACK_SPEED"));
                return;
            default:
                super.afterHookedMethod(methodHookParam);
                return;
        }
    }

    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f4810a) {
            case 1:
                KeyEvent keyEvent = (KeyEvent) methodHookParam.args[0];
                int keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() == 1 && keyCode == 24) {
                    long currentTimeMillis = System.currentTimeMillis();
                    f fVar = this.f4811b;
                    if (currentTimeMillis - ((xp) ((f) fVar.f4814c).f4814c).f2729b <= 300) {
                        ((Context) methodHookParam.thisObject).sendBroadcast(new Intent("TOGGLE_FLOATING_WINDOW"));
                    }
                    ((xp) ((f) fVar.f4814c).f4814c).f2729b = currentTimeMillis;
                    return;
                }
                return;
            default:
                super.beforeHookedMethod(methodHookParam);
                return;
        }
    }
}