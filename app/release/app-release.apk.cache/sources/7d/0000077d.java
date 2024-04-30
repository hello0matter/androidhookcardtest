package i0;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public final class v0 implements OnReceiveContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final x f4991a;

    public v0(x xVar) {
        this.f4991a = xVar;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        j jVar = new j(new androidx.appcompat.app.o0(contentInfo));
        j a5 = ((androidx.core.widget.w) this.f4991a).a(view, jVar);
        if (a5 == null) {
            return null;
        }
        if (a5 == jVar) {
            return contentInfo;
        }
        ContentInfo j4 = a5.f4942a.j();
        Objects.requireNonNull(j4);
        return f2.h.g(j4);
    }
}