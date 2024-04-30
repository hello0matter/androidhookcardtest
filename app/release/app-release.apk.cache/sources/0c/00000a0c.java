package w1;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import l2.c0;
import l2.d0;

/* loaded from: classes.dex */
public final class c extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7023a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f7024b;

    public /* synthetic */ c(int i4, Object obj) {
        this.f7023a = i4;
        this.f7024b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int i4 = this.f7023a;
        Object obj = this.f7024b;
        switch (i4) {
            case 0:
                f fVar = ((Chip) obj).f3215e;
                if (fVar != null) {
                    fVar.getOutline(outline);
                    return;
                } else {
                    outline.setAlpha(0.0f);
                    return;
                }
            case 1:
                c0 c0Var = (c0) obj;
                if (c0Var.f5278c != null && !c0Var.f5279d.isEmpty()) {
                    RectF rectF = c0Var.f5279d;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, c0Var.f5283g);
                    return;
                }
                return;
            default:
                d0 d0Var = (d0) obj;
                if (!d0Var.f5280e.isEmpty()) {
                    outline.setPath(d0Var.f5280e);
                    return;
                }
                return;
        }
    }
}