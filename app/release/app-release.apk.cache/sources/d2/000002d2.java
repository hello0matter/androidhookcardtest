package androidx.profileinstaller;

import androidx.activity.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;
import x0.c;
import x0.l;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f1942a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f1943b = {112, 114, 109, 0};

    public static byte[] a(c[] cVarArr, byte[] bArr) {
        int i4 = 0;
        for (c cVar : cVarArr) {
            i4 += ((((cVar.f7111g * 2) + 7) & (-8)) / 8) + (cVar.f7109e * 2) + b(cVar.f7105a, cVar.f7106b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + cVar.f7110f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i4);
        if (Arrays.equals(bArr, l.f7125c)) {
            for (c cVar2 : cVarArr) {
                k(byteArrayOutputStream, cVar2, b(cVar2.f7105a, cVar2.f7106b, bArr));
                m(byteArrayOutputStream, cVar2);
                int[] iArr = cVar2.f7112h;
                int length = iArr.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    int i7 = iArr[i5];
                    com.google.common.collect.c.g2(byteArrayOutputStream, i7 - i6);
                    i5++;
                    i6 = i7;
                }
                l(byteArrayOutputStream, cVar2);
            }
        } else {
            for (c cVar3 : cVarArr) {
                k(byteArrayOutputStream, cVar3, b(cVar3.f7105a, cVar3.f7106b, bArr));
            }
            for (c cVar4 : cVarArr) {
                m(byteArrayOutputStream, cVar4);
                int[] iArr2 = cVar4.f7112h;
                int length2 = iArr2.length;
                int i8 = 0;
                int i9 = 0;
                while (i8 < length2) {
                    int i10 = iArr2[i8];
                    com.google.common.collect.c.g2(byteArrayOutputStream, i10 - i9);
                    i8++;
                    i9 = i10;
                }
                l(byteArrayOutputStream, cVar4);
            }
        }
        if (byteArrayOutputStream.size() == i4) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i4);
    }

    public static String b(String str, String str2, byte[] bArr) {
        Object obj;
        byte[] bArr2 = l.f7127e;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = l.f7126d;
        String str3 = "!";
        if (!equals && !Arrays.equals(bArr, bArr3)) {
            obj = "!";
        } else {
            obj = ":";
        }
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            if (":".equals(obj)) {
                return str2.replace("!", ":");
            }
            return str2;
        } else if (str2.equals("classes.dex")) {
            return str;
        } else {
            if (!str2.contains("!") && !str2.contains(":")) {
                if (str2.endsWith(".apk")) {
                    return str2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                    str3 = ":";
                }
                return j.e(sb, str3, str2);
            } else if ("!".equals(obj)) {
                return str2.replace(":", "!");
            } else {
                if (":".equals(obj)) {
                    return str2.replace("!", ":");
                }
                return str2;
            }
        }
    }

    public static int c(int i4, int i5, int i6) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 4) {
                    return i5 + i6;
                }
                throw new IllegalStateException(j.b("Unexpected flag: ", i4));
            }
            return i5;
        }
        throw new IllegalStateException("HOT methods are not stored in the bitmap");
    }

    public static int[] d(ByteArrayInputStream byteArrayInputStream, int i4) {
        int[] iArr = new int[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += (int) com.google.common.collect.c.I1(byteArrayInputStream, 2);
            iArr[i6] = i5;
        }
        return iArr;
    }

    public static c[] e(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, c[] cVarArr) {
        byte[] bArr3 = l.f7128f;
        if (Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(l.f7123a, bArr2)) {
                if (Arrays.equals(bArr, bArr3)) {
                    int I1 = (int) com.google.common.collect.c.I1(fileInputStream, 1);
                    byte[] G1 = com.google.common.collect.c.G1(fileInputStream, (int) com.google.common.collect.c.I1(fileInputStream, 4), (int) com.google.common.collect.c.I1(fileInputStream, 4));
                    if (fileInputStream.read() <= 0) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(G1);
                        try {
                            c[] f4 = f(byteArrayInputStream, I1, cVarArr);
                            byteArrayInputStream.close();
                            return f4;
                        } catch (Throwable th) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    throw new IllegalStateException("Content found after the end of file");
                }
                throw new IllegalStateException("Unsupported meta version");
            }
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, l.f7129g)) {
            int I12 = (int) com.google.common.collect.c.I1(fileInputStream, 2);
            byte[] G12 = com.google.common.collect.c.G1(fileInputStream, (int) com.google.common.collect.c.I1(fileInputStream, 4), (int) com.google.common.collect.c.I1(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(G12);
                try {
                    c[] g4 = g(byteArrayInputStream2, bArr2, I12, cVarArr);
                    byteArrayInputStream2.close();
                    return g4;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        } else {
            throw new IllegalStateException("Unsupported meta version");
        }
    }

    public static c[] f(ByteArrayInputStream byteArrayInputStream, int i4, c[] cVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i4 == cVarArr.length) {
            String[] strArr = new String[i4];
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                iArr[i5] = (int) com.google.common.collect.c.I1(byteArrayInputStream, 2);
                strArr[i5] = new String(com.google.common.collect.c.F1(byteArrayInputStream, (int) com.google.common.collect.c.I1(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            }
            for (int i6 = 0; i6 < i4; i6++) {
                c cVar = cVarArr[i6];
                if (cVar.f7106b.equals(strArr[i6])) {
                    int i7 = iArr[i6];
                    cVar.f7109e = i7;
                    cVar.f7112h = d(byteArrayInputStream, i7);
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return cVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static c[] g(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i4, c[] cVarArr) {
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i4 == cVarArr.length) {
            for (int i5 = 0; i5 < i4; i5++) {
                com.google.common.collect.c.I1(byteArrayInputStream, 2);
                String str2 = new String(com.google.common.collect.c.F1(byteArrayInputStream, (int) com.google.common.collect.c.I1(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
                long I1 = com.google.common.collect.c.I1(byteArrayInputStream, 4);
                int I12 = (int) com.google.common.collect.c.I1(byteArrayInputStream, 2);
                c cVar = null;
                if (cVarArr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(":");
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= cVarArr.length) {
                            break;
                        } else if (cVarArr[i6].f7106b.equals(str)) {
                            cVar = cVarArr[i6];
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
                if (cVar != null) {
                    cVar.f7108d = I1;
                    int[] d4 = d(byteArrayInputStream, I12);
                    if (Arrays.equals(bArr, l.f7127e)) {
                        cVar.f7109e = I12;
                        cVar.f7112h = d4;
                    }
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return cVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static c[] h(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, l.f7124b)) {
            int I1 = (int) com.google.common.collect.c.I1(fileInputStream, 1);
            byte[] G1 = com.google.common.collect.c.G1(fileInputStream, (int) com.google.common.collect.c.I1(fileInputStream, 4), (int) com.google.common.collect.c.I1(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(G1);
                try {
                    c[] i4 = i(byteArrayInputStream, str, I1);
                    byteArrayInputStream.close();
                    return i4;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported version");
    }

    public static c[] i(ByteArrayInputStream byteArrayInputStream, String str, int i4) {
        TreeMap treeMap;
        int i5;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        c[] cVarArr = new c[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            int I1 = (int) com.google.common.collect.c.I1(byteArrayInputStream, 2);
            cVarArr[i6] = new c(str, new String(com.google.common.collect.c.F1(byteArrayInputStream, (int) com.google.common.collect.c.I1(byteArrayInputStream, 2)), StandardCharsets.UTF_8), com.google.common.collect.c.I1(byteArrayInputStream, 4), I1, (int) com.google.common.collect.c.I1(byteArrayInputStream, 4), (int) com.google.common.collect.c.I1(byteArrayInputStream, 4), new int[I1], new TreeMap());
        }
        for (int i7 = 0; i7 < i4; i7++) {
            c cVar = cVarArr[i7];
            int available = byteArrayInputStream.available() - cVar.f7110f;
            int i8 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = cVar.f7113i;
                if (available2 <= available) {
                    break;
                }
                i8 += (int) com.google.common.collect.c.I1(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i8), 1);
                for (int I12 = (int) com.google.common.collect.c.I1(byteArrayInputStream, 2); I12 > 0; I12--) {
                    com.google.common.collect.c.I1(byteArrayInputStream, 2);
                    int I13 = (int) com.google.common.collect.c.I1(byteArrayInputStream, 1);
                    if (I13 != 6 && I13 != 7) {
                        while (I13 > 0) {
                            com.google.common.collect.c.I1(byteArrayInputStream, 1);
                            for (int I14 = (int) com.google.common.collect.c.I1(byteArrayInputStream, 1); I14 > 0; I14--) {
                                com.google.common.collect.c.I1(byteArrayInputStream, 2);
                            }
                            I13--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() == available) {
                cVar.f7112h = d(byteArrayInputStream, cVar.f7109e);
                int i9 = cVar.f7111g;
                BitSet valueOf = BitSet.valueOf(com.google.common.collect.c.F1(byteArrayInputStream, (((i9 * 2) + 7) & (-8)) / 8));
                for (int i10 = 0; i10 < i9; i10++) {
                    if (valueOf.get(c(2, i10, i9))) {
                        i5 = 2;
                    } else {
                        i5 = 0;
                    }
                    if (valueOf.get(c(4, i10, i9))) {
                        i5 |= 4;
                    }
                    if (i5 != 0) {
                        Integer num = (Integer) treeMap.get(Integer.valueOf(i10));
                        if (num == null) {
                            num = 0;
                        }
                        treeMap.put(Integer.valueOf(i10), Integer.valueOf(i5 | num.intValue()));
                    }
                }
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return cVarArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean j(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, c[] cVarArr) {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = l.f7123a;
        int i4 = 0;
        if (Arrays.equals(bArr, bArr2)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                com.google.common.collect.c.g2(byteArrayOutputStream2, cVarArr.length);
                int i5 = 2;
                int i6 = 2;
                for (c cVar : cVarArr) {
                    com.google.common.collect.c.f2(byteArrayOutputStream2, cVar.f7107c, 4);
                    com.google.common.collect.c.f2(byteArrayOutputStream2, cVar.f7108d, 4);
                    com.google.common.collect.c.f2(byteArrayOutputStream2, cVar.f7111g, 4);
                    String b5 = b(cVar.f7105a, cVar.f7106b, bArr2);
                    Charset charset = StandardCharsets.UTF_8;
                    int length2 = b5.getBytes(charset).length;
                    com.google.common.collect.c.g2(byteArrayOutputStream2, length2);
                    i6 = i6 + 14 + length2;
                    byteArrayOutputStream2.write(b5.getBytes(charset));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i6 == byteArray.length) {
                    b bVar = new b(FileSectionType.DEX_FILES, byteArray, false);
                    byteArrayOutputStream2.close();
                    arrayList2.add(bVar);
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < cVarArr.length) {
                        try {
                            c cVar2 = cVarArr[i7];
                            com.google.common.collect.c.g2(byteArrayOutputStream3, i7);
                            com.google.common.collect.c.g2(byteArrayOutputStream3, cVar2.f7109e);
                            i8 = i8 + 4 + (cVar2.f7109e * 2);
                            int[] iArr = cVar2.f7112h;
                            int length3 = iArr.length;
                            int i9 = i4;
                            int i10 = i9;
                            while (i9 < length3) {
                                int i11 = iArr[i9];
                                com.google.common.collect.c.g2(byteArrayOutputStream3, i11 - i10);
                                i9++;
                                i10 = i11;
                            }
                            i7++;
                            i4 = 0;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    if (i8 == byteArray2.length) {
                        b bVar2 = new b(FileSectionType.CLASSES, byteArray2, true);
                        byteArrayOutputStream3.close();
                        arrayList2.add(bVar2);
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < cVarArr.length) {
                            try {
                                c cVar3 = cVarArr[i12];
                                int i14 = 0;
                                for (Map.Entry entry : cVar3.f7113i.entrySet()) {
                                    i14 |= ((Integer) entry.getValue()).intValue();
                                }
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                l(byteArrayOutputStream4, cVar3);
                                byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                                byteArrayOutputStream4.close();
                                ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                                m(byteArrayOutputStream5, cVar3);
                                byte[] byteArray4 = byteArrayOutputStream5.toByteArray();
                                byteArrayOutputStream5.close();
                                com.google.common.collect.c.g2(byteArrayOutputStream3, i12);
                                int length4 = byteArray3.length + i5 + byteArray4.length;
                                int i15 = i13 + 6;
                                ArrayList arrayList4 = arrayList3;
                                com.google.common.collect.c.f2(byteArrayOutputStream3, length4, 4);
                                com.google.common.collect.c.g2(byteArrayOutputStream3, i14);
                                byteArrayOutputStream3.write(byteArray3);
                                byteArrayOutputStream3.write(byteArray4);
                                i13 = i15 + length4;
                                i12++;
                                arrayList3 = arrayList4;
                                i5 = 2;
                            } finally {
                                try {
                                    byteArrayOutputStream3.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
                        if (i13 == byteArray5.length) {
                            b bVar3 = new b(FileSectionType.METHODS, byteArray5, true);
                            byteArrayOutputStream3.close();
                            arrayList2.add(bVar3);
                            long j4 = 4;
                            long size = j4 + j4 + 4 + (arrayList2.size() * 16);
                            com.google.common.collect.c.f2(byteArrayOutputStream, arrayList2.size(), 4);
                            int i16 = 0;
                            while (i16 < arrayList2.size()) {
                                b bVar4 = (b) arrayList2.get(i16);
                                com.google.common.collect.c.f2(byteArrayOutputStream, bVar4.f1944a.f1941a, 4);
                                com.google.common.collect.c.f2(byteArrayOutputStream, size, 4);
                                boolean z4 = bVar4.f1946c;
                                byte[] bArr3 = bVar4.f1945b;
                                if (z4) {
                                    byte[] R = com.google.common.collect.c.R(bArr3);
                                    arrayList = arrayList5;
                                    arrayList.add(R);
                                    com.google.common.collect.c.f2(byteArrayOutputStream, R.length, 4);
                                    com.google.common.collect.c.f2(byteArrayOutputStream, bArr3.length, 4);
                                    length = R.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr3);
                                    com.google.common.collect.c.f2(byteArrayOutputStream, bArr3.length, 4);
                                    com.google.common.collect.c.f2(byteArrayOutputStream, 0L, 4);
                                    length = bArr3.length;
                                }
                                size += length;
                                i16++;
                                arrayList5 = arrayList;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int i17 = 0; i17 < arrayList6.size(); i17++) {
                                byteArrayOutputStream.write((byte[]) arrayList6.get(i17));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray5.length);
                    }
                    throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
                }
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
        byte[] bArr4 = l.f7124b;
        if (Arrays.equals(bArr, bArr4)) {
            byte[] a5 = a(cVarArr, bArr4);
            com.google.common.collect.c.f2(byteArrayOutputStream, cVarArr.length, 1);
            com.google.common.collect.c.f2(byteArrayOutputStream, a5.length, 4);
            byte[] R2 = com.google.common.collect.c.R(a5);
            com.google.common.collect.c.f2(byteArrayOutputStream, R2.length, 4);
            byteArrayOutputStream.write(R2);
            return true;
        }
        byte[] bArr5 = l.f7126d;
        if (Arrays.equals(bArr, bArr5)) {
            com.google.common.collect.c.f2(byteArrayOutputStream, cVarArr.length, 1);
            for (c cVar4 : cVarArr) {
                String b6 = b(cVar4.f7105a, cVar4.f7106b, bArr5);
                Charset charset2 = StandardCharsets.UTF_8;
                com.google.common.collect.c.g2(byteArrayOutputStream, b6.getBytes(charset2).length);
                com.google.common.collect.c.g2(byteArrayOutputStream, cVar4.f7112h.length);
                com.google.common.collect.c.f2(byteArrayOutputStream, cVar4.f7113i.size() * 4, 4);
                com.google.common.collect.c.f2(byteArrayOutputStream, cVar4.f7107c, 4);
                byteArrayOutputStream.write(b6.getBytes(charset2));
                for (Integer num : cVar4.f7113i.keySet()) {
                    com.google.common.collect.c.g2(byteArrayOutputStream, num.intValue());
                    com.google.common.collect.c.g2(byteArrayOutputStream, 0);
                }
                for (int i18 : cVar4.f7112h) {
                    com.google.common.collect.c.g2(byteArrayOutputStream, i18);
                }
            }
            return true;
        }
        byte[] bArr6 = l.f7125c;
        if (Arrays.equals(bArr, bArr6)) {
            byte[] a6 = a(cVarArr, bArr6);
            com.google.common.collect.c.f2(byteArrayOutputStream, cVarArr.length, 1);
            com.google.common.collect.c.f2(byteArrayOutputStream, a6.length, 4);
            byte[] R3 = com.google.common.collect.c.R(a6);
            com.google.common.collect.c.f2(byteArrayOutputStream, R3.length, 4);
            byteArrayOutputStream.write(R3);
            return true;
        }
        byte[] bArr7 = l.f7127e;
        if (Arrays.equals(bArr, bArr7)) {
            com.google.common.collect.c.g2(byteArrayOutputStream, cVarArr.length);
            for (c cVar5 : cVarArr) {
                String b7 = b(cVar5.f7105a, cVar5.f7106b, bArr7);
                Charset charset3 = StandardCharsets.UTF_8;
                com.google.common.collect.c.g2(byteArrayOutputStream, b7.getBytes(charset3).length);
                TreeMap treeMap = cVar5.f7113i;
                com.google.common.collect.c.g2(byteArrayOutputStream, treeMap.size());
                com.google.common.collect.c.g2(byteArrayOutputStream, cVar5.f7112h.length);
                com.google.common.collect.c.f2(byteArrayOutputStream, cVar5.f7107c, 4);
                byteArrayOutputStream.write(b7.getBytes(charset3));
                for (Integer num2 : treeMap.keySet()) {
                    com.google.common.collect.c.g2(byteArrayOutputStream, num2.intValue());
                }
                for (int i19 : cVar5.f7112h) {
                    com.google.common.collect.c.g2(byteArrayOutputStream, i19);
                }
            }
            return true;
        }
        return false;
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, c cVar, String str) {
        Charset charset = StandardCharsets.UTF_8;
        com.google.common.collect.c.g2(byteArrayOutputStream, str.getBytes(charset).length);
        com.google.common.collect.c.g2(byteArrayOutputStream, cVar.f7109e);
        com.google.common.collect.c.f2(byteArrayOutputStream, cVar.f7110f, 4);
        com.google.common.collect.c.f2(byteArrayOutputStream, cVar.f7107c, 4);
        com.google.common.collect.c.f2(byteArrayOutputStream, cVar.f7111g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, c cVar) {
        byte[] bArr = new byte[(((cVar.f7111g * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : cVar.f7113i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i4 = intValue2 & 2;
            int i5 = cVar.f7111g;
            if (i4 != 0) {
                int c4 = c(2, intValue, i5);
                int i6 = c4 / 8;
                bArr[i6] = (byte) ((1 << (c4 % 8)) | bArr[i6]);
            }
            if ((intValue2 & 4) != 0) {
                int c5 = c(4, intValue, i5);
                int i7 = c5 / 8;
                bArr[i7] = (byte) ((1 << (c5 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, c cVar) {
        int i4 = 0;
        for (Map.Entry entry : cVar.f7113i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                com.google.common.collect.c.g2(byteArrayOutputStream, intValue - i4);
                com.google.common.collect.c.g2(byteArrayOutputStream, 0);
                i4 = intValue;
            }
        }
    }
}