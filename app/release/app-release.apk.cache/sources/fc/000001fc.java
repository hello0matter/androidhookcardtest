package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f1393c = 0;

    /* renamed from: a  reason: collision with root package name */
    public final d f1394a;

    /* renamed from: b  reason: collision with root package name */
    public final d f1395b;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f1394a);
        removeCallbacks(this.f1395b);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1394a);
        removeCallbacks(this.f1395b);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.core.widget.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.core.widget.d] */
    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1394a = new Runnable(this) { // from class: androidx.core.widget.d

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ContentLoadingProgressBar f1433b;

            {
                this.f1433b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i4 = r2;
                ContentLoadingProgressBar contentLoadingProgressBar = this.f1433b;
                switch (i4) {
                    case 0:
                        int i5 = ContentLoadingProgressBar.f1393c;
                        contentLoadingProgressBar.setVisibility(8);
                        return;
                    default:
                        int i6 = ContentLoadingProgressBar.f1393c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        return;
                }
            }
        };
        this.f1395b = new Runnable(this) { // from class: androidx.core.widget.d

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ContentLoadingProgressBar f1433b;

            {
                this.f1433b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i4 = r2;
                ContentLoadingProgressBar contentLoadingProgressBar = this.f1433b;
                switch (i4) {
                    case 0:
                        int i5 = ContentLoadingProgressBar.f1393c;
                        contentLoadingProgressBar.setVisibility(8);
                        return;
                    default:
                        int i6 = ContentLoadingProgressBar.f1393c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        return;
                }
            }
        };
    }
}