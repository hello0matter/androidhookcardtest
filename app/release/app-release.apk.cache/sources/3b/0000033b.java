package androidx.transition;

import a0.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.j3;
import c1.c0;
import c1.l;
import c1.m0;
import c1.p0;
import com.example.msphone.R;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ChangeTransform extends Transition {
    public static final String[] B = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final j3 C = new j3(float[].class, "nonTranslations", 7);
    public static final j3 D = new j3(PointF.class, "translations", 8);
    public static final boolean E = true;
    public final Matrix A;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f2344y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f2345z;

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z4;
        this.f2344y = true;
        this.f2345z = true;
        this.A = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2583e);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        if (!t.d(xmlPullParser, "reparentWithOverlay")) {
            z4 = true;
        } else {
            z4 = obtainStyledAttributes.getBoolean(1, true);
        }
        this.f2344y = z4;
        this.f2345z = t.d(xmlPullParser, "reparent") ? obtainStyledAttributes.getBoolean(0, true) : true;
        obtainStyledAttributes.recycle();
    }

    public final void H(m0 m0Var) {
        Matrix matrix;
        View view = m0Var.f2647b;
        if (view.getVisibility() == 8) {
            return;
        }
        HashMap hashMap = m0Var.f2646a;
        hashMap.put("android:changeTransform:parent", view.getParent());
        hashMap.put("android:changeTransform:transforms", new l(view));
        Matrix matrix2 = view.getMatrix();
        if (matrix2 != null && !matrix2.isIdentity()) {
            matrix = new Matrix(matrix2);
        } else {
            matrix = null;
        }
        hashMap.put("android:changeTransform:matrix", matrix);
        if (this.f2345z) {
            Matrix matrix3 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            p0.f2666a.B(viewGroup, matrix3);
            matrix3.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            hashMap.put("android:changeTransform:parentMatrix", matrix3);
            hashMap.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            hashMap.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    @Override // androidx.transition.Transition
    public final void d(m0 m0Var) {
        H(m0Var);
    }

    @Override // androidx.transition.Transition
    public final void g(m0 m0Var) {
        H(m0Var);
        if (!E) {
            View view = m0Var.f2647b;
            ((ViewGroup) view.getParent()).startViewTransition(view);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:120:0x0361
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // androidx.transition.Transition
    public final android.animation.Animator k(android.view.ViewGroup r24, c1.m0 r25, c1.m0 r26) {
        /*
            Method dump skipped, instructions count: 1149
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.k(android.view.ViewGroup, c1.m0, c1.m0):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public final String[] p() {
        return B;
    }
}