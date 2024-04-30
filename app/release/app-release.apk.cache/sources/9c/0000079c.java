package j0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final int f5073a;

    /* renamed from: b  reason: collision with root package name */
    public final h f5074b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5075c;

    public a(int i4, h hVar, int i5) {
        this.f5073a = i4;
        this.f5074b = hVar;
        this.f5075c = i5;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f5073a);
        this.f5074b.f5093a.performAction(this.f5075c, bundle);
    }
}