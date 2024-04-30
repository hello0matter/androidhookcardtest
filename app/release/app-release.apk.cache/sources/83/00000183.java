package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.msphone.R;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class u1 extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f906a;

    /* renamed from: b  reason: collision with root package name */
    public int f907b;

    /* renamed from: c  reason: collision with root package name */
    public int f908c;

    /* renamed from: d  reason: collision with root package name */
    public int f909d;

    /* renamed from: e  reason: collision with root package name */
    public int f910e;

    /* renamed from: f  reason: collision with root package name */
    public int f911f;

    /* renamed from: g  reason: collision with root package name */
    public s1 f912g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f913h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f914i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f915j;

    /* renamed from: k  reason: collision with root package name */
    public androidx.core.widget.h f916k;

    /* renamed from: l  reason: collision with root package name */
    public androidx.activity.k f917l;

    public u1(Context context, boolean z4) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f906a = new Rect();
        this.f907b = 0;
        this.f908c = 0;
        this.f909d = 0;
        this.f910e = 0;
        this.f914i = z4;
        setCacheColorHint(0);
    }

    public final int a(int i4, int i5) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i6 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i6;
        }
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        int i7 = 0;
        View view = null;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            if (i9 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i4, makeMeasureSpec);
            view.forceLayout();
            if (i8 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i5) {
                return i5;
            }
        }
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0147 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u1.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f906a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f917l != null) {
            return;
        }
        super.drawableStateChanged();
        s1 s1Var = this.f912g;
        if (s1Var != null) {
            s1Var.f893b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f915j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f914i || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f914i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f914i || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f914i && this.f913h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f917l = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f917l == null) {
            androidx.activity.k kVar = new androidx.activity.k(2, this);
            this.f917l = kVar;
            post(kVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i4 >= 30 && q1.f876d) {
                        try {
                            q1.f873a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                            q1.f874b.invoke(this, Integer.valueOf(pointToPosition));
                            q1.f875c.invoke(this, Integer.valueOf(pointToPosition));
                        } catch (IllegalAccessException | InvocationTargetException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f915j && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f911f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.activity.k kVar = this.f917l;
        if (kVar != null) {
            u1 u1Var = (u1) kVar.f106b;
            u1Var.f917l = null;
            u1Var.removeCallbacks(kVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z4) {
        this.f913h = z4;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.s1, d.c] */
    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        s1 s1Var;
        if (drawable != null) {
            ?? cVar = new d.c(drawable);
            cVar.f893b = true;
            s1Var = cVar;
        } else {
            s1Var = null;
        }
        this.f912g = s1Var;
        super.setSelector(s1Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f907b = rect.left;
        this.f908c = rect.top;
        this.f909d = rect.right;
        this.f910e = rect.bottom;
    }
}