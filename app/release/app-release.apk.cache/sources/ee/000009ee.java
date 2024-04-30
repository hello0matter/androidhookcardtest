package v1;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q0;
import com.example.msphone.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends q0 {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f6963a;

    /* renamed from: b  reason: collision with root package name */
    public List f6964b;

    public d() {
        Paint paint = new Paint();
        this.f6963a = paint;
        this.f6964b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.q0
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        float f4;
        float g4;
        float f5;
        Canvas canvas2;
        float f6;
        Paint paint = this.f6963a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (i iVar : this.f6964b) {
            paint.setColor(b0.a.b(-65281, iVar.f6977c, -16776961));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).K0()) {
                f6 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3182y.i();
                f5 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3182y.d();
                g4 = iVar.f6976b;
                canvas2 = canvas;
                f4 = g4;
            } else {
                f4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3182y.f();
                g4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3182y.g();
                f5 = iVar.f6976b;
                canvas2 = canvas;
                f6 = f5;
            }
            canvas2.drawLine(f4, f6, g4, f5, paint);
        }
    }
}