package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public boolean B;
    public boolean C;
    public final ArrayList D;
    public final ArrayList E;
    public final int[] F;
    public final androidx.appcompat.app.c G;
    public ArrayList H;
    public final s3 I;
    public x3 J;
    public n K;
    public u3 L;
    public g.c0 M;
    public g.n N;
    public boolean O;
    public OnBackInvokedCallback P;
    public OnBackInvokedDispatcher Q;
    public boolean R;
    public final androidx.activity.k S;

    /* renamed from: a  reason: collision with root package name */
    public ActionMenuView f655a;

    /* renamed from: b  reason: collision with root package name */
    public AppCompatTextView f656b;

    /* renamed from: c  reason: collision with root package name */
    public AppCompatTextView f657c;

    /* renamed from: d  reason: collision with root package name */
    public AppCompatImageButton f658d;

    /* renamed from: e  reason: collision with root package name */
    public AppCompatImageView f659e;

    /* renamed from: f  reason: collision with root package name */
    public final Drawable f660f;

    /* renamed from: g  reason: collision with root package name */
    public final CharSequence f661g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatImageButton f662h;

    /* renamed from: i  reason: collision with root package name */
    public View f663i;

    /* renamed from: j  reason: collision with root package name */
    public Context f664j;

    /* renamed from: k  reason: collision with root package name */
    public int f665k;

    /* renamed from: l  reason: collision with root package name */
    public int f666l;

    /* renamed from: m  reason: collision with root package name */
    public int f667m;

    /* renamed from: n  reason: collision with root package name */
    public final int f668n;

    /* renamed from: o  reason: collision with root package name */
    public final int f669o;

    /* renamed from: p  reason: collision with root package name */
    public int f670p;

    /* renamed from: q  reason: collision with root package name */
    public int f671q;

    /* renamed from: r  reason: collision with root package name */
    public int f672r;

    /* renamed from: s  reason: collision with root package name */
    public int f673s;

    /* renamed from: t  reason: collision with root package name */
    public o2 f674t;

    /* renamed from: u  reason: collision with root package name */
    public int f675u;

    /* renamed from: v  reason: collision with root package name */
    public int f676v;

    /* renamed from: w  reason: collision with root package name */
    public final int f677w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f678x;

    /* renamed from: y  reason: collision with root package name */
    public CharSequence f679y;

    /* renamed from: z  reason: collision with root package name */
    public ColorStateList f680z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar$LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        public int f681b;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f681b = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public int f682c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f683d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f682c = parcel.readInt();
            this.f683d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f682c);
            parcel.writeInt(this.f683d ? 1 : 0);
        }
    }

    public Toolbar(@NonNull Context context) {
        this(context, null);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i4 = 0; i4 < menu.size(); i4++) {
            arrayList.add(menu.getItem(i4));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new f.l(getContext());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.Toolbar$LayoutParams, androidx.appcompat.app.ActionBar$LayoutParams, android.view.ViewGroup$MarginLayoutParams] */
    public static LayoutParams h() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.f681b = 0;
        marginLayoutParams.f177a = 8388627;
        return marginLayoutParams;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.Toolbar$LayoutParams, androidx.appcompat.app.ActionBar$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.widget.Toolbar$LayoutParams, androidx.appcompat.app.ActionBar$LayoutParams, android.view.ViewGroup$MarginLayoutParams] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.appcompat.widget.Toolbar$LayoutParams, androidx.appcompat.app.ActionBar$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.appcompat.widget.Toolbar$LayoutParams, androidx.appcompat.app.ActionBar$LayoutParams] */
    public static LayoutParams i(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            ?? actionBar$LayoutParams = new ActionBar$LayoutParams((ActionBar$LayoutParams) layoutParams2);
            actionBar$LayoutParams.f681b = 0;
            actionBar$LayoutParams.f681b = layoutParams2.f681b;
            return actionBar$LayoutParams;
        } else if (layoutParams instanceof ActionBar$LayoutParams) {
            ?? actionBar$LayoutParams2 = new ActionBar$LayoutParams((ActionBar$LayoutParams) layoutParams);
            actionBar$LayoutParams2.f681b = 0;
            return actionBar$LayoutParams2;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ?? actionBar$LayoutParams3 = new ActionBar$LayoutParams(marginLayoutParams);
            actionBar$LayoutParams3.f681b = 0;
            ((ViewGroup.MarginLayoutParams) actionBar$LayoutParams3).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) actionBar$LayoutParams3).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) actionBar$LayoutParams3).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) actionBar$LayoutParams3).bottomMargin = marginLayoutParams.bottomMargin;
            return actionBar$LayoutParams3;
        } else {
            ?? actionBar$LayoutParams4 = new ActionBar$LayoutParams(layoutParams);
            actionBar$LayoutParams4.f681b = 0;
            return actionBar$LayoutParams4;
        }
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return i0.p.b(marginLayoutParams) + i0.p.c(marginLayoutParams);
    }

    public static int m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i4, ArrayList arrayList) {
        boolean z4;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (i0.h0.d(this) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i0.h0.d(this));
        arrayList.clear();
        if (z4) {
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f681b == 0 && u(childAt) && j(layoutParams.f177a) == absoluteGravity) {
                    arrayList.add(childAt);
                }
            }
            return;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f681b == 0 && u(childAt2) && j(layoutParams2.f177a) == absoluteGravity) {
                arrayList.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams h4 = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (LayoutParams) layoutParams;
        h4.f681b = 1;
        if (!z4 || this.f663i == null) {
            addView(view, h4);
            return;
        }
        view.setLayoutParams(h4);
        this.E.add(view);
    }

    public final void c() {
        if (this.f662h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f662h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f660f);
            this.f662h.setContentDescription(this.f661g);
            LayoutParams h4 = h();
            h4.f177a = (this.f668n & 112) | 8388611;
            h4.f681b = 2;
            this.f662h.setLayoutParams(h4);
            this.f662h.setOnClickListener(new androidx.appcompat.app.b(2, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.o2, java.lang.Object] */
    public final void d() {
        if (this.f674t == null) {
            ?? obj = new Object();
            obj.f860a = 0;
            obj.f861b = 0;
            obj.f862c = Integer.MIN_VALUE;
            obj.f863d = Integer.MIN_VALUE;
            obj.f864e = 0;
            obj.f865f = 0;
            obj.f866g = false;
            obj.f867h = false;
            this.f674t = obj;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f655a;
        if (actionMenuView.f454p == null) {
            g.p pVar = (g.p) actionMenuView.getMenu();
            if (this.L == null) {
                this.L = new u3(this);
            }
            this.f655a.setExpandedActionViewsExclusive(true);
            pVar.b(this.L, this.f664j);
            v();
        }
    }

    public final void f() {
        if (this.f655a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f655a = actionMenuView;
            actionMenuView.setPopupTheme(this.f665k);
            this.f655a.setOnMenuItemClickListener(this.I);
            this.f655a.setMenuCallbacks(this.M, new s3(this));
            LayoutParams h4 = h();
            h4.f177a = (this.f668n & 112) | 8388613;
            this.f655a.setLayoutParams(h4);
            b(this.f655a, false);
        }
    }

    public final void g() {
        if (this.f658d == null) {
            this.f658d = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams h4 = h();
            h4.f177a = (this.f668n & 112) | 8388611;
            this.f658d.setLayoutParams(h4);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f662h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.f662h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        o2 o2Var = this.f674t;
        if (o2Var != null) {
            if (o2Var.f866g) {
                return o2Var.f860a;
            }
            return o2Var.f861b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i4 = this.f676v;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        o2 o2Var = this.f674t;
        if (o2Var != null) {
            return o2Var.f860a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        o2 o2Var = this.f674t;
        if (o2Var != null) {
            return o2Var.f861b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        o2 o2Var = this.f674t;
        if (o2Var != null) {
            if (o2Var.f866g) {
                return o2Var.f861b;
            }
            return o2Var.f860a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i4 = this.f675u;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        g.p pVar;
        ActionMenuView actionMenuView = this.f655a;
        if (actionMenuView != null && (pVar = actionMenuView.f454p) != null && pVar.hasVisibleItems()) {
            return Math.max(getContentInsetEnd(), Math.max(this.f676v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (i0.h0.d(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (i0.h0.d(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f675u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f659e;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f659e;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f655a.getMenu();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f172d})
    public View getNavButtonView() {
        return this.f658d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f658d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.f658d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public n getOuterActionMenuPresenter() {
        return this.K;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        e();
        return this.f655a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f664j;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.f665k;
    }

    public CharSequence getSubtitle() {
        return this.f679y;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f172d})
    public final TextView getSubtitleTextView() {
        return this.f657c;
    }

    public CharSequence getTitle() {
        return this.f678x;
    }

    public int getTitleMarginBottom() {
        return this.f673s;
    }

    public int getTitleMarginEnd() {
        return this.f671q;
    }

    public int getTitleMarginStart() {
        return this.f670p;
    }

    public int getTitleMarginTop() {
        return this.f672r;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f172d})
    public final TextView getTitleTextView() {
        return this.f656b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.appcompat.widget.x3] */
    @RestrictTo({RestrictTo.Scope.f171c})
    public l1 getWrapper() {
        boolean z4;
        Drawable drawable;
        if (this.J == null) {
            ?? obj = new Object();
            obj.f964o = 0;
            obj.f950a = this;
            obj.f958i = getTitle();
            obj.f959j = getSubtitle();
            if (obj.f958i != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            obj.f957h = z4;
            obj.f956g = getNavigationIcon();
            String str = null;
            q3 f4 = q3.f(getContext(), null, c.a.f2543a, R.attr.actionBarStyle, 0);
            obj.f965p = f4.b(15);
            TypedArray typedArray = f4.f879b;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                obj.f957h = true;
                obj.f958i = text;
                if ((obj.f951b & 8) != 0) {
                    Toolbar toolbar = obj.f950a;
                    toolbar.setTitle(text);
                    if (obj.f957h) {
                        i0.y0.q(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                obj.f959j = text2;
                if ((obj.f951b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable b5 = f4.b(20);
            if (b5 != null) {
                obj.f955f = b5;
                obj.c();
            }
            Drawable b6 = f4.b(17);
            if (b6 != null) {
                obj.f954e = b6;
                obj.c();
            }
            if (obj.f956g == null && (drawable = obj.f965p) != null) {
                obj.f956g = drawable;
                int i4 = obj.f951b & 4;
                Toolbar toolbar2 = obj.f950a;
                if (i4 != 0) {
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            obj.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = obj.f953d;
                if (view != null && (obj.f951b & 16) != 0) {
                    removeView(view);
                }
                obj.f953d = inflate;
                if (inflate != null && (obj.f951b & 16) != 0) {
                    addView(inflate);
                }
                obj.a(obj.f951b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                setTitleTextAppearance(getContext(), resourceId2);
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                setSubtitleTextAppearance(getContext(), resourceId3);
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            f4.g();
            if (R.string.abc_action_bar_up_description != obj.f964o) {
                obj.f964o = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i5 = obj.f964o;
                    if (i5 != 0) {
                        str = getContext().getString(i5);
                    }
                    obj.f960k = str;
                    obj.b();
                }
            }
            obj.f960k = getNavigationContentDescription();
            setNavigationOnClickListener(new d(obj));
            this.J = obj;
        }
        return this.J;
    }

    public final int j(int i4) {
        WeakHashMap weakHashMap = i0.y0.f4999a;
        int d4 = i0.h0.d(this);
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, d4) & 7;
        if (absoluteGravity != 1 && absoluteGravity != 3 && absoluteGravity != 5) {
            if (d4 != 1) {
                return 3;
            }
            return 5;
        }
        return absoluteGravity;
    }

    public final int k(int i4, View view) {
        int i5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 > 0) {
            i5 = (measuredHeight - i4) / 2;
        } else {
            i5 = 0;
        }
        int i6 = layoutParams.f177a & 112;
        if (i6 != 16 && i6 != 48 && i6 != 80) {
            i6 = this.f677w & 112;
        }
        if (i6 != 48) {
            if (i6 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i7 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i7 < i8) {
                    i7 = i8;
                } else {
                    int i9 = (((height - paddingBottom) - measuredHeight) - i7) - paddingTop;
                    int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (i9 < i10) {
                        i7 = Math.max(0, i7 - (i10 - i9));
                    }
                }
                return paddingTop + i7;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i5;
        }
        return getPaddingTop() - i5;
    }

    public void n(int i4) {
        getMenuInflater().inflate(i4, getMenu());
    }

    public final void o() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = ((CopyOnWriteArrayList) this.G.f193b).iterator();
        if (!it2.hasNext()) {
            ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
            currentMenuItems2.removeAll(currentMenuItems);
            this.H = currentMenuItems2;
            return;
        }
        androidx.activity.j.f(it2.next());
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.S);
        v();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0289 A[LOOP:0: B:109:0x0287->B:110:0x0289, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a5 A[LOOP:1: B:112:0x02a3->B:113:0x02a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c4 A[LOOP:2: B:115:0x02c2->B:116:0x02c4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0312 A[LOOP:3: B:124:0x0310->B:125:0x0312, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0213  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean a5 = e4.a(this);
        int i13 = !a5 ? 1 : 0;
        int i14 = 0;
        if (u(this.f658d)) {
            t(this.f658d, i4, 0, i5, this.f669o);
            i6 = l(this.f658d) + this.f658d.getMeasuredWidth();
            i7 = Math.max(0, m(this.f658d) + this.f658d.getMeasuredHeight());
            i8 = View.combineMeasuredStates(0, this.f658d.getMeasuredState());
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (u(this.f662h)) {
            t(this.f662h, i4, 0, i5, this.f669o);
            i6 = l(this.f662h) + this.f662h.getMeasuredWidth();
            i7 = Math.max(i7, m(this.f662h) + this.f662h.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f662h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i6);
        int max2 = Math.max(0, currentContentInsetStart - i6);
        int[] iArr = this.F;
        iArr[a5 ? 1 : 0] = max2;
        if (u(this.f655a)) {
            t(this.f655a, i4, max, i5, this.f669o);
            i9 = l(this.f655a) + this.f655a.getMeasuredWidth();
            i7 = Math.max(i7, m(this.f655a) + this.f655a.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f655a.getMeasuredState());
        } else {
            i9 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i9);
        iArr[i13] = Math.max(0, currentContentInsetEnd - i9);
        if (u(this.f663i)) {
            max3 += s(this.f663i, i4, max3, i5, 0, iArr);
            i7 = Math.max(i7, m(this.f663i) + this.f663i.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f663i.getMeasuredState());
        }
        if (u(this.f659e)) {
            max3 += s(this.f659e, i4, max3, i5, 0, iArr);
            i7 = Math.max(i7, m(this.f659e) + this.f659e.getMeasuredHeight());
            i8 = View.combineMeasuredStates(i8, this.f659e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (((LayoutParams) childAt.getLayoutParams()).f681b == 0 && u(childAt)) {
                max3 += s(childAt, i4, max3, i5, 0, iArr);
                i7 = Math.max(i7, m(childAt) + childAt.getMeasuredHeight());
                i8 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
            }
        }
        int i16 = this.f672r + this.f673s;
        int i17 = this.f670p + this.f671q;
        if (u(this.f656b)) {
            s(this.f656b, i4, max3 + i17, i5, i16, iArr);
            int l4 = l(this.f656b) + this.f656b.getMeasuredWidth();
            i10 = m(this.f656b) + this.f656b.getMeasuredHeight();
            i11 = View.combineMeasuredStates(i8, this.f656b.getMeasuredState());
            i12 = l4;
        } else {
            i10 = 0;
            i11 = i8;
            i12 = 0;
        }
        if (u(this.f657c)) {
            i12 = Math.max(i12, s(this.f657c, i4, max3 + i17, i5, i10 + i16, iArr));
            i10 += m(this.f657c) + this.f657c.getMeasuredHeight();
            i11 = View.combineMeasuredStates(i11, this.f657c.getMeasuredState());
        }
        int max4 = Math.max(i7, i10);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max4;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + max3 + i12, getSuggestedMinimumWidth()), i4, (-16777216) & i11);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i5, i11 << 16);
        if (this.O) {
            int childCount2 = getChildCount();
            for (int i18 = 0; i18 < childCount2; i18++) {
                View childAt2 = getChildAt(i18);
                if (!u(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i14);
        }
        i14 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i14);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        g.p pVar;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        ActionMenuView actionMenuView = this.f655a;
        if (actionMenuView != null) {
            pVar = actionMenuView.f454p;
        } else {
            pVar = null;
        }
        int i4 = savedState.f682c;
        if (i4 != 0 && this.L != null && pVar != null && (findItem = pVar.findItem(i4)) != null) {
            findItem.expandActionView();
        }
        if (savedState.f683d) {
            androidx.activity.k kVar = this.S;
            removeCallbacks(kVar);
            post(kVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        if (r1 != Integer.MIN_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
        r1 = r0.f865f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
        r0.f861b = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003a, code lost:
        if (r1 != Integer.MIN_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onRtlPropertiesChanged(int r3) {
        /*
            r2 = this;
            super.onRtlPropertiesChanged(r3)
            r2.d()
            androidx.appcompat.widget.o2 r0 = r2.f674t
            r1 = 1
            if (r3 != r1) goto Lc
            goto Ld
        Lc:
            r1 = 0
        Ld:
            boolean r3 = r0.f866g
            if (r1 != r3) goto L12
            goto L45
        L12:
            r0.f866g = r1
            boolean r3 = r0.f867h
            if (r3 == 0) goto L3d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == 0) goto L2f
            int r1 = r0.f863d
            if (r1 == r3) goto L21
            goto L23
        L21:
            int r1 = r0.f864e
        L23:
            r0.f860a = r1
            int r1 = r0.f862c
            if (r1 == r3) goto L2a
            goto L2c
        L2a:
            int r1 = r0.f865f
        L2c:
            r0.f861b = r1
            goto L45
        L2f:
            int r1 = r0.f862c
            if (r1 == r3) goto L34
            goto L36
        L34:
            int r1 = r0.f864e
        L36:
            r0.f860a = r1
            int r1 = r0.f863d
            if (r1 == r3) goto L2a
            goto L2c
        L3d:
            int r3 = r0.f864e
            r0.f860a = r3
            int r3 = r0.f865f
            r0.f861b = r3
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onRtlPropertiesChanged(int):void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, androidx.appcompat.widget.Toolbar$SavedState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z4;
        n nVar;
        g.r rVar;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        u3 u3Var = this.L;
        if (u3Var != null && (rVar = u3Var.f920b) != null) {
            absSavedState.f682c = rVar.f4722a;
        }
        ActionMenuView actionMenuView = this.f655a;
        if (actionMenuView != null && (nVar = actionMenuView.f458t) != null && nVar.k()) {
            z4 = true;
        } else {
            z4 = false;
        }
        absSavedState.f683d = z4;
        return absSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    public final boolean p(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public final int q(View view, int i4, int i5, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = Math.max(0, i6) + i4;
        iArr[0] = Math.max(0, -i6);
        int k4 = k(i5, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, k4, max + measuredWidth, view.getMeasuredHeight() + k4);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + max;
    }

    public final int r(View view, int i4, int i5, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int k4 = k(i5, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, k4, max, view.getMeasuredHeight() + k4);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    public final int s(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i9) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + max + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public void setBackInvokedCallbackEnabled(boolean z4) {
        if (this.R != z4) {
            this.R = z4;
            v();
        }
    }

    public void setCollapseContentDescription(@StringRes int i4) {
        setCollapseContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setCollapseIcon(@DrawableRes int i4) {
        setCollapseIcon(com.google.common.collect.c.t0(getContext(), i4));
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setCollapsible(boolean z4) {
        this.O = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f676v) {
            this.f676v = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f675u) {
            this.f675u = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i4, int i5) {
        d();
        o2 o2Var = this.f674t;
        o2Var.f867h = false;
        if (i4 != Integer.MIN_VALUE) {
            o2Var.f864e = i4;
            o2Var.f860a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            o2Var.f865f = i5;
            o2Var.f861b = i5;
        }
    }

    public void setContentInsetsRelative(int i4, int i5) {
        d();
        this.f674t.a(i4, i5);
    }

    public void setLogo(@DrawableRes int i4) {
        setLogo(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setLogoDescription(@StringRes int i4) {
        setLogoDescription(getContext().getText(i4));
    }

    @RestrictTo({RestrictTo.Scope.f169a})
    public void setMenu(g.p pVar, n nVar) {
        if (pVar == null && this.f655a == null) {
            return;
        }
        f();
        g.p pVar2 = this.f655a.f454p;
        if (pVar2 == pVar) {
            return;
        }
        if (pVar2 != null) {
            pVar2.r(this.K);
            pVar2.r(this.L);
        }
        if (this.L == null) {
            this.L = new u3(this);
        }
        nVar.f846r = true;
        if (pVar != null) {
            pVar.b(nVar, this.f664j);
            pVar.b(this.L, this.f664j);
        } else {
            nVar.l(this.f664j, null);
            this.L.l(this.f664j, null);
            nVar.m(true);
            this.L.m(true);
        }
        this.f655a.setPopupTheme(this.f665k);
        this.f655a.setPresenter(nVar);
        this.K = nVar;
        v();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setMenuCallbacks(g.c0 c0Var, g.n nVar) {
        this.M = c0Var;
        this.N = nVar;
        ActionMenuView actionMenuView = this.f655a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(c0Var, nVar);
        }
    }

    public void setNavigationContentDescription(@StringRes int i4) {
        setNavigationContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setNavigationIcon(@DrawableRes int i4) {
        setNavigationIcon(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f658d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(v3 v3Var) {
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        e();
        this.f655a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i4) {
        if (this.f665k != i4) {
            this.f665k = i4;
            if (i4 == 0) {
                this.f664j = getContext();
            } else {
                this.f664j = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setSubtitle(@StringRes int i4) {
        setSubtitle(getContext().getText(i4));
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i4) {
        this.f667m = i4;
        AppCompatTextView appCompatTextView = this.f657c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i4);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i4) {
        setSubtitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setTitle(@StringRes int i4) {
        setTitle(getContext().getText(i4));
    }

    public void setTitleMargin(int i4, int i5, int i6, int i7) {
        this.f670p = i4;
        this.f672r = i5;
        this.f671q = i6;
        this.f673s = i7;
        requestLayout();
    }

    public void setTitleMarginBottom(int i4) {
        this.f673s = i4;
        requestLayout();
    }

    public void setTitleMarginEnd(int i4) {
        this.f671q = i4;
        requestLayout();
    }

    public void setTitleMarginStart(int i4) {
        this.f670p = i4;
        requestLayout();
    }

    public void setTitleMarginTop(int i4) {
        this.f672r = i4;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i4) {
        this.f666l = i4;
        AppCompatTextView appCompatTextView = this.f656b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i4);
        }
    }

    public void setTitleTextColor(@ColorInt int i4) {
        setTitleTextColor(ColorStateList.valueOf(i4));
    }

    public final void t(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r4.R != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 < r1) goto L53
            android.window.OnBackInvokedDispatcher r0 = androidx.appcompat.widget.t3.a(r4)
            androidx.appcompat.widget.u3 r1 = r4.L
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L16
            g.r r1 = r1.f920b
            if (r1 == 0) goto L16
            r1 = r3
            goto L17
        L16:
            r1 = r2
        L17:
            if (r1 == 0) goto L28
            if (r0 == 0) goto L28
            java.util.WeakHashMap r1 = i0.y0.f4999a
            boolean r1 = i0.j0.b(r4)
            if (r1 == 0) goto L28
            boolean r1 = r4.R
            if (r1 == 0) goto L28
            goto L29
        L28:
            r3 = r2
        L29:
            if (r3 == 0) goto L46
            android.window.OnBackInvokedDispatcher r1 = r4.Q
            if (r1 != 0) goto L46
            android.window.OnBackInvokedCallback r1 = r4.P
            if (r1 != 0) goto L3e
            androidx.appcompat.widget.r3 r1 = new androidx.appcompat.widget.r3
            r1.<init>(r4, r2)
            android.window.OnBackInvokedCallback r1 = androidx.appcompat.widget.t3.b(r1)
            r4.P = r1
        L3e:
            android.window.OnBackInvokedCallback r1 = r4.P
            androidx.appcompat.widget.t3.c(r0, r1)
        L43:
            r4.Q = r0
            goto L53
        L46:
            if (r3 != 0) goto L53
            android.window.OnBackInvokedDispatcher r0 = r4.Q
            if (r0 == 0) goto L53
            android.window.OnBackInvokedCallback r1 = r4.P
            androidx.appcompat.widget.t3.d(r0, r1)
            r0 = 0
            goto L43
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.v():void");
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        AppCompatImageButton appCompatImageButton = this.f662h;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            c();
            this.f662h.setImageDrawable(drawable);
            return;
        }
        AppCompatImageButton appCompatImageButton = this.f662h;
        if (appCompatImageButton != null) {
            appCompatImageButton.setImageDrawable(this.f660f);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f659e == null) {
                this.f659e = new AppCompatImageView(getContext());
            }
            if (!p(this.f659e)) {
                b(this.f659e, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f659e;
            if (appCompatImageView != null && p(appCompatImageView)) {
                removeView(this.f659e);
                this.E.remove(this.f659e);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f659e;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f659e == null) {
            this.f659e = new AppCompatImageView(getContext());
        }
        AppCompatImageView appCompatImageView = this.f659e;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        AppCompatImageButton appCompatImageButton = this.f658d;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            com.google.common.collect.c.V1(this.f658d, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            g();
            if (!p(this.f658d)) {
                b(this.f658d, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.f658d;
            if (appCompatImageButton != null && p(appCompatImageButton)) {
                removeView(this.f658d);
                this.E.remove(this.f658d);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.f658d;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f657c;
            if (appCompatTextView != null && p(appCompatTextView)) {
                removeView(this.f657c);
                this.E.remove(this.f657c);
            }
        } else {
            if (this.f657c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f657c = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f657c.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f667m;
                if (i4 != 0) {
                    this.f657c.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f657c.setTextColor(colorStateList);
                }
            }
            if (!p(this.f657c)) {
                b(this.f657c, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f657c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f679y = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.A = colorStateList;
        AppCompatTextView appCompatTextView = this.f657c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f656b;
            if (appCompatTextView != null && p(appCompatTextView)) {
                removeView(this.f656b);
                this.E.remove(this.f656b);
            }
        } else {
            if (this.f656b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f656b = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f656b.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f666l;
                if (i4 != 0) {
                    this.f656b.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f680z;
                if (colorStateList != null) {
                    this.f656b.setTextColor(colorStateList);
                }
            }
            if (!p(this.f656b)) {
                b(this.f656b, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f656b;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f678x = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f680z = colorStateList;
        AppCompatTextView appCompatTextView = this.f656b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f677w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new androidx.appcompat.app.c(new r3(this, 1));
        this.H = new ArrayList();
        this.I = new s3(this);
        this.S = new androidx.activity.k(3, this);
        Context context2 = getContext();
        int[] iArr = c.a.A;
        q3 f4 = q3.f(context2, attributeSet, iArr, i4, 0);
        i0.y0.o(this, context, iArr, attributeSet, f4.f879b, i4);
        TypedArray typedArray = f4.f879b;
        this.f666l = typedArray.getResourceId(28, 0);
        this.f667m = typedArray.getResourceId(19, 0);
        this.f677w = typedArray.getInteger(0, 8388627);
        this.f668n = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f673s = dimensionPixelOffset;
        this.f672r = dimensionPixelOffset;
        this.f671q = dimensionPixelOffset;
        this.f670p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f670p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f671q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f672r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f673s = dimensionPixelOffset5;
        }
        this.f669o = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        o2 o2Var = this.f674t;
        o2Var.f867h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            o2Var.f864e = dimensionPixelSize;
            o2Var.f860a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            o2Var.f865f = dimensionPixelSize2;
            o2Var.f861b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            o2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f675u = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f676v = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f660f = f4.b(4);
        this.f661g = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f664j = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable b5 = f4.b(16);
        if (b5 != null) {
            setNavigationIcon(b5);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable b6 = f4.b(11);
        if (b6 != null) {
            setLogo(b6);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(f4.a(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(f4.a(20));
        }
        if (typedArray.hasValue(14)) {
            n(typedArray.getResourceId(14, 0));
        }
        f4.g();
    }
}