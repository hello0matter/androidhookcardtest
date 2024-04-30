package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4);
        a(context, attributeSet, i4, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i4, int i5) {
        q3 f4 = q3.f(context, attributeSet, c.a.f2563u, i4, i5);
        TypedArray typedArray = f4.f879b;
        if (typedArray.hasValue(2)) {
            androidx.core.widget.o.c(this, typedArray.getBoolean(2, false));
        }
        setBackgroundDrawable(f4.b(0));
        f4.g();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i4, int i5) {
        super.showAsDropDown(view, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public final void update(View view, int i4, int i5, int i6, int i7) {
        super.update(view, i4, i5, i6, i7);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i4, int i5, int i6) {
        super.showAsDropDown(view, i4, i5, i6);
    }
}