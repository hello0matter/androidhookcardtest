package com.google.android.material.search;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.s2;
import androidx.appcompat.widget.v3;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.i0;
import com.google.android.material.internal.n0;
import com.google.android.material.internal.z;
import i0.g0;
import i0.g2;
import i0.m0;
import i0.w;
import i0.y0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends FrameLayout implements androidx.coordinatorlayout.widget.a, f2.b {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public TransitionState B;
    public HashMap C;

    /* renamed from: a  reason: collision with root package name */
    public final View f3742a;

    /* renamed from: b  reason: collision with root package name */
    public final ClippableRoundedCornerLayout f3743b;

    /* renamed from: c  reason: collision with root package name */
    public final View f3744c;

    /* renamed from: d  reason: collision with root package name */
    public final View f3745d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f3746e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f3747f;

    /* renamed from: g  reason: collision with root package name */
    public final MaterialToolbar f3748g;

    /* renamed from: h  reason: collision with root package name */
    public final Toolbar f3749h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f3750i;

    /* renamed from: j  reason: collision with root package name */
    public final EditText f3751j;

    /* renamed from: k  reason: collision with root package name */
    public final ImageButton f3752k;

    /* renamed from: l  reason: collision with root package name */
    public final View f3753l;

    /* renamed from: m  reason: collision with root package name */
    public final TouchObserverFrameLayout f3754m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f3755n;

    /* renamed from: o  reason: collision with root package name */
    public final p f3756o;

    /* renamed from: p  reason: collision with root package name */
    public final f2.f f3757p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f3758q;

    /* renamed from: r  reason: collision with root package name */
    public final b2.a f3759r;

    /* renamed from: s  reason: collision with root package name */
    public final LinkedHashSet f3760s;

    /* renamed from: t  reason: collision with root package name */
    public SearchBar f3761t;

    /* renamed from: u  reason: collision with root package name */
    public int f3762u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3763v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3764w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3765x;

    /* renamed from: y  reason: collision with root package name */
    public final int f3766y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3767z;

    /* loaded from: classes.dex */
    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            SearchView searchView = (SearchView) view;
            if (searchView.f3761t == null && (view2 instanceof SearchBar)) {
                searchView.setupWithSearchBar((SearchBar) view2);
                return false;
            }
            return false;
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public String f3768c;

        /* renamed from: d  reason: collision with root package name */
        public int f3769d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3768c = parcel.readString();
            this.f3769d = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f3768c);
            parcel.writeInt(this.f3769d);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class TransitionState {

        /* renamed from: a  reason: collision with root package name */
        public static final TransitionState f3770a;

        /* renamed from: b  reason: collision with root package name */
        public static final TransitionState f3771b;

        /* renamed from: c  reason: collision with root package name */
        public static final TransitionState f3772c;

        /* renamed from: d  reason: collision with root package name */
        public static final TransitionState f3773d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f3774e;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.android.material.search.SearchView$TransitionState] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.google.android.material.search.SearchView$TransitionState] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, com.google.android.material.search.SearchView$TransitionState] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, com.google.android.material.search.SearchView$TransitionState] */
        static {
            ?? r02 = new Enum("HIDING", 0);
            f3770a = r02;
            ?? r12 = new Enum("HIDDEN", 1);
            f3771b = r12;
            ?? r22 = new Enum("SHOWING", 2);
            f3772c = r22;
            ?? r32 = new Enum("SHOWN", 3);
            f3773d = r32;
            f3774e = new TransitionState[]{r02, r12, r22, r32};
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f3774e.clone();
        }
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ void e(SearchView searchView, g2 g2Var) {
        boolean z4;
        searchView.getClass();
        int d4 = g2Var.d();
        searchView.setUpStatusBarSpacer(d4);
        if (!searchView.A) {
            if (d4 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            searchView.setStatusBarSpacerEnabledInternal(z4);
        }
    }

    @Nullable
    private Window getActivityWindow() {
        Activity activity;
        Context context = getContext();
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                activity = null;
                break;
            }
        }
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f3761t;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    @Px
    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z4) {
        this.f3745d.setVisibility(z4 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f4) {
        View view;
        b2.a aVar = this.f3759r;
        if (aVar == null || (view = this.f3744c) == null) {
            return;
        }
        view.setBackgroundColor(aVar.a(this.f3766y, f4));
    }

    private void setUpHeaderLayout(int i4) {
        if (i4 != -1) {
            LayoutInflater from = LayoutInflater.from(getContext());
            FrameLayout frameLayout = this.f3746e;
            frameLayout.addView(from.inflate(i4, (ViewGroup) frameLayout, false));
            frameLayout.setVisibility(0);
        }
    }

    private void setUpStatusBarSpacer(@Px int i4) {
        View view = this.f3745d;
        if (view.getLayoutParams().height != i4) {
            view.getLayoutParams().height = i4;
            view.requestLayout();
        }
    }

    @Override // f2.b
    public final void a() {
        if (i()) {
            return;
        }
        p pVar = this.f3756o;
        f2.i iVar = pVar.f3807m;
        androidx.activity.b bVar = iVar.f4556f;
        iVar.f4556f = null;
        if (Build.VERSION.SDK_INT >= 34 && this.f3761t != null && bVar != null) {
            long totalDuration = pVar.j().getTotalDuration();
            SearchBar searchBar = pVar.f3809o;
            f2.i iVar2 = pVar.f3807m;
            AnimatorSet b5 = iVar2.b(searchBar);
            b5.setDuration(totalDuration);
            b5.start();
            iVar2.f4567i = 0.0f;
            iVar2.f4568j = null;
            iVar2.f4569k = null;
            if (pVar.f3808n != null) {
                pVar.c(false).start();
                pVar.f3808n.resume();
            }
            pVar.f3808n = null;
            return;
        }
        g();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (this.f3755n) {
            this.f3754m.addView(view, i4, layoutParams);
        } else {
            super.addView(view, i4, layoutParams);
        }
    }

    @Override // f2.b
    public final void b(androidx.activity.b bVar) {
        if (!i() && this.f3761t != null) {
            p pVar = this.f3756o;
            SearchBar searchBar = pVar.f3809o;
            f2.i iVar = pVar.f3807m;
            iVar.f4556f = bVar;
            View view = iVar.f4552b;
            iVar.f4568j = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (searchBar != null) {
                iVar.f4569k = n0.a(view, searchBar);
            }
            iVar.f4567i = bVar.f92b;
        }
    }

    @Override // f2.b
    public final void c(androidx.activity.b bVar) {
        boolean z4;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout;
        if (!i() && this.f3761t != null && Build.VERSION.SDK_INT >= 34) {
            p pVar = this.f3756o;
            pVar.getClass();
            float f4 = bVar.f93c;
            if (f4 > 0.0f) {
                SearchBar searchBar = pVar.f3809o;
                float cornerSize = searchBar.getCornerSize();
                f2.i iVar = pVar.f3807m;
                if (iVar.f4556f == null) {
                    Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
                }
                androidx.activity.b bVar2 = iVar.f4556f;
                iVar.f4556f = bVar;
                if (bVar2 != null) {
                    if (searchBar.getVisibility() != 4) {
                        searchBar.setVisibility(4);
                    }
                    int i4 = 1;
                    if (bVar.f94d == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    View view = iVar.f4552b;
                    float width = view.getWidth();
                    float height = view.getHeight();
                    if (width > 0.0f && height > 0.0f) {
                        float a5 = p1.a.a(1.0f, 0.9f, f4);
                        float f5 = iVar.f4565g;
                        float a6 = p1.a.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - f5), f4);
                        if (!z4) {
                            i4 = -1;
                        }
                        float min = Math.min(Math.max(0.0f, ((height - (a5 * height)) / 2.0f) - f5), iVar.f4566h);
                        float f6 = bVar.f92b - iVar.f4567i;
                        float signum = Math.signum(f6);
                        view.setScaleX(a5);
                        view.setScaleY(a5);
                        view.setTranslationX(a6 * i4);
                        view.setTranslationY(p1.a.a(0.0f, min, Math.abs(f6) / height) * signum);
                        if (view instanceof ClippableRoundedCornerLayout) {
                            ((ClippableRoundedCornerLayout) view).a(clippableRoundedCornerLayout.getLeft(), clippableRoundedCornerLayout.getTop(), clippableRoundedCornerLayout.getRight(), clippableRoundedCornerLayout.getBottom(), p1.a.a(iVar.c(), cornerSize, f4));
                        }
                    }
                }
                AnimatorSet animatorSet = pVar.f3808n;
                if (animatorSet != null) {
                    animatorSet.setCurrentPlayTime(f4 * ((float) animatorSet.getDuration()));
                    return;
                }
                SearchView searchView = pVar.f3795a;
                if (searchView.h()) {
                    searchView.f();
                }
                if (searchView.f3763v) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    pVar.b(animatorSet2);
                    animatorSet2.setDuration(250L);
                    animatorSet2.setInterpolator(z.a(false, p1.a.f6129b));
                    pVar.f3808n = animatorSet2;
                    animatorSet2.start();
                    pVar.f3808n.pause();
                }
            }
        }
    }

    @Override // f2.b
    public final void d() {
        if (!i() && this.f3761t != null && Build.VERSION.SDK_INT >= 34) {
            p pVar = this.f3756o;
            SearchBar searchBar = pVar.f3809o;
            f2.i iVar = pVar.f3807m;
            if (iVar.a() != null) {
                AnimatorSet b5 = iVar.b(searchBar);
                View view = iVar.f4552b;
                if (view instanceof ClippableRoundedCornerLayout) {
                    ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) view;
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), iVar.c());
                    ofFloat.addUpdateListener(new u1.b(1, clippableRoundedCornerLayout));
                    b5.playTogether(ofFloat);
                }
                b5.setDuration(iVar.f4555e);
                b5.start();
                iVar.f4567i = 0.0f;
                iVar.f4568j = null;
                iVar.f4569k = null;
            }
            AnimatorSet animatorSet = pVar.f3808n;
            if (animatorSet != null) {
                animatorSet.reverse();
            }
            pVar.f3808n = null;
        }
    }

    public final void f() {
        this.f3751j.post(new f(this, 2));
    }

    public final void g() {
        if (!this.B.equals(TransitionState.f3771b) && !this.B.equals(TransitionState.f3770a)) {
            this.f3756o.j();
        }
    }

    @VisibleForTesting
    public f2.i getBackHelper() {
        return this.f3756o.f3807m;
    }

    @Override // androidx.coordinatorlayout.widget.a
    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.B;
    }

    @DrawableRes
    @RestrictTo({RestrictTo.Scope.f170b})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    @NonNull
    public EditText getEditText() {
        return this.f3751j;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f3751j.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f3750i;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.f3750i.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f3762u;
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f3751j.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f3748g;
    }

    public final boolean h() {
        return this.f3762u == 48;
    }

    public final boolean i() {
        return this.B.equals(TransitionState.f3771b) || this.B.equals(TransitionState.f3770a);
    }

    public final void j() {
        if (this.f3765x) {
            this.f3751j.postDelayed(new f(this, 1), 100L);
        }
    }

    public final void k(TransitionState transitionState, boolean z4) {
        f2.c cVar;
        if (this.B.equals(transitionState)) {
            return;
        }
        TransitionState transitionState2 = TransitionState.f3771b;
        TransitionState transitionState3 = TransitionState.f3773d;
        if (z4) {
            if (transitionState == transitionState3) {
                setModalForAccessibility(true);
            } else if (transitionState == transitionState2) {
                setModalForAccessibility(false);
            }
        }
        this.B = transitionState;
        Iterator it = new LinkedHashSet(this.f3760s).iterator();
        if (!it.hasNext()) {
            if (this.f3761t != null && this.f3758q) {
                boolean equals = transitionState.equals(transitionState3);
                f2.f fVar = this.f3757p;
                if (equals) {
                    f2.c cVar2 = fVar.f4560a;
                    if (cVar2 != null) {
                        cVar2.b(fVar.f4561b, fVar.f4562c, false);
                        return;
                    }
                    return;
                } else if (transitionState.equals(transitionState2) && (cVar = fVar.f4560a) != null) {
                    cVar.c(fVar.f4562c);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        androidx.activity.j.f(it.next());
        throw null;
    }

    public final void l() {
        if (!this.B.equals(TransitionState.f3773d)) {
            TransitionState transitionState = this.B;
            TransitionState transitionState2 = TransitionState.f3772c;
            if (!transitionState.equals(transitionState2)) {
                final p pVar = this.f3756o;
                SearchBar searchBar = pVar.f3809o;
                ClippableRoundedCornerLayout clippableRoundedCornerLayout = pVar.f3797c;
                SearchView searchView = pVar.f3795a;
                if (searchBar != null) {
                    if (searchView.h()) {
                        searchView.j();
                    }
                    searchView.setTransitionState(transitionState2);
                    Toolbar toolbar = pVar.f3801g;
                    Menu menu = toolbar.getMenu();
                    if (menu != null) {
                        menu.clear();
                    }
                    if (pVar.f3809o.getMenuResId() != -1 && searchView.f3764w) {
                        toolbar.n(pVar.f3809o.getMenuResId());
                        ActionMenuView a5 = i0.a(toolbar);
                        if (a5 != null) {
                            for (int i4 = 0; i4 < a5.getChildCount(); i4++) {
                                View childAt = a5.getChildAt(i4);
                                childAt.setClickable(false);
                                childAt.setFocusable(false);
                                childAt.setFocusableInTouchMode(false);
                            }
                        }
                        toolbar.setVisibility(0);
                    } else {
                        toolbar.setVisibility(8);
                    }
                    CharSequence text = pVar.f3809o.getText();
                    EditText editText = pVar.f3803i;
                    editText.setText(text);
                    editText.setSelection(editText.getText().length());
                    clippableRoundedCornerLayout.setVisibility(4);
                    clippableRoundedCornerLayout.post(new Runnable() { // from class: com.google.android.material.search.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i5 = r2;
                            p pVar2 = pVar;
                            switch (i5) {
                                case 0:
                                    AnimatorSet d4 = pVar2.d(true);
                                    d4.addListener(new l(pVar2));
                                    d4.start();
                                    return;
                                default:
                                    ClippableRoundedCornerLayout clippableRoundedCornerLayout2 = pVar2.f3797c;
                                    clippableRoundedCornerLayout2.setTranslationY(clippableRoundedCornerLayout2.getHeight());
                                    AnimatorSet h4 = pVar2.h(true);
                                    h4.addListener(new n(pVar2));
                                    h4.start();
                                    return;
                            }
                        }
                    });
                    return;
                }
                if (searchView.h()) {
                    searchView.postDelayed(new f(searchView, 3), 150L);
                }
                clippableRoundedCornerLayout.setVisibility(4);
                clippableRoundedCornerLayout.post(new Runnable() { // from class: com.google.android.material.search.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i5 = r2;
                        p pVar2 = pVar;
                        switch (i5) {
                            case 0:
                                AnimatorSet d4 = pVar2.d(true);
                                d4.addListener(new l(pVar2));
                                d4.start();
                                return;
                            default:
                                ClippableRoundedCornerLayout clippableRoundedCornerLayout2 = pVar2.f3797c;
                                clippableRoundedCornerLayout2.setTranslationY(clippableRoundedCornerLayout2.getHeight());
                                AnimatorSet h4 = pVar2.h(true);
                                h4.addListener(new n(pVar2));
                                h4.start();
                                return;
                        }
                    }
                });
            }
        }
    }

    public final void m(ViewGroup viewGroup, boolean z4) {
        int i4;
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt != this) {
                if (childAt.findViewById(this.f3743b.getId()) != null) {
                    m((ViewGroup) childAt, z4);
                } else {
                    if (!z4) {
                        HashMap hashMap = this.C;
                        if (hashMap != null && hashMap.containsKey(childAt)) {
                            i4 = ((Integer) this.C.get(childAt)).intValue();
                            WeakHashMap weakHashMap = y0.f4999a;
                        }
                    } else {
                        this.C.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap2 = y0.f4999a;
                        i4 = 4;
                    }
                    g0.s(childAt, i4);
                }
            }
        }
    }

    public final void n() {
        int i4;
        ImageButton b5 = i0.b(this.f3748g);
        if (b5 == null) {
            return;
        }
        if (this.f3743b.getVisibility() == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        Drawable e22 = com.google.common.collect.c.e2(b5.getDrawable());
        if (e22 instanceof d.d) {
            d.d dVar = (d.d) e22;
            float f4 = i4;
            if (dVar.f4246i != f4) {
                dVar.f4246i = f4;
                dVar.invalidateSelf();
            }
        }
        if (e22 instanceof com.google.android.material.internal.f) {
            ((com.google.android.material.internal.f) e22).a(i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.Q1(this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f3762u = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        boolean z4;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        setText(savedState.f3768c);
        if (savedState.f3769d == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        setVisible(z4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.search.SearchView$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        String charSequence;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        Editable text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        absSavedState.f3768c = charSequence;
        absSavedState.f3769d = this.f3743b.getVisibility();
        return absSavedState;
    }

    public void setAnimatedNavigationIcon(boolean z4) {
        this.f3763v = z4;
    }

    public void setAutoShowKeyboard(boolean z4) {
        this.f3765x = z4;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        setUpBackgroundViewElevationOverlay(f4);
    }

    public void setHint(@StringRes int i4) {
        this.f3751j.setHint(i4);
    }

    public void setMenuItemsAnimated(boolean z4) {
        this.f3764w = z4;
    }

    public void setModalForAccessibility(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z4) {
            this.C = new HashMap(viewGroup.getChildCount());
        }
        m(viewGroup, z4);
        if (z4) {
            return;
        }
        this.C = null;
    }

    public void setOnMenuItemClickListener(@Nullable v3 v3Var) {
        this.f3748g.setOnMenuItemClickListener(v3Var);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        TextView textView = this.f3750i;
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public void setStatusBarSpacerEnabled(boolean z4) {
        this.A = true;
        setStatusBarSpacerEnabledInternal(z4);
    }

    public void setText(@StringRes int i4) {
        this.f3751j.setText(i4);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z4) {
        this.f3748g.setTouchscreenBlocksFocus(z4);
    }

    public void setTransitionState(@NonNull TransitionState transitionState) {
        k(transitionState, true);
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public void setUseWindowInsetsController(boolean z4) {
        this.f3767z = z4;
    }

    public void setVisible(boolean z4) {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f3743b;
        boolean z5 = clippableRoundedCornerLayout.getVisibility() == 0;
        clippableRoundedCornerLayout.setVisibility(z4 ? 0 : 8);
        n();
        k(z4 ? TransitionState.f3773d : TransitionState.f3771b, z5 != z4);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar) {
        this.f3761t = searchBar;
        this.f3756o.f3809o = searchBar;
        if (searchBar != null) {
            searchBar.setOnClickListener(new e(this, 0));
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new f(this, 0));
                    this.f3751j.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        MaterialToolbar materialToolbar = this.f3748g;
        if (materialToolbar != null && !(com.google.common.collect.c.e2(materialToolbar.getNavigationIcon()) instanceof d.d)) {
            int defaultNavigationIconResource = getDefaultNavigationIconResource();
            if (this.f3761t == null) {
                materialToolbar.setNavigationIcon(defaultNavigationIconResource);
            } else {
                Drawable mutate = com.google.common.collect.c.t0(getContext(), defaultNavigationIconResource).mutate();
                if (materialToolbar.getNavigationIconTint() != null) {
                    c0.b.g(mutate, materialToolbar.getNavigationIconTint().intValue());
                }
                materialToolbar.setNavigationIcon(new com.google.android.material.internal.f(this.f3761t.getNavigationIcon(), mutate));
                n();
            }
        }
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchViewStyle);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f3751j.setHint(charSequence);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.f3751j.setText(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, android.view.View$OnTouchListener] */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755966), attributeSet, i4);
        d.d dVar;
        this.f3757p = new f2.f(this);
        this.f3760s = new LinkedHashSet();
        this.f3762u = 16;
        this.B = TransitionState.f3771b;
        Context context2 = getContext();
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.U, i4, 2131755966, new int[0]);
        this.f3766y = d4.getColor(11, 0);
        int resourceId = d4.getResourceId(16, -1);
        int resourceId2 = d4.getResourceId(0, -1);
        String string = d4.getString(3);
        String string2 = d4.getString(4);
        String string3 = d4.getString(24);
        boolean z4 = d4.getBoolean(27, false);
        this.f3763v = d4.getBoolean(8, true);
        this.f3764w = d4.getBoolean(7, true);
        boolean z5 = d4.getBoolean(17, false);
        this.f3765x = d4.getBoolean(9, true);
        this.f3758q = d4.getBoolean(10, true);
        d4.recycle();
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_view, this);
        this.f3755n = true;
        this.f3742a = findViewById(R.id.open_search_view_scrim);
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) findViewById(R.id.open_search_view_root);
        this.f3743b = clippableRoundedCornerLayout;
        this.f3744c = findViewById(R.id.open_search_view_background);
        View findViewById = findViewById(R.id.open_search_view_status_bar_spacer);
        this.f3745d = findViewById;
        this.f3746e = (FrameLayout) findViewById(R.id.open_search_view_header_container);
        this.f3747f = (FrameLayout) findViewById(R.id.open_search_view_toolbar_container);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.open_search_view_toolbar);
        this.f3748g = materialToolbar;
        this.f3749h = (Toolbar) findViewById(R.id.open_search_view_dummy_toolbar);
        this.f3750i = (TextView) findViewById(R.id.open_search_view_search_prefix);
        EditText editText = (EditText) findViewById(R.id.open_search_view_edit_text);
        this.f3751j = editText;
        ImageButton imageButton = (ImageButton) findViewById(R.id.open_search_view_clear_button);
        this.f3752k = imageButton;
        View findViewById2 = findViewById(R.id.open_search_view_divider);
        this.f3753l = findViewById2;
        TouchObserverFrameLayout touchObserverFrameLayout = (TouchObserverFrameLayout) findViewById(R.id.open_search_view_content_container);
        this.f3754m = touchObserverFrameLayout;
        this.f3756o = new p(this);
        this.f3759r = new b2.a(context2);
        clippableRoundedCornerLayout.setOnTouchListener(new Object());
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
        setUpHeaderLayout(resourceId);
        setSearchPrefixText(string3);
        if (resourceId2 != -1) {
            editText.setTextAppearance(resourceId2);
        }
        editText.setText(string);
        editText.setHint(string2);
        if (!z5) {
            materialToolbar.setNavigationOnClickListener(new e(this, 1));
            if (z4) {
                dVar = new d.d(getContext());
                int b5 = y1.a.b(R.attr.colorOnSurface, this);
                Paint paint = dVar.f4238a;
                if (b5 != paint.getColor()) {
                    paint.setColor(b5);
                    dVar.invalidateSelf();
                }
            }
            imageButton.setOnClickListener(new e(this, 2));
            editText.addTextChangedListener(new s2(this, 1));
            touchObserverFrameLayout.setOnTouchListener(new h(0, this));
            n0.b(materialToolbar, new d(this));
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
            final int i5 = marginLayoutParams.leftMargin;
            final int i6 = marginLayoutParams.rightMargin;
            w wVar = new w() { // from class: com.google.android.material.search.c
                @Override // i0.w
                public final g2 i(View view, g2 g2Var) {
                    int i7 = SearchView.D;
                    int b6 = g2Var.b() + i5;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.leftMargin = b6;
                    marginLayoutParams2.rightMargin = g2Var.c() + i6;
                    return g2Var;
                }
            };
            WeakHashMap weakHashMap = y0.f4999a;
            m0.u(findViewById2, wVar);
            setUpStatusBarSpacer(getStatusBarHeight());
            m0.u(findViewById, new d(this));
        }
        dVar = null;
        materialToolbar.setNavigationIcon(dVar);
        imageButton.setOnClickListener(new e(this, 2));
        editText.addTextChangedListener(new s2(this, 1));
        touchObserverFrameLayout.setOnTouchListener(new h(0, this));
        n0.b(materialToolbar, new d(this));
        final ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
        final int i52 = marginLayoutParams2.leftMargin;
        final int i62 = marginLayoutParams2.rightMargin;
        w wVar2 = new w() { // from class: com.google.android.material.search.c
            @Override // i0.w
            public final g2 i(View view, g2 g2Var) {
                int i7 = SearchView.D;
                int b6 = g2Var.b() + i52;
                ViewGroup.MarginLayoutParams marginLayoutParams22 = marginLayoutParams2;
                marginLayoutParams22.leftMargin = b6;
                marginLayoutParams22.rightMargin = g2Var.c() + i62;
                return g2Var;
            }
        };
        WeakHashMap weakHashMap2 = y0.f4999a;
        m0.u(findViewById2, wVar2);
        setUpStatusBarSpacer(getStatusBarHeight());
        m0.u(findViewById, new d(this));
    }
}