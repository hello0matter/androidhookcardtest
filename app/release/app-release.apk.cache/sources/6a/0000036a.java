package androidx.viewpager2.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class o extends RecyclerView {

    /* renamed from: w0  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f2484w0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(ViewPager2 viewPager2, Context context) {
        super(context);
        this.f2484w0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        this.f2484w0.f2452t.getClass();
        return super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.f2484w0;
        accessibilityEvent.setFromIndex(viewPager2.f2436d);
        accessibilityEvent.setToIndex(viewPager2.f2436d);
        viewPager2.f2452t.j(accessibilityEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f2484w0.f2450r && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2484w0.f2450r && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }
}