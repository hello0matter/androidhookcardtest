package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final int f5917a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5918b;

    /* renamed from: c  reason: collision with root package name */
    public int f5919c;

    /* renamed from: d  reason: collision with root package name */
    public int f5920d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5921e;

    /* renamed from: f  reason: collision with root package name */
    public final String f5922f;

    /* renamed from: g  reason: collision with root package name */
    public final int f5923g;

    /* renamed from: h  reason: collision with root package name */
    public int f5924h;

    /* renamed from: i  reason: collision with root package name */
    public final float f5925i;

    /* renamed from: j  reason: collision with root package name */
    public final androidx.constraintlayout.motion.widget.b f5926j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f5927k;

    /* renamed from: l  reason: collision with root package name */
    public androidx.constraintlayout.motion.widget.c f5928l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f5929m;

    /* renamed from: n  reason: collision with root package name */
    public final int f5930n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f5931o;

    /* renamed from: p  reason: collision with root package name */
    public final int f5932p;

    /* renamed from: q  reason: collision with root package name */
    public final int f5933q;

    /* renamed from: r  reason: collision with root package name */
    public final int f5934r;

    public z(androidx.constraintlayout.motion.widget.b bVar, Context context, XmlResourceParser xmlResourceParser) {
        androidx.constraintlayout.widget.d dVar;
        int i4;
        this.f5917a = -1;
        this.f5918b = false;
        this.f5919c = -1;
        this.f5920d = -1;
        this.f5921e = 0;
        this.f5922f = null;
        this.f5923g = -1;
        this.f5924h = 400;
        this.f5925i = 0.0f;
        this.f5927k = new ArrayList();
        this.f5928l = null;
        this.f5929m = new ArrayList();
        this.f5930n = 0;
        this.f5931o = false;
        this.f5932p = -1;
        this.f5933q = 0;
        this.f5934r = 0;
        this.f5924h = bVar.f1086j;
        this.f5933q = bVar.f1087k;
        this.f5926j = bVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), t.k.f6667t);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            SparseArray sparseArray = bVar.f1083g;
            if (index == 2) {
                this.f5919c = obtainStyledAttributes.getResourceId(index, this.f5919c);
                if ("layout".equals(context.getResources().getResourceTypeName(this.f5919c))) {
                    dVar = new androidx.constraintlayout.widget.d();
                    dVar.h(context, this.f5919c);
                    i4 = this.f5919c;
                    sparseArray.append(i4, dVar);
                }
            } else {
                if (index == 3) {
                    this.f5920d = obtainStyledAttributes.getResourceId(index, this.f5920d);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f5920d))) {
                        dVar = new androidx.constraintlayout.widget.d();
                        dVar.h(context, this.f5920d);
                        i4 = this.f5920d;
                        sparseArray.append(i4, dVar);
                    }
                } else if (index == 6) {
                    int i6 = obtainStyledAttributes.peekValue(index).type;
                    if (i6 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.f5923g = resourceId;
                        if (resourceId == -1) {
                        }
                        this.f5921e = -2;
                    } else if (i6 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f5922f = string;
                        if (string.indexOf("/") > 0) {
                            this.f5923g = obtainStyledAttributes.getResourceId(index, -1);
                            this.f5921e = -2;
                        } else {
                            this.f5921e = -1;
                        }
                    } else {
                        this.f5921e = obtainStyledAttributes.getInteger(index, this.f5921e);
                    }
                } else if (index == 4) {
                    this.f5924h = obtainStyledAttributes.getInt(index, this.f5924h);
                } else if (index == 8) {
                    this.f5925i = obtainStyledAttributes.getFloat(index, this.f5925i);
                } else if (index == 1) {
                    this.f5930n = obtainStyledAttributes.getInteger(index, this.f5930n);
                } else if (index == 0) {
                    this.f5917a = obtainStyledAttributes.getResourceId(index, this.f5917a);
                } else if (index == 9) {
                    this.f5931o = obtainStyledAttributes.getBoolean(index, this.f5931o);
                } else if (index == 7) {
                    this.f5932p = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == 5) {
                    this.f5933q = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 10) {
                    this.f5934r = obtainStyledAttributes.getInteger(index, 0);
                }
            }
        }
        if (this.f5920d == -1) {
            this.f5918b = true;
        }
        obtainStyledAttributes.recycle();
    }

    public z(androidx.constraintlayout.motion.widget.b bVar, z zVar) {
        this.f5917a = -1;
        this.f5918b = false;
        this.f5919c = -1;
        this.f5920d = -1;
        this.f5921e = 0;
        this.f5922f = null;
        this.f5923g = -1;
        this.f5924h = 400;
        this.f5925i = 0.0f;
        this.f5927k = new ArrayList();
        this.f5928l = null;
        this.f5929m = new ArrayList();
        this.f5930n = 0;
        this.f5931o = false;
        this.f5932p = -1;
        this.f5933q = 0;
        this.f5934r = 0;
        this.f5926j = bVar;
        if (zVar != null) {
            this.f5932p = zVar.f5932p;
            this.f5921e = zVar.f5921e;
            this.f5922f = zVar.f5922f;
            this.f5923g = zVar.f5923g;
            this.f5924h = zVar.f5924h;
            this.f5927k = zVar.f5927k;
            this.f5925i = zVar.f5925i;
            this.f5933q = zVar.f5933q;
        }
    }
}