package p0;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        boolean z4;
        DrawerLayout drawerLayout = (DrawerLayout) view;
        if (windowInsets.getSystemWindowInsetTop() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        drawerLayout.setChildInsets(windowInsets, z4);
        return windowInsets.consumeSystemWindowInsets();
    }
}