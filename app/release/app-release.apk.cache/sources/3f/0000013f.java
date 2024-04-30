package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class g3 extends TouchDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final View f751a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f752b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f753c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f754d;

    /* renamed from: e  reason: collision with root package name */
    public final int f755e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f756f;

    public g3(Rect rect, Rect rect2, SearchView.SearchAutoComplete searchAutoComplete) {
        super(rect, searchAutoComplete);
        int scaledTouchSlop = ViewConfiguration.get(searchAutoComplete.getContext()).getScaledTouchSlop();
        this.f755e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f752b = rect3;
        Rect rect4 = new Rect();
        this.f754d = rect4;
        Rect rect5 = new Rect();
        this.f753c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i4 = -scaledTouchSlop;
        rect4.inset(i4, i4);
        rect5.set(rect2);
        this.f751a = searchAutoComplete;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        float f4;
        int i4;
        boolean z5;
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z6 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z5 = this.f756f;
                if (z5 && !this.f754d.contains(x4, y4)) {
                    z6 = z5;
                    z4 = false;
                }
            } else {
                if (action == 3) {
                    z5 = this.f756f;
                    this.f756f = false;
                }
                z4 = true;
                z6 = false;
            }
            z6 = z5;
            z4 = true;
        } else {
            if (this.f752b.contains(x4, y4)) {
                this.f756f = true;
                z4 = true;
            }
            z4 = true;
            z6 = false;
        }
        if (z6) {
            Rect rect = this.f753c;
            View view = this.f751a;
            if (!z4 || rect.contains(x4, y4)) {
                f4 = x4 - rect.left;
                i4 = y4 - rect.top;
            } else {
                f4 = view.getWidth() / 2;
                i4 = view.getHeight() / 2;
            }
            motionEvent.setLocation(f4, i4);
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}