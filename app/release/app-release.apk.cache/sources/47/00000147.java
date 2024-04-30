package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: l  reason: collision with root package name */
    public static final RectF f771l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    public static final ConcurrentHashMap f772m = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public int f773a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f774b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f775c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f776d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f777e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f778f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f779g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f780h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f781i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f782j;

    /* renamed from: k  reason: collision with root package name */
    public final e1 f783k;

    static {
        new ConcurrentHashMap();
    }

    public i1(TextView textView) {
        this.f781i = textView;
        this.f782j = textView.getContext();
        this.f783k = Build.VERSION.SDK_INT >= 29 ? new g1() : new e1();
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i4 : iArr) {
            if (i4 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i4)) < 0) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        return iArr2;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f772m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception e4) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e4);
            return null;
        }
    }

    public static Object e(Object obj, String str, Object obj2) {
        try {
            return d(str).invoke(obj, new Object[0]);
        } catch (Exception e4) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e4);
            return obj2;
        }
    }

    public final void a() {
        if (f()) {
            if (this.f774b) {
                if (this.f781i.getMeasuredHeight() <= 0 || this.f781i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f783k.b(this.f781i) ? 1048576 : (this.f781i.getMeasuredWidth() - this.f781i.getTotalPaddingLeft()) - this.f781i.getTotalPaddingRight();
                int height = (this.f781i.getHeight() - this.f781i.getCompoundPaddingBottom()) - this.f781i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f771l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float c4 = c(rectF);
                        if (c4 != this.f781i.getTextSize()) {
                            g(0, c4);
                        }
                    } finally {
                    }
                }
            }
            this.f774b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f778f.length;
        if (length != 0) {
            int i4 = length - 1;
            int i5 = 0;
            int i6 = 1;
            while (i6 <= i4) {
                int i7 = (i6 + i4) / 2;
                int i8 = this.f778f[i7];
                TextView textView = this.f781i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    text = transformation;
                }
                int b5 = b1.b(textView);
                TextPaint textPaint = this.f780h;
                if (textPaint == null) {
                    this.f780h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f780h.set(textView.getPaint());
                this.f780h.setTextSize(i8);
                StaticLayout a5 = d1.a(text, (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b5, this.f781i, this.f780h, this.f783k);
                if ((b5 != -1 && (a5.getLineCount() > b5 || a5.getLineEnd(a5.getLineCount() - 1) != text.length())) || a5.getHeight() > rectF.bottom) {
                    i5 = i7 - 1;
                    i4 = i5;
                } else {
                    int i9 = i7 + 1;
                    i5 = i6;
                    i6 = i9;
                }
            }
            return this.f778f[i5];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final boolean f() {
        return j() && this.f773a != 0;
    }

    public final void g(int i4, float f4) {
        Resources resources;
        Context context = this.f782j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i4, f4, resources.getDisplayMetrics());
        TextView textView = this.f781i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean a5 = c1.a(textView);
            if (textView.getLayout() != null) {
                this.f774b = false;
                try {
                    Method d4 = d("nullLayouts");
                    if (d4 != null) {
                        d4.invoke(textView, new Object[0]);
                    }
                } catch (Exception e4) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e4);
                }
                if (!a5) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f773a == 1) {
            if (!this.f779g || this.f778f.length == 0) {
                int floor = ((int) Math.floor((this.f777e - this.f776d) / this.f775c)) + 1;
                int[] iArr = new int[floor];
                for (int i4 = 0; i4 < floor; i4++) {
                    iArr[i4] = Math.round((i4 * this.f775c) + this.f776d);
                }
                this.f778f = b(iArr);
            }
            this.f774b = true;
        } else {
            this.f774b = false;
        }
        return this.f774b;
    }

    public final boolean i() {
        int[] iArr = this.f778f;
        int length = iArr.length;
        boolean z4 = length > 0;
        this.f779g = z4;
        if (z4) {
            this.f773a = 1;
            this.f776d = iArr[0];
            this.f777e = iArr[length - 1];
            this.f775c = -1.0f;
        }
        return z4;
    }

    public final boolean j() {
        return !(this.f781i instanceof AppCompatEditText);
    }

    public final void k(float f4, float f5, float f6) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
        } else if (f5 <= f4) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f5 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        } else if (f6 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f6 + "px) is less or equal to (0px)");
        } else {
            this.f773a = 1;
            this.f776d = f4;
            this.f777e = f5;
            this.f775c = f6;
            this.f779g = false;
        }
    }
}