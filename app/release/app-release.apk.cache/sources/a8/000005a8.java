package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.z2;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import java.util.Locale;

/* loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: e  reason: collision with root package name */
    public final ListPopupWindow f3950e;

    /* renamed from: f  reason: collision with root package name */
    public final AccessibilityManager f3951f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f3952g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3953h;

    /* renamed from: i  reason: collision with root package name */
    public final float f3954i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3955j;

    /* renamed from: k  reason: collision with root package name */
    public int f3956k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f3957l;

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    public static void a(MaterialAutoCompleteTextView materialAutoCompleteTextView, Object obj) {
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        AccessibilityManager accessibilityManager = this.f3951f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f3950e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.f3955j;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout b5 = b();
        if (b5 != null && b5.E) {
            return b5.getHint();
        }
        return super.getHint();
    }

    public float getPopupElevation() {
        return this.f3954i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f3956k;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f3957l;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        String str;
        super.onAttachedToWindow();
        TextInputLayout b5 = b();
        if (b5 != null && b5.E && super.getHint() == null) {
            String str2 = Build.MANUFACTURER;
            if (str2 == null) {
                str = "";
            } else {
                str = str2.toLowerCase(Locale.ENGLISH);
            }
            if (str.equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3950e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int selectedItemPosition;
        super.onMeasure(i4, i5);
        if (View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b5 = b();
            int i6 = 0;
            if (adapter != null && b5 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                ListPopupWindow listPopupWindow = this.f3950e;
                if (!listPopupWindow.f593z.isShowing()) {
                    selectedItemPosition = -1;
                } else {
                    selectedItemPosition = listPopupWindow.f570c.getSelectedItemPosition();
                }
                int min = Math.min(adapter.getCount(), Math.max(0, selectedItemPosition) + 15);
                View view = null;
                int i7 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i6) {
                        view = null;
                        i6 = itemViewType;
                    }
                    view = adapter.getView(max, view, b5);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i7 = Math.max(i7, view.getMeasuredWidth());
                }
                Drawable background = listPopupWindow.f593z.getBackground();
                if (background != null) {
                    Rect rect = this.f3952g;
                    background.getPadding(rect);
                    i7 += rect.left + rect.right;
                }
                i6 = b5.getEndIconView().getMeasuredWidth() + i7;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i6), View.MeasureSpec.getSize(i4)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        AccessibilityManager accessibilityManager = this.f3951f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        super.onWindowFocusChanged(z4);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t4) {
        super.setAdapter(t4);
        this.f3950e.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f3950e;
        if (listPopupWindow != null) {
            listPopupWindow.l(drawable);
        }
    }

    public void setDropDownBackgroundTint(@ColorInt int i4) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i4));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f3955j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof l2.j) {
            ((l2.j) dropDownBackground).o(this.f3955j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f3950e.f584q = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i4) {
        super.setRawInputType(i4);
        TextInputLayout b5 = b();
        if (b5 != null) {
            b5.s();
        }
    }

    public void setSimpleItemSelectedColor(int i4) {
        this.f3956k = i4;
        if (getAdapter() instanceof p) {
            ((p) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.f3957l = colorStateList;
        if (getAdapter() instanceof p) {
            ((p) getAdapter()).a();
        }
    }

    public void setSimpleItems(@ArrayRes int i4) {
        setSimpleItems(getResources().getStringArray(i4));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.f3951f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f3950e.f();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new p(this, getContext(), this.f3953h, strArr));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 0), attributeSet, i4);
        this.f3952g = new Rect();
        Context context2 = getContext();
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.f5967x, i4, 2131755758, new int[0]);
        if (d4.hasValue(0) && d4.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f3953h = d4.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        this.f3954i = d4.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (d4.hasValue(2)) {
            this.f3955j = ColorStateList.valueOf(d4.getColor(2, 0));
        }
        this.f3956k = d4.getColor(4, 0);
        this.f3957l = i2.d.a(context2, d4, 5);
        this.f3951f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f3950e = listPopupWindow;
        listPopupWindow.f592y = true;
        listPopupWindow.f593z.setFocusable(true);
        listPopupWindow.f582o = this;
        listPopupWindow.f593z.setInputMethodMode(2);
        listPopupWindow.o(getAdapter());
        listPopupWindow.f583p = new z2(1, this);
        if (d4.hasValue(6)) {
            setSimpleItems(d4.getResourceId(6, 0));
        }
        d4.recycle();
    }
}