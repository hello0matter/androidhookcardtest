package p1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;
import l.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final k f6136a = new k();

    /* renamed from: b  reason: collision with root package name */
    public final k f6137b = new k();

    public static f a(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0) {
            return b(context, resourceId);
        }
        return null;
    }

    public static f b(Context context, int i4) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i4);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return c(arrayList);
        } catch (Exception e4) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i4), e4);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [p1.g, java.lang.Object] */
    public static f c(ArrayList arrayList) {
        f fVar = new f();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Animator animator = (Animator) arrayList.get(i4);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                fVar.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
                    if (interpolator instanceof AccelerateInterpolator) {
                        interpolator = a.f6130c;
                    } else if (interpolator instanceof DecelerateInterpolator) {
                        interpolator = a.f6131d;
                    }
                } else {
                    interpolator = a.f6129b;
                }
                ?? obj = new Object();
                obj.f6141d = 0;
                obj.f6142e = 1;
                obj.f6138a = startDelay;
                obj.f6139b = duration;
                obj.f6140c = interpolator;
                obj.f6141d = objectAnimator.getRepeatCount();
                obj.f6142e = objectAnimator.getRepeatMode();
                fVar.f6136a.put(propertyName, obj);
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return fVar;
    }

    public final ObjectAnimator d(String str, ExtendedFloatingActionButton extendedFloatingActionButton, Property property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(extendedFloatingActionButton, e(str));
        ofPropertyValuesHolder.setProperty(property);
        f(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    public final PropertyValuesHolder[] e(String str) {
        if (g(str)) {
            PropertyValuesHolder[] propertyValuesHolderArr = (PropertyValuesHolder[]) this.f6137b.getOrDefault(str, null);
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
            for (int i4 = 0; i4 < propertyValuesHolderArr.length; i4++) {
                propertyValuesHolderArr2[i4] = propertyValuesHolderArr[i4].clone();
            }
            return propertyValuesHolderArr2;
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f6136a.equals(((f) obj).f6136a);
    }

    public final g f(String str) {
        k kVar = this.f6136a;
        if (kVar.getOrDefault(str, null) != null) {
            return (g) kVar.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public final boolean g(String str) {
        if (this.f6137b.getOrDefault(str, null) != null) {
            return true;
        }
        return false;
    }

    public final void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f6137b.put(str, propertyValuesHolderArr);
    }

    public final int hashCode() {
        return this.f6136a.hashCode();
    }

    public final String toString() {
        return "\n" + f.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f6136a + "}\n";
    }
}