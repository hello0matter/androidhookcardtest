package b0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class m extends n {
    public static Font g(FontFamily fontFamily, int i4) {
        int i5;
        int i6;
        if ((i4 & 1) != 0) {
            i5 = 700;
        } else {
            i5 = 400;
        }
        if ((i4 & 2) != 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        FontStyle fontStyle = new FontStyle(i5, i6);
        Font font = fontFamily.getFont(0);
        int h4 = h(fontStyle, font.getStyle());
        for (int i7 = 1; i7 < fontFamily.getSize(); i7++) {
            Font font2 = fontFamily.getFont(i7);
            int h5 = h(fontStyle, font2.getStyle());
            if (h5 < h4) {
                font = font2;
                h4 = h5;
            }
        }
        return font;
    }

    public static int h(FontStyle fontStyle, FontStyle fontStyle2) {
        int i4;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i4 = 0;
        } else {
            i4 = 2;
        }
        return abs + i4;
    }

    @Override // b0.n
    public final Typeface a(Context context, a0.g gVar, Resources resources, int i4) {
        a0.h[] hVarArr;
        try {
            FontFamily.Builder builder = null;
            for (a0.h hVar : gVar.f16a) {
                try {
                    Font build = new Font.Builder(resources, hVar.f22f).setWeight(hVar.f18b).setSlant(hVar.f19c ? 1 : 0).setTtcIndex(hVar.f21e).setFontVariationSettings(hVar.f20d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(g(build2, i4).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // b0.n
    public final Typeface b(Context context, f0.k[] kVarArr, int i4) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (f0.k kVar : kVarArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(kVar.f4535a, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor == null) {
                    }
                } else {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(kVar.f4537c).setSlant(kVar.f4538d ? 1 : 0).setTtcIndex(kVar.f4536b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(g(build2, i4).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // b0.n
    public final Typeface c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // b0.n
    public final Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        try {
            Font build = new Font.Builder(resources, i4).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // b0.n
    public final f0.k f(int i4, f0.k[] kVarArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}