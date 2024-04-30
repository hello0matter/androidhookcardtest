package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import o.v;
import t.k;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements v {

    /* renamed from: h  reason: collision with root package name */
    public boolean f1027h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1028i;

    /* renamed from: j  reason: collision with root package name */
    public float f1029j;

    /* renamed from: k  reason: collision with root package name */
    public View[] f1030k;

    public MotionHelper(Context context) {
        super(context);
        this.f1027h = false;
        this.f1028i = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6657j);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 1) {
                    this.f1027h = obtainStyledAttributes.getBoolean(index, this.f1027h);
                } else if (index == 0) {
                    this.f1028i = obtainStyledAttributes.getBoolean(index, this.f1028i);
                }
            }
        }
    }

    public float getProgress() {
        return this.f1029j;
    }

    public void setProgress(float f4) {
        this.f1029j = f4;
        int i4 = 0;
        if (this.f1224b > 0) {
            this.f1030k = f((ConstraintLayout) getParent());
            while (i4 < this.f1224b) {
                setProgress(this.f1030k[i4], f4);
                i4++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i4 < childCount) {
            View childAt = viewGroup.getChildAt(i4);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f4);
            }
            i4++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1027h = false;
        this.f1028i = false;
        g(attributeSet);
    }

    public void setProgress(View view, float f4) {
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1027h = false;
        this.f1028i = false;
        g(attributeSet);
    }
}