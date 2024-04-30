package d2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4334a;

    /* renamed from: b  reason: collision with root package name */
    public final ExtendedFloatingActionButton f4335b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f4336c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final w1.g f4337d;

    /* renamed from: e  reason: collision with root package name */
    public p1.f f4338e;

    /* renamed from: f  reason: collision with root package name */
    public p1.f f4339f;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, w1.g gVar) {
        this.f4335b = extendedFloatingActionButton;
        this.f4334a = extendedFloatingActionButton.getContext();
        this.f4337d = gVar;
    }

    public AnimatorSet a() {
        p1.f fVar = this.f4339f;
        if (fVar == null) {
            if (this.f4338e == null) {
                this.f4338e = p1.f.b(this.f4334a, c());
            }
            fVar = this.f4338e;
            fVar.getClass();
        }
        return b(fVar);
    }

    public final AnimatorSet b(p1.f fVar) {
        ArrayList arrayList = new ArrayList();
        boolean g4 = fVar.g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4335b;
        if (g4) {
            arrayList.add(fVar.d("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (fVar.g("scale")) {
            arrayList.add(fVar.d("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(fVar.d("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (fVar.g("width")) {
            arrayList.add(fVar.d("width", extendedFloatingActionButton, ExtendedFloatingActionButton.I));
        }
        if (fVar.g("height")) {
            arrayList.add(fVar.d("height", extendedFloatingActionButton, ExtendedFloatingActionButton.J));
        }
        if (fVar.g("paddingStart")) {
            arrayList.add(fVar.d("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.K));
        }
        if (fVar.g("paddingEnd")) {
            arrayList.add(fVar.d("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.L));
        }
        if (fVar.g("labelOpacity")) {
            arrayList.add(fVar.d("labelOpacity", extendedFloatingActionButton, new c1.a(this)));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        p1.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public abstract int c();

    public void d() {
        this.f4337d.f7056b = null;
    }

    public abstract void e();

    public abstract void f(Animator animator);

    public abstract void g();

    public abstract boolean h();
}