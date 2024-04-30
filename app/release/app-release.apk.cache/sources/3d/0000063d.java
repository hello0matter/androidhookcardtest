package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class b {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final d b() {
        if (this instanceof d) {
            return (d) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public long c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            u2.b bVar = new u2.b(stringWriter);
            bVar.f6903e = true;
            t2.b.f6693a.m2(bVar, this);
            return stringWriter.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }
}