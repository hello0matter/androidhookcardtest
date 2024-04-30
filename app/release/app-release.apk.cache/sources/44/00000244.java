package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final n f1551a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f1552b;

    /* renamed from: c  reason: collision with root package name */
    public final k f1553c;

    public v(d0 d0Var, n nVar, g gVar) {
        this.f1551a = nVar;
        this.f1552b = d0Var;
        this.f1553c = gVar;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z4) {
        w[] wVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (wVarArr = (w[]) editable.getSpans(selectionStart, selectionEnd, w.class)) != null && wVarArr.length > 0) {
            for (w wVar : wVarArr) {
                int spanStart = editable.getSpanStart(wVar);
                int spanEnd = editable.getSpanEnd(wVar);
                if ((z4 && spanStart == selectionStart) || ((!z4 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i4, int i5, t tVar) {
        int i6;
        if (tVar.f1544c == 0) {
            k kVar = this.f1553c;
            r0.a c4 = tVar.c();
            int a5 = c4.a(8);
            if (a5 != 0) {
                c4.f6452b.getShort(a5 + c4.f6451a);
            }
            g gVar = (g) kVar;
            gVar.getClass();
            ThreadLocal threadLocal = g.f1515b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i4 < i5) {
                sb.append(charSequence.charAt(i4));
                i4++;
            }
            TextPaint textPaint = gVar.f1516a;
            String sb2 = sb.toString();
            int i7 = b0.e.f2494a;
            if (b0.d.a(textPaint, sb2)) {
                i6 = 2;
            } else {
                i6 = 1;
            }
            tVar.f1544c = i6;
        }
        if (tVar.f1544c != 2) {
            return false;
        }
        return true;
    }
}