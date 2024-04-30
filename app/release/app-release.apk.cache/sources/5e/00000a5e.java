package y3;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes.dex */
public interface h extends t, ReadableByteChannel {
    ByteString e(long j4);

    String g(long j4);

    void h(long j4);

    short i();

    int k();

    int m(m mVar);

    String n();

    void o(long j4);

    f q();

    boolean r();

    long t();

    String u(Charset charset);

    byte v();
}