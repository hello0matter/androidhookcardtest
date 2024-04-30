package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.fragment.app.n f1923a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1924b;

    /* renamed from: c  reason: collision with root package name */
    public int f1925c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f1926d;

    public v(w wVar, androidx.fragment.app.n nVar) {
        this.f1926d = wVar;
        this.f1923a = nVar;
    }

    public final void c(boolean z4) {
        int i4;
        if (z4 == this.f1924b) {
            return;
        }
        this.f1924b = z4;
        if (z4) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        w wVar = this.f1926d;
        int i5 = wVar.f1930c;
        wVar.f1930c = i4 + i5;
        if (!wVar.f1931d) {
            wVar.f1931d = true;
            while (true) {
                try {
                    int i6 = wVar.f1930c;
                    if (i5 == i6) {
                        break;
                    }
                    i5 = i6;
                } finally {
                    wVar.f1931d = false;
                }
            }
        }
        if (this.f1924b) {
            wVar.c(this);
        }
    }

    public void d() {
    }

    public abstract boolean e();
}