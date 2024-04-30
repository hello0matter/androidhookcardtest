package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import e1.a;
import e1.b;
import e1.c;

@RestrictTo({RestrictTo.Scope.f169a})
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVar = remoteActionCompat.f1371a;
        boolean z4 = true;
        if (aVar.e(1)) {
            cVar = aVar.g();
        }
        remoteActionCompat.f1371a = (IconCompat) cVar;
        CharSequence charSequence = remoteActionCompat.f1372b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f4434e);
        }
        remoteActionCompat.f1372b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1373c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f4434e);
        }
        remoteActionCompat.f1373c = charSequence2;
        remoteActionCompat.f1374d = (PendingIntent) aVar.f(remoteActionCompat.f1374d, 4);
        boolean z5 = remoteActionCompat.f1375e;
        if (aVar.e(5)) {
            if (((b) aVar).f4434e.readInt() != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        remoteActionCompat.f1375e = z5;
        boolean z6 = remoteActionCompat.f1376f;
        if (aVar.e(6)) {
            if (((b) aVar).f4434e.readInt() == 0) {
                z4 = false;
            }
            z6 = z4;
        }
        remoteActionCompat.f1376f = z6;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1371a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1372b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f4434e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1373c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f1374d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z4 = remoteActionCompat.f1375e;
        aVar.h(5);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = remoteActionCompat.f1376f;
        aVar.h(6);
        parcel.writeInt(z5 ? 1 : 0);
    }
}