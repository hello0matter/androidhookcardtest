package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final v.c f3555a = new v.c(2);

    public static ActionMenuView a(Toolbar toolbar) {
        for (int i4 = 0; i4 < toolbar.getChildCount(); i4++) {
            View childAt = toolbar.getChildAt(i4);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public static ImageButton b(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i4 = 0; i4 < toolbar.getChildCount(); i4++) {
            View childAt = toolbar.getChildAt(i4);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static ArrayList c(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < toolbar.getChildCount(); i4++) {
            View childAt = toolbar.getChildAt(i4);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }
}