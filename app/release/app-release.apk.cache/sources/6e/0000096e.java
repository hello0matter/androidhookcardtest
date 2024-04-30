package r0;

import java.nio.ByteBuffer;
import l2.f;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public int f6451a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f6452b;

    /* renamed from: c  reason: collision with root package name */
    public int f6453c;

    /* renamed from: d  reason: collision with root package name */
    public int f6454d;

    public c() {
        if (f.f5284b == null) {
            f.f5284b = new f();
        }
    }

    public final int a(int i4) {
        if (i4 < this.f6454d) {
            return this.f6452b.getShort(this.f6453c + i4);
        }
        return 0;
    }
}