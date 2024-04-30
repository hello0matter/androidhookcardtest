package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class a implements i0.h1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f688a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f689b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f690c;

    public a(b bVar) {
        this.f690c = bVar;
    }

    @Override // i0.h1
    public final void a() {
        if (this.f688a) {
            return;
        }
        b bVar = this.f690c;
        bVar.f712f = null;
        super/*android.view.View*/.setVisibility(this.f689b);
    }

    @Override // i0.h1
    public final void g(View view) {
        this.f688a = true;
    }

    @Override // i0.h1
    public final void i() {
        super/*android.view.View*/.setVisibility(0);
        this.f688a = false;
    }
}