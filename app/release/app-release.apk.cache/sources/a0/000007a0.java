package j0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.search.SearchBar;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final d f5076a;

    public e(d dVar) {
        this.f5076a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f5076a.equals(((e) obj).f5076a);
    }

    public final int hashCode() {
        return this.f5076a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z4) {
        int i4;
        l0.d dVar = (l0.d) this.f5076a;
        int i5 = dVar.f5258a;
        Object obj = dVar.f5259b;
        switch (i5) {
            case VisibleForTesting.PROTECTED /* 4 */:
                int i6 = SearchBar.f3728l0;
                ((SearchBar) obj).setFocusableInTouchMode(z4);
                return;
            default:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) obj;
                AutoCompleteTextView autoCompleteTextView = iVar.f4035h;
                if (autoCompleteTextView != null && autoCompleteTextView.getInputType() == 0) {
                    if (z4) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    WeakHashMap weakHashMap = y0.f4999a;
                    g0.s(iVar.f4074d, i4);
                    return;
                }
                return;
        }
    }
}