package y;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import z.h;

/* loaded from: classes.dex */
public abstract class c extends Binder implements IInterface {
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, y.a] */
    @Override // android.os.Binder
    public final boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        b bVar;
        if (i4 >= 1 && i4 <= 16777215) {
            parcel.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        }
        if (i4 != 1598968902) {
            if (i4 != 1) {
                return super.onTransact(i4, parcel, parcel2, i5);
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                bVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                    bVar = (b) queryLocalInterface;
                } else {
                    ?? obj = new Object();
                    obj.f7147a = readStrongBinder;
                    bVar = obj;
                }
            }
            h hVar = (h) this;
            if (bVar != null) {
                hVar.f7217a.a();
            }
            return true;
        }
        parcel2.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}