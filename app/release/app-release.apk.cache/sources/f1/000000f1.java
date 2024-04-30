package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public final u f471a;

    /* renamed from: b  reason: collision with root package name */
    public final v f472b;

    /* renamed from: c  reason: collision with root package name */
    public final View f473c;

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f474d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f475e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f476f;

    /* renamed from: g  reason: collision with root package name */
    public i0.e f477g;

    /* renamed from: h  reason: collision with root package name */
    public final g.f f478h;

    /* renamed from: i  reason: collision with root package name */
    public ListPopupWindow f479i;

    /* renamed from: j  reason: collision with root package name */
    public PopupWindow.OnDismissListener f480j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f481k;

    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f482a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            q3 e4 = q3.e(context, attributeSet, f482a);
            setBackgroundDrawable(e4.b(0));
            e4.g();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, null);
    }

    public final void a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f478h);
            }
        }
    }

    public final boolean b() {
        return getListPopupWindow().f593z.isShowing();
    }

    @RestrictTo({RestrictTo.Scope.f169a})
    public r getDataModel() {
        this.f471a.getClass();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f479i == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f479i = listPopupWindow;
            listPopupWindow.o(this.f471a);
            ListPopupWindow listPopupWindow2 = this.f479i;
            listPopupWindow2.f582o = this;
            listPopupWindow2.f592y = true;
            listPopupWindow2.f593z.setFocusable(true);
            ListPopupWindow listPopupWindow3 = this.f479i;
            v vVar = this.f472b;
            listPopupWindow3.f583p = vVar;
            listPopupWindow3.f593z.setOnDismissListener(vVar);
        }
        return this.f479i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f471a.getClass();
        this.f481k = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f471a.getClass();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f478h);
        }
        if (b()) {
            a();
        }
        this.f481k = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        this.f473c.layout(0, 0, i6 - i4, i7 - i5);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        if (this.f476f.getVisibility() != 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), 1073741824);
        }
        View view = this.f473c;
        measureChild(view, i4, i5);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @RestrictTo({RestrictTo.Scope.f169a})
    public void setActivityChooserModel(r rVar) {
        u uVar = this.f471a;
        uVar.f905a.f471a.getClass();
        uVar.notifyDataSetChanged();
        if (b()) {
            a();
            if (!b() && this.f481k) {
                uVar.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
            }
        }
    }

    public void setDefaultActionButtonContentDescription(int i4) {
    }

    public void setExpandActivityOverflowButtonContentDescription(int i4) {
        this.f475e.setContentDescription(getContext().getString(i4));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f475e.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i4) {
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f480j = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setProvider(i0.e eVar) {
        this.f477g = eVar;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        new s(this, 0);
        this.f478h = new g.f(2, this);
        int[] iArr = c.a.f2547e;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        i0.y0.o(this, context, iArr, attributeSet, obtainStyledAttributes, i4);
        obtainStyledAttributes.getInt(1, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        v vVar = new v(this);
        this.f472b = vVar;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.f473c = findViewById;
        findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f476f = frameLayout;
        frameLayout.setOnClickListener(vVar);
        frameLayout.setOnLongClickListener(vVar);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(vVar);
        frameLayout2.setAccessibilityDelegate(new t(0, this));
        frameLayout2.setOnTouchListener(new g.b(this, frameLayout2));
        this.f474d = frameLayout2;
        ImageView imageView2 = (ImageView) frameLayout2.findViewById(R.id.image);
        this.f475e = imageView2;
        imageView2.setImageDrawable(drawable);
        u uVar = new u(this);
        this.f471a = uVar;
        uVar.registerDataSetObserver(new s(this, 1));
        Resources resources = context.getResources();
        Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}