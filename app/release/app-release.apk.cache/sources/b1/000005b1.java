package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final class d extends m {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4027e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(l lVar, int i4) {
        super(lVar);
        this.f4027e = i4;
    }

    @Override // com.google.android.material.textfield.m
    public final void r() {
        switch (this.f4027e) {
            case 0:
                l lVar = this.f4072b;
                lVar.f4063o = null;
                CheckableImageButton checkableImageButton = lVar.f4055g;
                checkableImageButton.setOnLongClickListener(null);
                com.google.common.collect.c.P1(checkableImageButton, null);
                return;
            default:
                return;
        }
    }
}