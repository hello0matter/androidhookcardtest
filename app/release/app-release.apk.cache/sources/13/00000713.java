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
public final class d extends XC_MethodHook {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ XC_MethodHook f4809b;

    public /* synthetic */ d(XC_MethodHook xC_MethodHook, int i4) {
        this.f4808a = i4;
        this.f4809b = xC_MethodHook;
    }

    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        switch (this.f4808a) {
            case 0:
                ((Activity) methodHookParam.thisObject).registerReceiver((BroadcastReceiver) ((f) this.f4809b).f4813b, new IntentFilter("com.example.CHANGE_PLAYBACK_SPEED"));
                return;
            default:
                super.afterHookedMethod(methodHookParam);
                return;
        }
    }

    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int i4 = this.f4808a;
        XC_MethodHook xC_MethodHook = this.f4809b;
        switch (i4) {
            case 1:
                KeyEvent keyEvent = (KeyEvent) methodHookParam.args[0];
                int keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() == 1 && keyCode == 24) {
                    long currentTimeMillis = System.currentTimeMillis();
                    f fVar = (f) xC_MethodHook;
                    if (currentTimeMillis - ((xp) fVar.f4814c).f2729b <= 300) {
                        ((Context) methodHookParam.thisObject).sendBroadcast(new Intent("TOGGLE_FLOATING_WINDOW"));
                    }
                    ((xp) fVar.f4814c).f2729b = currentTimeMillis;
                    return;
                }
                return;
            case 2:
                Object obj = methodHookParam.thisObject;
                try {
                    obj.getClass().getDeclaredMethod("setSpeed", Float.TYPE).invoke(obj, Float.valueOf(((xp) ((f) ((f) ((f) xC_MethodHook).f4814c).f4814c).f4814c).f2728a));
                    return;
                } catch (Exception unused) {
                    return;
                }
            default:
                super.beforeHookedMethod(methodHookParam);
                return;
        }
    }
}