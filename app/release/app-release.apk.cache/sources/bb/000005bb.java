package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4075a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f4076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4077c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f4078d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o f4079e;

    public n(o oVar, int i4, TextView textView, int i5, TextView textView2) {
        this.f4079e = oVar;
        this.f4075a = i4;
        this.f4076b = textView;
        this.f4077c = i5;
        this.f4078d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AppCompatTextView appCompatTextView;
        int i4 = this.f4075a;
        o oVar = this.f4079e;
        oVar.f4093n = i4;
        oVar.f4091l = null;
        TextView textView = this.f4076b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f4077c == 1 && (appCompatTextView = oVar.f4097r) != null) {
                appCompatTextView.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f4078d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f4078d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}