package x0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f7116a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7117b;

    /* renamed from: c  reason: collision with root package name */
    public final long f7118c;

    /* renamed from: d  reason: collision with root package name */
    public final long f7119d;

    public j(int i4, int i5, long j4, long j5) {
        this.f7116a = i4;
        this.f7117b = i5;
        this.f7118c = j4;
        this.f7119d = j5;
    }

    public static j a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            j jVar = new j(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return jVar;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f7116a);
            dataOutputStream.writeInt(this.f7117b);
            dataOutputStream.writeLong(this.f7118c);
            dataOutputStream.writeLong(this.f7119d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f7117b == jVar.f7117b && this.f7118c == jVar.f7118c && this.f7116a == jVar.f7116a && this.f7119d == jVar.f7119d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7117b), Long.valueOf(this.f7118c), Integer.valueOf(this.f7116a), Long.valueOf(this.f7119d));
    }
}