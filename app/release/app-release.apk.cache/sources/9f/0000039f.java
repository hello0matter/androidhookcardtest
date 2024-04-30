package c1;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.transition.Transition;
import com.example.msphone.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2623a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2624b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f2625c;

    public j(int i4, Object obj, Object obj2) {
        this.f2623a = i4;
        this.f2625c = obj;
        this.f2624b = obj2;
    }

    @Override // c1.g0, c1.f0
    public final void c() {
        switch (this.f2623a) {
            case 0:
                ((s) this.f2625c).setVisibility(4);
                return;
            default:
                return;
        }
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        switch (this.f2623a) {
            case 0:
                transition.v(this);
                View view = (View) this.f2624b;
                if (Build.VERSION.SDK_INT == 28) {
                    if (!u.f2690g) {
                        try {
                            u.b();
                            Method declaredMethod = u.f2685b.getDeclaredMethod("removeGhost", View.class);
                            u.f2689f = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e4) {
                            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e4);
                        }
                        u.f2690g = true;
                    }
                    Method method = u.f2689f;
                    if (method != null) {
                        try {
                            method.invoke(null, view);
                        } catch (IllegalAccessException unused) {
                        } catch (InvocationTargetException e5) {
                            throw new RuntimeException(e5.getCause());
                        }
                    }
                } else {
                    int i4 = v.f2692g;
                    v vVar = (v) view.getTag(R.id.ghost_view);
                    if (vVar != null) {
                        int i5 = vVar.f2696d - 1;
                        vVar.f2696d = i5;
                        if (i5 <= 0) {
                            ((t) vVar.getParent()).removeView(vVar);
                        }
                    }
                }
                ((View) this.f2624b).setTag(R.id.transition_transform, null);
                ((View) this.f2624b).setTag(R.id.parent_matrix, null);
                return;
            case 1:
                p0.b((View) this.f2624b, 1.0f);
                p0.f2666a.getClass();
                transition.v(this);
                return;
            case 2:
                ((ArrayList) ((l.b) this.f2624b).getOrDefault(((h0) this.f2625c).f2611b, null)).remove(transition);
                transition.v(this);
                return;
            default:
                ((Transition) this.f2624b).y();
                transition.v(this);
                return;
        }
    }

    @Override // c1.g0, c1.f0
    public final void e() {
        switch (this.f2623a) {
            case 0:
                ((s) this.f2625c).setVisibility(0);
                return;
            default:
                return;
        }
    }

    public j(View view, s sVar) {
        this.f2623a = 0;
        this.f2624b = view;
        this.f2625c = sVar;
    }
}