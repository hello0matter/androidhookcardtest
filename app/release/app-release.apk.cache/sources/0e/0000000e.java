package a0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f27a;

    /* renamed from: b  reason: collision with root package name */
    public final Configuration f28b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29c;

    public m(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        int hashCode;
        this.f27a = colorStateList;
        this.f28b = configuration;
        if (theme == null) {
            hashCode = 0;
        } else {
            hashCode = theme.hashCode();
        }
        this.f29c = hashCode;
    }
}