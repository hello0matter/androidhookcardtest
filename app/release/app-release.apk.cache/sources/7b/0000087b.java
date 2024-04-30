package m0;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import androidx.emoji2.text.z;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5432a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5433b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(new Handler());
        this.f5433b = bVar;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        switch (this.f5432a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        Cursor cursor;
        switch (this.f5432a) {
            case 0:
                b bVar = (b) this.f5433b;
                if (!bVar.f5435b || (cursor = bVar.f5436c) == null || cursor.isClosed()) {
                    return;
                }
                bVar.f5434a = bVar.f5436c.requery();
                return;
            default:
                super.onChange(z4);
                return;
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4, Uri uri) {
        switch (this.f5432a) {
            case 1:
                ((z) this.f5433b).b();
                return;
            default:
                super.onChange(z4, uri);
                return;
        }
    }
}