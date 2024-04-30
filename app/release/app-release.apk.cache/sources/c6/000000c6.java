package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final e f281a;

    /* renamed from: b  reason: collision with root package name */
    public final int f282b;

    public i(Context context) {
        int g4 = j.g(context, 0);
        this.f281a = new e(new ContextThemeWrapper(context, j.g(context, g4)));
        this.f282b = g4;
    }

    public final j a() {
        int i4;
        e eVar = this.f281a;
        j jVar = new j(eVar.f199a, this.f282b);
        View view = eVar.f203e;
        h hVar = jVar.f287f;
        if (view != null) {
            hVar.f269o = view;
        } else {
            CharSequence charSequence = eVar.f202d;
            if (charSequence != null) {
                hVar.f258d = charSequence;
                TextView textView = hVar.f267m;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = eVar.f201c;
            if (drawable != null) {
                hVar.f265k = drawable;
                hVar.f264j = 0;
                ImageView imageView = hVar.f266l;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    hVar.f266l.setImageDrawable(drawable);
                }
            }
        }
        if (eVar.f205g != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) eVar.f200b.inflate(hVar.f273s, (ViewGroup) null);
            if (eVar.f207i) {
                i4 = hVar.f274t;
            } else {
                i4 = hVar.f275u;
            }
            ListAdapter listAdapter = eVar.f205g;
            if (listAdapter == null) {
                listAdapter = new ArrayAdapter(eVar.f199a, i4, 16908308, (Object[]) null);
            }
            hVar.f270p = listAdapter;
            hVar.f271q = eVar.f208j;
            if (eVar.f206h != null) {
                alertController$RecycleListView.setOnItemClickListener(new d(0, eVar, hVar));
            }
            if (eVar.f207i) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            hVar.f259e = alertController$RecycleListView;
        }
        jVar.setCancelable(true);
        jVar.setCanceledOnTouchOutside(true);
        jVar.setOnCancelListener(null);
        jVar.setOnDismissListener(null);
        DialogInterface.OnKeyListener onKeyListener = eVar.f204f;
        if (onKeyListener != null) {
            jVar.setOnKeyListener(onKeyListener);
        }
        return jVar;
    }
}