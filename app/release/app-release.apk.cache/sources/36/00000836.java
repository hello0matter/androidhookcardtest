package l;

/* loaded from: classes.dex */
public final class a extends g.e {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5209d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f5210e;

    public a(int i4, Object obj) {
        this.f5209d = i4;
        this.f5210e = obj;
    }

    @Override // g.e
    public final void d() {
        int i4 = this.f5209d;
        Object obj = this.f5210e;
        switch (i4) {
            case 0:
                ((b) obj).clear();
                return;
            default:
                ((c) obj).clear();
                return;
        }
    }

    @Override // g.e
    public final Object e(int i4, int i5) {
        int i6 = this.f5209d;
        Object obj = this.f5210e;
        switch (i6) {
            case 0:
                return ((b) obj).f5251b[(i4 << 1) + i5];
            default:
                return ((c) obj).f5219b[i4];
        }
    }

    @Override // g.e
    public final b f() {
        switch (this.f5209d) {
            case 0:
                return (b) this.f5210e;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    @Override // g.e
    public final int g() {
        int i4 = this.f5209d;
        Object obj = this.f5210e;
        switch (i4) {
            case 0:
                return ((b) obj).f5252c;
            default:
                return ((c) obj).f5220c;
        }
    }

    @Override // g.e
    public final int h(Object obj) {
        int i4 = this.f5209d;
        Object obj2 = this.f5210e;
        switch (i4) {
            case 0:
                return ((b) obj2).e(obj);
            default:
                return ((c) obj2).indexOf(obj);
        }
    }

    @Override // g.e
    public final int i(Object obj) {
        int i4 = this.f5209d;
        Object obj2 = this.f5210e;
        switch (i4) {
            case 0:
                return ((b) obj2).g(obj);
            default:
                return ((c) obj2).indexOf(obj);
        }
    }

    @Override // g.e
    public final void j(Object obj, Object obj2) {
        int i4 = this.f5209d;
        Object obj3 = this.f5210e;
        switch (i4) {
            case 0:
                ((b) obj3).put(obj, obj2);
                return;
            default:
                ((c) obj3).add(obj);
                return;
        }
    }

    @Override // g.e
    public final void k(int i4) {
        int i5 = this.f5209d;
        Object obj = this.f5210e;
        switch (i5) {
            case 0:
                ((b) obj).i(i4);
                return;
            default:
                ((c) obj).e(i4);
                return;
        }
    }

    @Override // g.e
    public final Object l(int i4, Object obj) {
        switch (this.f5209d) {
            case 0:
                int i5 = (i4 << 1) + 1;
                Object[] objArr = ((b) this.f5210e).f5251b;
                Object obj2 = objArr[i5];
                objArr[i5] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }
}