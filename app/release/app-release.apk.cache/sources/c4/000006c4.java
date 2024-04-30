package f2;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final c f4560a;

    /* renamed from: b  reason: collision with root package name */
    public final b f4561b;

    /* renamed from: c  reason: collision with root package name */
    public final View f4562c;

    /* JADX WARN: Multi-variable type inference failed */
    public f(View view) {
        c cVar;
        b bVar = (b) view;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 34) {
            cVar = new Object();
        } else if (i4 >= 33) {
            cVar = new Object();
        } else {
            cVar = null;
        }
        this.f4560a = cVar;
        this.f4561b = bVar;
        this.f4562c = view;
    }
}