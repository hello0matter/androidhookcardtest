package d2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.example.msphone.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.a0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class q {
    public static final u0.a C = p1.a.f6130c;
    public static final int D = R.attr.motionDurationLong2;
    public static final int E = R.attr.motionEasingEmphasizedInterpolator;
    public static final int F = R.attr.motionDurationMedium1;
    public static final int G = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] H = {16842919, 16842910};
    public static final int[] I = {16843623, 16842908, 16842910};
    public static final int[] J = {16842908, 16842910};
    public static final int[] K = {16843623, 16842910};
    public static final int[] L = {16842910};
    public static final int[] M = new int[0];
    public v.b B;

    /* renamed from: a  reason: collision with root package name */
    public l2.p f4394a;

    /* renamed from: b  reason: collision with root package name */
    public l2.j f4395b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f4396c;

    /* renamed from: d  reason: collision with root package name */
    public b f4397d;

    /* renamed from: e  reason: collision with root package name */
    public LayerDrawable f4398e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4399f;

    /* renamed from: h  reason: collision with root package name */
    public float f4401h;

    /* renamed from: i  reason: collision with root package name */
    public float f4402i;

    /* renamed from: j  reason: collision with root package name */
    public float f4403j;

    /* renamed from: k  reason: collision with root package name */
    public int f4404k;

    /* renamed from: l  reason: collision with root package name */
    public Animator f4405l;

    /* renamed from: m  reason: collision with root package name */
    public p1.f f4406m;

    /* renamed from: n  reason: collision with root package name */
    public p1.f f4407n;

    /* renamed from: o  reason: collision with root package name */
    public float f4408o;

    /* renamed from: q  reason: collision with root package name */
    public int f4410q;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList f4412s;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList f4413t;

    /* renamed from: u  reason: collision with root package name */
    public ArrayList f4414u;

    /* renamed from: v  reason: collision with root package name */
    public final FloatingActionButton f4415v;

    /* renamed from: w  reason: collision with root package name */
    public final w1.g f4416w;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4400g = true;

    /* renamed from: p  reason: collision with root package name */
    public float f4409p = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    public int f4411r = 0;

    /* renamed from: x  reason: collision with root package name */
    public final Rect f4417x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    public final RectF f4418y = new RectF();

    /* renamed from: z  reason: collision with root package name */
    public final RectF f4419z = new RectF();
    public final Matrix A = new Matrix();

    public q(FloatingActionButton floatingActionButton, w1.g gVar) {
        this.f4415v = floatingActionButton;
        this.f4416w = gVar;
        a0 a0Var = new a0();
        s sVar = (s) this;
        a0Var.a(H, d(new o(sVar, 2)));
        a0Var.a(I, d(new o(sVar, 1)));
        a0Var.a(J, d(new o(sVar, 1)));
        a0Var.a(K, d(new o(sVar, 1)));
        a0Var.a(L, d(new o(sVar, 3)));
        a0Var.a(M, d(new o(sVar, 0)));
        this.f4408o = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(o oVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(C);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(oVar);
        valueAnimator.addUpdateListener(oVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f4, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f4415v.getDrawable();
        if (drawable != null && this.f4410q != 0) {
            RectF rectF = this.f4418y;
            RectF rectF2 = this.f4419z;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i4 = this.f4410q;
            rectF2.set(0.0f, 0.0f, i4, i4);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i5 = this.f4410q;
            matrix.postScale(f4, f4, i5 / 2.0f, i5 / 2.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [d2.n, android.animation.TypeEvaluator, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [d2.n, android.animation.TypeEvaluator, java.lang.Object] */
    public final AnimatorSet b(p1.f fVar, float f4, float f5, float f6) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f4};
        FloatingActionButton floatingActionButton = this.f4415v;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingActionButton, property, fArr);
        fVar.f("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingActionButton, View.SCALE_X, f5);
        fVar.f("scale").a(ofFloat2);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 == 26) {
            ?? obj = new Object();
            obj.f4387a = new FloatEvaluator();
            ofFloat2.setEvaluator(obj);
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton, View.SCALE_Y, f5);
        fVar.f("scale").a(ofFloat3);
        if (i4 == 26) {
            ?? obj2 = new Object();
            obj2.f4387a = new FloatEvaluator();
            ofFloat3.setEvaluator(obj2);
        }
        arrayList.add(ofFloat3);
        Matrix matrix = this.A;
        a(f6, matrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(floatingActionButton, new c1.a(), new l(this), new Matrix(matrix));
        fVar.f("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        p1.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f4, float f5, float f6, int i4, int i5) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.f4415v;
        ofFloat.addUpdateListener(new m(this, floatingActionButton.getAlpha(), f4, floatingActionButton.getScaleX(), f5, floatingActionButton.getScaleY(), this.f4409p, f6, new Matrix(this.A)));
        arrayList.add(ofFloat);
        p1.b.a(animatorSet, arrayList);
        animatorSet.setDuration(com.google.common.collect.c.K1(floatingActionButton.getContext(), i4, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(com.google.common.collect.c.L1(floatingActionButton.getContext(), i5, p1.a.f6129b));
        return animatorSet;
    }

    public abstract float e();

    public void f(Rect rect) {
        float f4;
        int i4 = 0;
        if (this.f4399f) {
            i4 = Math.max((this.f4404k - this.f4415v.getSizeDimension()) / 2, 0);
        }
        if (this.f4400g) {
            f4 = e() + this.f4403j;
        } else {
            f4 = 0.0f;
        }
        int max = Math.max(i4, (int) Math.ceil(f4));
        int max2 = Math.max(i4, (int) Math.ceil(f4 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public abstract void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i4);

    public abstract void h();

    public abstract void i();

    public abstract void j(int[] iArr);

    public abstract void k(float f4, float f5, float f6);

    public final void l() {
        float f4;
        ArrayList arrayList = this.f4414u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                com.google.android.material.bottomappbar.b bVar = iVar.f4365a;
                bVar.getClass();
                BottomAppBar bottomAppBar = bVar.f3046a;
                l2.j jVar = bottomAppBar.U;
                FloatingActionButton floatingActionButton = iVar.f4366b;
                if (floatingActionButton.getVisibility() == 0 && bottomAppBar.f3020c0 == 1) {
                    f4 = floatingActionButton.getScaleY();
                } else {
                    f4 = 0.0f;
                }
                jVar.p(f4);
            }
        }
    }

    public final void m() {
        ArrayList arrayList = this.f4414u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                com.google.android.material.bottomappbar.b bVar = iVar.f4365a;
                bVar.getClass();
                BottomAppBar bottomAppBar = bVar.f3046a;
                if (bottomAppBar.f3020c0 == 1) {
                    FloatingActionButton floatingActionButton = iVar.f4366b;
                    float translationX = floatingActionButton.getTranslationX();
                    int i4 = (BottomAppBar.A(bottomAppBar).f3064g > translationX ? 1 : (BottomAppBar.A(bottomAppBar).f3064g == translationX ? 0 : -1));
                    l2.j jVar = bottomAppBar.U;
                    if (i4 != 0) {
                        BottomAppBar.A(bottomAppBar).f3064g = translationX;
                        jVar.invalidateSelf();
                    }
                    float f4 = 0.0f;
                    float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
                    if (BottomAppBar.A(bottomAppBar).f3063f != max) {
                        BottomAppBar.A(bottomAppBar).u(max);
                        jVar.invalidateSelf();
                    }
                    if (floatingActionButton.getVisibility() == 0) {
                        f4 = floatingActionButton.getScaleY();
                    }
                    jVar.p(f4);
                }
            }
        }
    }

    public void n(ColorStateList colorStateList) {
        Drawable drawable = this.f4396c;
        if (drawable != null) {
            c0.b.h(drawable, j2.a.c(colorStateList));
        }
    }

    public final void o(l2.p pVar) {
        this.f4394a = pVar;
        l2.j jVar = this.f4395b;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(pVar);
        }
        Drawable drawable = this.f4396c;
        if (drawable instanceof l2.a0) {
            ((l2.a0) drawable).setShapeAppearanceModel(pVar);
        }
        b bVar = this.f4397d;
        if (bVar != null) {
            bVar.f4354o = pVar;
            bVar.invalidateSelf();
        }
    }

    public abstract boolean p();

    public abstract void q();

    public final void r() {
        Drawable drawable;
        Rect rect = this.f4417x;
        f(rect);
        h0.e.c(this.f4398e, "Didn't initialize content background");
        boolean p4 = p();
        w1.g gVar = this.f4416w;
        if (p4) {
            drawable = new InsetDrawable((Drawable) this.f4398e, rect.left, rect.top, rect.right, rect.bottom);
        } else {
            drawable = this.f4398e;
            if (drawable == null) {
                gVar.getClass();
                int i4 = rect.left;
                int i5 = rect.top;
                int i6 = rect.right;
                int i7 = rect.bottom;
                ((FloatingActionButton) gVar.f7056b).f3412l.set(i4, i5, i6, i7);
                FloatingActionButton floatingActionButton = (FloatingActionButton) gVar.f7056b;
                int i8 = floatingActionButton.f3409i;
                floatingActionButton.setPadding(i4 + i8, i5 + i8, i6 + i8, i7 + i8);
            }
        }
        super/*android.view.View*/.setBackgroundDrawable(drawable);
        int i42 = rect.left;
        int i52 = rect.top;
        int i62 = rect.right;
        int i72 = rect.bottom;
        ((FloatingActionButton) gVar.f7056b).f3412l.set(i42, i52, i62, i72);
        FloatingActionButton floatingActionButton2 = (FloatingActionButton) gVar.f7056b;
        int i82 = floatingActionButton2.f3409i;
        floatingActionButton2.setPadding(i42 + i82, i52 + i82, i62 + i82, i72 + i82);
    }
}