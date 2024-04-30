package l0;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.appcompat.app.o0;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import i0.y0;
import j0.v;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements v, j0.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5258a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5259b;

    public /* synthetic */ d(int i4, Object obj) {
        this.f5258a = i4;
        this.f5259b = obj;
    }

    public final boolean a(o0 o0Var, int i4, Bundle bundle) {
        i0.g hVar;
        View view = (View) this.f5259b;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 25 && (i4 & 1) != 0) {
            try {
                ((h) o0Var.f311b).a();
                InputContentInfo a5 = a.a(((h) o0Var.f311b).i());
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", a5);
            } catch (Exception e4) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e4);
                return false;
            }
        }
        ClipData clipData = new ClipData(((h) o0Var.f311b).f(), new ClipData.Item(((h) o0Var.f311b).j()));
        if (i5 >= 31) {
            hVar = new i0.f(clipData, 2);
        } else {
            hVar = new i0.h(clipData, 2);
        }
        hVar.c(((h) o0Var.f311b).b());
        hVar.b(bundle);
        if (y0.k(view, hVar.a()) != null) {
            return false;
        }
        return true;
    }

    @Override // j0.v
    public final boolean e(View view) {
        int i4 = BottomSheetDragHandleView.f3103m;
        return ((BottomSheetDragHandleView) this.f5259b).c();
    }
}