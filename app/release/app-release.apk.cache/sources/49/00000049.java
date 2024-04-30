package androidx.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.i0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f100a;

    /* renamed from: b  reason: collision with root package name */
    public final int f101b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f102c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f103d;

    public /* synthetic */ h(int i4, int i5, Object obj, Object obj2) {
        this.f100a = i5;
        this.f102c = obj;
        this.f103d = obj2;
        this.f101b = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.b bVar;
        int i4 = this.f100a;
        int i5 = 0;
        Object obj = this.f102c;
        int i6 = this.f101b;
        Object obj2 = this.f103d;
        switch (i4) {
            case 0:
                i iVar = (i) obj;
                Object obj3 = ((i0) obj2).f2125a;
                String str = (String) iVar.f139a.get(Integer.valueOf(i6));
                if (str != null) {
                    androidx.activity.result.d dVar = (androidx.activity.result.d) iVar.f143e.get(str);
                    if (dVar != null && (bVar = dVar.f135a) != null) {
                        if (iVar.f142d.remove(str)) {
                            bVar.k(obj3);
                            return;
                        }
                        return;
                    }
                    iVar.f145g.remove(str);
                    iVar.f144f.put(str, obj3);
                    return;
                }
                return;
            case 1:
                ((i) obj).a(i6, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj2));
                return;
            case 2:
                String[] strArr = (String[]) obj2;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) obj;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                while (i5 < length) {
                    iArr[i5] = packageManager.checkPermission(strArr[i5], packageName);
                    i5++;
                }
                ((x.c) activity).onRequestPermissionsResult(i6, strArr, iArr);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                a0.p pVar = ((b0.g) ((f0.l) obj2)).f2497a;
                if (pVar != null) {
                    pVar.c(i6);
                    return;
                }
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                List list = (List) obj2;
                int size = list.size();
                if (i6 != 1) {
                    while (i5 < size) {
                        ((androidx.emoji2.text.l) list.get(i5)).a();
                        i5++;
                    }
                    return;
                }
                while (i5 < size) {
                    ((androidx.emoji2.text.l) list.get(i5)).b();
                    i5++;
                }
                return;
            default:
                ((BottomSheetBehavior) obj).L((View) obj2, i6, false);
                return;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(int i4, ArrayList arrayList) {
        this(arrayList, i4, null);
        this.f100a = 4;
    }

    public /* synthetic */ h(i iVar, int i4, Object obj, int i5) {
        this.f100a = i5;
        this.f102c = iVar;
        this.f101b = i4;
        this.f103d = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(androidx.emoji2.text.l lVar, int i4) {
        this(Arrays.asList(lVar), i4, null);
        this.f100a = 4;
        h0.e.c(lVar, "initCallback cannot be null");
    }

    public h(List list, int i4, Throwable th) {
        this.f100a = 4;
        h0.e.c(list, "initCallbacks cannot be null");
        this.f103d = new ArrayList(list);
        this.f101b = i4;
        this.f102c = th;
    }
}