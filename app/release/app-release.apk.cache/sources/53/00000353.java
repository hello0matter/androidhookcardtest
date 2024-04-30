package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class b implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        boolean z4 = ((ViewPager.LayoutParams) ((View) obj).getLayoutParams()).f2429a;
        if (z4 != ((ViewPager.LayoutParams) ((View) obj2).getLayoutParams()).f2429a) {
            if (z4) {
                return 1;
            }
            return -1;
        }
        return 0;
    }
}