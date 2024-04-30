package r2;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f6460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6461b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c2.a f6462c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExpandableBehavior f6463d;

    public a(ExpandableBehavior expandableBehavior, View view, int i4, c2.a aVar) {
        this.f6463d = expandableBehavior;
        this.f6460a = view;
        this.f6461b = i4;
        this.f6462c = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.f6460a;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f6463d;
        if (expandableBehavior.f4164a == this.f6461b) {
            c2.a aVar = this.f6462c;
            expandableBehavior.w((View) aVar, view, ((FloatingActionButton) aVar).f3415o.f4760a, false);
        }
        return false;
    }
}