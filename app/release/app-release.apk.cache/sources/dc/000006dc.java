package g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public class g0 extends e implements Menu {

    /* renamed from: d  reason: collision with root package name */
    public final d0.a f4625d;

    public g0(Context context, d0.a aVar) {
        super(context);
        if (aVar != null) {
            this.f4625d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return n(((p) this.f4625d).add(i4));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = ((p) this.f4625d).addIntentOptions(i4, i5, i6, componentName, intentArr, intent, i7, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr[i8] = n(menuItemArr2[i8]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return ((p) this.f4625d).addSubMenu(i4);
    }

    @Override // android.view.Menu
    public final void clear() {
        l.k kVar = (l.k) this.f4619b;
        if (kVar != null) {
            kVar.clear();
        }
        l.k kVar2 = (l.k) this.f4620c;
        if (kVar2 != null) {
            kVar2.clear();
        }
        ((p) this.f4625d).clear();
    }

    @Override // android.view.Menu
    public final void close() {
        ((p) this.f4625d).close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        return n(((p) this.f4625d).findItem(i4));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return n(((p) this.f4625d).getItem(i4));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return ((p) this.f4625d).hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return ((p) this.f4625d).isShortcutKey(i4, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return ((p) this.f4625d).performIdentifierAction(i4, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        return ((p) this.f4625d).performShortcut(i4, keyEvent, i5);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        if (((l.k) this.f4619b) != null) {
            int i5 = 0;
            while (true) {
                l.k kVar = (l.k) this.f4619b;
                if (i5 >= kVar.f5252c) {
                    break;
                }
                if (((d0.b) kVar.h(i5)).getGroupId() == i4) {
                    ((l.k) this.f4619b).i(i5);
                    i5--;
                }
                i5++;
            }
        }
        ((p) this.f4625d).removeGroup(i4);
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        if (((l.k) this.f4619b) != null) {
            int i5 = 0;
            while (true) {
                l.k kVar = (l.k) this.f4619b;
                if (i5 >= kVar.f5252c) {
                    break;
                } else if (((d0.b) kVar.h(i5)).getItemId() == i4) {
                    ((l.k) this.f4619b).i(i5);
                    break;
                } else {
                    i5++;
                }
            }
        }
        ((p) this.f4625d).removeItem(i4);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z4, boolean z5) {
        ((p) this.f4625d).setGroupCheckable(i4, z4, z5);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z4) {
        ((p) this.f4625d).setGroupEnabled(i4, z4);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z4) {
        ((p) this.f4625d).setGroupVisible(i4, z4);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f4625d.setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public final int size() {
        return ((p) this.f4625d).size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return n(((p) this.f4625d).add(i4, i5, i6, i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return ((p) this.f4625d).addSubMenu(i4, i5, i6, i7);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return n(((p) this.f4625d).add(i4, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        return this.f4625d.addSubMenu(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return n(((p) this.f4625d).add(charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return ((p) this.f4625d).addSubMenu(charSequence);
    }
}