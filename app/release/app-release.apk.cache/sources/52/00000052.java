package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: b  reason: collision with root package name */
    public boolean f116b;

    /* renamed from: a  reason: collision with root package name */
    public final Object f115a = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f117c = new ArrayList();

    public q(n nVar, e eVar) {
    }

    public final void a() {
        synchronized (this.f115a) {
            try {
                this.f116b = true;
                Iterator it = this.f117c.iterator();
                while (it.hasNext()) {
                    ((e3.a) it.next()).a();
                }
                this.f117c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}