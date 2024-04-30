package com.google.gson.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class JsonToken {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonToken f4223a;

    /* renamed from: b  reason: collision with root package name */
    public static final JsonToken f4224b;

    /* renamed from: c  reason: collision with root package name */
    public static final JsonToken f4225c;

    /* renamed from: d  reason: collision with root package name */
    public static final JsonToken f4226d;

    /* renamed from: e  reason: collision with root package name */
    public static final JsonToken f4227e;

    /* renamed from: f  reason: collision with root package name */
    public static final JsonToken f4228f;

    /* renamed from: g  reason: collision with root package name */
    public static final JsonToken f4229g;

    /* renamed from: h  reason: collision with root package name */
    public static final JsonToken f4230h;

    /* renamed from: i  reason: collision with root package name */
    public static final JsonToken f4231i;

    /* renamed from: j  reason: collision with root package name */
    public static final JsonToken f4232j;

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ JsonToken[] f4233k;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.google.gson.stream.JsonToken, java.lang.Enum] */
    static {
        ?? r02 = new Enum("BEGIN_ARRAY", 0);
        f4223a = r02;
        ?? r12 = new Enum("END_ARRAY", 1);
        f4224b = r12;
        ?? r22 = new Enum("BEGIN_OBJECT", 2);
        f4225c = r22;
        ?? r32 = new Enum("END_OBJECT", 3);
        f4226d = r32;
        ?? r4 = new Enum("NAME", 4);
        f4227e = r4;
        ?? r5 = new Enum("STRING", 5);
        f4228f = r5;
        ?? r6 = new Enum("NUMBER", 6);
        f4229g = r6;
        ?? r7 = new Enum("BOOLEAN", 7);
        f4230h = r7;
        ?? r8 = new Enum("NULL", 8);
        f4231i = r8;
        ?? r9 = new Enum("END_DOCUMENT", 9);
        f4232j = r9;
        f4233k = new JsonToken[]{r02, r12, r22, r32, r4, r5, r6, r7, r8, r9};
    }

    public static JsonToken valueOf(String str) {
        return (JsonToken) Enum.valueOf(JsonToken.class, str);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) f4233k.clone();
    }
}