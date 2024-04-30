package f0;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4520a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f4521b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f4522c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f4523d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4524e;

    public /* synthetic */ f(String str, Context context, e eVar, int i4, int i5) {
        this.f4520a = i5;
        this.f4521b = str;
        this.f4522c = context;
        this.f4523d = eVar;
        this.f4524e = i4;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str = this.f4521b;
        Context context = this.f4522c;
        e eVar = this.f4523d;
        int i4 = this.f4524e;
        int i5 = this.f4520a;
        switch (i5) {
            case 0:
                switch (i5) {
                    case 0:
                        return i.a(str, context, eVar, i4);
                    default:
                        try {
                            return i.a(str, context, eVar, i4);
                        } catch (Throwable unused) {
                            return new h(-3);
                        }
                }
            default:
                switch (i5) {
                    case 0:
                        return i.a(str, context, eVar, i4);
                    default:
                        try {
                            return i.a(str, context, eVar, i4);
                        } catch (Throwable unused2) {
                            return new h(-3);
                        }
                }
        }
    }
}