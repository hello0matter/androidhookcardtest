package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class f0 {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f747c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    public final ProgressBar f748a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f749b;

    public f0(ProgressBar progressBar) {
        this.f748a = progressBar;
    }

    public void a(AttributeSet attributeSet, int i4) {
        ProgressBar progressBar = this.f748a;
        q3 f4 = q3.f(progressBar.getContext(), attributeSet, f747c, i4, 0);
        Drawable c4 = f4.c(0);
        if (c4 != null) {
            if (c4 instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) c4;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i5 = 0; i5 < numberOfFrames; i5++) {
                    Drawable b5 = b(animationDrawable.getFrame(i5), true);
                    b5.setLevel(10000);
                    animationDrawable2.addFrame(b5, animationDrawable.getDuration(i5));
                }
                animationDrawable2.setLevel(10000);
                c4 = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(c4);
        }
        Drawable c5 = f4.c(1);
        if (c5 != null) {
            progressBar.setProgressDrawable(b(c5, false));
        }
        f4.g();
    }

    public final Drawable b(Drawable drawable, boolean z4) {
        boolean z5;
        if (drawable instanceof c0.e) {
            ((c0.f) ((c0.e) drawable)).getClass();
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i4 = 0; i4 < numberOfLayers; i4++) {
                int id = layerDrawable.getId(i4);
                Drawable drawable2 = layerDrawable.getDrawable(i4);
                if (id != 16908301 && id != 16908303) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                drawableArr[i4] = b(drawable2, z5);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i5 = 0; i5 < numberOfLayers; i5++) {
                layerDrawable2.setId(i5, layerDrawable.getId(i5));
                layerDrawable2.setLayerGravity(i5, layerDrawable.getLayerGravity(i5));
                layerDrawable2.setLayerWidth(i5, layerDrawable.getLayerWidth(i5));
                layerDrawable2.setLayerHeight(i5, layerDrawable.getLayerHeight(i5));
                layerDrawable2.setLayerInsetLeft(i5, layerDrawable.getLayerInsetLeft(i5));
                layerDrawable2.setLayerInsetRight(i5, layerDrawable.getLayerInsetRight(i5));
                layerDrawable2.setLayerInsetTop(i5, layerDrawable.getLayerInsetTop(i5));
                layerDrawable2.setLayerInsetBottom(i5, layerDrawable.getLayerInsetBottom(i5));
                layerDrawable2.setLayerInsetStart(i5, layerDrawable.getLayerInsetStart(i5));
                layerDrawable2.setLayerInsetEnd(i5, layerDrawable.getLayerInsetEnd(i5));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f749b == null) {
                this.f749b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z4) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
        return drawable;
    }
}