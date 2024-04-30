package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class x3 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f950a;

    /* renamed from: b  reason: collision with root package name */
    public int f951b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollingTabContainerView f952c;

    /* renamed from: d  reason: collision with root package name */
    public View f953d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f954e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f955f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f956g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f957h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f958i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f959j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f960k;

    /* renamed from: l  reason: collision with root package name */
    public Window.Callback f961l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f962m;

    /* renamed from: n  reason: collision with root package name */
    public n f963n;

    /* renamed from: o  reason: collision with root package name */
    public int f964o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f965p;

    public final void a(int i4) {
        View view;
        int i5 = this.f951b ^ i4;
        this.f951b = i4;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i4 & 4) != 0) {
                    b();
                }
                int i6 = this.f951b & 4;
                Toolbar toolbar = this.f950a;
                if (i6 != 0) {
                    Drawable drawable = this.f956g;
                    if (drawable == null) {
                        drawable = this.f965p;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i5 & 3) != 0) {
                c();
            }
            int i7 = i5 & 8;
            Toolbar toolbar2 = this.f950a;
            if (i7 != 0) {
                if ((i4 & 8) != 0) {
                    toolbar2.setTitle(this.f958i);
                    toolbar2.setSubtitle(this.f959j);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i5 & 16) != 0 && (view = this.f953d) != null) {
                if ((i4 & 16) != 0) {
                    toolbar2.addView(view);
                } else {
                    toolbar2.removeView(view);
                }
            }
        }
    }

    public final void b() {
        if ((this.f951b & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f960k);
            Toolbar toolbar = this.f950a;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f964o);
            } else {
                toolbar.setNavigationContentDescription(this.f960k);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i4 = this.f951b;
        if ((i4 & 2) == 0) {
            drawable = null;
        } else if ((i4 & 1) == 0 || (drawable = this.f955f) == null) {
            drawable = this.f954e;
        }
        this.f950a.setLogo(drawable);
    }
}