package com.google.android.material.navigation;

import android.content.Context;
import android.view.SubMenu;
import g.p;
import g.r;

/* loaded from: classes.dex */
public final class e extends p {
    public final int A;

    /* renamed from: z  reason: collision with root package name */
    public final Class f3694z;

    public e(Context context, Class cls, int i4) {
        super(context);
        this.f3694z = cls;
        this.A = i4;
    }

    @Override // g.p
    public final r a(int i4, int i5, int i6, CharSequence charSequence) {
        int size = this.f4700f.size() + 1;
        int i7 = this.A;
        if (size <= i7) {
            y();
            r a5 = super.a(i4, i5, i6, charSequence);
            a5.g(true);
            x();
            return a5;
        }
        String simpleName = this.f3694z.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i7);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(androidx.activity.j.e(sb, simpleName, "#getMaxItemCount()"));
    }

    @Override // g.p, android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f3694z.getSimpleName().concat(" does not support submenus"));
    }
}