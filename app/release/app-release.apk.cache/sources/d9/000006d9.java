package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.j2;
import androidx.appcompat.widget.o0;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import i0.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4621a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4622b;

    public /* synthetic */ f(int i4, Object obj) {
        this.f4621a = i4;
        this.f4622b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        i0.d dVar;
        boolean z4;
        boolean z5;
        boolean z6;
        Activity activity;
        Rect rect;
        boolean z7;
        boolean z8;
        boolean z9;
        WindowMetrics currentWindowMetrics;
        int i4;
        int i5 = this.f4621a;
        boolean z10 = false;
        Object obj = this.f4622b;
        switch (i5) {
            case 0:
                j jVar = (j) obj;
                if (jVar.b()) {
                    ArrayList arrayList = jVar.f4661i;
                    if (arrayList.size() > 0 && !((i) arrayList.get(0)).f4631a.f592y) {
                        View view = jVar.f4668p;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((i) it.next()).f4631a.f();
                            }
                            return;
                        }
                        jVar.dismiss();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                i0 i0Var = (i0) obj;
                if (i0Var.b()) {
                    j2 j2Var = i0Var.f4641i;
                    if (!j2Var.f592y) {
                        View view2 = i0Var.f4646n;
                        if (view2 != null && view2.isShown()) {
                            j2Var.f();
                            return;
                        } else {
                            i0Var.dismiss();
                            return;
                        }
                    }
                    return;
                }
                return;
            case 2:
                ActivityChooserView activityChooserView = (ActivityChooserView) obj;
                if (activityChooserView.b()) {
                    if (!activityChooserView.isShown()) {
                        activityChooserView.getListPopupWindow().dismiss();
                        return;
                    }
                    activityChooserView.getListPopupWindow().f();
                    i0.e eVar = activityChooserView.f477g;
                    if (eVar != null && (dVar = eVar.f4919a) != null) {
                        ((androidx.appcompat.widget.n) dVar).n(true);
                        return;
                    }
                    return;
                }
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                AppCompatSpinner appCompatSpinner = (AppCompatSpinner) obj;
                if (!appCompatSpinner.getInternalPopup().b()) {
                    appCompatSpinner.f526f.e(androidx.appcompat.widget.j0.b(appCompatSpinner), androidx.appcompat.widget.j0.a(appCompatSpinner));
                }
                ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    androidx.appcompat.widget.i0.a(viewTreeObserver, this);
                    return;
                }
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                o0 o0Var = (o0) obj;
                AppCompatSpinner appCompatSpinner2 = o0Var.G;
                WeakHashMap weakHashMap = y0.f4999a;
                if (i0.j0.b(appCompatSpinner2) && appCompatSpinner2.getGlobalVisibleRect(o0Var.E)) {
                    o0Var.s();
                    o0Var.f();
                    return;
                }
                o0Var.dismiss();
                return;
            default:
                NavigationView navigationView = (NavigationView) obj;
                navigationView.getLocationOnScreen(navigationView.f3680k);
                int[] iArr = navigationView.f3680k;
                if (iArr[1] == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                com.google.android.material.internal.w wVar = navigationView.f3678i;
                if (wVar.f3600x != z4) {
                    wVar.f3600x = z4;
                    if (wVar.f3578b.getChildCount() <= 0 && wVar.f3600x) {
                        i4 = wVar.f3602z;
                    } else {
                        i4 = 0;
                    }
                    NavigationMenuView navigationMenuView = wVar.f3577a;
                    navigationMenuView.setPadding(0, i4, 0, navigationMenuView.getPaddingBottom());
                }
                if (z4 && navigationView.f3683n) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                navigationView.setDrawTopInsetForeground(z5);
                int i6 = iArr[0];
                if (i6 != 0 && navigationView.getWidth() + i6 != 0) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                navigationView.setDrawLeftInsetForeground(z6);
                Context context = navigationView.getContext();
                while (true) {
                    if (context instanceof ContextWrapper) {
                        if (context instanceof Activity) {
                            activity = (Activity) context;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        activity = null;
                    }
                }
                if (activity != null) {
                    int i7 = Build.VERSION.SDK_INT;
                    WindowManager windowManager = (WindowManager) activity.getSystemService("window");
                    if (i7 >= 30) {
                        currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                        rect = currentWindowMetrics.getBounds();
                    } else {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        rect = new Rect();
                        rect.right = point.x;
                        rect.bottom = point.y;
                    }
                    if (rect.height() - navigationView.getHeight() == iArr[1]) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z7 && z8 && navigationView.f3684o) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    navigationView.setDrawBottomInsetForeground(z9);
                    if (rect.width() == iArr[0] || rect.width() - navigationView.getWidth() == iArr[0]) {
                        z10 = true;
                    }
                    navigationView.setDrawRightInsetForeground(z10);
                    return;
                }
                return;
        }
    }
}