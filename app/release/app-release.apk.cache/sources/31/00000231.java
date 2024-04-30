package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f0 extends SpannableStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Class f1513a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1514b;

    public f0(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f1514b = new ArrayList();
        h0.e.c(cls, "watcherClass cannot be null");
        this.f1513a = cls;
    }

    public final void a() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f1514b;
            if (i4 < arrayList.size()) {
                ((e0) arrayList.get(i4)).f1512b.incrementAndGet();
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c4) {
        super.append(c4);
        return this;
    }

    public final void b() {
        e();
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f1514b;
            if (i4 < arrayList.size()) {
                ((e0) arrayList.get(i4)).onTextChanged(this, 0, length(), length());
                i4++;
            } else {
                return;
            }
        }
    }

    public final e0 c(Object obj) {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f1514b;
            if (i4 >= arrayList.size()) {
                return null;
            }
            e0 e0Var = (e0) arrayList.get(i4);
            if (e0Var.f1511a == obj) {
                return e0Var;
            }
            i4++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            if (this.f1513a == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i4, int i5) {
        super.delete(i4, i5);
        return this;
    }

    public final void e() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f1514b;
            if (i4 < arrayList.size()) {
                ((e0) arrayList.get(i4)).f1512b.decrementAndGet();
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        e0 c4;
        if (d(obj) && (c4 = c(obj)) != null) {
            obj = c4;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        e0 c4;
        if (d(obj) && (c4 = c(obj)) != null) {
            obj = c4;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        e0 c4;
        if (d(obj) && (c4 = c(obj)) != null) {
            obj = c4;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i4, int i5, Class cls) {
        if (this.f1513a == cls) {
            e0[] e0VarArr = (e0[]) super.getSpans(i4, i5, e0.class);
            Object[] objArr = (Object[]) Array.newInstance(cls, e0VarArr.length);
            for (int i6 = 0; i6 < e0VarArr.length; i6++) {
                objArr[i6] = e0VarArr[i6].f1511a;
            }
            return objArr;
        }
        return super.getSpans(i4, i5, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i4, CharSequence charSequence) {
        super.insert(i4, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i4, int i5, Class cls) {
        return super.nextSpanTransition(i4, i5, (cls == null || this.f1513a == cls) ? e0.class : e0.class);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        e0 e0Var;
        if (d(obj)) {
            e0Var = c(obj);
            if (e0Var != null) {
                obj = e0Var;
            }
        } else {
            e0Var = null;
        }
        super.removeSpan(obj);
        if (e0Var != null) {
            this.f1514b.remove(e0Var);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i4, int i5, CharSequence charSequence) {
        replace(i4, i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i4, int i5, int i6) {
        if (d(obj)) {
            e0 e0Var = new e0(obj);
            this.f1514b.add(e0Var);
            obj = e0Var;
        }
        super.setSpan(obj, i4, i5, i6);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i4, int i5) {
        return new f0(this.f1513a, this, i4, i5);
    }

    public f0(Class cls, CharSequence charSequence, int i4, int i5) {
        super(charSequence, i4, i5);
        this.f1514b = new ArrayList();
        h0.e.c(cls, "watcherClass cannot be null");
        this.f1513a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i4, int i5) {
        super.delete(i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i4, CharSequence charSequence, int i5, int i6) {
        super.insert(i4, charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i4, int i5, CharSequence charSequence, int i6, int i7) {
        replace(i4, i5, charSequence, i6, i7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i4, int i5) {
        super.append(charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i4, CharSequence charSequence) {
        super.insert(i4, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i4, int i5, CharSequence charSequence) {
        a();
        super.replace(i4, i5, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i4, CharSequence charSequence, int i5, int i6) {
        super.insert(i4, charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i4, int i5, CharSequence charSequence, int i6, int i7) {
        a();
        super.replace(i4, i5, charSequence, i6, i7);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i4, int i5) {
        super.append(charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i4) {
        super.append(charSequence, obj, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i4, int i5) {
        super.append(charSequence, i4, i5);
        return this;
    }
}