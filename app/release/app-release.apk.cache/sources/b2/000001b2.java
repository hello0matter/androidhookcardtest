package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import r.h;

/* loaded from: classes.dex */
public abstract class f implements r.e {

    /* renamed from: a  reason: collision with root package name */
    public int f1164a;

    /* renamed from: b  reason: collision with root package name */
    public q.d f1165b;

    /* renamed from: c  reason: collision with root package name */
    public h f1166c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintWidget$DimensionBehaviour f1167d;

    /* renamed from: e  reason: collision with root package name */
    public final b f1168e = new b(this);

    /* renamed from: f  reason: collision with root package name */
    public int f1169f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1170g = false;

    /* renamed from: h  reason: collision with root package name */
    public final a f1171h = new a(this);

    /* renamed from: i  reason: collision with root package name */
    public final a f1172i = new a(this);

    /* renamed from: j  reason: collision with root package name */
    public WidgetRun$RunType f1173j = WidgetRun$RunType.f1145a;

    public f(q.d dVar) {
        this.f1165b = dVar;
    }

    public static void b(a aVar, a aVar2, int i4) {
        aVar.f1159l.add(aVar2);
        aVar.f1153f = i4;
        aVar2.f1158k.add(aVar);
    }

    public static a h(q.c cVar) {
        f fVar;
        f fVar2;
        q.c cVar2 = cVar.f6192d;
        if (cVar2 == null) {
            return null;
        }
        int ordinal = cVar2.f6191c.ordinal();
        q.d dVar = cVar2.f6190b;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal != 5) {
                            return null;
                        }
                        return dVar.f6204e.f1162k;
                    }
                    fVar2 = dVar.f6204e;
                } else {
                    fVar2 = dVar.f6202d;
                }
                return fVar2.f1172i;
            }
            fVar = dVar.f6204e;
        } else {
            fVar = dVar.f6202d;
        }
        return fVar.f1171h;
    }

    public static a i(q.c cVar, int i4) {
        f fVar;
        q.c cVar2 = cVar.f6192d;
        if (cVar2 == null) {
            return null;
        }
        q.d dVar = cVar2.f6190b;
        if (i4 == 0) {
            fVar = dVar.f6202d;
        } else {
            fVar = dVar.f6204e;
        }
        int ordinal = cVar2.f6191c.ordinal();
        if (ordinal != 1 && ordinal != 2) {
            if (ordinal != 3 && ordinal != 4) {
                return null;
            }
            return fVar.f1172i;
        }
        return fVar.f1171h;
    }

    public final void c(a aVar, a aVar2, int i4, b bVar) {
        aVar.f1159l.add(aVar2);
        aVar.f1159l.add(this.f1168e);
        aVar.f1155h = i4;
        aVar.f1156i = bVar;
        aVar2.f1158k.add(aVar);
        bVar.f1158k.add(aVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i4, int i5) {
        int max;
        if (i5 == 0) {
            q.d dVar = this.f1165b;
            int i6 = dVar.f6216n;
            max = Math.max(dVar.f6215m, i4);
            if (i6 > 0) {
                max = Math.min(i6, i4);
            }
            if (max == i4) {
                return i4;
            }
        } else {
            q.d dVar2 = this.f1165b;
            int i7 = dVar2.f6219q;
            max = Math.max(dVar2.f6218p, i4);
            if (i7 > 0) {
                max = Math.min(i7, i4);
            }
            if (max == i4) {
                return i4;
            }
        }
        return max;
    }

    public long j() {
        b bVar = this.f1168e;
        if (bVar.f1157j) {
            return bVar.f1154g;
        }
        return 0L;
    }

    public abstract boolean k();

    public final void l(q.c cVar, q.c cVar2, int i4) {
        float f4;
        int g4;
        f fVar;
        b bVar;
        float f5;
        a h4 = h(cVar);
        a h5 = h(cVar2);
        if (h4.f1157j && h5.f1157j) {
            int c4 = cVar.c() + h4.f1154g;
            int c5 = h5.f1154g - cVar2.c();
            int i5 = c5 - c4;
            b bVar2 = this.f1168e;
            if (!bVar2.f1157j) {
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = this.f1167d;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.f1133c;
                if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2) {
                    int i6 = this.f1164a;
                    if (i6 != 0) {
                        if (i6 != 1) {
                            if (i6 != 2) {
                                if (i6 == 3) {
                                    q.d dVar = this.f1165b;
                                    f fVar2 = dVar.f6202d;
                                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = fVar2.f1167d;
                                    f fVar3 = dVar.f6204e;
                                    if (constraintWidget$DimensionBehaviour3 != constraintWidget$DimensionBehaviour2 || fVar2.f1164a != 3 || fVar3.f1167d != constraintWidget$DimensionBehaviour2 || fVar3.f1164a != 3) {
                                        if (i4 == 0) {
                                            fVar2 = fVar3;
                                        }
                                        b bVar3 = fVar2.f1168e;
                                        if (bVar3.f1157j) {
                                            float f6 = dVar.N;
                                            float f7 = bVar3.f1154g;
                                            if (i4 == 1) {
                                                g4 = (int) ((f7 / f6) + 0.5f);
                                            } else {
                                                g4 = (int) ((f6 * f7) + 0.5f);
                                            }
                                        }
                                    }
                                }
                            } else {
                                q.d dVar2 = this.f1165b;
                                q.d dVar3 = dVar2.K;
                                if (dVar3 != null) {
                                    if (i4 == 0) {
                                        fVar = dVar3.f6202d;
                                    } else {
                                        fVar = dVar3.f6204e;
                                    }
                                    if (fVar.f1168e.f1157j) {
                                        if (i4 == 0) {
                                            f5 = dVar2.f6217o;
                                        } else {
                                            f5 = dVar2.f6220r;
                                        }
                                        g4 = g((int) ((bVar.f1154g * f5) + 0.5f), i4);
                                    }
                                }
                            }
                        } else {
                            g4 = Math.min(g(bVar2.f1160m, i4), i5);
                        }
                    } else {
                        g4 = g(i5, i4);
                    }
                    bVar2.d(g4);
                }
            }
            if (!bVar2.f1157j) {
                return;
            }
            int i7 = bVar2.f1154g;
            a aVar = this.f1172i;
            a aVar2 = this.f1171h;
            if (i7 == i5) {
                aVar2.d(c4);
                aVar.d(c5);
                return;
            }
            q.d dVar4 = this.f1165b;
            if (i4 == 0) {
                f4 = dVar4.U;
            } else {
                f4 = dVar4.V;
            }
            if (h4 == h5) {
                c4 = h4.f1154g;
                c5 = h5.f1154g;
                f4 = 0.5f;
            }
            aVar2.d((int) ((((c5 - c4) - i7) * f4) + c4 + 0.5f));
            aVar.d(aVar2.f1154g + bVar2.f1154g);
        }
    }
}