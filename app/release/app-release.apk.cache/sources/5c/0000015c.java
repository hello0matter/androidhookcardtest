package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.example.msphone.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m2 {

    /* renamed from: g  reason: collision with root package name */
    public static m2 f824g;

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f826a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakHashMap f827b = new WeakHashMap(0);

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f828c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f829d;

    /* renamed from: e  reason: collision with root package name */
    public l2 f830e;

    /* renamed from: f  reason: collision with root package name */
    public static final PorterDuff.Mode f823f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h  reason: collision with root package name */
    public static final k2 f825h = new l.f(6);

    public static synchronized m2 c() {
        m2 m2Var;
        synchronized (m2.class) {
            try {
                if (f824g == null) {
                    f824g = new m2();
                }
                m2Var = f824g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return m2Var;
    }

    public static synchronized PorterDuffColorFilter g(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (m2.class) {
            k2 k2Var = f825h;
            k2Var.getClass();
            int i5 = (31 + i4) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) k2Var.a(Integer.valueOf(mode.hashCode() + i5));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i4, mode);
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) k2Var.b(Integer.valueOf(mode.hashCode() + i5), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public final synchronized void a(Context context, long j4, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                l.e eVar = (l.e) this.f827b.get(context);
                if (eVar == null) {
                    eVar = new l.e();
                    this.f827b.put(context, eVar);
                }
                eVar.e(j4, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable b(Context context, int i4) {
        int i5;
        if (this.f828c == null) {
            this.f828c = new TypedValue();
        }
        TypedValue typedValue = this.f828c;
        context.getResources().getValue(i4, typedValue, true);
        long j4 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable d4 = d(context, j4);
        if (d4 != null) {
            return d4;
        }
        LayerDrawable layerDrawable = null;
        if (this.f830e != null) {
            if (i4 == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{e(context, R.drawable.abc_cab_background_internal_bg), e(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else {
                if (i4 == R.drawable.abc_ratingbar_material) {
                    i5 = R.dimen.abc_star_big;
                } else if (i4 == R.drawable.abc_ratingbar_indicator_material) {
                    i5 = R.dimen.abc_star_medium;
                } else if (i4 == R.drawable.abc_ratingbar_small_material) {
                    i5 = R.dimen.abc_star_small;
                }
                layerDrawable = z.c(this, context, i5);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j4, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable d(Context context, long j4) {
        l.e eVar = (l.e) this.f827b.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) eVar.d(j4, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int b5 = l.d.b(eVar.f5226b, eVar.f5228d, j4);
            if (b5 >= 0) {
                Object[] objArr = eVar.f5227c;
                Object obj = objArr[b5];
                Object obj2 = l.e.f5224e;
                if (obj != obj2) {
                    objArr[b5] = obj2;
                    eVar.f5225a = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable e(Context context, int i4) {
        return f(context, i4, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        c0.b.i(r0, r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized android.graphics.drawable.Drawable f(android.content.Context r9, int r10, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.f829d     // Catch: java.lang.Throwable -> Ld7
            if (r0 == 0) goto L6
            goto L26
        L6:
            r0 = 1
            r8.f829d = r0     // Catch: java.lang.Throwable -> Ld7
            r0 = 2131165303(0x7f070077, float:1.794482E38)
            android.graphics.drawable.Drawable r0 = r8.e(r9, r0)     // Catch: java.lang.Throwable -> Ld7
            if (r0 == 0) goto Ldb
            boolean r1 = r0 instanceof d1.p     // Catch: java.lang.Throwable -> Ld7
            if (r1 != 0) goto L26
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r1 = "android.graphics.drawable.VectorDrawable"
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> Ld7
            if (r0 == 0) goto Ldb
        L26:
            android.graphics.drawable.Drawable r0 = r8.b(r9, r10)     // Catch: java.lang.Throwable -> Ld7
            if (r0 != 0) goto L32
            java.lang.Object r0 = z.e.f7215a     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r0 = z.c.b(r9, r10)     // Catch: java.lang.Throwable -> Ld7
        L32:
            if (r0 == 0) goto Ld1
            android.content.res.ColorStateList r1 = r8.h(r9, r10)     // Catch: java.lang.Throwable -> Ld7
            r2 = 0
            if (r1 == 0) goto L57
            int[] r9 = androidx.appcompat.widget.o1.f857a     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r0 = r0.mutate()     // Catch: java.lang.Throwable -> Ld7
            c0.b.h(r0, r1)     // Catch: java.lang.Throwable -> Ld7
            androidx.appcompat.widget.l2 r9 = r8.f830e     // Catch: java.lang.Throwable -> Ld7
            if (r9 != 0) goto L49
            goto L50
        L49:
            r9 = 2131165290(0x7f07006a, float:1.7944793E38)
            if (r10 != r9) goto L50
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch: java.lang.Throwable -> Ld7
        L50:
            if (r2 == 0) goto Ld1
            c0.b.i(r0, r2)     // Catch: java.lang.Throwable -> Ld7
            goto Ld1
        L57:
            androidx.appcompat.widget.l2 r1 = r8.f830e     // Catch: java.lang.Throwable -> Ld7
            if (r1 == 0) goto Lc8
            r1 = 2131165285(0x7f070065, float:1.7944783E38)
            r3 = 16908301(0x102000d, float:2.3877265E-38)
            r4 = 16908303(0x102000f, float:2.387727E-38)
            r5 = 16908288(0x1020000, float:2.387723E-38)
            r6 = 2130903263(0x7f0300df, float:1.741334E38)
            r7 = 2130903265(0x7f0300e1, float:1.7413343E38)
            if (r10 != r1) goto L95
            r10 = r0
            android.graphics.drawable.LayerDrawable r10 = (android.graphics.drawable.LayerDrawable) r10     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r5)     // Catch: java.lang.Throwable -> Ld7
            int r1 = androidx.appcompat.widget.m3.c(r9, r7)     // Catch: java.lang.Throwable -> Ld7
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.a0.f691b     // Catch: java.lang.Throwable -> Ld7
            androidx.appcompat.widget.z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r4)     // Catch: java.lang.Throwable -> Ld7
            int r1 = androidx.appcompat.widget.m3.c(r9, r7)     // Catch: java.lang.Throwable -> Ld7
            androidx.appcompat.widget.z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r10 = r10.findDrawableByLayerId(r3)     // Catch: java.lang.Throwable -> Ld7
            int r9 = androidx.appcompat.widget.m3.c(r9, r6)     // Catch: java.lang.Throwable -> Ld7
        L91:
            androidx.appcompat.widget.z.f(r10, r9, r2)     // Catch: java.lang.Throwable -> Ld7
            goto Ld1
        L95:
            r1 = 2131165276(0x7f07005c, float:1.7944765E38)
            if (r10 == r1) goto La4
            r1 = 2131165275(0x7f07005b, float:1.7944763E38)
            if (r10 == r1) goto La4
            r1 = 2131165277(0x7f07005d, float:1.7944767E38)
            if (r10 != r1) goto Lc8
        La4:
            r10 = r0
            android.graphics.drawable.LayerDrawable r10 = (android.graphics.drawable.LayerDrawable) r10     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r5)     // Catch: java.lang.Throwable -> Ld7
            int r1 = androidx.appcompat.widget.m3.b(r9, r7)     // Catch: java.lang.Throwable -> Ld7
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.a0.f691b     // Catch: java.lang.Throwable -> Ld7
            androidx.appcompat.widget.z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r4)     // Catch: java.lang.Throwable -> Ld7
            int r1 = androidx.appcompat.widget.m3.c(r9, r6)     // Catch: java.lang.Throwable -> Ld7
            androidx.appcompat.widget.z.f(r11, r1, r2)     // Catch: java.lang.Throwable -> Ld7
            android.graphics.drawable.Drawable r10 = r10.findDrawableByLayerId(r3)     // Catch: java.lang.Throwable -> Ld7
            int r9 = androidx.appcompat.widget.m3.c(r9, r6)     // Catch: java.lang.Throwable -> Ld7
            goto L91
        Lc8:
            boolean r9 = r8.i(r9, r10, r0)     // Catch: java.lang.Throwable -> Ld7
            if (r9 != 0) goto Ld1
            if (r11 == 0) goto Ld1
            r0 = r2
        Ld1:
            if (r0 == 0) goto Ld9
            androidx.appcompat.widget.o1.a(r0)     // Catch: java.lang.Throwable -> Ld7
            goto Ld9
        Ld7:
            r9 = move-exception
            goto Le6
        Ld9:
            monitor-exit(r8)
            return r0
        Ldb:
            r9 = 0
            r8.f829d = r9     // Catch: java.lang.Throwable -> Ld7
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r10 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r9.<init>(r10)     // Catch: java.lang.Throwable -> Ld7
            throw r9     // Catch: java.lang.Throwable -> Ld7
        Le6:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m2.f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList h(Context context, int i4) {
        ColorStateList colorStateList;
        l.l lVar;
        WeakHashMap weakHashMap = this.f826a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap != null && (lVar = (l.l) weakHashMap.get(context)) != null) {
            colorStateList = (ColorStateList) lVar.c(i4, null);
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            l2 l2Var = this.f830e;
            if (l2Var != null) {
                colorStateList2 = ((z) l2Var).d(context, i4);
            }
            if (colorStateList2 != null) {
                if (this.f826a == null) {
                    this.f826a = new WeakHashMap();
                }
                l.l lVar2 = (l.l) this.f826a.get(context);
                if (lVar2 == null) {
                    lVar2 = new l.l();
                    this.f826a.put(context, lVar2);
                }
                lVar2.a(i4, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            androidx.appcompat.widget.l2 r0 = r7.f830e
            r1 = 0
            if (r0 == 0) goto L70
            androidx.appcompat.widget.z r0 = (androidx.appcompat.widget.z) r0
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.a0.f691b
            java.lang.Object r3 = r0.f989b
            int[] r3 = (int[]) r3
            boolean r3 = androidx.appcompat.widget.z.a(r3, r9)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L1b
            r9 = 2130903265(0x7f0300e1, float:1.7413343E38)
        L18:
            r3 = r4
        L19:
            r0 = r5
            goto L57
        L1b:
            java.lang.Object r3 = r0.f991d
            int[] r3 = (int[]) r3
            boolean r3 = androidx.appcompat.widget.z.a(r3, r9)
            if (r3 == 0) goto L29
            r9 = 2130903263(0x7f0300df, float:1.741334E38)
            goto L18
        L29:
            java.lang.Object r0 = r0.f992e
            int[] r0 = (int[]) r0
            boolean r0 = androidx.appcompat.widget.z.a(r0, r9)
            r3 = 16842801(0x1010031, float:2.3693695E-38)
            if (r0 == 0) goto L3a
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
        L38:
            r9 = r3
            goto L18
        L3a:
            r0 = 2131165262(0x7f07004e, float:1.7944736E38)
            if (r9 != r0) goto L4e
            r9 = 1109603123(0x42233333, float:40.8)
            int r9 = java.lang.Math.round(r9)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r3 = r4
            r6 = r0
            r0 = r9
            r9 = r6
            goto L57
        L4e:
            r0 = 2131165244(0x7f07003c, float:1.79447E38)
            if (r9 != r0) goto L54
            goto L38
        L54:
            r9 = r1
            r3 = r9
            goto L19
        L57:
            if (r3 == 0) goto L70
            int[] r1 = androidx.appcompat.widget.o1.f857a
            android.graphics.drawable.Drawable r10 = r10.mutate()
            int r8 = androidx.appcompat.widget.m3.c(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = androidx.appcompat.widget.a0.c(r8, r2)
            r10.setColorFilter(r8)
            if (r0 == r5) goto L6f
            r10.setAlpha(r0)
        L6f:
            r1 = r4
        L70:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m2.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}