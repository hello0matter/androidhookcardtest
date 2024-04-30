package d1;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class g extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f4268a;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setLevel(i4);
        }
        return super.onLevelChange(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setChangingConfigurations(i4);
        } else {
            super.setChangingConfigurations(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int i4, PorterDuff.Mode mode) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setColorFilter(i4, mode);
        } else {
            super.setColorFilter(i4, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setFilterBitmap(z4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f4, float f5) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.e(drawable, f4, f5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i4, int i5, int i6, int i7) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.f(drawable, i4, i5, i6, i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return super.setState(iArr);
    }
}