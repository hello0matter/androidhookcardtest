package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class m extends v {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i4, LayoutInflater layoutInflater, RecyclerView recyclerView) {
        super(layoutInflater.inflate(R.layout.design_navigation_item_separator, (ViewGroup) recyclerView, false));
        if (i4 != 2) {
        } else {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, (ViewGroup) recyclerView, false));
        }
    }
}