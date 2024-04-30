package d1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class n extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f4312a;

    /* renamed from: b  reason: collision with root package name */
    public m f4313b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f4314c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f4315d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4316e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f4317f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f4318g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f4319h;

    /* renamed from: i  reason: collision with root package name */
    public int f4320i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4321j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4322k;

    /* renamed from: l  reason: collision with root package name */
    public Paint f4323l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f4312a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new p(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new p(this);
    }
}