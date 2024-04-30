package h2;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.progressindicator.BaseProgressIndicator;

/* loaded from: classes.dex */
public final class c extends d1.c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4817b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f4818c;

    public c(int i4, View view) {
        this.f4817b = i4;
        this.f4818c = view;
    }

    @Override // d1.c
    public final void a(Drawable drawable) {
        int i4 = this.f4817b;
        View view = this.f4818c;
        switch (i4) {
            case 0:
                BaseProgressIndicator baseProgressIndicator = (BaseProgressIndicator) view;
                baseProgressIndicator.setIndeterminate(false);
                baseProgressIndicator.setProgressCompat(baseProgressIndicator.f3706b, baseProgressIndicator.f3707c);
                return;
            case 1:
                BaseProgressIndicator baseProgressIndicator2 = (BaseProgressIndicator) view;
                if (!baseProgressIndicator2.f3711g) {
                    baseProgressIndicator2.setVisibility(baseProgressIndicator2.f3712h);
                    return;
                }
                return;
            default:
                ColorStateList colorStateList = ((MaterialCheckBox) view).f3201o;
                if (colorStateList != null) {
                    c0.b.h(drawable, colorStateList);
                    return;
                }
                return;
        }
    }

    @Override // d1.c
    public final void b(Drawable drawable) {
        switch (this.f4817b) {
            case 2:
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) this.f4818c;
                ColorStateList colorStateList = materialCheckBox.f3201o;
                if (colorStateList != null) {
                    c0.b.g(drawable, colorStateList.getColorForState(materialCheckBox.f3205s, colorStateList.getDefaultColor()));
                    return;
                }
                return;
            default:
                return;
        }
    }
}