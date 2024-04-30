package g;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public final class a implements d0.b {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f4579a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f4580b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f4581c;

    /* renamed from: d  reason: collision with root package name */
    public char f4582d;

    /* renamed from: f  reason: collision with root package name */
    public char f4584f;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f4586h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f4587i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f4588j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f4589k;

    /* renamed from: e  reason: collision with root package name */
    public int f4583e = 4096;

    /* renamed from: g  reason: collision with root package name */
    public int f4585g = 4096;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f4590l = null;

    /* renamed from: m  reason: collision with root package name */
    public PorterDuff.Mode f4591m = null;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4592n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4593o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f4594p = 16;

    public a(Context context, CharSequence charSequence) {
        this.f4587i = context;
        this.f4579a = charSequence;
    }

    @Override // d0.b
    public final d0.b a(i0.e eVar) {
        throw new UnsupportedOperationException();
    }

    @Override // d0.b
    public final i0.e b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f4586h;
        if (drawable != null) {
            if (this.f4592n || this.f4593o) {
                this.f4586h = drawable;
                Drawable mutate = drawable.mutate();
                this.f4586h = mutate;
                if (this.f4592n) {
                    c0.b.h(mutate, this.f4590l);
                }
                if (this.f4593o) {
                    c0.b.i(this.f4586h, this.f4591m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f4585g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f4584f;
    }

    @Override // d0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f4588j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f4586h;
    }

    @Override // d0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f4590l;
    }

    @Override // d0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f4591m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f4581c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return 16908332;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f4583e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f4582d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f4579a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4580b;
        if (charSequence == null) {
            return this.f4579a;
        }
        return charSequence;
    }

    @Override // d0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f4589k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f4594p & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f4594p & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f4594p & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        if ((this.f4594p & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        this.f4584f = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        this.f4594p = (z4 ? 1 : 0) | (this.f4594p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        int i4;
        int i5 = this.f4594p & (-3);
        if (z4) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        this.f4594p = i4 | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f4588j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        int i4;
        int i5 = this.f4594p & (-17);
        if (z4) {
            i4 = 16;
        } else {
            i4 = 0;
        }
        this.f4594p = i4 | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        Context context = this.f4587i;
        Object obj = z.e.f7215a;
        this.f4586h = z.c.b(context, i4);
        c();
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4590l = colorStateList;
        this.f4592n = true;
        c();
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4591m = mode;
        this.f4593o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f4581c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        this.f4582d = c4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f4582d = c4;
        this.f4584f = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        this.f4579a = this.f4587i.getResources().getString(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4580b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f4589k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i4 = 8;
        int i5 = this.f4594p & 8;
        if (z4) {
            i4 = 0;
        }
        this.f4594p = i5 | i4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        this.f4584f = Character.toLowerCase(c4);
        this.f4585g = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final d0.b setContentDescription(CharSequence charSequence) {
        this.f4588j = charSequence;
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        this.f4582d = c4;
        this.f4583e = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f4582d = c4;
        this.f4583e = KeyEvent.normalizeMetaState(i4);
        this.f4584f = Character.toLowerCase(c5);
        this.f4585g = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f4579a = charSequence;
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public final d0.b setTooltipText(CharSequence charSequence) {
        this.f4589k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f4586h = drawable;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        return this;
    }
}