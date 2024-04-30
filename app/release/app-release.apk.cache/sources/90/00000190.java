package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final CheckedTextView f934a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f935b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f936c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f937d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f938e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f939f;

    public x(CheckedTextView checkedTextView) {
        this.f934a = checkedTextView;
    }

    public final void a() {
        CheckedTextView checkedTextView = this.f934a;
        Drawable checkMarkDrawable = checkedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f937d || this.f938e) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.f937d) {
                    c0.b.h(mutate, this.f935b);
                }
                if (this.f938e) {
                    c0.b.i(mutate, this.f936c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(checkedTextView.getDrawableState());
                }
                checkedTextView.setCheckMarkDrawable(mutate);
            }
        }
    }
}