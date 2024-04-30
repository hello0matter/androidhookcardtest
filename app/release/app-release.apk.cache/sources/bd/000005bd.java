package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ColorStateList f4106a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f4107b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaterialAutoCompleteTextView f4108c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(MaterialAutoCompleteTextView materialAutoCompleteTextView, Context context, int i4, String[] strArr) {
        super(context, i4, strArr);
        this.f4108c = materialAutoCompleteTextView;
        a();
    }

    public final void a() {
        boolean z4;
        ColorStateList colorStateList;
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.f4108c;
        ColorStateList colorStateList2 = materialAutoCompleteTextView.f3957l;
        if (colorStateList2 != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        ColorStateList colorStateList3 = null;
        if (!z4) {
            colorStateList = null;
        } else {
            int[] iArr = {16842919};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        }
        this.f4107b = colorStateList;
        if (materialAutoCompleteTextView.f3956k != 0 && materialAutoCompleteTextView.f3957l != null) {
            int[] iArr2 = {16843623, -16842919};
            int[] iArr3 = {16842913, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{b0.a.c(materialAutoCompleteTextView.f3957l.getColorForState(iArr3, 0), materialAutoCompleteTextView.f3956k), b0.a.c(materialAutoCompleteTextView.f3957l.getColorForState(iArr2, 0), materialAutoCompleteTextView.f3956k), materialAutoCompleteTextView.f3956k});
        }
        this.f4106a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i4, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = this.f4108c;
            RippleDrawable rippleDrawable = null;
            if (materialAutoCompleteTextView.getText().toString().contentEquals(textView.getText()) && materialAutoCompleteTextView.f3956k != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(materialAutoCompleteTextView.f3956k);
                if (this.f4107b != null) {
                    c0.b.h(colorDrawable, this.f4106a);
                    rippleDrawable = new RippleDrawable(this.f4107b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = y0.f4999a;
            g0.q(textView, rippleDrawable);
        }
        return view2;
    }
}