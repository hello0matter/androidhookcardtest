package q1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.example.msphone.R;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.h0;
import i2.d;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final BadgeState$State f6343a;

    /* renamed from: b  reason: collision with root package name */
    public final BadgeState$State f6344b = new BadgeState$State();

    /* renamed from: c  reason: collision with root package name */
    public final float f6345c;

    /* renamed from: d  reason: collision with root package name */
    public final float f6346d;

    /* renamed from: e  reason: collision with root package name */
    public final float f6347e;

    /* renamed from: f  reason: collision with root package name */
    public final float f6348f;

    /* renamed from: g  reason: collision with root package name */
    public final float f6349g;

    /* renamed from: h  reason: collision with root package name */
    public final float f6350h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6351i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6352j;

    /* renamed from: k  reason: collision with root package name */
    public final int f6353k;

    public b(Context context, BadgeState$State badgeState$State) {
        BadgeState$State badgeState$State2;
        AttributeSet attributeSet;
        int i4;
        int i5;
        boolean z4;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        int intValue9;
        int intValue10;
        int intValue11;
        int intValue12;
        int intValue13;
        int intValue14;
        int intValue15;
        int intValue16;
        boolean booleanValue;
        int next;
        if (badgeState$State == null) {
            badgeState$State2 = new BadgeState$State();
        } else {
            badgeState$State2 = badgeState$State;
        }
        int i6 = badgeState$State2.f2974a;
        if (i6 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i6);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    if (TextUtils.equals(xml.getName(), "badge")) {
                        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                        i4 = asAttributeSet.getStyleAttribute();
                        attributeSet = asAttributeSet;
                    } else {
                        throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (IOException | XmlPullParserException e4) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i6));
                notFoundException.initCause(e4);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            i4 = 0;
        }
        if (i4 == 0) {
            i5 = 2131756009;
        } else {
            i5 = i4;
        }
        TypedArray d4 = h0.d(context, attributeSet, o1.a.f5940c, R.attr.badgeStyle, i5, new int[0]);
        Resources resources = context.getResources();
        this.f6345c = d4.getDimensionPixelSize(4, -1);
        this.f6351i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.f6352j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f6346d = d4.getDimensionPixelSize(14, -1);
        this.f6347e = d4.getDimension(12, resources.getDimension(R.dimen.m3_badge_size));
        this.f6349g = d4.getDimension(17, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f6348f = d4.getDimension(3, resources.getDimension(R.dimen.m3_badge_size));
        this.f6350h = d4.getDimension(13, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f6353k = d4.getInt(24, 1);
        BadgeState$State badgeState$State3 = this.f6344b;
        int i7 = badgeState$State2.f2982i;
        badgeState$State3.f2982i = i7 == -2 ? 255 : i7;
        int i8 = badgeState$State2.f2984k;
        if (i8 != -2) {
            badgeState$State3.f2984k = i8;
        } else if (d4.hasValue(23)) {
            this.f6344b.f2984k = d4.getInt(23, 0);
        } else {
            this.f6344b.f2984k = -1;
        }
        String str = badgeState$State2.f2983j;
        if (str != null) {
            this.f6344b.f2983j = str;
        } else if (d4.hasValue(7)) {
            this.f6344b.f2983j = d4.getString(7);
        }
        BadgeState$State badgeState$State4 = this.f6344b;
        badgeState$State4.f2988o = badgeState$State2.f2988o;
        CharSequence charSequence = badgeState$State2.f2989p;
        badgeState$State4.f2989p = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        BadgeState$State badgeState$State5 = this.f6344b;
        int i9 = badgeState$State2.f2990q;
        badgeState$State5.f2990q = i9 == 0 ? R.plurals.mtrl_badge_content_description : i9;
        int i10 = badgeState$State2.f2991r;
        badgeState$State5.f2991r = i10 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i10;
        Boolean bool = badgeState$State2.f2993t;
        if (bool != null && !bool.booleanValue()) {
            z4 = false;
        } else {
            z4 = true;
        }
        badgeState$State5.f2993t = Boolean.valueOf(z4);
        BadgeState$State badgeState$State6 = this.f6344b;
        int i11 = badgeState$State2.f2985l;
        badgeState$State6.f2985l = i11 == -2 ? d4.getInt(21, -2) : i11;
        BadgeState$State badgeState$State7 = this.f6344b;
        int i12 = badgeState$State2.f2986m;
        badgeState$State7.f2986m = i12 == -2 ? d4.getInt(22, -2) : i12;
        BadgeState$State badgeState$State8 = this.f6344b;
        Integer num = badgeState$State2.f2978e;
        if (num == null) {
            intValue = d4.getResourceId(5, 2131755369);
        } else {
            intValue = num.intValue();
        }
        badgeState$State8.f2978e = Integer.valueOf(intValue);
        BadgeState$State badgeState$State9 = this.f6344b;
        Integer num2 = badgeState$State2.f2979f;
        if (num2 == null) {
            intValue2 = d4.getResourceId(6, 0);
        } else {
            intValue2 = num2.intValue();
        }
        badgeState$State9.f2979f = Integer.valueOf(intValue2);
        BadgeState$State badgeState$State10 = this.f6344b;
        Integer num3 = badgeState$State2.f2980g;
        if (num3 == null) {
            intValue3 = d4.getResourceId(15, 2131755369);
        } else {
            intValue3 = num3.intValue();
        }
        badgeState$State10.f2980g = Integer.valueOf(intValue3);
        BadgeState$State badgeState$State11 = this.f6344b;
        Integer num4 = badgeState$State2.f2981h;
        if (num4 == null) {
            intValue4 = d4.getResourceId(16, 0);
        } else {
            intValue4 = num4.intValue();
        }
        badgeState$State11.f2981h = Integer.valueOf(intValue4);
        BadgeState$State badgeState$State12 = this.f6344b;
        Integer num5 = badgeState$State2.f2975b;
        if (num5 == null) {
            intValue5 = d.a(context, d4, 1).getDefaultColor();
        } else {
            intValue5 = num5.intValue();
        }
        badgeState$State12.f2975b = Integer.valueOf(intValue5);
        BadgeState$State badgeState$State13 = this.f6344b;
        Integer num6 = badgeState$State2.f2977d;
        if (num6 == null) {
            intValue6 = d4.getResourceId(8, 2131755511);
        } else {
            intValue6 = num6.intValue();
        }
        badgeState$State13.f2977d = Integer.valueOf(intValue6);
        Integer num7 = badgeState$State2.f2976c;
        if (num7 != null) {
            this.f6344b.f2976c = num7;
        } else if (d4.hasValue(9)) {
            this.f6344b.f2976c = Integer.valueOf(d.a(context, d4, 9).getDefaultColor());
        } else {
            int intValue17 = this.f6344b.f2977d.intValue();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(intValue17, o1.a.f5943d0);
            obtainStyledAttributes.getDimension(0, 0.0f);
            ColorStateList a5 = d.a(context, obtainStyledAttributes, 3);
            d.a(context, obtainStyledAttributes, 4);
            d.a(context, obtainStyledAttributes, 5);
            obtainStyledAttributes.getInt(2, 0);
            obtainStyledAttributes.getInt(1, 1);
            int i13 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
            obtainStyledAttributes.getResourceId(i13, 0);
            obtainStyledAttributes.getString(i13);
            obtainStyledAttributes.getBoolean(14, false);
            d.a(context, obtainStyledAttributes, 6);
            obtainStyledAttributes.getFloat(7, 0.0f);
            obtainStyledAttributes.getFloat(8, 0.0f);
            obtainStyledAttributes.getFloat(9, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(intValue17, o1.a.I);
            obtainStyledAttributes2.hasValue(0);
            obtainStyledAttributes2.getFloat(0, 0.0f);
            obtainStyledAttributes2.recycle();
            this.f6344b.f2976c = Integer.valueOf(a5.getDefaultColor());
        }
        BadgeState$State badgeState$State14 = this.f6344b;
        Integer num8 = badgeState$State2.f2992s;
        if (num8 == null) {
            intValue7 = d4.getInt(2, 8388661);
        } else {
            intValue7 = num8.intValue();
        }
        badgeState$State14.f2992s = Integer.valueOf(intValue7);
        BadgeState$State badgeState$State15 = this.f6344b;
        Integer num9 = badgeState$State2.f2994u;
        if (num9 == null) {
            intValue8 = d4.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        } else {
            intValue8 = num9.intValue();
        }
        badgeState$State15.f2994u = Integer.valueOf(intValue8);
        BadgeState$State badgeState$State16 = this.f6344b;
        Integer num10 = badgeState$State2.f2995v;
        if (num10 == null) {
            intValue9 = d4.getDimensionPixelSize(10, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding));
        } else {
            intValue9 = num10.intValue();
        }
        badgeState$State16.f2995v = Integer.valueOf(intValue9);
        BadgeState$State badgeState$State17 = this.f6344b;
        Integer num11 = badgeState$State2.f2996w;
        if (num11 == null) {
            intValue10 = d4.getDimensionPixelOffset(18, 0);
        } else {
            intValue10 = num11.intValue();
        }
        badgeState$State17.f2996w = Integer.valueOf(intValue10);
        BadgeState$State badgeState$State18 = this.f6344b;
        Integer num12 = badgeState$State2.f2997x;
        if (num12 == null) {
            intValue11 = d4.getDimensionPixelOffset(25, 0);
        } else {
            intValue11 = num12.intValue();
        }
        badgeState$State18.f2997x = Integer.valueOf(intValue11);
        BadgeState$State badgeState$State19 = this.f6344b;
        Integer num13 = badgeState$State2.f2998y;
        if (num13 == null) {
            intValue12 = d4.getDimensionPixelOffset(19, badgeState$State19.f2996w.intValue());
        } else {
            intValue12 = num13.intValue();
        }
        badgeState$State19.f2998y = Integer.valueOf(intValue12);
        BadgeState$State badgeState$State20 = this.f6344b;
        Integer num14 = badgeState$State2.f2999z;
        if (num14 == null) {
            intValue13 = d4.getDimensionPixelOffset(26, badgeState$State20.f2997x.intValue());
        } else {
            intValue13 = num14.intValue();
        }
        badgeState$State20.f2999z = Integer.valueOf(intValue13);
        BadgeState$State badgeState$State21 = this.f6344b;
        Integer num15 = badgeState$State2.C;
        if (num15 == null) {
            intValue14 = d4.getDimensionPixelOffset(20, 0);
        } else {
            intValue14 = num15.intValue();
        }
        badgeState$State21.C = Integer.valueOf(intValue14);
        BadgeState$State badgeState$State22 = this.f6344b;
        Integer num16 = badgeState$State2.A;
        if (num16 == null) {
            intValue15 = 0;
        } else {
            intValue15 = num16.intValue();
        }
        badgeState$State22.A = Integer.valueOf(intValue15);
        BadgeState$State badgeState$State23 = this.f6344b;
        Integer num17 = badgeState$State2.B;
        if (num17 == null) {
            intValue16 = 0;
        } else {
            intValue16 = num17.intValue();
        }
        badgeState$State23.B = Integer.valueOf(intValue16);
        BadgeState$State badgeState$State24 = this.f6344b;
        Boolean bool2 = badgeState$State2.D;
        if (bool2 == null) {
            booleanValue = d4.getBoolean(0, false);
        } else {
            booleanValue = bool2.booleanValue();
        }
        badgeState$State24.D = Boolean.valueOf(booleanValue);
        d4.recycle();
        Locale locale = badgeState$State2.f2987n;
        if (locale == null) {
            this.f6344b.f2987n = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.f6344b.f2987n = locale;
        }
        this.f6343a = badgeState$State2;
    }
}