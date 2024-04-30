package i0;

import android.view.ContentInfo;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class u0 {
    @Nullable
    @DoNotInline
    public static String[] a(@NonNull View view) {
        return view.getReceiveContentMimeTypes();
    }

    @Nullable
    @DoNotInline
    public static j b(@NonNull View view, @NonNull j jVar) {
        ContentInfo j4 = jVar.f4942a.j();
        Objects.requireNonNull(j4);
        ContentInfo g4 = f2.h.g(j4);
        ContentInfo performReceiveContent = view.performReceiveContent(g4);
        if (performReceiveContent == null) {
            return null;
        }
        if (performReceiveContent == g4) {
            return jVar;
        }
        return new j(new androidx.appcompat.app.o0(performReceiveContent));
    }

    @DoNotInline
    public static void c(@NonNull View view, @Nullable String[] strArr, @Nullable x xVar) {
        if (xVar == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new v0(xVar));
        }
    }
}