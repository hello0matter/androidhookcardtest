package androidx.appcompat.widget;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class l3 extends androidx.emoji2.text.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f813a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f814b;

    public l3(EditText editText) {
        this.f814b = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.l
    public final void a() {
        switch (this.f813a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f814b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.emoji2.text.l
    public final void b() {
        WeakReference weakReference = this.f814b;
        switch (this.f813a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) weakReference.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    return;
                }
                return;
            default:
                s0.j.a((EditText) weakReference.get(), 1);
                return;
        }
    }

    public l3(SwitchCompat switchCompat) {
        this.f814b = new WeakReference(switchCompat);
    }
}