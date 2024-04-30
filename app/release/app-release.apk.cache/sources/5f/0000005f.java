package androidx.activity.result;

import android.view.View;
import i0.g2;
import i0.w;

/* loaded from: classes.dex */
public final class h implements w {

    /* renamed from: a  reason: collision with root package name */
    public int f146a;

    /* renamed from: b  reason: collision with root package name */
    public int f147b;

    /* renamed from: c  reason: collision with root package name */
    public Object f148c = new long[10];

    /* renamed from: d  reason: collision with root package name */
    public Object f149d = new Object[10];

    public final Object a(long j4, boolean z4) {
        long j5 = Long.MAX_VALUE;
        Object obj = null;
        while (true) {
            int i4 = this.f147b;
            if (i4 <= 0) {
                break;
            }
            int i5 = this.f146a;
            long j6 = j4 - ((long[]) this.f148c)[i5];
            if (j6 < 0 && (z4 || (-j6) >= j5)) {
                break;
            } else if (i4 > 0) {
                Object[] objArr = (Object[]) this.f149d;
                obj = objArr[i5];
                objArr[i5] = null;
                this.f146a = (i5 + 1) % objArr.length;
                this.f147b = i4 - 1;
                j5 = j6;
            } else {
                throw new IllegalStateException();
            }
        }
        return obj;
    }

    @Override // i0.w
    public final g2 i(View view, g2 g2Var) {
        int i4 = g2Var.f4931a.f(7).f2491b;
        int i5 = this.f146a;
        Object obj = this.f148c;
        if (i5 >= 0) {
            View view2 = (View) obj;
            view2.getLayoutParams().height = this.f146a + i4;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        View view3 = (View) obj;
        view3.setPadding(view3.getPaddingLeft(), this.f147b + i4, view3.getPaddingRight(), view3.getPaddingBottom());
        return g2Var;
    }
}