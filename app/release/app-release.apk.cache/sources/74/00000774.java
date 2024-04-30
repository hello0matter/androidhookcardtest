package i0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s0 {
    @DoNotInline
    public static View.AccessibilityDelegate a(View view) {
        return view.getAccessibilityDelegate();
    }

    @DoNotInline
    public static List<Rect> b(View view) {
        return view.getSystemGestureExclusionRects();
    }

    @DoNotInline
    public static void c(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i4, int i5) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i4, i5);
    }

    @DoNotInline
    public static void d(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}