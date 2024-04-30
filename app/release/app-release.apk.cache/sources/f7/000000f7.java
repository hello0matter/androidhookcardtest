package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    public final x f494a;

    /* renamed from: b  reason: collision with root package name */
    public final w f495b;

    /* renamed from: c  reason: collision with root package name */
    public final y0 f496c;

    /* renamed from: d  reason: collision with root package name */
    public d0 f497d;

    public AppCompatCheckedTextView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private d0 getEmojiTextViewHelper() {
        if (this.f497d == null) {
            this.f497d = new d0(this);
        }
        return this.f497d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y0 y0Var = this.f496c;
        if (y0Var != null) {
            y0Var.b();
        }
        w wVar = this.f495b;
        if (wVar != null) {
            wVar.a();
        }
        x xVar = this.f494a;
        if (xVar != null) {
            xVar.a();
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.v.d(super.getCustomSelectionActionModeCallback());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f495b;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f495b;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCheckMarkTintList() {
        x xVar = this.f494a;
        if (xVar != null) {
            return xVar.f935b;
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        x xVar = this.f494a;
        if (xVar != null) {
            return xVar.f936c;
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f496c.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f496c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        com.google.common.collect.c.h1(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f495b;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f495b;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int i4) {
        setCheckMarkDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f496c;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f496c;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f495b;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f495b;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCheckMarkTintList(@Nullable ColorStateList colorStateList) {
        x xVar = this.f494a;
        if (xVar != null) {
            xVar.f935b = colorStateList;
            xVar.f937d = true;
            xVar.a();
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode mode) {
        x xVar = this.f494a;
        if (xVar != null) {
            xVar.f936c = mode;
            xVar.f938e = true;
            xVar.a();
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        y0 y0Var = this.f496c;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        y0 y0Var = this.f496c;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i4) {
        super.setTextAppearance(context, i4);
        y0 y0Var = this.f496c;
        if (y0Var != null) {
            y0Var.g(context, i4);
        }
    }

    public AppCompatCheckedTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        x xVar = this.f494a;
        if (xVar != null) {
            if (xVar.f939f) {
                xVar.f939f = false;
                return;
            }
            xVar.f939f = true;
            xVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: all -> 0x005d, TryCatch #1 {all -> 0x005d, blocks: (B:3:0x0045, B:5:0x004b, B:7:0x0051, B:16:0x0076, B:18:0x007d, B:19:0x0084, B:21:0x008b, B:11:0x005f, B:13:0x0065, B:15:0x006b), top: B:29:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:3:0x0045, B:5:0x004b, B:7:0x0051, B:16:0x0076, B:18:0x007d, B:19:0x0084, B:21:0x008b, B:11:0x005f, B:13:0x0065, B:15:0x006b), top: B:29:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatCheckedTextView(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            androidx.appcompat.widget.n3.a(r9)
            r8.<init>(r9, r10, r11)
            android.content.Context r9 = r8.getContext()
            androidx.appcompat.widget.m3.a(r8, r9)
            androidx.appcompat.widget.y0 r9 = new androidx.appcompat.widget.y0
            r9.<init>(r8)
            r8.f496c = r9
            r9.f(r10, r11)
            r9.b()
            androidx.appcompat.widget.w r9 = new androidx.appcompat.widget.w
            r9.<init>(r8)
            r8.f495b = r9
            r9.e(r10, r11)
            androidx.appcompat.widget.x r9 = new androidx.appcompat.widget.x
            r9.<init>(r8)
            r8.f494a = r9
            android.content.Context r9 = r8.getContext()
            int[] r2 = c.a.f2555m
            r6 = 0
            androidx.appcompat.widget.q3 r9 = androidx.appcompat.widget.q3.f(r9, r10, r2, r11, r6)
            android.content.res.TypedArray r7 = r9.f879b
            android.content.Context r1 = r8.getContext()
            android.content.res.TypedArray r4 = r9.f879b
            r0 = r8
            r3 = r10
            r5 = r11
            i0.y0.o(r0, r1, r2, r3, r4, r5)
            r0 = 1
            boolean r1 = r7.hasValue(r0)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L5f
            int r0 = r7.getResourceId(r0, r6)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L5f
            android.content.Context r1 = r8.getContext()     // Catch: java.lang.Throwable -> L5d android.content.res.Resources.NotFoundException -> L5f
            android.graphics.drawable.Drawable r0 = com.google.common.collect.c.t0(r1, r0)     // Catch: java.lang.Throwable -> L5d android.content.res.Resources.NotFoundException -> L5f
            r8.setCheckMarkDrawable(r0)     // Catch: java.lang.Throwable -> L5d android.content.res.Resources.NotFoundException -> L5f
            goto L76
        L5d:
            r10 = move-exception
            goto La3
        L5f:
            boolean r0 = r7.hasValue(r6)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L76
            int r0 = r7.getResourceId(r6, r6)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L76
            android.content.Context r1 = r8.getContext()     // Catch: java.lang.Throwable -> L5d
            android.graphics.drawable.Drawable r0 = com.google.common.collect.c.t0(r1, r0)     // Catch: java.lang.Throwable -> L5d
            r8.setCheckMarkDrawable(r0)     // Catch: java.lang.Throwable -> L5d
        L76:
            r0 = 2
            boolean r1 = r7.hasValue(r0)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L84
            android.content.res.ColorStateList r0 = r9.a(r0)     // Catch: java.lang.Throwable -> L5d
            r8.setCheckMarkTintList(r0)     // Catch: java.lang.Throwable -> L5d
        L84:
            r0 = 3
            boolean r1 = r7.hasValue(r0)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L98
            r1 = -1
            int r0 = r7.getInt(r0, r1)     // Catch: java.lang.Throwable -> L5d
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.o1.c(r0, r1)     // Catch: java.lang.Throwable -> L5d
            r8.setCheckMarkTintMode(r0)     // Catch: java.lang.Throwable -> L5d
        L98:
            r9.g()
            androidx.appcompat.widget.d0 r9 = r8.getEmojiTextViewHelper()
            r9.b(r10, r11)
            return
        La3:
            r9.g()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}