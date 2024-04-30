package q1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.example.msphone.R;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.c0;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.h0;
import i2.g;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import l2.j;
import l2.p;

/* loaded from: classes.dex */
public final class a extends Drawable implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f6330a;

    /* renamed from: b  reason: collision with root package name */
    public final j f6331b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f6332c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f6333d;

    /* renamed from: e  reason: collision with root package name */
    public final b f6334e;

    /* renamed from: f  reason: collision with root package name */
    public float f6335f;

    /* renamed from: g  reason: collision with root package name */
    public float f6336g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6337h;

    /* renamed from: i  reason: collision with root package name */
    public float f6338i;

    /* renamed from: j  reason: collision with root package name */
    public float f6339j;

    /* renamed from: k  reason: collision with root package name */
    public float f6340k;

    /* renamed from: l  reason: collision with root package name */
    public WeakReference f6341l;

    /* renamed from: m  reason: collision with root package name */
    public WeakReference f6342m;

    public a(Context context, BadgeState$State badgeState$State) {
        int intValue;
        int intValue2;
        FrameLayout frameLayout;
        g gVar;
        WeakReference weakReference = new WeakReference(context);
        this.f6330a = weakReference;
        h0.c(context, h0.f3554b, "Theme.MaterialComponents");
        this.f6333d = new Rect();
        d0 d0Var = new d0(this);
        this.f6332c = d0Var;
        TextPaint textPaint = d0Var.f3534a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        b bVar = new b(context, badgeState$State);
        this.f6334e = bVar;
        boolean f4 = f();
        BadgeState$State badgeState$State2 = bVar.f6344b;
        if (f4) {
            intValue = badgeState$State2.f2980g.intValue();
        } else {
            intValue = badgeState$State2.f2978e.intValue();
        }
        if (f()) {
            intValue2 = badgeState$State2.f2981h.intValue();
        } else {
            intValue2 = badgeState$State2.f2979f.intValue();
        }
        j jVar = new j(p.a(context, intValue, intValue2).a());
        this.f6331b = jVar;
        h();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && d0Var.f3540g != (gVar = new g(context2, badgeState$State2.f2977d.intValue()))) {
            d0Var.c(gVar, context2);
            textPaint.setColor(badgeState$State2.f2976c.intValue());
            invalidateSelf();
            j();
            invalidateSelf();
        }
        int i4 = badgeState$State2.f2985l;
        if (i4 != -2) {
            this.f6337h = ((int) Math.pow(10.0d, i4 - 1.0d)) - 1;
        } else {
            this.f6337h = badgeState$State2.f2986m;
        }
        d0Var.f3538e = true;
        j();
        invalidateSelf();
        d0Var.f3538e = true;
        h();
        j();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(badgeState$State2.f2975b.intValue());
        if (jVar.f5310a.f5290c != valueOf) {
            jVar.o(valueOf);
            invalidateSelf();
        }
        textPaint.setColor(badgeState$State2.f2976c.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f6341l;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.f6341l.get();
            WeakReference weakReference3 = this.f6342m;
            if (weakReference3 != null) {
                frameLayout = (FrameLayout) weakReference3.get();
            } else {
                frameLayout = null;
            }
            i(view, frameLayout);
        }
        j();
        setVisible(badgeState$State2.f2993t.booleanValue(), false);
    }

    @Override // com.google.android.material.internal.c0
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        boolean z4;
        b bVar = this.f6334e;
        BadgeState$State badgeState$State = bVar.f6344b;
        String str = badgeState$State.f2983j;
        if (str != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        WeakReference weakReference = this.f6330a;
        if (z4) {
            int i4 = badgeState$State.f2985l;
            if (i4 != -2 && str != null && str.length() > i4) {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    return "";
                }
                return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i4 - 1), "…");
            }
            return str;
        } else if (g()) {
            int i5 = this.f6337h;
            BadgeState$State badgeState$State2 = bVar.f6344b;
            if (i5 != -2 && e() > this.f6337h) {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    return "";
                }
                return String.format(badgeState$State2.f2987n, context2.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f6337h), "+");
            }
            return NumberFormat.getInstance(badgeState$State2.f2987n).format(e());
        } else {
            return null;
        }
    }

    public final CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        b bVar = this.f6334e;
        BadgeState$State badgeState$State = bVar.f6344b;
        String str = badgeState$State.f2983j;
        if (str != null) {
            CharSequence charSequence = badgeState$State.f2988o;
            if (charSequence != null) {
                return charSequence;
            }
            return str;
        }
        boolean g4 = g();
        BadgeState$State badgeState$State2 = bVar.f6344b;
        if (g4) {
            if (badgeState$State2.f2990q == 0 || (context = (Context) this.f6330a.get()) == null) {
                return null;
            }
            if (this.f6337h != -2) {
                int e4 = e();
                int i4 = this.f6337h;
                if (e4 > i4) {
                    return context.getString(badgeState$State2.f2991r, Integer.valueOf(i4));
                }
            }
            return context.getResources().getQuantityString(badgeState$State2.f2990q, e(), Integer.valueOf(e()));
        }
        return badgeState$State2.f2989p;
    }

    public final FrameLayout d() {
        WeakReference weakReference = this.f6342m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String b5;
        int round;
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f6331b.draw(canvas);
            if (f() && (b5 = b()) != null) {
                Rect rect = new Rect();
                d0 d0Var = this.f6332c;
                d0Var.f3534a.getTextBounds(b5, 0, b5.length(), rect);
                float exactCenterY = this.f6336g - rect.exactCenterY();
                float f4 = this.f6335f;
                if (rect.bottom <= 0) {
                    round = (int) exactCenterY;
                } else {
                    round = Math.round(exactCenterY);
                }
                canvas.drawText(b5, f4, round, d0Var.f3534a);
            }
        }
    }

    public final int e() {
        int i4 = this.f6334e.f6344b.f2984k;
        if (i4 == -1) {
            return 0;
        }
        return i4;
    }

    public final boolean f() {
        if (this.f6334e.f6344b.f2983j != null || g()) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        BadgeState$State badgeState$State = this.f6334e.f6344b;
        if (badgeState$State.f2983j == null && badgeState$State.f2984k != -1) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6334e.f6344b.f2982i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6333d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6333d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        int intValue;
        int intValue2;
        Context context = (Context) this.f6330a.get();
        if (context == null) {
            return;
        }
        boolean f4 = f();
        b bVar = this.f6334e;
        if (f4) {
            intValue = bVar.f6344b.f2980g.intValue();
        } else {
            intValue = bVar.f6344b.f2978e.intValue();
        }
        if (f()) {
            intValue2 = bVar.f6344b.f2981h.intValue();
        } else {
            intValue2 = bVar.f6344b.f2979f.intValue();
        }
        this.f6331b.setShapeAppearanceModel(p.a(context, intValue, intValue2).a());
        invalidateSelf();
    }

    public final void i(View view, FrameLayout frameLayout) {
        this.f6341l = new WeakReference(view);
        this.f6342m = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0171, code lost:
        if (i0.h0.d(r2) == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0173, code lost:
        r3 = (r5.right + r14.f6339j) - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017c, code lost:
        r3 = (r5.left - r14.f6339j) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018d, code lost:
        if (i0.h0.d(r2) == 0) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.j():void");
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.c0
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        b bVar = this.f6334e;
        bVar.f6343a.f2982i = i4;
        bVar.f6344b.f2982i = i4;
        this.f6332c.f3534a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}