package o2;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class a extends com.google.android.material.tabs.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5970a;

    public a(int i4) {
        this.f5970a = i4;
    }

    @Override // com.google.android.material.tabs.a
    public final void b(TabLayout tabLayout, View view, View view2, float f4, Drawable drawable) {
        float cos;
        float sin;
        float b5;
        switch (this.f5970a) {
            case 0:
                RectF a5 = com.google.android.material.tabs.a.a(tabLayout, view);
                RectF a6 = com.google.android.material.tabs.a.a(tabLayout, view2);
                if (a5.left < a6.left) {
                    double d4 = (f4 * 3.141592653589793d) / 2.0d;
                    sin = (float) (1.0d - Math.cos(d4));
                    cos = (float) Math.sin(d4);
                } else {
                    double d5 = (f4 * 3.141592653589793d) / 2.0d;
                    cos = (float) (1.0d - Math.cos(d5));
                    sin = (float) Math.sin(d5);
                }
                drawable.setBounds(p1.a.c((int) a5.left, sin, (int) a6.left), drawable.getBounds().top, p1.a.c((int) a5.right, cos, (int) a6.right), drawable.getBounds().bottom);
                return;
            default:
                int i4 = (f4 > 0.5f ? 1 : (f4 == 0.5f ? 0 : -1));
                if (i4 >= 0) {
                    view = view2;
                }
                RectF a7 = com.google.android.material.tabs.a.a(tabLayout, view);
                if (i4 < 0) {
                    b5 = p1.a.b(1.0f, 0.0f, 0.0f, 0.5f, f4);
                } else {
                    b5 = p1.a.b(0.0f, 1.0f, 0.5f, 1.0f, f4);
                }
                drawable.setBounds((int) a7.left, drawable.getBounds().top, (int) a7.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (b5 * 255.0f));
                return;
        }
    }
}