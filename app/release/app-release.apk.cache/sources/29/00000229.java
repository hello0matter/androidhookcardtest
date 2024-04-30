package androidx.emoji2.text;

import androidx.appcompat.app.o0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

/* loaded from: classes.dex */
public abstract class b0 {
    /* JADX WARN: Type inference failed for: r0v2, types: [r0.b, r0.c] */
    public static r0.b a(MappedByteBuffer mappedByteBuffer) {
        long j4;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        o0 o0Var = new o0(duplicate);
        o0Var.x(4);
        int i4 = ((ByteBuffer) o0Var.f311b).getShort() & 65535;
        if (i4 <= 100) {
            o0Var.x(6);
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    int i6 = ((ByteBuffer) o0Var.f311b).getInt();
                    o0Var.x(4);
                    j4 = o0Var.v();
                    o0Var.x(4);
                    if (1835365473 == i6) {
                        break;
                    }
                    i5++;
                } else {
                    j4 = -1;
                    break;
                }
            }
            if (j4 != -1) {
                o0Var.x((int) (j4 - ((ByteBuffer) o0Var.f311b).position()));
                o0Var.x(12);
                long v2 = o0Var.v();
                for (int i7 = 0; i7 < v2; i7++) {
                    int i8 = ((ByteBuffer) o0Var.f311b).getInt();
                    long v4 = o0Var.v();
                    o0Var.v();
                    if (1164798569 == i8 || 1701669481 == i8) {
                        duplicate.position((int) (v4 + j4));
                        ?? cVar = new r0.c();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int position = duplicate.position() + duplicate.getInt(duplicate.position());
                        cVar.f6452b = duplicate;
                        cVar.f6451a = position;
                        int i9 = position - duplicate.getInt(position);
                        cVar.f6453c = i9;
                        cVar.f6454d = cVar.f6452b.getShort(i9);
                        return cVar;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }
}