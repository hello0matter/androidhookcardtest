package f;

import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class p {
    @DoNotInline
    public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i4) {
        callback.onProvideKeyboardShortcuts(list, menu, i4);
    }
}