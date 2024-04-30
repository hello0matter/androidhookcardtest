package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public final w f507a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f508b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f509c;

    public AppCompatImageView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f507a;
        if (wVar != null) {
            wVar.a();
        }
        e0 e0Var = this.f508b;
        if (e0Var != null) {
            e0Var.a();
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f507a;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f507a;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportImageTintList() {
        o3 o3Var;
        e0 e0Var = this.f508b;
        if (e0Var == null || (o3Var = e0Var.f739b) == null) {
            return null;
        }
        return o3Var.f868a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportImageTintMode() {
        o3 o3Var;
        e0 e0Var = this.f508b;
        if (e0Var == null || (o3Var = e0Var.f739b) == null) {
            return null;
        }
        return o3Var.f869b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        if ((!(this.f508b.f738a.getBackground() instanceof RippleDrawable)) && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f507a;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f507a;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        e0 e0Var = this.f508b;
        if (e0Var != null) {
            e0Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        e0 e0Var = this.f508b;
        if (e0Var != null && drawable != null && !this.f509c) {
            e0Var.f740c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (e0Var != null) {
            e0Var.a();
            if (!this.f509c) {
                ImageView imageView = e0Var.f738a;
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setLevel(e0Var.f740c);
                }
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i4) {
        super.setImageLevel(i4);
        this.f509c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i4) {
        e0 e0Var = this.f508b;
        if (e0Var != null) {
            e0Var.c(i4);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        e0 e0Var = this.f508b;
        if (e0Var != null) {
            e0Var.a();
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f507a;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f507a;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.appcompat.widget.o3, java.lang.Object] */
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        e0 e0Var = this.f508b;
        if (e0Var != null) {
            if (e0Var.f739b == null) {
                e0Var.f739b = new Object();
            }
            o3 o3Var = e0Var.f739b;
            o3Var.f868a = colorStateList;
            o3Var.f871d = true;
            e0Var.a();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.appcompat.widget.o3, java.lang.Object] */
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        e0 e0Var = this.f508b;
        if (e0Var != null) {
            if (e0Var.f739b == null) {
                e0Var.f739b = new Object();
            }
            o3 o3Var = e0Var.f739b;
            o3Var.f869b = mode;
            o3Var.f870c = true;
            e0Var.a();
        }
    }

    public AppCompatImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n3.a(context);
        this.f509c = false;
        m3.a(this, getContext());
        w wVar = new w(this);
        this.f507a = wVar;
        wVar.e(attributeSet, i4);
        e0 e0Var = new e0(this);
        this.f508b = e0Var;
        e0Var.b(attributeSet, i4);
    }
}