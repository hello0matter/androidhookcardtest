package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.o0;
import androidx.recyclerview.widget.i0;
import com.example.msphone.R;
import com.google.android.material.internal.n0;
import com.google.android.material.timepicker.g;
import f1.f;
import i0.g0;
import i0.h0;
import i0.p;
import i0.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import l2.n;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f3130k = 0;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f3131a;

    /* renamed from: b  reason: collision with root package name */
    public final o0 f3132b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashSet f3133c;

    /* renamed from: d  reason: collision with root package name */
    public final o.d f3134d;

    /* renamed from: e  reason: collision with root package name */
    public Integer[] f3135e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3136f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3137g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3138h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3139i;

    /* renamed from: j  reason: collision with root package name */
    public HashSet f3140j;

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (c(i4)) {
                return i4;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if ((getChildAt(i5) instanceof MaterialButton) && c(i5)) {
                i4++;
            }
        }
        return i4;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = y0.f4999a;
            materialButton.setId(h0.a());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f3132b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i4 = firstVisibleChildIndex + 1; i4 < getChildCount(); i4++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i4);
            int min = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i4 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams2 = materialButton.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            }
            if (getOrientation() == 0) {
                p.g(layoutParams, 0);
                p.h(layoutParams, -min);
                layoutParams.topMargin = 0;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = -min;
                p.h(layoutParams, 0);
            }
            materialButton.setLayoutParams(layoutParams);
        }
        if (getChildCount() != 0 && firstVisibleChildIndex != -1) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams3.topMargin = 0;
                layoutParams3.bottomMargin = 0;
                return;
            }
            p.g(layoutParams3, 0);
            p.h(layoutParams3, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i4, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.f3126o);
        l2.p shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f3131a.add(new d(shapeAppearanceModel.f5352e, shapeAppearanceModel.f5355h, shapeAppearanceModel.f5353f, shapeAppearanceModel.f5354g));
        materialButton.setEnabled(isEnabled());
        y0.p(materialButton, new f(2, this));
    }

    public final void b(int i4, boolean z4) {
        if (i4 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i4);
            return;
        }
        HashSet hashSet = new HashSet(this.f3140j);
        if (z4 && !hashSet.contains(Integer.valueOf(i4))) {
            if (this.f3137g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i4));
        } else if (z4 || !hashSet.contains(Integer.valueOf(i4))) {
            return;
        } else {
            if (!this.f3138h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i4));
            }
        }
        d(hashSet);
    }

    public final boolean c(int i4) {
        return getChildAt(i4).getVisibility() != 8;
    }

    public final void d(Set set) {
        HashSet hashSet = this.f3140j;
        this.f3140j = new HashSet(set);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            int id = ((MaterialButton) getChildAt(i4)).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.f3136f = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.f3136f = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f3133c.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).a();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f3134d);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            treeMap.put((MaterialButton) getChildAt(i4), Integer.valueOf(i4));
        }
        this.f3135e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        boolean z4;
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i4 = 0; i4 < childCount; i4++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i4);
            if (materialButton.getVisibility() != 8) {
                n g4 = materialButton.getShapeAppearanceModel().g();
                d dVar2 = (d) this.f3131a.get(i4);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    if (getOrientation() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    l2.a aVar = d.f3161e;
                    if (i4 == firstVisibleChildIndex) {
                        if (z4) {
                            if (n0.f(this)) {
                                dVar = new d(aVar, aVar, dVar2.f3163b, dVar2.f3164c);
                            } else {
                                dVar = new d(dVar2.f3162a, dVar2.f3165d, aVar, aVar);
                            }
                        } else {
                            dVar = new d(dVar2.f3162a, aVar, dVar2.f3163b, aVar);
                        }
                    } else if (i4 == lastVisibleChildIndex) {
                        if (z4) {
                            if (n0.f(this)) {
                                dVar = new d(dVar2.f3162a, dVar2.f3165d, aVar, aVar);
                            } else {
                                dVar = new d(aVar, aVar, dVar2.f3163b, dVar2.f3164c);
                            }
                        } else {
                            dVar = new d(aVar, dVar2.f3165d, aVar, dVar2.f3164c);
                        }
                    } else {
                        dVar2 = null;
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    g4.c(0.0f);
                } else {
                    g4.f5339e = dVar2.f3162a;
                    g4.f5342h = dVar2.f3165d;
                    g4.f5340f = dVar2.f3163b;
                    g4.f5341g = dVar2.f3164c;
                }
                materialButton.setShapeAppearanceModel(g4.a());
            }
        }
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.f3137g || this.f3140j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f3140j.iterator().next()).intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            int id = ((MaterialButton) getChildAt(i4)).getId();
            if (this.f3140j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i4, int i5) {
        Integer[] numArr = this.f3135e;
        if (numArr == null || i5 >= numArr.length) {
            Log.w("MButtonToggleGroup", "Child order wasn't updated");
            return i5;
        }
        return numArr[i5].intValue();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i4 = this.f3139i;
        if (i4 != -1) {
            d(Collections.singleton(Integer.valueOf(i4)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i4;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (this.f3137g) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(1, visibleButtonCount, i4).f2125a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        e();
        a();
        super.onMeasure(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f3131a.remove(indexOfChild);
        }
        e();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            ((MaterialButton) getChildAt(i4)).setEnabled(z4);
        }
    }

    public void setSelectionRequired(boolean z4) {
        this.f3138h = z4;
    }

    public void setSingleSelection(@BoolRes int i4) {
        setSingleSelection(getResources().getBoolean(i4));
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    public void setSingleSelection(boolean z4) {
        if (this.f3137g != z4) {
            this.f3137g = z4;
            d(new HashSet());
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            ((MaterialButton) getChildAt(i4)).setA11yClassName((this.f3137g ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756050), attributeSet, i4);
        this.f3131a = new ArrayList();
        this.f3132b = new o0(this);
        this.f3133c = new LinkedHashSet();
        this.f3134d = new o.d(3, this);
        this.f3136f = false;
        this.f3140j = new HashSet();
        TypedArray d4 = com.google.android.material.internal.h0.d(getContext(), attributeSet, o1.a.f5969z, i4, 2131756050, new int[0]);
        setSingleSelection(d4.getBoolean(3, false));
        this.f3139i = d4.getResourceId(1, -1);
        this.f3138h = d4.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(d4.getBoolean(0, true));
        d4.recycle();
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, 1);
    }
}