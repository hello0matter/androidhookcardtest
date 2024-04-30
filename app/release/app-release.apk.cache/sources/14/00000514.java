package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.example.msphone.R;
import i0.y0;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements g.e0 {
    public static final int[] G = {16842912};
    public FrameLayout A;
    public g.r B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final f1.f F;

    /* renamed from: v  reason: collision with root package name */
    public int f3455v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3456w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3457x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3458y;

    /* renamed from: z  reason: collision with root package name */
    public final CheckedTextView f3459z;

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // g.e0
    public final void c(g.r rVar) {
        int i4;
        LinearLayoutCompat.LayoutParams layoutParams;
        int i5;
        StateListDrawable stateListDrawable;
        this.B = rVar;
        int i6 = rVar.f4722a;
        if (i6 > 0) {
            setId(i6);
        }
        if (rVar.isVisible()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        setVisibility(i4);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = y0.f4999a;
            i0.g0.q(this, stateListDrawable);
        }
        setCheckable(rVar.isCheckable());
        setChecked(rVar.isChecked());
        setEnabled(rVar.isEnabled());
        setTitle(rVar.f4726e);
        setIcon(rVar.getIcon());
        setActionView(rVar.getActionView());
        setContentDescription(rVar.f4738q);
        com.google.common.collect.c.V1(this, rVar.f4739r);
        g.r rVar2 = this.B;
        CharSequence charSequence = rVar2.f4726e;
        CheckedTextView checkedTextView = this.f3459z;
        if (charSequence == null && rVar2.getIcon() == null && this.B.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                i5 = -1;
            } else {
                return;
            }
        } else {
            checkedTextView.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
                i5 = -2;
            } else {
                return;
            }
        }
        ((LinearLayout.LayoutParams) layoutParams).width = i5;
        this.A.setLayoutParams(layoutParams);
    }

    @Override // g.e0
    public g.r getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        g.r rVar = this.B;
        if (rVar != null && rVar.isCheckable() && this.B.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
        if (this.f3457x != z4) {
            this.f3457x = z4;
            this.F.h(this.f3459z, 2048);
        }
    }

    public void setChecked(boolean z4) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.f3459z;
        checkedTextView.setChecked(z4);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z4 && this.f3458y) ? 1 : 0);
    }

    public void setHorizontalPadding(int i4) {
        setPadding(i4, getPaddingTop(), i4, getPaddingBottom());
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                c0.b.h(drawable, this.C);
            }
            int i4 = this.f3455v;
            drawable.setBounds(0, 0, i4, i4);
        } else if (this.f3456w) {
            if (this.E == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = a0.s.f38a;
                Drawable a5 = a0.k.a(resources, R.drawable.navigation_empty_icon, theme);
                this.E = a5;
                if (a5 != null) {
                    int i5 = this.f3455v;
                    a5.setBounds(0, 0, i5, i5);
                }
            }
            drawable = this.E;
        }
        androidx.core.widget.q.e(this.f3459z, drawable, null, null, null);
    }

    public void setIconPadding(int i4) {
        this.f3459z.setCompoundDrawablePadding(i4);
    }

    public void setIconSize(@Dimension int i4) {
        this.f3455v = i4;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        g.r rVar = this.B;
        if (rVar != null) {
            setIcon(rVar.getIcon());
        }
    }

    public void setMaxLines(int i4) {
        this.f3459z.setMaxLines(i4);
    }

    public void setNeedsEmptyIcon(boolean z4) {
        this.f3456w = z4;
    }

    public void setShortcut(boolean z4, char c4) {
    }

    public void setTextAppearance(int i4) {
        this.f3459z.setTextAppearance(i4);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f3459z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f3459z.setText(charSequence);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3458y = true;
        f1.f fVar = new f1.f(4, this);
        this.F = fVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.f3459z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        y0.p(checkedTextView, fVar);
    }
}