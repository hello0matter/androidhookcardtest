package a0;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Shader f13a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f14b;

    /* renamed from: c  reason: collision with root package name */
    public int f15c;

    public d(Shader shader, ColorStateList colorStateList, int i4) {
        this.f13a = shader;
        this.f14b = colorStateList;
        this.f15c = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c8, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a0.d a(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.d.a(android.content.res.Resources, int, android.content.res.Resources$Theme):a0.d");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        if (this.f13a == null && (colorStateList = this.f14b) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }
}