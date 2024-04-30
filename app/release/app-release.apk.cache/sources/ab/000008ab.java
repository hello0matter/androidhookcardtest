package n0;

import android.graphics.Rect;
import j0.h;
import java.util.Comparator;
import l2.f;

/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f5710a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f5711b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5712c;

    /* renamed from: d  reason: collision with root package name */
    public final f f5713d;

    public c(boolean z4, f fVar) {
        this.f5712c = z4;
        this.f5713d = fVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f5713d.getClass();
        Rect rect = this.f5710a;
        ((h) obj).d(rect);
        Rect rect2 = this.f5711b;
        ((h) obj2).d(rect2);
        int i4 = rect.top;
        int i5 = rect2.top;
        if (i4 < i5) {
            return -1;
        }
        if (i4 > i5) {
            return 1;
        }
        int i6 = rect.left;
        int i7 = rect2.left;
        boolean z4 = this.f5712c;
        if (i6 < i7) {
            if (!z4) {
                return -1;
            }
            return 1;
        } else if (i6 > i7) {
            if (z4) {
                return -1;
            }
            return 1;
        } else {
            int i8 = rect.bottom;
            int i9 = rect2.bottom;
            if (i8 < i9) {
                return -1;
            }
            if (i8 > i9) {
                return 1;
            }
            int i10 = rect.right;
            int i11 = rect2.right;
            if (i10 < i11) {
                if (!z4) {
                    return -1;
                }
                return 1;
            } else if (i10 > i11) {
                if (z4) {
                    return -1;
                }
                return 1;
            } else {
                return 0;
            }
        }
    }
}