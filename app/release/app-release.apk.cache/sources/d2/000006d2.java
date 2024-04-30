package g;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.example.msphone.R;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4597a;

    /* renamed from: b  reason: collision with root package name */
    public final p f4598b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4599c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4600d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4601e;

    /* renamed from: f  reason: collision with root package name */
    public View f4602f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4604h;

    /* renamed from: i  reason: collision with root package name */
    public c0 f4605i;

    /* renamed from: j  reason: collision with root package name */
    public y f4606j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f4607k;

    /* renamed from: g  reason: collision with root package name */
    public int f4603g = 8388611;

    /* renamed from: l  reason: collision with root package name */
    public final z f4608l = new z(this);

    public b0(int i4, int i5, Context context, View view, p pVar, boolean z4) {
        this.f4597a = context;
        this.f4598b = pVar;
        this.f4602f = view;
        this.f4599c = z4;
        this.f4600d = i4;
        this.f4601e = i5;
    }

    public final y a() {
        y i0Var;
        if (this.f4606j == null) {
            Context context = this.f4597a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            a0.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                i0Var = new j(this.f4597a, this.f4602f, this.f4600d, this.f4601e, this.f4599c);
            } else {
                View view = this.f4602f;
                i0Var = new i0(this.f4600d, this.f4601e, this.f4597a, view, this.f4598b, this.f4599c);
            }
            i0Var.n(this.f4598b);
            i0Var.t(this.f4608l);
            i0Var.p(this.f4602f);
            i0Var.d(this.f4605i);
            i0Var.q(this.f4604h);
            i0Var.r(this.f4603g);
            this.f4606j = i0Var;
        }
        return this.f4606j;
    }

    public final boolean b() {
        y yVar = this.f4606j;
        if (yVar != null && yVar.b()) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f4606j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f4607k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i4, int i5, boolean z4, boolean z5) {
        y a5 = a();
        a5.u(z5);
        if (z4) {
            int i6 = this.f4603g;
            View view = this.f4602f;
            WeakHashMap weakHashMap = y0.f4999a;
            if ((Gravity.getAbsoluteGravity(i6, i0.h0.d(view)) & 7) == 5) {
                i4 -= this.f4602f.getWidth();
            }
            a5.s(i4);
            a5.v(i5);
            int i7 = (int) ((this.f4597a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a5.f4758a = new Rect(i4 - i7, i5 - i7, i4 + i7, i5 + i7);
        }
        a5.f();
    }
}