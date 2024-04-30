package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.exoplayer2.container.CreationTime;
import com.google.android.exoplayer2.container.Mp4LocationData;
import com.google.android.exoplayer2.container.XmpData;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f130a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f130a) {
            case 0:
                return new ActivityResult(parcel);
            case 1:
                com.google.common.collect.c.F(parcel, "inParcel");
                Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                com.google.common.collect.c.C(readParcelable);
                return new IntentSenderRequest((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 2:
                return new ParcelImpl(parcel);
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return new CreationTime(parcel);
            case VisibleForTesting.PROTECTED /* 4 */:
                return new Mp4LocationData(parcel);
            case VisibleForTesting.NONE /* 5 */:
                return new XmpData(parcel);
            case 6:
                return new DrmInitData(parcel);
            case 7:
                return new Metadata(parcel);
            case 8:
                String readString = parcel.readString();
                readString.getClass();
                return new AppInfoTable(readString, parcel.readInt());
            case 9:
                return new EventMessage(parcel);
            case 10:
                return new PictureFrame(parcel);
            case 11:
                return new VorbisComment(parcel);
            case 12:
                return new IcyHeaders(parcel);
            case 13:
                return new IcyInfo(parcel);
            case 14:
                return new ApicFrame(parcel);
            case 15:
                return new BinaryFrame(parcel);
            case 16:
                return new ChapterFrame(parcel);
            case 17:
                return new ChapterTocFrame(parcel);
            case 18:
                return new CommentFrame(parcel);
            case 19:
                return new GeobFrame(parcel);
            case 20:
                return new InternalFrame(parcel);
            case 21:
                return new MlltFrame(parcel);
            case 22:
                return new PrivFrame(parcel);
            case 23:
                return new TextInformationFrame(parcel);
            case 24:
                return new UrlLinkFrame(parcel);
            case 25:
                return new MdtaMetadataEntry(parcel);
            case 26:
                return new MotionPhotoMetadata(parcel);
            case 27:
                return new SmtaMetadataEntry(parcel);
            case 28:
                return new PrivateCommand(parcel);
            default:
                return new SpliceInsertCommand(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f130a) {
            case 0:
                return new ActivityResult[i4];
            case 1:
                return new IntentSenderRequest[i4];
            case 2:
                return new ParcelImpl[i4];
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return new CreationTime[i4];
            case VisibleForTesting.PROTECTED /* 4 */:
                return new Mp4LocationData[i4];
            case VisibleForTesting.NONE /* 5 */:
                return new XmpData[i4];
            case 6:
                return new DrmInitData[i4];
            case 7:
                return new Metadata[i4];
            case 8:
                return new AppInfoTable[i4];
            case 9:
                return new EventMessage[i4];
            case 10:
                return new PictureFrame[i4];
            case 11:
                return new VorbisComment[i4];
            case 12:
                return new IcyHeaders[i4];
            case 13:
                return new IcyInfo[i4];
            case 14:
                return new ApicFrame[i4];
            case 15:
                return new BinaryFrame[i4];
            case 16:
                return new ChapterFrame[i4];
            case 17:
                return new ChapterTocFrame[i4];
            case 18:
                return new CommentFrame[i4];
            case 19:
                return new GeobFrame[i4];
            case 20:
                return new InternalFrame[i4];
            case 21:
                return new MlltFrame[i4];
            case 22:
                return new PrivFrame[i4];
            case 23:
                return new TextInformationFrame[i4];
            case 24:
                return new UrlLinkFrame[i4];
            case 25:
                return new MdtaMetadataEntry[i4];
            case 26:
                return new MotionPhotoMetadata[i4];
            case 27:
                return new SmtaMetadataEntry[i4];
            case 28:
                return new PrivateCommand[i4];
            default:
                return new SpliceInsertCommand[i4];
        }
    }
}