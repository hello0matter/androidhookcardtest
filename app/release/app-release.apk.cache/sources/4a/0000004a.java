package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.IntentSenderRequest;
import androidx.recyclerview.widget.i0;

/* loaded from: classes.dex */
public final class i extends androidx.activity.result.f {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f104h;

    public i(ComponentActivity componentActivity) {
        this.f104h = componentActivity;
    }

    @Override // androidx.activity.result.f
    public final void b(int i4, com.google.common.collect.c cVar, Intent intent) {
        Bundle bundle;
        ComponentActivity componentActivity = this.f104h;
        i0 P0 = cVar.P0(componentActivity, intent);
        if (P0 != null) {
            new Handler(Looper.getMainLooper()).post(new h(this, i4, P0, 0));
            return;
        }
        Intent c02 = cVar.c0(componentActivity, intent);
        if (c02.getExtras() != null && c02.getExtras().getClassLoader() == null) {
            c02.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (c02.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = c02.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            c02.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(c02.getAction())) {
            String[] stringArrayExtra = c02.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            x.e.c(componentActivity, stringArrayExtra, i4);
        } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(c02.getAction())) {
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) c02.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                IntentSender intentSender = intentSenderRequest.f126a;
                Intent intent2 = intentSenderRequest.f127b;
                int i5 = intentSenderRequest.f128c;
                int i6 = intentSenderRequest.f129d;
                int i7 = x.e.f7064b;
                x.a.c(componentActivity, intentSender, i4, intent2, i5, i6, 0, bundle);
            } catch (IntentSender.SendIntentException e4) {
                new Handler(Looper.getMainLooper()).post(new h(this, i4, e4, 1));
            }
        } else {
            int i8 = x.e.f7064b;
            x.a.b(componentActivity, c02, i4, bundle);
        }
    }
}