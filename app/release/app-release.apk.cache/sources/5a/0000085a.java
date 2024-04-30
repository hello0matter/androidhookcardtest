package l2;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class i extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public p f5288a;

    /* renamed from: b  reason: collision with root package name */
    public b2.a f5289b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f5290c;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f5291d;

    /* renamed from: e  reason: collision with root package name */
    public final ColorStateList f5292e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f5293f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f5294g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f5295h;

    /* renamed from: i  reason: collision with root package name */
    public final float f5296i;

    /* renamed from: j  reason: collision with root package name */
    public float f5297j;

    /* renamed from: k  reason: collision with root package name */
    public float f5298k;

    /* renamed from: l  reason: collision with root package name */
    public int f5299l;

    /* renamed from: m  reason: collision with root package name */
    public float f5300m;

    /* renamed from: n  reason: collision with root package name */
    public float f5301n;

    /* renamed from: o  reason: collision with root package name */
    public final float f5302o;

    /* renamed from: p  reason: collision with root package name */
    public int f5303p;

    /* renamed from: q  reason: collision with root package name */
    public int f5304q;

    /* renamed from: r  reason: collision with root package name */
    public int f5305r;

    /* renamed from: s  reason: collision with root package name */
    public final int f5306s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f5307t;

    /* renamed from: u  reason: collision with root package name */
    public Paint.Style f5308u;

    public i(i iVar) {
        this.f5290c = null;
        this.f5291d = null;
        this.f5292e = null;
        this.f5293f = null;
        this.f5294g = PorterDuff.Mode.SRC_IN;
        this.f5295h = null;
        this.f5296i = 1.0f;
        this.f5297j = 1.0f;
        this.f5299l = 255;
        this.f5300m = 0.0f;
        this.f5301n = 0.0f;
        this.f5302o = 0.0f;
        this.f5303p = 0;
        this.f5304q = 0;
        this.f5305r = 0;
        this.f5306s = 0;
        this.f5307t = false;
        this.f5308u = Paint.Style.FILL_AND_STROKE;
        this.f5288a = iVar.f5288a;
        this.f5289b = iVar.f5289b;
        this.f5298k = iVar.f5298k;
        this.f5290c = iVar.f5290c;
        this.f5291d = iVar.f5291d;
        this.f5294g = iVar.f5294g;
        this.f5293f = iVar.f5293f;
        this.f5299l = iVar.f5299l;
        this.f5296i = iVar.f5296i;
        this.f5305r = iVar.f5305r;
        this.f5303p = iVar.f5303p;
        this.f5307t = iVar.f5307t;
        this.f5297j = iVar.f5297j;
        this.f5300m = iVar.f5300m;
        this.f5301n = iVar.f5301n;
        this.f5302o = iVar.f5302o;
        this.f5304q = iVar.f5304q;
        this.f5306s = iVar.f5306s;
        this.f5292e = iVar.f5292e;
        this.f5308u = iVar.f5308u;
        if (iVar.f5295h != null) {
            this.f5295h = new Rect(iVar.f5295h);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        j jVar = new j(this);
        jVar.f5314e = true;
        return jVar;
    }

    public i(p pVar) {
        this.f5290c = null;
        this.f5291d = null;
        this.f5292e = null;
        this.f5293f = null;
        this.f5294g = PorterDuff.Mode.SRC_IN;
        this.f5295h = null;
        this.f5296i = 1.0f;
        this.f5297j = 1.0f;
        this.f5299l = 255;
        this.f5300m = 0.0f;
        this.f5301n = 0.0f;
        this.f5302o = 0.0f;
        this.f5303p = 0;
        this.f5304q = 0;
        this.f5305r = 0;
        this.f5306s = 0;
        this.f5307t = false;
        this.f5308u = Paint.Style.FILL_AND_STROKE;
        this.f5288a = pVar;
        this.f5289b = null;
    }
}