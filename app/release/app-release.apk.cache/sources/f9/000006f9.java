package g0;

/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    public static final g f4779a = new Object();

    @Override // g0.h
    public final int a(CharSequence charSequence, int i4) {
        int i5 = 2;
        for (int i6 = 0; i6 < i4 && i5 == 2; i6++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i6));
            j jVar = k.f4782a;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            i5 = 2;
                            break;
                    }
                }
                i5 = 0;
            }
            i5 = 1;
        }
        return i5;
    }
}