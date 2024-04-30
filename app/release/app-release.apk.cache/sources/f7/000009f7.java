package v1;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.msphone.R;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class m extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public static final int[] f6990q = {1};

    /* renamed from: r  reason: collision with root package name */
    public static final int[] f6991r = {1, 0};

    @Override // com.google.common.collect.c
    public final j m1(b bVar, View view) {
        float f4;
        float f5;
        float f6;
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) bVar;
        float f7 = carouselLayoutManager.f2287o;
        if (carouselLayoutManager.K0()) {
            f7 = carouselLayoutManager.f2286n;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carouselLayoutManager.K0()) {
            f8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f9 = f8;
        float dimension = view.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_min) + f9;
        float dimension2 = view.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_max) + f9;
        float min = Math.min(measuredHeight + f9, f7);
        float K = com.google.common.collect.c.K((measuredHeight / 3.0f) + f9, view.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_min) + f9, view.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_max) + f9);
        float f10 = (min + K) / 2.0f;
        int[] iArr = f6990q;
        int[] iArr2 = f6991r;
        int i4 = Integer.MIN_VALUE;
        int i5 = 0;
        int i6 = Integer.MIN_VALUE;
        for (int i7 : iArr2) {
            if (i7 > i6) {
                i6 = i7;
            }
        }
        float f11 = f7 - (i6 * f10);
        int i8 = iArr[0];
        if (i8 > Integer.MIN_VALUE) {
            i4 = i8;
        }
        int ceil = (int) Math.ceil(f7 / min);
        int i9 = 1;
        int max = (ceil - ((int) Math.max(1.0d, Math.floor((f11 - (i4 * dimension2)) / min)))) + 1;
        int[] iArr3 = new int[max];
        for (int i10 = 0; i10 < max; i10++) {
            iArr3[i10] = ceil - i10;
        }
        a aVar = null;
        int i11 = 1;
        int i12 = 0;
        loop2: while (true) {
            float f12 = 0.0f;
            if (i12 < max) {
                int i13 = iArr3[i12];
                int length = iArr2.length;
                int i14 = i5;
                while (i14 < length) {
                    int i15 = iArr2[i14];
                    int i16 = i11;
                    a aVar2 = aVar;
                    int i17 = i5;
                    while (i17 < i9) {
                        f4 = f9;
                        int i18 = i17;
                        int i19 = i14;
                        int i20 = length;
                        float f13 = dimension;
                        float f14 = dimension;
                        f5 = f12;
                        int i21 = i12;
                        int[] iArr4 = iArr3;
                        int i22 = max;
                        int[] iArr5 = iArr2;
                        a aVar3 = new a(i16, K, f13, dimension2, iArr[i17], f10, i15, min, i13, f7);
                        float f15 = aVar3.f6958h;
                        aVar2 = aVar2;
                        if (aVar2 == null || f15 < aVar2.f6958h) {
                            if (f15 == f5) {
                                aVar = aVar3;
                                break loop2;
                            }
                            aVar2 = aVar3;
                        }
                        i16++;
                        i17 = i18 + 1;
                        f9 = f4;
                        f12 = f5;
                        iArr3 = iArr4;
                        i14 = i19;
                        length = i20;
                        dimension = f14;
                        i12 = i21;
                        max = i22;
                        iArr2 = iArr5;
                        i9 = 1;
                    }
                    i14++;
                    aVar = aVar2;
                    i11 = i16;
                    dimension = dimension;
                    i9 = 1;
                    i5 = 0;
                }
                i12++;
                i9 = 1;
                i5 = 0;
            } else {
                f4 = f9;
                f5 = 0.0f;
                break;
            }
        }
        float dimension3 = view.getContext().getResources().getDimension(R.dimen.m3_carousel_gone_size) + f4;
        float f16 = dimension3 / 2.0f;
        float f17 = f5 - f16;
        float f18 = (aVar.f6956f / 2.0f) + f5;
        int i23 = aVar.f6957g;
        int i24 = 0;
        float f19 = aVar.f6956f;
        float max2 = (Math.max(0, i23 - 1) * f19) + f18;
        float f20 = (f19 / 2.0f) + max2;
        int i25 = aVar.f6954d;
        if (i25 > 0) {
            max2 = (aVar.f6955e / 2.0f) + f20;
        }
        if (i25 > 0) {
            f20 = (aVar.f6955e / 2.0f) + max2;
        }
        int i26 = aVar.f6953c;
        if (i26 > 0) {
            f6 = (aVar.f6952b / 2.0f) + f20;
        } else {
            f6 = max2;
        }
        float f21 = f7 + f16;
        float f22 = 1.0f - ((dimension3 - f4) / (f19 - f4));
        float f23 = 1.0f - ((aVar.f6952b - f4) / (f19 - f4));
        float f24 = 1.0f - ((aVar.f6955e - f4) / (f19 - f4));
        h hVar = new h(f19);
        hVar.a(f17, f22, dimension3, false);
        float f25 = aVar.f6956f;
        if (i23 > 0 && f25 > 0.0f) {
            while (i24 < i23) {
                hVar.a((i24 * f25) + f18, 0.0f, f25, true);
                i24++;
                f18 = f18;
                i23 = i23;
            }
        }
        if (i25 > 0) {
            hVar.a(max2, f24, aVar.f6955e, false);
        }
        if (i26 > 0) {
            float f26 = aVar.f6952b;
            if (i26 > 0 && f26 > 0.0f) {
                for (int i27 = 0; i27 < i26; i27++) {
                    hVar.a((i27 * f26) + f6, f23, f26, false);
                }
            }
        }
        hVar.a(f21, f22, dimension3, false);
        return hVar.b();
    }
}