package androidx.appcompat.widget;

import android.graphics.Canvas;

/* loaded from: classes.dex */
public final class s1 extends d.c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f893b;

    @Override // d.c, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f893b) {
            super.draw(canvas);
        }
    }

    @Override // d.c, android.graphics.drawable.Drawable
    public final void setHotspot(float f4, float f5) {
        if (this.f893b) {
            super.setHotspot(f4, f5);
        }
    }

    @Override // d.c, android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i4, int i5, int i6, int i7) {
        if (this.f893b) {
            super.setHotspotBounds(i4, i5, i6, i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (this.f893b) {
            return this.f4236a.setState(iArr);
        }
        return false;
    }

    @Override // d.c, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        if (this.f893b) {
            return super.setVisible(z4, z5);
        }
        return false;
    }
}