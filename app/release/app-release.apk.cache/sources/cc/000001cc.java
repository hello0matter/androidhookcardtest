package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public CoordinatorLayout.Behavior f1347a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1348b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1349c;

    /* renamed from: d  reason: collision with root package name */
    public int f1350d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1351e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1352f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1353g;

    /* renamed from: h  reason: collision with root package name */
    public int f1354h;

    /* renamed from: i  reason: collision with root package name */
    public int f1355i;

    /* renamed from: j  reason: collision with root package name */
    public int f1356j;

    /* renamed from: k  reason: collision with root package name */
    public View f1357k;

    /* renamed from: l  reason: collision with root package name */
    public View f1358l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1359m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1360n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1361o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1362p;

    /* renamed from: q  reason: collision with root package name */
    public final Rect f1363q;

    public b() {
        super(-2, -2);
        this.f1348b = false;
        this.f1349c = 0;
        this.f1350d = 0;
        this.f1351e = -1;
        this.f1352f = -1;
        this.f1353g = 0;
        this.f1354h = 0;
        this.f1363q = new Rect();
    }

    public final boolean a(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return false;
            }
            return this.f1361o;
        }
        return this.f1360n;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CoordinatorLayout.Behavior behavior;
        this.f1348b = false;
        this.f1349c = 0;
        this.f1350d = 0;
        this.f1351e = -1;
        this.f1352f = -1;
        this.f1353g = 0;
        this.f1354h = 0;
        this.f1363q = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.a.f6848b);
        this.f1349c = obtainStyledAttributes.getInteger(0, 0);
        this.f1352f = obtainStyledAttributes.getResourceId(1, -1);
        this.f1350d = obtainStyledAttributes.getInteger(2, 0);
        this.f1351e = obtainStyledAttributes.getInteger(6, -1);
        this.f1353g = obtainStyledAttributes.getInt(5, 0);
        this.f1354h = obtainStyledAttributes.getInt(4, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(3);
        this.f1348b = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f1322t;
            if (TextUtils.isEmpty(string)) {
                behavior = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f1322t;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f1324v;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f1323u);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    behavior = (CoordinatorLayout.Behavior) constructor.newInstance(context, attributeSet);
                } catch (Exception e4) {
                    throw new RuntimeException("Could not inflate Behavior subclass " + string, e4);
                }
            }
            this.f1347a = behavior;
        }
        obtainStyledAttributes.recycle();
        CoordinatorLayout.Behavior behavior2 = this.f1347a;
        if (behavior2 != null) {
            behavior2.g(this);
        }
    }

    public b(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f1348b = false;
        this.f1349c = 0;
        this.f1350d = 0;
        this.f1351e = -1;
        this.f1352f = -1;
        this.f1353g = 0;
        this.f1354h = 0;
        this.f1363q = new Rect();
    }

    public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1348b = false;
        this.f1349c = 0;
        this.f1350d = 0;
        this.f1351e = -1;
        this.f1352f = -1;
        this.f1353g = 0;
        this.f1354h = 0;
        this.f1363q = new Rect();
    }

    public b(b bVar) {
        super((ViewGroup.MarginLayoutParams) bVar);
        this.f1348b = false;
        this.f1349c = 0;
        this.f1350d = 0;
        this.f1351e = -1;
        this.f1352f = -1;
        this.f1353g = 0;
        this.f1354h = 0;
        this.f1363q = new Rect();
    }
}