package s0;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.o;

/* loaded from: classes.dex */
public final class d extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f6502a;

    /* renamed from: b  reason: collision with root package name */
    public final l2.f f6503b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        l2.f fVar = new l2.f(11, 0);
        this.f6502a = editText;
        this.f6503b = fVar;
        if (o.f1526j != null) {
            o a5 = o.a();
            if (a5.b() == 1 && editorInfo != null) {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                a5.f1531e.A(editorInfo);
            }
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i4, int i5) {
        Editable editableText = this.f6502a.getEditableText();
        this.f6503b.getClass();
        if (!l2.f.i(this, editableText, i4, i5, false) && !super.deleteSurroundingText(i4, i5)) {
            return false;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i4, int i5) {
        Editable editableText = this.f6502a.getEditableText();
        this.f6503b.getClass();
        if (l2.f.i(this, editableText, i4, i5, true) || super.deleteSurroundingTextInCodePoints(i4, i5)) {
            return true;
        }
        return false;
    }
}