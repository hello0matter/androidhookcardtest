package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.search.SearchBar;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class n0 {
    public static Rect a(View view, SearchBar searchBar) {
        int[] iArr = new int[2];
        searchBar.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i6 = i4 - iArr2[0];
        int i7 = i5 - iArr2[1];
        return new Rect(i6, i7, searchBar.getWidth() + i6, searchBar.getHeight() + i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.recyclerview.widget.o0] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, android.view.View$OnAttachStateChangeListener] */
    public static void b(View view, m0 m0Var) {
        WeakHashMap weakHashMap = y0.f4999a;
        int f4 = i0.h0.f(view);
        int paddingTop = view.getPaddingTop();
        int e4 = i0.h0.e(view);
        int paddingBottom = view.getPaddingBottom();
        ?? obj = new Object();
        obj.f2197a = f4;
        obj.f2198b = paddingTop;
        obj.f2199c = e4;
        obj.f2200d = paddingBottom;
        i0.m0.u(view, new androidx.appcompat.widget.c0(12, m0Var, (Object) obj));
        if (i0.j0.b(view)) {
            i0.k0.c(view);
        } else {
            view.addOnAttachStateChangeListener(new Object());
        }
    }

    public static float c(Context context, int i4) {
        return TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup d(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static c1.o0 e(View view) {
        ViewGroup d4 = d(view);
        if (d4 == null) {
            return null;
        }
        return new c1.o0(1, d4);
    }

    public static boolean f(View view) {
        WeakHashMap weakHashMap = y0.f4999a;
        if (i0.h0.d(view) == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode g(int i4, PorterDuff.Mode mode) {
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 9) {
                    switch (i4) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}