package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f4213a;

    public LazilyParsedNumber(String str) {
        this.f4213a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new BigDecimal(this.f4213a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f4213a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            String str = ((LazilyParsedNumber) obj).f4213a;
            String str2 = this.f4213a;
            return str2 == str || str2.equals(str);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f4213a);
    }

    public final int hashCode() {
        return this.f4213a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f4213a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return new BigDecimal(str).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(str);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f4213a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f4213a;
    }
}