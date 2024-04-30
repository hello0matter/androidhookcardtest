package s0;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.o;

/* loaded from: classes.dex */
public final class f implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f6506a;

    /* renamed from: b  reason: collision with root package name */
    public e f6507b;

    public f(TextView textView) {
        this.f6506a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i4, int i5, Spanned spanned, int i6, int i7) {
        TextView textView = this.f6506a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b5 = o.a().b();
        if (b5 != 0) {
            if (b5 != 1) {
                if (b5 != 3) {
                    return charSequence;
                }
            } else if ((i7 != 0 || i6 != 0 || spanned.length() != 0 || charSequence != textView.getText()) && charSequence != null) {
                if (i4 != 0 || i5 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i4, i5);
                }
                return o.a().f(0, charSequence.length(), charSequence);
            } else {
                return charSequence;
            }
        }
        o a5 = o.a();
        if (this.f6507b == null) {
            this.f6507b = new e(textView, this);
        }
        a5.g(this.f6507b);
        return charSequence;
    }
}