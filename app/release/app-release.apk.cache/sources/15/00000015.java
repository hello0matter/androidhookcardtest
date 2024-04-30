package a0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class t {
    public static d a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i4) {
        d dVar;
        if (d(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i4, typedValue);
            int i5 = typedValue.type;
            if (i5 >= 28 && i5 <= 31) {
                return new d(null, null, typedValue.data);
            }
            try {
                dVar = d.a(typedArray.getResources(), typedArray.getResourceId(i4, 0), theme);
            } catch (Exception e4) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e4);
                dVar = null;
            }
            if (dVar != null) {
                return dVar;
            }
        }
        return new d(null, null, 0);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i4, int i5) {
        if (!d(xmlPullParser, str)) {
            return i5;
        }
        return typedArray.getInt(i4, i5);
    }

    public static String c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i4) {
        if (!d(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i4);
    }

    public static boolean d(XmlPullParser xmlPullParser, String str) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            return true;
        }
        return false;
    }

    public static TypedArray e(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}