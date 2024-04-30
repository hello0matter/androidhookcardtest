package o;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public g f5818a;

    /* renamed from: b  reason: collision with root package name */
    public String f5819b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f5820c = new ArrayList();

    public final float a(float f4) {
        g gVar = this.f5818a;
        com.google.common.collect.c cVar = gVar.f5809f;
        if (cVar != null) {
            cVar.J0(f4, gVar.f5810g);
        } else {
            double[] dArr = gVar.f5810g;
            dArr[0] = gVar.f5808e[0];
            dArr[1] = gVar.f5805b[0];
        }
        return (float) ((gVar.f5804a.d(f4) * gVar.f5810g[1]) + gVar.f5810g[0]);
    }

    public final float b(float f4) {
        double b5;
        double signum;
        double b6;
        g gVar = this.f5818a;
        com.google.common.collect.c cVar = gVar.f5809f;
        double d4 = 0.0d;
        if (cVar != null) {
            double d5 = f4;
            cVar.N0(d5, gVar.f5811h);
            gVar.f5809f.J0(d5, gVar.f5810g);
        } else {
            double[] dArr = gVar.f5811h;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        double d6 = f4;
        n.h hVar = gVar.f5804a;
        double d7 = hVar.d(d6);
        double d8 = 2.0d;
        switch (hVar.f5682d) {
            case 1:
                double[] dArr2 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr2[1]) + dArr2[0]);
            case 2:
                b5 = hVar.b(d6) * 4.0d;
                signum = Math.signum((((hVar.c(d6) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                d4 = b5 * signum;
                double[] dArr22 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr22[1]) + dArr22[0]);
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                b6 = hVar.b(d6);
                d4 = b6 * d8;
                double[] dArr222 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr222[1]) + dArr222[0]);
            case VisibleForTesting.PROTECTED /* 4 */:
                b6 = -hVar.b(d6);
                d4 = b6 * d8;
                double[] dArr2222 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr2222[1]) + dArr2222[0]);
            case VisibleForTesting.NONE /* 5 */:
                d8 = hVar.b(d6) * (-6.283185307179586d);
                b6 = Math.sin(hVar.c(d6) * 6.283185307179586d);
                d4 = b6 * d8;
                double[] dArr22222 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr22222[1]) + dArr22222[0]);
            case 6:
                b5 = hVar.b(d6) * 4.0d;
                signum = (((hVar.c(d6) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                d4 = b5 * signum;
                double[] dArr222222 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr222222[1]) + dArr222222[0]);
            default:
                b5 = hVar.b(d6) * 6.283185307179586d;
                signum = Math.cos(hVar.c(d6) * 6.283185307179586d);
                d4 = b5 * signum;
                double[] dArr2222222 = gVar.f5811h;
                return (float) ((d4 * gVar.f5810g[1]) + (d7 * dArr2222222[1]) + dArr2222222[0]);
        }
    }

    public abstract void c(View view, float f4);

    public final String toString() {
        String str = this.f5819b;
        new DecimalFormat("##.##");
        Iterator it = this.f5820c.iterator();
        if (!it.hasNext()) {
            return str;
        }
        androidx.activity.j.f(it.next());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("[0 , ");
        throw null;
    }
}