package h1;

import android.content.Context;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.Toast;
import com.example.msphone.FloatingWindowService;

/* loaded from: classes.dex */
public final class a implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FloatingWindowService f4800a;

    public a(FloatingWindowService floatingWindowService) {
        this.f4800a = floatingWindowService;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i4, boolean z4) {
        float f4 = ((i4 * 1.7f) / 170.0f) + 0.3f;
        Context context = seekBar.getContext();
        Toast.makeText(context, "设置播放速度为" + f4 + "倍", 1).show();
        Intent intent = new Intent("com.example.CHANGE_PLAYBACK_SPEED");
        intent.putExtra("playback_speed", f4);
        this.f4800a.sendBroadcast(intent);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}