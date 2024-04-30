package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class v implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityChooserView f922a;

    public v(ActivityChooserView activityChooserView) {
        this.f922a = activityChooserView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityChooserView activityChooserView = this.f922a;
        FrameLayout frameLayout = activityChooserView.f476f;
        u uVar = activityChooserView.f471a;
        if (view != frameLayout) {
            if (view == activityChooserView.f474d) {
                uVar.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
            }
            throw new IllegalArgumentException();
        }
        activityChooserView.a();
        uVar.getClass();
        throw null;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        i0.d dVar;
        ActivityChooserView activityChooserView = this.f922a;
        PopupWindow.OnDismissListener onDismissListener = activityChooserView.f480j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        i0.e eVar = activityChooserView.f477g;
        if (eVar != null && (dVar = eVar.f4919a) != null) {
            ((n) dVar).n(false);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        ((u) adapterView.getAdapter()).getClass();
        ActivityChooserView activityChooserView = this.f922a;
        activityChooserView.a();
        activityChooserView.f471a.getClass();
        throw null;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ActivityChooserView activityChooserView = this.f922a;
        if (view == activityChooserView.f476f) {
            activityChooserView.f471a.getClass();
            throw null;
        }
        throw new IllegalArgumentException();
    }
}