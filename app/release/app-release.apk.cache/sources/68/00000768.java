package i0;

import android.content.ClipData;
import android.view.PointerIcon;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class o0 {
    @DoNotInline
    public static void a(@NonNull View view) {
        view.cancelDragAndDrop();
    }

    @DoNotInline
    public static void b(View view) {
        view.dispatchFinishTemporaryDetach();
    }

    @DoNotInline
    public static void c(View view) {
        view.dispatchStartTemporaryDetach();
    }

    @DoNotInline
    public static void d(@NonNull View view, PointerIcon pointerIcon) {
        view.setPointerIcon(pointerIcon);
    }

    @DoNotInline
    public static boolean e(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i4) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i4);
    }

    @DoNotInline
    public static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
        view.updateDragShadow(dragShadowBuilder);
    }
}