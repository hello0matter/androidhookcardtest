package com.google.errorprone.annotations;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Modifier {

    /* renamed from: a  reason: collision with root package name */
    public static final Modifier f4204a;

    /* renamed from: b  reason: collision with root package name */
    public static final Modifier f4205b;

    /* renamed from: c  reason: collision with root package name */
    public static final Modifier f4206c;

    /* renamed from: d  reason: collision with root package name */
    public static final Modifier f4207d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ Modifier[] f4208e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    static {
        ?? r02 = new Enum("PUBLIC", 0);
        f4204a = r02;
        ?? r12 = new Enum("PROTECTED", 1);
        ?? r22 = new Enum("PRIVATE", 2);
        f4205b = r22;
        ?? r32 = new Enum("ABSTRACT", 3);
        ?? r4 = new Enum("DEFAULT", 4);
        ?? r5 = new Enum("STATIC", 5);
        f4206c = r5;
        ?? r6 = new Enum("FINAL", 6);
        f4207d = r6;
        f4208e = new Modifier[]{r02, r12, r22, r32, r4, r5, r6, new Enum("TRANSIENT", 7), new Enum("VOLATILE", 8), new Enum("SYNCHRONIZED", 9), new Enum("NATIVE", 10), new Enum("STRICTFP", 11)};
    }

    public static Modifier valueOf(String str) {
        return (Modifier) Enum.valueOf(Modifier.class, str);
    }

    public static Modifier[] values() {
        return (Modifier[]) f4208e.clone();
    }
}