package s0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.l;
import androidx.emoji2.text.o;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class e extends l {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f6504a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f6505b;

    public e(TextView textView, f fVar) {
        this.f6504a = new WeakReference(textView);
        this.f6505b = new WeakReference(fVar);
    }

    @Override // androidx.emoji2.text.l
    public final void b() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f6504a.get();
        InputFilter inputFilter = (InputFilter) this.f6505b.get();
        if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (textView.isAttachedToWindow()) {
                        CharSequence text = textView.getText();
                        o a5 = o.a();
                        if (text == null) {
                            length = 0;
                        } else {
                            a5.getClass();
                            length = text.length();
                        }
                        CharSequence f4 = a5.f(0, length, text);
                        if (text == f4) {
                            return;
                        }
                        int selectionStart = Selection.getSelectionStart(f4);
                        int selectionEnd = Selection.getSelectionEnd(f4);
                        textView.setText(f4);
                        if (f4 instanceof Spannable) {
                            Spannable spannable = (Spannable) f4;
                            if (selectionStart >= 0 && selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionStart, selectionEnd);
                                return;
                            } else if (selectionStart >= 0) {
                                Selection.setSelection(spannable, selectionStart);
                                return;
                            } else if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }
}