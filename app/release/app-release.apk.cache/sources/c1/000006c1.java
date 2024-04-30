package f2;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.r;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public OnBackInvokedCallback f4557a;

    public OnBackInvokedCallback a(b bVar) {
        Objects.requireNonNull(bVar);
        return new r(3, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        r3 = r3.findOnBackInvokedDispatcher();
     */
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(@androidx.annotation.NonNull f2.b r2, @androidx.annotation.NonNull android.view.View r3, boolean r4) {
        /*
            r1 = this;
            android.window.OnBackInvokedCallback r0 = r1.f4557a
            if (r0 == 0) goto L5
            return
        L5:
            android.window.OnBackInvokedDispatcher r3 = androidx.activity.o.d(r3)
            if (r3 != 0) goto Lc
            return
        Lc:
            android.window.OnBackInvokedCallback r2 = r1.a(r2)
            r1.f4557a = r2
            if (r4 == 0) goto L18
            r4 = 1000000(0xf4240, float:1.401298E-39)
            goto L19
        L18:
            r4 = 0
        L19:
            androidx.activity.o.h(r3, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.b(f2.b, android.view.View, boolean):void");
    }

    @DoNotInline
    public void c(@NonNull View view) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher;
        findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
        if (findOnBackInvokedDispatcher != null) {
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f4557a);
            this.f4557a = null;
        }
    }
}