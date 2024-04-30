package androidx.lifecycle;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public Lifecycle$State f1911a;

    /* renamed from: b  reason: collision with root package name */
    public o f1912b;

    public final void a(q qVar, Lifecycle$Event lifecycle$Event) {
        Lifecycle$State a5 = lifecycle$Event.a();
        Lifecycle$State lifecycle$State = this.f1911a;
        com.google.common.collect.c.F(lifecycle$State, "state1");
        if (a5.compareTo(lifecycle$State) < 0) {
            lifecycle$State = a5;
        }
        this.f1911a = lifecycle$State;
        this.f1912b.b(qVar, lifecycle$Event);
        this.f1911a = a5;
    }
}