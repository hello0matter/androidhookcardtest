package i0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class o1 extends WindowInsetsAnimation$Callback {

    /* renamed from: a  reason: collision with root package name */
    public final t.n f4964a;

    /* renamed from: b  reason: collision with root package name */
    public List f4965b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f4966c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f4967d;

    public o1(t.n nVar) {
        super(nVar.f6677a);
        this.f4967d = new HashMap();
        this.f4964a = nVar;
    }

    public final r1 a(WindowInsetsAnimation windowInsetsAnimation) {
        r1 r1Var = (r1) this.f4967d.get(windowInsetsAnimation);
        if (r1Var == null) {
            r1Var = new r1(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                r1Var.f4973a = new p1(windowInsetsAnimation);
            }
            this.f4967d.put(windowInsetsAnimation, r1Var);
        }
        return r1Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        t.n nVar = this.f4964a;
        a(windowInsetsAnimation);
        ((View) nVar.f6681e).setTranslationY(0.0f);
        this.f4967d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        t.n nVar = this.f4964a;
        a(windowInsetsAnimation);
        int[] iArr = nVar.f6682f;
        ((View) nVar.f6681e).getLocationOnScreen(iArr);
        nVar.f6678b = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        float fraction;
        ArrayList arrayList = this.f4966c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f4966c = arrayList2;
            this.f4965b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation j4 = a2.a.j(list.get(size));
            r1 a5 = a(j4);
            fraction = j4.getFraction();
            a5.f4973a.d(fraction);
            this.f4966c.add(a5);
        }
        t.n nVar = this.f4964a;
        g2 h4 = g2.h(null, windowInsets);
        nVar.a(h4, this.f4965b);
        return h4.g();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        t.n nVar = this.f4964a;
        a(windowInsetsAnimation);
        androidx.appcompat.widget.c0 c0Var = new androidx.appcompat.widget.c0(bounds);
        nVar.b(c0Var);
        return p1.e(c0Var);
    }
}