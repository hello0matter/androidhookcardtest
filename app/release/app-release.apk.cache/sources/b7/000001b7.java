package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.Constraints;
import q.e;
import q.j;
import t.k;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: h  reason: collision with root package name */
    public int f1212h;

    /* renamed from: i  reason: collision with root package name */
    public int f1213i;

    /* renamed from: j  reason: collision with root package name */
    public q.a f1214j;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1214j = new q.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6649b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 15) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.f1214j.f6170k0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.f1214j.f6171l0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.f1226d = this.f1214j;
        l();
    }

    public int getMargin() {
        return this.f1214j.f6171l0;
    }

    public int getType() {
        return this.f1212h;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void h(c cVar, j jVar, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        super.h(cVar, jVar, layoutParams, sparseArray);
        if (jVar instanceof q.a) {
            q.a aVar = (q.a) jVar;
            boolean z4 = ((e) jVar.K).f6233l0;
            t.e eVar = cVar.f1314d;
            m(aVar, eVar.f6588b0, z4);
            aVar.f6170k0 = eVar.f6604j0;
            aVar.f6171l0 = eVar.f6590c0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void i(q.d dVar, boolean z4) {
        m(dVar, this.f1212h, z4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r6 == 6) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r6 == 6) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(q.d r4, int r5, boolean r6) {
        /*
            r3 = this;
            r3.f1213i = r5
            r5 = 0
            r0 = 6
            r1 = 1
            r2 = 5
            if (r6 == 0) goto L14
            int r6 = r3.f1212h
            if (r6 != r2) goto Lf
        Lc:
            r3.f1213i = r1
            goto L1c
        Lf:
            if (r6 != r0) goto L1c
        L11:
            r3.f1213i = r5
            goto L1c
        L14:
            int r6 = r3.f1212h
            if (r6 != r2) goto L19
            goto L11
        L19:
            if (r6 != r0) goto L1c
            goto Lc
        L1c:
            boolean r5 = r4 instanceof q.a
            if (r5 == 0) goto L26
            q.a r4 = (q.a) r4
            int r5 = r3.f1213i
            r4.f6169j0 = r5
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.m(q.d, int, boolean):void");
    }

    public void setAllowsGoneWidget(boolean z4) {
        this.f1214j.f6170k0 = z4;
    }

    public void setDpMargin(int i4) {
        this.f1214j.f6171l0 = (int) ((i4 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i4) {
        this.f1214j.f6171l0 = i4;
    }

    public void setType(int i4) {
        this.f1212h = i4;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        super.setVisibility(8);
    }
}