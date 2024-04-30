package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import k1.b;

/* loaded from: classes.dex */
public final class BadgeState$State implements Parcelable {
    public static final Parcelable.Creator<BadgeState$State> CREATOR = new b(7);
    public Integer A;
    public Integer B;
    public Integer C;
    public Boolean D;

    /* renamed from: a  reason: collision with root package name */
    public int f2974a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f2975b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f2976c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f2977d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f2978e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f2979f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f2980g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f2981h;

    /* renamed from: j  reason: collision with root package name */
    public String f2983j;

    /* renamed from: n  reason: collision with root package name */
    public Locale f2987n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f2988o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f2989p;

    /* renamed from: q  reason: collision with root package name */
    public int f2990q;

    /* renamed from: r  reason: collision with root package name */
    public int f2991r;

    /* renamed from: s  reason: collision with root package name */
    public Integer f2992s;

    /* renamed from: u  reason: collision with root package name */
    public Integer f2994u;

    /* renamed from: v  reason: collision with root package name */
    public Integer f2995v;

    /* renamed from: w  reason: collision with root package name */
    public Integer f2996w;

    /* renamed from: x  reason: collision with root package name */
    public Integer f2997x;

    /* renamed from: y  reason: collision with root package name */
    public Integer f2998y;

    /* renamed from: z  reason: collision with root package name */
    public Integer f2999z;

    /* renamed from: i  reason: collision with root package name */
    public int f2982i = 255;

    /* renamed from: k  reason: collision with root package name */
    public int f2984k = -2;

    /* renamed from: l  reason: collision with root package name */
    public int f2985l = -2;

    /* renamed from: m  reason: collision with root package name */
    public int f2986m = -2;

    /* renamed from: t  reason: collision with root package name */
    public Boolean f2993t = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2974a);
        parcel.writeSerializable(this.f2975b);
        parcel.writeSerializable(this.f2976c);
        parcel.writeSerializable(this.f2977d);
        parcel.writeSerializable(this.f2978e);
        parcel.writeSerializable(this.f2979f);
        parcel.writeSerializable(this.f2980g);
        parcel.writeSerializable(this.f2981h);
        parcel.writeInt(this.f2982i);
        parcel.writeString(this.f2983j);
        parcel.writeInt(this.f2984k);
        parcel.writeInt(this.f2985l);
        parcel.writeInt(this.f2986m);
        CharSequence charSequence = this.f2988o;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.f2989p;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.f2990q);
        parcel.writeSerializable(this.f2992s);
        parcel.writeSerializable(this.f2994u);
        parcel.writeSerializable(this.f2995v);
        parcel.writeSerializable(this.f2996w);
        parcel.writeSerializable(this.f2997x);
        parcel.writeSerializable(this.f2998y);
        parcel.writeSerializable(this.f2999z);
        parcel.writeSerializable(this.C);
        parcel.writeSerializable(this.A);
        parcel.writeSerializable(this.B);
        parcel.writeSerializable(this.f2993t);
        parcel.writeSerializable(this.f2987n);
        parcel.writeSerializable(this.D);
    }
}