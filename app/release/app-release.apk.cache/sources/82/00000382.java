package b4;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f2530a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f2531b;

    /* renamed from: c  reason: collision with root package name */
    public int f2532c;

    /* renamed from: d  reason: collision with root package name */
    public int f2533d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2534e;

    /* renamed from: f  reason: collision with root package name */
    public int f2535f;

    /* renamed from: g  reason: collision with root package name */
    public int f2536g;

    public final String toString() {
        String simpleName = b.class.getSimpleName();
        String arrays = Arrays.toString(this.f2531b);
        int i4 = this.f2535f;
        boolean z4 = this.f2534e;
        int i5 = this.f2530a;
        int i6 = this.f2536g;
        int i7 = this.f2532c;
        int i8 = this.f2533d;
        return simpleName + "[buffer=" + arrays + ", currentLinePos=" + i4 + ", eof=" + z4 + ", ibitWorkArea=" + i5 + ", lbitWorkArea=0, modulus=" + i6 + ", pos=" + i7 + ", readPos=" + i8 + "]";
    }
}