package kotlin.enums;

import com.google.common.collect.c;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import y2.d;

/* JADX INFO: Access modifiers changed from: package-private */
@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/enums/EnumEntriesList;", "", "T", "La3/a;", "Ly2/d;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class EnumEntriesList<T extends Enum<T>> extends d implements a3.a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Enum[] f5184a;

    public EnumEntriesList(Enum[] enumArr) {
        this.f5184a = enumArr;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.f5184a);
    }

    @Override // kotlin.collections.a
    public final int a() {
        return this.f5184a.length;
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final boolean contains(Object obj) {
        Enum r02;
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r6 = (Enum) obj;
        c.F(r6, "element");
        int ordinal = r6.ordinal();
        Enum[] enumArr = this.f5184a;
        c.F(enumArr, "<this>");
        if (ordinal >= 0 && ordinal <= enumArr.length - 1) {
            r02 = enumArr[ordinal];
        } else {
            r02 = null;
        }
        if (r02 != r6) {
            return false;
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        Enum[] enumArr = this.f5184a;
        int length = enumArr.length;
        if (i4 >= 0 && i4 < length) {
            return enumArr[i4];
        }
        throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + length);
    }

    @Override // y2.d, java.util.List
    public final int indexOf(Object obj) {
        Enum r22;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r5 = (Enum) obj;
        c.F(r5, "element");
        int ordinal = r5.ordinal();
        Enum[] enumArr = this.f5184a;
        c.F(enumArr, "<this>");
        if (ordinal >= 0 && ordinal <= enumArr.length - 1) {
            r22 = enumArr[ordinal];
        } else {
            r22 = null;
        }
        if (r22 != r5) {
            return -1;
        }
        return ordinal;
    }

    @Override // y2.d, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r22 = (Enum) obj;
        c.F(r22, "element");
        return indexOf(r22);
    }
}