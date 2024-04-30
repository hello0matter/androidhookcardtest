package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class d0 implements androidx.activity.result.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0 f1675b;

    public /* synthetic */ d0(k0 k0Var, int i4) {
        this.f1674a = i4;
        this.f1675b = k0Var;
    }

    public final void a(ActivityResult activityResult) {
        StringBuilder sb;
        StringBuilder sb2;
        int i4 = this.f1674a;
        k0 k0Var = this.f1675b;
        switch (i4) {
            case 0:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) k0Var.f1747y.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo == null) {
                    sb = new StringBuilder("No IntentSenders were started for ");
                    sb.append(this);
                } else {
                    String str = fragmentManager$LaunchedFragmentInfo.f1593a;
                    t c4 = k0Var.f1725c.c(str);
                    if (c4 == null) {
                        sb = new StringBuilder("Intent Sender result delivered for unknown Fragment ");
                        sb.append(str);
                    } else {
                        c4.p(fragmentManager$LaunchedFragmentInfo.f1594b, activityResult.f120a, activityResult.f121b);
                        return;
                    }
                }
                Log.w("FragmentManager", sb.toString());
                return;
            default:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) k0Var.f1747y.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo2 == null) {
                    sb2 = new StringBuilder("No Activities were started for result for ");
                    sb2.append(this);
                } else {
                    String str2 = fragmentManager$LaunchedFragmentInfo2.f1593a;
                    t c5 = k0Var.f1725c.c(str2);
                    if (c5 == null) {
                        sb2 = new StringBuilder("Activity result delivered for unknown Fragment ");
                        sb2.append(str2);
                    } else {
                        c5.p(fragmentManager$LaunchedFragmentInfo2.f1594b, activityResult.f120a, activityResult.f121b);
                        return;
                    }
                }
                Log.w("FragmentManager", sb2.toString());
                return;
        }
    }

    public final void b(t tVar, e0.c cVar) {
        boolean z4;
        synchronized (cVar) {
            z4 = cVar.f4422a;
        }
        if (!z4) {
            k0 k0Var = this.f1675b;
            Map map = k0Var.f1733k;
            HashSet hashSet = (HashSet) map.get(tVar);
            if (hashSet != null && hashSet.remove(cVar) && hashSet.isEmpty()) {
                map.remove(tVar);
                if (tVar.f1801a < 5) {
                    tVar.B();
                    k0Var.f1735m.o(false);
                    tVar.D = null;
                    tVar.E = null;
                    tVar.N = null;
                    tVar.O.e(null);
                    tVar.f1814n = false;
                    k0Var.J(k0Var.f1737o, tVar);
                }
            }
        }
    }

    public final void c(t tVar, e0.c cVar) {
        Map map = this.f1675b.f1733k;
        if (map.get(tVar) == null) {
            map.put(tVar, new HashSet());
        }
        ((HashSet) map.get(tVar)).add(cVar);
    }

    @Override // androidx.activity.result.b
    public final void k(Object obj) {
        StringBuilder sb;
        int i4;
        switch (this.f1674a) {
            case 0:
                a((ActivityResult) obj);
                return;
            case 1:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    if (((Boolean) arrayList.get(i5)).booleanValue()) {
                        i4 = 0;
                    } else {
                        i4 = -1;
                    }
                    iArr[i5] = i4;
                }
                k0 k0Var = this.f1675b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) k0Var.f1747y.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo == null) {
                    sb = new StringBuilder("No permissions were requested for ");
                    sb.append(this);
                } else {
                    String str = fragmentManager$LaunchedFragmentInfo.f1593a;
                    if (k0Var.f1725c.c(str) == null) {
                        sb = new StringBuilder("Permission request result delivered for unknown Fragment ");
                        sb.append(str);
                    } else {
                        return;
                    }
                }
                Log.w("FragmentManager", sb.toString());
                return;
            default:
                a((ActivityResult) obj);
                return;
        }
    }
}