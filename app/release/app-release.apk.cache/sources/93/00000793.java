package i2;

import a0.p;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f5044a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f5045b;

    public e(g gVar, h hVar) {
        this.f5045b = gVar;
        this.f5044a = hVar;
    }

    @Override // a0.p
    public final void c(int i4) {
        this.f5045b.f5062m = true;
        this.f5044a.a(i4);
    }

    @Override // a0.p
    public final void d(Typeface typeface) {
        g gVar = this.f5045b;
        gVar.f5063n = Typeface.create(typeface, gVar.f5052c);
        gVar.f5062m = true;
        this.f5044a.b(gVar.f5063n, false);
    }
}