package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class j extends h0 implements DialogInterface {

    /* renamed from: f  reason: collision with root package name */
    public final h f287f;

    public j(Context context, int i4) {
        super(context, g(context, i4));
        this.f287f = new h(getContext(), this, getWindow());
    }

    public static int g(Context context, int i4) {
        if (((i4 >>> 24) & 255) >= 1) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0230, code lost:
        if (r4 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x023a, code lost:
        if (r4 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x023c, code lost:
        r4.setVisibility(0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.h0, androidx.activity.p, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r18) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.j.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f287f.f263i;
        if (nestedScrollView != null && nestedScrollView.h(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f287f.f263i;
        if (nestedScrollView != null && nestedScrollView.h(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // androidx.appcompat.app.h0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        h hVar = this.f287f;
        hVar.f258d = charSequence;
        TextView textView = hVar.f267m;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}