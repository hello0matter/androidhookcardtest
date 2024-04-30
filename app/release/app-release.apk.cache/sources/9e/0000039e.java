package c1;

import android.view.ViewGroup;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import com.example.msphone.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AutoTransition f2620a = new AutoTransition();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f2621b = new ThreadLocal();

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayList f2622c = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [c1.h0, android.view.ViewTreeObserver$OnPreDrawListener, java.lang.Object, android.view.View$OnAttachStateChangeListener] */
    public static void a(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = f2622c;
        if (!arrayList.contains(viewGroup)) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            if (i0.j0.c(viewGroup)) {
                arrayList.add(viewGroup);
                if (transition == null) {
                    transition = f2620a;
                }
                Transition clone = transition.clone();
                ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).u(viewGroup);
                    }
                }
                if (clone != null) {
                    clone.h(viewGroup, true);
                }
                androidx.activity.j.f(viewGroup.getTag(R.id.transition_current_scene));
                viewGroup.setTag(R.id.transition_current_scene, null);
                if (clone != null) {
                    ?? obj = new Object();
                    obj.f2610a = clone;
                    obj.f2611b = viewGroup;
                    viewGroup.addOnAttachStateChangeListener(obj);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(obj);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [l.b, l.k, java.lang.Object] */
    public static l.b b() {
        l.b bVar;
        ThreadLocal threadLocal = f2621b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (bVar = (l.b) weakReference.get()) != null) {
            return bVar;
        }
        ?? kVar = new l.k();
        threadLocal.set(new WeakReference(kVar));
        return kVar;
    }
}