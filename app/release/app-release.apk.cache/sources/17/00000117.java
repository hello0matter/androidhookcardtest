package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f684a;

    /* renamed from: b  reason: collision with root package name */
    public int f685b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f686c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f687d;

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f684a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f687d;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f684a, viewGroup, false);
                int i4 = this.f685b;
                if (i4 != -1) {
                    inflate.setId(i4);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f686c = new WeakReference(inflate);
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f685b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f687d;
    }

    public int getLayoutResource() {
        return this.f684a;
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i4) {
        this.f685b = i4;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f687d = layoutInflater;
    }

    public void setLayoutResource(int i4) {
        this.f684a = i4;
    }

    public void setOnInflateListener(d4 d4Var) {
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        WeakReference weakReference = this.f686c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i4);
            return;
        }
        super.setVisibility(i4);
        if (i4 == 0 || i4 == 4) {
            a();
        }
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f684a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.D, i4, 0);
        this.f685b = obtainStyledAttributes.getResourceId(2, -1);
        this.f684a = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}