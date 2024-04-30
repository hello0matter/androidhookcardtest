package x;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class e extends z.e {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f7064b = 0;

    public static void c(Activity activity, String[] strArr, int i4) {
        String[] strArr2;
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (!TextUtils.isEmpty(strArr[i5])) {
                if (!e0.a.a() && TextUtils.equals(strArr[i5], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i5));
                }
            } else {
                throw new IllegalArgumentException(androidx.activity.j.e(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[strArr.length - size];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < strArr.length; i7++) {
                if (!hashSet.contains(Integer.valueOf(i7))) {
                    strArr2[i6] = strArr[i7];
                    i6++;
                }
            }
        }
        if (activity instanceof d) {
            ((d) activity).getClass();
        }
        b.b(activity, strArr, i4);
    }
}