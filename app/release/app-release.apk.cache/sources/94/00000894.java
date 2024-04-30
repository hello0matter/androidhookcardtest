package m3;

import androidx.fragment.app.m0;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Regex;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: j  reason: collision with root package name */
    public static final char[] f5542j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f5543a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5544b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5545c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5546d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5547e;

    /* renamed from: f  reason: collision with root package name */
    public final List f5548f;

    /* renamed from: g  reason: collision with root package name */
    public final String f5549g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5550h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5551i;

    public o(String str, String str2, String str3, String str4, int i4, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        this.f5543a = str;
        this.f5544b = str2;
        this.f5545c = str3;
        this.f5546d = str4;
        this.f5547e = i4;
        this.f5548f = arrayList2;
        this.f5549g = str5;
        this.f5550h = str6;
        this.f5551i = com.google.common.collect.c.n(str, "https");
    }

    public final String a() {
        if (this.f5545c.length() == 0) {
            return "";
        }
        String str = this.f5550h;
        String substring = str.substring(kotlin.text.b.t2(str, ':', this.f5543a.length() + 3, false, 4) + 1, kotlin.text.b.t2(str, '@', 0, false, 6));
        com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String b() {
        String str = this.f5550h;
        int t22 = kotlin.text.b.t2(str, '/', this.f5543a.length() + 3, false, 4);
        String substring = str.substring(t22, n3.b.g(str, "?#", t22, str.length()));
        com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final ArrayList c() {
        String str = this.f5550h;
        int t22 = kotlin.text.b.t2(str, '/', this.f5543a.length() + 3, false, 4);
        int g4 = n3.b.g(str, "?#", t22, str.length());
        ArrayList arrayList = new ArrayList();
        while (t22 < g4) {
            int i4 = t22 + 1;
            int f4 = n3.b.f(str, '/', i4, g4);
            String substring = str.substring(i4, f4);
            com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            t22 = f4;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f5548f == null) {
            return null;
        }
        String str = this.f5550h;
        int t22 = kotlin.text.b.t2(str, '?', 0, false, 6) + 1;
        String substring = str.substring(t22, n3.b.f(str, '#', t22, str.length()));
        com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String e() {
        if (this.f5544b.length() == 0) {
            return "";
        }
        int length = this.f5543a.length() + 3;
        String str = this.f5550h;
        String substring = str.substring(length, n3.b.g(str, ":@", length, str.length()));
        com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof o) && com.google.common.collect.c.n(((o) obj).f5550h, this.f5550h)) {
            return true;
        }
        return false;
    }

    public final String f() {
        n nVar;
        try {
            nVar = new n();
            nVar.c(this, "/...");
        } catch (IllegalArgumentException unused) {
            nVar = null;
        }
        com.google.common.collect.c.C(nVar);
        nVar.f5535b = m0.e("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        nVar.f5536c = m0.e("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        return nVar.a().f5550h;
    }

    public final URI g() {
        int i4;
        ArrayList arrayList;
        String substring;
        String str;
        String str2;
        n nVar = new n();
        String str3 = this.f5543a;
        nVar.f5534a = str3;
        nVar.f5535b = e();
        nVar.f5536c = a();
        nVar.f5537d = this.f5546d;
        com.google.common.collect.c.F(str3, "scheme");
        int i5 = -1;
        if (com.google.common.collect.c.n(str3, "http")) {
            i4 = 80;
        } else if (com.google.common.collect.c.n(str3, "https")) {
            i4 = 443;
        } else {
            i4 = -1;
        }
        int i6 = this.f5547e;
        if (i6 != i4) {
            i5 = i6;
        }
        nVar.f5538e = i5;
        ArrayList arrayList2 = nVar.f5539f;
        arrayList2.clear();
        arrayList2.addAll(c());
        String d4 = d();
        String str4 = null;
        if (d4 != null) {
            arrayList = m0.v(m0.e(d4, 0, 0, " \"'<>#", true, false, true, false, 211));
        } else {
            arrayList = null;
        }
        nVar.f5540g = arrayList;
        if (this.f5549g == null) {
            substring = null;
        } else {
            String str5 = this.f5550h;
            substring = str5.substring(kotlin.text.b.t2(str5, '#', 0, false, 6) + 1);
            com.google.common.collect.c.E(substring, "this as java.lang.String).substring(startIndex)");
        }
        nVar.f5541h = substring;
        String str6 = nVar.f5537d;
        if (str6 != null) {
            str = new Regex("[\"<>^`{|}]").f5200a.matcher(str6).replaceAll("");
            com.google.common.collect.c.E(str, "nativePattern.matcher(in…).replaceAll(replacement)");
        } else {
            str = null;
        }
        nVar.f5537d = str;
        int size = arrayList2.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList2.set(i7, m0.e((String) arrayList2.get(i7), 0, 0, "[]", true, true, false, false, 227));
        }
        ArrayList arrayList3 = nVar.f5540g;
        if (arrayList3 != null) {
            int size2 = arrayList3.size();
            for (int i8 = 0; i8 < size2; i8++) {
                String str7 = (String) arrayList3.get(i8);
                if (str7 != null) {
                    str2 = m0.e(str7, 0, 0, "\\^`{|}", true, true, true, false, 195);
                } else {
                    str2 = null;
                }
                arrayList3.set(i8, str2);
            }
        }
        String str8 = nVar.f5541h;
        if (str8 != null) {
            str4 = m0.e(str8, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 163);
        }
        nVar.f5541h = str4;
        String nVar2 = nVar.toString();
        try {
            return new URI(nVar2);
        } catch (URISyntaxException e4) {
            try {
                String replaceAll = new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").f5200a.matcher(nVar2).replaceAll("");
                com.google.common.collect.c.E(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
                URI create = URI.create(replaceAll);
                com.google.common.collect.c.E(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e4);
            }
        }
    }

    public final int hashCode() {
        return this.f5550h.hashCode();
    }

    public final String toString() {
        return this.f5550h;
    }
}