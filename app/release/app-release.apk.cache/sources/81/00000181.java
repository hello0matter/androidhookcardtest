package androidx.appcompat.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class u extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityChooserView f905a;

    public u(ActivityChooserView activityChooserView) {
        this.f905a = activityChooserView;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        throw null;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        throw null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i4) {
        return 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        ActivityChooserView activityChooserView = this.f905a;
        if (view == null || view.getId() != R.id.list_item) {
            view = LayoutInflater.from(activityChooserView.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
        }
        activityChooserView.getContext().getPackageManager();
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        getItem(i4);
        throw null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }
}