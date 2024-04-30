package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.msphone.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TimePickerView extends ConstraintLayout {

    /* renamed from: r  reason: collision with root package name */
    public static final /* synthetic */ int f4154r = 0;

    /* renamed from: q  reason: collision with root package name */
    public final Chip f4155q;

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        if (view == this && i4 == 0) {
            this.f4155q.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        h hVar = new h(this);
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(R.id.material_clock_face);
        ((MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle)).f3133c.add(new g(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.f4155q = chip2;
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        j jVar = new j(new GestureDetector(getContext(), new i(this)));
        chip.setOnTouchListener(jVar);
        chip2.setOnTouchListener(jVar);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(hVar);
        chip2.setOnClickListener(hVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }
}