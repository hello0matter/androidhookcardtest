package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class h implements View.OnTouchListener {

    /* renamed from: r  reason: collision with root package name */
    public static final int f1434r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    public final a f1435a;

    /* renamed from: b  reason: collision with root package name */
    public final AccelerateInterpolator f1436b;

    /* renamed from: c  reason: collision with root package name */
    public final View f1437c;

    /* renamed from: d  reason: collision with root package name */
    public androidx.activity.k f1438d;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f1439e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f1440f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1441g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1442h;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f1443i;

    /* renamed from: j  reason: collision with root package name */
    public final float[] f1444j;

    /* renamed from: k  reason: collision with root package name */
    public final float[] f1445k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1446l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1447m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1448n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1449o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1450p;

    /* renamed from: q  reason: collision with root package name */
    public final ListView f1451q;

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.core.widget.a, java.lang.Object] */
    public h(ListView listView) {
        ?? obj = new Object();
        obj.f1427e = Long.MIN_VALUE;
        obj.f1429g = -1L;
        obj.f1428f = 0L;
        this.f1435a = obj;
        this.f1436b = new AccelerateInterpolator();
        this.f1439e = new float[]{0.0f, 0.0f};
        this.f1440f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1443i = new float[]{0.0f, 0.0f};
        this.f1444j = new float[]{0.0f, 0.0f};
        this.f1445k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1437c = listView;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f1445k;
        float f5 = ((int) ((1575.0f * f4) + 0.5f)) / 1000.0f;
        fArr[0] = f5;
        fArr[1] = f5;
        float[] fArr2 = this.f1444j;
        float f6 = ((int) ((f4 * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f6;
        fArr2[1] = f6;
        this.f1441g = 1;
        float[] fArr3 = this.f1440f;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f1439e;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f1443i;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.f1442h = f1434r;
        obj.f1423a = 500;
        obj.f1424b = 500;
        this.f1451q = listView;
    }

    public static float b(float f4, float f5, float f6) {
        return f4 > f6 ? f6 : f4 < f5 ? f5 : f4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f1439e
            r0 = r0[r7]
            float[] r1 = r3.f1440f
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f1436b
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            goto L58
        L3c:
            float[] r0 = r3.f1443i
            r0 = r0[r7]
            float[] r1 = r3.f1444j
            r1 = r1[r7]
            float[] r2 = r3.f1445k
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r2 = b(r4, r1, r7)
            goto L58
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r2 = -r4
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.h.a(float, float, float, int):float");
    }

    public final float c(float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        int i4 = this.f1441g;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2 || f4 >= 0.0f) {
                return 0.0f;
            }
            return f4 / (-f5);
        } else if (f4 >= f5) {
            return 0.0f;
        } else {
            if (f4 >= 0.0f) {
                return 1.0f - (f4 / f5);
            }
            if (!this.f1449o || i4 != 1) {
                return 0.0f;
            }
            return 1.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f1450p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7c
        L16:
            r7.e()
            goto L7c
        L1a:
            r7.f1448n = r2
            r7.f1446l = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.f1437c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            androidx.core.widget.a r9 = r7.f1435a
            r9.f1425c = r0
            r9.f1426d = r8
            boolean r8 = r7.f1449o
            if (r8 != 0) goto L7c
            boolean r8 = r7.f()
            if (r8 == 0) goto L7c
            androidx.activity.k r8 = r7.f1438d
            if (r8 != 0) goto L60
            androidx.activity.k r8 = new androidx.activity.k
            r9 = 4
            r8.<init>(r9, r7)
            r7.f1438d = r8
        L60:
            r7.f1449o = r2
            r7.f1447m = r2
            boolean r8 = r7.f1446l
            if (r8 != 0) goto L75
            int r8 = r7.f1442h
            if (r8 <= 0) goto L75
            androidx.activity.k r9 = r7.f1438d
            long r5 = (long) r8
            java.util.WeakHashMap r8 = i0.y0.f4999a
            i0.g0.n(r4, r9, r5)
            goto L7a
        L75:
            androidx.activity.k r8 = r7.f1438d
            r8.run()
        L7a:
            r7.f1446l = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.h.d(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void e() {
        int i4 = 0;
        if (this.f1447m) {
            this.f1449o = false;
            return;
        }
        a aVar = this.f1435a;
        aVar.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i5 = (int) (currentAnimationTimeMillis - aVar.f1427e);
        int i6 = aVar.f1424b;
        if (i5 > i6) {
            i4 = i6;
        } else if (i5 >= 0) {
            i4 = i5;
        }
        aVar.f1431i = i4;
        aVar.f1430h = aVar.a(currentAnimationTimeMillis);
        aVar.f1429g = currentAnimationTimeMillis;
    }

    public final boolean f() {
        ListView listView;
        int count;
        a aVar = this.f1435a;
        float f4 = aVar.f1426d;
        int abs = (int) (f4 / Math.abs(f4));
        Math.abs(aVar.f1425c);
        if (abs == 0 || (count = (listView = this.f1451q).getCount()) == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i4 = firstVisiblePosition + childCount;
        if (abs > 0) {
            if (i4 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (abs >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        d(view, motionEvent);
        return false;
    }
}