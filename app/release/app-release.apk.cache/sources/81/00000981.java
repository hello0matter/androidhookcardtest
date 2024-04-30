package s0;

import android.text.Editable;
import androidx.emoji2.text.f0;

/* loaded from: classes.dex */
public final class c extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6499a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f6500b;

    /* renamed from: c  reason: collision with root package name */
    public static Class f6501c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f6501c;
        if (cls != null) {
            return new f0(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}