package i0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public class a2 extends z1 {
    public a2(@NonNull g2 g2Var, @NonNull WindowInsets windowInsets) {
        super(g2Var, windowInsets);
    }

    @Override // i0.d2
    @NonNull
    public g2 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f5010c.consumeDisplayCutout();
        return g2.h(null, consumeDisplayCutout);
    }

    @Override // i0.d2
    @Nullable
    public l e() {
        DisplayCutout displayCutout;
        displayCutout = this.f5010c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new l(displayCutout);
    }

    @Override // i0.y1, i0.d2
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        if (Objects.equals(this.f5010c, a2Var.f5010c) && Objects.equals(this.f5014g, a2Var.f5014g)) {
            return true;
        }
        return false;
    }

    @Override // i0.d2
    public int hashCode() {
        return this.f5010c.hashCode();
    }
}