package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedTreeMap f4211a = new LinkedTreeMap();

    public final b e(String str) {
        return (b) this.f4211a.get(str);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof d) && ((d) obj).f4211a.equals(this.f4211a));
    }

    public final int hashCode() {
        return this.f4211a.hashCode();
    }
}