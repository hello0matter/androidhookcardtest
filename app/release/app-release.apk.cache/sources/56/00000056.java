package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Landroidx/activity/result/IntentSenderRequest;", "Landroid/os/Parcelable;", "androidx/activity/result/h", "l2/f", "activity_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a(1);

    /* renamed from: a  reason: collision with root package name */
    public final IntentSender f126a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f127b;

    /* renamed from: c  reason: collision with root package name */
    public final int f128c;

    /* renamed from: d  reason: collision with root package name */
    public final int f129d;

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i4, int i5) {
        com.google.common.collect.c.F(intentSender, "intentSender");
        this.f126a = intentSender;
        this.f127b = intent;
        this.f128c = i4;
        this.f129d = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        com.google.common.collect.c.F(parcel, "dest");
        parcel.writeParcelable(this.f126a, i4);
        parcel.writeParcelable(this.f127b, i4);
        parcel.writeInt(this.f128c);
        parcel.writeInt(this.f129d);
    }
}