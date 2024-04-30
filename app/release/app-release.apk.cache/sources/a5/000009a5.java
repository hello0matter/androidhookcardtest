package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import androidx.appcompat.widget.c0;
import i0.g2;
import i0.r1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public int f6677a;

    /* renamed from: b  reason: collision with root package name */
    public int f6678b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f6679c = -1;

    /* renamed from: d  reason: collision with root package name */
    public Object f6680d = new SparseArray();

    /* renamed from: e  reason: collision with root package name */
    public Object f6681e = new SparseArray();

    /* renamed from: f  reason: collision with root package name */
    public int[] f6682f = null;

    public n(Context context, XmlResourceParser xmlResourceParser) {
        boolean z4;
        this.f6677a = -1;
        l lVar = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6665r);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                this.f6677a = obtainStyledAttributes.getResourceId(index, this.f6677a);
            }
        }
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else if ("StateSet".equals(xmlResourceParser.getName())) {
                            return;
                        }
                    } else {
                        String name = xmlResourceParser.getName();
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 1301459538:
                                if (name.equals("LayoutDescription")) {
                                    z4 = false;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    z4 = true;
                                    break;
                                }
                                z4 = true;
                                break;
                            default:
                                z4 = true;
                                break;
                        }
                        if (z4 && !z4) {
                            if (!z4) {
                                if (!z4) {
                                    Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                } else {
                                    m mVar = new m(context, xmlResourceParser);
                                    if (lVar != null) {
                                        lVar.f6670b.add(mVar);
                                    }
                                }
                            } else {
                                lVar = new l(context, xmlResourceParser);
                                ((SparseArray) this.f6680d).put(lVar.f6669a, lVar);
                            }
                        }
                    }
                } else {
                    xmlResourceParser.getName();
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }

    public final void a(g2 g2Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r1 r1Var = (r1) it.next();
            if ((r1Var.f4973a.c() & 8) != 0) {
                ((View) this.f6681e).setTranslationY(p1.a.c(this.f6679c, r1Var.f4973a.b(), 0));
                return;
            }
        }
    }

    public final void b(c0 c0Var) {
        View view = (View) this.f6681e;
        int[] iArr = this.f6682f;
        view.getLocationOnScreen(iArr);
        int i4 = this.f6678b - iArr[1];
        this.f6679c = i4;
        view.setTranslationY(i4);
    }

    public final int c(int i4) {
        l lVar;
        Object obj;
        int i5;
        Object obj2;
        float f4 = -1;
        int i6 = 0;
        if (-1 == i4) {
            if (i4 == -1) {
                obj2 = ((SparseArray) this.f6680d).valueAt(0);
            } else {
                obj2 = ((SparseArray) this.f6680d).get(this.f6678b);
            }
            lVar = (l) obj2;
            if (lVar == null) {
                return -1;
            }
            int i7 = this.f6679c;
            ArrayList arrayList = lVar.f6670b;
            if (i7 != -1 && ((m) arrayList.get(-1)).a(f4, f4)) {
                return -1;
            }
            while (true) {
                ArrayList arrayList2 = lVar.f6670b;
                if (i6 < arrayList2.size()) {
                    if (((m) arrayList2.get(i6)).a(f4, f4)) {
                        break;
                    }
                    i6++;
                } else {
                    i6 = -1;
                    break;
                }
            }
            if (-1 == i6) {
                return -1;
            }
            if (i6 != -1) {
                obj = arrayList.get(i6);
                i5 = ((m) obj).f6676e;
            }
            i5 = lVar.f6671c;
        } else {
            lVar = (l) ((SparseArray) this.f6680d).get(i4);
            if (lVar == null) {
                return -1;
            }
            while (true) {
                ArrayList arrayList3 = lVar.f6670b;
                if (i6 < arrayList3.size()) {
                    if (((m) arrayList3.get(i6)).a(f4, f4)) {
                        break;
                    }
                    i6++;
                } else {
                    i6 = -1;
                    break;
                }
            }
            if (i6 != -1) {
                obj = lVar.f6670b.get(i6);
                i5 = ((m) obj).f6676e;
            }
            i5 = lVar.f6671c;
        }
        return i5;
    }
}