package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class SpecialEffectsController$Operation$State {

    /* renamed from: a  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$State f1626a;

    /* renamed from: b  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$State f1627b;

    /* renamed from: c  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$State f1628c;

    /* renamed from: d  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$State f1629d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ SpecialEffectsController$Operation$State[] f1630e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$State] */
    static {
        ?? r02 = new Enum("REMOVED", 0);
        f1626a = r02;
        ?? r12 = new Enum("VISIBLE", 1);
        f1627b = r12;
        ?? r22 = new Enum("GONE", 2);
        f1628c = r22;
        ?? r32 = new Enum("INVISIBLE", 3);
        f1629d = r32;
        f1630e = new SpecialEffectsController$Operation$State[]{r02, r12, r22, r32};
    }

    public static SpecialEffectsController$Operation$State b(int i4) {
        if (i4 != 0) {
            if (i4 != 4) {
                if (i4 == 8) {
                    return f1628c;
                }
                throw new IllegalArgumentException(androidx.activity.j.b("Unknown visibility ", i4));
            }
            return f1629d;
        }
        return f1627b;
    }

    public static SpecialEffectsController$Operation$State c(View view) {
        return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? f1629d : b(view.getVisibility());
    }

    public static SpecialEffectsController$Operation$State valueOf(String str) {
        return (SpecialEffectsController$Operation$State) Enum.valueOf(SpecialEffectsController$Operation$State.class, str);
    }

    public static SpecialEffectsController$Operation$State[] values() {
        return (SpecialEffectsController$Operation$State[]) f1630e.clone();
    }

    public final void a(View view) {
        int i4;
        int ordinal = ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        i4 = 4;
                    } else {
                        return;
                    }
                } else {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i4 = 8;
                }
            } else {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                }
                i4 = 0;
            }
            view.setVisibility(i4);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
            }
            viewGroup.removeView(view);
        }
    }
}