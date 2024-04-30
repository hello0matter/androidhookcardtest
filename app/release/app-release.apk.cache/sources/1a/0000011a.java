package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class a1 extends androidx.appcompat.app.o0 {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AppCompatTextView f694e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(AppCompatTextView appCompatTextView) {
        super(6, appCompatTextView);
        this.f694e = appCompatTextView;
    }

    @Override // androidx.appcompat.app.o0, androidx.appcompat.widget.z0
    public final void n(int i4) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i4);
    }

    @Override // androidx.appcompat.app.o0, androidx.appcompat.widget.z0
    public final void o(int i4) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i4);
    }
}