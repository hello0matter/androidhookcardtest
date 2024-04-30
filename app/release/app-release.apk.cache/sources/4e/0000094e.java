package q0;

import android.view.View;

/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6297b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, int i4) {
        super(str);
        this.f6297b = i4;
    }

    @Override // g0.i
    public final /* bridge */ /* synthetic */ float b(Object obj) {
        switch (this.f6297b) {
            case 2:
                return e((View) obj);
            case 8:
                return e((View) obj);
            case 9:
                return e((View) obj);
            case 10:
                return e((View) obj);
            case 11:
                return e((View) obj);
            default:
                return e((View) obj);
        }
    }

    @Override // g0.i
    public final /* bridge */ /* synthetic */ void d(Object obj, float f4) {
        switch (this.f6297b) {
            case 2:
                f((View) obj, f4);
                return;
            case 8:
                f((View) obj, f4);
                return;
            case 9:
                f((View) obj, f4);
                return;
            case 10:
                f((View) obj, f4);
                return;
            case 11:
                f((View) obj, f4);
                return;
            default:
                f((View) obj, f4);
                return;
        }
    }

    public final float e(View view) {
        switch (this.f6297b) {
            case 2:
                return view.getAlpha();
            case 8:
                return view.getScaleX();
            case 9:
                return view.getScaleY();
            case 10:
                return view.getRotation();
            case 11:
                return view.getRotationX();
            default:
                return view.getRotationY();
        }
    }

    public final void f(View view, float f4) {
        switch (this.f6297b) {
            case 2:
                view.setAlpha(f4);
                return;
            case 8:
                view.setScaleX(f4);
                return;
            case 9:
                view.setScaleY(f4);
                return;
            case 10:
                view.setRotation(f4);
                return;
            case 11:
                view.setRotationX(f4);
                return;
            default:
                view.setRotationY(f4);
                return;
        }
    }
}