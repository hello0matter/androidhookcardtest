package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import java.nio.MappedByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class z implements m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1559a;

    /* renamed from: b  reason: collision with root package name */
    public final f0.e f1560b;

    /* renamed from: c  reason: collision with root package name */
    public final x f1561c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1562d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f1563e;

    /* renamed from: f  reason: collision with root package name */
    public Executor f1564f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadPoolExecutor f1565g;

    /* renamed from: h  reason: collision with root package name */
    public com.google.common.collect.c f1566h;

    /* renamed from: i  reason: collision with root package name */
    public m0.a f1567i;

    public z(Context context, f0.e eVar) {
        x xVar = a0.f1504d;
        this.f1562d = new Object();
        h0.e.c(context, "Context cannot be null");
        this.f1559a = context.getApplicationContext();
        this.f1560b = eVar;
        this.f1561c = xVar;
    }

    public final void a() {
        synchronized (this.f1562d) {
            try {
                this.f1566h = null;
                m0.a aVar = this.f1567i;
                if (aVar != null) {
                    x xVar = this.f1561c;
                    Context context = this.f1559a;
                    xVar.getClass();
                    context.getContentResolver().unregisterContentObserver(aVar);
                    this.f1567i = null;
                }
                Handler handler = this.f1563e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f1563e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f1565g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f1564f = null;
                this.f1565g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f1562d) {
            try {
                if (this.f1566h == null) {
                    return;
                }
                if (this.f1564f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f1565g = threadPoolExecutor;
                    this.f1564f = threadPoolExecutor;
                }
                this.f1564f.execute(new Runnable(this) { // from class: androidx.emoji2.text.y

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ z f1558b;

                    {
                        this.f1558b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (r2) {
                            case 0:
                                z zVar = this.f1558b;
                                synchronized (zVar.f1562d) {
                                    try {
                                        if (zVar.f1566h != null) {
                                            try {
                                                f0.k d4 = zVar.d();
                                                int i4 = d4.f4539e;
                                                if (i4 == 2) {
                                                    synchronized (zVar.f1562d) {
                                                    }
                                                }
                                                if (i4 == 0) {
                                                    int i5 = e0.j.f4429a;
                                                    e0.i.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                                    x xVar = zVar.f1561c;
                                                    Context context = zVar.f1559a;
                                                    xVar.getClass();
                                                    Typeface b5 = b0.h.f2498a.b(context, new f0.k[]{d4}, 0);
                                                    MappedByteBuffer e4 = b0.p.e(zVar.f1559a, d4.f4535a);
                                                    if (e4 != null && b5 != null) {
                                                        try {
                                                            e0.i.a("EmojiCompat.MetadataRepo.create");
                                                            d0 d0Var = new d0(b5, b0.a(e4));
                                                            e0.i.b();
                                                            e0.i.b();
                                                            synchronized (zVar.f1562d) {
                                                                com.google.common.collect.c cVar = zVar.f1566h;
                                                                if (cVar != null) {
                                                                    cVar.q1(d0Var);
                                                                }
                                                            }
                                                            zVar.a();
                                                            return;
                                                        } catch (Throwable th) {
                                                            int i6 = e0.j.f4429a;
                                                            e0.i.b();
                                                            throw th;
                                                        }
                                                    }
                                                    throw new RuntimeException("Unable to open file.");
                                                }
                                                throw new RuntimeException("fetchFonts result is not OK. (" + i4 + ")");
                                            } catch (Throwable th2) {
                                                synchronized (zVar.f1562d) {
                                                    try {
                                                        com.google.common.collect.c cVar2 = zVar.f1566h;
                                                        if (cVar2 != null) {
                                                            cVar2.k1(th2);
                                                        }
                                                        zVar.a();
                                                        return;
                                                    } finally {
                                                    }
                                                }
                                            }
                                        }
                                        return;
                                    } finally {
                                    }
                                }
                            default:
                                this.f1558b.b();
                                return;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.emoji2.text.m
    public final void c(com.google.common.collect.c cVar) {
        synchronized (this.f1562d) {
            this.f1566h = cVar;
        }
        b();
    }

    public final f0.k d() {
        try {
            x xVar = this.f1561c;
            Context context = this.f1559a;
            f0.e eVar = this.f1560b;
            xVar.getClass();
            f0.j a5 = f0.d.a(context, eVar);
            int i4 = a5.f4533a;
            if (i4 == 0) {
                f0.k[] kVarArr = a5.f4534b;
                if (kVarArr != null && kVarArr.length != 0) {
                    return kVarArr[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            throw new RuntimeException("fetchFonts failed (" + i4 + ")");
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("provider not found", e4);
        }
    }
}