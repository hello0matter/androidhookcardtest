package i0;

import android.view.WindowInsets;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class v1 extends x1 {

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsets.Builder f4992c;

    public v1() {
        this.f4992c = u1.b();
    }

    @Override // i0.x1
    @NonNull
    public g2 b() {
        WindowInsets build;
        a();
        build = this.f4992c.build();
        g2 h4 = g2.h(null, build);
        h4.f4931a.o(this.f4998b);
        return h4;
    }

    @Override // i0.x1
    public void d(@NonNull b0.c cVar) {
        this.f4992c.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // i0.x1
    public void e(@NonNull b0.c cVar) {
        this.f4992c.setStableInsets(cVar.d());
    }

    @Override // i0.x1
    public void f(@NonNull b0.c cVar) {
        this.f4992c.setSystemGestureInsets(cVar.d());
    }

    @Override // i0.x1
    public void g(@NonNull b0.c cVar) {
        this.f4992c.setSystemWindowInsets(cVar.d());
    }

    @Override // i0.x1
    public void h(@NonNull b0.c cVar) {
        this.f4992c.setTappableElementInsets(cVar.d());
    }

    public v1(@NonNull g2 g2Var) {
        super(g2Var);
        WindowInsets g4 = g2Var.g();
        this.f4992c = g4 != null ? u1.c(g4) : u1.b();
    }
}