package s0;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.o;

/* loaded from: classes.dex */
public final class i extends l2.f {

    /* renamed from: c  reason: collision with root package name */
    public final h f6513c;

    public i(TextView textView) {
        super(13, 0);
        this.f6513c = new h(textView);
    }

    @Override // l2.f
    public final InputFilter[] g(InputFilter[] inputFilterArr) {
        boolean z4;
        if (o.f1526j != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return inputFilterArr;
        }
        return this.f6513c.g(inputFilterArr);
    }

    @Override // l2.f
    public final boolean m() {
        return this.f6513c.f6512e;
    }

    @Override // l2.f
    public final void o(boolean z4) {
        boolean z5;
        if (o.f1526j != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5) {
            return;
        }
        this.f6513c.o(z4);
    }

    @Override // l2.f
    public final void r(boolean z4) {
        boolean z5;
        if (o.f1526j != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z6 = !z5;
        h hVar = this.f6513c;
        if (z6) {
            hVar.f6512e = z4;
        } else {
            hVar.r(z4);
        }
    }

    @Override // l2.f
    public final TransformationMethod t(TransformationMethod transformationMethod) {
        boolean z4;
        if (o.f1526j != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return transformationMethod;
        }
        return this.f6513c.t(transformationMethod);
    }
}