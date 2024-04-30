package s;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/* loaded from: classes.dex */
public final class b extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6487a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageFilterView f6488b;

    public /* synthetic */ b(ImageFilterView imageFilterView, int i4) {
        this.f6487a = i4;
        this.f6488b = imageFilterView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int i4 = this.f6487a;
        ImageFilterView imageFilterView = this.f6488b;
        switch (i4) {
            case 0:
                int width = imageFilterView.getWidth();
                int height = imageFilterView.getHeight();
                outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * imageFilterView.f1187g) / 2.0f);
                return;
            default:
                outline.setRoundRect(0, 0, imageFilterView.getWidth(), imageFilterView.getHeight(), imageFilterView.f1188h);
                return;
        }
    }
}