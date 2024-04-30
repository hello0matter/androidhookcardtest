package g;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class u extends FrameLayout implements f.d {

    /* renamed from: a  reason: collision with root package name */
    public final CollapsibleActionView f4751a;

    public u(View view) {
        super(view.getContext());
        this.f4751a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // f.d
    public final void b() {
        this.f4751a.onActionViewExpanded();
    }

    @Override // f.d
    public final void e() {
        this.f4751a.onActionViewCollapsed();
    }
}