package l1;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.util.GlUtil$GlException;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f5271a = new Object();

    public static void a(String str, GlUtil$GlException glUtil$GlException) {
        String replace;
        synchronized (f5271a) {
            Throwable th = glUtil$GlException;
            while (true) {
                if (th != null) {
                    try {
                        if (th instanceof UnknownHostException) {
                            replace = "UnknownHostException (no network)";
                            break;
                        }
                        th = th.getCause();
                    } finally {
                    }
                } else {
                    replace = Log.getStackTraceString(glUtil$GlException).trim().replace("\t", "    ");
                    break;
                }
            }
        }
        if (!TextUtils.isEmpty(replace)) {
            str = str + "\n  " + replace.replace("\n", "\n  ") + '\n';
        }
        synchronized (f5271a) {
            Log.e("SceneRenderer", str);
        }
    }
}