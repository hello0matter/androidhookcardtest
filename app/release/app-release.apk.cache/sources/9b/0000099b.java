package t;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import m3.o;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f6577a;

    /* renamed from: b  reason: collision with root package name */
    public int f6578b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintLayout f6579c;

    /* renamed from: d  reason: collision with root package name */
    public ThreadPoolExecutor f6580d;

    /* renamed from: e  reason: collision with root package name */
    public Cloneable f6581e;

    /* renamed from: f  reason: collision with root package name */
    public Cloneable f6582f;

    /* renamed from: g  reason: collision with root package name */
    public Object f6583g;

    public final q3.g a(String str) {
        Iterator it = ((ArrayDeque) this.f6582f).iterator();
        while (it.hasNext()) {
            q3.g gVar = (q3.g) it.next();
            if (com.google.common.collect.c.n(((o) gVar.f6394c.f6398b.f989b).f5546d, str)) {
                return gVar;
            }
        }
        Iterator it2 = ((ArrayDeque) this.f6581e).iterator();
        while (it2.hasNext()) {
            q3.g gVar2 = (q3.g) it2.next();
            if (com.google.common.collect.c.n(((o) gVar2.f6394c.f6398b.f989b).f5546d, str)) {
                return gVar2;
            }
        }
        return null;
    }

    public final void b(q3.g gVar) {
        Runnable runnable;
        com.google.common.collect.c.F(gVar, "call");
        gVar.f6393b.decrementAndGet();
        ArrayDeque arrayDeque = (ArrayDeque) this.f6582f;
        synchronized (this) {
            if (arrayDeque.remove(gVar)) {
                runnable = (Runnable) this.f6579c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!d() && runnable != null) {
            runnable.run();
        }
    }

    public final void c(Context context, XmlResourceParser xmlResourceParser) {
        int i4;
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            if ("id".equals(xmlResourceParser.getAttributeName(i5))) {
                String attributeValue = xmlResourceParser.getAttributeValue(i5);
                if (attributeValue.contains("/")) {
                    i4 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i4 = -1;
                }
                if (i4 == -1) {
                    if (attributeValue.length() > 1) {
                        i4 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.i(context, xmlResourceParser);
                ((SparseArray) this.f6582f).put(i4, dVar);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t.d.d():boolean");
    }

    public final void e(float f4, float f5, int i4) {
        androidx.constraintlayout.widget.d dVar;
        Object obj;
        androidx.constraintlayout.widget.d dVar2;
        int i5 = this.f6577a;
        ConstraintLayout constraintLayout = this.f6579c;
        Cloneable cloneable = this.f6581e;
        int i6 = 0;
        if (i5 == i4) {
            SparseArray sparseArray = (SparseArray) cloneable;
            if (i4 == -1) {
                obj = sparseArray.valueAt(0);
            } else {
                obj = sparseArray.get(i5);
            }
            b bVar = (b) obj;
            int i7 = this.f6578b;
            if (i7 != -1 && ((c) bVar.f6568b.get(i7)).a(f4, f5)) {
                return;
            }
            while (true) {
                ArrayList arrayList = bVar.f6568b;
                if (i6 < arrayList.size()) {
                    if (((c) arrayList.get(i6)).a(f4, f5)) {
                        break;
                    }
                    i6++;
                } else {
                    i6 = -1;
                    break;
                }
            }
            if (this.f6578b == i6) {
                return;
            }
            ArrayList arrayList2 = bVar.f6568b;
            if (i6 == -1) {
                dVar2 = (androidx.constraintlayout.widget.d) this.f6580d;
            } else {
                dVar2 = ((c) arrayList2.get(i6)).f6576f;
            }
            if (i6 != -1) {
                int i8 = ((c) arrayList2.get(i6)).f6575e;
            }
            if (dVar2 == null) {
                return;
            }
            this.f6578b = i6;
            androidx.activity.j.f(this.f6583g);
            dVar2.b(constraintLayout);
        } else {
            this.f6577a = i4;
            b bVar2 = (b) ((SparseArray) cloneable).get(i4);
            while (true) {
                ArrayList arrayList3 = bVar2.f6568b;
                if (i6 < arrayList3.size()) {
                    if (((c) arrayList3.get(i6)).a(f4, f5)) {
                        break;
                    }
                    i6++;
                } else {
                    i6 = -1;
                    break;
                }
            }
            ArrayList arrayList4 = bVar2.f6568b;
            if (i6 == -1) {
                dVar = bVar2.f6570d;
            } else {
                dVar = ((c) arrayList4.get(i6)).f6576f;
            }
            if (i6 != -1) {
                int i9 = ((c) arrayList4.get(i6)).f6575e;
            }
            if (dVar == null) {
                Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i4 + ", dim =" + f4 + ", " + f5);
                return;
            }
            this.f6578b = i6;
            androidx.activity.j.f(this.f6583g);
            dVar.b(constraintLayout);
        }
        androidx.activity.j.f(this.f6583g);
    }
}