package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Region;
import android.os.Build;

/* loaded from: classes.dex */
public final class f extends g {
    @Override // l2.j
    public final void g(Canvas canvas) {
        if (this.f4030x.f4028v.isEmpty()) {
            super.g(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.f4030x.f4028v);
        } else {
            canvas.clipRect(this.f4030x.f4028v, Region.Op.DIFFERENCE);
        }
        super.g(canvas);
        canvas.restore();
    }
}