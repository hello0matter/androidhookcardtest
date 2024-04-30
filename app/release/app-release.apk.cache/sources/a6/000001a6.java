package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.d;
import com.example.msphone.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n.e;
import o.k;
import o.p;
import o.u;
import o.x;
import o.y;
import o.z;
import org.xmlpull.v1.XmlPullParserException;
import t.f;
import t.g;
import t.h;
import t.n;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f1077a;

    /* renamed from: b  reason: collision with root package name */
    public final n f1078b;

    /* renamed from: c  reason: collision with root package name */
    public z f1079c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f1080d;

    /* renamed from: e  reason: collision with root package name */
    public final z f1081e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f1082f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray f1083g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap f1084h;

    /* renamed from: i  reason: collision with root package name */
    public final SparseIntArray f1085i;

    /* renamed from: j  reason: collision with root package name */
    public int f1086j;

    /* renamed from: k  reason: collision with root package name */
    public int f1087k;

    /* renamed from: l  reason: collision with root package name */
    public MotionEvent f1088l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1089m;

    /* renamed from: n  reason: collision with root package name */
    public u f1090n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1091o;

    /* renamed from: p  reason: collision with root package name */
    public float f1092p;

    /* renamed from: q  reason: collision with root package name */
    public float f1093q;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public b(Context context, MotionLayout motionLayout, int i4) {
        int eventType;
        z zVar = null;
        this.f1078b = null;
        this.f1079c = null;
        ArrayList arrayList = new ArrayList();
        this.f1080d = arrayList;
        this.f1081e = null;
        this.f1082f = new ArrayList();
        this.f1083g = new SparseArray();
        this.f1084h = new HashMap();
        this.f1085i = new SparseIntArray();
        this.f1086j = 400;
        this.f1087k = 0;
        this.f1089m = false;
        this.f1077a = motionLayout;
        XmlResourceParser xml = context.getResources().getXml(i4);
        try {
            eventType = xml.getEventType();
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
        while (true) {
            char c4 = 1;
            if (eventType != 1) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c4 = 5;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case -1239391468:
                                if (name.equals("KeyFrameSet")) {
                                    c4 = 6;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 269306229:
                                if (name.equals("Transition")) {
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 312750793:
                                if (name.equals("OnClick")) {
                                    c4 = 3;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 327855227:
                                if (name.equals("OnSwipe")) {
                                    c4 = 2;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 793277014:
                                if (name.equals("MotionScene")) {
                                    c4 = 0;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c4 = 4;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            default:
                                c4 = 65535;
                                break;
                        }
                        switch (c4) {
                            case 0:
                                i(context, xml);
                                continue;
                            case 1:
                                zVar = new z(this, context, xml);
                                arrayList.add(zVar);
                                if (this.f1079c == null && !zVar.f5918b) {
                                    this.f1079c = zVar;
                                    c cVar = zVar.f5928l;
                                    if (cVar != null) {
                                        cVar.b(this.f1091o);
                                    }
                                }
                                if (zVar.f5918b) {
                                    if (zVar.f5919c == -1) {
                                        this.f1081e = zVar;
                                    } else {
                                        this.f1082f.add(zVar);
                                    }
                                    arrayList.remove(zVar);
                                    continue;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (zVar == null) {
                                    Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i4) + ".xml:" + xml.getLineNumber() + ")");
                                }
                                zVar.f5928l = new c(context, this.f1077a, xml);
                                continue;
                            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                                zVar.getClass();
                                zVar.f5929m.add(new y(context, zVar, xml));
                                continue;
                            case VisibleForTesting.PROTECTED /* 4 */:
                                this.f1078b = new n(context, xml);
                                continue;
                            case VisibleForTesting.NONE /* 5 */:
                                h(context, xml);
                                continue;
                            case 6:
                                zVar.f5927k.add(new k(xml));
                                continue;
                            default:
                                Log.v("MotionScene", "WARNING UNKNOWN ATTRIBUTE " + name);
                                continue;
                        }
                    }
                } else {
                    xml.getName();
                    continue;
                }
                eventType = xml.next();
            } else {
                this.f1083g.put(R.id.motion_base, new d());
                this.f1084h.put("motion_base", Integer.valueOf((int) R.id.motion_base));
                return;
            }
        }
    }

    public final boolean a(MotionLayout motionLayout, int i4) {
        if (this.f1090n != null) {
            return false;
        }
        Iterator it = this.f1080d.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            int i5 = zVar.f5930n;
            if (i5 != 0) {
                int i6 = zVar.f5920d;
                MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.f1070d;
                MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.f1069c;
                MotionLayout.TransitionState transitionState3 = MotionLayout.TransitionState.f1068b;
                if (i4 == i6 && (i5 == 4 || i5 == 2)) {
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(zVar);
                    if (zVar.f5930n == 4) {
                        motionLayout.o(1.0f);
                        motionLayout.setState(transitionState3);
                        motionLayout.setState(transitionState2);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.p(true);
                        motionLayout.setState(transitionState3);
                        motionLayout.setState(transitionState2);
                        motionLayout.setState(transitionState);
                    }
                    return true;
                } else if (i4 == zVar.f5919c && (i5 == 3 || i5 == 1)) {
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(zVar);
                    if (zVar.f5930n == 3) {
                        motionLayout.o(0.0f);
                        motionLayout.setState(transitionState3);
                        motionLayout.setState(transitionState2);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.p(true);
                        motionLayout.setState(transitionState3);
                        motionLayout.setState(transitionState2);
                        motionLayout.setState(transitionState);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final d b(int i4) {
        int c4;
        n nVar = this.f1078b;
        if (nVar != null && (c4 = nVar.c(i4)) != -1) {
            i4 = c4;
        }
        SparseArray sparseArray = this.f1083g;
        if (sparseArray.get(i4) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + com.google.common.collect.c.D0(this.f1077a.getContext(), i4) + " In MotionScene");
            i4 = sparseArray.keyAt(0);
        }
        return (d) sparseArray.get(i4);
    }

    public final int c(Context context, String str) {
        int i4;
        if (str.contains("/")) {
            i4 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i4 = -1;
        }
        if (i4 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
            return i4;
        }
        return i4;
    }

    public final Interpolator d() {
        z zVar = this.f1079c;
        int i4 = zVar.f5921e;
        if (i4 != -2) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return null;
                                }
                                return new BounceInterpolator();
                            }
                            return new AnticipateInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new x(this, e.c(zVar.f5922f));
        }
        return AnimationUtils.loadInterpolator(this.f1077a.getContext(), this.f1079c.f5923g);
    }

    public final void e(p pVar) {
        z zVar = this.f1079c;
        if (zVar == null) {
            z zVar2 = this.f1081e;
            if (zVar2 != null) {
                Iterator it = zVar2.f5927k.iterator();
                while (it.hasNext()) {
                    ((k) it.next()).a(pVar);
                }
                return;
            }
            return;
        }
        Iterator it2 = zVar.f5927k.iterator();
        while (it2.hasNext()) {
            ((k) it2.next()).a(pVar);
        }
    }

    public final float f() {
        c cVar;
        z zVar = this.f1079c;
        if (zVar != null && (cVar = zVar.f5928l) != null) {
            return cVar.f1112q;
        }
        return 0.0f;
    }

    public final int g() {
        z zVar = this.f1079c;
        if (zVar == null) {
            return -1;
        }
        return zVar.f5920d;
    }

    public final void h(Context context, XmlResourceParser xmlResourceParser) {
        d dVar = new d();
        dVar.f1320b = false;
        int attributeCount = xmlResourceParser.getAttributeCount();
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeName = xmlResourceParser.getAttributeName(i6);
            String attributeValue = xmlResourceParser.getAttributeValue(i6);
            attributeName.getClass();
            if (!attributeName.equals("deriveConstraintsFrom")) {
                if (attributeName.equals("id")) {
                    i4 = c(context, attributeValue);
                    int indexOf = attributeValue.indexOf(47);
                    if (indexOf >= 0) {
                        attributeValue = attributeValue.substring(indexOf + 1);
                    }
                    this.f1084h.put(attributeValue, Integer.valueOf(i4));
                }
            } else {
                i5 = c(context, attributeValue);
            }
        }
        if (i4 != -1) {
            int i7 = this.f1077a.J;
            dVar.i(context, xmlResourceParser);
            if (i5 != -1) {
                this.f1085i.put(i4, i5);
            }
            this.f1083g.put(i4, dVar);
        }
    }

    public final void i(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), t.k.f6659l);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                this.f1086j = obtainStyledAttributes.getInt(index, this.f1086j);
            } else if (index == 1) {
                this.f1087k = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void j(int i4) {
        SparseIntArray sparseIntArray = this.f1085i;
        int i5 = sparseIntArray.get(i4);
        if (i5 > 0) {
            j(sparseIntArray.get(i4));
            SparseArray sparseArray = this.f1083g;
            d dVar = (d) sparseArray.get(i4);
            d dVar2 = (d) sparseArray.get(i5);
            if (dVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + com.google.common.collect.c.D0(this.f1077a.getContext(), i5));
                return;
            }
            dVar.getClass();
            HashMap hashMap = dVar2.f1321c;
            for (Integer num : hashMap.keySet()) {
                num.getClass();
                androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) hashMap.get(num);
                HashMap hashMap2 = dVar.f1321c;
                if (!hashMap2.containsKey(num)) {
                    hashMap2.put(num, new androidx.constraintlayout.widget.c());
                }
                androidx.constraintlayout.widget.c cVar2 = (androidx.constraintlayout.widget.c) hashMap2.get(num);
                t.e eVar = cVar2.f1314d;
                if (!eVar.f6587b) {
                    eVar.a(cVar.f1314d);
                }
                g gVar = cVar2.f1312b;
                if (!gVar.f6629a) {
                    g gVar2 = cVar.f1312b;
                    gVar.f6629a = gVar2.f6629a;
                    gVar.f6630b = gVar2.f6630b;
                    gVar.f6632d = gVar2.f6632d;
                    gVar.f6633e = gVar2.f6633e;
                    gVar.f6631c = gVar2.f6631c;
                }
                h hVar = cVar2.f1315e;
                if (!hVar.f6635a) {
                    hVar.a(cVar.f1315e);
                }
                f fVar = cVar2.f1313c;
                if (!fVar.f6622a) {
                    fVar.a(cVar.f1313c);
                }
                for (String str : cVar.f1316f.keySet()) {
                    if (!cVar2.f1316f.containsKey(str)) {
                        cVar2.f1316f.put(str, cVar.f1316f.get(str));
                    }
                }
            }
            sparseIntArray.put(i4, -1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r2 != (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(int r9, int r10) {
        /*
            r8 = this;
            t.n r0 = r8.f1078b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.c(r9)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r9
        Ld:
            t.n r2 = r8.f1078b
            int r2 = r2.c(r10)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r10
            goto L1a
        L18:
            r0 = r9
            goto L16
        L1a:
            java.util.ArrayList r3 = r8.f1080d
            java.util.Iterator r4 = r3.iterator()
        L20:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L46
            java.lang.Object r5 = r4.next()
            o.z r5 = (o.z) r5
            int r6 = r5.f5919c
            if (r6 != r2) goto L34
            int r7 = r5.f5920d
            if (r7 == r0) goto L3a
        L34:
            if (r6 != r10) goto L20
            int r6 = r5.f5920d
            if (r6 != r9) goto L20
        L3a:
            r8.f1079c = r5
            androidx.constraintlayout.motion.widget.c r9 = r5.f5928l
            if (r9 == 0) goto L45
            boolean r10 = r8.f1091o
            r9.b(r10)
        L45:
            return
        L46:
            o.z r9 = r8.f1081e
            java.util.ArrayList r4 = r8.f1082f
            java.util.Iterator r4 = r4.iterator()
        L4e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L60
            java.lang.Object r5 = r4.next()
            o.z r5 = (o.z) r5
            int r6 = r5.f5919c
            if (r6 != r10) goto L4e
            r9 = r5
            goto L4e
        L60:
            o.z r10 = new o.z
            r10.<init>(r8, r9)
            r10.f5920d = r0
            r10.f5919c = r2
            if (r0 == r1) goto L6e
            r3.add(r10)
        L6e:
            r8.f1079c = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.b.k(int, int):void");
    }

    public final boolean l() {
        Iterator it = this.f1080d.iterator();
        while (it.hasNext()) {
            if (((z) it.next()).f5928l != null) {
                return true;
            }
        }
        z zVar = this.f1079c;
        if (zVar != null && zVar.f5928l != null) {
            return true;
        }
        return false;
    }
}