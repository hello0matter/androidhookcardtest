package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Handler;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsAnimation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c0 implements i0.w, w1.i, d2.h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f724a;

    /* renamed from: b  reason: collision with root package name */
    public Object f725b;

    /* renamed from: c  reason: collision with root package name */
    public Object f726c;

    public c0(int i4) {
        this.f724a = i4;
        if (i4 != 13) {
            this.f725b = new Rect();
            this.f726c = new Rect();
        }
    }

    public final KeyListener a(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            return ((s0.b) this.f726c).f6498a.u(keyListener);
        }
        return keyListener;
    }

    public final void b(AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = ((EditText) this.f725b).getContext().obtainStyledAttributes(attributeSet, c.a.f2552j, i4, 0);
        try {
            boolean z4 = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z4 = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            ((s0.b) this.f726c).f6498a.r(z4);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // d2.h
    public final int c() {
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (!(((ExtendedFloatingActionButton) this.f726c).getParent() instanceof View)) {
            return ((d2.h) this.f725b).c();
        }
        View view = (View) ((ExtendedFloatingActionButton) this.f726c).getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.width == -2) {
            return ((d2.h) this.f725b).c();
        }
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        if ((((ExtendedFloatingActionButton) this.f726c).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ((ExtendedFloatingActionButton) this.f726c).getLayoutParams()) != null) {
            i4 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        } else {
            i4 = 0;
        }
        return (view.getWidth() - i4) - paddingRight;
    }

    @Override // d2.h
    public final int d() {
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Object obj = this.f726c;
        if (((ExtendedFloatingActionButton) obj).H == -1) {
            if (!(((ExtendedFloatingActionButton) obj).getParent() instanceof View)) {
                return ((d2.h) this.f725b).d();
            }
            View view = (View) ((ExtendedFloatingActionButton) this.f726c).getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && layoutParams.height == -2) {
                return ((d2.h) this.f725b).d();
            }
            int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
            if ((((ExtendedFloatingActionButton) this.f726c).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ((ExtendedFloatingActionButton) this.f726c).getLayoutParams()) != null) {
                i4 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            } else {
                i4 = 0;
            }
            return (view.getHeight() - i4) - paddingBottom;
        } else if (((ExtendedFloatingActionButton) obj).H != 0 && ((ExtendedFloatingActionButton) obj).H != -2) {
            return ((ExtendedFloatingActionButton) obj).H;
        } else {
            return ((d2.h) this.f725b).d();
        }
    }

    @Override // d2.h
    public final int e() {
        return ((ExtendedFloatingActionButton) this.f726c).A;
    }

    public final InputConnection f(InputConnection inputConnection, EditorInfo editorInfo) {
        s0.b bVar = (s0.b) this.f726c;
        if (inputConnection == null) {
            bVar.getClass();
            return null;
        }
        return bVar.f6498a.v(inputConnection, editorInfo);
    }

    @Override // d2.h
    public final int g() {
        return ((ExtendedFloatingActionButton) this.f726c).f3398z;
    }

    @Override // d2.h
    public final ViewGroup.LayoutParams h() {
        int i4;
        Object obj = this.f726c;
        if (((ExtendedFloatingActionButton) obj).H == 0) {
            i4 = -2;
        } else {
            i4 = ((ExtendedFloatingActionButton) obj).H;
        }
        return new ViewGroup.LayoutParams(-1, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, androidx.recyclerview.widget.o0] */
    @Override // i0.w
    public final i0.g2 i(View view, i0.g2 g2Var) {
        switch (this.f724a) {
            case 6:
                i0.g2 j4 = i0.y0.j(view, g2Var);
                if (!j4.f4931a.m()) {
                    Rect rect = (Rect) this.f725b;
                    rect.left = j4.b();
                    rect.top = j4.d();
                    rect.right = j4.c();
                    rect.bottom = j4.a();
                    int childCount = ((ViewPager) this.f726c).getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        i0.g2 b5 = i0.y0.b(((ViewPager) this.f726c).getChildAt(i4), j4);
                        rect.left = Math.min(b5.b(), rect.left);
                        rect.top = Math.min(b5.d(), rect.top);
                        rect.right = Math.min(b5.c(), rect.right);
                        rect.bottom = Math.min(b5.a(), rect.bottom);
                    }
                    return j4.f(rect.left, rect.top, rect.right, rect.bottom);
                }
                return j4;
            default:
                androidx.recyclerview.widget.o0 o0Var = (androidx.recyclerview.widget.o0) this.f726c;
                ?? obj = new Object();
                obj.f2197a = o0Var.f2197a;
                obj.f2198b = o0Var.f2198b;
                obj.f2199c = o0Var.f2199c;
                obj.f2200d = o0Var.f2200d;
                return ((com.google.android.material.internal.m0) this.f725b).s(view, g2Var, obj);
        }
    }

    public final void j(f0.h hVar) {
        int i4 = hVar.f4528b;
        if (i4 == 0) {
            ((Handler) this.f726c).post(new f0.a(this, (f0.l) this.f725b, hVar.f4527a, 0));
        } else {
            ((Handler) this.f726c).post(new androidx.activity.h(i4, 3, this, (f0.l) this.f725b));
        }
    }

    public final void k(int i4, int i5, int i6, int i7) {
        ((CardView) this.f726c).f1006d.set(i4, i5, i6, i7);
        Object obj = this.f726c;
        CardView.b((CardView) obj, i4 + ((CardView) obj).f1005c.left, i5 + ((CardView) obj).f1005c.top, i6 + ((CardView) obj).f1005c.right, i7 + ((CardView) obj).f1005c.bottom);
    }

    public final String toString() {
        switch (this.f724a) {
            case VisibleForTesting.NONE /* 5 */:
                return "Bounds{lower=" + ((b0.c) this.f725b) + " upper=" + ((b0.c) this.f726c) + "}";
            default:
                return super.toString();
        }
    }

    public c0(int i4, int i5) {
        this.f724a = 3;
        this.f725b = new int[]{i4, i5};
        this.f726c = new float[]{0.0f, 1.0f};
    }

    public c0(int i4, int i5, int i6) {
        this.f724a = 3;
        this.f725b = new int[]{i4, i5, i6};
        this.f726c = new float[]{0.0f, 0.5f, 1.0f};
    }

    public /* synthetic */ c0(int i4, View view, Object obj) {
        this.f724a = i4;
        this.f726c = view;
        this.f725b = obj;
    }

    public /* synthetic */ c0(int i4, Object obj, Object obj2) {
        this.f724a = i4;
        this.f725b = obj;
        this.f726c = obj2;
    }

    public c0(WindowInsetsAnimation.Bounds bounds) {
        Insets lowerBound;
        Insets upperBound;
        this.f724a = 5;
        lowerBound = bounds.getLowerBound();
        this.f725b = b0.c.c(lowerBound);
        upperBound = bounds.getUpperBound();
        this.f726c = b0.c.c(upperBound);
    }

    public c0(EditText editText) {
        this.f724a = 0;
        this.f725b = editText;
        this.f726c = new s0.b(editText);
    }

    public c0(TextView textView) {
        this.f724a = 1;
        textView.getClass();
        this.f725b = textView;
    }

    public c0(CardView cardView) {
        this.f724a = 2;
        this.f726c = cardView;
    }

    public c0(ViewPager viewPager) {
        this.f724a = 6;
        this.f726c = viewPager;
        this.f725b = new Rect();
    }

    public c0(ArrayList arrayList, ArrayList arrayList2) {
        this.f724a = 3;
        int size = arrayList.size();
        this.f725b = new int[size];
        this.f726c = new float[size];
        for (int i4 = 0; i4 < size; i4++) {
            ((int[]) this.f725b)[i4] = ((Integer) arrayList.get(i4)).intValue();
            ((float[]) this.f726c)[i4] = ((Float) arrayList2.get(i4)).floatValue();
        }
    }

    public c0(v1.i iVar, v1.i iVar2) {
        this.f724a = 8;
        if (iVar.f6975a > iVar2.f6975a) {
            throw new IllegalArgumentException();
        }
        this.f725b = iVar;
        this.f726c = iVar2;
    }
}