package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.example.msphone.R;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes.dex */
public final class z implements l2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f988a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f989b;

    /* renamed from: c  reason: collision with root package name */
    public final Serializable f990c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f991d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f992e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f993f;

    /* renamed from: g  reason: collision with root package name */
    public Object f994g;

    /* JADX WARN: Type inference failed for: r1v3, types: [int[], java.io.Serializable] */
    public z() {
        this.f988a = 0;
        this.f989b = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        this.f990c = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        this.f991d = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        this.f992e = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        this.f993f = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        this.f994g = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
    }

    public static boolean a(int[] iArr, int i4) {
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList b(Context context, int i4) {
        int c4 = m3.c(context, R.attr.colorControlHighlight);
        int b5 = m3.b(context, R.attr.colorButtonNormal);
        return new ColorStateList(new int[][]{m3.f832b, m3.f834d, m3.f833c, m3.f836f}, new int[]{b5, b0.a.c(c4, i4), b0.a.c(c4, i4), i4});
    }

    public static LayerDrawable c(m2 m2Var, Context context, int i4) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i4);
        Drawable e4 = m2Var.e(context, R.drawable.abc_star_black_48dp);
        Drawable e5 = m2Var.e(context, R.drawable.abc_star_half_black_48dp);
        if ((e4 instanceof BitmapDrawable) && e4.getIntrinsicWidth() == dimensionPixelSize && e4.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) e4;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            e4.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            e4.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((e5 instanceof BitmapDrawable) && e5.getIntrinsicWidth() == dimensionPixelSize && e5.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) e5;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            e5.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            e5.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        return layerDrawable;
    }

    public static void f(Drawable drawable, int i4, PorterDuff.Mode mode) {
        int[] iArr = o1.f857a;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = a0.f691b;
        }
        mutate.setColorFilter(a0.c(i4, mode));
    }

    public final ColorStateList d(Context context, int i4) {
        if (i4 == R.drawable.abc_edit_text_material) {
            return z.e.b(context, R.color.abc_tint_edittext);
        }
        if (i4 == R.drawable.abc_switch_track_mtrl_alpha) {
            return z.e.b(context, R.color.abc_tint_switch_track);
        }
        if (i4 == R.drawable.abc_switch_thumb_material) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList d4 = m3.d(context, R.attr.colorSwitchThumbNormal);
            if (d4 != null && d4.isStateful()) {
                int[] iArr3 = m3.f832b;
                iArr[0] = iArr3;
                iArr2[0] = d4.getColorForState(iArr3, 0);
                iArr[1] = m3.f835e;
                iArr2[1] = m3.c(context, R.attr.colorControlActivated);
                iArr[2] = m3.f836f;
                iArr2[2] = d4.getDefaultColor();
            } else {
                iArr[0] = m3.f832b;
                iArr2[0] = m3.b(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = m3.f835e;
                iArr2[1] = m3.c(context, R.attr.colorControlActivated);
                iArr[2] = m3.f836f;
                iArr2[2] = m3.c(context, R.attr.colorSwitchThumbNormal);
            }
            return new ColorStateList(iArr, iArr2);
        } else if (i4 == R.drawable.abc_btn_default_mtrl_shape) {
            return b(context, m3.c(context, R.attr.colorButtonNormal));
        } else {
            if (i4 == R.drawable.abc_btn_borderless_material) {
                return b(context, 0);
            }
            if (i4 == R.drawable.abc_btn_colored_material) {
                return b(context, m3.c(context, R.attr.colorAccent));
            }
            if (i4 != R.drawable.abc_spinner_mtrl_am_alpha && i4 != R.drawable.abc_spinner_textfield_background_material) {
                if (a((int[]) this.f990c, i4)) {
                    return m3.d(context, R.attr.colorControlNormal);
                }
                if (a((int[]) this.f993f, i4)) {
                    return z.e.b(context, R.color.abc_tint_default);
                }
                if (a((int[]) this.f994g, i4)) {
                    return z.e.b(context, R.color.abc_tint_btn_checkable);
                }
                if (i4 == R.drawable.abc_seekbar_thumb_material) {
                    return z.e.b(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
            return z.e.b(context, R.color.abc_tint_spinner);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, m3.t] */
    public final m3.t e() {
        LinkedHashMap linkedHashMap;
        ?? obj = new Object();
        obj.f5606e = new LinkedHashMap();
        obj.f5602a = (m3.o) this.f989b;
        obj.f5603b = (String) this.f990c;
        obj.f5605d = (m3.u) this.f992e;
        Map map = (Map) this.f993f;
        if (map.isEmpty()) {
            linkedHashMap = new LinkedHashMap();
        } else {
            linkedHashMap = new LinkedHashMap(map);
        }
        obj.f5606e = linkedHashMap;
        obj.f5604c = ((m3.m) this.f991d).c();
        return obj;
    }

    public final String toString() {
        switch (this.f988a) {
            case 1:
                StringBuilder sb = new StringBuilder("Request{method=");
                sb.append((String) this.f990c);
                sb.append(", url=");
                sb.append((m3.o) this.f989b);
                m3.m mVar = (m3.m) this.f991d;
                if (mVar.size() != 0) {
                    sb.append(", headers=[");
                    Iterator it = mVar.iterator();
                    int i4 = 0;
                    while (true) {
                        y2.a aVar = (y2.a) it;
                        if (aVar.hasNext()) {
                            Object next = aVar.next();
                            int i5 = i4 + 1;
                            if (i4 >= 0) {
                                Pair pair = (Pair) next;
                                String str = (String) pair.f5152a;
                                String str2 = (String) pair.f5153b;
                                if (i4 > 0) {
                                    sb.append(", ");
                                }
                                sb.append(str);
                                sb.append(':');
                                sb.append(str2);
                                i4 = i5;
                            } else {
                                throw new ArithmeticException("Index overflow has happened.");
                            }
                        } else {
                            sb.append(']');
                        }
                    }
                }
                Map map = (Map) this.f993f;
                if (!map.isEmpty()) {
                    sb.append(", tags=");
                    sb.append(map);
                }
                sb.append('}');
                String sb2 = sb.toString();
                com.google.common.collect.c.E(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            default:
                return super.toString();
        }
    }

    public z(m3.o oVar, String str, m3.m mVar, m3.u uVar, Map map) {
        this.f988a = 1;
        com.google.common.collect.c.F(str, "method");
        this.f989b = oVar;
        this.f990c = str;
        this.f991d = mVar;
        this.f992e = uVar;
        this.f993f = map;
    }
}