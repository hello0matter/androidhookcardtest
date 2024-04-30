package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: a  reason: collision with root package name */
    public final Serializable f4212a;

    public e(LazilyParsedNumber lazilyParsedNumber) {
        this.f4212a = lazilyParsedNumber;
    }

    public static boolean f(e eVar) {
        Serializable serializable = eVar.f4212a;
        if (serializable instanceof Number) {
            Number number = (Number) serializable;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    @Override // com.google.gson.b
    public final int a() {
        if (this.f4212a instanceof Number) {
            return e().intValue();
        }
        return Integer.parseInt(d());
    }

    @Override // com.google.gson.b
    public final long c() {
        if (this.f4212a instanceof Number) {
            return e().longValue();
        }
        return Long.parseLong(d());
    }

    @Override // com.google.gson.b
    public final String d() {
        Serializable serializable = this.f4212a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return e().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final Number e() {
        Serializable serializable = this.f4212a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new LazilyParsedNumber((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        Serializable serializable = this.f4212a;
        Serializable serializable2 = eVar.f4212a;
        if (serializable == null) {
            return serializable2 == null;
        } else if (f(this) && f(eVar)) {
            return e().longValue() == eVar.e().longValue();
        } else if ((serializable instanceof Number) && (serializable2 instanceof Number)) {
            double doubleValue = e().doubleValue();
            double doubleValue2 = eVar.e().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return serializable.equals(serializable2);
        }
    }

    public final int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.f4212a;
        if (serializable == null) {
            return 31;
        }
        if (f(this)) {
            doubleToLongBits = e().longValue();
        } else if (!(serializable instanceof Number)) {
            return serializable.hashCode();
        } else {
            doubleToLongBits = Double.doubleToLongBits(e().doubleValue());
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public e(Boolean bool) {
        this.f4212a = bool;
    }

    public e(String str) {
        Objects.requireNonNull(str);
        this.f4212a = str;
    }
}