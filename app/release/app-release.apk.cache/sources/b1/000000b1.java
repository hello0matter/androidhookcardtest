package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public final int f178a;

    /* renamed from: b  reason: collision with root package name */
    public final int f179b;

    public AlertController$RecycleListView(Context context) {
        this(context, null);
    }

    public void setHasDecor(boolean z4, boolean z5) {
        if (z5 && z4) {
            return;
        }
        setPadding(getPaddingLeft(), z4 ? getPaddingTop() : this.f178a, getPaddingRight(), z5 ? getPaddingBottom() : this.f179b);
    }

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f2564v);
        this.f179b = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f178a = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}