package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ListPopupWindow implements g.h0 {
    public static final Method A;
    public static final Method B;

    /* renamed from: a  reason: collision with root package name */
    public final Context f568a;

    /* renamed from: b  reason: collision with root package name */
    public ListAdapter f569b;

    /* renamed from: c  reason: collision with root package name */
    public u1 f570c;

    /* renamed from: d  reason: collision with root package name */
    public final int f571d;

    /* renamed from: e  reason: collision with root package name */
    public int f572e;

    /* renamed from: f  reason: collision with root package name */
    public int f573f;

    /* renamed from: g  reason: collision with root package name */
    public int f574g;

    /* renamed from: h  reason: collision with root package name */
    public final int f575h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f576i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f577j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f578k;

    /* renamed from: l  reason: collision with root package name */
    public int f579l;

    /* renamed from: m  reason: collision with root package name */
    public final int f580m;

    /* renamed from: n  reason: collision with root package name */
    public c2 f581n;

    /* renamed from: o  reason: collision with root package name */
    public View f582o;

    /* renamed from: p  reason: collision with root package name */
    public AdapterView.OnItemClickListener f583p;

    /* renamed from: q  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f584q;

    /* renamed from: r  reason: collision with root package name */
    public final y1 f585r;

    /* renamed from: s  reason: collision with root package name */
    public final e2 f586s;

    /* renamed from: t  reason: collision with root package name */
    public final d2 f587t;

    /* renamed from: u  reason: collision with root package name */
    public final y1 f588u;

    /* renamed from: v  reason: collision with root package name */
    public final Handler f589v;

    /* renamed from: w  reason: collision with root package name */
    public final Rect f590w;

    /* renamed from: x  reason: collision with root package name */
    public Rect f591x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f592y;

    /* renamed from: z  reason: collision with root package name */
    public final PopupWindow f593z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                A = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public u1 a(Context context, boolean z4) {
        return new u1(context, z4);
    }

    @Override // g.h0
    public final boolean b() {
        return this.f593z.isShowing();
    }

    public final void c(int i4) {
        this.f573f = i4;
    }

    public final int d() {
        return this.f573f;
    }

    @Override // g.h0
    public final void dismiss() {
        PopupWindow popupWindow = this.f593z;
        popupWindow.dismiss();
        popupWindow.setContentView(null);
        this.f570c = null;
        this.f589v.removeCallbacks(this.f585r);
    }

    @Override // g.h0
    public final void f() {
        int i4;
        boolean z4;
        int makeMeasureSpec;
        int i5;
        int i6;
        boolean z5;
        u1 u1Var;
        int i7;
        int i8;
        u1 u1Var2 = this.f570c;
        PopupWindow popupWindow = this.f593z;
        Context context = this.f568a;
        int i9 = 0;
        if (u1Var2 == null) {
            u1 a5 = a(context, !this.f592y);
            this.f570c = a5;
            a5.setAdapter(this.f569b);
            this.f570c.setOnItemClickListener(this.f583p);
            this.f570c.setFocusable(true);
            this.f570c.setFocusableInTouchMode(true);
            this.f570c.setOnItemSelectedListener(new z1(0, this));
            this.f570c.setOnScrollListener(this.f587t);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f584q;
            if (onItemSelectedListener != null) {
                this.f570c.setOnItemSelectedListener(onItemSelectedListener);
            }
            popupWindow.setContentView(this.f570c);
        } else {
            ViewGroup viewGroup = (ViewGroup) popupWindow.getContentView();
        }
        Drawable background = popupWindow.getBackground();
        Rect rect = this.f590w;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i4 = rect.bottom + i10;
            if (!this.f576i) {
                this.f574g = -i10;
            }
        } else {
            rect.setEmpty();
            i4 = 0;
        }
        if (popupWindow.getInputMethodMode() == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        int a6 = a2.a(popupWindow, this.f582o, this.f574g, z4);
        int i11 = this.f571d;
        if (i11 == -1) {
            i6 = a6 + i4;
        } else {
            int i12 = this.f572e;
            if (i12 != -2) {
                if (i12 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int a7 = this.f570c.a(makeMeasureSpec, a6);
            if (a7 > 0) {
                i5 = this.f570c.getPaddingBottom() + this.f570c.getPaddingTop() + i4;
            } else {
                i5 = 0;
            }
            i6 = a7 + i5;
        }
        if (this.f593z.getInputMethodMode() == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        androidx.core.widget.o.d(popupWindow, this.f575h);
        if (popupWindow.isShowing()) {
            View view = this.f582o;
            WeakHashMap weakHashMap = i0.y0.f4999a;
            if (!i0.j0.b(view)) {
                return;
            }
            int i13 = this.f572e;
            if (i13 == -1) {
                i13 = -1;
            } else if (i13 == -2) {
                i13 = this.f582o.getWidth();
            }
            if (i11 == -1) {
                if (z5) {
                    i11 = i6;
                } else {
                    i11 = -1;
                }
                int i14 = this.f572e;
                if (z5) {
                    if (i14 == -1) {
                        i8 = -1;
                    } else {
                        i8 = 0;
                    }
                    popupWindow.setWidth(i8);
                    popupWindow.setHeight(0);
                } else {
                    if (i14 == -1) {
                        i9 = -1;
                    }
                    popupWindow.setWidth(i9);
                    popupWindow.setHeight(-1);
                }
            } else if (i11 == -2) {
                i11 = i6;
            }
            popupWindow.setOutsideTouchable(true);
            View view2 = this.f582o;
            int i15 = this.f573f;
            int i16 = this.f574g;
            if (i13 < 0) {
                i13 = -1;
            }
            if (i11 < 0) {
                i7 = -1;
            } else {
                i7 = i11;
            }
            popupWindow.update(view2, i15, i16, i13, i7);
            return;
        }
        int i17 = this.f572e;
        if (i17 == -1) {
            i17 = -1;
        } else if (i17 == -2) {
            i17 = this.f582o.getWidth();
        }
        if (i11 == -1) {
            i11 = -1;
        } else if (i11 == -2) {
            i11 = i6;
        }
        popupWindow.setWidth(i17);
        popupWindow.setHeight(i11);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = A;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            b2.b(popupWindow, true);
        }
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(this.f586s);
        if (this.f578k) {
            androidx.core.widget.o.c(popupWindow, this.f577j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = B;
            if (method2 != null) {
                try {
                    method2.invoke(popupWindow, this.f591x);
                } catch (Exception e4) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e4);
                }
            }
        } else {
            b2.a(popupWindow, this.f591x);
        }
        androidx.core.widget.n.a(popupWindow, this.f582o, this.f573f, this.f574g, this.f579l);
        this.f570c.setSelection(-1);
        if ((!this.f592y || this.f570c.isInTouchMode()) && (u1Var = this.f570c) != null) {
            u1Var.setListSelectionHidden(true);
            u1Var.requestLayout();
        }
        if (!this.f592y) {
            this.f589v.post(this.f588u);
        }
    }

    public final int g() {
        if (this.f576i) {
            return this.f574g;
        }
        return 0;
    }

    public final Drawable h() {
        return this.f593z.getBackground();
    }

    @Override // g.h0
    public final u1 k() {
        return this.f570c;
    }

    public final void l(Drawable drawable) {
        this.f593z.setBackgroundDrawable(drawable);
    }

    public final void n(int i4) {
        this.f574g = i4;
        this.f576i = true;
    }

    public void o(ListAdapter listAdapter) {
        c2 c2Var = this.f581n;
        if (c2Var == null) {
            this.f581n = new c2(0, this);
        } else {
            ListAdapter listAdapter2 = this.f569b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(c2Var);
            }
        }
        this.f569b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f581n);
        }
        u1 u1Var = this.f570c;
        if (u1Var != null) {
            u1Var.setAdapter(this.f569b);
        }
    }

    public final void q(int i4) {
        Drawable background = this.f593z.getBackground();
        if (background != null) {
            Rect rect = this.f590w;
            background.getPadding(rect);
            this.f572e = rect.left + rect.right + i4;
            return;
        }
        this.f572e = i4;
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        this(context, attributeSet, i4, 0);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.widget.AppCompatPopupWindow, android.widget.PopupWindow] */
    public ListPopupWindow(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f571d = -2;
        this.f572e = -2;
        this.f575h = 1002;
        this.f579l = 0;
        this.f580m = Integer.MAX_VALUE;
        this.f585r = new y1(this, 2);
        this.f586s = new e2(0, this);
        this.f587t = new d2(this);
        this.f588u = new y1(this, 1);
        this.f590w = new Rect();
        this.f568a = context;
        this.f589v = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f2559q, i4, i5);
        this.f573f = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f574g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f576i = true;
        }
        obtainStyledAttributes.recycle();
        ?? popupWindow = new PopupWindow(context, attributeSet, i4, i5);
        popupWindow.a(context, attributeSet, i4, i5);
        this.f593z = popupWindow;
        popupWindow.setInputMethodMode(1);
    }
}