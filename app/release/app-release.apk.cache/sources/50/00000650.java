package d1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class e extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4261a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4262b;

    public e(Drawable.ConstantState constantState) {
        this.f4262b = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        switch (this.f4261a) {
            case 0:
                return ((Drawable.ConstantState) this.f4262b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f4261a) {
            case 0:
                return ((Drawable.ConstantState) this.f4262b).getChangingConfigurations();
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        int i4 = this.f4261a;
        Object obj = this.f4262b;
        switch (i4) {
            case 0:
                f fVar = new f(null);
                Drawable newDrawable = ((Drawable.ConstantState) obj).newDrawable();
                fVar.f4268a = newDrawable;
                newDrawable.setCallback(fVar.f4267f);
                return fVar;
            default:
                return (d2.b) obj;
        }
    }

    public e(d2.b bVar) {
        this.f4262b = bVar;
    }

    public /* synthetic */ e(d2.b bVar, int i4) {
        this(bVar);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        switch (this.f4261a) {
            case 0:
                f fVar = new f(null);
                Drawable newDrawable = ((Drawable.ConstantState) this.f4262b).newDrawable(resources);
                fVar.f4268a = newDrawable;
                newDrawable.setCallback(fVar.f4267f);
                return fVar;
            default:
                return super.newDrawable(resources);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f4261a) {
            case 0:
                f fVar = new f(null);
                Drawable newDrawable = ((Drawable.ConstantState) this.f4262b).newDrawable(resources, theme);
                fVar.f4268a = newDrawable;
                newDrawable.setCallback(fVar.f4267f);
                return fVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}