package l2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class s extends y {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f5373c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f5374d;

    public s(ArrayList arrayList, Matrix matrix) {
        this.f5373c = arrayList;
        this.f5374d = matrix;
    }

    @Override // l2.y
    public final void a(Matrix matrix, k2.a aVar, int i4, Canvas canvas) {
        for (y yVar : this.f5373c) {
            yVar.a(this.f5374d, aVar, i4, canvas);
        }
    }
}