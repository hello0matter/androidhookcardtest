package t;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f6560a;

    /* renamed from: b  reason: collision with root package name */
    public ConstraintAttribute$AttributeType f6561b;

    /* renamed from: c  reason: collision with root package name */
    public int f6562c;

    /* renamed from: d  reason: collision with root package name */
    public float f6563d;

    /* renamed from: e  reason: collision with root package name */
    public String f6564e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6565f;

    /* renamed from: g  reason: collision with root package name */
    public int f6566g;

    public a(a aVar, Object obj) {
        this.f6560a = aVar.f6560a;
        this.f6561b = aVar.f6561b;
        g(obj);
    }

    public static int a(int i4) {
        int i5 = (i4 & (~(i4 >> 31))) - 255;
        return (i5 & (i5 >> 31)) + 255;
    }

    public static void e(View view, HashMap hashMap) {
        StringBuilder sb;
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str);
            String str2 = "set" + str;
            try {
            } catch (IllegalAccessException e4) {
                e = e4;
                sb = new StringBuilder(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e5) {
                Log.e("TransitionLayout", e5.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                Log.e("TransitionLayout", cls.getName() + " must have a method " + str2);
            } catch (InvocationTargetException e6) {
                e = e6;
                sb = new StringBuilder(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            }
            switch (aVar.f6561b.ordinal()) {
                case 0:
                    cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f6562c));
                    continue;
                case 1:
                    cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f6563d));
                    continue;
                case 2:
                    cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f6566g));
                    continue;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    Method method = cls.getMethod(str2, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(aVar.f6566g);
                    method.invoke(view, colorDrawable);
                    continue;
                case VisibleForTesting.PROTECTED /* 4 */:
                    cls.getMethod(str2, CharSequence.class).invoke(view, aVar.f6564e);
                    continue;
                case VisibleForTesting.NONE /* 5 */:
                    cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f6565f));
                    continue;
                case 6:
                    cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f6563d));
                    continue;
                default:
                    continue;
            }
            Log.e("TransitionLayout", e5.getMessage());
            Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
            Log.e("TransitionLayout", cls.getName() + " must have a method " + str2);
        }
    }

    public final float b() {
        switch (this.f6561b.ordinal()) {
            case 0:
                return this.f6562c;
            case 1:
                return this.f6563d;
            case 2:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case VisibleForTesting.PROTECTED /* 4 */:
                throw new RuntimeException("Cannot interpolate String");
            case VisibleForTesting.NONE /* 5 */:
                if (this.f6565f) {
                    return 0.0f;
                }
                return 1.0f;
            case 6:
                return this.f6563d;
            default:
                return Float.NaN;
        }
    }

    public final void c(float[] fArr) {
        float f4;
        switch (this.f6561b.ordinal()) {
            case 0:
                fArr[0] = this.f6562c;
                return;
            case 1:
                fArr[0] = this.f6563d;
                return;
            case 2:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                int i4 = this.f6566g;
                float pow = (float) Math.pow(((i4 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i4 >> 8) & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((i4 & 255) / 255.0f, 2.2d);
                fArr[3] = ((i4 >> 24) & 255) / 255.0f;
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case VisibleForTesting.NONE /* 5 */:
                if (this.f6565f) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                fArr[0] = f4;
                return;
            case 6:
                fArr[0] = this.f6563d;
                return;
            default:
                return;
        }
    }

    public final int d() {
        int ordinal = this.f6561b.ordinal();
        if (ordinal != 2 && ordinal != 3) {
            return 1;
        }
        return 4;
    }

    public final void f(View view, float[] fArr) {
        StringBuilder sb;
        Class<?> cls = view.getClass();
        StringBuilder sb2 = new StringBuilder("set");
        String str = this.f6560a;
        sb2.append(str);
        String sb3 = sb2.toString();
        try {
            boolean z4 = true;
            switch (this.f6561b.ordinal()) {
                case 0:
                    cls.getMethod(sb3, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(sb3, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(sb3, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    Method method = cls.getMethod(sb3, Drawable.class);
                    int a5 = a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
                    int a6 = a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((a5 << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a6 << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method.invoke(view, colorDrawable);
                    return;
                case VisibleForTesting.PROTECTED /* 4 */:
                    throw new RuntimeException("unable to interpolate strings " + str);
                case VisibleForTesting.NONE /* 5 */:
                    Method method2 = cls.getMethod(sb3, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z4 = false;
                    }
                    objArr[0] = Boolean.valueOf(z4);
                    method2.invoke(view, objArr);
                    return;
                case 6:
                    cls.getMethod(sb3, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e4) {
            e = e4;
            sb = new StringBuilder("cannot access method ");
            sb.append(sb3);
            sb.append("on View \"");
            sb.append(com.google.common.collect.c.E0(view));
            sb.append("\"");
            Log.e("TransitionLayout", sb.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e = e5;
            sb = new StringBuilder("no method ");
            sb.append(sb3);
            sb.append("on View \"");
            sb.append(com.google.common.collect.c.E0(view));
            sb.append("\"");
            Log.e("TransitionLayout", sb.toString());
            e.printStackTrace();
        } catch (InvocationTargetException e6) {
            e = e6;
            e.printStackTrace();
        }
    }

    public final void g(Object obj) {
        switch (this.f6561b.ordinal()) {
            case 0:
                this.f6562c = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.f6563d = ((Float) obj).floatValue();
                return;
            case 2:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                this.f6566g = ((Integer) obj).intValue();
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                this.f6564e = (String) obj;
                return;
            case VisibleForTesting.NONE /* 5 */:
                this.f6565f = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}