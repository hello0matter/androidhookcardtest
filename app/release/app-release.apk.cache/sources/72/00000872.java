package l3;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class g extends f {
    public static boolean i2(String str, String str2) {
        com.google.common.collect.c.F(str, "<this>");
        return str.endsWith(str2);
    }

    public static boolean j2(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final boolean k2(String str) {
        com.google.common.collect.c.F(str, "<this>");
        if (str.length() == 0) {
            return true;
        }
        i3.a aVar = new i3.a(0, str.length() - 1, 1);
        if ((aVar instanceof Collection) && ((Collection) aVar).isEmpty()) {
            return true;
        }
        Iterator it = aVar.iterator();
        while (((i3.b) it).f5069c) {
            char charAt = str.charAt(((i3.b) it).b());
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean l2(int i4, int i5, int i6, String str, String str2, boolean z4) {
        com.google.common.collect.c.F(str, "<this>");
        com.google.common.collect.c.F(str2, "other");
        if (!z4) {
            return str.regionMatches(i4, str2, i5, i6);
        }
        return str.regionMatches(z4, i4, str2, i5, i6);
    }

    public static String m2(String str, String str2, String str3) {
        com.google.common.collect.c.F(str, "<this>");
        int s22 = kotlin.text.b.s2(0, str, str2, false);
        if (s22 >= 0) {
            int length = str2.length();
            int i4 = 1;
            if (length >= 1) {
                i4 = length;
            }
            int length2 = str3.length() + (str.length() - length);
            if (length2 >= 0) {
                StringBuilder sb = new StringBuilder(length2);
                int i5 = 0;
                do {
                    sb.append((CharSequence) str, i5, s22);
                    sb.append(str3);
                    i5 = s22 + length;
                    if (s22 >= str.length()) {
                        break;
                    }
                    s22 = kotlin.text.b.s2(s22 + i4, str, str2, false);
                } while (s22 > 0);
                sb.append((CharSequence) str, i5, str.length());
                String sb2 = sb.toString();
                com.google.common.collect.c.E(sb2, "stringBuilder.append(this, i, length).toString()");
                return sb2;
            }
            throw new OutOfMemoryError();
        }
        return str;
    }

    public static boolean n2(String str, String str2, int i4, boolean z4) {
        com.google.common.collect.c.F(str, "<this>");
        if (!z4) {
            return str.startsWith(str2, i4);
        }
        return l2(i4, 0, str2.length(), str, str2, z4);
    }

    public static boolean o2(String str, String str2, boolean z4) {
        com.google.common.collect.c.F(str, "<this>");
        com.google.common.collect.c.F(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2);
        }
        return l2(0, 0, str2.length(), str, str2, z4);
    }
}