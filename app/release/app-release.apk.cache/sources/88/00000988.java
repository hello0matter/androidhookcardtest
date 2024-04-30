package s0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.l3;
import androidx.emoji2.text.o;

/* loaded from: classes.dex */
public final class j implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f6514a;

    /* renamed from: c  reason: collision with root package name */
    public l3 f6516c;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6515b = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6517d = true;

    public j(EditText editText) {
        this.f6514a = editText;
    }

    public static void a(EditText editText, int i4) {
        int length;
        if (i4 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            o a5 = o.a();
            if (editableText == null) {
                length = 0;
            } else {
                a5.getClass();
                length = editableText.length();
            }
            a5.f(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        EditText editText = this.f6514a;
        if (!editText.isInEditMode() && this.f6517d) {
            if ((this.f6515b || o.f1526j != null) && i5 <= i6 && (charSequence instanceof Spannable)) {
                int b5 = o.a().b();
                if (b5 != 0) {
                    if (b5 != 1) {
                        if (b5 != 3) {
                            return;
                        }
                    } else {
                        o.a().f(i4, i6 + i4, (Spannable) charSequence);
                        return;
                    }
                }
                o a5 = o.a();
                if (this.f6516c == null) {
                    this.f6516c = new l3(editText);
                }
                a5.g(this.f6516c);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}