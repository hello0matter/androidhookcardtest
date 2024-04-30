package h2;

import android.os.SystemClock;
import com.google.android.material.progressindicator.BaseProgressIndicator;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseProgressIndicator f4816b;

    public /* synthetic */ b(BaseProgressIndicator baseProgressIndicator, int i4) {
        this.f4815a = i4;
        this.f4816b = baseProgressIndicator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f4815a;
        BaseProgressIndicator baseProgressIndicator = this.f4816b;
        switch (i4) {
            case 0:
                int i5 = BaseProgressIndicator.f3704m;
                if (baseProgressIndicator.f3709e > 0) {
                    SystemClock.uptimeMillis();
                }
                baseProgressIndicator.setVisibility(0);
                return;
            default:
                int i6 = BaseProgressIndicator.f3704m;
                ((k) baseProgressIndicator.getCurrentDrawable()).e(false, false, true);
                if (baseProgressIndicator.getProgressDrawable() == null || !baseProgressIndicator.getProgressDrawable().isVisible()) {
                    if (baseProgressIndicator.getIndeterminateDrawable() == null || !baseProgressIndicator.getIndeterminateDrawable().isVisible()) {
                        baseProgressIndicator.setVisibility(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}