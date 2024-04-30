package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.o0;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements a1.b {
    @Override // a1.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // a1.b
    public final /* bridge */ /* synthetic */ Object b(Context context) {
        c(context);
        return Boolean.TRUE;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.emoji2.text.j, androidx.emoji2.text.p] */
    public final void c(Context context) {
        Object obj;
        ?? jVar = new j(new o0(context));
        jVar.f1523b = 1;
        if (o.f1526j == null) {
            synchronized (o.f1525i) {
                try {
                    if (o.f1526j == null) {
                        o.f1526j = new o(jVar);
                    }
                } finally {
                }
            }
        }
        a1.a c4 = a1.a.c(context);
        c4.getClass();
        synchronized (a1.a.f53e) {
            try {
                obj = c4.f54a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c4.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final androidx.lifecycle.s f4 = ((androidx.lifecycle.q) obj).f();
        f4.a(new androidx.lifecycle.d() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.d
            public final void a() {
                Handler handler;
                EmojiCompatInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = c.a(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new s(0), 500L);
                f4.b(this);
            }
        });
    }
}