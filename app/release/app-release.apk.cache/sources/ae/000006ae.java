package f0;

import androidx.appcompat.widget.c0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g implements h0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4526b;

    public /* synthetic */ g(int i4, Object obj) {
        this.f4525a = i4;
        this.f4526b = obj;
    }

    public final void a(h hVar) {
        switch (this.f4525a) {
            case 0:
                if (hVar == null) {
                    hVar = new h(-3);
                }
                ((c0) this.f4526b).j(hVar);
                return;
            default:
                synchronized (i.f4531c) {
                    try {
                        l.k kVar = i.f4532d;
                        ArrayList arrayList = (ArrayList) kVar.getOrDefault((String) this.f4526b, null);
                        if (arrayList != null) {
                            kVar.remove((String) this.f4526b);
                            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                ((g) ((h0.a) arrayList.get(i4))).b(hVar);
                            }
                            return;
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    public final /* bridge */ /* synthetic */ void b(Object obj) {
        switch (this.f4525a) {
            case 0:
                a((h) obj);
                return;
            default:
                a((h) obj);
                return;
        }
    }
}