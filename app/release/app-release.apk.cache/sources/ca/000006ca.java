package f3;

import e3.g;
import e3.h;
import e3.i;
import e3.j;
import e3.k;
import e3.l;
import e3.m;
import e3.n;
import e3.o;
import e3.p;
import e3.q;
import e3.r;
import e3.s;
import e3.t;
import e3.u;
import e3.v;
import e3.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes.dex */
public final class b implements j3.a, a {

    /* renamed from: b  reason: collision with root package name */
    public static final Map f4574b;

    /* renamed from: a  reason: collision with root package name */
    public final Class f4575a;

    static {
        List asList = Arrays.asList(e3.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, e3.b.class, e3.c.class, e3.d.class, e3.e.class, e3.f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        com.google.common.collect.c.E(asList, "asList(this)");
        ArrayList arrayList = new ArrayList(y2.h.h2(asList));
        int i4 = 0;
        for (Object obj : asList) {
            int i5 = i4 + 1;
            if (i4 >= 0) {
                arrayList.add(new Pair((Class) obj, Integer.valueOf(i4)));
                i4 = i5;
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        f4574b = kotlin.collections.b.i2(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        com.google.common.collect.c.E(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            com.google.common.collect.c.E(str, "kotlinName");
            sb.append(kotlin.text.b.B2(str));
            sb.append("CompanionObject");
            hashMap3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f4574b.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(com.google.common.collect.c.f1(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), kotlin.text.b.B2((String) entry2.getValue()));
        }
    }

    public b(Class cls) {
        com.google.common.collect.c.F(cls, "jClass");
        this.f4575a = cls;
    }

    @Override // f3.a
    public final Class a() {
        return this.f4575a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof b) && com.google.common.collect.c.n(com.google.common.collect.c.w0(this), com.google.common.collect.c.w0((j3.a) obj))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return com.google.common.collect.c.w0(this).hashCode();
    }

    public final String toString() {
        return this.f4575a.toString() + " (Kotlin reflection is not available)";
    }
}