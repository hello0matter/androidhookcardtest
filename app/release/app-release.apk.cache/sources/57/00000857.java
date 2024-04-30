package l2;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.method.TransformationMethod;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.ReportFragment;

/* loaded from: classes.dex */
public class f implements x0.d {

    /* renamed from: b  reason: collision with root package name */
    public static f f5284b;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5285a;

    public f() {
        this.f5285a = 9;
    }

    public static void a(int i4, int i5) {
        if (i4 >= 0 && i4 < i5) {
            return;
        }
        throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
    }

    public static void b(int i4, int i5) {
        if (i4 >= 0 && i4 <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
    }

    public static z0.e c(z0.f fVar) {
        com.google.common.collect.c.F(fVar, "owner");
        return new z0.e(fVar);
    }

    public static void d(Activity activity, Lifecycle$Event lifecycle$Event) {
        com.google.common.collect.c.F(activity, "activity");
        com.google.common.collect.c.F(lifecycle$Event, "event");
        if (activity instanceof androidx.lifecycle.q) {
            androidx.lifecycle.s f4 = ((androidx.lifecycle.q) activity).f();
            if (f4 instanceof androidx.lifecycle.s) {
                f4.e(lifecycle$Event);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007b, code lost:
        if (r11 != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0088, code lost:
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean i(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.f.i(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static void k(Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            androidx.lifecycle.d0.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new androidx.lifecycle.d0());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public boolean e() {
        return this instanceof g;
    }

    public void f(float f4, float f5, float f6, z zVar) {
        zVar.d(f4, 0.0f);
    }

    @Override // x0.d
    public void h() {
        switch (this.f5285a) {
            case 18:
                return;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                return;
        }
    }

    @Override // x0.d
    public void l(int i4, Object obj) {
        String str;
        switch (this.f5285a) {
            case 18:
                return;
            default:
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
                    return;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    return;
                }
        }
    }

    public boolean m() {
        return false;
    }

    public boolean n(Spannable spannable) {
        return false;
    }

    public /* synthetic */ f(int i4) {
        this.f5285a = i4;
    }

    public /* synthetic */ f(int i4, int i5) {
        this.f5285a = i4;
    }

    public InputFilter[] g(InputFilter[] inputFilterArr) {
        return inputFilterArr;
    }

    public void o(boolean z4) {
    }

    public void p(boolean z4) {
    }

    public void q(boolean z4) {
    }

    public void r(boolean z4) {
    }

    public TransformationMethod t(TransformationMethod transformationMethod) {
        return transformationMethod;
    }

    public void j() {
    }

    public void s() {
    }
}