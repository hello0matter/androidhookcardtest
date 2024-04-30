package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.i0;
import com.google.common.collect.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import y2.h;
import z.e;

/* loaded from: classes.dex */
public final class a extends c {
    @Override // com.google.common.collect.c
    public final i0 P0(ComponentActivity componentActivity, Intent intent) {
        String[] strArr = (String[]) intent;
        c.F(componentActivity, "context");
        if (strArr.length == 0) {
            return new i0(kotlin.collections.b.h2());
        }
        for (String str : strArr) {
            if (e.a(componentActivity, str) != 0) {
                return null;
            }
        }
        int f12 = c.f1(strArr.length);
        if (f12 < 16) {
            f12 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f12);
        for (String str2 : strArr) {
            linkedHashMap.put(str2, Boolean.TRUE);
        }
        return new i0(linkedHashMap);
    }

    @Override // com.google.common.collect.c
    public final Intent c0(ComponentActivity componentActivity, Intent intent) {
        c.F(componentActivity, "context");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) intent);
        c.E(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // com.google.common.collect.c
    public final Object z1(Intent intent, int i4) {
        boolean z4;
        if (i4 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i5 : intArrayExtra) {
                    if (i5 == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    arrayList.add(Boolean.valueOf(z4));
                }
                ArrayList m22 = h.m2(stringArrayExtra);
                Iterator it = m22.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(h.h2(m22), h.h2(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new Pair(it.next(), it2.next()));
                }
                return kotlin.collections.b.i2(arrayList2);
            }
        }
        return kotlin.collections.b.h2();
    }
}