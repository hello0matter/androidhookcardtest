package androidx.appcompat.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class k implements z0.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f296a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f297b;

    public k(AppCompatActivity appCompatActivity) {
        this.f297b = appCompatActivity;
    }

    @Override // z0.c
    public final Bundle a() {
        int i4 = this.f296a;
        Object obj = this.f297b;
        switch (i4) {
            case 0:
                Bundle bundle = new Bundle();
                ((AppCompatActivity) obj).l().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((Set) obj));
                return bundle2;
        }
    }

    public k(z0.d dVar) {
        com.google.common.collect.c.F(dVar, "registry");
        this.f297b = new LinkedHashSet();
        dVar.b("androidx.savedstate.Restarter", this);
    }
}