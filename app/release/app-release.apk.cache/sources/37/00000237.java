package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class i0 implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1520a = false;

    /* renamed from: b  reason: collision with root package name */
    public Spannable f1521b;

    public i0(Spannable spannable) {
        this.f1521b = spannable;
    }

    public final void a() {
        l2.f fVar;
        Spannable spannable = this.f1521b;
        if (!this.f1520a) {
            if (Build.VERSION.SDK_INT < 28) {
                fVar = new l2.f(8, 0);
            } else {
                fVar = new l2.f(8, 0);
            }
            if (fVar.n(spannable)) {
                this.f1521b = new SpannableString(spannable);
            }
        }
        this.f1520a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i4) {
        return this.f1521b.charAt(i4);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f1521b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f1521b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f1521b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f1521b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f1521b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i4, int i5, Class cls) {
        return this.f1521b.getSpans(i4, i5, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1521b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i4, int i5, Class cls) {
        return this.f1521b.nextSpanTransition(i4, i5, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f1521b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i4, int i5, int i6) {
        a();
        this.f1521b.setSpan(obj, i4, i5, i6);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i4, int i5) {
        return this.f1521b.subSequence(i4, i5);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f1521b.toString();
    }

    public i0(CharSequence charSequence) {
        this.f1521b = new SpannableString(charSequence);
    }
}