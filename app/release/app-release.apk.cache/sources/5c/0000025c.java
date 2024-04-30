package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1659a;

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.FragmentManager$LaunchedFragmentInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.fragment.app.FragmentManagerState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1659a) {
            case 0:
                return new BackStackState(parcel);
            case 1:
                ?? obj = new Object();
                obj.f1593a = parcel.readString();
                obj.f1594b = parcel.readInt();
                return obj;
            case 2:
                ?? obj2 = new Object();
                obj2.f1599e = null;
                obj2.f1600f = new ArrayList();
                obj2.f1601g = new ArrayList();
                obj2.f1595a = parcel.createTypedArrayList(FragmentState.CREATOR);
                obj2.f1596b = parcel.createStringArrayList();
                obj2.f1597c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
                obj2.f1598d = parcel.readInt();
                obj2.f1599e = parcel.readString();
                obj2.f1600f = parcel.createStringArrayList();
                obj2.f1601g = parcel.createTypedArrayList(Bundle.CREATOR);
                obj2.f1602h = parcel.createTypedArrayList(FragmentManager$LaunchedFragmentInfo.CREATOR);
                return obj2;
            default:
                return new FragmentState(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f1659a) {
            case 0:
                return new BackStackState[i4];
            case 1:
                return new FragmentManager$LaunchedFragmentInfo[i4];
            case 2:
                return new FragmentManagerState[i4];
            default:
                return new FragmentState[i4];
        }
    }
}