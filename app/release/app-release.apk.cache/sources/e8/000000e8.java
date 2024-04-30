package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.q3;
import g.f0;
import g.o;
import g.p;
import g.r;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements o, f0, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f386b = {16842964, 16843049};

    /* renamed from: a  reason: collision with root package name */
    public p f387a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // g.o
    public final boolean a(r rVar) {
        return this.f387a.q(rVar, null, 0);
    }

    @Override // g.f0
    public final void d(p pVar) {
        this.f387a = pVar;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        a((r) getAdapter().getItem(i4));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        q3 f4 = q3.f(context, attributeSet, f386b, i4, 0);
        TypedArray typedArray = f4.f879b;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(f4.b(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(f4.b(1));
        }
        f4.g();
    }
}