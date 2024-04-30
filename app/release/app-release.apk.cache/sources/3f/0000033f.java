package androidx.transition;

import a0.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import c1.c0;
import com.google.common.collect.c;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    public final Path f2346a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f2347b = new Matrix();

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2587i);
        try {
            String c4 = t.c(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (c4 != null) {
                b(c.e0(c4));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.transition.PathMotion
    public final Path a(float f4, float f5, float f6, float f7) {
        float f8 = f6 - f4;
        float f9 = f7 - f5;
        float sqrt = (float) Math.sqrt((f9 * f9) + (f8 * f8));
        double atan2 = Math.atan2(f9, f8);
        Matrix matrix = this.f2347b;
        matrix.setScale(sqrt, sqrt);
        matrix.postRotate((float) Math.toDegrees(atan2));
        matrix.postTranslate(f4, f5);
        Path path = new Path();
        this.f2346a.transform(matrix, path);
        return path;
    }

    public final void b(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f6 = fArr[0];
        float f7 = fArr[1];
        if (f6 == f4 && f7 == f5) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        Matrix matrix = this.f2347b;
        matrix.setTranslate(-f6, -f7);
        float f8 = f4 - f6;
        float f9 = f5 - f7;
        float sqrt = 1.0f / ((float) Math.sqrt((f9 * f9) + (f8 * f8)));
        matrix.postScale(sqrt, sqrt);
        matrix.postRotate((float) Math.toDegrees(-Math.atan2(f9, f8)));
        path.transform(matrix, this.f2346a);
    }
}