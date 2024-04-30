package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class i {
    @DoNotInline
    public static boolean a(ListView listView, int i4) {
        return listView.canScrollList(i4);
    }

    @DoNotInline
    public static void b(ListView listView, int i4) {
        listView.scrollListBy(i4);
    }
}