package u1;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.example.msphone.R;
import com.google.android.material.card.MaterialCardView;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;
import l2.e;
import l2.j;
import l2.m;
import l2.n;
import l2.p;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: y  reason: collision with root package name */
    public static final double f6856y = Math.cos(Math.toRadians(45.0d));

    /* renamed from: z  reason: collision with root package name */
    public static final ColorDrawable f6857z;

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f6858a;

    /* renamed from: c  reason: collision with root package name */
    public final j f6860c;

    /* renamed from: d  reason: collision with root package name */
    public final j f6861d;

    /* renamed from: e  reason: collision with root package name */
    public int f6862e;

    /* renamed from: f  reason: collision with root package name */
    public int f6863f;

    /* renamed from: g  reason: collision with root package name */
    public int f6864g;

    /* renamed from: h  reason: collision with root package name */
    public int f6865h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f6866i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f6867j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f6868k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f6869l;

    /* renamed from: m  reason: collision with root package name */
    public p f6870m;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f6871n;

    /* renamed from: o  reason: collision with root package name */
    public RippleDrawable f6872o;

    /* renamed from: p  reason: collision with root package name */
    public LayerDrawable f6873p;

    /* renamed from: q  reason: collision with root package name */
    public j f6874q;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6876s;

    /* renamed from: t  reason: collision with root package name */
    public ValueAnimator f6877t;

    /* renamed from: u  reason: collision with root package name */
    public final TimeInterpolator f6878u;

    /* renamed from: v  reason: collision with root package name */
    public final int f6879v;

    /* renamed from: w  reason: collision with root package name */
    public final int f6880w;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f6859b = new Rect();

    /* renamed from: r  reason: collision with root package name */
    public boolean f6875r = false;

    /* renamed from: x  reason: collision with root package name */
    public float f6881x = 0.0f;

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        f6857z = colorDrawable;
    }

    public d(MaterialCardView materialCardView, AttributeSet attributeSet, int i4) {
        this.f6858a = materialCardView;
        j jVar = new j(materialCardView.getContext(), attributeSet, i4, 2131756030);
        this.f6860c = jVar;
        jVar.l(materialCardView.getContext());
        jVar.r();
        n g4 = jVar.f5310a.f5288a.g();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, o1.a.f5950h, i4, R.style.CardView);
        if (obtainStyledAttributes.hasValue(3)) {
            g4.c(obtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.f6861d = new j();
        h(g4.a());
        this.f6878u = com.google.common.collect.c.L1(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, p1.a.f6128a);
        this.f6879v = com.google.common.collect.c.K1(materialCardView.getContext(), R.attr.motionDurationShort2, 300);
        this.f6880w = com.google.common.collect.c.K1(materialCardView.getContext(), R.attr.motionDurationShort1, 300);
        obtainStyledAttributes.recycle();
    }

    public static float b(com.google.common.collect.c cVar, float f4) {
        if (cVar instanceof m) {
            return (float) ((1.0d - f6856y) * f4);
        }
        if (cVar instanceof e) {
            return f4 / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        com.google.common.collect.c cVar = this.f6870m.f5348a;
        j jVar = this.f6860c;
        return Math.max(Math.max(b(cVar, jVar.j()), b(this.f6870m.f5349b, jVar.f5310a.f5288a.f5353f.a(jVar.h()))), Math.max(b(this.f6870m.f5350c, jVar.f5310a.f5288a.f5354g.a(jVar.h())), b(this.f6870m.f5351d, jVar.f5310a.f5288a.f5355h.a(jVar.h()))));
    }

    public final LayerDrawable c() {
        if (this.f6872o == null) {
            int[] iArr = j2.a.f5097a;
            this.f6874q = new j(this.f6870m);
            this.f6872o = new RippleDrawable(this.f6868k, null, this.f6874q);
        }
        if (this.f6873p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f6872o, this.f6861d, this.f6867j});
            this.f6873p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f6873p;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.drawable.InsetDrawable, u1.c] */
    public final c d(Drawable drawable) {
        int i4;
        int i5;
        float f4;
        MaterialCardView materialCardView = this.f6858a;
        if (materialCardView.getUseCompatPadding()) {
            float maxCardElevation = materialCardView.getMaxCardElevation() * 1.5f;
            float f5 = 0.0f;
            if (i()) {
                f4 = a();
            } else {
                f4 = 0.0f;
            }
            int ceil = (int) Math.ceil(maxCardElevation + f4);
            float maxCardElevation2 = materialCardView.getMaxCardElevation();
            if (i()) {
                f5 = a();
            }
            i4 = (int) Math.ceil(maxCardElevation2 + f5);
            i5 = ceil;
        } else {
            i4 = 0;
            i5 = 0;
        }
        return new InsetDrawable(drawable, i4, i5, i4, i5);
    }

    public final void e(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f4;
        if (this.f6873p != null) {
            MaterialCardView materialCardView = this.f6858a;
            if (materialCardView.getUseCompatPadding()) {
                float maxCardElevation = materialCardView.getMaxCardElevation() * 1.5f;
                float f5 = 0.0f;
                if (i()) {
                    f4 = a();
                } else {
                    f4 = 0.0f;
                }
                i6 = (int) Math.ceil((maxCardElevation + f4) * 2.0f);
                float maxCardElevation2 = materialCardView.getMaxCardElevation();
                if (i()) {
                    f5 = a();
                }
                i7 = (int) Math.ceil((maxCardElevation2 + f5) * 2.0f);
            } else {
                i6 = 0;
                i7 = 0;
            }
            int i14 = this.f6864g;
            if ((i14 & 8388613) == 8388613) {
                i8 = ((i4 - this.f6862e) - this.f6863f) - i7;
            } else {
                i8 = this.f6862e;
            }
            if ((i14 & 80) == 80) {
                i9 = this.f6862e;
            } else {
                i9 = ((i5 - this.f6862e) - this.f6863f) - i6;
            }
            int i15 = i9;
            if ((i14 & 8388613) == 8388613) {
                i10 = this.f6862e;
            } else {
                i10 = ((i4 - this.f6862e) - this.f6863f) - i7;
            }
            if ((i14 & 80) == 80) {
                i11 = ((i5 - this.f6862e) - this.f6863f) - i6;
            } else {
                i11 = this.f6862e;
            }
            WeakHashMap weakHashMap = y0.f4999a;
            if (h0.d(materialCardView) == 1) {
                i13 = i10;
                i12 = i8;
            } else {
                i12 = i10;
                i13 = i8;
            }
            this.f6873p.setLayerInset(2, i13, i11, i12, i15);
        }
    }

    public final void f(boolean z4, boolean z5) {
        float f4;
        int i4;
        int i5 = 0;
        Drawable drawable = this.f6867j;
        if (drawable != null) {
            float f5 = 0.0f;
            if (z5) {
                if (z4) {
                    f5 = 1.0f;
                }
                if (z4) {
                    f4 = 1.0f - this.f6881x;
                } else {
                    f4 = this.f6881x;
                }
                ValueAnimator valueAnimator = this.f6877t;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f6877t = null;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f6881x, f5);
                this.f6877t = ofFloat;
                ofFloat.addUpdateListener(new b(0, this));
                this.f6877t.setInterpolator(this.f6878u);
                ValueAnimator valueAnimator2 = this.f6877t;
                if (z4) {
                    i4 = this.f6879v;
                } else {
                    i4 = this.f6880w;
                }
                valueAnimator2.setDuration(i4 * f4);
                this.f6877t.start();
                return;
            }
            if (z4) {
                i5 = 255;
            }
            drawable.setAlpha(i5);
            if (z4) {
                f5 = 1.0f;
            }
            this.f6881x = f5;
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f6867j = mutate;
            c0.b.h(mutate, this.f6869l);
            f(this.f6858a.f3171j, false);
        } else {
            this.f6867j = f6857z;
        }
        LayerDrawable layerDrawable = this.f6873p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f6867j);
        }
    }

    public final void h(p pVar) {
        this.f6870m = pVar;
        j jVar = this.f6860c;
        jVar.setShapeAppearanceModel(pVar);
        jVar.f5331v = !jVar.m();
        j jVar2 = this.f6861d;
        if (jVar2 != null) {
            jVar2.setShapeAppearanceModel(pVar);
        }
        j jVar3 = this.f6874q;
        if (jVar3 != null) {
            jVar3.setShapeAppearanceModel(pVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f6858a;
        if (materialCardView.getPreventCornerOverlap() && this.f6860c.m() && materialCardView.getUseCompatPadding()) {
            return true;
        }
        return false;
    }

    public final void j() {
        boolean z4;
        float a5;
        MaterialCardView materialCardView = this.f6858a;
        if (materialCardView.getPreventCornerOverlap() && !this.f6860c.m()) {
            z4 = true;
        } else {
            z4 = false;
        }
        float f4 = 0.0f;
        if (!z4 && !i()) {
            a5 = 0.0f;
        } else {
            a5 = a();
        }
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            f4 = (float) ((1.0d - f6856y) * materialCardView.getCardViewRadius());
        }
        int i4 = (int) (a5 - f4);
        Rect rect = this.f6859b;
        materialCardView.e(rect.left + i4, rect.top + i4, rect.right + i4, rect.bottom + i4);
    }

    public final void k() {
        boolean z4 = this.f6875r;
        MaterialCardView materialCardView = this.f6858a;
        if (!z4) {
            materialCardView.setBackgroundInternal(d(this.f6860c));
        }
        materialCardView.setForeground(d(this.f6866i));
    }
}