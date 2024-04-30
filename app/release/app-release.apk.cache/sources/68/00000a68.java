package y3;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface r extends Closeable, Flushable {
    v a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void f(f fVar, long j4);

    void flush();
}