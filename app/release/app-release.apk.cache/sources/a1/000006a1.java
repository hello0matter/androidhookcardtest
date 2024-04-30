package f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.q3;
import g.s;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class l extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f4493e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class[] f4494f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f4495a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f4496b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4497c;

    /* renamed from: d  reason: collision with root package name */
    public Object f4498d;

    static {
        Class[] clsArr = {Context.class};
        f4493e = clsArr;
        f4494f = clsArr;
    }

    public l(Context context) {
        super(context);
        this.f4497c = context;
        Object[] objArr = {context};
        this.f4495a = objArr;
        this.f4496b = objArr;
    }

    public static Object a(Context context) {
        if (context instanceof Activity) {
            return context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v61 */
    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        ?? r4;
        int i4;
        boolean z4;
        char charAt;
        char charAt2;
        int i5;
        boolean z5;
        i0.e eVar;
        ColorStateList colorStateList;
        k kVar = new k(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            r4 = 1;
            i4 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlResourceParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z6 = false;
        boolean z7 = false;
        String str = null;
        while (!z6) {
            if (eventType != r4) {
                if (eventType != i4) {
                    if (eventType == 3) {
                        String name2 = xmlResourceParser.getName();
                        if (z7 && name2.equals(str)) {
                            z4 = r4;
                            z7 = false;
                            str = null;
                            eventType = xmlResourceParser.next();
                            r4 = z4;
                            i4 = 2;
                        } else if (name2.equals("group")) {
                            kVar.f4468b = 0;
                            kVar.f4469c = 0;
                            kVar.f4470d = 0;
                            kVar.f4471e = 0;
                            kVar.f4472f = r4;
                            kVar.f4473g = r4;
                        } else if (name2.equals("item")) {
                            if (!kVar.f4474h) {
                                i0.e eVar2 = kVar.f4492z;
                                if (eVar2 != null && ((s) eVar2).f4748b.hasSubMenu()) {
                                    kVar.f4474h = r4;
                                    kVar.b(kVar.f4467a.addSubMenu(kVar.f4468b, kVar.f4475i, kVar.f4476j, kVar.f4477k).getItem());
                                } else {
                                    kVar.f4474h = r4;
                                    kVar.b(kVar.f4467a.add(kVar.f4468b, kVar.f4475i, kVar.f4476j, kVar.f4477k));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z4 = r4;
                            z6 = z4;
                        }
                    }
                    z4 = r4;
                } else {
                    if (!z7) {
                        String name3 = xmlResourceParser.getName();
                        boolean equals = name3.equals("group");
                        l lVar = kVar.E;
                        if (equals) {
                            TypedArray obtainStyledAttributes = lVar.f4497c.obtainStyledAttributes(attributeSet, c.a.f2560r);
                            kVar.f4468b = obtainStyledAttributes.getResourceId(r4, 0);
                            kVar.f4469c = obtainStyledAttributes.getInt(3, 0);
                            kVar.f4470d = obtainStyledAttributes.getInt(4, 0);
                            kVar.f4471e = obtainStyledAttributes.getInt(5, 0);
                            kVar.f4472f = obtainStyledAttributes.getBoolean(2, r4);
                            kVar.f4473g = obtainStyledAttributes.getBoolean(0, r4);
                            obtainStyledAttributes.recycle();
                        } else {
                            if (name3.equals("item")) {
                                q3 e4 = q3.e(lVar.f4497c, attributeSet, c.a.f2561s);
                                TypedArray typedArray = e4.f879b;
                                kVar.f4475i = typedArray.getResourceId(2, 0);
                                kVar.f4476j = (typedArray.getInt(5, kVar.f4469c) & (-65536)) | (typedArray.getInt(6, kVar.f4470d) & 65535);
                                kVar.f4477k = typedArray.getText(7);
                                kVar.f4478l = typedArray.getText(8);
                                kVar.f4479m = typedArray.getResourceId(0, 0);
                                String string = typedArray.getString(9);
                                if (string == null) {
                                    charAt = 0;
                                } else {
                                    charAt = string.charAt(0);
                                }
                                kVar.f4480n = charAt;
                                kVar.f4481o = typedArray.getInt(16, 4096);
                                String string2 = typedArray.getString(10);
                                if (string2 == null) {
                                    charAt2 = 0;
                                } else {
                                    charAt2 = string2.charAt(0);
                                }
                                kVar.f4482p = charAt2;
                                kVar.f4483q = typedArray.getInt(20, 4096);
                                if (typedArray.hasValue(11)) {
                                    i5 = typedArray.getBoolean(11, false);
                                } else {
                                    i5 = kVar.f4471e;
                                }
                                kVar.f4484r = i5;
                                kVar.f4485s = typedArray.getBoolean(3, false);
                                kVar.f4486t = typedArray.getBoolean(4, kVar.f4472f);
                                kVar.f4487u = typedArray.getBoolean(1, kVar.f4473g);
                                kVar.f4488v = typedArray.getInt(21, -1);
                                kVar.f4491y = typedArray.getString(12);
                                kVar.f4489w = typedArray.getResourceId(13, 0);
                                kVar.f4490x = typedArray.getString(15);
                                String string3 = typedArray.getString(14);
                                if (string3 != null) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5 && kVar.f4489w == 0 && kVar.f4490x == null) {
                                    eVar = (i0.e) kVar.a(string3, f4494f, lVar.f4496b);
                                } else {
                                    if (z5) {
                                        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                    }
                                    eVar = null;
                                }
                                kVar.f4492z = eVar;
                                kVar.A = typedArray.getText(17);
                                kVar.B = typedArray.getText(22);
                                if (typedArray.hasValue(19)) {
                                    kVar.D = o1.c(typedArray.getInt(19, -1), kVar.D);
                                    colorStateList = null;
                                } else {
                                    colorStateList = null;
                                    kVar.D = null;
                                }
                                if (typedArray.hasValue(18)) {
                                    kVar.C = e4.a(18);
                                } else {
                                    kVar.C = colorStateList;
                                }
                                e4.g();
                                kVar.f4474h = false;
                                z4 = true;
                            } else if (name3.equals("menu")) {
                                z4 = true;
                                kVar.f4474h = true;
                                SubMenu addSubMenu = kVar.f4467a.addSubMenu(kVar.f4468b, kVar.f4475i, kVar.f4476j, kVar.f4477k);
                                kVar.b(addSubMenu.getItem());
                                b(xmlResourceParser, attributeSet, addSubMenu);
                            } else {
                                z4 = true;
                                str = name3;
                                z7 = true;
                            }
                            eventType = xmlResourceParser.next();
                            r4 = z4;
                            i4 = 2;
                        }
                    }
                    z4 = r4;
                }
                eventType = xmlResourceParser.next();
                r4 = z4;
                i4 = 2;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i4, Menu menu) {
        if (!(menu instanceof d0.a)) {
            super.inflate(i4, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f4497c.getResources().getLayout(i4);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (XmlPullParserException e4) {
                    throw new InflateException("Error inflating menu XML", e4);
                }
            } catch (IOException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}