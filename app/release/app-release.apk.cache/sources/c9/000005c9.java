package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.msphone.R;
import i0.g0;
import i0.h0;
import i0.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import l2.l;
import l2.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RadialViewGroup extends ConstraintLayout {

    /* renamed from: q  reason: collision with root package name */
    public final e f4147q;

    /* renamed from: r  reason: collision with root package name */
    public int f4148r;

    /* renamed from: s  reason: collision with root package name */
    public final l2.j f4149s;

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i4, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = y0.f4999a;
            view.setId(h0.a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f4147q;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    public void o() {
        int i4;
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.d(this);
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i6 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i6 == null) {
                    i6 = 1;
                }
                if (!hashMap.containsKey(i6)) {
                    hashMap.put(i6, new ArrayList());
                }
                ((List) hashMap.get(i6)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List<View> list = (List) entry.getValue();
            if (((Integer) entry.getKey()).intValue() == 2) {
                i4 = Math.round(this.f4148r * 0.66f);
            } else {
                i4 = this.f4148r;
            }
            float f4 = 0.0f;
            for (View view : list) {
                t.e eVar = dVar.g(view.getId()).f1314d;
                eVar.f6618x = R.id.circle_center;
                eVar.f6619y = i4;
                eVar.f6620z = f4;
                f4 += 360.0f / list.size();
            }
        }
        dVar.b(this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        o();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f4147q;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i4) {
        this.f4149s.o(ColorStateList.valueOf(i4));
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.material.timepicker.e] */
    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        l2.j jVar = new l2.j();
        this.f4149s = jVar;
        l lVar = new l(0.5f);
        n g4 = jVar.f5310a.f5288a.g();
        g4.f5339e = lVar;
        g4.f5340f = lVar;
        g4.f5341g = lVar;
        g4.f5342h = lVar;
        jVar.setShapeAppearanceModel(g4.a());
        this.f4149s.o(ColorStateList.valueOf(-1));
        l2.j jVar2 = this.f4149s;
        WeakHashMap weakHashMap = y0.f4999a;
        g0.q(this, jVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.P, i4, 0);
        this.f4148r = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f4147q = new Runnable() { // from class: com.google.android.material.timepicker.e
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.o();
            }
        };
        obtainStyledAttributes.recycle();
    }
}