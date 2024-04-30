package b0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class n {
    public n() {
        new ConcurrentHashMap();
    }

    public static Object e(Object[] objArr, int i4, l2.f fVar) {
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        if ((i4 & 1) == 0) {
            i5 = 400;
        } else {
            i5 = 700;
        }
        if ((i4 & 2) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Object obj = null;
        int i8 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int i9 = fVar.f5285a;
            switch (i9) {
                case 0:
                    i6 = ((f0.k) obj2).f4537c;
                    break;
                default:
                    i6 = ((a0.h) obj2).f18b;
                    break;
            }
            int abs = Math.abs(i6 - i5) * 2;
            switch (i9) {
                case 0:
                    z5 = ((f0.k) obj2).f4538d;
                    break;
                default:
                    z5 = ((a0.h) obj2).f19c;
                    break;
            }
            if (z5 == z4) {
                i7 = 0;
            } else {
                i7 = 1;
            }
            int i10 = abs + i7;
            if (obj == null || i8 > i10) {
                obj = obj2;
                i8 = i10;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, a0.g gVar, Resources resources, int i4);

    public abstract Typeface b(Context context, f0.k[] kVarArr, int i4);

    public Typeface c(Context context, InputStream inputStream) {
        File d4 = p.d(context);
        if (d4 == null) {
            return null;
        }
        try {
            if (!p.c(d4, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(d4.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            d4.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        File d4 = p.d(context);
        if (d4 == null) {
            return null;
        }
        try {
            if (!p.b(d4, resources, i4)) {
                return null;
            }
            return Typeface.createFromFile(d4.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            d4.delete();
        }
    }

    public f0.k f(int i4, f0.k[] kVarArr) {
        return (f0.k) e(kVarArr, i4, new l2.f(0));
    }
}