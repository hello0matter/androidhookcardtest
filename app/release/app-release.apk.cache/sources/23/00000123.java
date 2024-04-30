package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class b4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f716a;

    /* renamed from: b  reason: collision with root package name */
    public final View f717b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f718c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f719d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f720e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f721f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f722g;

    public b4(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f719d = layoutParams;
        this.f720e = new Rect();
        this.f721f = new int[2];
        this.f722g = new int[2];
        this.f716a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f717b = inflate;
        this.f718c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(b4.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 2131755012;
        layoutParams.flags = 24;
    }
}