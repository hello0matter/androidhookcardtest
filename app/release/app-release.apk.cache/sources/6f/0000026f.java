package androidx.fragment.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;

/* loaded from: classes.dex */
public final class h0 extends com.google.common.collect.c {
    @Override // com.google.common.collect.c
    public void D1(m.e eVar, m.e eVar2) {
        eVar.f5424b = eVar2;
    }

    @Override // com.google.common.collect.c
    public void E1(m.e eVar, Thread thread) {
        eVar.f5423a = thread;
    }

    @Override // com.google.common.collect.c
    public Intent c0(ComponentActivity componentActivity, Intent intent) {
        Bundle bundleExtra;
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intent;
        Intent intent2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intent3 = intentSenderRequest.f127b;
        if (intent3 != null && (bundleExtra = intent3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
            intent3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (intent3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                IntentSender intentSender = intentSenderRequest.f126a;
                com.google.common.collect.c.F(intentSender, "intentSender");
                intentSenderRequest = new IntentSenderRequest(intentSender, null, intentSenderRequest.f128c, intentSenderRequest.f129d);
            }
        }
        intent2.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "CreateIntent created the following intent: " + intent2);
        }
        return intent2;
    }

    @Override // com.google.common.collect.c
    public boolean w(m.f fVar, m.c cVar) {
        m.c cVar2 = m.c.f5415b;
        synchronized (fVar) {
            try {
                if (fVar.f5430b == cVar) {
                    fVar.f5430b = cVar2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.common.collect.c
    public boolean x(m.f fVar, Object obj, Object obj2) {
        synchronized (fVar) {
            try {
                if (fVar.f5429a == obj) {
                    fVar.f5429a = obj2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.common.collect.c
    public boolean y(m.f fVar, m.e eVar, m.e eVar2) {
        synchronized (fVar) {
            try {
                if (fVar.f5431c == eVar) {
                    fVar.f5431c = eVar2;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.common.collect.c
    public Object z1(Intent intent, int i4) {
        return new ActivityResult(intent, i4);
    }
}