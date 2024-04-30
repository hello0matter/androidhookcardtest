package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ActionBar$LayoutParams extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public int f177a;

    public ActionBar$LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f177a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f2544b);
        this.f177a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public ActionBar$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f177a = 0;
    }

    public ActionBar$LayoutParams(ActionBar$LayoutParams actionBar$LayoutParams) {
        super((ViewGroup.MarginLayoutParams) actionBar$LayoutParams);
        this.f177a = 0;
        this.f177a = actionBar$LayoutParams.f177a;
    }
}