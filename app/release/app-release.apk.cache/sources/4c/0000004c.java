package androidx.activity;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.u1;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.msphone.MainActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import i0.g0;
import i0.y0;
import java.io.DataOutputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f106b;

    public /* synthetic */ k(int i4, Object obj) {
        this.f105a = i4;
        this.f106b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.appcompat.widget.n nVar;
        boolean z4;
        View d4;
        int width;
        int i4;
        com.google.gson.d b5;
        Instant ofEpochMilli;
        Instant now;
        boolean isAfter;
        LocalDateTime now2;
        switch (this.f105a) {
            case 0:
                try {
                    ComponentActivity.g((ComponentActivity) this.f106b);
                    return;
                } catch (IllegalStateException e4) {
                    if (TextUtils.equals(e4.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        return;
                    }
                    throw e4;
                } catch (NullPointerException e5) {
                    if (!TextUtils.equals(e5.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e5;
                    }
                    return;
                }
            case 1:
                d.b bVar = (d.b) this.f106b;
                bVar.a(true);
                bVar.invalidateSelf();
                return;
            case 2:
                u1 u1Var = (u1) this.f106b;
                u1Var.f917l = null;
                u1Var.drawableStateChanged();
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                ActionMenuView actionMenuView = ((Toolbar) this.f106b).f655a;
                if (actionMenuView != null && (nVar = actionMenuView.f458t) != null) {
                    nVar.o();
                    return;
                }
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                androidx.core.widget.h hVar = (androidx.core.widget.h) this.f106b;
                if (hVar.f1449o) {
                    if (hVar.f1447m) {
                        hVar.f1447m = false;
                        androidx.core.widget.a aVar = hVar.f1435a;
                        aVar.getClass();
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f1427e = currentAnimationTimeMillis;
                        aVar.f1429g = -1L;
                        aVar.f1428f = currentAnimationTimeMillis;
                        aVar.f1430h = 0.5f;
                    }
                    androidx.core.widget.a aVar2 = hVar.f1435a;
                    if ((aVar2.f1429g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar2.f1429g + aVar2.f1431i) || !hVar.f()) {
                        hVar.f1449o = false;
                        return;
                    }
                    if (hVar.f1448n) {
                        hVar.f1448n = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        hVar.f1437c.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (aVar2.f1428f != 0) {
                        long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float a5 = aVar2.a(currentAnimationTimeMillis2);
                        aVar2.f1428f = currentAnimationTimeMillis2;
                        androidx.core.widget.i.b(hVar.f1451q, (int) (((float) (currentAnimationTimeMillis2 - aVar2.f1428f)) * ((a5 * 4.0f) + ((-4.0f) * a5 * a5)) * aVar2.f1426d));
                        View view = hVar.f1437c;
                        WeakHashMap weakHashMap = y0.f4999a;
                        g0.m(view, this);
                        return;
                    }
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                return;
            case VisibleForTesting.NONE /* 5 */:
                ((n0.e) this.f106b).p(0);
                return;
            case 6:
                androidx.drawerlayout.widget.b bVar2 = (androidx.drawerlayout.widget.b) this.f106b;
                int i5 = bVar2.f1498r.f5730o;
                int i6 = 3;
                if (bVar2.f1497q == 3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                DrawerLayout drawerLayout = bVar2.f1500t;
                if (z4) {
                    d4 = drawerLayout.d(3);
                    if (d4 != null) {
                        i4 = -d4.getWidth();
                    } else {
                        i4 = 0;
                    }
                    width = i4 + i5;
                } else {
                    d4 = drawerLayout.d(5);
                    width = drawerLayout.getWidth() - i5;
                }
                if (d4 != null) {
                    if (((z4 && d4.getLeft() < width) || (!z4 && d4.getLeft() > width)) && drawerLayout.g(d4) == 0) {
                        bVar2.f1498r.s(d4, width, d4.getTop());
                        ((DrawerLayout.LayoutParams) d4.getLayoutParams()).f1490c = true;
                        drawerLayout.invalidate();
                        if (bVar2.f1497q == 3) {
                            i6 = 5;
                        }
                        DrawerLayout drawerLayout2 = bVar2.f1500t;
                        View d5 = drawerLayout2.d(i6);
                        if (d5 != null) {
                            drawerLayout2.b(d5, true);
                        }
                        if (!drawerLayout.f1479r) {
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
                            int childCount = drawerLayout.getChildCount();
                            for (int i7 = 0; i7 < childCount; i7++) {
                                drawerLayout.getChildAt(i7).dispatchTouchEvent(obtain2);
                            }
                            obtain2.recycle();
                            drawerLayout.f1479r = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 7:
                j.f(this.f106b);
                SystemClock.uptimeMillis();
                throw null;
            case 8:
            default:
                t1.b bVar3 = (t1.b) this.f106b;
                bVar3.f6688c = false;
                n0.e eVar = ((BottomSheetBehavior) bVar3.f6690e).M;
                if (eVar != null && eVar.g()) {
                    bVar3.a(bVar3.f6687b);
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) bVar3.f6690e;
                if (bottomSheetBehavior.L == 2) {
                    bottomSheetBehavior.J(bVar3.f6687b);
                    return;
                }
                return;
            case 9:
                ViewPager viewPager = (ViewPager) this.f106b;
                viewPager.setScrollState(0);
                viewPager.j();
                return;
            case 10:
                MainActivity mainActivity = (MainActivity) this.f106b;
                String str = MainActivity.E;
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 26) {
                    mainActivity.getClass();
                    StringBuilder sb = new StringBuilder("{\"id\":\"");
                    sb.append(MainActivity.F);
                    sb.append("\",\"we\":\"");
                    sb.append(MainActivity.G);
                    sb.append("\",\"endable\":\"");
                    sb.append(MainActivity.H);
                    sb.append("\",\"logit\":\"");
                    now2 = LocalDateTime.now();
                    sb.append(now2);
                    sb.append("\",\"time\":\"");
                    MainActivity.I = j.e(sb, MainActivity.E, "\",\"dj\":\"\"}");
                }
                mainActivity.getClass();
                String r4 = MainActivity.r();
                String o4 = MainActivity.o(MainActivity.n(MainActivity.q(), r4), r4);
                try {
                    b5 = com.google.common.collect.c.A1(MainActivity.p(((String) h1.c.a(MainActivity.s(mainActivity.A, mainActivity.B), MainActivity.n(MainActivity.I, o4)).get()).replaceAll("\"", ""), o4)).b();
                } catch (Exception unused) {
                    mainActivity.finish();
                    System.exit(0);
                }
                if (b5.f4211a.containsKey("data")) {
                    com.google.gson.d b6 = b5.e("data").b();
                    if (b6.f4211a.containsKey("cdk")) {
                        if (i8 >= 26) {
                            ofEpochMilli = Instant.ofEpochMilli(b6.e("outtime").c());
                            now = Instant.now();
                            isAfter = ofEpochMilli.isAfter(now);
                            if (isAfter) {
                                if (b6.e("cdk").a() == 0) {
                                    try {
                                        Process exec = Runtime.getRuntime().exec("su");
                                        DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
                                        dataOutputStream.writeBytes("pm uninstall " + mainActivity.getPackageName() + "\n");
                                        dataOutputStream.flush();
                                        dataOutputStream.writeBytes("exit\n");
                                        dataOutputStream.flush();
                                        exec.waitFor();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                        }
                        mainActivity.C.postDelayed(this, 120000L);
                        return;
                    }
                }
                mainActivity.finish();
                System.exit(0);
                mainActivity.C.postDelayed(this, 120000L);
                return;
        }
    }
}