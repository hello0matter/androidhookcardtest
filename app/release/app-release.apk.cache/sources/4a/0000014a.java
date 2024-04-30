package androidx.appcompat.widget;

import android.app.Application;
import android.util.Log;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f801a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f803c;

    public /* synthetic */ j(int i4, Object obj, Object obj2) {
        this.f801a = i4;
        this.f803c = obj;
        this.f802b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.n nVar;
        Object obj = this.f802b;
        int i4 = this.f801a;
        Object obj2 = this.f803c;
        switch (i4) {
            case 0:
                n nVar2 = (n) obj2;
                g.p pVar = nVar2.f4611c;
                if (pVar != null && (nVar = pVar.f4699e) != null) {
                    nVar.b(pVar);
                }
                View view = (View) nVar2.f4616h;
                if (view != null && view.getWindowToken() != null) {
                    h hVar = (h) obj;
                    if (!hVar.b()) {
                        if (hVar.f4602f != null) {
                            hVar.d(0, 0, false, false);
                        }
                    }
                    nVar2.f848t = hVar;
                }
                nVar2.f850v = null;
                return;
            case 1:
                View view2 = (View) obj;
                ScrollingTabContainerView scrollingTabContainerView = (ScrollingTabContainerView) obj2;
                scrollingTabContainerView.smoothScrollTo(view2.getLeft() - ((scrollingTabContainerView.getWidth() - view2.getWidth()) / 2), 0);
                scrollingTabContainerView.f598a = null;
                return;
            case 2:
                ((View) obj).setNestedScrollingEnabled(true);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                ((x.f) obj).f7065a = obj2;
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                ((Application) obj).unregisterActivityLifecycleCallbacks((x.f) obj2);
                return;
            default:
                try {
                    Method method = x.g.f7074d;
                    if (method != null) {
                        method.invoke(obj, obj2, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        x.g.f7075e.invoke(obj, obj2, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e4) {
                    if (e4.getClass() == RuntimeException.class && e4.getMessage() != null && e4.getMessage().startsWith("Unable to stop")) {
                        throw e4;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
        }
    }

    public /* synthetic */ j(Object obj, Object obj2, int i4) {
        this.f801a = i4;
        this.f802b = obj;
        this.f803c = obj2;
    }
}