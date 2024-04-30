package i0;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class p0 {
    @DoNotInline
    public static void a(@NonNull View view, Collection<View> collection, int i4) {
        view.addKeyboardNavigationClusters(collection, i4);
    }

    @DoNotInline
    public static int b(View view) {
        return view.getImportantForAutofill();
    }

    @DoNotInline
    public static int c(@NonNull View view) {
        return view.getNextClusterForwardId();
    }

    @DoNotInline
    public static boolean d(@NonNull View view) {
        return view.hasExplicitFocusable();
    }

    @DoNotInline
    public static boolean e(@NonNull View view) {
        return view.isFocusedByDefault();
    }

    @DoNotInline
    public static boolean f(View view) {
        return view.isImportantForAutofill();
    }

    @DoNotInline
    public static boolean g(@NonNull View view) {
        return view.isKeyboardNavigationCluster();
    }

    @DoNotInline
    public static View h(@NonNull View view, View view2, int i4) {
        return view.keyboardNavigationClusterSearch(view2, i4);
    }

    @DoNotInline
    public static boolean i(@NonNull View view) {
        return view.restoreDefaultFocus();
    }

    @DoNotInline
    public static void j(@NonNull View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    @DoNotInline
    public static void k(@NonNull View view, boolean z4) {
        view.setFocusedByDefault(z4);
    }

    @DoNotInline
    public static void l(View view, int i4) {
        view.setImportantForAutofill(i4);
    }

    @DoNotInline
    public static void m(@NonNull View view, boolean z4) {
        view.setKeyboardNavigationCluster(z4);
    }

    @DoNotInline
    public static void n(View view, int i4) {
        view.setNextClusterForwardId(i4);
    }

    @DoNotInline
    public static void o(@NonNull View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}