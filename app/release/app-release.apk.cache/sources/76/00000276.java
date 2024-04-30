package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class l implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f1749a;

    public l(p pVar) {
        this.f1749a = pVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        p pVar = this.f1749a;
        Dialog dialog = pVar.f1765d0;
        if (dialog != null) {
            pVar.onCancel(dialog);
        }
    }
}