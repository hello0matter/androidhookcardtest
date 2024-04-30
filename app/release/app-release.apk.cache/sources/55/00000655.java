package d1;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f4280a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f4281b;

    /* renamed from: c  reason: collision with root package name */
    public float f4282c;

    /* renamed from: d  reason: collision with root package name */
    public float f4283d;

    /* renamed from: e  reason: collision with root package name */
    public float f4284e;

    /* renamed from: f  reason: collision with root package name */
    public float f4285f;

    /* renamed from: g  reason: collision with root package name */
    public float f4286g;

    /* renamed from: h  reason: collision with root package name */
    public float f4287h;

    /* renamed from: i  reason: collision with root package name */
    public float f4288i;

    /* renamed from: j  reason: collision with root package name */
    public final Matrix f4289j;

    /* renamed from: k  reason: collision with root package name */
    public final int f4290k;

    /* renamed from: l  reason: collision with root package name */
    public String f4291l;

    public j() {
        this.f4280a = new Matrix();
        this.f4281b = new ArrayList();
        this.f4282c = 0.0f;
        this.f4283d = 0.0f;
        this.f4284e = 0.0f;
        this.f4285f = 1.0f;
        this.f4286g = 1.0f;
        this.f4287h = 0.0f;
        this.f4288i = 0.0f;
        this.f4289j = new Matrix();
        this.f4291l = null;
    }

    @Override // d1.k
    public final boolean a() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f4281b;
            if (i4 >= arrayList.size()) {
                return false;
            }
            if (((k) arrayList.get(i4)).a()) {
                return true;
            }
            i4++;
        }
    }

    @Override // d1.k
    public final boolean b(int[] iArr) {
        int i4 = 0;
        boolean z4 = false;
        while (true) {
            ArrayList arrayList = this.f4281b;
            if (i4 < arrayList.size()) {
                z4 |= ((k) arrayList.get(i4)).b(iArr);
                i4++;
            } else {
                return z4;
            }
        }
    }

    public final void c() {
        Matrix matrix = this.f4289j;
        matrix.reset();
        matrix.postTranslate(-this.f4283d, -this.f4284e);
        matrix.postScale(this.f4285f, this.f4286g);
        matrix.postRotate(this.f4282c, 0.0f, 0.0f);
        matrix.postTranslate(this.f4287h + this.f4283d, this.f4288i + this.f4284e);
    }

    public String getGroupName() {
        return this.f4291l;
    }

    public Matrix getLocalMatrix() {
        return this.f4289j;
    }

    public float getPivotX() {
        return this.f4283d;
    }

    public float getPivotY() {
        return this.f4284e;
    }

    public float getRotation() {
        return this.f4282c;
    }

    public float getScaleX() {
        return this.f4285f;
    }

    public float getScaleY() {
        return this.f4286g;
    }

    public float getTranslateX() {
        return this.f4287h;
    }

    public float getTranslateY() {
        return this.f4288i;
    }

    public void setPivotX(float f4) {
        if (f4 != this.f4283d) {
            this.f4283d = f4;
            c();
        }
    }

    public void setPivotY(float f4) {
        if (f4 != this.f4284e) {
            this.f4284e = f4;
            c();
        }
    }

    public void setRotation(float f4) {
        if (f4 != this.f4282c) {
            this.f4282c = f4;
            c();
        }
    }

    public void setScaleX(float f4) {
        if (f4 != this.f4285f) {
            this.f4285f = f4;
            c();
        }
    }

    public void setScaleY(float f4) {
        if (f4 != this.f4286g) {
            this.f4286g = f4;
            c();
        }
    }

    public void setTranslateX(float f4) {
        if (f4 != this.f4287h) {
            this.f4287h = f4;
            c();
        }
    }

    public void setTranslateY(float f4) {
        if (f4 != this.f4288i) {
            this.f4288i = f4;
            c();
        }
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [d1.l, d1.i] */
    public j(j jVar, l.b bVar) {
        l lVar;
        this.f4280a = new Matrix();
        this.f4281b = new ArrayList();
        this.f4282c = 0.0f;
        this.f4283d = 0.0f;
        this.f4284e = 0.0f;
        this.f4285f = 1.0f;
        this.f4286g = 1.0f;
        this.f4287h = 0.0f;
        this.f4288i = 0.0f;
        Matrix matrix = new Matrix();
        this.f4289j = matrix;
        this.f4291l = null;
        this.f4282c = jVar.f4282c;
        this.f4283d = jVar.f4283d;
        this.f4284e = jVar.f4284e;
        this.f4285f = jVar.f4285f;
        this.f4286g = jVar.f4286g;
        this.f4287h = jVar.f4287h;
        this.f4288i = jVar.f4288i;
        String str = jVar.f4291l;
        this.f4291l = str;
        this.f4290k = jVar.f4290k;
        if (str != null) {
            bVar.put(str, this);
        }
        matrix.set(jVar.f4289j);
        ArrayList arrayList = jVar.f4281b;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Object obj = arrayList.get(i4);
            if (obj instanceof j) {
                this.f4281b.add(new j((j) obj, bVar));
            } else {
                if (obj instanceof i) {
                    i iVar = (i) obj;
                    ?? lVar2 = new l(iVar);
                    lVar2.f4270f = 0.0f;
                    lVar2.f4272h = 1.0f;
                    lVar2.f4273i = 1.0f;
                    lVar2.f4274j = 0.0f;
                    lVar2.f4275k = 1.0f;
                    lVar2.f4276l = 0.0f;
                    lVar2.f4277m = Paint.Cap.BUTT;
                    lVar2.f4278n = Paint.Join.MITER;
                    lVar2.f4279o = 4.0f;
                    lVar2.f4269e = iVar.f4269e;
                    lVar2.f4270f = iVar.f4270f;
                    lVar2.f4272h = iVar.f4272h;
                    lVar2.f4271g = iVar.f4271g;
                    lVar2.f4294c = iVar.f4294c;
                    lVar2.f4273i = iVar.f4273i;
                    lVar2.f4274j = iVar.f4274j;
                    lVar2.f4275k = iVar.f4275k;
                    lVar2.f4276l = iVar.f4276l;
                    lVar2.f4277m = iVar.f4277m;
                    lVar2.f4278n = iVar.f4278n;
                    lVar2.f4279o = iVar.f4279o;
                    lVar = lVar2;
                } else if (!(obj instanceof h)) {
                    throw new IllegalStateException("Unknown object in the tree!");
                } else {
                    lVar = new l((h) obj);
                }
                this.f4281b.add(lVar);
                Object obj2 = lVar.f4293b;
                if (obj2 != null) {
                    bVar.put(obj2, lVar);
                }
            }
        }
    }
}