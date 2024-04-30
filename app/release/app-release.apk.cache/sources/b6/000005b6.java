package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.msphone.R;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i extends m {

    /* renamed from: e  reason: collision with root package name */
    public final int f4032e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4033f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeInterpolator f4034g;

    /* renamed from: h  reason: collision with root package name */
    public AutoCompleteTextView f4035h;

    /* renamed from: i  reason: collision with root package name */
    public final com.google.android.material.datepicker.s f4036i;

    /* renamed from: j  reason: collision with root package name */
    public final com.google.android.material.datepicker.j f4037j;

    /* renamed from: k  reason: collision with root package name */
    public final l0.d f4038k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4039l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4040m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4041n;

    /* renamed from: o  reason: collision with root package name */
    public long f4042o;

    /* renamed from: p  reason: collision with root package name */
    public AccessibilityManager f4043p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f4044q;

    /* renamed from: r  reason: collision with root package name */
    public ValueAnimator f4045r;

    public i(l lVar) {
        super(lVar);
        this.f4036i = new com.google.android.material.datepicker.s(2, this);
        this.f4037j = new com.google.android.material.datepicker.j(2, this);
        this.f4038k = new l0.d(5, this);
        this.f4042o = Long.MAX_VALUE;
        this.f4033f = com.google.common.collect.c.K1(lVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f4032e = com.google.common.collect.c.K1(lVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f4034g = com.google.common.collect.c.L1(lVar.getContext(), R.attr.motionEasingLinearInterpolator, p1.a.f6128a);
    }

    @Override // com.google.android.material.textfield.m
    public final void a() {
        if (this.f4043p.isTouchExplorationEnabled() && com.google.common.collect.c.X0(this.f4035h) && !this.f4074d.hasFocus()) {
            this.f4035h.dismissDropDown();
        }
        this.f4035h.post(new androidx.activity.d(11, this));
    }

    @Override // com.google.android.material.textfield.m
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.m
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.m
    public final View.OnFocusChangeListener e() {
        return this.f4037j;
    }

    @Override // com.google.android.material.textfield.m
    public final View.OnClickListener f() {
        return this.f4036i;
    }

    @Override // com.google.android.material.textfield.m
    public final j0.d h() {
        return this.f4038k;
    }

    @Override // com.google.android.material.textfield.m
    public final boolean i(int i4) {
        return i4 != 0;
    }

    @Override // com.google.android.material.textfield.m
    public final boolean j() {
        return this.f4039l;
    }

    @Override // com.google.android.material.textfield.m
    public final boolean l() {
        return this.f4041n;
    }

    @Override // com.google.android.material.textfield.m
    public final void m(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            this.f4035h = autoCompleteTextView;
            autoCompleteTextView.setOnTouchListener(new com.google.android.material.search.h(1, this));
            this.f4035h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.h
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    i iVar = i.this;
                    iVar.f4040m = true;
                    iVar.f4042o = System.currentTimeMillis();
                    iVar.t(false);
                }
            });
            this.f4035h.setThreshold(0);
            TextInputLayout textInputLayout = this.f4071a;
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!com.google.common.collect.c.X0(editText) && this.f4043p.isTouchExplorationEnabled()) {
                WeakHashMap weakHashMap = y0.f4999a;
                g0.s(this.f4074d, 2);
            }
            textInputLayout.setEndIconVisible(true);
            return;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    @Override // com.google.android.material.textfield.m
    public final void n(j0.h hVar) {
        boolean isShowingHintText;
        if (!com.google.common.collect.c.X0(this.f4035h)) {
            hVar.g(Spinner.class.getName());
        }
        int i4 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        if (i4 >= 26) {
            isShowingHintText = accessibilityNodeInfo.isShowingHintText();
            if (!isShowingHintText) {
                return;
            }
        } else {
            Bundle extras = accessibilityNodeInfo.getExtras();
            if (extras == null || (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) != 4) {
                return;
            }
        }
        hVar.i(null);
    }

    @Override // com.google.android.material.textfield.m
    public final void o(AccessibilityEvent accessibilityEvent) {
        boolean z4;
        if (this.f4043p.isEnabled() && !com.google.common.collect.c.X0(this.f4035h)) {
            if (accessibilityEvent.getEventType() == 32768 && this.f4041n && !this.f4035h.isPopupShowing()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (accessibilityEvent.getEventType() == 1 || z4) {
                u();
                this.f4040m = true;
                this.f4042o = System.currentTimeMillis();
            }
        }
    }

    @Override // com.google.android.material.textfield.m
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f4034g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f4033f);
        ofFloat.addUpdateListener(new u1.b(5, this));
        this.f4045r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.f4032e);
        ofFloat2.addUpdateListener(new u1.b(5, this));
        this.f4044q = ofFloat2;
        ofFloat2.addListener(new androidx.appcompat.widget.e(10, this));
        this.f4043p = (AccessibilityManager) this.f4073c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.m
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f4035h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f4035h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z4) {
        if (this.f4041n != z4) {
            this.f4041n = z4;
            this.f4045r.cancel();
            this.f4044q.start();
        }
    }

    public final void u() {
        boolean z4;
        if (this.f4035h == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f4042o;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            this.f4040m = false;
        }
        if (!this.f4040m) {
            t(!this.f4041n);
            if (this.f4041n) {
                this.f4035h.requestFocus();
                this.f4035h.showDropDown();
                return;
            }
            this.f4035h.dismissDropDown();
            return;
        }
        this.f4040m = false;
    }
}