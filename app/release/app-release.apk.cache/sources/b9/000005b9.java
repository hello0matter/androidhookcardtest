package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.q3;
import com.example.msphone.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.n0;
import i0.g0;
import i0.h0;
import i0.j0;
import i0.y0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l extends LinearLayout {

    /* renamed from: w  reason: collision with root package name */
    public static final /* synthetic */ int f4048w = 0;

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f4049a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f4050b;

    /* renamed from: c  reason: collision with root package name */
    public final CheckableImageButton f4051c;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f4052d;

    /* renamed from: e  reason: collision with root package name */
    public PorterDuff.Mode f4053e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnLongClickListener f4054f;

    /* renamed from: g  reason: collision with root package name */
    public final CheckableImageButton f4055g;

    /* renamed from: h  reason: collision with root package name */
    public final androidx.activity.result.h f4056h;

    /* renamed from: i  reason: collision with root package name */
    public int f4057i;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashSet f4058j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f4059k;

    /* renamed from: l  reason: collision with root package name */
    public PorterDuff.Mode f4060l;

    /* renamed from: m  reason: collision with root package name */
    public int f4061m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView.ScaleType f4062n;

    /* renamed from: o  reason: collision with root package name */
    public View.OnLongClickListener f4063o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f4064p;

    /* renamed from: q  reason: collision with root package name */
    public final AppCompatTextView f4065q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4066r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f4067s;

    /* renamed from: t  reason: collision with root package name */
    public final AccessibilityManager f4068t;

    /* renamed from: u  reason: collision with root package name */
    public j0.d f4069u;

    /* renamed from: v  reason: collision with root package name */
    public final j f4070v;

    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, androidx.activity.result.h] */
    public l(TextInputLayout textInputLayout, q3 q3Var) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.f4057i = 0;
        this.f4058j = new LinkedHashSet();
        this.f4070v = new j(this);
        k kVar = new k(this);
        this.f4068t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f4049a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f4050b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a5 = a(R.id.text_input_error_icon, from, this);
        this.f4051c = a5;
        CheckableImageButton a6 = a(R.id.text_input_end_icon, from, frameLayout);
        this.f4055g = a6;
        ?? obj = new Object();
        obj.f148c = new SparseArray();
        obj.f149d = this;
        TypedArray typedArray = q3Var.f879b;
        obj.f146a = typedArray.getResourceId(28, 0);
        obj.f147b = typedArray.getResourceId(52, 0);
        this.f4056h = obj;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f4065q = appCompatTextView;
        if (typedArray.hasValue(38)) {
            this.f4052d = i2.d.b(getContext(), q3Var, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f4053e = n0.g(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(q3Var.b(37));
        }
        a5.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(a5, 2);
        a5.setClickable(false);
        a5.setPressable(false);
        a5.setFocusable(false);
        if (!typedArray.hasValue(53)) {
            if (typedArray.hasValue(32)) {
                this.f4059k = i2.d.b(getContext(), q3Var, 32);
            }
            if (typedArray.hasValue(33)) {
                this.f4060l = n0.g(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && a6.getContentDescription() != (text = typedArray.getText(27))) {
                a6.setContentDescription(text);
            }
            a6.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(53)) {
            if (typedArray.hasValue(54)) {
                this.f4059k = i2.d.b(getContext(), q3Var, 54);
            }
            if (typedArray.hasValue(55)) {
                this.f4060l = n0.g(typedArray.getInt(55, -1), null);
            }
            g(typedArray.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(51);
            if (a6.getContentDescription() != text2) {
                a6.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize >= 0) {
            if (dimensionPixelSize != this.f4061m) {
                this.f4061m = dimensionPixelSize;
                a6.setMinimumWidth(dimensionPixelSize);
                a6.setMinimumHeight(dimensionPixelSize);
                a5.setMinimumWidth(dimensionPixelSize);
                a5.setMinimumHeight(dimensionPixelSize);
            }
            if (typedArray.hasValue(31)) {
                ImageView.ScaleType V = com.google.common.collect.c.V(typedArray.getInt(31, -1));
                this.f4062n = V;
                a6.setScaleType(V);
                a5.setScaleType(V);
            }
            appCompatTextView.setVisibility(8);
            appCompatTextView.setId(R.id.textinput_suffix_text);
            appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
            j0.f(appCompatTextView, 1);
            appCompatTextView.setTextAppearance(typedArray.getResourceId(72, 0));
            if (typedArray.hasValue(73)) {
                appCompatTextView.setTextColor(q3Var.a(73));
            }
            CharSequence text3 = typedArray.getText(71);
            this.f4064p = TextUtils.isEmpty(text3) ? null : text3;
            appCompatTextView.setText(text3);
            n();
            frameLayout.addView(a6);
            addView(appCompatTextView);
            addView(frameLayout);
            addView(a5);
            textInputLayout.f3969e0.add(kVar);
            if (textInputLayout.f3966d != null) {
                kVar.a(textInputLayout);
            }
            addOnAttachStateChangeListener(new g.g(3, this));
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public final CheckableImageButton a(int i4, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i4);
        if (i2.d.e(getContext())) {
            i0.p.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final m b() {
        int i4 = this.f4057i;
        androidx.activity.result.h hVar = this.f4056h;
        SparseArray sparseArray = (SparseArray) hVar.f148c;
        m mVar = (m) sparseArray.get(i4);
        if (mVar == null) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3) {
                                mVar = new i((l) hVar.f149d);
                            } else {
                                throw new IllegalArgumentException(androidx.activity.j.b("Invalid end icon mode: ", i4));
                            }
                        } else {
                            mVar = new c((l) hVar.f149d);
                        }
                    } else {
                        mVar = new q((l) hVar.f149d, hVar.f147b);
                    }
                } else {
                    mVar = new d((l) hVar.f149d, 1);
                }
            } else {
                mVar = new d((l) hVar.f149d, 0);
            }
            sparseArray.append(i4, mVar);
        }
        return mVar;
    }

    public final int c() {
        int c4;
        if (!d() && !e()) {
            c4 = 0;
        } else {
            CheckableImageButton checkableImageButton = this.f4055g;
            c4 = i0.p.c((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        }
        WeakHashMap weakHashMap = y0.f4999a;
        return h0.e(this.f4065q) + h0.e(this) + c4;
    }

    public final boolean d() {
        return this.f4050b.getVisibility() == 0 && this.f4055g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f4051c.getVisibility() == 0;
    }

    public final void f(boolean z4) {
        boolean z5;
        boolean isActivated;
        boolean z6;
        m b5 = b();
        boolean k4 = b5.k();
        CheckableImageButton checkableImageButton = this.f4055g;
        boolean z7 = true;
        if (k4 && (z6 = checkableImageButton.f3439d) != b5.l()) {
            checkableImageButton.setChecked(!z6);
            z5 = true;
        } else {
            z5 = false;
        }
        if ((b5 instanceof i) && (isActivated = checkableImageButton.isActivated()) != b5.j()) {
            checkableImageButton.setActivated(!isActivated);
        } else {
            z7 = z5;
        }
        if (z4 || z7) {
            com.google.common.collect.c.J1(this.f4049a, checkableImageButton, this.f4059k);
        }
    }

    public final void g(int i4) {
        boolean z4;
        Drawable drawable;
        if (this.f4057i == i4) {
            return;
        }
        m b5 = b();
        j0.d dVar = this.f4069u;
        AccessibilityManager accessibilityManager = this.f4068t;
        if (dVar != null && accessibilityManager != null) {
            j0.c.b(accessibilityManager, dVar);
        }
        CharSequence charSequence = null;
        this.f4069u = null;
        b5.s();
        this.f4057i = i4;
        Iterator it = this.f4058j.iterator();
        if (!it.hasNext()) {
            if (i4 != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            h(z4);
            m b6 = b();
            int i5 = this.f4056h.f146a;
            if (i5 == 0) {
                i5 = b6.d();
            }
            if (i5 != 0) {
                drawable = com.google.common.collect.c.t0(getContext(), i5);
            } else {
                drawable = null;
            }
            CheckableImageButton checkableImageButton = this.f4055g;
            checkableImageButton.setImageDrawable(drawable);
            TextInputLayout textInputLayout = this.f4049a;
            if (drawable != null) {
                com.google.common.collect.c.m(textInputLayout, checkableImageButton, this.f4059k, this.f4060l);
                com.google.common.collect.c.J1(textInputLayout, checkableImageButton, this.f4059k);
            }
            int c4 = b6.c();
            if (c4 != 0) {
                charSequence = getResources().getText(c4);
            }
            if (checkableImageButton.getContentDescription() != charSequence) {
                checkableImageButton.setContentDescription(charSequence);
            }
            checkableImageButton.setCheckable(b6.k());
            if (b6.i(textInputLayout.getBoxBackgroundMode())) {
                b6.r();
                j0.d h4 = b6.h();
                this.f4069u = h4;
                if (h4 != null && accessibilityManager != null) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (j0.b(this)) {
                        j0.c.a(accessibilityManager, this.f4069u);
                    }
                }
                View.OnClickListener f4 = b6.f();
                View.OnLongClickListener onLongClickListener = this.f4063o;
                checkableImageButton.setOnClickListener(f4);
                com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
                EditText editText = this.f4067s;
                if (editText != null) {
                    b6.m(editText);
                    j(b6);
                }
                com.google.common.collect.c.m(textInputLayout, checkableImageButton, this.f4059k, this.f4060l);
                f(true);
                return;
            }
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i4);
        }
        androidx.activity.j.f(it.next());
        throw null;
    }

    public final void h(boolean z4) {
        if (d() != z4) {
            this.f4055g.setVisibility(z4 ? 0 : 8);
            k();
            m();
            this.f4049a.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f4051c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        com.google.common.collect.c.m(this.f4049a, checkableImageButton, this.f4052d, this.f4053e);
    }

    public final void j(m mVar) {
        if (this.f4067s == null) {
            return;
        }
        if (mVar.e() != null) {
            this.f4067s.setOnFocusChangeListener(mVar.e());
        }
        if (mVar.g() != null) {
            this.f4055g.setOnFocusChangeListener(mVar.g());
        }
    }

    public final void k() {
        int i4 = 8;
        this.f4050b.setVisibility((this.f4055g.getVisibility() != 0 || e()) ? 8 : 0);
        boolean z4 = (this.f4064p == null || this.f4066r) ? true : false;
        if (d() || e() || !z4) {
            i4 = 0;
        }
        setVisibility(i4);
    }

    public final void l() {
        int i4;
        CheckableImageButton checkableImageButton = this.f4051c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f4049a;
        if (drawable != null && textInputLayout.f3978j.f4096q && textInputLayout.m()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkableImageButton.setVisibility(i4);
        k();
        m();
        if (this.f4057i == 0) {
            textInputLayout.q();
        }
    }

    public final void m() {
        int i4;
        TextInputLayout textInputLayout = this.f4049a;
        if (textInputLayout.f3966d == null) {
            return;
        }
        if (!d() && !e()) {
            EditText editText = textInputLayout.f3966d;
            WeakHashMap weakHashMap = y0.f4999a;
            i4 = h0.e(editText);
        } else {
            i4 = 0;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f3966d.getPaddingTop();
        int paddingBottom = textInputLayout.f3966d.getPaddingBottom();
        WeakHashMap weakHashMap2 = y0.f4999a;
        h0.k(this.f4065q, dimensionPixelSize, paddingTop, i4, paddingBottom);
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.f4065q;
        int visibility = appCompatTextView.getVisibility();
        int i4 = (this.f4064p == null || this.f4066r) ? 8 : 0;
        if (visibility != i4) {
            b().p(i4 == 0);
        }
        k();
        appCompatTextView.setVisibility(i4);
        this.f4049a.q();
    }
}