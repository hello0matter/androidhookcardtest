package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f745a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f746b;

    public /* synthetic */ f(ActionBarOverlayLayout actionBarOverlayLayout, int i4) {
        this.f745a = i4;
        this.f746b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f745a;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f746b;
        switch (i4) {
            case 0:
                actionBarOverlayLayout.c();
                actionBarOverlayLayout.f449w = actionBarOverlayLayout.f430d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f450x);
                return;
            default:
                actionBarOverlayLayout.c();
                actionBarOverlayLayout.f449w = actionBarOverlayLayout.f430d.animate().translationY(-actionBarOverlayLayout.f430d.getHeight()).setListener(actionBarOverlayLayout.f450x);
                return;
        }
    }
}