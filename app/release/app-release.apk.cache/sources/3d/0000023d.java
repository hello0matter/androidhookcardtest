package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.o0;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f1525i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static volatile o f1526j;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock f1527a;

    /* renamed from: b  reason: collision with root package name */
    public final l.c f1528b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1529c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1530d;

    /* renamed from: e  reason: collision with root package name */
    public final i f1531e;

    /* renamed from: f  reason: collision with root package name */
    public final m f1532f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1533g;

    /* renamed from: h  reason: collision with root package name */
    public final g f1534h;

    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.emoji2.text.i, androidx.appcompat.app.o0] */
    public o(p pVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1527a = reentrantReadWriteLock;
        this.f1529c = 3;
        this.f1532f = pVar.f1522a;
        int i4 = pVar.f1523b;
        this.f1533g = i4;
        this.f1534h = pVar.f1524c;
        this.f1530d = new Handler(Looper.getMainLooper());
        this.f1528b = new l.c();
        ?? o0Var = new o0(16, this);
        this.f1531e = o0Var;
        reentrantReadWriteLock.writeLock().lock();
        if (i4 == 0) {
            try {
                this.f1529c = 0;
            } catch (Throwable th) {
                this.f1527a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            o0Var.y();
        }
    }

    public static o a() {
        o oVar;
        boolean z4;
        synchronized (f1525i) {
            try {
                oVar = f1526j;
                if (oVar != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return oVar;
    }

    public final int b() {
        this.f1527a.readLock().lock();
        try {
            return this.f1529c;
        } finally {
            this.f1527a.readLock().unlock();
        }
    }

    public final void c() {
        boolean z4;
        if (this.f1533g == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (b() == 1) {
                return;
            }
            this.f1527a.writeLock().lock();
            try {
                if (this.f1529c == 0) {
                    return;
                }
                this.f1529c = 0;
                this.f1527a.writeLock().unlock();
                this.f1531e.y();
                return;
            } finally {
                this.f1527a.writeLock().unlock();
            }
        }
        throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1527a.writeLock().lock();
        try {
            this.f1529c = 2;
            arrayList.addAll(this.f1528b);
            this.f1528b.clear();
            this.f1527a.writeLock().unlock();
            this.f1530d.post(new androidx.activity.h(arrayList, this.f1529c, th));
        } catch (Throwable th2) {
            this.f1527a.writeLock().unlock();
            throw th2;
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f1527a.writeLock().lock();
        try {
            this.f1529c = 1;
            arrayList.addAll(this.f1528b);
            this.f1528b.clear();
            this.f1527a.writeLock().unlock();
            this.f1530d.post(new androidx.activity.h(this.f1529c, arrayList));
        } catch (Throwable th) {
            this.f1527a.writeLock().unlock();
            throw th;
        }
    }

    public final CharSequence f(int i4, int i5, CharSequence charSequence) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        if (b() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (i4 >= 0) {
                if (i5 >= 0) {
                    if (i4 <= i5) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    h0.e.a("start should be <= than end", z5);
                    if (charSequence == null) {
                        return null;
                    }
                    if (i4 <= charSequence.length()) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    h0.e.a("start should be < than charSequence length", z6);
                    if (i5 > charSequence.length()) {
                        z7 = false;
                    }
                    h0.e.a("end should be < than charSequence length", z7);
                    if (charSequence.length() != 0 && i4 != i5) {
                        return this.f1531e.z(charSequence, i4, i5, false);
                    }
                    return charSequence;
                }
                throw new IllegalArgumentException("end cannot be negative");
            }
            throw new IllegalArgumentException("start cannot be negative");
        }
        throw new IllegalStateException("Not initialized yet");
    }

    public final void g(l lVar) {
        h0.e.c(lVar, "initCallback cannot be null");
        this.f1527a.writeLock().lock();
        try {
            if (this.f1529c != 1 && this.f1529c != 2) {
                this.f1528b.add(lVar);
                this.f1527a.writeLock().unlock();
            }
            this.f1530d.post(new androidx.activity.h(lVar, this.f1529c));
            this.f1527a.writeLock().unlock();
        } catch (Throwable th) {
            this.f1527a.writeLock().unlock();
            throw th;
        }
    }
}