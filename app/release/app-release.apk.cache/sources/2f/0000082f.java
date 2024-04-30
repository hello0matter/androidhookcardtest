package kotlin.text;

import androidx.activity.j;
import com.google.common.collect.c;
import e3.p;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import l3.g;
import y2.h;

/* loaded from: classes.dex */
public abstract class b extends g {
    public static List A2(CharSequence charSequence, final char[] cArr) {
        c.F(charSequence, "<this>");
        if (cArr.length == 1) {
            String valueOf = String.valueOf(cArr[0]);
            z2(0);
            int s22 = s2(0, charSequence, valueOf, false);
            if (s22 != -1) {
                ArrayList arrayList = new ArrayList(10);
                int i4 = 0;
                do {
                    arrayList.add(charSequence.subSequence(i4, s22).toString());
                    i4 = valueOf.length() + s22;
                    s22 = s2(i4, charSequence, valueOf, false);
                } while (s22 != -1);
                arrayList.add(charSequence.subSequence(i4, charSequence.length()).toString());
                return arrayList;
            }
            return c.c1(charSequence.toString());
        }
        z2(0);
        l3.c<i3.c> cVar = new l3.c(charSequence, 0, 0, new p() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            @Override // e3.p
            public final Pair b(CharSequence charSequence2, Integer num) {
                int intValue = num.intValue();
                c.F(charSequence2, "$this$$receiver");
                int v2 = b.v2(intValue, charSequence2, r2, cArr);
                if (v2 < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(v2), 1);
            }
        });
        ArrayList arrayList2 = new ArrayList(h.h2(new k3.c(cVar)));
        for (i3.c cVar2 : cVar) {
            c.F(cVar2, "range");
            arrayList2.add(charSequence.subSequence(cVar2.f5064a, cVar2.f5065b + 1).toString());
        }
        return arrayList2;
    }

    public static String B2(String str) {
        c.F(str, "<this>");
        c.F(str, "missingDelimiterValue");
        int w22 = w2(str, '.', 0, 6);
        if (w22 != -1) {
            String substring = str.substring(w22 + 1, str.length());
            c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static CharSequence C2(CharSequence charSequence) {
        int i4;
        boolean z4;
        c.F(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z5 = false;
        while (i5 <= length) {
            if (!z5) {
                i4 = i5;
            } else {
                i4 = length;
            }
            char charAt = charSequence.charAt(i4);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z5) {
                if (!z4) {
                    z5 = true;
                } else {
                    i5++;
                }
            } else if (!z4) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static boolean p2(CharSequence charSequence, char c4) {
        if (t2(charSequence, c4, 0, false, 2) < 0) {
            return false;
        }
        return true;
    }

    public static boolean q2(CharSequence charSequence, String str) {
        c.F(charSequence, "<this>");
        if (u2(charSequence, str, 0, false, 2) < 0) {
            return false;
        }
        return true;
    }

    public static final int r2(CharSequence charSequence) {
        c.F(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x004c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int s2(int r9, java.lang.CharSequence r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r0 = "<this>"
            com.google.common.collect.c.F(r10, r0)
            java.lang.String r0 = "string"
            com.google.common.collect.c.F(r11, r0)
            if (r12 != 0) goto L19
            boolean r0 = r10 instanceof java.lang.String
            if (r0 != 0) goto L11
            goto L19
        L11:
            java.lang.String r10 = (java.lang.String) r10
            int r9 = r10.indexOf(r11, r9)
            goto L70
        L19:
            int r0 = r10.length()
            i3.c r1 = new i3.c
            if (r9 >= 0) goto L22
            r9 = 0
        L22:
            int r2 = r10.length()
            if (r0 <= r2) goto L29
            r0 = r2
        L29:
            r2 = 1
            r1.<init>(r9, r0, r2)
            boolean r0 = r10 instanceof java.lang.String
            int r2 = r1.f5066c
            int r1 = r1.f5065b
            if (r0 == 0) goto L53
            if (r2 <= 0) goto L39
            if (r9 <= r1) goto L3d
        L39:
            if (r2 >= 0) goto L6f
            if (r1 > r9) goto L6f
        L3d:
            r7 = r10
            java.lang.String r7 = (java.lang.String) r7
            int r5 = r11.length()
            r3 = 0
            r4 = r9
            r6 = r11
            r8 = r12
            boolean r0 = l3.g.l2(r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L4f
            goto L70
        L4f:
            if (r9 == r1) goto L6f
            int r9 = r9 + r2
            goto L3d
        L53:
            if (r2 <= 0) goto L57
            if (r9 <= r1) goto L5b
        L57:
            if (r2 >= 0) goto L6f
            if (r1 > r9) goto L6f
        L5b:
            int r7 = r11.length()
            r4 = 0
            r3 = r11
            r5 = r10
            r6 = r9
            r8 = r12
            boolean r0 = x2(r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L6b
            goto L70
        L6b:
            if (r9 == r1) goto L6f
            int r9 = r9 + r2
            goto L5b
        L6f:
            r9 = -1
        L70:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.b.s2(int, java.lang.CharSequence, java.lang.String, boolean):int");
    }

    public static int t2(CharSequence charSequence, char c4, int i4, boolean z4, int i5) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        c.F(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c4, i4);
        }
        return v2(i4, charSequence, z4, new char[]{c4});
    }

    public static /* synthetic */ int u2(CharSequence charSequence, String str, int i4, boolean z4, int i5) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return s2(i4, charSequence, str, z4);
    }

    public static final int v2(int i4, CharSequence charSequence, boolean z4, char[] cArr) {
        int i5;
        c.F(charSequence, "<this>");
        c.F(cArr, "chars");
        boolean z5 = true;
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(h.n2(cArr), i4);
        }
        if (i4 < 0) {
            i4 = 0;
        }
        i3.a aVar = new i3.a(i4, r2(charSequence), 1);
        int i6 = aVar.f5065b;
        int i7 = aVar.f5066c;
        if (i7 <= 0 ? i4 < i6 : i4 > i6) {
            z5 = false;
        }
        if (!z5) {
            i4 = i6;
        }
        while (z5) {
            if (i4 == i6) {
                if (z5) {
                    i5 = i4;
                    z5 = false;
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                i5 = i4 + i7;
            }
            char charAt = charSequence.charAt(i4);
            for (char c4 : cArr) {
                if (c.l0(c4, charAt, z4)) {
                    return i4;
                }
            }
            i4 = i5;
        }
        return -1;
    }

    public static int w2(CharSequence charSequence, char c4, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i4 = r2(charSequence);
        }
        c.F(charSequence, "<this>");
        if (!(charSequence instanceof String)) {
            char[] cArr = {c4};
            if (charSequence instanceof String) {
                return ((String) charSequence).lastIndexOf(h.n2(cArr), i4);
            }
            int r22 = r2(charSequence);
            if (i4 > r22) {
                i4 = r22;
            }
            while (-1 < i4) {
                if (c.l0(cArr[0], charSequence.charAt(i4), false)) {
                    return i4;
                }
                i4--;
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(c4, i4);
    }

    public static final boolean x2(CharSequence charSequence, int i4, CharSequence charSequence2, int i5, int i6, boolean z4) {
        c.F(charSequence, "<this>");
        c.F(charSequence2, "other");
        if (i5 < 0 || i4 < 0 || i4 > charSequence.length() - i6 || i5 > charSequence2.length() - i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!c.l0(charSequence.charAt(i4 + i7), charSequence2.charAt(i5 + i7), z4)) {
                return false;
            }
        }
        return true;
    }

    public static String y2(String str, String str2) {
        if (g.o2(str2, str, false)) {
            String substring = str2.substring(str.length());
            c.E(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str2;
    }

    public static final void z2(int i4) {
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(j.b("Limit must be non-negative, but was ", i4).toString());
    }
}