package org.apache.commons.codec;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CodecPolicy {

    /* renamed from: a  reason: collision with root package name */
    public static final CodecPolicy f6055a;

    /* renamed from: b  reason: collision with root package name */
    public static final CodecPolicy f6056b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ CodecPolicy[] f6057c;

    /* JADX WARN: Type inference failed for: r0v0, types: [org.apache.commons.codec.CodecPolicy, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.apache.commons.codec.CodecPolicy, java.lang.Enum] */
    static {
        ?? r02 = new Enum("STRICT", 0);
        f6055a = r02;
        ?? r12 = new Enum("LENIENT", 1);
        f6056b = r12;
        f6057c = new CodecPolicy[]{r02, r12};
    }

    public static CodecPolicy valueOf(String str) {
        return (CodecPolicy) Enum.valueOf(CodecPolicy.class, str);
    }

    public static CodecPolicy[] values() {
        return (CodecPolicy[]) f6057c.clone();
    }
}