package l2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: m  reason: collision with root package name */
    public static final l f5347m = new l(0.5f);

    /* renamed from: a  reason: collision with root package name */
    public com.google.common.collect.c f5348a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public com.google.common.collect.c f5349b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public com.google.common.collect.c f5350c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public com.google.common.collect.c f5351d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public d f5352e = new a(0.0f);

    /* renamed from: f  reason: collision with root package name */
    public d f5353f = new a(0.0f);

    /* renamed from: g  reason: collision with root package name */
    public d f5354g = new a(0.0f);

    /* renamed from: h  reason: collision with root package name */
    public d f5355h = new a(0.0f);

    /* renamed from: i  reason: collision with root package name */
    public f f5356i = com.google.common.collect.c.b0();

    /* renamed from: j  reason: collision with root package name */
    public f f5357j = com.google.common.collect.c.b0();

    /* renamed from: k  reason: collision with root package name */
    public f f5358k = com.google.common.collect.c.b0();

    /* renamed from: l  reason: collision with root package name */
    public f f5359l = com.google.common.collect.c.b0();

    public static n a(Context context, int i4, int i5) {
        return b(context, i4, i5, new a(0));
    }

    public static n b(Context context, int i4, int i5, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i4);
        if (i5 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i5);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(o1.a.V);
        try {
            int i6 = obtainStyledAttributes.getInt(0, 0);
            int i7 = obtainStyledAttributes.getInt(3, i6);
            int i8 = obtainStyledAttributes.getInt(4, i6);
            int i9 = obtainStyledAttributes.getInt(2, i6);
            int i10 = obtainStyledAttributes.getInt(1, i6);
            d e4 = e(obtainStyledAttributes, 5, dVar);
            d e5 = e(obtainStyledAttributes, 8, e4);
            d e6 = e(obtainStyledAttributes, 9, e4);
            d e7 = e(obtainStyledAttributes, 7, e4);
            d e8 = e(obtainStyledAttributes, 6, e4);
            n nVar = new n();
            com.google.common.collect.c a02 = com.google.common.collect.c.a0(i7);
            nVar.f5335a = a02;
            n.b(a02);
            nVar.f5339e = e5;
            com.google.common.collect.c a03 = com.google.common.collect.c.a0(i8);
            nVar.f5336b = a03;
            n.b(a03);
            nVar.f5340f = e6;
            com.google.common.collect.c a04 = com.google.common.collect.c.a0(i9);
            nVar.f5337c = a04;
            n.b(a04);
            nVar.f5341g = e7;
            com.google.common.collect.c a05 = com.google.common.collect.c.a0(i10);
            nVar.f5338d = a05;
            n.b(a05);
            nVar.f5342h = e8;
            return nVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static n c(Context context, AttributeSet attributeSet, int i4, int i5) {
        return d(context, attributeSet, i4, i5, new a(0));
    }

    public static n d(Context context, AttributeSet attributeSet, int i4, int i5, d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.G, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, dVar);
    }

    public static d e(TypedArray typedArray, int i4, d dVar) {
        TypedValue peekValue = typedArray.peekValue(i4);
        if (peekValue == null) {
            return dVar;
        }
        int i5 = peekValue.type;
        if (i5 == 5) {
            return new a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i5 == 6) {
            return new l(peekValue.getFraction(1.0f, 1.0f));
        }
        return dVar;
    }

    public final boolean f(RectF rectF) {
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.f5359l.getClass().equals(f.class) && this.f5357j.getClass().equals(f.class) && this.f5356i.getClass().equals(f.class) && this.f5358k.getClass().equals(f.class)) {
            z4 = true;
        } else {
            z4 = false;
        }
        float a5 = this.f5352e.a(rectF);
        if (this.f5353f.a(rectF) == a5 && this.f5355h.a(rectF) == a5 && this.f5354g.a(rectF) == a5) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((this.f5349b instanceof m) && (this.f5348a instanceof m) && (this.f5350c instanceof m) && (this.f5351d instanceof m)) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!z4 || !z5 || !z6) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [l2.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, com.google.common.collect.c] */
    public final n g() {
        ?? obj = new Object();
        obj.f5335a = new Object();
        obj.f5336b = new Object();
        obj.f5337c = new Object();
        obj.f5338d = new Object();
        obj.f5339e = new a(0.0f);
        obj.f5340f = new a(0.0f);
        obj.f5341g = new a(0.0f);
        obj.f5342h = new a(0.0f);
        obj.f5343i = com.google.common.collect.c.b0();
        obj.f5344j = com.google.common.collect.c.b0();
        obj.f5345k = com.google.common.collect.c.b0();
        obj.f5335a = this.f5348a;
        obj.f5336b = this.f5349b;
        obj.f5337c = this.f5350c;
        obj.f5338d = this.f5351d;
        obj.f5339e = this.f5352e;
        obj.f5340f = this.f5353f;
        obj.f5341g = this.f5354g;
        obj.f5342h = this.f5355h;
        obj.f5343i = this.f5356i;
        obj.f5344j = this.f5357j;
        obj.f5345k = this.f5358k;
        obj.f5346l = this.f5359l;
        return obj;
    }

    public final p h(o oVar) {
        n g4 = g();
        g4.f5339e = oVar.a(this.f5352e);
        g4.f5340f = oVar.a(this.f5353f);
        g4.f5342h = oVar.a(this.f5355h);
        g4.f5341g = oVar.a(this.f5354g);
        return g4.a();
    }
}