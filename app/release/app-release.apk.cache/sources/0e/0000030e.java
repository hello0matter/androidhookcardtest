package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    public int f2197a;

    /* renamed from: b  reason: collision with root package name */
    public int f2198b;

    /* renamed from: c  reason: collision with root package name */
    public int f2199c;

    /* renamed from: d  reason: collision with root package name */
    public int f2200d;

    public final void a(l1 l1Var) {
        View view = l1Var.f2170a;
        this.f2197a = view.getLeft();
        this.f2198b = view.getTop();
        this.f2199c = view.getRight();
        this.f2200d = view.getBottom();
    }
}