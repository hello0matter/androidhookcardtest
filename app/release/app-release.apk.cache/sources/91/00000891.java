package m3;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f5532a = new ArrayList(20);

    public final void a(String str, String str2) {
        com.google.common.collect.c.F(str, "name");
        com.google.common.collect.c.F(str2, "value");
        ArrayList arrayList = this.f5532a;
        arrayList.add(str);
        arrayList.add(kotlin.text.b.C2(str2).toString());
    }

    public final m b() {
        return new m((String[]) this.f5532a.toArray(new String[0]));
    }

    public final void c(String str) {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f5532a;
            if (i4 < arrayList.size()) {
                if (l3.g.j2(str, (String) arrayList.get(i4))) {
                    arrayList.remove(i4);
                    arrayList.remove(i4);
                    i4 -= 2;
                }
                i4 += 2;
            } else {
                return;
            }
        }
    }
}