package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.example.msphone.R;
import com.google.android.material.internal.n0;
import i0.y0;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f3269a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3270b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final x a() {
        return (x) super.getAdapter();
    }

    public final View b(int i4) {
        return getChildAt(i4 - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (x) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((x) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int a5;
        int width;
        int a6;
        int width2;
        int i4;
        int i5;
        int i6;
        int i7;
        int left;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        x xVar = (x) super.getAdapter();
        DateSelector dateSelector = xVar.f3370b;
        c cVar = xVar.f3372d;
        int max = Math.max(xVar.a(), getFirstVisiblePosition());
        int min = Math.min(xVar.c(), getLastVisiblePosition());
        Long item = xVar.getItem(max);
        Long item2 = xVar.getItem(min);
        Iterator it = dateSelector.e().iterator();
        while (it.hasNext()) {
            h0.c cVar2 = (h0.c) it.next();
            Object obj = cVar2.f4797a;
            if (obj != null) {
                Object obj2 = cVar2.f4798b;
                if (obj2 != null) {
                    Long l4 = (Long) obj;
                    long longValue = l4.longValue();
                    Long l5 = (Long) obj2;
                    long longValue2 = l5.longValue();
                    if (item != null && item2 != null && l4.longValue() <= item2.longValue() && l5.longValue() >= item.longValue()) {
                        boolean f4 = n0.f(this);
                        int i8 = (longValue > item.longValue() ? 1 : (longValue == item.longValue() ? 0 : -1));
                        Calendar calendar = materialCalendarGridView.f3269a;
                        Month month = xVar.f3369a;
                        if (i8 < 0) {
                            if (max % month.f3293d == 0) {
                                left = 0;
                            } else {
                                View b5 = materialCalendarGridView.b(max - 1);
                                if (!f4) {
                                    left = b5.getRight();
                                } else {
                                    left = b5.getLeft();
                                }
                            }
                            width = left;
                            a5 = max;
                        } else {
                            calendar.setTimeInMillis(longValue);
                            a5 = xVar.a() + (calendar.get(5) - 1);
                            View b6 = materialCalendarGridView.b(a5);
                            width = (b6.getWidth() / 2) + b6.getLeft();
                        }
                        if (longValue2 > item2.longValue()) {
                            if ((min + 1) % month.f3293d == 0) {
                                width2 = getWidth();
                            } else {
                                View b7 = materialCalendarGridView.b(min);
                                if (!f4) {
                                    width2 = b7.getRight();
                                } else {
                                    width2 = b7.getLeft();
                                }
                            }
                            a6 = min;
                        } else {
                            calendar.setTimeInMillis(longValue2);
                            a6 = xVar.a() + (calendar.get(5) - 1);
                            View b8 = materialCalendarGridView.b(a6);
                            width2 = (b8.getWidth() / 2) + b8.getLeft();
                        }
                        int itemId = (int) xVar.getItemId(a5);
                        int itemId2 = (int) xVar.getItemId(a6);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            x xVar2 = xVar;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View b9 = materialCalendarGridView.b(numColumns);
                            int top = ((Rect) cVar.f3311a.f926b).top + b9.getTop();
                            Iterator it2 = it;
                            int bottom = b9.getBottom() - ((Rect) cVar.f3311a.f926b).bottom;
                            if (!f4) {
                                if (numColumns > a5) {
                                    i6 = 0;
                                } else {
                                    i6 = width;
                                }
                                if (a6 > numColumns2) {
                                    i7 = getWidth();
                                } else {
                                    i7 = width2;
                                }
                            } else {
                                if (a6 > numColumns2) {
                                    i4 = 0;
                                } else {
                                    i4 = width2;
                                }
                                if (numColumns > a5) {
                                    i5 = getWidth();
                                } else {
                                    i5 = width;
                                }
                                int i9 = i5;
                                i6 = i4;
                                i7 = i9;
                            }
                            canvas.drawRect(i6, top, i7, bottom, cVar.f3318h);
                            itemId++;
                            materialCalendarGridView = this;
                            max = max;
                            xVar = xVar2;
                            it = it2;
                        }
                    } else {
                        materialCalendarGridView = this;
                        max = max;
                        xVar = xVar;
                        it = it;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z4, int i4, Rect rect) {
        int a5;
        if (z4) {
            if (i4 == 33) {
                a5 = ((x) super.getAdapter()).c();
            } else if (i4 == 130) {
                a5 = ((x) super.getAdapter()).a();
            } else {
                super.onFocusChanged(true, i4, rect);
                return;
            }
            setSelection(a5);
            return;
        }
        super.onFocusChanged(false, i4, rect);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (!super.onKeyDown(i4, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((x) super.getAdapter()).a()) {
            return true;
        }
        if (19 != i4) {
            return false;
        }
        setSelection(((x) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (!this.f3270b) {
            super.onMeasure(i4, i5);
            return;
        }
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i4) {
        if (i4 < ((x) super.getAdapter()).a()) {
            i4 = ((x) super.getAdapter()).a();
        }
        super.setSelection(i4);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3269a = g0.g(null);
        if (MaterialDatePicker.L(getContext(), 16843277)) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f3270b = MaterialDatePicker.L(getContext(), R.attr.nestedScrollable);
        y0.p(this, new m(3, this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter  reason: avoid collision after fix types in other method */
    public final ListAdapter getAdapter2() {
        return (x) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof x)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), x.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}