package l1;

import android.os.Build;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5272a = Build.VERSION.SDK_INT;

    static {
        String str = Build.DEVICE;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static void b(int i4) {
        Integer.toString(i4, 36);
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            sb.append(Character.forDigit((bArr[i4] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i4] & 15, 16));
        }
        return sb.toString();
    }
}