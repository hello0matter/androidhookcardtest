package v1;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f6967a;

    public g(int i4) {
        this.f6967a = i4;
    }

    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract float b(RecyclerView.LayoutParams layoutParams);

    public abstract RectF c(float f4, float f5, float f6, float f7);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract void j(View view, int i4, int i5);

    public abstract void k(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void l(float f4, float f5, Rect rect, View view);
}