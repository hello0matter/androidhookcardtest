package g;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.o0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r implements d0.b {
    public i0.e A;
    public MenuItem.OnActionExpandListener B;

    /* renamed from: a  reason: collision with root package name */
    public final int f4722a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4723b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4724c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4725d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f4726e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f4727f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f4728g;

    /* renamed from: h  reason: collision with root package name */
    public char f4729h;

    /* renamed from: j  reason: collision with root package name */
    public char f4731j;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f4733l;

    /* renamed from: n  reason: collision with root package name */
    public final p f4735n;

    /* renamed from: o  reason: collision with root package name */
    public j0 f4736o;

    /* renamed from: p  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f4737p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f4738q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f4739r;

    /* renamed from: y  reason: collision with root package name */
    public int f4746y;

    /* renamed from: z  reason: collision with root package name */
    public View f4747z;

    /* renamed from: i  reason: collision with root package name */
    public int f4730i = 4096;

    /* renamed from: k  reason: collision with root package name */
    public int f4732k = 4096;

    /* renamed from: m  reason: collision with root package name */
    public int f4734m = 0;

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f4740s = null;

    /* renamed from: t  reason: collision with root package name */
    public PorterDuff.Mode f4741t = null;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4742u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4743v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4744w = false;

    /* renamed from: x  reason: collision with root package name */
    public int f4745x = 16;
    public boolean C = false;

    public r(p pVar, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        this.f4735n = pVar;
        this.f4722a = i5;
        this.f4723b = i4;
        this.f4724c = i6;
        this.f4725d = i7;
        this.f4726e = charSequence;
        this.f4746y = i8;
    }

    public static void c(StringBuilder sb, int i4, int i5, String str) {
        if ((i4 & i5) == i5) {
            sb.append(str);
        }
    }

    @Override // d0.b
    public final d0.b a(i0.e eVar) {
        i0.e eVar2 = this.A;
        if (eVar2 != null) {
            eVar2.getClass();
            eVar2.f4919a = null;
        }
        this.f4747z = null;
        this.A = eVar;
        this.f4735n.p(true);
        i0.e eVar3 = this.A;
        if (eVar3 != null) {
            eVar3.d(new o0(3, this));
        }
        return this;
    }

    @Override // d0.b
    public final i0.e b() {
        return this.A;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f4746y & 8) == 0) {
            return false;
        }
        if (this.f4747z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f4735n.d(this);
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f4744w && (this.f4742u || this.f4743v)) {
            drawable = drawable.mutate();
            if (this.f4742u) {
                c0.b.h(drawable, this.f4740s);
            }
            if (this.f4743v) {
                c0.b.i(drawable, this.f4741t);
            }
            this.f4744w = false;
        }
        return drawable;
    }

    public final boolean e() {
        i0.e eVar;
        if ((this.f4746y & 8) == 0) {
            return false;
        }
        if (this.f4747z == null && (eVar = this.A) != null) {
            this.f4747z = eVar.b(this);
        }
        if (this.f4747z == null) {
            return false;
        }
        return true;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.f4735n.f(this);
    }

    public final boolean f() {
        if ((this.f4745x & 32) == 32) {
            return true;
        }
        return false;
    }

    public final void g(boolean z4) {
        int i4;
        int i5 = this.f4745x & (-5);
        if (z4) {
            i4 = 4;
        } else {
            i4 = 0;
        }
        this.f4745x = i4 | i5;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f4747z;
        if (view != null) {
            return view;
        }
        i0.e eVar = this.A;
        if (eVar != null) {
            View b5 = eVar.b(this);
            this.f4747z = b5;
            return b5;
        }
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f4732k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f4731j;
    }

    @Override // d0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f4738q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f4723b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f4733l;
        if (drawable != null) {
            return d(drawable);
        }
        int i4 = this.f4734m;
        if (i4 != 0) {
            Drawable t02 = com.google.common.collect.c.t0(this.f4735n.f4695a, i4);
            this.f4734m = 0;
            this.f4733l = t02;
            return d(t02);
        }
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f4740s;
    }

    @Override // d0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f4741t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f4728g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f4722a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f4730i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f4729h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f4724c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f4736o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f4726e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4727f;
        if (charSequence == null) {
            return this.f4726e;
        }
        return charSequence;
    }

    @Override // d0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f4739r;
    }

    public final void h(boolean z4) {
        int i4;
        if (z4) {
            i4 = this.f4745x | 32;
        } else {
            i4 = this.f4745x & (-33);
        }
        this.f4745x = i4;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        if (this.f4736o != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f4745x & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f4745x & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f4745x & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        i0.e eVar = this.A;
        if (eVar != null && eVar.c()) {
            if ((this.f4745x & 8) != 0 || !this.A.a()) {
                return false;
            }
            return true;
        } else if ((this.f4745x & 8) != 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        int i5;
        Context context = this.f4735n.f4695a;
        View inflate = LayoutInflater.from(context).inflate(i4, (ViewGroup) new LinearLayout(context), false);
        this.f4747z = inflate;
        this.A = null;
        if (inflate != null && inflate.getId() == -1 && (i5 = this.f4722a) > 0) {
            inflate.setId(i5);
        }
        p pVar = this.f4735n;
        pVar.f4705k = true;
        pVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        if (this.f4731j == c4) {
            return this;
        }
        this.f4731j = Character.toLowerCase(c4);
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        int i4 = this.f4745x;
        int i5 = (z4 ? 1 : 0) | (i4 & (-2));
        this.f4745x = i5;
        if (i4 != i5) {
            this.f4735n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        boolean z5;
        int i4;
        int i5 = this.f4745x;
        int i6 = 2;
        if ((i5 & 4) != 0) {
            p pVar = this.f4735n;
            pVar.getClass();
            ArrayList arrayList = pVar.f4700f;
            int size = arrayList.size();
            pVar.y();
            for (int i7 = 0; i7 < size; i7++) {
                r rVar = (r) arrayList.get(i7);
                if (rVar.f4723b == this.f4723b && (rVar.f4745x & 4) != 0 && rVar.isCheckable()) {
                    if (rVar == this) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    int i8 = rVar.f4745x;
                    int i9 = i8 & (-3);
                    if (z5) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i10 = i4 | i9;
                    rVar.f4745x = i10;
                    if (i8 != i10) {
                        rVar.f4735n.p(false);
                    }
                }
            }
            pVar.x();
        } else {
            int i11 = i5 & (-3);
            if (!z4) {
                i6 = 0;
            }
            int i12 = i11 | i6;
            this.f4745x = i12;
            if (i5 != i12) {
                this.f4735n.p(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        int i4;
        if (z4) {
            i4 = this.f4745x | 16;
        } else {
            i4 = this.f4745x & (-17);
        }
        this.f4745x = i4;
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f4733l = null;
        this.f4734m = i4;
        this.f4744w = true;
        this.f4735n.p(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4740s = colorStateList;
        this.f4742u = true;
        this.f4744w = true;
        this.f4735n.p(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4741t = mode;
        this.f4743v = true;
        this.f4744w = true;
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f4728g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        if (this.f4729h == c4) {
            return this;
        }
        this.f4729h = c4;
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4737p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f4729h = c4;
        this.f4731j = Character.toLowerCase(c5);
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f4746y = i4;
        p pVar = this.f4735n;
        pVar.f4705k = true;
        pVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        setTitle(this.f4735n.f4695a.getString(i4));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4727f = charSequence;
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i4;
        int i5 = this.f4745x;
        int i6 = i5 & (-9);
        if (z4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        int i7 = i4 | i6;
        this.f4745x = i7;
        if (i5 != i7) {
            p pVar = this.f4735n;
            pVar.f4702h = true;
            pVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f4726e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        if (this.f4731j == c4 && this.f4732k == i4) {
            return this;
        }
        this.f4731j = Character.toLowerCase(c4);
        this.f4732k = KeyEvent.normalizeMetaState(i4);
        this.f4735n.p(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final d0.b setContentDescription(CharSequence charSequence) {
        this.f4738q = charSequence;
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f4734m = 0;
        this.f4733l = drawable;
        this.f4744w = true;
        this.f4735n.p(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        if (this.f4729h == c4 && this.f4730i == i4) {
            return this;
        }
        this.f4729h = c4;
        this.f4730i = KeyEvent.normalizeMetaState(i4);
        this.f4735n.p(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f4729h = c4;
        this.f4730i = KeyEvent.normalizeMetaState(i4);
        this.f4731j = Character.toLowerCase(c5);
        this.f4732k = KeyEvent.normalizeMetaState(i5);
        this.f4735n.p(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final d0.b setTooltipText(CharSequence charSequence) {
        this.f4739r = charSequence;
        this.f4735n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f4726e = charSequence;
        this.f4735n.p(false);
        j0 j0Var = this.f4736o;
        if (j0Var != null) {
            j0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i4;
        this.f4747z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i4 = this.f4722a) > 0) {
            view.setId(i4);
        }
        p pVar = this.f4735n;
        pVar.f4705k = true;
        pVar.p(true);
        return this;
    }
}