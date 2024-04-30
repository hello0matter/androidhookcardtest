package i0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

/* loaded from: classes.dex */
public final class f implements g {

    /* renamed from: a  reason: collision with root package name */
    public final ContentInfo.Builder f4928a;

    public f(ClipData clipData, int i4) {
        this.f4928a = f2.h.e(clipData, i4);
    }

    @Override // i0.g
    public final j a() {
        ContentInfo build;
        build = this.f4928a.build();
        return new j(new androidx.appcompat.app.o0(build));
    }

    @Override // i0.g
    public final void b(Bundle bundle) {
        this.f4928a.setExtras(bundle);
    }

    @Override // i0.g
    public final void c(Uri uri) {
        this.f4928a.setLinkUri(uri);
    }

    @Override // i0.g
    public final void e(int i4) {
        this.f4928a.setFlags(i4);
    }
}