package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a implements r.e {

    /* renamed from: d  reason: collision with root package name */
    public final f f1151d;

    /* renamed from: f  reason: collision with root package name */
    public int f1153f;

    /* renamed from: g  reason: collision with root package name */
    public int f1154g;

    /* renamed from: a  reason: collision with root package name */
    public f f1148a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1149b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1150c = false;

    /* renamed from: e  reason: collision with root package name */
    public DependencyNode$Type f1152e = DependencyNode$Type.f1136a;

    /* renamed from: h  reason: collision with root package name */
    public int f1155h = 1;

    /* renamed from: i  reason: collision with root package name */
    public b f1156i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1157j = false;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f1158k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f1159l = new ArrayList();

    public a(f fVar) {
        this.f1151d = fVar;
    }

    @Override // r.e
    public final void a(r.e eVar) {
        ArrayList arrayList = this.f1159l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((a) it.next()).f1157j) {
                return;
            }
        }
        this.f1150c = true;
        f fVar = this.f1148a;
        if (fVar != null) {
            fVar.a(this);
        }
        if (this.f1149b) {
            this.f1151d.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        a aVar = null;
        int i4 = 0;
        while (it2.hasNext()) {
            a aVar2 = (a) it2.next();
            if (!(aVar2 instanceof b)) {
                i4++;
                aVar = aVar2;
            }
        }
        if (aVar != null && i4 == 1 && aVar.f1157j) {
            b bVar = this.f1156i;
            if (bVar != null) {
                if (bVar.f1157j) {
                    this.f1153f = this.f1155h * bVar.f1154g;
                } else {
                    return;
                }
            }
            d(aVar.f1154g + this.f1153f);
        }
        f fVar2 = this.f1148a;
        if (fVar2 != null) {
            fVar2.a(this);
        }
    }

    public final void b(r.e eVar) {
        this.f1158k.add(eVar);
        if (this.f1157j) {
            eVar.a(eVar);
        }
    }

    public final void c() {
        this.f1159l.clear();
        this.f1158k.clear();
        this.f1157j = false;
        this.f1154g = 0;
        this.f1150c = false;
        this.f1149b = false;
    }

    public void d(int i4) {
        if (this.f1157j) {
            return;
        }
        this.f1157j = true;
        this.f1154g = i4;
        Iterator it = this.f1158k.iterator();
        while (it.hasNext()) {
            r.e eVar = (r.e) it.next();
            eVar.a(eVar);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1151d.f1165b.Y);
        sb.append(":");
        sb.append(this.f1152e);
        sb.append("(");
        if (this.f1157j) {
            obj = Integer.valueOf(this.f1154g);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f1159l.size());
        sb.append(":d=");
        sb.append(this.f1158k.size());
        sb.append(">");
        return sb.toString();
    }
}