package o;

import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f5827b;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f5828a = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f5827b = hashMap;
        try {
            hashMap.put("KeyAttribute", b.class.getConstructor(new Class[0]));
            hashMap.put("KeyPosition", l.class.getConstructor(new Class[0]));
            hashMap.put("KeyCycle", c.class.getConstructor(new Class[0]));
            hashMap.put("KeyTimeCycle", m.class.getConstructor(new Class[0]));
            hashMap.put("KeyTrigger", n.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e4) {
            Log.e("KeyFrames", "unable to load", e4);
        }
    }

    public k(XmlResourceParser xmlResourceParser) {
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlResourceParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlResourceParser.getName();
                    HashMap hashMap = f5827b;
                    if (!hashMap.containsKey(name)) {
                        name.equalsIgnoreCase("CustomAttribute");
                        continue;
                    } else {
                        try {
                            androidx.activity.j.f(((Constructor) hashMap.get(name)).newInstance(new Object[0]));
                            Xml.asAttributeSet(xmlResourceParser);
                            throw null;
                            break;
                        } catch (Exception e4) {
                            Log.e("KeyFrames", "unable to create ", e4);
                            continue;
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e6) {
            e6.printStackTrace();
        }
    }

    public final void a(p pVar) {
        HashMap hashMap = this.f5828a;
        ArrayList arrayList = (ArrayList) hashMap.get(Integer.valueOf(pVar.f5847b));
        if (arrayList != null) {
            pVar.f5866u.addAll(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                androidx.activity.j.f(it.next());
                String str = ((ConstraintLayout.LayoutParams) pVar.f5846a.getLayoutParams()).U;
                throw null;
            }
        }
    }
}