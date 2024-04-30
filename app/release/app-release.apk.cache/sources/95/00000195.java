package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final CompoundButton f966a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f967b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f968c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f969d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f970e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f971f;

    public y(CompoundButton compoundButton) {
        this.f966a = compoundButton;
    }

    public final void a() {
        CompoundButton compoundButton = this.f966a;
        Drawable a5 = androidx.core.widget.c.a(compoundButton);
        if (a5 != null) {
            if (this.f969d || this.f970e) {
                Drawable mutate = a5.mutate();
                if (this.f969d) {
                    c0.b.h(mutate, this.f967b);
                }
                if (this.f970e) {
                    c0.b.i(mutate, this.f968c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[Catch: all -> 0x0034, TryCatch #1 {all -> 0x0034, blocks: (B:3:0x001c, B:5:0x0022, B:7:0x0028, B:16:0x004d, B:18:0x0054, B:19:0x005b, B:21:0x0062, B:11:0x0036, B:13:0x003c, B:15:0x0042), top: B:29:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #1 {all -> 0x0034, blocks: (B:3:0x001c, B:5:0x0022, B:7:0x0028, B:16:0x004d, B:18:0x0054, B:19:0x005b, B:21:0x0062, B:11:0x0036, B:13:0x003c, B:15:0x0042), top: B:29:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r6 = r10.f966a
            android.content.Context r0 = r6.getContext()
            int[] r2 = c.a.f2556n
            r7 = 0
            androidx.appcompat.widget.q3 r8 = androidx.appcompat.widget.q3.f(r0, r11, r2, r12, r7)
            android.content.res.TypedArray r9 = r8.f879b
            android.content.Context r1 = r6.getContext()
            android.content.res.TypedArray r4 = r8.f879b
            r0 = r6
            r3 = r11
            r5 = r12
            i0.y0.o(r0, r1, r2, r3, r4, r5)
            r11 = 1
            boolean r12 = r9.hasValue(r11)     // Catch: java.lang.Throwable -> L34
            if (r12 == 0) goto L36
            int r11 = r9.getResourceId(r11, r7)     // Catch: java.lang.Throwable -> L34
            if (r11 == 0) goto L36
            android.content.Context r12 = r6.getContext()     // Catch: java.lang.Throwable -> L34 android.content.res.Resources.NotFoundException -> L36
            android.graphics.drawable.Drawable r11 = com.google.common.collect.c.t0(r12, r11)     // Catch: java.lang.Throwable -> L34 android.content.res.Resources.NotFoundException -> L36
            r6.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L34 android.content.res.Resources.NotFoundException -> L36
            goto L4d
        L34:
            r11 = move-exception
            goto L73
        L36:
            boolean r11 = r9.hasValue(r7)     // Catch: java.lang.Throwable -> L34
            if (r11 == 0) goto L4d
            int r11 = r9.getResourceId(r7, r7)     // Catch: java.lang.Throwable -> L34
            if (r11 == 0) goto L4d
            android.content.Context r12 = r6.getContext()     // Catch: java.lang.Throwable -> L34
            android.graphics.drawable.Drawable r11 = com.google.common.collect.c.t0(r12, r11)     // Catch: java.lang.Throwable -> L34
            r6.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L34
        L4d:
            r11 = 2
            boolean r12 = r9.hasValue(r11)     // Catch: java.lang.Throwable -> L34
            if (r12 == 0) goto L5b
            android.content.res.ColorStateList r11 = r8.a(r11)     // Catch: java.lang.Throwable -> L34
            androidx.core.widget.b.c(r6, r11)     // Catch: java.lang.Throwable -> L34
        L5b:
            r11 = 3
            boolean r12 = r9.hasValue(r11)     // Catch: java.lang.Throwable -> L34
            if (r12 == 0) goto L6f
            r12 = -1
            int r11 = r9.getInt(r11, r12)     // Catch: java.lang.Throwable -> L34
            r12 = 0
            android.graphics.PorterDuff$Mode r11 = androidx.appcompat.widget.o1.c(r11, r12)     // Catch: java.lang.Throwable -> L34
            androidx.core.widget.b.d(r6, r11)     // Catch: java.lang.Throwable -> L34
        L6f:
            r8.g()
            return
        L73:
            r8.g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.b(android.util.AttributeSet, int):void");
    }
}