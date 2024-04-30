package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import t.k;

/* loaded from: classes.dex */
public class MockView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f1194a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f1195b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f1196c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1197d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1198e;

    /* renamed from: f  reason: collision with root package name */
    public String f1199f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f1200g;

    /* renamed from: h  reason: collision with root package name */
    public int f1201h;

    /* renamed from: i  reason: collision with root package name */
    public int f1202i;

    /* renamed from: j  reason: collision with root package name */
    public int f1203j;

    /* renamed from: k  reason: collision with root package name */
    public int f1204k;

    public MockView(Context context) {
        super(context);
        this.f1194a = new Paint();
        this.f1195b = new Paint();
        this.f1196c = new Paint();
        this.f1197d = true;
        this.f1198e = true;
        this.f1199f = null;
        this.f1200g = new Rect();
        this.f1201h = Color.argb(255, 0, 0, 0);
        this.f1202i = Color.argb(255, 200, 200, 200);
        this.f1203j = Color.argb(255, 50, 50, 50);
        this.f1204k = 4;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6655h);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 1) {
                    this.f1199f = obtainStyledAttributes.getString(index);
                } else if (index == 4) {
                    this.f1197d = obtainStyledAttributes.getBoolean(index, this.f1197d);
                } else if (index == 0) {
                    this.f1201h = obtainStyledAttributes.getColor(index, this.f1201h);
                } else if (index == 2) {
                    this.f1203j = obtainStyledAttributes.getColor(index, this.f1203j);
                } else if (index == 3) {
                    this.f1202i = obtainStyledAttributes.getColor(index, this.f1202i);
                } else if (index == 5) {
                    this.f1198e = obtainStyledAttributes.getBoolean(index, this.f1198e);
                }
            }
        }
        if (this.f1199f == null) {
            try {
                this.f1199f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        int i5 = this.f1201h;
        Paint paint = this.f1194a;
        paint.setColor(i5);
        paint.setAntiAlias(true);
        int i6 = this.f1202i;
        Paint paint2 = this.f1195b;
        paint2.setColor(i6);
        paint2.setAntiAlias(true);
        this.f1196c.setColor(this.f1203j);
        this.f1204k = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f1204k);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1197d) {
            width--;
            height--;
            float f4 = width;
            float f5 = height;
            canvas.drawLine(0.0f, 0.0f, f4, f5, this.f1194a);
            canvas.drawLine(0.0f, f5, f4, 0.0f, this.f1194a);
            canvas.drawLine(0.0f, 0.0f, f4, 0.0f, this.f1194a);
            canvas.drawLine(f4, 0.0f, f4, f5, this.f1194a);
            canvas.drawLine(f4, f5, 0.0f, f5, this.f1194a);
            canvas.drawLine(0.0f, f5, 0.0f, 0.0f, this.f1194a);
        }
        String str = this.f1199f;
        if (str == null || !this.f1198e) {
            return;
        }
        int length = str.length();
        Paint paint = this.f1195b;
        Rect rect = this.f1200g;
        paint.getTextBounds(str, 0, length, rect);
        float width2 = (width - rect.width()) / 2.0f;
        float height2 = ((height - rect.height()) / 2.0f) + rect.height();
        rect.offset((int) width2, (int) height2);
        int i4 = rect.left;
        int i5 = this.f1204k;
        rect.set(i4 - i5, rect.top - i5, rect.right + i5, rect.bottom + i5);
        canvas.drawRect(rect, this.f1196c);
        canvas.drawText(this.f1199f, width2, height2, paint);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1194a = new Paint();
        this.f1195b = new Paint();
        this.f1196c = new Paint();
        this.f1197d = true;
        this.f1198e = true;
        this.f1199f = null;
        this.f1200g = new Rect();
        this.f1201h = Color.argb(255, 0, 0, 0);
        this.f1202i = Color.argb(255, 200, 200, 200);
        this.f1203j = Color.argb(255, 50, 50, 50);
        this.f1204k = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1194a = new Paint();
        this.f1195b = new Paint();
        this.f1196c = new Paint();
        this.f1197d = true;
        this.f1198e = true;
        this.f1199f = null;
        this.f1200g = new Rect();
        this.f1201h = Color.argb(255, 0, 0, 0);
        this.f1202i = Color.argb(255, 200, 200, 200);
        this.f1203j = Color.argb(255, 50, 50, 50);
        this.f1204k = 4;
        a(context, attributeSet);
    }
}