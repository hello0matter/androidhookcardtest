package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: classes.dex */
public final class c0 implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    public final k0 f1668a;

    public c0(k0 k0Var) {
        this.f1668a = k0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0248  */
    /* JADX WARN: Type inference failed for: r1v16, types: [android.widget.FrameLayout, android.view.View, androidx.fragment.app.FragmentContainerView, android.view.ViewGroup] */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onCreateView(android.view.View r18, java.lang.String r19, android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}