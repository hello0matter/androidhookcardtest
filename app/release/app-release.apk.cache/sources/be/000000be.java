package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f199a;

    /* renamed from: b  reason: collision with root package name */
    public final LayoutInflater f200b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f201c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f202d;

    /* renamed from: e  reason: collision with root package name */
    public View f203e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnKeyListener f204f;

    /* renamed from: g  reason: collision with root package name */
    public ListAdapter f205g;

    /* renamed from: h  reason: collision with root package name */
    public DialogInterface.OnClickListener f206h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f207i;

    /* renamed from: j  reason: collision with root package name */
    public int f208j = -1;

    public e(ContextThemeWrapper contextThemeWrapper) {
        this.f199a = contextThemeWrapper;
        this.f200b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
    }
}