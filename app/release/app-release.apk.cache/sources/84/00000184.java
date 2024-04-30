package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class u2 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f918a;

    public u2(SearchView searchView) {
        this.f918a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        SearchView searchView = this.f918a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.K;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z4);
        }
    }
}