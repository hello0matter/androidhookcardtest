package com.google.android.material.internal;

import android.view.View;
import i0.g2;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class k0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3560a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f3562c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m0 f3563d;

    public k0(boolean z4, boolean z5, boolean z6, com.google.android.material.bottomappbar.b bVar) {
        this.f3560a = z4;
        this.f3561b = z5;
        this.f3562c = z6;
        this.f3563d = bVar;
    }

    @Override // com.google.android.material.internal.m0
    public final g2 s(View view, g2 g2Var, androidx.recyclerview.widget.o0 o0Var) {
        if (this.f3560a) {
            o0Var.f2200d = g2Var.a() + o0Var.f2200d;
        }
        boolean f4 = n0.f(view);
        if (this.f3561b) {
            if (f4) {
                o0Var.f2199c = g2Var.b() + o0Var.f2199c;
            } else {
                o0Var.f2197a = g2Var.b() + o0Var.f2197a;
            }
        }
        if (this.f3562c) {
            if (f4) {
                o0Var.f2197a = g2Var.c() + o0Var.f2197a;
            } else {
                o0Var.f2199c = g2Var.c() + o0Var.f2199c;
            }
        }
        int i4 = o0Var.f2197a;
        int i5 = o0Var.f2198b;
        int i6 = o0Var.f2199c;
        int i7 = o0Var.f2200d;
        WeakHashMap weakHashMap = y0.f4999a;
        i0.h0.k(view, i4, i5, i6, i7);
        m0 m0Var = this.f3563d;
        if (m0Var != null) {
            return m0Var.s(view, g2Var, o0Var);
        }
        return g2Var;
    }
}