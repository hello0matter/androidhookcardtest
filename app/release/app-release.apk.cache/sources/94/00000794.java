package i2;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f5046a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextPaint f5047b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f5048c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f5049d;

    public f(g gVar, Context context, TextPaint textPaint, h hVar) {
        this.f5049d = gVar;
        this.f5046a = context;
        this.f5047b = textPaint;
        this.f5048c = hVar;
    }

    @Override // i2.h
    public final void a(int i4) {
        this.f5048c.a(i4);
    }

    @Override // i2.h
    public final void b(Typeface typeface, boolean z4) {
        this.f5049d.g(this.f5046a, this.f5047b, typeface);
        this.f5048c.b(typeface, z4);
    }
}