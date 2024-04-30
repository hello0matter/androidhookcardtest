package l3;

/* loaded from: classes.dex */
public abstract class h extends kotlin.text.b {
    public static String D2(String str, int i4) {
        if (i4 >= 0) {
            int length = str.length();
            if (i4 > length) {
                i4 = length;
            }
            String substring = str.substring(0, i4);
            com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
    }
}