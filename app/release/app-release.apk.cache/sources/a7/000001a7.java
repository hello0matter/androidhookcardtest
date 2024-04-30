package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import t.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: v  reason: collision with root package name */
    public static final float[][] f1094v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: w  reason: collision with root package name */
    public static final float[][] f1095w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: a  reason: collision with root package name */
    public final int f1096a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1097b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1098c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1099d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1100e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1101f;

    /* renamed from: g  reason: collision with root package name */
    public float f1102g;

    /* renamed from: h  reason: collision with root package name */
    public float f1103h;

    /* renamed from: i  reason: collision with root package name */
    public float f1104i;

    /* renamed from: j  reason: collision with root package name */
    public float f1105j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1106k = false;

    /* renamed from: l  reason: collision with root package name */
    public final float[] f1107l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    public float f1108m;

    /* renamed from: n  reason: collision with root package name */
    public float f1109n;

    /* renamed from: o  reason: collision with root package name */
    public final MotionLayout f1110o;

    /* renamed from: p  reason: collision with root package name */
    public final float f1111p;

    /* renamed from: q  reason: collision with root package name */
    public final float f1112q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f1113r;

    /* renamed from: s  reason: collision with root package name */
    public final float f1114s;

    /* renamed from: t  reason: collision with root package name */
    public final int f1115t;

    /* renamed from: u  reason: collision with root package name */
    public final float f1116u;

    public c(Context context, MotionLayout motionLayout, XmlResourceParser xmlResourceParser) {
        this.f1096a = 0;
        this.f1097b = 0;
        this.f1098c = 0;
        this.f1099d = -1;
        this.f1100e = -1;
        this.f1101f = -1;
        this.f1102g = 0.5f;
        this.f1103h = 0.5f;
        this.f1104i = 0.0f;
        this.f1105j = 1.0f;
        this.f1111p = 4.0f;
        this.f1112q = 1.2f;
        this.f1113r = true;
        this.f1114s = 1.0f;
        this.f1115t = 0;
        this.f1116u = 10.0f;
        this.f1110o = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6662o);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 9) {
                this.f1099d = obtainStyledAttributes.getResourceId(index, this.f1099d);
            } else if (index == 10) {
                int i5 = obtainStyledAttributes.getInt(index, this.f1096a);
                this.f1096a = i5;
                float[] fArr = f1094v[i5];
                this.f1103h = fArr[0];
                this.f1102g = fArr[1];
            } else if (index == 0) {
                int i6 = obtainStyledAttributes.getInt(index, this.f1097b);
                this.f1097b = i6;
                float[] fArr2 = f1095w[i6];
                this.f1104i = fArr2[0];
                this.f1105j = fArr2[1];
            } else if (index == 5) {
                this.f1111p = obtainStyledAttributes.getFloat(index, this.f1111p);
            } else if (index == 4) {
                this.f1112q = obtainStyledAttributes.getFloat(index, this.f1112q);
            } else if (index == 6) {
                this.f1113r = obtainStyledAttributes.getBoolean(index, this.f1113r);
            } else if (index == 1) {
                this.f1114s = obtainStyledAttributes.getFloat(index, this.f1114s);
            } else if (index == 2) {
                this.f1116u = obtainStyledAttributes.getFloat(index, this.f1116u);
            } else if (index == 11) {
                this.f1100e = obtainStyledAttributes.getResourceId(index, this.f1100e);
            } else if (index == 8) {
                this.f1098c = obtainStyledAttributes.getInt(index, this.f1098c);
            } else if (index == 7) {
                this.f1115t = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == 3) {
                this.f1101f = obtainStyledAttributes.getResourceId(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i4 = this.f1100e;
        if (i4 == -1 || (findViewById = viewGroup.findViewById(i4)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public final void b(boolean z4) {
        float[][] fArr = f1094v;
        float[][] fArr2 = f1095w;
        if (z4) {
            fArr2[4] = fArr2[3];
            fArr2[5] = fArr2[2];
            fArr[5] = fArr[2];
            fArr[6] = fArr[1];
        } else {
            fArr2[4] = fArr2[2];
            fArr2[5] = fArr2[3];
            fArr[5] = fArr[1];
            fArr[6] = fArr[2];
        }
        float[] fArr3 = fArr[this.f1096a];
        this.f1103h = fArr3[0];
        this.f1102g = fArr3[1];
        float[] fArr4 = fArr2[this.f1097b];
        this.f1104i = fArr4[0];
        this.f1105j = fArr4[1];
    }

    public final String toString() {
        return this.f1104i + " , " + this.f1105j;
    }
}