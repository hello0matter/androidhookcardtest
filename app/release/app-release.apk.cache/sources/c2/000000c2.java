package androidx.appcompat.app;

import android.widget.ArrayAdapter;

/* loaded from: classes.dex */
public final class g extends ArrayAdapter {
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}