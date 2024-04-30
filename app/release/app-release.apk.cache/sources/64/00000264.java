package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class d1 extends Writer {

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f1677b = new StringBuilder(128);

    /* renamed from: a  reason: collision with root package name */
    public final String f1676a = "FragmentManager";

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        x();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        x();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            char c4 = cArr[i4 + i6];
            if (c4 == '\n') {
                x();
            } else {
                this.f1677b.append(c4);
            }
        }
    }

    public final void x() {
        StringBuilder sb = this.f1677b;
        if (sb.length() > 0) {
            Log.d(this.f1676a, sb.toString());
            sb.delete(0, sb.length());
        }
    }
}