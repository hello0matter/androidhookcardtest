package f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f4443a;

    /* JADX WARN: Type inference failed for: r0v0, types: [f.a, java.lang.Object] */
    public static a a(Context context) {
        ?? obj = new Object();
        obj.f4443a = context;
        return obj;
    }

    public final int b() {
        Configuration configuration = this.f4443a.getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i4 <= 600) {
            if (i4 <= 960 || i5 <= 720) {
                if (i4 <= 720 || i5 <= 960) {
                    if (i4 < 500) {
                        if (i4 <= 640 || i5 <= 480) {
                            if (i4 <= 480 || i5 <= 640) {
                                if (i4 >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return 5;
    }

    public final int c() {
        int[] iArr = c.a.f2543a;
        Context context = this.f4443a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
        Resources resources = context.getResources();
        if (!this.f4443a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }
}