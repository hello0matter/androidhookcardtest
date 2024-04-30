package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class m implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f1750a;

    public m(p pVar) {
        this.f1750a = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        p pVar = this.f1750a;
        Dialog dialog = pVar.f1765d0;
        if (dialog != null) {
            pVar.onDismiss(dialog);
        }
    }
}