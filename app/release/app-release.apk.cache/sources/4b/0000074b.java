package i0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h implements g, i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4932a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ClipData f4933b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4934c;

    /* renamed from: d  reason: collision with root package name */
    public int f4935d;

    /* renamed from: e  reason: collision with root package name */
    public Uri f4936e;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f4937f;

    public h(ClipData clipData, int i4) {
        this.f4933b = clipData;
        this.f4934c = i4;
    }

    @Override // i0.g
    public final j a() {
        return new j(new h(this));
    }

    @Override // i0.g
    public final void b(Bundle bundle) {
        this.f4937f = bundle;
    }

    @Override // i0.g
    public final void c(Uri uri) {
        this.f4936e = uri;
    }

    @Override // i0.i
    public final ClipData d() {
        return this.f4933b;
    }

    @Override // i0.g
    public final void e(int i4) {
        this.f4935d = i4;
    }

    @Override // i0.i
    public final int g() {
        return this.f4935d;
    }

    @Override // i0.i
    public final ContentInfo j() {
        return null;
    }

    @Override // i0.i
    public final int q() {
        return this.f4934c;
    }

    public final String toString() {
        String str;
        String valueOf;
        String str2;
        switch (this.f4932a) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f4933b.getDescription());
                sb.append(", source=");
                int i4 = this.f4934c;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 != 4) {
                                    if (i4 != 5) {
                                        str = String.valueOf(i4);
                                    } else {
                                        str = "SOURCE_PROCESS_TEXT";
                                    }
                                } else {
                                    str = "SOURCE_AUTOFILL";
                                }
                            } else {
                                str = "SOURCE_DRAG_AND_DROP";
                            }
                        } else {
                            str = "SOURCE_INPUT_METHOD";
                        }
                    } else {
                        str = "SOURCE_CLIPBOARD";
                    }
                } else {
                    str = "SOURCE_APP";
                }
                sb.append(str);
                sb.append(", flags=");
                int i5 = this.f4935d;
                if ((i5 & 1) != 0) {
                    valueOf = "FLAG_CONVERT_TO_PLAIN_TEXT";
                } else {
                    valueOf = String.valueOf(i5);
                }
                sb.append(valueOf);
                String str3 = "";
                if (this.f4936e == null) {
                    str2 = "";
                } else {
                    str2 = ", hasLinkUri(" + this.f4936e.toString().length() + ")";
                }
                sb.append(str2);
                if (this.f4937f != null) {
                    str3 = ", hasExtras";
                }
                return androidx.activity.j.e(sb, str3, "}");
            default:
                return super.toString();
        }
    }

    public h(h hVar) {
        ClipData clipData = hVar.f4933b;
        clipData.getClass();
        this.f4933b = clipData;
        int i4 = hVar.f4934c;
        if (i4 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        } else if (i4 > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        } else {
            this.f4934c = i4;
            int i5 = hVar.f4935d;
            if ((i5 & 1) == i5) {
                this.f4935d = i5;
                this.f4936e = hVar.f4936e;
                this.f4937f = hVar.f4937f;
                return;
            }
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i5) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}