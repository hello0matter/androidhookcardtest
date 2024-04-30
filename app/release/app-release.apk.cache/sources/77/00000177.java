package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
public final class s extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActivityChooserView f888b;

    public /* synthetic */ s(ActivityChooserView activityChooserView, int i4) {
        this.f887a = i4;
        this.f888b = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        int i4 = this.f887a;
        ActivityChooserView activityChooserView = this.f888b;
        switch (i4) {
            case 0:
                super.onChanged();
                activityChooserView.f471a.notifyDataSetChanged();
                return;
            default:
                super.onChanged();
                activityChooserView.f471a.getClass();
                throw null;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f887a) {
            case 0:
                super.onInvalidated();
                this.f888b.f471a.notifyDataSetInvalidated();
                return;
            default:
                super.onInvalidated();
                return;
        }
    }
}