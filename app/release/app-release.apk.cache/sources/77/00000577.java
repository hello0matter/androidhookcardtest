package com.google.android.material.search;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3783a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f3784b;

    public /* synthetic */ h(int i4, Object obj) {
        this.f3783a = i4;
        this.f3784b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i4 = this.f3783a;
        Object obj = this.f3784b;
        switch (i4) {
            case 0:
                SearchView searchView = (SearchView) obj;
                int i5 = SearchView.D;
                if (searchView.h()) {
                    searchView.f();
                }
                return false;
            default:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) obj;
                iVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long currentTimeMillis = System.currentTimeMillis() - iVar.f4042o;
                    if (currentTimeMillis < 0 || currentTimeMillis > 300) {
                        iVar.f4040m = false;
                    }
                    iVar.u();
                    iVar.f4040m = true;
                    iVar.f4042o = System.currentTimeMillis();
                }
                return false;
        }
    }
}