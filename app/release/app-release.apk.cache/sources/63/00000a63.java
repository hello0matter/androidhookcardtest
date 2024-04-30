package y3;

import java.util.RandomAccess;
import okio.ByteString;

/* loaded from: classes.dex */
public final class m extends y2.d implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public final ByteString[] f7192a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f7193b;

    public m(ByteString[] byteStringArr, int[] iArr) {
        this.f7192a = byteStringArr;
        this.f7193b = iArr;
    }

    @Override // kotlin.collections.a
    public final int a() {
        return this.f7192a.length;
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return super.contains((ByteString) obj);
    }

    @Override // java.util.List
    public final Object get(int i4) {
        return this.f7192a[i4];
    }

    @Override // y2.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return super.indexOf((ByteString) obj);
    }

    @Override // y2.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return super.lastIndexOf((ByteString) obj);
    }
}