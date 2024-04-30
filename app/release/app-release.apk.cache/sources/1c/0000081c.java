package kotlin.jvm.internal;

import androidx.activity.w;
import f3.a;
import f3.b;
import f3.d;
import f3.e;
import java.io.Serializable;
import kotlin.SinceKotlin;

/* loaded from: classes.dex */
public abstract class CallableReference implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public transient FunctionReference f5188a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5189b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f5190c = w.class;

    /* renamed from: d  reason: collision with root package name */
    public final String f5191d = "updateEnabledCallbacks";

    /* renamed from: e  reason: collision with root package name */
    public final String f5192e = "updateEnabledCallbacks()V";

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5193f;

    @SinceKotlin(version = "1.2")
    /* loaded from: classes.dex */
    public static class NoReceiver implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final NoReceiver f5194a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return f5194a;
        }
    }

    static {
        NoReceiver noReceiver = NoReceiver.f5194a;
    }

    public CallableReference(w wVar, boolean z4) {
        this.f5189b = wVar;
        this.f5193f = z4;
    }

    public final a b() {
        a bVar;
        Class cls = this.f5190c;
        if (cls == null) {
            return null;
        }
        if (this.f5193f) {
            e.f4578a.getClass();
            bVar = new d(cls);
        } else {
            e.f4578a.getClass();
            bVar = new b(cls);
        }
        return bVar;
    }
}