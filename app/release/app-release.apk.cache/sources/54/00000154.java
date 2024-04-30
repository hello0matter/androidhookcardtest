package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class l extends AppCompatImageView implements o {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f808d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f808d = nVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        com.google.common.collect.c.V1(this, getContentDescription());
        setOnTouchListener(new k(this, this, nVar, 0));
    }

    @Override // androidx.appcompat.widget.o
    public final boolean a() {
        return false;
    }

    @Override // androidx.appcompat.widget.o
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f808d.o();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i4, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i4, i5, i6, i7);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            c0.b.f(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}