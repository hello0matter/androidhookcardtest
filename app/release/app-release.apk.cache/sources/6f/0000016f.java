package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class q1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f873a;

    /* renamed from: b  reason: collision with root package name */
    public static final Method f874b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f875c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f876d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f873a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f874b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f875c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f876d = true;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
    }
}