package com.google.android.exoplayer2.video;

import android.view.Surface;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
@Deprecated
/* loaded from: classes.dex */
public final class PlaceholderSurface extends Surface {
    @Override // android.view.Surface
    public final void release() {
        super.release();
        throw null;
    }
}