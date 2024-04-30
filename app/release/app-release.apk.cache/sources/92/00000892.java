package m3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes.dex */
public final class m implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f5533a;

    public m(String[] strArr) {
        this.f5533a = strArr;
    }

    public final String a(String str) {
        com.google.common.collect.c.F(str, "name");
        String[] strArr = this.f5533a;
        int length = strArr.length - 2;
        int L0 = com.google.common.collect.c.L0(length, 0, -2);
        if (L0 <= length) {
            while (!l3.g.j2(str, strArr[length])) {
                if (length != L0) {
                    length -= 2;
                }
            }
            return strArr[length + 1];
        }
        return null;
    }

    public final String b(int i4) {
        return this.f5533a[i4 * 2];
    }

    public final l c() {
        l lVar = new l();
        ArrayList arrayList = lVar.f5532a;
        com.google.common.collect.c.F(arrayList, "<this>");
        String[] strArr = this.f5533a;
        com.google.common.collect.c.F(strArr, "elements");
        List asList = Arrays.asList(strArr);
        com.google.common.collect.c.E(asList, "asList(this)");
        arrayList.addAll(asList);
        return lVar;
    }

    public final String d(int i4) {
        return this.f5533a[(i4 * 2) + 1];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            if (Arrays.equals(this.f5533a, ((m) obj).f5533a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5533a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i4 = 0; i4 < size; i4++) {
            pairArr[i4] = new Pair(b(i4), d(i4));
        }
        return new y2.a(pairArr);
    }

    public final int size() {
        return this.f5533a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            String b5 = b(i4);
            String d4 = d(i4);
            sb.append(b5);
            sb.append(": ");
            if (n3.b.q(b5)) {
                d4 = "██";
            }
            sb.append(d4);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        com.google.common.collect.c.E(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}