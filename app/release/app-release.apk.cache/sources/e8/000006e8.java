package g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import i0.a1;
import i0.b1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class p implements d0.a {

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f4694y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    public final Context f4695a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f4696b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4697c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4698d;

    /* renamed from: e  reason: collision with root package name */
    public n f4699e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f4700f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f4701g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4702h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f4703i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f4704j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4705k;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence f4707m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f4708n;

    /* renamed from: o  reason: collision with root package name */
    public View f4709o;

    /* renamed from: v  reason: collision with root package name */
    public r f4716v;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4718x;

    /* renamed from: l  reason: collision with root package name */
    public int f4706l = 0;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4710p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4711q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4712r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4713s = false;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList f4714t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    public final CopyOnWriteArrayList f4715u = new CopyOnWriteArrayList();

    /* renamed from: w  reason: collision with root package name */
    public boolean f4717w = false;

    public p(Context context) {
        Resources resources;
        int identifier;
        boolean z4 = false;
        this.f4695a = context;
        Resources resources2 = context.getResources();
        this.f4696b = resources2;
        this.f4700f = new ArrayList();
        this.f4701g = new ArrayList();
        this.f4702h = true;
        this.f4703i = new ArrayList();
        this.f4704j = new ArrayList();
        this.f4705k = true;
        if (resources2.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = b1.f4907a;
            if (Build.VERSION.SDK_INT < 28 ? !((identifier = (resources = context.getResources()).getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android")) == 0 || !resources.getBoolean(identifier)) : a1.b(viewConfiguration)) {
                z4 = true;
            }
        }
        this.f4698d = z4;
    }

    public r a(int i4, int i5, int i6, CharSequence charSequence) {
        int i7;
        int i8 = ((-65536) & i6) >> 16;
        if (i8 >= 0 && i8 < 6) {
            int i9 = (f4694y[i8] << 16) | (65535 & i6);
            r rVar = new r(this, i4, i5, i6, i9, charSequence, this.f4706l);
            ArrayList arrayList = this.f4700f;
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (((r) arrayList.get(size)).f4725d <= i9) {
                        i7 = size + 1;
                        break;
                    }
                    size--;
                } else {
                    i7 = 0;
                    break;
                }
            }
            arrayList.add(i7, rVar);
            p(true);
            return rVar;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return a(0, 0, 0, this.f4696b.getString(i4));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        int i8;
        Intent intent2;
        int i9;
        PackageManager packageManager = this.f4695a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i8 = queryIntentActivityOptions.size();
        } else {
            i8 = 0;
        }
        if ((i7 & 1) == 0) {
            removeGroup(i4);
        }
        for (int i10 = 0; i10 < i8; i10++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            if (i11 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i11];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            r a5 = a(i4, i5, i6, resolveInfo.loadLabel(packageManager));
            a5.setIcon(resolveInfo.loadIcon(packageManager));
            a5.f4728g = intent3;
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = a5;
            }
        }
        return i8;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return addSubMenu(0, 0, 0, this.f4696b.getString(i4));
    }

    public final void b(d0 d0Var, Context context) {
        this.f4715u.add(new WeakReference(d0Var));
        d0Var.l(context, this);
        this.f4705k = true;
    }

    public final void c(boolean z4) {
        if (this.f4713s) {
            return;
        }
        this.f4713s = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            d0 d0Var = (d0) weakReference.get();
            if (d0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                d0Var.a(this, z4);
            }
        }
        this.f4713s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        r rVar = this.f4716v;
        if (rVar != null) {
            d(rVar);
        }
        this.f4700f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f4708n = null;
        this.f4707m = null;
        this.f4709o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(r rVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
        boolean z4 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f4716v == rVar) {
            y();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                d0 d0Var = (d0) weakReference.get();
                if (d0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z4 = d0Var.j(rVar);
                    if (z4) {
                        break;
                    }
                }
            }
            x();
            if (z4) {
                this.f4716v = null;
            }
        }
        return z4;
    }

    public boolean e(p pVar, MenuItem menuItem) {
        n nVar = this.f4699e;
        if (nVar != null && nVar.p(pVar, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean f(r rVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
        boolean z4 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        y();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            d0 d0Var = (d0) weakReference.get();
            if (d0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z4 = d0Var.h(rVar);
                if (z4) {
                    break;
                }
            }
        }
        x();
        if (z4) {
            this.f4716v = rVar;
        }
        return z4;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        MenuItem findItem;
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            r rVar = (r) arrayList.get(i5);
            if (rVar.f4722a == i4) {
                return rVar;
            }
            if (rVar.hasSubMenu() && (findItem = rVar.f4736o.findItem(i4)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final r g(int i4, KeyEvent keyEvent) {
        char c4;
        ArrayList arrayList = this.f4714t;
        arrayList.clear();
        h(arrayList, i4, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (r) arrayList.get(0);
        }
        boolean n4 = n();
        for (int i5 = 0; i5 < size; i5++) {
            r rVar = (r) arrayList.get(i5);
            if (n4) {
                c4 = rVar.f4731j;
            } else {
                c4 = rVar.f4729h;
            }
            char[] cArr = keyData.meta;
            if ((c4 == cArr[0] && (metaState & 2) == 0) || ((c4 == cArr[2] && (metaState & 2) != 0) || (n4 && c4 == '\b' && i4 == 67))) {
                return rVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return (MenuItem) this.f4700f.get(i4);
    }

    public final void h(ArrayList arrayList, int i4, KeyEvent keyEvent) {
        char c4;
        int i5;
        boolean n4 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && i4 != 67) {
            return;
        }
        ArrayList arrayList2 = this.f4700f;
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            r rVar = (r) arrayList2.get(i6);
            if (rVar.hasSubMenu()) {
                rVar.f4736o.h(arrayList, i4, keyEvent);
            }
            if (n4) {
                c4 = rVar.f4731j;
            } else {
                c4 = rVar.f4729h;
            }
            if (n4) {
                i5 = rVar.f4732k;
            } else {
                i5 = rVar.f4730i;
            }
            if ((modifiers & 69647) == (i5 & 69647) && c4 != 0) {
                char[] cArr = keyData.meta;
                if (c4 != cArr[0] && c4 != cArr[2]) {
                    if (n4 && c4 == '\b') {
                        if (i4 != 67) {
                        }
                    }
                }
                if (rVar.isEnabled()) {
                    arrayList.add(rVar);
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f4718x) {
            return true;
        }
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((r) arrayList.get(i4)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList l4 = l();
        if (!this.f4705k) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            d0 d0Var = (d0) weakReference.get();
            if (d0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z4 |= d0Var.e();
            }
        }
        ArrayList arrayList = this.f4703i;
        ArrayList arrayList2 = this.f4704j;
        arrayList.clear();
        arrayList2.clear();
        if (z4) {
            int size = l4.size();
            for (int i4 = 0; i4 < size; i4++) {
                r rVar = (r) l4.get(i4);
                if (rVar.f()) {
                    arrayList.add(rVar);
                } else {
                    arrayList2.add(rVar);
                }
            }
        } else {
            arrayList2.addAll(l());
        }
        this.f4705k = false;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        if (g(i4, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z4 = this.f4702h;
        ArrayList arrayList = this.f4701g;
        if (!z4) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f4700f;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            r rVar = (r) arrayList2.get(i4);
            if (rVar.isVisible()) {
                arrayList.add(rVar);
            }
        }
        this.f4702h = false;
        this.f4705k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f4717w;
    }

    public boolean n() {
        return this.f4697c;
    }

    public boolean o() {
        return this.f4698d;
    }

    public void p(boolean z4) {
        if (!this.f4710p) {
            if (z4) {
                this.f4702h = true;
                this.f4705k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
            if (!copyOnWriteArrayList.isEmpty()) {
                y();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    d0 d0Var = (d0) weakReference.get();
                    if (d0Var == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        d0Var.m(z4);
                    }
                }
                x();
                return;
            }
            return;
        }
        this.f4711q = true;
        if (z4) {
            this.f4712r = true;
        }
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return q(findItem(i4), null, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        boolean z4;
        r g4 = g(i4, keyEvent);
        if (g4 != null) {
            z4 = q(g4, null, i5);
        } else {
            z4 = false;
        }
        if ((i5 & 2) != 0) {
            c(true);
        }
        return z4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
        if (r1 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
        c(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
        if ((r9 & 1) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d5, code lost:
        if (r1 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean q(android.view.MenuItem r7, g.d0 r8, int r9) {
        /*
            r6 = this;
            g.r r7 = (g.r) r7
            r0 = 0
            if (r7 == 0) goto Ld9
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ld9
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f4737p
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L1a
        L18:
            r1 = r2
            goto L45
        L1a:
            g.p r1 = r7.f4735n
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r7.f4728g
            if (r3 == 0) goto L35
            android.content.Context r1 = r1.f4695a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L35:
            i0.e r1 = r7.A
            if (r1 == 0) goto L44
            g.s r1 = (g.s) r1
            android.view.ActionProvider r1 = r1.f4748b
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L44
            goto L18
        L44:
            r1 = r0
        L45:
            i0.e r3 = r7.A
            if (r3 == 0) goto L56
            r4 = r3
            g.s r4 = (g.s) r4
            android.view.ActionProvider r4 = r4.f4748b
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L56
            r4 = r2
            goto L57
        L56:
            r4 = r0
        L57:
            boolean r5 = r7.e()
            if (r5 == 0) goto L69
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld8
        L64:
            r6.c(r2)
            goto Ld8
        L69:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L77
            if (r4 == 0) goto L72
            goto L77
        L72:
            r7 = r9 & 1
            if (r7 != 0) goto Ld8
            goto L64
        L77:
            r9 = r9 & 4
            if (r9 != 0) goto L7e
            r6.c(r0)
        L7e:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L92
            g.j0 r9 = new g.j0
            android.content.Context r5 = r6.f4695a
            r9.<init>(r5, r6, r7)
            r7.f4736o = r9
            java.lang.CharSequence r5 = r7.f4726e
            r9.setHeaderTitle(r5)
        L92:
            g.j0 r7 = r7.f4736o
            if (r4 == 0) goto La2
            g.s r3 = (g.s) r3
            g.x r9 = r3.f4749c
            r9.getClass()
            android.view.ActionProvider r9 = r3.f4748b
            r9.onPrepareSubMenu(r7)
        La2:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f4715u
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto Lab
            goto Ld4
        Lab:
            if (r8 == 0) goto Lb1
            boolean r0 = r8.c(r7)
        Lb1:
            java.util.Iterator r8 = r9.iterator()
        Lb5:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Ld4
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            g.d0 r4 = (g.d0) r4
            if (r4 != 0) goto Lcd
            r9.remove(r3)
            goto Lb5
        Lcd:
            if (r0 != 0) goto Lb5
            boolean r0 = r4.c(r7)
            goto Lb5
        Ld4:
            r1 = r1 | r0
            if (r1 != 0) goto Ld8
            goto L64
        Ld8:
            return r1
        Ld9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.p.q(android.view.MenuItem, g.d0, int):boolean");
    }

    public final void r(d0 d0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            d0 d0Var2 = (d0) weakReference.get();
            if (d0Var2 == null || d0Var2 == d0Var) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 < size) {
                if (((r) arrayList.get(i6)).f4723b == i4) {
                    break;
                }
                i6++;
            } else {
                i6 = -1;
                break;
            }
        }
        if (i6 >= 0) {
            int size2 = arrayList.size() - i6;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= size2 || ((r) arrayList.get(i6)).f4723b != i4) {
                    break;
                }
                if (i6 >= 0) {
                    ArrayList arrayList2 = this.f4700f;
                    if (i6 < arrayList2.size()) {
                        arrayList2.remove(i6);
                    }
                }
                i5 = i7;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                if (((r) arrayList.get(i5)).f4722a == i4) {
                    break;
                }
                i5++;
            } else {
                i5 = -1;
                break;
            }
        }
        if (i5 >= 0) {
            ArrayList arrayList2 = this.f4700f;
            if (i5 < arrayList2.size()) {
                arrayList2.remove(i5);
                p(true);
            }
        }
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f4700f.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((j0) item.getSubMenu()).s(bundle);
            }
        }
        int i5 = bundle.getInt("android:menu:expandedactionview");
        if (i5 > 0 && (findItem = findItem(i5)) != null) {
            findItem.expandActionView();
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z4, boolean z5) {
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            r rVar = (r) arrayList.get(i5);
            if (rVar.f4723b == i4) {
                rVar.g(z5);
                rVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f4717w = z4;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z4) {
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            r rVar = (r) arrayList.get(i5);
            if (rVar.f4723b == i4) {
                rVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z4) {
        int i5;
        ArrayList arrayList = this.f4700f;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            r rVar = (r) arrayList.get(i6);
            if (rVar.f4723b == i4) {
                int i7 = rVar.f4745x;
                int i8 = i7 & (-9);
                if (z4) {
                    i5 = 0;
                } else {
                    i5 = 8;
                }
                int i9 = i8 | i5;
                rVar.f4745x = i9;
                if (i7 != i9) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f4697c = z4;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f4700f.size();
    }

    public final void t(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
            if (!copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    d0 d0Var = (d0) weakReference.get();
                    if (d0Var == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        int id = d0Var.getId();
                        if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                            d0Var.i(parcelable);
                        }
                    }
                }
            }
        }
    }

    public final void u(Bundle bundle) {
        int size = this.f4700f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((j0) item.getSubMenu()).u(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void v(Bundle bundle) {
        Parcelable g4;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4715u;
        if (!copyOnWriteArrayList.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                d0 d0Var = (d0) weakReference.get();
                if (d0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = d0Var.getId();
                    if (id > 0 && (g4 = d0Var.g()) != null) {
                        sparseArray.put(id, g4);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void w(int i4, CharSequence charSequence, int i5, Drawable drawable, View view) {
        Resources resources = this.f4696b;
        if (view != null) {
            this.f4709o = view;
            this.f4707m = null;
            this.f4708n = null;
        } else {
            if (i4 > 0) {
                this.f4707m = resources.getText(i4);
            } else if (charSequence != null) {
                this.f4707m = charSequence;
            }
            if (i5 > 0) {
                Context context = this.f4695a;
                Object obj = z.e.f7215a;
                this.f4708n = z.c.b(context, i5);
            } else if (drawable != null) {
                this.f4708n = drawable;
            }
            this.f4709o = null;
        }
        p(false);
    }

    public final void x() {
        this.f4710p = false;
        if (this.f4711q) {
            this.f4711q = false;
            p(this.f4712r);
        }
    }

    public final void y() {
        if (!this.f4710p) {
            this.f4710p = true;
            this.f4711q = false;
            this.f4712r = false;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return a(i4, i5, i6, this.f4696b.getString(i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return addSubMenu(i4, i5, i6, this.f4696b.getString(i7));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return a(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        r a5 = a(i4, i5, i6, charSequence);
        j0 j0Var = new j0(this.f4695a, this, a5);
        a5.f4736o = j0Var;
        j0Var.setHeaderTitle(a5.f4726e);
        return j0Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public p k() {
        return this;
    }
}