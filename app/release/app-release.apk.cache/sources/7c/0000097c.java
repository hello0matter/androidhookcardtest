package s;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

/* loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6485a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageFilterButton f6486b;

    public /* synthetic */ a(ImageFilterButton imageFilterButton, int i4) {
        this.f6485a = i4;
        this.f6486b = imageFilterButton;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int i4 = this.f6485a;
        ImageFilterButton imageFilterButton = this.f6486b;
        switch (i4) {
            case 0:
                int width = imageFilterButton.getWidth();
                int height = imageFilterButton.getHeight();
                outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * imageFilterButton.f1176f) / 2.0f);
                return;
            default:
                outline.setRoundRect(0, 0, imageFilterButton.getWidth(), imageFilterButton.getHeight(), imageFilterButton.f1177g);
                return;
        }
    }
}