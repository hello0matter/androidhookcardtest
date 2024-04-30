package g0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f4763e = new byte[1792];

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f4764a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4765b;

    /* renamed from: c  reason: collision with root package name */
    public int f4766c;

    /* renamed from: d  reason: collision with root package name */
    public char f4767d;

    static {
        for (int i4 = 0; i4 < 1792; i4++) {
            f4763e[i4] = Character.getDirectionality(i4);
        }
    }

    public b(CharSequence charSequence) {
        this.f4764a = charSequence;
        this.f4765b = charSequence.length();
    }

    public final byte a() {
        CharSequence charSequence = this.f4764a;
        char charAt = charSequence.charAt(this.f4766c - 1);
        this.f4767d = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f4766c);
            this.f4766c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f4766c--;
        char c4 = this.f4767d;
        if (c4 < 1792) {
            return f4763e[c4];
        }
        return Character.getDirectionality(c4);
    }
}