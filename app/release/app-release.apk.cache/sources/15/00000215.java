package androidx.core.widget;

import android.graphics.Paint;
import android.os.Build;
import android.view.ActionMode;
import android.widget.TextView;

/* loaded from: classes.dex */
public abstract class v {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r8 != 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r6 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static g0.e a(android.widget.TextView r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L10
            g0.e r0 = new g0.e
            android.text.PrecomputedText$Params r8 = androidx.core.widget.t.b(r8)
            r0.<init>(r8)
            return r0
        L10:
            android.text.TextPaint r2 = new android.text.TextPaint
            android.text.TextPaint r3 = r8.getPaint()
            r2.<init>(r3)
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            int r4 = androidx.core.widget.r.a(r8)
            int r5 = androidx.core.widget.r.d(r8)
            android.text.method.TransformationMethod r6 = r8.getTransformationMethod()
            boolean r6 = r6 instanceof android.text.method.PasswordTransformationMethod
            if (r6 == 0) goto L2e
        L2b:
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.LTR
            goto L72
        L2e:
            r6 = 1
            r7 = 0
            if (r0 < r1) goto L59
            int r0 = r8.getInputType()
            r0 = r0 & 15
            r1 = 3
            if (r0 != r1) goto L59
            java.util.Locale r8 = androidx.core.widget.q.d(r8)
            android.icu.text.DecimalFormatSymbols r8 = androidx.core.widget.s.a(r8)
            java.lang.String[] r8 = androidx.core.widget.t.a(r8)
            r8 = r8[r7]
            int r8 = r8.codePointAt(r7)
            byte r8 = java.lang.Character.getDirectionality(r8)
            if (r8 == r6) goto L56
            r0 = 2
            if (r8 != r0) goto L2b
        L56:
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.RTL
            goto L72
        L59:
            int r0 = androidx.core.widget.q.b(r8)
            if (r0 != r6) goto L60
            goto L61
        L60:
            r6 = r7
        L61:
            int r8 = androidx.core.widget.q.c(r8)
            switch(r8) {
                case 2: goto L70;
                case 3: goto L2b;
                case 4: goto L56;
                case 5: goto L6d;
                case 6: goto L72;
                case 7: goto L6a;
                default: goto L68;
            }
        L68:
            if (r6 == 0) goto L72
        L6a:
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL
            goto L72
        L6d:
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.LOCALE
            goto L72
        L70:
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.ANYRTL_LTR
        L72:
            g0.e r8 = new g0.e
            android.text.TextDirectionHeuristic r3 = (android.text.TextDirectionHeuristic) r3
            r8.<init>(r2, r3, r4, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.v.a(android.widget.TextView):g0.e");
    }

    public static void b(TextView textView, int i4) {
        h0.e.b(i4);
        if (Build.VERSION.SDK_INT >= 28) {
            t.c(textView, i4);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i5 = p.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i4 > Math.abs(i5)) {
            textView.setPadding(textView.getPaddingLeft(), i4 + i5, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void c(TextView textView, int i4) {
        h0.e.b(i4);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i5 = p.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i4 > Math.abs(i5)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i4 - i5);
        }
    }

    public static ActionMode.Callback d(ActionMode.Callback callback) {
        if ((callback instanceof u) && Build.VERSION.SDK_INT >= 26) {
            return ((u) callback).f1453a;
        }
        return callback;
    }

    public static ActionMode.Callback e(ActionMode.Callback callback, TextView textView) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26 && i4 <= 27 && !(callback instanceof u) && callback != null) {
            return new u(callback, textView);
        }
        return callback;
    }
}