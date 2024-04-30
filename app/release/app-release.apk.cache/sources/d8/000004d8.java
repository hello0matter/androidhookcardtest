package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.msphone.R;
import com.google.android.material.button.MaterialButton;
import i0.y0;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends c0 {

    /* renamed from: g0  reason: collision with root package name */
    public static final /* synthetic */ int f3259g0 = 0;
    public int T;
    public DateSelector U;
    public CalendarConstraints V;
    public DayViewDecorator W;
    public Month X;
    public CalendarSelector Y;
    public c Z;

    /* renamed from: a0  reason: collision with root package name */
    public RecyclerView f3260a0;

    /* renamed from: b0  reason: collision with root package name */
    public RecyclerView f3261b0;

    /* renamed from: c0  reason: collision with root package name */
    public View f3262c0;

    /* renamed from: d0  reason: collision with root package name */
    public View f3263d0;

    /* renamed from: e0  reason: collision with root package name */
    public View f3264e0;

    /* renamed from: f0  reason: collision with root package name */
    public View f3265f0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class CalendarSelector {

        /* renamed from: a  reason: collision with root package name */
        public static final CalendarSelector f3266a;

        /* renamed from: b  reason: collision with root package name */
        public static final CalendarSelector f3267b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ CalendarSelector[] f3268c;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.android.material.datepicker.MaterialCalendar$CalendarSelector] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.google.android.material.datepicker.MaterialCalendar$CalendarSelector] */
        static {
            ?? r02 = new Enum("DAY", 0);
            f3266a = r02;
            ?? r12 = new Enum("YEAR", 1);
            f3267b = r12;
            f3268c = new CalendarSelector[]{r02, r12};
        }

        public static CalendarSelector valueOf(String str) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, str);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) f3268c.clone();
        }
    }

    @Override // com.google.android.material.datepicker.c0
    public final void H(u uVar) {
        this.S.add(uVar);
    }

    public final void I(Month month) {
        boolean z4;
        RecyclerView recyclerView;
        androidx.viewpager2.widget.q qVar;
        a0 a0Var = (a0) this.f3261b0.getAdapter();
        int o4 = a0Var.f3303c.f3246a.o(month);
        int o5 = o4 - a0Var.f3303c.f3246a.o(this.X);
        boolean z5 = false;
        if (Math.abs(o5) > 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (o5 > 0) {
            z5 = true;
        }
        this.X = month;
        if (z4 && z5) {
            this.f3261b0.b0(o4 - 3);
            recyclerView = this.f3261b0;
            qVar = new androidx.viewpager2.widget.q(o4, 1, this);
        } else if (z4) {
            this.f3261b0.b0(o4 + 3);
            recyclerView = this.f3261b0;
            qVar = new androidx.viewpager2.widget.q(o4, 1, this);
        } else {
            recyclerView = this.f3261b0;
            qVar = new androidx.viewpager2.widget.q(o4, 1, this);
        }
        recyclerView.post(qVar);
    }

    public final void J(CalendarSelector calendarSelector) {
        this.Y = calendarSelector;
        if (calendarSelector == CalendarSelector.f3267b) {
            this.f3260a0.getLayoutManager().m0(this.X.f3292c - ((j0) this.f3260a0.getAdapter()).f3343c.V.f3246a.f3292c);
            this.f3264e0.setVisibility(0);
            this.f3265f0.setVisibility(8);
            this.f3262c0.setVisibility(8);
            this.f3263d0.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.f3266a) {
            this.f3264e0.setVisibility(8);
            this.f3265f0.setVisibility(0);
            this.f3262c0.setVisibility(0);
            this.f3263d0.setVisibility(0);
            I(this.X);
        }
    }

    public final void K() {
        CalendarSelector calendarSelector = this.Y;
        CalendarSelector calendarSelector2 = CalendarSelector.f3267b;
        CalendarSelector calendarSelector3 = CalendarSelector.f3266a;
        if (calendarSelector == calendarSelector2) {
            J(calendarSelector3);
        } else if (calendarSelector == calendarSelector3) {
            J(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.t
    public final void r(Bundle bundle) {
        super.r(bundle);
        if (bundle == null) {
            bundle = this.f1806f;
        }
        this.T = bundle.getInt("THEME_RES_ID_KEY");
        this.U = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.V = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.W = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.X = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.t
    public final View s(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i4;
        int i5;
        k kVar;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(i(), this.T);
        this.Z = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.V.f3246a;
        if (MaterialDatePicker.L(contextThemeWrapper, 16843277)) {
            i4 = R.layout.mtrl_calendar_vertical;
            i5 = 1;
        } else {
            i4 = R.layout.mtrl_calendar_horizontal;
            i5 = 0;
        }
        View inflate = cloneInContext.inflate(i4, viewGroup, false);
        Resources resources = C().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i6 = x.f3367g;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i6 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i6) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        y0.p(gridView, new m(0, this));
        int i7 = this.V.f3250e;
        if (i7 > 0) {
            kVar = new k(i7);
        } else {
            kVar = new k();
        }
        gridView.setAdapter((ListAdapter) kVar);
        gridView.setNumColumns(month.f3293d);
        gridView.setEnabled(false);
        this.f3261b0 = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        i();
        this.f3261b0.setLayoutManager(new n(this, i5, i5));
        this.f3261b0.setTag("MONTHS_VIEW_GROUP_TAG");
        a0 a0Var = new a0(contextThemeWrapper, this.U, this.V, this.W, new o(this));
        this.f3261b0.setAdapter(a0Var);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f3260a0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f3260a0.setLayoutManager(new GridLayoutManager(integer));
            this.f3260a0.setAdapter(new j0(this));
            this.f3260a0.g(new p(this));
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            y0.p(materialButton, new m(2, this));
            View findViewById = inflate.findViewById(R.id.month_navigation_previous);
            this.f3262c0 = findViewById;
            findViewById.setTag("NAVIGATION_PREV_TAG");
            View findViewById2 = inflate.findViewById(R.id.month_navigation_next);
            this.f3263d0 = findViewById2;
            findViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f3264e0 = inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
            this.f3265f0 = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            J(CalendarSelector.f3266a);
            materialButton.setText(this.X.n());
            this.f3261b0.h(new q(this, a0Var, materialButton));
            materialButton.setOnClickListener(new androidx.appcompat.app.b(3, this));
            this.f3263d0.setOnClickListener(new l(this, a0Var, 1));
            this.f3262c0.setOnClickListener(new l(this, a0Var, 0));
        }
        if (!MaterialDatePicker.L(contextThemeWrapper, 16843277)) {
            new androidx.recyclerview.widget.f0().a(this.f3261b0);
        }
        this.f3261b0.b0(a0Var.f3303c.f3246a.o(this.X));
        y0.p(this.f3261b0, new m(1, this));
        return inflate;
    }

    @Override // androidx.fragment.app.t
    public final void w(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.T);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.U);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.V);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.W);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.X);
    }
}