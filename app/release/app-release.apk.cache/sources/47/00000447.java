package com.google.android.exoplayer2.scheduler;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import k1.b;

@Deprecated
/* loaded from: classes.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new b(6);

    /* renamed from: a  reason: collision with root package name */
    public final int f2854a;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RequirementFlags {
    }

    public Requirements(int i4) {
        this.f2854a = (i4 & 2) != 0 ? i4 | 1 : i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Requirements.class != obj.getClass()) {
            return false;
        }
        return this.f2854a == ((Requirements) obj).f2854a;
    }

    public final int hashCode() {
        return this.f2854a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2854a);
    }
}