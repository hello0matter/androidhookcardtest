package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import e1.a;
import e1.b;
import java.nio.charset.Charset;

@RestrictTo({RestrictTo.Scope.f169a})
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        int i4 = iconCompat.f1383a;
        if (aVar.e(1)) {
            i4 = ((b) aVar).f4434e.readInt();
        }
        iconCompat.f1383a = i4;
        byte[] bArr = iconCompat.f1385c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f4434e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f1385c = bArr;
        iconCompat.f1386d = aVar.f(iconCompat.f1386d, 3);
        int i5 = iconCompat.f1387e;
        if (aVar.e(4)) {
            i5 = ((b) aVar).f4434e.readInt();
        }
        iconCompat.f1387e = i5;
        int i6 = iconCompat.f1388f;
        if (aVar.e(5)) {
            i6 = ((b) aVar).f4434e.readInt();
        }
        iconCompat.f1388f = i6;
        iconCompat.f1389g = (ColorStateList) aVar.f(iconCompat.f1389g, 6);
        String str = iconCompat.f1391i;
        if (aVar.e(7)) {
            str = ((b) aVar).f4434e.readString();
        }
        iconCompat.f1391i = str;
        String str2 = iconCompat.f1392j;
        if (aVar.e(8)) {
            str2 = ((b) aVar).f4434e.readString();
        }
        iconCompat.f1392j = str2;
        iconCompat.f1390h = PorterDuff.Mode.valueOf(iconCompat.f1391i);
        switch (iconCompat.f1383a) {
            case LabelVisibilityMode.LABEL_VISIBILITY_AUTO /* -1 */:
                parcelable = iconCompat.f1386d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f1384b = parcelable;
                break;
            case 1:
            case VisibleForTesting.NONE /* 5 */:
                parcelable = iconCompat.f1386d;
                if (parcelable == null) {
                    byte[] bArr3 = iconCompat.f1385c;
                    iconCompat.f1384b = bArr3;
                    iconCompat.f1383a = 3;
                    iconCompat.f1387e = 0;
                    iconCompat.f1388f = bArr3.length;
                    break;
                }
                iconCompat.f1384b = parcelable;
                break;
            case 2:
            case VisibleForTesting.PROTECTED /* 4 */:
            case 6:
                String str3 = new String(iconCompat.f1385c, Charset.forName("UTF-16"));
                iconCompat.f1384b = str3;
                if (iconCompat.f1383a == 2 && iconCompat.f1392j == null) {
                    iconCompat.f1392j = str3.split(":", -1)[0];
                    break;
                }
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                iconCompat.f1384b = iconCompat.f1385c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f1391i = iconCompat.f1390h.name();
        switch (iconCompat.f1383a) {
            case LabelVisibilityMode.LABEL_VISIBILITY_AUTO /* -1 */:
            case 1:
            case VisibleForTesting.NONE /* 5 */:
                iconCompat.f1386d = (Parcelable) iconCompat.f1384b;
                break;
            case 2:
                iconCompat.f1385c = ((String) iconCompat.f1384b).getBytes(Charset.forName("UTF-16"));
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                iconCompat.f1385c = (byte[]) iconCompat.f1384b;
                break;
            case VisibleForTesting.PROTECTED /* 4 */:
            case 6:
                iconCompat.f1385c = iconCompat.f1384b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i4 = iconCompat.f1383a;
        if (-1 != i4) {
            aVar.h(1);
            ((b) aVar).f4434e.writeInt(i4);
        }
        byte[] bArr = iconCompat.f1385c;
        if (bArr != null) {
            aVar.h(2);
            int length = bArr.length;
            Parcel parcel = ((b) aVar).f4434e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1386d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f4434e.writeParcelable(parcelable, 0);
        }
        int i5 = iconCompat.f1387e;
        if (i5 != 0) {
            aVar.h(4);
            ((b) aVar).f4434e.writeInt(i5);
        }
        int i6 = iconCompat.f1388f;
        if (i6 != 0) {
            aVar.h(5);
            ((b) aVar).f4434e.writeInt(i6);
        }
        ColorStateList colorStateList = iconCompat.f1389g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f4434e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f1391i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f4434e.writeString(str);
        }
        String str2 = iconCompat.f1392j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f4434e.writeString(str2);
        }
    }
}