package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final View f283a;

    /* renamed from: b  reason: collision with root package name */
    public final String f284b;

    /* renamed from: c  reason: collision with root package name */
    public Method f285c;

    /* renamed from: d  reason: collision with root package name */
    public Context f286d;

    public i0(View view, String str) {
        this.f283a = view;
        this.f284b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id;
        String str;
        Method method;
        if (this.f285c == null) {
            View view2 = this.f283a;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f284b;
                if (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                            this.f285c = method;
                            this.f286d = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                } else {
                    if (view2.getId() == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
                }
            }
        }
        try {
            this.f285c.invoke(this.f286d, view);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException("Could not execute method for android:onClick", e5);
        }
    }
}