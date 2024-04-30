package com.example.msphone;

import android.content.Context;
import androidx.appcompat.app.a0;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import h1.f;

/* loaded from: classes.dex */
public class xp implements IXposedHookLoadPackage {

    /* renamed from: a  reason: collision with root package name */
    public float f2728a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public long f2729b = 0;

    public final void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        a0 a0Var = new a0(2, this);
        if (loadPackageParam.packageName.equals("com.eastedge.taxidriverforpad")) {
            XposedHelpers.findAndHookMethod("com.stub.StubApp", loadPackageParam.classLoader, "attachBaseContext", new Object[]{Context.class, new f(this, a0Var)});
        }
    }
}