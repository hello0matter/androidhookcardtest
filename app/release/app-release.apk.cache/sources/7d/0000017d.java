package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class t0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f899a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Typeface f900b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f901c;

    public t0(TextView textView, Typeface typeface, int i4) {
        this.f899a = textView;
        this.f900b = typeface;
        this.f901c = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f899a.setTypeface(this.f900b, this.f901c);
    }
}