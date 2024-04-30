package d2;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4378a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4379b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4380c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4381d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f4382e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ float f4383f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4384g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Matrix f4385h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ q f4386i;

    public m(q qVar, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix matrix) {
        this.f4386i = qVar;
        this.f4378a = f4;
        this.f4379b = f5;
        this.f4380c = f6;
        this.f4381d = f7;
        this.f4382e = f8;
        this.f4383f = f9;
        this.f4384g = f10;
        this.f4385h = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        q qVar = this.f4386i;
        qVar.f4415v.setAlpha(p1.a.b(this.f4378a, this.f4379b, 0.0f, 0.2f, floatValue));
        FloatingActionButton floatingActionButton = qVar.f4415v;
        float f4 = this.f4380c;
        float f5 = this.f4381d;
        floatingActionButton.setScaleX(p1.a.a(f4, f5, floatValue));
        qVar.f4415v.setScaleY(p1.a.a(this.f4382e, f5, floatValue));
        float f6 = this.f4383f;
        float f7 = this.f4384g;
        qVar.f4409p = p1.a.a(f6, f7, floatValue);
        float a5 = p1.a.a(f6, f7, floatValue);
        Matrix matrix = this.f4385h;
        qVar.a(a5, matrix);
        qVar.f4415v.setImageMatrix(matrix);
    }
}