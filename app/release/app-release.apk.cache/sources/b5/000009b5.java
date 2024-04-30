package t3;

import okio.ByteString;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f6736a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f6737b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f6738c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f6739d;

    static {
        ByteString byteString = ByteString.f6049d;
        f6736a = a.h("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f6737b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f6738c = new String[64];
        String[] strArr = new String[256];
        for (int i4 = 0; i4 < 256; i4++) {
            String binaryString = Integer.toBinaryString(i4);
            com.google.common.collect.c.E(binaryString, "toBinaryString(it)");
            String replace = n3.b.i("%8s", binaryString).replace(' ', '0');
            com.google.common.collect.c.E(replace, "this as java.lang.String…replace(oldChar, newChar)");
            strArr[i4] = replace;
        }
        f6739d = strArr;
        String[] strArr2 = f6738c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i5 = iArr[0];
        strArr2[i5 | 8] = androidx.activity.j.e(new StringBuilder(), strArr2[i5], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            int i8 = iArr[0];
            String[] strArr3 = f6738c;
            int i9 = i8 | i7;
            strArr3[i9] = strArr3[i8] + '|' + strArr3[i7];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i8]);
            sb.append('|');
            strArr3[i9 | 8] = androidx.activity.j.e(sb, strArr3[i7], "|PADDED");
        }
        int length = f6738c.length;
        for (int i10 = 0; i10 < length; i10++) {
            String[] strArr4 = f6738c;
            if (strArr4[i10] == null) {
                strArr4[i10] = f6739d[i10];
            }
        }
    }

    public static String a(boolean z4, int i4, int i5, int i6, int i7) {
        String i8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String[] strArr = f6737b;
        if (i6 < strArr.length) {
            i8 = strArr[i6];
        } else {
            i8 = n3.b.i("0x%02x", Integer.valueOf(i6));
        }
        if (i7 == 0) {
            str = "";
        } else {
            String[] strArr2 = f6739d;
            if (i6 != 2 && i6 != 3) {
                if (i6 != 4 && i6 != 6) {
                    if (i6 != 7 && i6 != 8) {
                        String[] strArr3 = f6738c;
                        if (i7 < strArr3.length) {
                            str2 = strArr3[i7];
                            com.google.common.collect.c.C(str2);
                        } else {
                            str2 = strArr2[i7];
                        }
                        if (i6 == 5 && (i7 & 4) != 0) {
                            str3 = "PUSH_PROMISE";
                            str4 = "HEADERS";
                        } else if (i6 == 0 && (i7 & 32) != 0) {
                            str3 = "COMPRESSED";
                            str4 = "PRIORITY";
                        } else {
                            str = str2;
                        }
                        str = l3.g.m2(str2, str4, str3);
                    }
                } else if (i7 == 1) {
                    str = "ACK";
                } else {
                    str = strArr2[i7];
                }
            }
            str = strArr2[i7];
        }
        if (z4) {
            str5 = "<<";
        } else {
            str5 = ">>";
        }
        return n3.b.i("%s 0x%08x %5d %-13s %s", str5, Integer.valueOf(i4), Integer.valueOf(i5), i8, str);
    }
}