package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.util.Arrays;
import java.util.HashMap;
import q.j;
import t.e;
import t.k;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a  reason: collision with root package name */
    public int[] f1223a;

    /* renamed from: b  reason: collision with root package name */
    public int f1224b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f1225c;

    /* renamed from: d  reason: collision with root package name */
    public j f1226d;

    /* renamed from: e  reason: collision with root package name */
    public String f1227e;

    /* renamed from: f  reason: collision with root package name */
    public View[] f1228f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap f1229g;

    public ConstraintHelper(Context context) {
        super(context);
        this.f1223a = new int[32];
        this.f1228f = null;
        this.f1229g = new HashMap();
        this.f1225c = context;
        g(null);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.f1225c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int e4 = e(trim);
        if (e4 != 0) {
            this.f1229g.put(Integer.valueOf(e4), trim);
            b(e4);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final void b(int i4) {
        if (i4 == getId()) {
            return;
        }
        int i5 = this.f1224b + 1;
        int[] iArr = this.f1223a;
        if (i5 > iArr.length) {
            this.f1223a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1223a;
        int i6 = this.f1224b;
        iArr2[i6] = i4;
        this.f1224b = i6 + 1;
    }

    public final void c() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i4 = 0; i4 < this.f1224b; i4++) {
                View c4 = constraintLayout.c(this.f1223a[i4]);
                if (c4 != null) {
                    c4.setVisibility(visibility);
                    if (elevation > 0.0f) {
                        c4.setTranslationZ(c4.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f1225c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = constraintLayout.getChildAt(i4);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int e(java.lang.String r5) {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r1 = 0
            if (r0 == 0) goto L10
            android.view.ViewParent r0 = r4.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            goto L11
        L10:
            r0 = r1
        L11:
            boolean r2 = r4.isInEditMode()
            if (r2 == 0) goto L3a
            if (r0 == 0) goto L3a
            boolean r2 = r5 instanceof java.lang.String
            if (r2 == 0) goto L2e
            java.util.HashMap r2 = r0.f1243m
            if (r2 == 0) goto L2e
            boolean r2 = r2.containsKey(r5)
            if (r2 == 0) goto L2e
            java.util.HashMap r2 = r0.f1243m
            java.lang.Object r2 = r2.get(r5)
            goto L2f
        L2e:
            r2 = r1
        L2f:
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L3a
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L3b
        L3a:
            r2 = 0
        L3b:
            if (r2 != 0) goto L43
            if (r0 == 0) goto L43
            int r2 = r4.d(r0, r5)
        L43:
            if (r2 != 0) goto L4f
            java.lang.Class<t.j> r0 = t.j.class
            java.lang.reflect.Field r0 = r0.getField(r5)     // Catch: java.lang.Exception -> L4f
            int r2 = r0.getInt(r1)     // Catch: java.lang.Exception -> L4f
        L4f:
            if (r2 != 0) goto L61
            android.content.Context r0 = r4.f1225c
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r2 = r1.getIdentifier(r5, r2, r0)
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.e(java.lang.String):int");
    }

    public final View[] f(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1228f;
        if (viewArr == null || viewArr.length != this.f1224b) {
            this.f1228f = new View[this.f1224b];
        }
        for (int i4 = 0; i4 < this.f1224b; i4++) {
            this.f1228f[i4] = constraintLayout.c(this.f1223a[i4]);
        }
        return this.f1228f;
    }

    public void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6649b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 19) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1227e = string;
                    setIds(string);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1223a, this.f1224b);
    }

    public void h(c cVar, j jVar, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        e eVar = cVar.f1314d;
        int[] iArr = eVar.f6594e0;
        int i4 = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = eVar.f6596f0;
            if (str != null && str.length() > 0) {
                String[] split = eVar.f6596f0.split(",");
                getContext();
                int[] iArr2 = new int[split.length];
                int i5 = 0;
                for (String str2 : split) {
                    int e4 = e(str2.trim());
                    if (e4 != 0) {
                        iArr2[i5] = e4;
                        i5++;
                    }
                }
                if (i5 != split.length) {
                    iArr2 = Arrays.copyOf(iArr2, i5);
                }
                eVar.f6594e0 = iArr2;
            }
        }
        jVar.f6285i0 = 0;
        Arrays.fill(jVar.f6284h0, (Object) null);
        if (eVar.f6594e0 == null) {
            return;
        }
        while (true) {
            int[] iArr3 = eVar.f6594e0;
            if (i4 < iArr3.length) {
                q.d dVar = (q.d) sparseArray.get(iArr3[i4]);
                if (dVar != null) {
                    jVar.D(dVar);
                }
                i4++;
            } else {
                return;
            }
        }
    }

    public void j() {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    public final void l() {
        if (this.f1226d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f1269l0 = this.f1226d;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1227e;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f1227e = str;
        if (str == null) {
            return;
        }
        int i4 = 0;
        this.f1224b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i4);
            if (indexOf == -1) {
                a(str.substring(i4));
                return;
            } else {
                a(str.substring(i4, indexOf));
                i4 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1227e = null;
        this.f1224b = 0;
        for (int i4 : iArr) {
            b(i4);
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1223a = new int[32];
        this.f1228f = null;
        this.f1229g = new HashMap();
        this.f1225c = context;
        g(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1223a = new int[32];
        this.f1228f = null;
        this.f1229g = new HashMap();
        this.f1225c = context;
        g(attributeSet);
    }

    public void i(q.d dVar, boolean z4) {
    }
}