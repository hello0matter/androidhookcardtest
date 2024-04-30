package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.k0;
import com.example.msphone.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import i0.i1;
import i0.i2;
import i0.j1;
import i0.m0;
import i0.m2;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class MaterialDatePicker<S> extends androidx.fragment.app.p {
    public TextView A0;
    public CheckableImageButton B0;
    public l2.j C0;
    public Button D0;
    public boolean E0;
    public CharSequence F0;
    public CharSequence G0;

    /* renamed from: h0  reason: collision with root package name */
    public final LinkedHashSet f3271h0 = new LinkedHashSet();

    /* renamed from: i0  reason: collision with root package name */
    public final LinkedHashSet f3272i0 = new LinkedHashSet();

    /* renamed from: j0  reason: collision with root package name */
    public final LinkedHashSet f3273j0 = new LinkedHashSet();

    /* renamed from: k0  reason: collision with root package name */
    public final LinkedHashSet f3274k0 = new LinkedHashSet();

    /* renamed from: l0  reason: collision with root package name */
    public int f3275l0;

    /* renamed from: m0  reason: collision with root package name */
    public DateSelector f3276m0;

    /* renamed from: n0  reason: collision with root package name */
    public c0 f3277n0;

    /* renamed from: o0  reason: collision with root package name */
    public CalendarConstraints f3278o0;

    /* renamed from: p0  reason: collision with root package name */
    public DayViewDecorator f3279p0;

    /* renamed from: q0  reason: collision with root package name */
    public MaterialCalendar f3280q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f3281r0;

    /* renamed from: s0  reason: collision with root package name */
    public CharSequence f3282s0;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f3283t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f3284u0;

    /* renamed from: v0  reason: collision with root package name */
    public int f3285v0;

    /* renamed from: w0  reason: collision with root package name */
    public CharSequence f3286w0;

    /* renamed from: x0  reason: collision with root package name */
    public int f3287x0;

    /* renamed from: y0  reason: collision with root package name */
    public CharSequence f3288y0;

    /* renamed from: z0  reason: collision with root package name */
    public TextView f3289z0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface InputMode {
    }

    public static int K(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month month = new Month(g0.f());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int i4 = month.f3293d;
        int i5 = dimensionPixelSize * i4;
        return ((i4 - 1) * dimensionPixelOffset2) + i5 + (dimensionPixelOffset * 2);
    }

    public static boolean L(Context context, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2.c.c(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()).data, new int[]{i4});
        boolean z4 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z4;
    }

    @Override // androidx.fragment.app.p
    public final Dialog I() {
        Context C = C();
        Context C2 = C();
        int i4 = this.f3275l0;
        if (i4 == 0) {
            i4 = J().d(C2);
        }
        Dialog dialog = new Dialog(C, i4);
        Context context = dialog.getContext();
        this.f3283t0 = L(context, 16843277);
        this.C0 = new l2.j(context, null, R.attr.materialCalendarStyle, 2131756051);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, o1.a.A, R.attr.materialCalendarStyle, 2131756051);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.C0.l(context);
        this.C0.o(ColorStateList.valueOf(color));
        l2.j jVar = this.C0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = y0.f4999a;
        jVar.n(m0.i(decorView));
        return dialog;
    }

    public final DateSelector J() {
        if (this.f3276m0 == null) {
            this.f3276m0 = (DateSelector) this.f1806f.getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f3276m0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.fragment.app.t, com.google.android.material.datepicker.v] */
    public final void M() {
        CharSequence charSequence;
        Context C = C();
        int i4 = this.f3275l0;
        if (i4 == 0) {
            i4 = J().d(C);
        }
        DateSelector J = J();
        CalendarConstraints calendarConstraints = this.f3278o0;
        DayViewDecorator dayViewDecorator = this.f3279p0;
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i4);
        bundle.putParcelable("GRID_SELECTOR_KEY", J);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.f3249d);
        materialCalendar.G(bundle);
        this.f3280q0 = materialCalendar;
        if (this.f3284u0 == 1) {
            DateSelector J2 = J();
            CalendarConstraints calendarConstraints2 = this.f3278o0;
            ?? vVar = new v();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i4);
            bundle2.putParcelable("DATE_SELECTOR_KEY", J2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            vVar.G(bundle2);
            materialCalendar = vVar;
        }
        this.f3277n0 = materialCalendar;
        TextView textView = this.f3289z0;
        if (this.f3284u0 == 1 && C().getResources().getConfiguration().orientation == 2) {
            charSequence = this.G0;
        } else {
            charSequence = this.F0;
        }
        textView.setText(charSequence);
        String c4 = J().c(i());
        this.A0.setContentDescription(J().b(C()));
        this.A0.setText(c4);
        k0 h4 = h();
        h4.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(h4);
        aVar.e(R.id.mtrl_calendar_frame, this.f3277n0, null, 2);
        if (!aVar.f1637g) {
            aVar.f1646p.y(aVar, false);
            this.f3277n0.H(new u(0, this));
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final void N(CheckableImageButton checkableImageButton) {
        this.B0.setContentDescription(checkableImageButton.getContext().getString(this.f3284u0 == 1 ? R.string.mtrl_picker_toggle_to_calendar_input_mode : R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.p, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f3273j0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.p, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f3274k0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.E;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.t
    public final void r(Bundle bundle) {
        super.r(bundle);
        if (bundle == null) {
            bundle = this.f1806f;
        }
        this.f3275l0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f3276m0 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f3278o0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f3279p0 = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f3281r0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f3282s0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f3284u0 = bundle.getInt("INPUT_MODE_KEY");
        this.f3285v0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f3286w0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f3287x0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f3288y0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence charSequence = this.f3282s0;
        if (charSequence == null) {
            charSequence = C().getResources().getText(this.f3281r0);
        }
        this.F0 = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.G0 = charSequence;
    }

    @Override // androidx.fragment.app.t
    public final View s(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i4;
        View findViewById;
        LinearLayout.LayoutParams layoutParams;
        boolean z4;
        if (this.f3283t0) {
            i4 = R.layout.mtrl_picker_fullscreen;
        } else {
            i4 = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i4, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.f3279p0;
        if (dayViewDecorator != null) {
            dayViewDecorator.getClass();
        }
        if (this.f3283t0) {
            findViewById = inflate.findViewById(R.id.mtrl_calendar_frame);
            layoutParams = new LinearLayout.LayoutParams(K(context), -2);
        } else {
            findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            layoutParams = new LinearLayout.LayoutParams(K(context), -1);
        }
        findViewById.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.A0 = textView;
        WeakHashMap weakHashMap = y0.f4999a;
        i0.j0.f(textView, 1);
        this.B0 = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f3289z0 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.B0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.B0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, com.google.common.collect.c.t0(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], com.google.common.collect.c.t0(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        CheckableImageButton checkableImageButton2 = this.B0;
        if (this.f3284u0 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        checkableImageButton2.setChecked(z4);
        y0.p(this.B0, null);
        N(this.B0);
        this.B0.setOnClickListener(new s(0, this));
        this.D0 = (Button) inflate.findViewById(R.id.confirm_button);
        if (J().h()) {
            this.D0.setEnabled(true);
        } else {
            this.D0.setEnabled(false);
        }
        this.D0.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.f3286w0;
        if (charSequence != null) {
            this.D0.setText(charSequence);
        } else {
            int i5 = this.f3285v0;
            if (i5 != 0) {
                this.D0.setText(i5);
            }
        }
        this.D0.setOnClickListener(new t(this, 0));
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence2 = this.f3288y0;
        if (charSequence2 != null) {
            button.setText(charSequence2);
        } else {
            int i6 = this.f3287x0;
            if (i6 != 0) {
                button.setText(i6);
            }
        }
        button.setOnClickListener(new t(this, 1));
        return inflate;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.material.datepicker.b, java.lang.Object] */
    @Override // androidx.fragment.app.p, androidx.fragment.app.t
    public final void w(Bundle bundle) {
        Month month;
        super.w(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f3275l0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f3276m0);
        CalendarConstraints calendarConstraints = this.f3278o0;
        ?? obj = new Object();
        int i4 = b.f3308c;
        int i5 = b.f3308c;
        long j4 = calendarConstraints.f3246a.f3295f;
        long j5 = calendarConstraints.f3247b.f3295f;
        obj.f3309a = Long.valueOf(calendarConstraints.f3249d.f3295f);
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.f3248c;
        obj.f3310b = dateValidator;
        MaterialCalendar materialCalendar = this.f3280q0;
        Month month2 = null;
        if (materialCalendar == null) {
            month = null;
        } else {
            month = materialCalendar.X;
        }
        if (month != null) {
            obj.f3309a = Long.valueOf(month.f3295f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month m4 = Month.m(j4);
        Month m5 = Month.m(j5);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l4 = obj.f3309a;
        if (l4 != null) {
            month2 = Month.m(l4.longValue());
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(m4, m5, dateValidator2, month2, calendarConstraints.f3250e));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f3279p0);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f3281r0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f3282s0);
        bundle.putInt("INPUT_MODE_KEY", this.f3284u0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f3285v0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f3286w0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f3287x0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f3288y0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [i0.w, java.lang.Object, androidx.activity.result.h] */
    @Override // androidx.fragment.app.p, androidx.fragment.app.t
    public final void x() {
        Integer num;
        boolean z4;
        int i4;
        boolean z5;
        i2 i2Var;
        i2 i2Var2;
        i2 i2Var3;
        i2 i2Var4;
        WindowInsetsController insetsController;
        WindowInsetsController insetsController2;
        super.x();
        Dialog dialog = this.f1765d0;
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (this.f3283t0) {
                window.setLayout(-1, -1);
                window.setBackgroundDrawable(this.C0);
                if (!this.E0) {
                    View findViewById = D().findViewById(R.id.fullscreen_header);
                    if (findViewById.getBackground() instanceof ColorDrawable) {
                        num = Integer.valueOf(((ColorDrawable) findViewById.getBackground()).getColor());
                    } else {
                        num = null;
                    }
                    int i5 = Build.VERSION.SDK_INT;
                    boolean z6 = false;
                    if (num != null && num.intValue() != 0) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    int c4 = y1.a.c(window.getContext(), 16842801, -16777216);
                    if (z4) {
                        num = Integer.valueOf(c4);
                    }
                    if (i5 >= 30) {
                        j1.a(window, false);
                    } else {
                        i1.a(window, false);
                    }
                    window.getContext();
                    Context context = window.getContext();
                    if (i5 < 27) {
                        i4 = b0.a.e(y1.a.c(context, 16843858, -16777216), 128);
                    } else {
                        i4 = 0;
                    }
                    window.setStatusBarColor(0);
                    window.setNavigationBarColor(i4);
                    boolean d4 = y1.a.d(num.intValue());
                    if (!y1.a.d(0) && !d4) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    View decorView = window.getDecorView();
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 30) {
                        insetsController2 = window.getInsetsController();
                        m2 m2Var = new m2(insetsController2);
                        m2Var.f4958d = window;
                        i2Var2 = m2Var;
                    } else {
                        if (i6 >= 26) {
                            i2Var = new i2(window, decorView);
                        } else {
                            i2Var = new i2(window, decorView);
                        }
                        i2Var2 = i2Var;
                    }
                    i2Var2.q(z5);
                    boolean d5 = y1.a.d(c4);
                    if (y1.a.d(i4) || (i4 == 0 && d5)) {
                        z6 = true;
                    }
                    View decorView2 = window.getDecorView();
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 30) {
                        insetsController = window.getInsetsController();
                        m2 m2Var2 = new m2(insetsController);
                        m2Var2.f4958d = window;
                        i2Var4 = m2Var2;
                    } else {
                        if (i7 >= 26) {
                            i2Var3 = new i2(window, decorView2);
                        } else {
                            i2Var3 = new i2(window, decorView2);
                        }
                        i2Var4 = i2Var3;
                    }
                    i2Var4.p(z6);
                    int paddingTop = findViewById.getPaddingTop();
                    int i8 = findViewById.getLayoutParams().height;
                    ?? obj = new Object();
                    obj.f149d = this;
                    obj.f146a = i8;
                    obj.f148c = findViewById;
                    obj.f147b = paddingTop;
                    WeakHashMap weakHashMap = y0.f4999a;
                    m0.u(findViewById, obj);
                    this.E0 = true;
                }
            } else {
                window.setLayout(-2, -2);
                int dimensionPixelOffset = C().getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
                Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
                window.setBackgroundDrawable(new InsetDrawable((Drawable) this.C0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
                View decorView3 = window.getDecorView();
                Dialog dialog2 = this.f1765d0;
                if (dialog2 != null) {
                    decorView3.setOnTouchListener(new z1.a(dialog2, rect));
                } else {
                    throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
                }
            }
            M();
            return;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.t
    public final void y() {
        this.f3277n0.S.clear();
        super.y();
    }
}