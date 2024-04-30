package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.c0;
import androidx.recyclerview.widget.i0;
import com.example.msphone.R;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.a;
import com.google.android.material.internal.h0;
import i0.g0;
import i0.y0;
import java.util.List;
import java.util.WeakHashMap;
import w1.g;
import w1.h;
import w1.i;
import w1.j;

/* loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f3234e;

    /* renamed from: f  reason: collision with root package name */
    public int f3235f;

    /* renamed from: g  reason: collision with root package name */
    public i f3236g;

    /* renamed from: h  reason: collision with root package name */
    public final a f3237h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3238i;

    /* renamed from: j  reason: collision with root package name */
    public final j f3239j;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getVisibleChipCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if ((getChildAt(i5) instanceof Chip) && getChildAt(i5).getVisibility() == 0) {
                i4++;
            }
        }
        return i4;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public final boolean a() {
        return this.f3447c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        return this.f3237h.c();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.f3237h.b(this);
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.f3234e;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.f3235f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i4 = this.f3238i;
        if (i4 != -1) {
            a aVar = this.f3237h;
            com.google.android.material.internal.i iVar = (com.google.android.material.internal.i) aVar.f3469a.get(Integer.valueOf(i4));
            if (iVar != null && aVar.a(iVar)) {
                aVar.d();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i4;
        int i5;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.f3447c) {
            i4 = getVisibleChipCount();
        } else {
            i4 = -1;
        }
        int rowCount = getRowCount();
        if (this.f3237h.f3472d) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(rowCount, i4, i5).f2125a);
    }

    public void setChipSpacing(@Dimension int i4) {
        setChipSpacingHorizontal(i4);
        setChipSpacingVertical(i4);
    }

    public void setChipSpacingHorizontal(@Dimension int i4) {
        if (this.f3234e != i4) {
            this.f3234e = i4;
            setItemSpacing(i4);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i4) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i4));
    }

    public void setChipSpacingResource(@DimenRes int i4) {
        setChipSpacing(getResources().getDimensionPixelOffset(i4));
    }

    public void setChipSpacingVertical(@Dimension int i4) {
        if (this.f3235f != i4) {
            this.f3235f = i4;
            setLineSpacing(i4);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i4) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i4));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i4) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable h hVar) {
        if (hVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new c0(9, (View) this, (Object) hVar));
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable i iVar) {
        this.f3236g = iVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f3239j.f7057a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z4) {
        this.f3237h.f3473e = z4;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i4) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i4) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(@BoolRes int i4) {
        setSingleLine(getResources().getBoolean(i4));
    }

    public void setSingleSelection(@BoolRes int i4) {
        setSingleSelection(getResources().getBoolean(i4));
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z4) {
        super.setSingleLine(z4);
    }

    public void setSingleSelection(boolean z4) {
        a aVar = this.f3237h;
        if (aVar.f3472d != z4) {
            aVar.f3472d = z4;
            boolean z5 = !aVar.f3470b.isEmpty();
            for (com.google.android.material.internal.i iVar : aVar.f3469a.values()) {
                aVar.e(iVar, false);
            }
            if (z5) {
                aVar.d();
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756036), attributeSet, i4);
        a aVar = new a();
        this.f3237h = aVar;
        j jVar = new j(this);
        this.f3239j = jVar;
        TypedArray d4 = h0.d(getContext(), attributeSet, o1.a.f5953j, i4, 2131756036, new int[0]);
        int dimensionPixelOffset = d4.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(d4.getDimensionPixelOffset(2, dimensionPixelOffset));
        setChipSpacingVertical(d4.getDimensionPixelOffset(3, dimensionPixelOffset));
        setSingleLine(d4.getBoolean(5, false));
        setSingleSelection(d4.getBoolean(6, false));
        setSelectionRequired(d4.getBoolean(4, false));
        this.f3238i = d4.getResourceId(0, -1);
        d4.recycle();
        aVar.f3471c = new g(0, this);
        super.setOnHierarchyChangeListener(jVar);
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, 1);
    }
}