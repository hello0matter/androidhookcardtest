package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f1909a = new LinkedHashMap();

    public final void a() {
        for (h0 h0Var : this.f1909a.values()) {
            HashMap hashMap = h0Var.f1904a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        for (Object obj : h0Var.f1904a.values()) {
                            if (obj instanceof Closeable) {
                                try {
                                    ((Closeable) obj).close();
                                } catch (IOException e4) {
                                    throw new RuntimeException(e4);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = h0Var.f1905b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        for (Closeable closeable : h0Var.f1905b) {
                            if (closeable instanceof Closeable) {
                                try {
                                    closeable.close();
                                } catch (IOException e5) {
                                    throw new RuntimeException(e5);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            h0Var.a();
        }
        this.f1909a.clear();
    }
}