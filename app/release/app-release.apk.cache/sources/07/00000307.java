package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class m extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f2188a;

    public m(p pVar) {
        this.f2188a = pVar;
    }

    @Override // androidx.recyclerview.widget.y0
    public final void b(RecyclerView recyclerView, int i4, int i5) {
        boolean z4;
        boolean z5;
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        p pVar = this.f2188a;
        int computeVerticalScrollRange = pVar.f2221s.computeVerticalScrollRange();
        int i6 = pVar.f2220r;
        int i7 = computeVerticalScrollRange - i6;
        int i8 = pVar.f2203a;
        if (i7 > 0 && i6 >= i8) {
            z4 = true;
        } else {
            z4 = false;
        }
        pVar.f2222t = z4;
        int computeHorizontalScrollRange = pVar.f2221s.computeHorizontalScrollRange();
        int i9 = pVar.f2219q;
        if (computeHorizontalScrollRange - i9 > 0 && i9 >= i8) {
            z5 = true;
        } else {
            z5 = false;
        }
        pVar.f2223u = z5;
        boolean z6 = pVar.f2222t;
        if (!z6 && !z5) {
            if (pVar.f2224v != 0) {
                pVar.g(0);
                return;
            }
            return;
        }
        if (z6) {
            float f4 = i6;
            pVar.f2214l = (int) ((((f4 / 2.0f) + computeVerticalScrollOffset) * f4) / computeVerticalScrollRange);
            pVar.f2213k = Math.min(i6, (i6 * i6) / computeVerticalScrollRange);
        }
        if (pVar.f2223u) {
            float f5 = computeHorizontalScrollOffset;
            float f6 = i9;
            pVar.f2217o = (int) ((((f6 / 2.0f) + f5) * f6) / computeHorizontalScrollRange);
            pVar.f2216n = Math.min(i9, (i9 * i9) / computeHorizontalScrollRange);
        }
        int i10 = pVar.f2224v;
        if (i10 == 0 || i10 == 1) {
            pVar.g(1);
        }
    }
}