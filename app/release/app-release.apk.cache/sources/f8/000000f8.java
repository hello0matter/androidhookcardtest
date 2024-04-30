package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements i0.y {

    /* renamed from: a  reason: collision with root package name */
    public final w f498a;

    /* renamed from: b  reason: collision with root package name */
    public final y0 f499b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f500c;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.core.widget.w f501d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f502e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f503f;

    public AppCompatEditText(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    @RequiresApi(26)
    @UiThread
    private b0 getSuperCaller() {
        if (this.f503f == null) {
            this.f503f = new b0(this);
        }
        return this.f503f;
    }

    @Override // i0.y
    public final i0.j a(i0.j jVar) {
        return this.f501d.a(this, jVar);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f498a;
        if (wVar != null) {
            wVar.a();
        }
        y0 y0Var = this.f499b;
        if (y0Var != null) {
            y0Var.b();
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
        w wVar = this.f498a;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f498a;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f499b.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f499b.e();
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        c0 c0Var;
        if (Build.VERSION.SDK_INT < 28 && (c0Var = this.f500c) != null) {
            TextClassifier textClassifier = (TextClassifier) c0Var.f726c;
            if (textClassifier == null) {
                return r0.a((TextView) c0Var.f725b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r1 != null) goto L18;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r8) {
        /*
            r7 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r8)
            androidx.appcompat.widget.y0 r1 = r7.f499b
            r1.getClass()
            androidx.appcompat.widget.y0.h(r7, r0, r8)
            com.google.common.collect.c.h1(r7, r8, r0)
            if (r0 == 0) goto L77
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L77
            java.lang.String[] r2 = i0.y0.g(r7)
            if (r2 == 0) goto L77
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String r4 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            r5 = 25
            if (r1 < r5) goto L29
            l0.a.b(r8, r2)
            goto L3e
        L29:
            android.os.Bundle r6 = r8.extras
            if (r6 != 0) goto L34
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r8.extras = r6
        L34:
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r4, r2)
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r3, r2)
        L3e:
            l0.d r2 = new l0.d
            r6 = 0
            r2.<init>(r6, r7)
            if (r1 < r5) goto L4d
            l0.e r1 = new l0.e
            r1.<init>(r0, r2)
        L4b:
            r0 = r1
            goto L77
        L4d:
            java.lang.String[] r6 = l0.c.f5257a
            if (r1 < r5) goto L59
            java.lang.String[] r1 = l0.a.c(r8)
            if (r1 == 0) goto L6d
        L57:
            r6 = r1
            goto L6d
        L59:
            android.os.Bundle r1 = r8.extras
            if (r1 != 0) goto L5e
            goto L6d
        L5e:
            java.lang.String[] r1 = r1.getStringArray(r4)
            if (r1 != 0) goto L6a
            android.os.Bundle r1 = r8.extras
            java.lang.String[] r1 = r1.getStringArray(r3)
        L6a:
            if (r1 == 0) goto L6d
            goto L57
        L6d:
            int r1 = r6.length
            if (r1 != 0) goto L71
            goto L77
        L71:
            l0.f r1 = new l0.f
            r1.<init>(r0, r2)
            goto L4b
        L77:
            androidx.appcompat.widget.c0 r1 = r7.f502e
            android.view.inputmethod.InputConnection r8 = r1.f(r0, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && i0.y0.g(this) != null) {
            Context context = getContext();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3 && g0.a(dragEvent, this, activity)) {
                return true;
            }
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public final boolean onTextContextMenuItem(int i4) {
        ClipData primaryClip;
        i0.g hVar;
        int i5;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 31 && i0.y0.g(this) != null && (i4 == 16908322 || i4 == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                primaryClip = null;
            } else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                if (i6 >= 31) {
                    hVar = new i0.f(primaryClip, 1);
                } else {
                    hVar = new i0.h(primaryClip, 1);
                }
                if (i4 == 16908322) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                hVar.e(i5);
                i0.y0.k(this, hVar.a());
            }
            return true;
        }
        return super.onTextContextMenuItem(i4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f498a;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f498a;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f499b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f499b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        ((s0.b) this.f502e.f726c).f6498a.r(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.f502e.a(keyListener));
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f498a;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f498a;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        y0 y0Var = this.f499b;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        y0 y0Var = this.f499b;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        y0 y0Var = this.f499b;
        if (y0Var != null) {
            y0Var.g(context, i4);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        c0 c0Var;
        if (Build.VERSION.SDK_INT >= 28 || (c0Var = this.f500c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0Var.f726c = textClassifier;
        }
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.core.widget.w, java.lang.Object] */
    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n3.a(context);
        m3.a(this, getContext());
        w wVar = new w(this);
        this.f498a = wVar;
        wVar.e(attributeSet, i4);
        y0 y0Var = new y0(this);
        this.f499b = y0Var;
        y0Var.f(attributeSet, i4);
        y0Var.b();
        this.f500c = new c0((TextView) this);
        this.f501d = new Object();
        c0 c0Var = new c0((EditText) this);
        this.f502e = c0Var;
        c0Var.b(attributeSet, i4);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a5 = c0Var.a(keyListener);
            if (a5 == keyListener) {
                return;
            }
            super.setKeyListener(a5);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }
}