package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import t.k;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f1298a;

    /* renamed from: b  reason: collision with root package name */
    public View f1299b;

    /* renamed from: c  reason: collision with root package name */
    public int f1300c;

    public Placeholder(Context context) {
        super(context);
        this.f1298a = -1;
        this.f1299b = null;
        this.f1300c = 4;
        a(null);
    }

    public final void a(AttributeSet attributeSet) {
        super.setVisibility(this.f1300c);
        this.f1298a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6650c);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 0) {
                    this.f1298a = obtainStyledAttributes.getResourceId(index, this.f1298a);
                } else if (index == 1) {
                    this.f1300c = obtainStyledAttributes.getInt(index, this.f1300c);
                }
            }
        }
    }

    public View getContent() {
        return this.f1299b;
    }

    public int getEmptyVisibility() {
        return this.f1300c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i4) {
        View findViewById;
        if (this.f1298a == i4) {
            return;
        }
        View view = this.f1299b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f1299b.getLayoutParams()).f1247a0 = false;
            this.f1299b = null;
        }
        this.f1298a = i4;
        if (i4 == -1 || (findViewById = ((View) getParent()).findViewById(i4)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i4) {
        this.f1300c = i4;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1298a = -1;
        this.f1299b = null;
        this.f1300c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1298a = -1;
        this.f1299b = null;
        this.f1300c = 4;
        a(attributeSet);
    }
}