package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.q3;
import c.a;
import com.example.msphone.R;
import g.e0;
import g.r;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements e0, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    public r f388a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f389b;

    /* renamed from: c  reason: collision with root package name */
    public RadioButton f390c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f391d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f392e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f393f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f394g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f395h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f396i;

    /* renamed from: j  reason: collision with root package name */
    public final Drawable f397j;

    /* renamed from: k  reason: collision with root package name */
    public final int f398k;

    /* renamed from: l  reason: collision with root package name */
    public final Context f399l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f400m;

    /* renamed from: n  reason: collision with root package name */
    public final Drawable f401n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f402o;

    /* renamed from: p  reason: collision with root package name */
    public LayoutInflater f403p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f404q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f403p == null) {
            this.f403p = LayoutInflater.from(getContext());
        }
        return this.f403p;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f394g;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f395h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f395h.getLayoutParams();
        rect.top = this.f395h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // g.e0
    public final void c(r rVar) {
        int i4;
        char c4;
        char c5;
        this.f388a = rVar;
        boolean z4 = false;
        if (rVar.isVisible()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        setVisibility(i4);
        setTitle(rVar.f4726e);
        setCheckable(rVar.isCheckable());
        if (rVar.f4735n.o()) {
            if (rVar.f4735n.n()) {
                c5 = rVar.f4731j;
            } else {
                c5 = rVar.f4729h;
            }
            if (c5 != 0) {
                z4 = true;
            }
        }
        if (rVar.f4735n.n()) {
            c4 = rVar.f4731j;
        } else {
            c4 = rVar.f4729h;
        }
        setShortcut(z4, c4);
        setIcon(rVar.getIcon());
        setEnabled(rVar.isEnabled());
        setSubMenuArrowVisible(rVar.hasSubMenu());
        setContentDescription(rVar.f4738q);
    }

    @Override // g.e0
    public r getItemData() {
        return this.f388a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = y0.f4999a;
        g0.q(this, this.f397j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f391d = textView;
        int i4 = this.f398k;
        if (i4 != -1) {
            textView.setTextAppearance(this.f399l, i4);
        }
        this.f393f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f394g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f401n);
        }
        this.f395h = (ImageView) findViewById(R.id.group_divider);
        this.f396i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (this.f389b != null && this.f400m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f389b.getLayoutParams();
            int i6 = layoutParams.height;
            if (i6 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i6;
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setCheckable(boolean z4) {
        CompoundButton compoundButton;
        View view;
        if (!z4 && this.f390c == null && this.f392e == null) {
            return;
        }
        if ((this.f388a.f4745x & 4) != 0) {
            if (this.f390c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f390c = radioButton;
                LinearLayout linearLayout = this.f396i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f390c;
            view = this.f392e;
        } else {
            if (this.f392e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f392e = checkBox;
                LinearLayout linearLayout2 = this.f396i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f392e;
            view = this.f390c;
        }
        if (z4) {
            compoundButton.setChecked(this.f388a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox2 = this.f392e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f390c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if ((this.f388a.f4745x & 4) != 0) {
            if (this.f390c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f390c = radioButton;
                LinearLayout linearLayout = this.f396i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f390c;
        } else {
            if (this.f392e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f392e = checkBox;
                LinearLayout linearLayout2 = this.f396i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f392e;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f404q = z4;
        this.f400m = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f395h;
        if (imageView != null) {
            imageView.setVisibility((this.f402o || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f388a.f4735n.getClass();
        boolean z4 = this.f404q;
        if (!z4 && !this.f400m) {
            return;
        }
        ImageView imageView = this.f389b;
        if (imageView == null && drawable == null && !this.f400m) {
            return;
        }
        if (imageView == null) {
            ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
            this.f389b = imageView2;
            LinearLayout linearLayout = this.f396i;
            if (linearLayout != null) {
                linearLayout.addView(imageView2, 0);
            } else {
                addView(imageView2, 0);
            }
        }
        if (drawable == null && !this.f400m) {
            this.f389b.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.f389b;
        if (!z4) {
            drawable = null;
        }
        imageView3.setImageDrawable(drawable);
        if (this.f389b.getVisibility() != 0) {
            this.f389b.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setShortcut(boolean r8, char r9) {
        /*
            r7 = this;
            r9 = 8
            if (r8 == 0) goto L1f
            g.r r8 = r7.f388a
            g.p r0 = r8.f4735n
            boolean r0 = r0.o()
            if (r0 == 0) goto L1f
            g.p r0 = r8.f4735n
            boolean r0 = r0.n()
            if (r0 == 0) goto L19
            char r8 = r8.f4731j
            goto L1b
        L19:
            char r8 = r8.f4729h
        L1b:
            if (r8 == 0) goto L1f
            r8 = 0
            goto L20
        L1f:
            r8 = r9
        L20:
            if (r8 != 0) goto Ld2
            android.widget.TextView r0 = r7.f393f
            g.r r1 = r7.f388a
            g.p r2 = r1.f4735n
            boolean r2 = r2.n()
            if (r2 == 0) goto L31
            char r2 = r1.f4731j
            goto L33
        L31:
            char r2 = r1.f4729h
        L33:
            if (r2 != 0) goto L39
            java.lang.String r9 = ""
            goto Lcf
        L39:
            g.p r3 = r1.f4735n
            android.content.Context r4 = r3.f4695a
            android.content.res.Resources r4 = r4.getResources()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.content.Context r6 = r3.f4695a
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r6 = r6.hasPermanentMenuKey()
            if (r6 == 0) goto L5c
            r6 = 2131689489(0x7f0f0011, float:1.9007995E38)
            java.lang.String r6 = r4.getString(r6)
            r5.append(r6)
        L5c:
            boolean r3 = r3.n()
            if (r3 == 0) goto L65
            int r1 = r1.f4732k
            goto L67
        L65:
            int r1 = r1.f4730i
        L67:
            r3 = 2131689485(0x7f0f000d, float:1.9007987E38)
            java.lang.String r3 = r4.getString(r3)
            r6 = 65536(0x10000, float:9.1835E-41)
            g.r.c(r5, r1, r6, r3)
            r3 = 2131689481(0x7f0f0009, float:1.9007979E38)
            java.lang.String r3 = r4.getString(r3)
            r6 = 4096(0x1000, float:5.74E-42)
            g.r.c(r5, r1, r6, r3)
            r3 = 2131689480(0x7f0f0008, float:1.9007977E38)
            java.lang.String r3 = r4.getString(r3)
            r6 = 2
            g.r.c(r5, r1, r6, r3)
            r3 = 2131689486(0x7f0f000e, float:1.9007989E38)
            java.lang.String r3 = r4.getString(r3)
            r6 = 1
            g.r.c(r5, r1, r6, r3)
            r3 = 2131689488(0x7f0f0010, float:1.9007993E38)
            java.lang.String r3 = r4.getString(r3)
            r6 = 4
            g.r.c(r5, r1, r6, r3)
            r3 = 2131689484(0x7f0f000c, float:1.9007985E38)
            java.lang.String r3 = r4.getString(r3)
            g.r.c(r5, r1, r9, r3)
            if (r2 == r9) goto Lc7
            r9 = 10
            if (r2 == r9) goto Lc3
            r9 = 32
            if (r2 == r9) goto Lb8
            r5.append(r2)
            goto Lcb
        Lb8:
            r9 = 2131689487(0x7f0f000f, float:1.900799E38)
        Lbb:
            java.lang.String r9 = r4.getString(r9)
            r5.append(r9)
            goto Lcb
        Lc3:
            r9 = 2131689483(0x7f0f000b, float:1.9007983E38)
            goto Lbb
        Lc7:
            r9 = 2131689482(0x7f0f000a, float:1.900798E38)
            goto Lbb
        Lcb:
            java.lang.String r9 = r5.toString()
        Lcf:
            r0.setText(r9)
        Ld2:
            android.widget.TextView r9 = r7.f393f
            int r9 = r9.getVisibility()
            if (r9 == r8) goto Ldf
            android.widget.TextView r9 = r7.f393f
            r9.setVisibility(r8)
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.setShortcut(boolean, char):void");
    }

    public void setTitle(CharSequence charSequence) {
        int i4;
        TextView textView;
        if (charSequence != null) {
            this.f391d.setText(charSequence);
            if (this.f391d.getVisibility() == 0) {
                return;
            }
            textView = this.f391d;
            i4 = 0;
        } else {
            i4 = 8;
            if (this.f391d.getVisibility() == 8) {
                return;
            }
            textView = this.f391d;
        }
        textView.setVisibility(i4);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet);
        q3 f4 = q3.f(getContext(), attributeSet, a.f2562t, i4, 0);
        this.f397j = f4.b(5);
        TypedArray typedArray = f4.f879b;
        this.f398k = typedArray.getResourceId(1, -1);
        this.f400m = typedArray.getBoolean(7, false);
        this.f399l = context;
        this.f401n = f4.b(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.f402o = obtainStyledAttributes.hasValue(0);
        f4.g();
        obtainStyledAttributes.recycle();
    }
}