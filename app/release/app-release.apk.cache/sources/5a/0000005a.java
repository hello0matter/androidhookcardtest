package androidx.activity.result;

import android.content.Intent;

/* loaded from: classes.dex */
public final class c extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f131q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f132r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ com.google.common.collect.c f133s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ f f134t;

    public /* synthetic */ c(f fVar, String str, com.google.common.collect.c cVar, int i4) {
        this.f131q = i4;
        this.f134t = fVar;
        this.f132r = str;
        this.f133s = cVar;
    }

    public final void h2(Intent intent) {
        int i4 = this.f131q;
        com.google.common.collect.c cVar = this.f133s;
        String str = this.f132r;
        f fVar = this.f134t;
        switch (i4) {
            case 0:
                Integer num = (Integer) fVar.f140b.get(str);
                if (num != null) {
                    fVar.f142d.add(str);
                    try {
                        fVar.b(num.intValue(), cVar, intent);
                        return;
                    } catch (Exception e4) {
                        fVar.f142d.remove(str);
                        throw e4;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + cVar + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                Integer num2 = (Integer) fVar.f140b.get(str);
                if (num2 != null) {
                    fVar.f142d.add(str);
                    try {
                        fVar.b(num2.intValue(), cVar, intent);
                        return;
                    } catch (Exception e5) {
                        fVar.f142d.remove(str);
                        throw e5;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + cVar + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }
}