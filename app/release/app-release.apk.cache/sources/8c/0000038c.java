package c1;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class a extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2569a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2570b;

    public a() {
        super(Matrix.class, "imageMatrixProperty");
        this.f2570b = new Matrix();
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f2569a) {
            case 0:
                ((Drawable) obj).copyBounds((Rect) this.f2570b);
                Rect rect = (Rect) this.f2570b;
                return new PointF(rect.left, rect.top);
            case 1:
                ((Matrix) this.f2570b).set(((ImageView) obj).getImageMatrix());
                return (Matrix) this.f2570b;
            default:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                return Float.valueOf(p1.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.F.getColorForState(extendedFloatingActionButton.getDrawableState(), ((d2.a) this.f2570b).f4335b.F.getDefaultColor()))));
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f2569a) {
            case 0:
                Drawable drawable = (Drawable) obj;
                PointF pointF = (PointF) obj2;
                drawable.copyBounds((Rect) this.f2570b);
                ((Rect) this.f2570b).offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds((Rect) this.f2570b);
                return;
            case 1:
                ((ImageView) obj).setImageMatrix((Matrix) obj2);
                return;
            default:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                Float f4 = (Float) obj2;
                int colorForState = extendedFloatingActionButton.F.getColorForState(extendedFloatingActionButton.getDrawableState(), ((d2.a) this.f2570b).f4335b.F.getDefaultColor());
                ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (p1.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f4.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                if (f4.floatValue() == 1.0f) {
                    extendedFloatingActionButton.g(extendedFloatingActionButton.F);
                    return;
                } else {
                    extendedFloatingActionButton.g(valueOf);
                    return;
                }
        }
    }

    public a(int i4) {
        super(PointF.class, "boundsOrigin");
        this.f2570b = new Rect();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d2.a aVar) {
        super(Float.class, "LABEL_OPACITY_PROPERTY");
        this.f2570b = aVar;
    }
}