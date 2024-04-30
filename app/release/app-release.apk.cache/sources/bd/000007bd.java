package k2;

import android.graphics.Paint;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f5132i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f5133j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f5134k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f5135l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f5136a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f5137b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f5138c;

    /* renamed from: d  reason: collision with root package name */
    public int f5139d;

    /* renamed from: e  reason: collision with root package name */
    public int f5140e;

    /* renamed from: f  reason: collision with root package name */
    public int f5141f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f5142g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public final Paint f5143h;

    public a() {
        Paint paint = new Paint();
        this.f5143h = paint;
        this.f5136a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f5137b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f5138c = new Paint(paint2);
    }

    public final void a(int i4) {
        this.f5139d = b0.a.e(i4, 68);
        this.f5140e = b0.a.e(i4, 20);
        this.f5141f = b0.a.e(i4, 0);
        this.f5136a.setColor(this.f5139d);
    }
}