package e2;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import l2.j;

/* loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f4441a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f4442b;

    public a(ShapeableImageView shapeableImageView) {
        this.f4442b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f4442b;
        if (shapeableImageView.f3427l == null) {
            return;
        }
        if (shapeableImageView.f3426k == null) {
            shapeableImageView.f3426k = new j(shapeableImageView.f3427l);
        }
        RectF rectF = shapeableImageView.f3420e;
        Rect rect = this.f4441a;
        rectF.round(rect);
        shapeableImageView.f3426k.setBounds(rect);
        shapeableImageView.f3426k.getOutline(outline);
    }
}