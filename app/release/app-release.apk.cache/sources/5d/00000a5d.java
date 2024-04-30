package y3;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* loaded from: classes.dex */
public interface g extends r, WritableByteChannel {
    g b(byte[] bArr);

    g c(ByteString byteString);

    g d(long j4);

    @Override // y3.r, java.io.Flushable
    void flush();

    g j(int i4);

    g l(int i4);

    g p(String str);

    g s(int i4);
}