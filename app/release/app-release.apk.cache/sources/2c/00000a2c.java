package x0;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f7097a;

    /* renamed from: b  reason: collision with root package name */
    public final d f7098b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f7099c;

    /* renamed from: d  reason: collision with root package name */
    public final File f7100d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7101e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7102f = false;

    /* renamed from: g  reason: collision with root package name */
    public c[] f7103g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f7104h;

    public b(AssetManager assetManager, h.a aVar, d dVar, String str, File file) {
        this.f7097a = aVar;
        this.f7098b = dVar;
        this.f7101e = str;
        this.f7100d = file;
        int i4 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i4 <= 33) {
            switch (i4) {
                case 24:
                case 25:
                    bArr = l.f7127e;
                    break;
                case 26:
                    bArr = l.f7126d;
                    break;
                case 27:
                    bArr = l.f7125c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = l.f7124b;
                    break;
                case 31:
                case 32:
                case 33:
                    bArr = l.f7123a;
                    break;
            }
        }
        this.f7099c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f7098b.h();
            }
            return null;
        }
    }

    public final void b(final int i4, final Serializable serializable) {
        this.f7097a.execute(new Runnable() { // from class: x0.a
            @Override // java.lang.Runnable
            public final void run() {
                int i5 = r2;
                Object obj = serializable;
                int i6 = i4;
                Object obj2 = this;
                switch (i5) {
                    case 0:
                        ((b) obj2).f7098b.l(i6, obj);
                        return;
                    default:
                        ((d) obj2).l(i6, obj);
                        return;
                }
            }
        });
    }
}