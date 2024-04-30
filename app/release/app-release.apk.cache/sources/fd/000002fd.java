package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    public int f2126a;

    /* renamed from: b  reason: collision with root package name */
    public int f2127b;

    /* renamed from: c  reason: collision with root package name */
    public int f2128c;

    /* renamed from: d  reason: collision with root package name */
    public int f2129d;

    /* renamed from: e  reason: collision with root package name */
    public int f2130e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2131f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2132g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2133h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2134i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2135j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2136k;

    /* renamed from: l  reason: collision with root package name */
    public int f2137l;

    /* renamed from: m  reason: collision with root package name */
    public long f2138m;

    /* renamed from: n  reason: collision with root package name */
    public int f2139n;

    public final void a(int i4) {
        if ((this.f2129d & i4) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i4) + " but it is " + Integer.toBinaryString(this.f2129d));
    }

    public final int b() {
        return this.f2132g ? this.f2127b - this.f2128c : this.f2130e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f2126a + ", mData=null, mItemCount=" + this.f2130e + ", mIsMeasuring=" + this.f2134i + ", mPreviousLayoutItemCount=" + this.f2127b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2128c + ", mStructureChanged=" + this.f2131f + ", mInPreLayout=" + this.f2132g + ", mRunSimpleAnimations=" + this.f2135j + ", mRunPredictiveAnimations=" + this.f2136k + '}';
    }
}