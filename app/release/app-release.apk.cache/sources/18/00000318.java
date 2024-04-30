package androidx.recyclerview.widget;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: a  reason: collision with root package name */
    public int[] f2247a;

    /* renamed from: b  reason: collision with root package name */
    public List f2248b;

    public final void a(int i4) {
        int[] iArr = this.f2247a;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i4, 10) + 1];
            this.f2247a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int length = iArr.length;
            while (length <= i4) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f2247a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.f2247a;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(int r6) {
        /*
            r5 = this;
            int[] r0 = r5.f2247a
            r1 = -1
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r0.length
            if (r6 < r0) goto La
            return r1
        La:
            java.util.List r0 = r5.f2248b
            if (r0 != 0) goto L10
        Le:
            r0 = r1
            goto L5f
        L10:
            r2 = 0
            if (r0 != 0) goto L14
            goto L2d
        L14:
            int r0 = r0.size()
            int r0 = r0 + (-1)
        L1a:
            if (r0 < 0) goto L2d
            java.util.List r3 = r5.f2248b
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r3
            int r4 = r3.f2028a
            if (r4 != r6) goto L2a
            r2 = r3
            goto L2d
        L2a:
            int r0 = r0 + (-1)
            goto L1a
        L2d:
            if (r2 == 0) goto L34
            java.util.List r0 = r5.f2248b
            r0.remove(r2)
        L34:
            java.util.List r0 = r5.f2248b
            int r0 = r0.size()
            r2 = 0
        L3b:
            if (r2 >= r0) goto L4d
            java.util.List r3 = r5.f2248b
            java.lang.Object r3 = r3.get(r2)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r3
            int r3 = r3.f2028a
            if (r3 < r6) goto L4a
            goto L4e
        L4a:
            int r2 = r2 + 1
            goto L3b
        L4d:
            r2 = r1
        L4e:
            if (r2 == r1) goto Le
            java.util.List r0 = r5.f2248b
            java.lang.Object r0 = r0.get(r2)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r0
            java.util.List r3 = r5.f2248b
            r3.remove(r2)
            int r0 = r0.f2028a
        L5f:
            if (r0 != r1) goto L6b
            int[] r0 = r5.f2247a
            int r2 = r0.length
            java.util.Arrays.fill(r0, r6, r2, r1)
            int[] r6 = r5.f2247a
            int r6 = r6.length
            return r6
        L6b:
            int[] r2 = r5.f2247a
            int r0 = r0 + 1
            java.util.Arrays.fill(r2, r6, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r1.b(int):int");
    }

    public final void c(int i4, int i5) {
        int[] iArr = this.f2247a;
        if (iArr != null && i4 < iArr.length) {
            int i6 = i4 + i5;
            a(i6);
            int[] iArr2 = this.f2247a;
            System.arraycopy(iArr2, i4, iArr2, i6, (iArr2.length - i4) - i5);
            Arrays.fill(this.f2247a, i4, i6, -1);
            List list = this.f2248b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f2248b.get(size);
                    int i7 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2028a;
                    if (i7 >= i4) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2028a = i7 + i5;
                    }
                }
            }
        }
    }

    public final void d(int i4, int i5) {
        int[] iArr = this.f2247a;
        if (iArr != null && i4 < iArr.length) {
            int i6 = i4 + i5;
            a(i6);
            int[] iArr2 = this.f2247a;
            System.arraycopy(iArr2, i6, iArr2, i4, (iArr2.length - i4) - i5);
            int[] iArr3 = this.f2247a;
            Arrays.fill(iArr3, iArr3.length - i5, iArr3.length, -1);
            List list = this.f2248b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f2248b.get(size);
                    int i7 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2028a;
                    if (i7 >= i4) {
                        if (i7 < i6) {
                            this.f2248b.remove(size);
                        } else {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2028a = i7 - i5;
                        }
                    }
                }
            }
        }
    }
}