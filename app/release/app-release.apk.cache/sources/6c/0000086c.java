package l3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5399a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Charset f5400b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Charset f5401c;

    static {
        Charset forName = Charset.forName("UTF-8");
        com.google.common.collect.c.E(forName, "forName(\"UTF-8\")");
        f5399a = forName;
        com.google.common.collect.c.E(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        com.google.common.collect.c.E(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        com.google.common.collect.c.E(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        com.google.common.collect.c.E(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        com.google.common.collect.c.E(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}