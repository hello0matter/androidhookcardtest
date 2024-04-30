package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

/* loaded from: classes.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f196a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f198c;

    public /* synthetic */ d(int i4, Object obj, Object obj2) {
        this.f196a = i4;
        this.f198c = obj;
        this.f197b = obj2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        int i5 = this.f196a;
        Object obj = this.f198c;
        switch (i5) {
            case 0:
                e eVar = (e) obj;
                DialogInterface.OnClickListener onClickListener = eVar.f206h;
                h hVar = (h) this.f197b;
                onClickListener.onClick(hVar.f256b, i4);
                if (!eVar.f207i) {
                    hVar.f256b.dismiss();
                    return;
                }
                return;
            default:
                androidx.appcompat.widget.o0 o0Var = (androidx.appcompat.widget.o0) obj;
                o0Var.G.setSelection(i4);
                AppCompatSpinner appCompatSpinner = o0Var.G;
                if (appCompatSpinner.getOnItemClickListener() != null) {
                    appCompatSpinner.performItemClick(view, i4, o0Var.D.getItemId(i4));
                }
                o0Var.dismiss();
                return;
        }
    }
}