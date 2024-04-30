package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public final class f extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    public static Configuration f4446f;

    /* renamed from: a  reason: collision with root package name */
    public int f4447a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f4448b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f4449c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f4450d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f4451e;

    public f(Context context, int i4) {
        super(context);
        this.f4447a = i4;
    }

    public final void a(Configuration configuration) {
        if (this.f4451e == null) {
            if (this.f4450d == null) {
                this.f4450d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f4448b == null) {
            this.f4448b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f4448b.setTo(theme);
            }
        }
        this.f4448b.applyStyle(this.f4447a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r0.equals(f.f.f4446f) != false) goto L14;
     */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f4451e
            if (r0 != 0) goto L37
            android.content.res.Configuration r0 = r3.f4450d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = f.f.f4446f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            f.f.f4446f = r1
        L1c:
            android.content.res.Configuration r1 = f.f.f4446f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f4450d
            android.content.Context r0 = f.e.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
        L2f:
            r3.f4451e = r0
            goto L37
        L32:
            android.content.res.Resources r0 = super.getResources()
            goto L2f
        L37:
            android.content.res.Resources r0 = r3.f4451e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f.f.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f4449c == null) {
                this.f4449c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f4449c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f4448b;
        if (theme != null) {
            return theme;
        }
        if (this.f4447a == 0) {
            this.f4447a = 2131755545;
        }
        b();
        return this.f4448b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        if (this.f4447a != i4) {
            this.f4447a = i4;
            b();
        }
    }
}