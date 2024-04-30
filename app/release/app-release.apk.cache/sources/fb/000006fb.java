package g0;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4780a;

    public abstract boolean a();

    public abstract float b(Object obj);

    public final boolean c(CharSequence charSequence, int i4) {
        if (charSequence != null && i4 >= 0 && charSequence.length() - i4 >= 0) {
            h hVar = (h) this.f4780a;
            if (hVar == null) {
                return a();
            }
            int a5 = hVar.a(charSequence, i4);
            if (a5 == 0) {
                return true;
            }
            if (a5 != 1) {
                return a();
            }
            return false;
        }
        throw new IllegalArgumentException();
    }

    public abstract void d(Object obj, float f4);
}