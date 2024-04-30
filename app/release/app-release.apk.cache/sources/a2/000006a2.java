package f;

import android.view.View;
import androidx.appcompat.widget.x3;
import i0.h1;

/* loaded from: classes.dex */
public final class m extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4499q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4500r;

    /* renamed from: s  reason: collision with root package name */
    public int f4501s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f4502t;

    public m(x3 x3Var, int i4) {
        this.f4499q = 1;
        this.f4502t = x3Var;
        this.f4501s = i4;
        this.f4500r = false;
    }

    @Override // i0.h1
    public final void a() {
        int i4 = this.f4499q;
        Object obj = this.f4502t;
        switch (i4) {
            case 0:
                int i5 = this.f4501s + 1;
                this.f4501s = i5;
                n nVar = (n) obj;
                if (i5 == nVar.f4503a.size()) {
                    h1 h1Var = nVar.f4506d;
                    if (h1Var != null) {
                        h1Var.a();
                    }
                    this.f4501s = 0;
                    this.f4500r = false;
                    nVar.f4507e = false;
                    return;
                }
                return;
            default:
                if (!this.f4500r) {
                    ((x3) obj).f950a.setVisibility(this.f4501s);
                    return;
                }
                return;
        }
    }

    @Override // com.google.common.collect.c, i0.h1
    public final void g(View view) {
        switch (this.f4499q) {
            case 1:
                this.f4500r = true;
                return;
            default:
                return;
        }
    }

    @Override // com.google.common.collect.c, i0.h1
    public final void i() {
        int i4 = this.f4499q;
        Object obj = this.f4502t;
        switch (i4) {
            case 0:
                if (!this.f4500r) {
                    this.f4500r = true;
                    h1 h1Var = ((n) obj).f4506d;
                    if (h1Var != null) {
                        h1Var.i();
                        return;
                    }
                    return;
                }
                return;
            default:
                ((x3) obj).f950a.setVisibility(0);
                return;
        }
    }

    public m(n nVar) {
        this.f4499q = 0;
        this.f4502t = nVar;
        this.f4500r = false;
        this.f4501s = 0;
    }
}