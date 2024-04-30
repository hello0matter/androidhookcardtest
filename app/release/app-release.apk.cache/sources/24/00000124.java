package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f723a;

    public c(ActionBarContainer actionBarContainer) {
        this.f723a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f723a;
        if (actionBarContainer.f412h) {
            Drawable drawable = actionBarContainer.f411g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f409e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f410f;
        if (drawable3 == null || !actionBarContainer.f413i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f723a;
        if (actionBarContainer.f412h) {
            if (actionBarContainer.f411g != null) {
                drawable = actionBarContainer.f409e;
            } else {
                return;
            }
        } else {
            drawable = actionBarContainer.f409e;
            if (drawable == null) {
                return;
            }
        }
        drawable.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}