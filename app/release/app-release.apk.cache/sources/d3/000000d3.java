package androidx.appcompat.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.f2;
import androidx.appcompat.widget.s3;
import androidx.appcompat.widget.z0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.example.msphone.FloatingWindowService;
import com.example.msphone.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.button.MaterialButtonToggleGroup;
import i0.d2;
import i0.g2;
import i0.t1;
import i0.v1;
import i0.w1;
import i0.y0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class o0 implements f2, g.c0, g.n, z0, androidx.core.widget.l, i0.w, i0.i, j0.v, androidx.emoji2.text.m, x0.d, androidx.activity.result.b, com.google.android.material.internal.m0, com.google.android.material.button.a {

    /* renamed from: c  reason: collision with root package name */
    public static Field f308c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f309d;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f310a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f311b;

    public o0(int i4) {
        this.f310a = i4;
        if (i4 == 7) {
            this.f311b = new HashMap();
        } else if (i4 == 12) {
            int i5 = Build.VERSION.SDK_INT;
            this.f311b = i5 >= 30 ? new w1() : i5 >= 29 ? new v1() : new t1();
        } else if (i4 != 22) {
            this.f311b = new ArrayDeque();
        }
    }

    @Override // g.c0
    public final void a(g.p pVar, boolean z4) {
        if (pVar instanceof g.j0) {
            pVar.k().c(false);
        }
        g.c0 c0Var = ((androidx.appcompat.widget.n) this.f311b).f4613e;
        if (c0Var != null) {
            c0Var.a(pVar, z4);
        }
    }

    @Override // g.n
    public final void b(g.p pVar) {
        g.n nVar = ((ActionMenuView) this.f311b).f460v;
        if (nVar != null) {
            nVar.b(pVar);
        }
    }

    @Override // androidx.emoji2.text.m
    public final void c(final com.google.common.collect.c cVar) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Runnable() { // from class: androidx.emoji2.text.q
            @Override // java.lang.Runnable
            public final void run() {
                o0 o0Var = o0.this;
                com.google.common.collect.c cVar2 = cVar;
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                o0Var.getClass();
                try {
                    a0 X = com.google.common.collect.c.X((Context) o0Var.f311b);
                    if (X != null) {
                        z zVar = (z) X.f1522a;
                        synchronized (zVar.f1562d) {
                            zVar.f1564f = threadPoolExecutor2;
                        }
                        X.f1522a.c(new r(cVar2, threadPoolExecutor2));
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th) {
                    cVar2.k1(th);
                    threadPoolExecutor2.shutdown();
                }
            }
        });
    }

    @Override // i0.i
    public final ClipData d() {
        ClipData clip;
        clip = ((ContentInfo) this.f311b).getClip();
        return clip;
    }

    @Override // j0.v
    public final boolean e(View view) {
        int width;
        boolean z4 = false;
        switch (this.f310a) {
            case 14:
                ((DrawerLayout) this.f311b).getClass();
                if (!DrawerLayout.k(view) || ((DrawerLayout) this.f311b).g(view) == 2) {
                    return false;
                }
                ((DrawerLayout) this.f311b).b(view, true);
                return true;
            default:
                if (!((SwipeDismissBehavior) this.f311b).w(view)) {
                    return false;
                }
                WeakHashMap weakHashMap = y0.f4999a;
                if (i0.h0.d(view) == 1) {
                    z4 = true;
                }
                int i4 = ((SwipeDismissBehavior) this.f311b).f3012d;
                if ((i4 == 0 && z4) || (i4 == 1 && !z4)) {
                    width = -view.getWidth();
                } else {
                    width = view.getWidth();
                }
                view.offsetLeftAndRight(width);
                view.setAlpha(0.0f);
                ((SwipeDismissBehavior) this.f311b).getClass();
                return true;
        }
    }

    @Override // g.c0
    public final boolean f(g.p pVar) {
        Object obj = this.f311b;
        if (pVar == ((androidx.appcompat.widget.n) obj).f4611c) {
            return false;
        }
        ((androidx.appcompat.widget.n) obj).f853y = ((g.j0) pVar).A.f4722a;
        g.c0 c0Var = ((androidx.appcompat.widget.n) obj).f4613e;
        if (c0Var == null) {
            return false;
        }
        return c0Var.f(pVar);
    }

    @Override // i0.i
    public final int g() {
        int flags;
        flags = ((ContentInfo) this.f311b).getFlags();
        return flags;
    }

    @Override // x0.d
    public final void h() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i0.w
    public final g2 i(View view, g2 g2Var) {
        boolean z4;
        int i4 = 0;
        boolean z5 = true;
        d2 d2Var = g2Var.f4931a;
        g2 g2Var2 = null;
        switch (this.f310a) {
            case 9:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f311b;
                if (!h0.b.a(coordinatorLayout.f1340n, g2Var)) {
                    coordinatorLayout.f1340n = g2Var;
                    if (g2Var.d() > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    coordinatorLayout.f1341o = z4;
                    if (z4 || coordinatorLayout.getBackground() != null) {
                        z5 = false;
                    }
                    coordinatorLayout.setWillNotDraw(z5);
                    if (!d2Var.m()) {
                        int childCount = coordinatorLayout.getChildCount();
                        while (i4 < childCount) {
                            View childAt = coordinatorLayout.getChildAt(i4);
                            WeakHashMap weakHashMap = y0.f4999a;
                            if (!i0.g0.b(childAt) || ((androidx.coordinatorlayout.widget.b) childAt.getLayoutParams()).f1347a == null || !d2Var.m()) {
                                i4++;
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return g2Var;
            case 25:
                AppBarLayout appBarLayout = (AppBarLayout) this.f311b;
                appBarLayout.getClass();
                WeakHashMap weakHashMap2 = y0.f4999a;
                if (i0.g0.b(appBarLayout)) {
                    g2Var2 = g2Var;
                }
                if (!h0.b.a(appBarLayout.f2874g, g2Var2)) {
                    appBarLayout.f2874g = g2Var2;
                    if (appBarLayout.f2889v != null && appBarLayout.getTopInset() > 0) {
                        i4 = 1;
                    }
                    appBarLayout.setWillNotDraw(i4 ^ 1);
                    appBarLayout.requestLayout();
                }
                return g2Var;
            default:
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.f311b;
                collapsingToolbarLayout.getClass();
                WeakHashMap weakHashMap3 = y0.f4999a;
                if (!i0.g0.b(collapsingToolbarLayout)) {
                    g2Var = null;
                }
                if (!h0.b.a(collapsingToolbarLayout.A, g2Var)) {
                    collapsingToolbarLayout.A = g2Var;
                    collapsingToolbarLayout.requestLayout();
                }
                return d2Var.c();
        }
    }

    @Override // i0.i
    public final ContentInfo j() {
        return (ContentInfo) this.f311b;
    }

    @Override // androidx.activity.result.b
    public final void k(Object obj) {
        MainActivity mainActivity = (MainActivity) this.f311b;
        ActivityResult activityResult = (ActivityResult) obj;
        mainActivity.getClass();
        if (Settings.canDrawOverlays(mainActivity)) {
            mainActivity.startService(new Intent(mainActivity, FloatingWindowService.class));
        }
    }

    @Override // x0.d
    public final void l(int i4, Object obj) {
        String str;
        switch (i4) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case VisibleForTesting.PROTECTED /* 4 */:
                str = "RESULT_NOT_WRITABLE";
                break;
            case VisibleForTesting.NONE /* 5 */:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i4 != 6 && i4 != 7 && i4 != 8) {
            Log.d("ProfileInstaller", str);
        } else {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
        ((ProfileInstallReceiver) this.f311b).setResultCode(i4);
    }

    @Override // androidx.appcompat.widget.f2
    public final void m(g.p pVar, g.r rVar) {
        g.i iVar = null;
        ((g.j) this.f311b).f4659g.removeCallbacksAndMessages(null);
        int size = ((g.j) this.f311b).f4661i.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                if (pVar == ((g.i) ((g.j) this.f311b).f4661i.get(i4)).f4632b) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 == -1) {
            return;
        }
        int i5 = i4 + 1;
        if (i5 < ((g.j) this.f311b).f4661i.size()) {
            iVar = (g.i) ((g.j) this.f311b).f4661i.get(i5);
        }
        ((g.j) this.f311b).f4659g.postAtTime(new g.h(this, iVar, rVar, pVar, 0), pVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.z0
    public void n(int i4) {
    }

    @Override // androidx.appcompat.widget.z0
    public void o(int i4) {
    }

    @Override // g.n
    public final boolean p(g.p pVar, MenuItem menuItem) {
        androidx.appcompat.widget.q qVar = ((ActionMenuView) this.f311b).A;
        if (qVar != null) {
            Iterator it = ((CopyOnWriteArrayList) ((s3) qVar).f896a.G.f193b).iterator();
            if (it.hasNext()) {
                androidx.activity.j.f(it.next());
                throw null;
            }
            return false;
        }
        return false;
    }

    @Override // i0.i
    public final int q() {
        int source;
        source = ((ContentInfo) this.f311b).getSource();
        return source;
    }

    @Override // androidx.appcompat.widget.f2
    public final void r(g.p pVar, MenuItem menuItem) {
        ((g.j) this.f311b).f4659g.removeCallbacksAndMessages(pVar);
    }

    @Override // com.google.android.material.internal.m0
    public final g2 s(View view, g2 g2Var, androidx.recyclerview.widget.o0 o0Var) {
        int i4;
        o0Var.f2200d = g2Var.a() + o0Var.f2200d;
        WeakHashMap weakHashMap = y0.f4999a;
        boolean z4 = true;
        if (i0.h0.d(view) != 1) {
            z4 = false;
        }
        int b5 = g2Var.b();
        int c4 = g2Var.c();
        int i5 = o0Var.f2197a;
        if (z4) {
            i4 = c4;
        } else {
            i4 = b5;
        }
        int i6 = i5 + i4;
        o0Var.f2197a = i6;
        int i7 = o0Var.f2199c;
        if (!z4) {
            b5 = c4;
        }
        int i8 = i7 + b5;
        o0Var.f2199c = i8;
        i0.h0.k(view, i6, o0Var.f2198b, i8, o0Var.f2200d);
        return g2Var;
    }

    @Override // androidx.core.widget.l
    public final void t(NestedScrollView nestedScrollView) {
    }

    public final String toString() {
        switch (this.f310a) {
            case 11:
                return "ContentInfoCompat{" + ((ContentInfo) this.f311b) + "}";
            default:
                return super.toString();
        }
    }

    public final void u(m3.w wVar) {
        m3.q qVar;
        Charset charset;
        int i4 = wVar.f5627d;
        if (200 <= i4 && i4 < 300) {
            CompletableFuture completableFuture = (CompletableFuture) this.f311b;
            m3.y yVar = wVar.f5630g;
            yVar.getClass();
            y3.h hVar = ((m3.x) yVar).f5639c;
            try {
                m3.x xVar = (m3.x) yVar;
                int i5 = xVar.f5637a;
                Object obj = xVar.f5640d;
                switch (i5) {
                    case 0:
                        qVar = (m3.q) obj;
                        break;
                    default:
                        String str = (String) obj;
                        if (str != null) {
                            Pattern pattern = m3.q.f5552c;
                            try {
                                qVar = androidx.fragment.app.m0.k(str);
                                break;
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                        qVar = null;
                        break;
                }
                if (qVar == null || (charset = qVar.a(l3.a.f5399a)) == null) {
                    charset = l3.a.f5399a;
                }
                String u4 = hVar.u(n3.b.s(hVar, charset));
                com.google.common.collect.c.P(hVar, null);
                completableFuture.complete(u4);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    com.google.common.collect.c.P(hVar, th);
                    throw th2;
                }
            }
        }
        ((CompletableFuture) this.f311b).completeExceptionally(new IOException("Unexpected code " + wVar));
    }

    public final long v() {
        return ((ByteBuffer) this.f311b).getInt() & 4294967295L;
    }

    public void w(int i4, View view) {
        if (!f309d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f308c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f309d = true;
        }
        Field field = f308c;
        if (field != null) {
            try {
                f308c.setInt(view, i4 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public final void x(int i4) {
        Object obj = this.f311b;
        ((ByteBuffer) obj).position(((ByteBuffer) obj).position() + i4);
    }

    public /* synthetic */ o0(int i4, Object obj) {
        this.f310a = i4;
        this.f311b = obj;
    }

    public o0(Context context) {
        this.f310a = 17;
        this.f311b = context.getApplicationContext();
    }

    public o0(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f310a = 13;
        this.f311b = Build.VERSION.SDK_INT >= 25 ? new l0.g(uri, clipDescription, uri2) : new c(uri, clipDescription, uri2);
    }

    public o0(ContentInfo contentInfo) {
        this.f310a = 11;
        contentInfo.getClass();
        this.f311b = f2.h.o(contentInfo);
    }

    public o0(TextView textView) {
        this.f310a = 19;
        h0.e.c(textView, "textView cannot be null");
        this.f311b = new s0.i(textView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this(29, materialButtonToggleGroup);
        this.f310a = 29;
    }

    public o0(ByteBuffer byteBuffer) {
        this.f310a = 18;
        this.f311b = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
}