package a0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class j {
    public static f a(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        int i4;
        boolean z4;
        int i5;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlResourceParser.require(2, null, "font-family");
            if (xmlResourceParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), w.a.f7014b);
                String string = obtainAttributes.getString(0);
                String string2 = obtainAttributes.getString(4);
                String string3 = obtainAttributes.getString(5);
                int resourceId = obtainAttributes.getResourceId(1, 0);
                int integer = obtainAttributes.getInteger(2, 1);
                int integer2 = obtainAttributes.getInteger(3, 500);
                String string4 = obtainAttributes.getString(6);
                obtainAttributes.recycle();
                if (string != null && string2 != null && string3 != null) {
                    while (xmlResourceParser.next() != 3) {
                        c(xmlResourceParser);
                    }
                    return new i(new f0.e(string, string2, string3, b(resources, resourceId)), integer, integer2, string4);
                }
                ArrayList arrayList = new ArrayList();
                while (xmlResourceParser.next() != 3) {
                    if (xmlResourceParser.getEventType() == 2) {
                        if (xmlResourceParser.getName().equals("font")) {
                            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), w.a.f7015c);
                            int i6 = 8;
                            if (!obtainAttributes2.hasValue(8)) {
                                i6 = 1;
                            }
                            int i7 = obtainAttributes2.getInt(i6, 400);
                            if (obtainAttributes2.hasValue(6)) {
                                i4 = 6;
                            } else {
                                i4 = 2;
                            }
                            if (1 == obtainAttributes2.getInt(i4, 0)) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            int i8 = 9;
                            if (!obtainAttributes2.hasValue(9)) {
                                i8 = 3;
                            }
                            int i9 = 7;
                            if (!obtainAttributes2.hasValue(7)) {
                                i9 = 4;
                            }
                            String string5 = obtainAttributes2.getString(i9);
                            int i10 = obtainAttributes2.getInt(i8, 0);
                            if (obtainAttributes2.hasValue(5)) {
                                i5 = 5;
                            } else {
                                i5 = 0;
                            }
                            int resourceId2 = obtainAttributes2.getResourceId(i5, 0);
                            String string6 = obtainAttributes2.getString(i5);
                            obtainAttributes2.recycle();
                            while (xmlResourceParser.next() != 3) {
                                c(xmlResourceParser);
                            }
                            arrayList.add(new h(i7, i10, resourceId2, string6, string5, z4));
                        } else {
                            c(xmlResourceParser);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new g((h[]) arrayList.toArray(new h[0]));
                }
            } else {
                c(xmlResourceParser);
            }
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List b(Resources resources, int i4) {
        if (i4 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i4);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (e.a(obtainTypedArray, 0) == 1) {
                for (int i5 = 0; i5 < obtainTypedArray.length(); i5++) {
                    int resourceId = obtainTypedArray.getResourceId(i5, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i4);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void c(XmlResourceParser xmlResourceParser) {
        int i4 = 1;
        while (i4 > 0) {
            int next = xmlResourceParser.next();
            if (next != 2) {
                if (next == 3) {
                    i4--;
                }
            } else {
                i4++;
            }
        }
    }
}