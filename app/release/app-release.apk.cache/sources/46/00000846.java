package l0;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.appcompat.app.o0;

/* loaded from: classes.dex */
public final class e extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f5260a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InputConnection inputConnection, d dVar) {
        super(inputConnection, false);
        this.f5260a = dVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i4, Bundle bundle) {
        o0 o0Var = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            o0Var = new o0(13, new g(inputContentInfo));
        }
        if (this.f5260a.a(o0Var, i4, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i4, bundle);
    }
}