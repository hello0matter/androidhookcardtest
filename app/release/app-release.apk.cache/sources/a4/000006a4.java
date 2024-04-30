package f;

import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class o {
    @DoNotInline
    public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    @DoNotInline
    public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i4) {
        return callback.onWindowStartingActionMode(callback2, i4);
    }
}