package l0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    public final InputContentInfo f5262a;

    public g(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f5262a = new InputContentInfo(uri, clipDescription, uri2);
    }

    @Override // l0.h
    public final void a() {
        this.f5262a.requestPermission();
    }

    @Override // l0.h
    public final Uri b() {
        return this.f5262a.getLinkUri();
    }

    @Override // l0.h
    public final ClipDescription f() {
        return this.f5262a.getDescription();
    }

    @Override // l0.h
    public final Object i() {
        return this.f5262a;
    }

    @Override // l0.h
    public final Uri j() {
        return this.f5262a.getContentUri();
    }

    public g(Object obj) {
        this.f5262a = (InputContentInfo) obj;
    }
}