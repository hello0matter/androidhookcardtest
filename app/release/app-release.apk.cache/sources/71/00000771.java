package i0;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import com.example.msphone.R;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class r0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View$OnUnhandledKeyEventListener, java.lang.Object] */
    @DoNotInline
    public static void a(@NonNull View view, @NonNull w0 w0Var) {
        l.k kVar = (l.k) view.getTag(R.id.tag_unhandled_key_listeners);
        l.k kVar2 = kVar;
        if (kVar == null) {
            l.k kVar3 = new l.k();
            view.setTag(R.id.tag_unhandled_key_listeners, kVar3);
            kVar2 = kVar3;
        }
        Objects.requireNonNull(w0Var);
        ?? obj = new Object();
        kVar2.put(w0Var, obj);
        view.addOnUnhandledKeyEventListener(obj);
    }

    @DoNotInline
    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @DoNotInline
    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    @DoNotInline
    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    @DoNotInline
    public static void e(@NonNull View view, @NonNull w0 w0Var) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        l.k kVar = (l.k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) kVar.getOrDefault(w0Var, null)) != null) {
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }
    }

    @DoNotInline
    public static <T> T f(View view, int i4) {
        return (T) view.requireViewById(i4);
    }

    @DoNotInline
    public static void g(View view, boolean z4) {
        view.setAccessibilityHeading(z4);
    }

    @DoNotInline
    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    @DoNotInline
    public static void i(View view, boolean z4) {
        view.setScreenReaderFocusable(z4);
    }
}