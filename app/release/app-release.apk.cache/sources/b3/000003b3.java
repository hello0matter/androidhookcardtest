package c1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.example.msphone.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f2681c = 0;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f2682a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2683b;

    public static void a(View view, ArrayList arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        if (this.f2683b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            ViewGroup viewGroup = this.f2682a;
            viewGroup.setTag(R.id.ghost_view_holder, null);
            viewGroup.getOverlay().remove(this);
            this.f2683b = false;
        }
    }
}