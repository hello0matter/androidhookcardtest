package k1;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.ParcelableSparseBooleanArray;
import com.google.android.material.internal.ParcelableSparseIntArray;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5118a;

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, com.google.android.material.badge.BadgeState$State] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4 = 0;
        switch (this.f5118a) {
            case 0:
                return new Object();
            case 1:
                return new SpliceScheduleCommand(parcel);
            case 2:
                return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return new VorbisComment(parcel);
            case VisibleForTesting.PROTECTED /* 4 */:
                return new DownloadRequest(parcel);
            case VisibleForTesting.NONE /* 5 */:
                return new StreamKey(parcel);
            case 6:
                return new Requirements(parcel.readInt());
            case 7:
                ?? obj = new Object();
                obj.f2982i = 255;
                obj.f2984k = -2;
                obj.f2985l = -2;
                obj.f2986m = -2;
                obj.f2993t = Boolean.TRUE;
                obj.f2974a = parcel.readInt();
                obj.f2975b = (Integer) parcel.readSerializable();
                obj.f2976c = (Integer) parcel.readSerializable();
                obj.f2977d = (Integer) parcel.readSerializable();
                obj.f2978e = (Integer) parcel.readSerializable();
                obj.f2979f = (Integer) parcel.readSerializable();
                obj.f2980g = (Integer) parcel.readSerializable();
                obj.f2981h = (Integer) parcel.readSerializable();
                obj.f2982i = parcel.readInt();
                obj.f2983j = parcel.readString();
                obj.f2984k = parcel.readInt();
                obj.f2985l = parcel.readInt();
                obj.f2986m = parcel.readInt();
                obj.f2988o = parcel.readString();
                obj.f2989p = parcel.readString();
                obj.f2990q = parcel.readInt();
                obj.f2992s = (Integer) parcel.readSerializable();
                obj.f2994u = (Integer) parcel.readSerializable();
                obj.f2995v = (Integer) parcel.readSerializable();
                obj.f2996w = (Integer) parcel.readSerializable();
                obj.f2997x = (Integer) parcel.readSerializable();
                obj.f2998y = (Integer) parcel.readSerializable();
                obj.f2999z = (Integer) parcel.readSerializable();
                obj.C = (Integer) parcel.readSerializable();
                obj.A = (Integer) parcel.readSerializable();
                obj.B = (Integer) parcel.readSerializable();
                obj.f2993t = (Boolean) parcel.readSerializable();
                obj.f2987n = (Locale) parcel.readSerializable();
                obj.D = (Boolean) parcel.readSerializable();
                return obj;
            case 8:
                int readInt = parcel.readInt();
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(readInt);
                int[] iArr = new int[readInt];
                boolean[] zArr = new boolean[readInt];
                parcel.readIntArray(iArr);
                parcel.readBooleanArray(zArr);
                while (i4 < readInt) {
                    sparseBooleanArray.put(iArr[i4], zArr[i4]);
                    i4++;
                }
                return sparseBooleanArray;
            default:
                int readInt2 = parcel.readInt();
                SparseIntArray sparseIntArray = new SparseIntArray(readInt2);
                int[] iArr2 = new int[readInt2];
                int[] iArr3 = new int[readInt2];
                parcel.readIntArray(iArr2);
                parcel.readIntArray(iArr3);
                while (i4 < readInt2) {
                    sparseIntArray.put(iArr2[i4], iArr3[i4]);
                    i4++;
                }
                return sparseIntArray;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f5118a) {
            case 0:
                return new SpliceNullCommand[i4];
            case 1:
                return new SpliceScheduleCommand[i4];
            case 2:
                return new TimeSignalCommand[i4];
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return new com.google.android.exoplayer2.metadata.vorbis.VorbisComment[i4];
            case VisibleForTesting.PROTECTED /* 4 */:
                return new DownloadRequest[i4];
            case VisibleForTesting.NONE /* 5 */:
                return new StreamKey[i4];
            case 6:
                return new Requirements[i4];
            case 7:
                return new BadgeState$State[i4];
            case 8:
                return new ParcelableSparseBooleanArray[i4];
            default:
                return new ParcelableSparseIntArray[i4];
        }
    }
}