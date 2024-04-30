package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements g.f0 {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        setLayoutManager(new LinearLayoutManager(1));
    }

    @Override // g.f0
    public final void d(g.p pVar) {
    }
}