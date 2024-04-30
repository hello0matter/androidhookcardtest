package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.msphone.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Context f255a;

    /* renamed from: b  reason: collision with root package name */
    public final h0 f256b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f257c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f258d;

    /* renamed from: e  reason: collision with root package name */
    public AlertController$RecycleListView f259e;

    /* renamed from: f  reason: collision with root package name */
    public Button f260f;

    /* renamed from: g  reason: collision with root package name */
    public Button f261g;

    /* renamed from: h  reason: collision with root package name */
    public Button f262h;

    /* renamed from: i  reason: collision with root package name */
    public NestedScrollView f263i;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f265k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f266l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f267m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f268n;

    /* renamed from: o  reason: collision with root package name */
    public View f269o;

    /* renamed from: p  reason: collision with root package name */
    public ListAdapter f270p;

    /* renamed from: r  reason: collision with root package name */
    public final int f272r;

    /* renamed from: s  reason: collision with root package name */
    public final int f273s;

    /* renamed from: t  reason: collision with root package name */
    public final int f274t;

    /* renamed from: u  reason: collision with root package name */
    public final int f275u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f276v;

    /* renamed from: w  reason: collision with root package name */
    public final f f277w;

    /* renamed from: j  reason: collision with root package name */
    public int f264j = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f271q = -1;

    /* renamed from: x  reason: collision with root package name */
    public final b f278x = new b(0, this);

    /* JADX WARN: Type inference failed for: r6v1, types: [android.os.Handler, androidx.appcompat.app.f] */
    public h(Context context, h0 h0Var, Window window) {
        this.f255a = context;
        this.f256b = h0Var;
        this.f257c = window;
        ?? handler = new Handler();
        handler.f225a = new WeakReference(h0Var);
        this.f277w = handler;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, c.a.f2548f, R.attr.alertDialogStyle, 0);
        this.f272r = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.f273s = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.getResourceId(5, 0);
        this.f274t = obtainStyledAttributes.getResourceId(7, 0);
        this.f275u = obtainStyledAttributes.getResourceId(3, 0);
        this.f276v = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        h0Var.d().h(1);
    }

    public static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }
}