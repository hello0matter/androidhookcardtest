package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.versionedparcelable.CustomVersionedParcelable;
import c0.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f1382k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public Object f1384b;

    /* renamed from: j  reason: collision with root package name */
    public String f1392j;

    /* renamed from: a  reason: collision with root package name */
    public int f1383a = -1;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1385c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1386d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1387e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1388f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1389g = null;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f1390h = f1382k;

    /* renamed from: i  reason: collision with root package name */
    public String f1391i = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f169a})
    /* loaded from: classes.dex */
    public @interface IconType {
    }

    public final String toString() {
        String str;
        int height;
        int i4;
        if (this.f1383a == -1) {
            return String.valueOf(this.f1384b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f1383a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                str = "DATA";
                break;
            case VisibleForTesting.PROTECTED /* 4 */:
                str = "URI";
                break;
            case VisibleForTesting.NONE /* 5 */:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f1383a) {
            case 1:
            case VisibleForTesting.NONE /* 5 */:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1384b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f1384b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1392j);
                sb.append(" id=");
                Object[] objArr = new Object[1];
                int i5 = this.f1383a;
                if (i5 == -1) {
                    int i6 = Build.VERSION.SDK_INT;
                    Object obj = this.f1384b;
                    if (i6 >= 28) {
                        i4 = d.a(obj);
                    } else {
                        try {
                            i4 = ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
                            Log.e("IconCompat", "Unable to get icon resource", e4);
                            i4 = 0;
                        }
                    }
                } else if (i5 == 2) {
                    i4 = this.f1387e;
                } else {
                    throw new IllegalStateException("called getResId() on " + this);
                }
                objArr[0] = Integer.valueOf(i4);
                sb.append(String.format("0x%08x", objArr));
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                sb.append(" len=");
                sb.append(this.f1387e);
                if (this.f1388f != 0) {
                    sb.append(" off=");
                    height = this.f1388f;
                    sb.append(height);
                    break;
                }
                break;
            case VisibleForTesting.PROTECTED /* 4 */:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1384b);
                break;
        }
        if (this.f1389g != null) {
            sb.append(" tint=");
            sb.append(this.f1389g);
        }
        if (this.f1390h != f1382k) {
            sb.append(" mode=");
            sb.append(this.f1390h);
        }
        sb.append(")");
        return sb.toString();
    }
}