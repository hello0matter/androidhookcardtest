package l3;

import e3.p;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements k3.b {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f5408a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5409b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5410c;

    /* renamed from: d  reason: collision with root package name */
    public final p f5411d;

    public c(CharSequence charSequence, int i4, int i5, p pVar) {
        com.google.common.collect.c.F(charSequence, "input");
        this.f5408a = charSequence;
        this.f5409b = i4;
        this.f5410c = i5;
        this.f5411d = pVar;
    }

    @Override // k3.b
    public final Iterator iterator() {
        return new b(this);
    }
}