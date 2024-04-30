package t2;

import androidx.annotation.VisibleForTesting;
import com.google.common.collect.c;
import com.google.gson.d;
import com.google.gson.e;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.Serializable;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6692q;

    public /* synthetic */ a(int i4) {
        this.f6692q = i4;
    }

    public static com.google.gson.b j2(u2.a aVar, JsonToken jsonToken) {
        int ordinal = jsonToken.ordinal();
        if (ordinal != 5) {
            if (ordinal != 6) {
                if (ordinal != 7) {
                    if (ordinal == 8) {
                        aVar.L();
                        return com.google.gson.c.f4210a;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return new e(Boolean.valueOf(aVar.H()));
            }
            return new e(new LazilyParsedNumber(aVar.N()));
        }
        return new e(aVar.N());
    }

    public static void k2(com.google.gson.b bVar, u2.b bVar2) {
        boolean parseBoolean;
        String str;
        if (bVar != null && !(bVar instanceof com.google.gson.c)) {
            boolean z4 = bVar instanceof e;
            Writer writer = bVar2.f6899a;
            if (z4) {
                if (z4) {
                    e eVar = (e) bVar;
                    Serializable serializable = eVar.f4212a;
                    if (serializable instanceof Number) {
                        Number e4 = eVar.e();
                        if (e4 != null) {
                            bVar2.F();
                            String obj = e4.toString();
                            if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
                                Class<?> cls = e4.getClass();
                                if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !u2.b.f6897h.matcher(obj).matches()) {
                                    throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
                                }
                            } else if (!bVar2.f6903e) {
                                throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
                            }
                            bVar2.x();
                            writer.append((CharSequence) obj);
                            return;
                        }
                    } else {
                        boolean z5 = serializable instanceof Boolean;
                        if (z5) {
                            if (z5) {
                                parseBoolean = ((Boolean) serializable).booleanValue();
                            } else {
                                parseBoolean = Boolean.parseBoolean(eVar.d());
                            }
                            bVar2.F();
                            bVar2.x();
                            if (parseBoolean) {
                                str = "true";
                            } else {
                                str = "false";
                            }
                            writer.write(str);
                            return;
                        }
                        bVar2.E(eVar.d());
                        return;
                    }
                } else {
                    throw new IllegalStateException("Not a JSON Primitive: " + bVar);
                }
            } else {
                boolean z6 = bVar instanceof com.google.gson.a;
                if (z6) {
                    bVar2.F();
                    bVar2.x();
                    int i4 = bVar2.f6901c;
                    int[] iArr = bVar2.f6900b;
                    if (i4 == iArr.length) {
                        bVar2.f6900b = Arrays.copyOf(iArr, i4 * 2);
                    }
                    int[] iArr2 = bVar2.f6900b;
                    int i5 = bVar2.f6901c;
                    bVar2.f6901c = i5 + 1;
                    iArr2[i5] = 1;
                    writer.write(91);
                    if (z6) {
                        Iterator it = ((com.google.gson.a) bVar).f4209a.iterator();
                        while (it.hasNext()) {
                            k2((com.google.gson.b) it.next(), bVar2);
                        }
                        bVar2.y(1, 2, ']');
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Array: " + bVar);
                } else if (bVar instanceof d) {
                    bVar2.F();
                    bVar2.x();
                    int i6 = bVar2.f6901c;
                    int[] iArr3 = bVar2.f6900b;
                    if (i6 == iArr3.length) {
                        bVar2.f6900b = Arrays.copyOf(iArr3, i6 * 2);
                    }
                    int[] iArr4 = bVar2.f6900b;
                    int i7 = bVar2.f6901c;
                    bVar2.f6901c = i7 + 1;
                    iArr4[i7] = 3;
                    writer.write(123);
                    Iterator it2 = ((s2.b) bVar.b().f4211a.entrySet()).iterator();
                    while (((s2.c) it2).hasNext()) {
                        Map.Entry entry = (Map.Entry) ((s2.a) it2).next();
                        bVar2.z((String) entry.getKey());
                        k2((com.google.gson.b) entry.getValue(), bVar2);
                    }
                    bVar2.y(3, 5, '}');
                    return;
                } else {
                    throw new IllegalArgumentException("Couldn't write " + bVar.getClass());
                }
            }
        }
        bVar2.A();
    }

    public final Number h2(u2.a aVar) {
        JsonToken jsonToken = JsonToken.f4231i;
        switch (this.f6692q) {
            case 23:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                try {
                    int I = aVar.I();
                    if (I <= 255 && I >= -128) {
                        return Byte.valueOf((byte) I);
                    }
                    throw new RuntimeException("Lossy conversion from " + I + " to byte; at path " + aVar.E(true));
                } catch (NumberFormatException e4) {
                    throw new RuntimeException(e4);
                }
            case 24:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                try {
                    int I2 = aVar.I();
                    if (I2 <= 65535 && I2 >= -32768) {
                        return Short.valueOf((short) I2);
                    }
                    throw new RuntimeException("Lossy conversion from " + I2 + " to short; at path " + aVar.E(true));
                } catch (NumberFormatException e5) {
                    throw new RuntimeException(e5);
                }
            default:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.I());
                } catch (NumberFormatException e6) {
                    throw new RuntimeException(e6);
                }
        }
    }

    public final Object i2(u2.a aVar) {
        String str;
        String str2;
        com.google.gson.b aVar2;
        String str3;
        com.google.gson.b aVar3;
        boolean z4;
        boolean H;
        JsonToken jsonToken = JsonToken.f4231i;
        int i4 = this.f6692q;
        String str4 = null;
        switch (i4) {
            case 0:
                ArrayList arrayList = new ArrayList();
                aVar.x();
                while (true) {
                    int i5 = aVar.f6889h;
                    if (i5 == 0) {
                        i5 = aVar.A();
                    }
                    if (i5 != 2 && i5 != 4 && i5 != 17) {
                        try {
                            arrayList.add(Integer.valueOf(aVar.I()));
                        } catch (NumberFormatException e4) {
                            throw new RuntimeException(e4);
                        }
                    }
                }
                aVar.B();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i6 = 0; i6 < size; i6++) {
                    atomicIntegerArray.set(i6, ((Integer) arrayList.get(i6)).intValue());
                }
                return atomicIntegerArray;
            case 1:
            case 2:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
            case 6:
            case 7:
            case 8:
            case 22:
            default:
                return new AtomicBoolean(aVar.H());
            case VisibleForTesting.PROTECTED /* 4 */:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                String N = aVar.N();
                if (N.length() == 1) {
                    return Character.valueOf(N.charAt(0));
                }
                throw new RuntimeException("Expecting character, got: " + N + "; at " + aVar.E(true));
            case VisibleForTesting.NONE /* 5 */:
                JsonToken P = aVar.P();
                if (P == jsonToken) {
                    aVar.L();
                    return null;
                } else if (P == JsonToken.f4230h) {
                    return Boolean.toString(aVar.H());
                } else {
                    return aVar.N();
                }
            case 9:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                return new StringBuilder(aVar.N());
            case 10:
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            case 11:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                return new StringBuffer(aVar.N());
            case 12:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                String N2 = aVar.N();
                if ("null".equals(N2)) {
                    return null;
                }
                return new URL(N2);
            case 13:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                try {
                    String N3 = aVar.N();
                    if ("null".equals(N3)) {
                        return null;
                    }
                    return new URI(N3);
                } catch (URISyntaxException e5) {
                    throw new RuntimeException(e5);
                }
            case 14:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                return InetAddress.getByName(aVar.N());
            case 15:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                String N4 = aVar.N();
                try {
                    return UUID.fromString(N4);
                } catch (IllegalArgumentException e6) {
                    throw new RuntimeException("Failed parsing '" + N4 + "' as UUID; at path " + aVar.E(true), e6);
                }
            case 16:
                String N5 = aVar.N();
                try {
                    return Currency.getInstance(N5);
                } catch (IllegalArgumentException e7) {
                    throw new RuntimeException("Failed parsing '" + N5 + "' as Currency; at path " + aVar.E(true), e7);
                }
            case 17:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                aVar.y();
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (aVar.P() != JsonToken.f4226d) {
                    String J = aVar.J();
                    int I = aVar.I();
                    if ("year".equals(J)) {
                        i7 = I;
                    } else if ("month".equals(J)) {
                        i8 = I;
                    } else if ("dayOfMonth".equals(J)) {
                        i9 = I;
                    } else if ("hourOfDay".equals(J)) {
                        i10 = I;
                    } else if ("minute".equals(J)) {
                        i11 = I;
                    } else if ("second".equals(J)) {
                        i12 = I;
                    }
                }
                aVar.C();
                return new GregorianCalendar(i7, i8, i9, i10, i11, i12);
            case 18:
                if (aVar.P() == jsonToken) {
                    aVar.L();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.N(), "_");
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                } else {
                    str = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str2 = stringTokenizer.nextToken();
                } else {
                    str2 = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str4 = stringTokenizer.nextToken();
                }
                if (str2 == null && str4 == null) {
                    return new Locale(str);
                }
                if (str4 == null) {
                    return new Locale(str, str2);
                }
                return new Locale(str, str2, str4);
            case 19:
                JsonToken P2 = aVar.P();
                int ordinal = P2.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 2) {
                        aVar2 = null;
                    } else {
                        aVar.y();
                        aVar2 = new d();
                    }
                } else {
                    aVar.x();
                    aVar2 = new com.google.gson.a();
                }
                if (aVar2 == null) {
                    return j2(aVar, P2);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    int i13 = aVar.f6889h;
                    if (i13 == 0) {
                        i13 = aVar.A();
                    }
                    if (i13 != 2 && i13 != 4 && i13 != 17) {
                        if (aVar2 instanceof d) {
                            str3 = aVar.J();
                        } else {
                            str3 = null;
                        }
                        JsonToken P3 = aVar.P();
                        int ordinal2 = P3.ordinal();
                        if (ordinal2 != 0) {
                            if (ordinal2 != 2) {
                                aVar3 = null;
                            } else {
                                aVar.y();
                                aVar3 = new d();
                            }
                        } else {
                            aVar.x();
                            aVar3 = new com.google.gson.a();
                        }
                        if (aVar3 != null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (aVar3 == null) {
                            aVar3 = j2(aVar, P3);
                        }
                        if (aVar2 instanceof com.google.gson.a) {
                            com.google.gson.a aVar4 = (com.google.gson.a) aVar2;
                            aVar4.getClass();
                            aVar4.f4209a.add(aVar3);
                        } else {
                            d dVar = (d) aVar2;
                            dVar.getClass();
                            dVar.f4211a.put(str3, aVar3);
                        }
                        if (z4) {
                            arrayDeque.addLast(aVar2);
                            aVar2 = aVar3;
                        }
                    } else {
                        if (aVar2 instanceof com.google.gson.a) {
                            aVar.B();
                        } else {
                            aVar.C();
                        }
                        if (arrayDeque.isEmpty()) {
                            return aVar2;
                        }
                        aVar2 = (com.google.gson.b) arrayDeque.removeLast();
                    }
                }
                break;
            case 20:
                BitSet bitSet = new BitSet();
                aVar.x();
                JsonToken P4 = aVar.P();
                int i14 = 0;
                while (P4 != JsonToken.f4224b) {
                    int ordinal3 = P4.ordinal();
                    if (ordinal3 != 5 && ordinal3 != 6) {
                        if (ordinal3 == 7) {
                            if (!aVar.H()) {
                                i14++;
                                P4 = aVar.P();
                            }
                            bitSet.set(i14);
                            i14++;
                            P4 = aVar.P();
                        } else {
                            throw new RuntimeException("Invalid bitset value type: " + P4 + "; at path " + aVar.E(false));
                        }
                    } else {
                        int I2 = aVar.I();
                        if (I2 != 0) {
                            if (I2 != 1) {
                                throw new RuntimeException("Invalid bitset value " + I2 + ", expected 0 or 1; at path " + aVar.E(true));
                            }
                            bitSet.set(i14);
                            i14++;
                            P4 = aVar.P();
                        } else {
                            continue;
                            i14++;
                            P4 = aVar.P();
                        }
                    }
                }
                aVar.B();
                return bitSet;
            case 21:
                switch (i4) {
                    case 21:
                        JsonToken P5 = aVar.P();
                        if (P5 == jsonToken) {
                            aVar.L();
                            return null;
                        }
                        if (P5 == JsonToken.f4228f) {
                            H = Boolean.parseBoolean(aVar.N());
                        } else {
                            H = aVar.H();
                        }
                        return Boolean.valueOf(H);
                    default:
                        if (aVar.P() == jsonToken) {
                            aVar.L();
                            return null;
                        }
                        return Boolean.valueOf(aVar.N());
                }
            case 23:
                return h2(aVar);
            case 24:
                return h2(aVar);
            case 25:
                return h2(aVar);
            case 26:
                try {
                    return new AtomicInteger(aVar.I());
                } catch (NumberFormatException e8) {
                    throw new RuntimeException(e8);
                }
        }
    }

    public final void l2(u2.b bVar, Number number) {
        switch (this.f6692q) {
            case 23:
                if (number == null) {
                    bVar.A();
                    return;
                } else {
                    bVar.D(number.byteValue());
                    return;
                }
            case 24:
                if (number == null) {
                    bVar.A();
                    return;
                } else {
                    bVar.D(number.shortValue());
                    return;
                }
            default:
                if (number == null) {
                    bVar.A();
                    return;
                } else {
                    bVar.D(number.intValue());
                    return;
                }
        }
    }

    public final void m2(u2.b bVar, Object obj) {
        String bool;
        String str = "false";
        Writer writer = bVar.f6899a;
        int i4 = this.f6692q;
        int i5 = 0;
        String str2 = null;
        switch (i4) {
            case 0:
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                bVar.F();
                bVar.x();
                int i6 = bVar.f6901c;
                int[] iArr = bVar.f6900b;
                if (i6 == iArr.length) {
                    bVar.f6900b = Arrays.copyOf(iArr, i6 * 2);
                }
                int[] iArr2 = bVar.f6900b;
                int i7 = bVar.f6901c;
                bVar.f6901c = i7 + 1;
                iArr2[i7] = 1;
                writer.write(91);
                int length = atomicIntegerArray.length();
                while (i5 < length) {
                    bVar.D(atomicIntegerArray.get(i5));
                    i5++;
                }
                bVar.y(1, 2, ']');
                return;
            case 1:
            case 2:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
            case 6:
            case 7:
            case 8:
            case 22:
            default:
                boolean z4 = ((AtomicBoolean) obj).get();
                bVar.F();
                bVar.x();
                if (z4) {
                    str = "true";
                }
                writer.write(str);
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                Character ch = (Character) obj;
                if (ch != null) {
                    str2 = String.valueOf(ch);
                }
                bVar.E(str2);
                return;
            case VisibleForTesting.NONE /* 5 */:
                bVar.E((String) obj);
                return;
            case 9:
                StringBuilder sb = (StringBuilder) obj;
                if (sb != null) {
                    str2 = sb.toString();
                }
                bVar.E(str2);
                return;
            case 10:
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            case 11:
                StringBuffer stringBuffer = (StringBuffer) obj;
                if (stringBuffer != null) {
                    str2 = stringBuffer.toString();
                }
                bVar.E(str2);
                return;
            case 12:
                URL url = (URL) obj;
                if (url != null) {
                    str2 = url.toExternalForm();
                }
                bVar.E(str2);
                return;
            case 13:
                URI uri = (URI) obj;
                if (uri != null) {
                    str2 = uri.toASCIIString();
                }
                bVar.E(str2);
                return;
            case 14:
                InetAddress inetAddress = (InetAddress) obj;
                if (inetAddress != null) {
                    str2 = inetAddress.getHostAddress();
                }
                bVar.E(str2);
                return;
            case 15:
                UUID uuid = (UUID) obj;
                if (uuid != null) {
                    str2 = uuid.toString();
                }
                bVar.E(str2);
                return;
            case 16:
                bVar.E(((Currency) obj).getCurrencyCode());
                return;
            case 17:
                Calendar calendar = (Calendar) obj;
                if (calendar == null) {
                    bVar.A();
                    return;
                }
                bVar.F();
                bVar.x();
                int i8 = bVar.f6901c;
                int[] iArr3 = bVar.f6900b;
                if (i8 == iArr3.length) {
                    bVar.f6900b = Arrays.copyOf(iArr3, i8 * 2);
                }
                int[] iArr4 = bVar.f6900b;
                int i9 = bVar.f6901c;
                bVar.f6901c = i9 + 1;
                iArr4[i9] = 3;
                writer.write(123);
                bVar.z("year");
                bVar.D(calendar.get(1));
                bVar.z("month");
                bVar.D(calendar.get(2));
                bVar.z("dayOfMonth");
                bVar.D(calendar.get(5));
                bVar.z("hourOfDay");
                bVar.D(calendar.get(11));
                bVar.z("minute");
                bVar.D(calendar.get(12));
                bVar.z("second");
                bVar.D(calendar.get(13));
                bVar.y(3, 5, '}');
                return;
            case 18:
                Locale locale = (Locale) obj;
                if (locale != null) {
                    str2 = locale.toString();
                }
                bVar.E(str2);
                return;
            case 19:
                k2((com.google.gson.b) obj, bVar);
                return;
            case 20:
                BitSet bitSet = (BitSet) obj;
                bVar.F();
                bVar.x();
                int i10 = bVar.f6901c;
                int[] iArr5 = bVar.f6900b;
                if (i10 == iArr5.length) {
                    bVar.f6900b = Arrays.copyOf(iArr5, i10 * 2);
                }
                int[] iArr6 = bVar.f6900b;
                int i11 = bVar.f6901c;
                bVar.f6901c = i11 + 1;
                iArr6[i11] = 1;
                writer.write(91);
                int length2 = bitSet.length();
                while (i5 < length2) {
                    bVar.D(bitSet.get(i5) ? 1L : 0L);
                    i5++;
                }
                bVar.y(1, 2, ']');
                return;
            case 21:
                Boolean bool2 = (Boolean) obj;
                switch (i4) {
                    case 21:
                        if (bool2 == null) {
                            bVar.A();
                            return;
                        }
                        bVar.F();
                        bVar.x();
                        if (bool2.booleanValue()) {
                            str = "true";
                        }
                        writer.write(str);
                        return;
                    default:
                        if (bool2 == null) {
                            bool = "null";
                        } else {
                            bool = bool2.toString();
                        }
                        bVar.E(bool);
                        return;
                }
            case 23:
                l2(bVar, (Number) obj);
                return;
            case 24:
                l2(bVar, (Number) obj);
                return;
            case 25:
                l2(bVar, (Number) obj);
                return;
            case 26:
                bVar.D(((AtomicInteger) obj).get());
                return;
        }
    }
}