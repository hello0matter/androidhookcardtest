package h1;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.a0;
import com.example.msphone.xp;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class f extends XC_MethodHook {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4812a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f4814c;

    public f(xp xpVar, a0 a0Var) {
        this.f4812a = 2;
        this.f4814c = xpVar;
        this.f4813b = a0Var;
    }

    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Method[] declaredMethods;
        int i4 = this.f4812a;
        Object obj = this.f4813b;
        Object obj2 = this.f4814c;
        switch (i4) {
            case 0:
                Object obj3 = methodHookParam.thisObject;
                Field declaredField = ((Class) obj).getDeclaredField("iMediaPlayer");
                declaredField.setAccessible(true);
                for (Method method : declaredField.get(obj3).getClass().getDeclaredMethods()) {
                    if (method.getName().equals("setDataSource")) {
                        XposedBridge.hookMethod(method, new d(this, 2));
                    }
                }
                return;
            case 1:
                XC_MethodHook.MethodHookParam methodHookParam2 = (XC_MethodHook.MethodHookParam) obj;
                super.afterHookedMethod(methodHookParam2);
                Context context = (Context) methodHookParam2.args[0];
                ClassLoader classLoader = context.getClassLoader();
                f fVar = (f) obj2;
                ((xp) fVar.f4814c).getClass();
                ((xp) fVar.f4814c).f2728a = context.getSharedPreferences("XposedModulePrefs", 0).getFloat("currentSpeed", 1.0f);
                XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "onCreate", new Object[]{Bundle.class, new e(this, 0)});
                XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "dispatchKeyEvent", new Object[]{KeyEvent.class, new e(this, 1)});
                try {
                    Class findClass = XposedHelpers.findClass("com.jiuzhou.TaxiDriver.Views.OrderView", classLoader);
                    XposedBridge.hookMethod(findClass.getDeclaredMethod("ManualPlay", File.class, Integer.TYPE), new f(this, findClass, 0));
                    return;
                } catch (NoSuchMethodException unused) {
                    return;
                }
            default:
                super.afterHookedMethod(methodHookParam);
                Context context2 = (Context) methodHookParam.args[0];
                ClassLoader classLoader2 = context2.getClassLoader();
                xp xpVar = (xp) obj2;
                xpVar.getClass();
                xpVar.f2728a = context2.getSharedPreferences("XposedModulePrefs", 0).getFloat("currentSpeed", 1.0f);
                XposedHelpers.findAndHookMethod("android.app.Activity", classLoader2, "onCreate", new Object[]{Bundle.class, new d(this, 0)});
                XposedHelpers.findAndHookMethod("android.app.Activity", classLoader2, "dispatchKeyEvent", new Object[]{KeyEvent.class, new d(this, 1)});
                try {
                    XposedBridge.hookMethod(XposedHelpers.findClass("com.jiuzhou.TaxiDriver.Views.OrderView", classLoader2).getDeclaredMethod("ManualPlay", File.class, Integer.TYPE), new f(this, methodHookParam, 1));
                    return;
                } catch (NoSuchMethodException unused2) {
                    return;
                }
        }
    }

    public /* synthetic */ f(XC_MethodHook xC_MethodHook, Object obj, int i4) {
        this.f4812a = i4;
        this.f4814c = xC_MethodHook;
        this.f4813b = obj;
    }
}