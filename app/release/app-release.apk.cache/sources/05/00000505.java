package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.l1;
import androidx.recyclerview.widget.q0;
import c0.b;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import i0.y0;
import i2.d;
import java.util.WeakHashMap;
import o1.a;

/* loaded from: classes.dex */
public class MaterialDividerItemDecoration extends q0 {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f3384a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3385b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3386c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3387d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3388e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3389f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3390g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f3391h = new Rect();

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        TypedArray d4 = h0.d(context, attributeSet, a.E, R.attr.materialDividerStyle, 2131756075, new int[0]);
        this.f3386c = d.a(context, d4, 0).getDefaultColor();
        this.f3385b = d4.getDimensionPixelSize(3, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f3388e = d4.getDimensionPixelOffset(2, 0);
        this.f3389f = d4.getDimensionPixelOffset(1, 0);
        this.f3390g = d4.getBoolean(4, true);
        d4.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        int i5 = this.f3386c;
        this.f3386c = i5;
        this.f3384a = shapeDrawable;
        b.g(shapeDrawable, i5);
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("Invalid orientation: " + i4 + ". It should be either HORIZONTAL or VERTICAL");
        }
        this.f3387d = i4;
    }

    @Override // androidx.recyclerview.widget.q0
    public final void a(Rect rect, View view, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
        if (d(recyclerView, view)) {
            int i4 = this.f3387d;
            int i5 = this.f3385b;
            if (i4 == 1) {
                rect.bottom = i5;
            } else {
                rect.right = i5;
            }
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int i4;
        int width;
        int i5;
        int i6;
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        int i7 = this.f3387d;
        int i8 = this.f3385b;
        int i9 = this.f3389f;
        int i10 = this.f3388e;
        boolean z4 = true;
        Rect rect = this.f3391h;
        int i11 = 0;
        if (i7 == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i5 = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i5, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                i5 = 0;
            }
            WeakHashMap weakHashMap = y0.f4999a;
            if (i0.h0.d(recyclerView) != 1) {
                z4 = false;
            }
            if (z4) {
                i6 = i9;
            } else {
                i6 = i10;
            }
            int i12 = i5 + i6;
            if (z4) {
                i9 = i10;
            }
            int i13 = width - i9;
            int childCount = recyclerView.getChildCount();
            while (i11 < childCount) {
                View childAt = recyclerView.getChildAt(i11);
                if (d(recyclerView, childAt)) {
                    recyclerView.getLayoutManager().y(childAt, rect);
                    int round = Math.round(childAt.getTranslationY()) + rect.bottom;
                    this.f3384a.setBounds(i12, round - i8, i13, round);
                    this.f3384a.draw(canvas);
                }
                i11++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i4 = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i4, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i4 = 0;
        }
        int i14 = i4 + i10;
        int i15 = height - i9;
        int childCount2 = recyclerView.getChildCount();
        while (i11 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i11);
            if (d(recyclerView, childAt2)) {
                recyclerView.getLayoutManager().y(childAt2, rect);
                int round2 = Math.round(childAt2.getTranslationX()) + rect.right;
                this.f3384a.setBounds(round2 - i8, i14, round2, i15);
                this.f3384a.draw(canvas);
            }
            i11++;
        }
        canvas.restore();
    }

    public final boolean d(RecyclerView recyclerView, View view) {
        int i4;
        boolean z4;
        RecyclerView recyclerView2;
        recyclerView.getClass();
        l1 J = RecyclerView.J(view);
        if (J != null && (recyclerView2 = J.f2187r) != null) {
            i4 = recyclerView2.G(J);
        } else {
            i4 = -1;
        }
        j0 adapter = recyclerView.getAdapter();
        if (adapter != null && i4 == adapter.a() - 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i4 == -1) {
            return false;
        }
        if (z4 && !this.f3390g) {
            return false;
        }
        return true;
    }
}