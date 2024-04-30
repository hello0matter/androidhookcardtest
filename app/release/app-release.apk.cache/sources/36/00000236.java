package androidx.emoji2.text;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.app.o0;

/* loaded from: classes.dex */
public final class i extends o0 {

    /* renamed from: e  reason: collision with root package name */
    public volatile v f1518e;

    /* renamed from: f  reason: collision with root package name */
    public volatile d0 f1519f;

    public final void A(EditorInfo editorInfo) {
        int i4;
        Bundle bundle = editorInfo.extras;
        r0.b bVar = this.f1519f.f1507a;
        int a5 = bVar.a(4);
        if (a5 != 0) {
            i4 = bVar.f6452b.getInt(a5 + bVar.f6451a);
        } else {
            i4 = 0;
        }
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i4);
        Bundle bundle2 = editorInfo.extras;
        ((o) this.f311b).getClass();
        bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }

    public final void y() {
        try {
            ((o) this.f311b).f1532f.c(new h(this));
        } catch (Throwable th) {
            ((o) this.f311b).d(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050 A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:7:0x0013, B:10:0x0018, B:12:0x001c, B:14:0x0029, B:21:0x003f, B:23:0x0049, B:25:0x004c, B:27:0x0050, B:29:0x0060, B:30:0x0063, B:32:0x0070, B:35:0x0078, B:40:0x0094, B:47:0x00a2, B:50:0x00ae, B:51:0x00b8, B:52:0x00cc, B:54:0x00d3, B:55:0x00d8, B:57:0x00e3, B:59:0x00ea, B:61:0x00ee, B:63:0x00f4, B:65:0x00f8, B:69:0x0102, B:72:0x010e, B:73:0x0113, B:75:0x0126, B:18:0x0034), top: B:87:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010e A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:7:0x0013, B:10:0x0018, B:12:0x001c, B:14:0x0029, B:21:0x003f, B:23:0x0049, B:25:0x004c, B:27:0x0050, B:29:0x0060, B:30:0x0063, B:32:0x0070, B:35:0x0078, B:40:0x0094, B:47:0x00a2, B:50:0x00ae, B:51:0x00b8, B:52:0x00cc, B:54:0x00d3, B:55:0x00d8, B:57:0x00e3, B:59:0x00ea, B:61:0x00ee, B:63:0x00f4, B:65:0x00f8, B:69:0x0102, B:72:0x010e, B:73:0x0113, B:75:0x0126, B:18:0x0034), top: B:87:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #0 {all -> 0x002f, blocks: (B:7:0x0013, B:10:0x0018, B:12:0x001c, B:14:0x0029, B:21:0x003f, B:23:0x0049, B:25:0x004c, B:27:0x0050, B:29:0x0060, B:30:0x0063, B:32:0x0070, B:35:0x0078, B:40:0x0094, B:47:0x00a2, B:50:0x00ae, B:51:0x00b8, B:52:0x00cc, B:54:0x00d3, B:55:0x00d8, B:57:0x00e3, B:59:0x00ea, B:61:0x00ee, B:63:0x00f4, B:65:0x00f8, B:69:0x0102, B:72:0x010e, B:73:0x0113, B:75:0x0126, B:18:0x0034), top: B:87:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.CharSequence z(java.lang.CharSequence r12, int r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.i.z(java.lang.CharSequence, int, int, boolean):java.lang.CharSequence");
    }
}