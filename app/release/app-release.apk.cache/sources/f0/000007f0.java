package kotlin.enums;

import com.google.common.collect.c;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00060\u0003j\u0002`\u0004:\u0001\bJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/enums/EnumEntriesSerializationProxy;", "", "E", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "l2/f", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Class f5185a;

    public EnumEntriesSerializationProxy(Enum[] enumArr) {
        c.F(enumArr, "entries");
        Class<?> componentType = enumArr.getClass().getComponentType();
        c.C(componentType);
        this.f5185a = componentType;
    }

    private final Object readResolve() {
        Object[] enumConstants = this.f5185a.getEnumConstants();
        c.E(enumConstants, "c.enumConstants");
        return a.a((Enum[]) enumConstants);
    }
}