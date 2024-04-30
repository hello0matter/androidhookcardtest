package m3;

import androidx.fragment.app.m0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public String f5534a;

    /* renamed from: d  reason: collision with root package name */
    public String f5537d;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f5539f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f5540g;

    /* renamed from: h  reason: collision with root package name */
    public String f5541h;

    /* renamed from: b  reason: collision with root package name */
    public String f5535b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f5536c = "";

    /* renamed from: e  reason: collision with root package name */
    public int f5538e = -1;

    public n() {
        ArrayList arrayList = new ArrayList();
        this.f5539f = arrayList;
        arrayList.add("");
    }

    public final o a() {
        ArrayList arrayList;
        String str;
        String str2 = this.f5534a;
        if (str2 != null) {
            String t4 = m0.t(this.f5535b, 0, 0, false, 7);
            String t5 = m0.t(this.f5536c, 0, 0, false, 7);
            String str3 = this.f5537d;
            if (str3 != null) {
                int b5 = b();
                ArrayList arrayList2 = this.f5539f;
                ArrayList arrayList3 = new ArrayList(y2.h.h2(arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(m0.t((String) it.next(), 0, 0, false, 7));
                }
                ArrayList<String> arrayList4 = this.f5540g;
                String str4 = null;
                if (arrayList4 != null) {
                    arrayList = new ArrayList(y2.h.h2(arrayList4));
                    for (String str5 : arrayList4) {
                        if (str5 != null) {
                            str = m0.t(str5, 0, 0, true, 3);
                        } else {
                            str = null;
                        }
                        arrayList.add(str);
                    }
                } else {
                    arrayList = null;
                }
                String str6 = this.f5541h;
                if (str6 != null) {
                    str4 = m0.t(str6, 0, 0, false, 7);
                }
                return new o(str2, t4, t5, str3, b5, arrayList3, arrayList, str4, toString());
            }
            throw new IllegalStateException("host == null");
        }
        throw new IllegalStateException("scheme == null");
    }

    public final int b() {
        int i4 = this.f5538e;
        if (i4 == -1) {
            String str = this.f5534a;
            com.google.common.collect.c.C(str);
            if (com.google.common.collect.c.n(str, "http")) {
                return 80;
            }
            if (!com.google.common.collect.c.n(str, "https")) {
                return -1;
            }
            return 443;
        }
        return i4;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:122:0x0284
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final void c(m3.o r34, java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.n.c(m3.o, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (r1 != r3) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.n.toString():java.lang.String");
    }
}