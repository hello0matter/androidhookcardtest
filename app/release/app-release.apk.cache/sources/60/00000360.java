package androidx.viewpager2.widget;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2473a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2474b;

    public e(int i4, Object obj) {
        this.f2473a = i4;
        this.f2474b = obj;
    }

    @Override // androidx.recyclerview.widget.l0
    public final void a() {
        int i4 = this.f2473a;
        Object obj = this.f2474b;
        switch (i4) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) obj;
                viewPager2.f2437e = true;
                viewPager2.f2444l.f2471l = true;
                return;
            default:
                ((l) obj).k();
                return;
        }
    }
}