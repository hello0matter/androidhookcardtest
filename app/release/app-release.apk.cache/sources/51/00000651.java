package d1;

import a0.s;
import a0.t;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class f extends g implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    public final Context f4264c;

    /* renamed from: d  reason: collision with root package name */
    public androidx.appcompat.widget.e f4265d = null;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f4266e = null;

    /* renamed from: f  reason: collision with root package name */
    public final d.a f4267f = new d.a(this);

    /* renamed from: b  reason: collision with root package name */
    public final d f4263b = new Drawable.ConstantState();

    /* JADX WARN: Type inference failed for: r2v1, types: [android.graphics.drawable.Drawable$ConstantState, d1.d] */
    public f(Context context) {
        this.f4264c = context;
    }

    @Override // d1.g, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.b.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        d dVar = this.f4263b;
        dVar.f4257a.draw(canvas);
        if (dVar.f4258b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.a.a(drawable);
        }
        return this.f4263b.f4257a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f4263b.getClass();
        return changingConfigurations | 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.b.c(drawable);
        }
        return this.f4263b.f4257a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f4268a != null) {
            return new e(this.f4268a.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f4263b.f4257a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f4263b.f4257a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f4263b.f4257a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.a.d(drawable);
        }
        return this.f4263b.f4257a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f4263b.f4258b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f4263b.f4257a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4263b.f4257a.setBounds(rect);
        }
    }

    @Override // d1.g, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setLevel(i4);
        }
        return this.f4263b.f4257a.setLevel(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f4263b.f4257a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setAlpha(i4);
        } else {
            this.f4263b.f4257a.setAlpha(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.a.e(drawable, z4);
        } else {
            this.f4263b.f4257a.setAutoMirrored(z4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4263b.f4257a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            com.google.common.collect.c.S1(drawable, i4);
        } else {
            this.f4263b.f4257a.setTint(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            com.google.common.collect.c.T1(drawable, colorStateList);
        } else {
            this.f4263b.f4257a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            com.google.common.collect.c.U1(drawable, mode);
        } else {
            this.f4263b.f4257a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setVisible(z4, z5);
        }
        this.f4263b.f4257a.setVisible(z4, z5);
        return super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        d dVar = this.f4263b;
        if (dVar.f4258b.isStarted()) {
            return;
        }
        dVar.f4258b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4263b.f4258b.end();
        }
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [l.b, l.k] */
    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        d dVar;
        TypedArray obtainAttributes;
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            dVar = this.f4263b;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = t.e(resources, theme, attributeSet, a.f4253e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        p pVar = new p();
                        ThreadLocal threadLocal = s.f38a;
                        pVar.f4268a = a0.k.a(resources, resourceId, theme);
                        new o(pVar.f4268a.getConstantState());
                        pVar.f4330f = false;
                        pVar.setCallback(this.f4267f);
                        p pVar2 = dVar.f4257a;
                        if (pVar2 != null) {
                            pVar2.setCallback(null);
                        }
                        dVar.f4257a = pVar;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.f4254f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4264c;
                        if (context != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, resourceId2);
                            loadAnimator.setTarget(dVar.f4257a.f4326b.f4313b.f4311o.getOrDefault(string, null));
                            if (dVar.f4259c == null) {
                                dVar.f4259c = new ArrayList();
                                dVar.f4260d = new l.k();
                            }
                            dVar.f4259c.add(loadAnimator);
                            dVar.f4260d.put(loadAnimator, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        if (dVar.f4258b == null) {
            dVar.f4258b = new AnimatorSet();
        }
        dVar.f4258b.playTogether(dVar.f4259c);
    }
}