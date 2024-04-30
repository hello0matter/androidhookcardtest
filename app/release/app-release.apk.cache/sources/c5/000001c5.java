package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import t.e;
import t.f;
import t.g;
import t.h;
import t.j;
import t.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1317d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    public static final SparseIntArray f1318e;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1319a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1320b = true;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f1321c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1318e = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(103, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(102, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(104, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    public static int[] e(Barrier barrier, String str) {
        int i4;
        HashMap hashMap;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < split.length) {
            String trim = split[i5].trim();
            Object obj = null;
            try {
                i4 = j.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i4 = 0;
            }
            if (i4 == 0) {
                i4 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i4 == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                constraintLayout.getClass();
                if ((trim instanceof String) && (hashMap = constraintLayout.f1243m) != null && hashMap.containsKey(trim)) {
                    obj = constraintLayout.f1243m.get(trim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    i4 = ((Integer) obj).intValue();
                }
            }
            iArr[i6] = i4;
            i5++;
            i6++;
        }
        if (i6 != split.length) {
            return Arrays.copyOf(iArr, i6);
        }
        return iArr;
    }

    public static c f(Context context, AttributeSet attributeSet) {
        String str;
        StringBuilder sb;
        c cVar = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6648a);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            g gVar = cVar.f1312b;
            f fVar = cVar.f1313c;
            h hVar = cVar.f1315e;
            e eVar = cVar.f1314d;
            if (index != 1 && 23 != index && 24 != index) {
                fVar.f6622a = true;
                eVar.f6587b = true;
                gVar.f6629a = true;
                hVar.f6635a = true;
            }
            SparseIntArray sparseIntArray = f1318e;
            switch (sparseIntArray.get(index)) {
                case 1:
                    eVar.f6610p = j(obtainStyledAttributes, index, eVar.f6610p);
                    continue;
                case 2:
                    eVar.G = obtainStyledAttributes.getDimensionPixelSize(index, eVar.G);
                    continue;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    eVar.f6609o = j(obtainStyledAttributes, index, eVar.f6609o);
                    continue;
                case VisibleForTesting.PROTECTED /* 4 */:
                    eVar.f6608n = j(obtainStyledAttributes, index, eVar.f6608n);
                    continue;
                case VisibleForTesting.NONE /* 5 */:
                    eVar.f6617w = obtainStyledAttributes.getString(index);
                    continue;
                case 6:
                    eVar.A = obtainStyledAttributes.getDimensionPixelOffset(index, eVar.A);
                    continue;
                case 7:
                    eVar.B = obtainStyledAttributes.getDimensionPixelOffset(index, eVar.B);
                    continue;
                case 8:
                    eVar.H = obtainStyledAttributes.getDimensionPixelSize(index, eVar.H);
                    continue;
                case 9:
                    eVar.f6614t = j(obtainStyledAttributes, index, eVar.f6614t);
                    continue;
                case 10:
                    eVar.f6613s = j(obtainStyledAttributes, index, eVar.f6613s);
                    continue;
                case 11:
                    eVar.M = obtainStyledAttributes.getDimensionPixelSize(index, eVar.M);
                    continue;
                case 12:
                    eVar.N = obtainStyledAttributes.getDimensionPixelSize(index, eVar.N);
                    continue;
                case 13:
                    eVar.J = obtainStyledAttributes.getDimensionPixelSize(index, eVar.J);
                    continue;
                case 14:
                    eVar.L = obtainStyledAttributes.getDimensionPixelSize(index, eVar.L);
                    continue;
                case 15:
                    eVar.O = obtainStyledAttributes.getDimensionPixelSize(index, eVar.O);
                    continue;
                case 16:
                    eVar.K = obtainStyledAttributes.getDimensionPixelSize(index, eVar.K);
                    continue;
                case 17:
                    eVar.f6593e = obtainStyledAttributes.getDimensionPixelOffset(index, eVar.f6593e);
                    continue;
                case 18:
                    eVar.f6595f = obtainStyledAttributes.getDimensionPixelOffset(index, eVar.f6595f);
                    continue;
                case 19:
                    eVar.f6597g = obtainStyledAttributes.getFloat(index, eVar.f6597g);
                    continue;
                case 20:
                    eVar.f6615u = obtainStyledAttributes.getFloat(index, eVar.f6615u);
                    continue;
                case 21:
                    eVar.f6591d = obtainStyledAttributes.getLayoutDimension(index, eVar.f6591d);
                    continue;
                case 22:
                    gVar.f6630b = f1317d[obtainStyledAttributes.getInt(index, gVar.f6630b)];
                    continue;
                case 23:
                    eVar.f6589c = obtainStyledAttributes.getLayoutDimension(index, eVar.f6589c);
                    continue;
                case 24:
                    eVar.D = obtainStyledAttributes.getDimensionPixelSize(index, eVar.D);
                    continue;
                case 25:
                    eVar.f6599h = j(obtainStyledAttributes, index, eVar.f6599h);
                    continue;
                case 26:
                    eVar.f6601i = j(obtainStyledAttributes, index, eVar.f6601i);
                    continue;
                case 27:
                    eVar.C = obtainStyledAttributes.getInt(index, eVar.C);
                    continue;
                case 28:
                    eVar.E = obtainStyledAttributes.getDimensionPixelSize(index, eVar.E);
                    continue;
                case 29:
                    eVar.f6603j = j(obtainStyledAttributes, index, eVar.f6603j);
                    continue;
                case 30:
                    eVar.f6605k = j(obtainStyledAttributes, index, eVar.f6605k);
                    continue;
                case 31:
                    eVar.I = obtainStyledAttributes.getDimensionPixelSize(index, eVar.I);
                    continue;
                case 32:
                    eVar.f6611q = j(obtainStyledAttributes, index, eVar.f6611q);
                    continue;
                case 33:
                    eVar.f6612r = j(obtainStyledAttributes, index, eVar.f6612r);
                    continue;
                case 34:
                    eVar.F = obtainStyledAttributes.getDimensionPixelSize(index, eVar.F);
                    continue;
                case 35:
                    eVar.f6607m = j(obtainStyledAttributes, index, eVar.f6607m);
                    continue;
                case 36:
                    eVar.f6606l = j(obtainStyledAttributes, index, eVar.f6606l);
                    continue;
                case 37:
                    eVar.f6616v = obtainStyledAttributes.getFloat(index, eVar.f6616v);
                    continue;
                case 38:
                    cVar.f1311a = obtainStyledAttributes.getResourceId(index, cVar.f1311a);
                    continue;
                case 39:
                    eVar.Q = obtainStyledAttributes.getFloat(index, eVar.Q);
                    continue;
                case 40:
                    eVar.P = obtainStyledAttributes.getFloat(index, eVar.P);
                    continue;
                case 41:
                    eVar.R = obtainStyledAttributes.getInt(index, eVar.R);
                    continue;
                case 42:
                    eVar.S = obtainStyledAttributes.getInt(index, eVar.S);
                    continue;
                case 43:
                    gVar.f6632d = obtainStyledAttributes.getFloat(index, gVar.f6632d);
                    continue;
                case 44:
                    hVar.f6646l = true;
                    hVar.f6647m = obtainStyledAttributes.getDimension(index, hVar.f6647m);
                    continue;
                case 45:
                    hVar.f6637c = obtainStyledAttributes.getFloat(index, hVar.f6637c);
                    continue;
                case 46:
                    hVar.f6638d = obtainStyledAttributes.getFloat(index, hVar.f6638d);
                    continue;
                case 47:
                    hVar.f6639e = obtainStyledAttributes.getFloat(index, hVar.f6639e);
                    continue;
                case 48:
                    hVar.f6640f = obtainStyledAttributes.getFloat(index, hVar.f6640f);
                    continue;
                case 49:
                    hVar.f6641g = obtainStyledAttributes.getDimension(index, hVar.f6641g);
                    continue;
                case 50:
                    hVar.f6642h = obtainStyledAttributes.getDimension(index, hVar.f6642h);
                    continue;
                case 51:
                    hVar.f6643i = obtainStyledAttributes.getDimension(index, hVar.f6643i);
                    continue;
                case 52:
                    hVar.f6644j = obtainStyledAttributes.getDimension(index, hVar.f6644j);
                    continue;
                case 53:
                    hVar.f6645k = obtainStyledAttributes.getDimension(index, hVar.f6645k);
                    continue;
                case 54:
                    eVar.T = obtainStyledAttributes.getInt(index, eVar.T);
                    continue;
                case 55:
                    eVar.U = obtainStyledAttributes.getInt(index, eVar.U);
                    continue;
                case 56:
                    eVar.V = obtainStyledAttributes.getDimensionPixelSize(index, eVar.V);
                    continue;
                case 57:
                    eVar.W = obtainStyledAttributes.getDimensionPixelSize(index, eVar.W);
                    continue;
                case 58:
                    eVar.X = obtainStyledAttributes.getDimensionPixelSize(index, eVar.X);
                    continue;
                case 59:
                    eVar.Y = obtainStyledAttributes.getDimensionPixelSize(index, eVar.Y);
                    continue;
                case 60:
                    hVar.f6636b = obtainStyledAttributes.getFloat(index, hVar.f6636b);
                    continue;
                case 61:
                    eVar.f6618x = j(obtainStyledAttributes, index, eVar.f6618x);
                    continue;
                case 62:
                    eVar.f6619y = obtainStyledAttributes.getDimensionPixelSize(index, eVar.f6619y);
                    continue;
                case 63:
                    eVar.f6620z = obtainStyledAttributes.getFloat(index, eVar.f6620z);
                    continue;
                case 64:
                    fVar.f6623b = j(obtainStyledAttributes, index, fVar.f6623b);
                    continue;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        str = obtainStyledAttributes.getString(index);
                    } else {
                        str = n.e.f5672c[obtainStyledAttributes.getInteger(index, 0)];
                    }
                    fVar.f6624c = str;
                    continue;
                case 66:
                    fVar.f6626e = obtainStyledAttributes.getInt(index, 0);
                    continue;
                case 67:
                    fVar.f6628g = obtainStyledAttributes.getFloat(index, fVar.f6628g);
                    continue;
                case 68:
                    gVar.f6633e = obtainStyledAttributes.getFloat(index, gVar.f6633e);
                    continue;
                case 69:
                    eVar.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    continue;
                case 70:
                    eVar.f6586a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    eVar.f6588b0 = obtainStyledAttributes.getInt(index, eVar.f6588b0);
                    continue;
                case 73:
                    eVar.f6590c0 = obtainStyledAttributes.getDimensionPixelSize(index, eVar.f6590c0);
                    continue;
                case 74:
                    eVar.f6596f0 = obtainStyledAttributes.getString(index);
                    continue;
                case 75:
                    eVar.f6604j0 = obtainStyledAttributes.getBoolean(index, eVar.f6604j0);
                    continue;
                case 76:
                    fVar.f6625d = obtainStyledAttributes.getInt(index, fVar.f6625d);
                    continue;
                case 77:
                    eVar.f6598g0 = obtainStyledAttributes.getString(index);
                    continue;
                case 78:
                    gVar.f6631c = obtainStyledAttributes.getInt(index, gVar.f6631c);
                    continue;
                case 79:
                    fVar.f6627f = obtainStyledAttributes.getFloat(index, fVar.f6627f);
                    continue;
                case 80:
                    eVar.f6600h0 = obtainStyledAttributes.getBoolean(index, eVar.f6600h0);
                    continue;
                case 81:
                    eVar.f6602i0 = obtainStyledAttributes.getBoolean(index, eVar.f6602i0);
                    continue;
                case 82:
                    sb = new StringBuilder("unused attribute 0x");
                    break;
                default:
                    sb = new StringBuilder("Unknown attribute 0x");
                    break;
            }
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(sparseIntArray.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
        obtainStyledAttributes.recycle();
        return cVar;
    }

    public static int j(TypedArray typedArray, int i4, int i5) {
        int resourceId = typedArray.getResourceId(i4, i5);
        return resourceId == -1 ? typedArray.getInt(i4, -1) : resourceId;
    }

    public final void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = constraintLayout.getChildAt(i4);
            int id = childAt.getId();
            HashMap hashMap = this.f1321c;
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                Log.v("ConstraintSet", "id unknown " + com.google.common.collect.c.E0(childAt));
            } else if (this.f1320b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (hashMap.containsKey(Integer.valueOf(id))) {
                    t.a.e(childAt, ((c) hashMap.get(Integer.valueOf(id))).f1316f);
                }
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        c(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = this.f1321c;
        HashSet hashSet = new HashSet(hashMap.keySet());
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = constraintLayout.getChildAt(i4);
            int id = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + com.google.common.collect.c.E0(childAt));
            } else if (this.f1320b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (hashMap.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        c cVar = (c) hashMap.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            cVar.f1314d.f6592d0 = 1;
                        }
                        int i5 = cVar.f1314d.f6592d0;
                        if (i5 != -1 && i5 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            e eVar = cVar.f1314d;
                            barrier.setType(eVar.f6588b0);
                            barrier.setMargin(eVar.f6590c0);
                            barrier.setAllowsGoneWidget(eVar.f6604j0);
                            int[] iArr = eVar.f6594e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = eVar.f6596f0;
                                if (str != null) {
                                    int[] e4 = e(barrier, str);
                                    eVar.f6594e0 = e4;
                                    barrier.setReferencedIds(e4);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.a();
                        cVar.a(layoutParams);
                        t.a.e(childAt, cVar.f1316f);
                        childAt.setLayoutParams(layoutParams);
                        g gVar = cVar.f1312b;
                        if (gVar.f6631c == 0) {
                            childAt.setVisibility(gVar.f6630b);
                        }
                        childAt.setAlpha(gVar.f6632d);
                        h hVar = cVar.f1315e;
                        childAt.setRotation(hVar.f6636b);
                        childAt.setRotationX(hVar.f6637c);
                        childAt.setRotationY(hVar.f6638d);
                        childAt.setScaleX(hVar.f6639e);
                        childAt.setScaleY(hVar.f6640f);
                        if (!Float.isNaN(hVar.f6641g)) {
                            childAt.setPivotX(hVar.f6641g);
                        }
                        if (!Float.isNaN(hVar.f6642h)) {
                            childAt.setPivotY(hVar.f6642h);
                        }
                        childAt.setTranslationX(hVar.f6643i);
                        childAt.setTranslationY(hVar.f6644j);
                        childAt.setTranslationZ(hVar.f6645k);
                        if (hVar.f6646l) {
                            childAt.setElevation(hVar.f6647m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            c cVar2 = (c) hashMap.get(num);
            e eVar2 = cVar2.f1314d;
            int i6 = eVar2.f6592d0;
            if (i6 != -1 && i6 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = eVar2.f6594e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = eVar2.f6596f0;
                    if (str2 != null) {
                        int[] e5 = e(barrier2, str2);
                        eVar2.f6594e0 = e5;
                        barrier2.setReferencedIds(e5);
                    }
                }
                barrier2.setType(eVar2.f6588b0);
                barrier2.setMargin(eVar2.f6590c0);
                int i7 = ConstraintLayout.f1230p;
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams();
                barrier2.l();
                cVar2.a(layoutParams2);
                constraintLayout.addView(barrier2, layoutParams2);
            }
            if (eVar2.f6585a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                int i8 = ConstraintLayout.f1230p;
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams();
                cVar2.a(layoutParams3);
                constraintLayout.addView(guideline, layoutParams3);
            }
        }
    }

    public final void d(ConstraintLayout constraintLayout) {
        int i4;
        d dVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = dVar.f1321c;
        hashMap.clear();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraintLayout.getChildAt(i5);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (dVar.f1320b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new c());
            }
            c cVar = (c) hashMap.get(Integer.valueOf(id));
            HashMap hashMap2 = dVar.f1319a;
            HashMap hashMap3 = new HashMap();
            Class<?> cls = childAt.getClass();
            for (String str : hashMap2.keySet()) {
                t.a aVar = (t.a) hashMap2.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        hashMap3.put(str, new t.a(aVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        i4 = childCount;
                    } else {
                        i4 = childCount;
                        try {
                            hashMap3.put(str, new t.a(aVar, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                        } catch (IllegalAccessException e4) {
                            e = e4;
                            e.printStackTrace();
                            childCount = i4;
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            e.printStackTrace();
                            childCount = i4;
                        } catch (InvocationTargetException e6) {
                            e = e6;
                            e.printStackTrace();
                            childCount = i4;
                        }
                    }
                } catch (IllegalAccessException e7) {
                    e = e7;
                    i4 = childCount;
                    e.printStackTrace();
                    childCount = i4;
                } catch (NoSuchMethodException e8) {
                    e = e8;
                    i4 = childCount;
                    e.printStackTrace();
                    childCount = i4;
                } catch (InvocationTargetException e9) {
                    e = e9;
                    i4 = childCount;
                    e.printStackTrace();
                    childCount = i4;
                }
                childCount = i4;
            }
            int i6 = childCount;
            cVar.f1316f = hashMap3;
            cVar.b(id, layoutParams);
            int visibility = childAt.getVisibility();
            g gVar = cVar.f1312b;
            gVar.f6630b = visibility;
            gVar.f6632d = childAt.getAlpha();
            float rotation = childAt.getRotation();
            h hVar = cVar.f1315e;
            hVar.f6636b = rotation;
            hVar.f6637c = childAt.getRotationX();
            hVar.f6638d = childAt.getRotationY();
            hVar.f6639e = childAt.getScaleX();
            hVar.f6640f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                hVar.f6641g = pivotX;
                hVar.f6642h = pivotY;
            }
            hVar.f6643i = childAt.getTranslationX();
            hVar.f6644j = childAt.getTranslationY();
            hVar.f6645k = childAt.getTranslationZ();
            if (hVar.f6646l) {
                hVar.f6647m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                boolean z4 = barrier.f1214j.f6170k0;
                e eVar = cVar.f1314d;
                eVar.f6604j0 = z4;
                eVar.f6594e0 = barrier.getReferencedIds();
                eVar.f6588b0 = barrier.getType();
                eVar.f6590c0 = barrier.getMargin();
            }
            i5++;
            dVar = this;
            childCount = i6;
        }
    }

    public final c g(int i4) {
        HashMap hashMap = this.f1321c;
        if (!hashMap.containsKey(Integer.valueOf(i4))) {
            hashMap.put(Integer.valueOf(i4), new c());
        }
        return (c) hashMap.get(Integer.valueOf(i4));
    }

    public final void h(Context context, int i4) {
        XmlResourceParser xml = context.getResources().getXml(i4);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    c f4 = f(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        f4.f1314d.f6585a = true;
                    }
                    this.f1321c.put(Integer.valueOf(f4.f1311a), f4);
                    continue;
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [t.a, java.lang.Object] */
    public final void i(Context context, XmlResourceParser xmlResourceParser) {
        char c4;
        Object obj;
        float dimension;
        int color;
        try {
            int eventType = xmlResourceParser.getEventType();
            c cVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    int i4 = 2;
                    if (eventType != 2) {
                        if (eventType == 3) {
                            String name = xmlResourceParser.getName();
                            if ("ConstraintSet".equals(name)) {
                                return;
                            }
                            if (name.equalsIgnoreCase("Constraint")) {
                                try {
                                    this.f1321c.put(Integer.valueOf(cVar.f1311a), cVar);
                                    cVar = null;
                                } catch (IOException e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    return;
                                } catch (XmlPullParserException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    return;
                                }
                            }
                        }
                    } else {
                        String name2 = xmlResourceParser.getName();
                        switch (name2.hashCode()) {
                            case -2025855158:
                                if (name2.equals("Layout")) {
                                    c4 = 5;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case -1984451626:
                                if (name2.equals("Motion")) {
                                    c4 = 6;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case -1269513683:
                                if (name2.equals("PropertySet")) {
                                    c4 = 3;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case -1238332596:
                                if (name2.equals("Transform")) {
                                    c4 = 4;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case -71750448:
                                if (name2.equals("Guideline")) {
                                    c4 = 1;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1331510167:
                                if (name2.equals("Barrier")) {
                                    c4 = 2;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1791837707:
                                if (name2.equals("CustomAttribute")) {
                                    c4 = 7;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1803088381:
                                if (name2.equals("Constraint")) {
                                    c4 = 0;
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
                                cVar = f(context, Xml.asAttributeSet(xmlResourceParser));
                                break;
                            case 1:
                                cVar = f(context, Xml.asAttributeSet(xmlResourceParser));
                                e eVar = cVar.f1314d;
                                eVar.f6585a = true;
                                eVar.f6587b = true;
                                break;
                            case 2:
                                cVar = f(context, Xml.asAttributeSet(xmlResourceParser));
                                cVar.f1314d.f6592d0 = 1;
                                break;
                            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                                if (cVar != null) {
                                    cVar.f1312b.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                            case VisibleForTesting.PROTECTED /* 4 */:
                                if (cVar != null) {
                                    cVar.f1315e.b(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                            case VisibleForTesting.NONE /* 5 */:
                                if (cVar != null) {
                                    cVar.f1314d.b(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                            case 6:
                                if (cVar != null) {
                                    cVar.f1313c.b(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                            case 7:
                                if (cVar != null) {
                                    HashMap hashMap = cVar.f1316f;
                                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6652e);
                                    int indexCount = obtainStyledAttributes.getIndexCount();
                                    int i5 = 0;
                                    String str = null;
                                    Object obj2 = null;
                                    ConstraintAttribute$AttributeType constraintAttribute$AttributeType = null;
                                    while (i5 < indexCount) {
                                        int index = obtainStyledAttributes.getIndex(i5);
                                        if (index == 0) {
                                            String string = obtainStyledAttributes.getString(index);
                                            if (string != null && string.length() > 0) {
                                                str = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                                            } else {
                                                str = string;
                                            }
                                        } else if (index == 1) {
                                            obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                                            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.f1220f;
                                        } else {
                                            if (index == 3) {
                                                constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.f1217c;
                                                color = obtainStyledAttributes.getColor(index, 0);
                                            } else if (index == i4) {
                                                constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.f1218d;
                                                color = obtainStyledAttributes.getColor(index, 0);
                                            } else {
                                                ConstraintAttribute$AttributeType constraintAttribute$AttributeType2 = ConstraintAttribute$AttributeType.f1221g;
                                                if (index == 7) {
                                                    dimension = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                                                } else if (index == 4) {
                                                    dimension = obtainStyledAttributes.getDimension(index, 0.0f);
                                                } else if (index == 5) {
                                                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.f1216b;
                                                    obj2 = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                                                    i5++;
                                                    i4 = 2;
                                                } else {
                                                    if (index == 6) {
                                                        constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.f1215a;
                                                        obj2 = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                                                    } else if (index == 8) {
                                                        constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.f1219e;
                                                        obj2 = obtainStyledAttributes.getString(index);
                                                    }
                                                    i5++;
                                                    i4 = 2;
                                                }
                                                obj2 = Float.valueOf(dimension);
                                                constraintAttribute$AttributeType = constraintAttribute$AttributeType2;
                                            }
                                            obj2 = Integer.valueOf(color);
                                        }
                                        i5++;
                                        i4 = 2;
                                    }
                                    String str2 = str;
                                    if (str2 != null && (obj = obj2) != null) {
                                        ?? obj3 = new Object();
                                        obj3.f6560a = str2;
                                        obj3.f6561b = constraintAttribute$AttributeType;
                                        obj3.g(obj);
                                        hashMap.put(str2, obj3);
                                    }
                                    obtainStyledAttributes.recycle();
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                }
                        }
                    }
                } else {
                    xmlResourceParser.getName();
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e6) {
            e = e6;
        } catch (XmlPullParserException e7) {
            e = e7;
        }
    }
}