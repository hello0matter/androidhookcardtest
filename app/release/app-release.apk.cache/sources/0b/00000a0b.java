package w1;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.c0;
import com.google.android.material.internal.d0;

/* loaded from: classes.dex */
public final class b extends i2.h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7021a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f7022b;

    public b(int i4, Object obj) {
        this.f7021a = i4;
        this.f7022b = obj;
    }

    @Override // i2.h
    public final void a(int i4) {
        switch (this.f7021a) {
            case 0:
                return;
            default:
                d0 d0Var = (d0) this.f7022b;
                d0Var.f3538e = true;
                c0 c0Var = (c0) d0Var.f3539f.get();
                if (c0Var != null) {
                    c0Var.a();
                    return;
                }
                return;
        }
    }

    @Override // i2.h
    public final void b(Typeface typeface, boolean z4) {
        CharSequence text;
        int i4 = this.f7021a;
        Object obj = this.f7022b;
        switch (i4) {
            case 0:
                Chip chip = (Chip) obj;
                f fVar = chip.f3215e;
                if (fVar.D0) {
                    text = fVar.E;
                } else {
                    text = chip.getText();
                }
                chip.setText(text);
                chip.requestLayout();
                chip.invalidate();
                return;
            default:
                if (!z4) {
                    d0 d0Var = (d0) obj;
                    d0Var.f3538e = true;
                    c0 c0Var = (c0) d0Var.f3539f.get();
                    if (c0Var != null) {
                        c0Var.a();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}