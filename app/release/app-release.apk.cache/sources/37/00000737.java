package i0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.example.msphone.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final View.AccessibilityDelegate f4911c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    public final View.AccessibilityDelegate f4912a;

    /* renamed from: b  reason: collision with root package name */
    public final a f4913b;

    public c() {
        this(f4911c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f4912a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public androidx.recyclerview.widget.i0 b(View view) {
        AccessibilityNodeProvider a5 = b.a(this.f4912a, view);
        if (a5 != null) {
            return new androidx.recyclerview.widget.i0(a5);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f4912a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, j0.h hVar) {
        this.f4912a.onInitializeAccessibilityNodeInfo(view, hVar.f5093a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f4912a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f4912a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i4, Bundle bundle) {
        ClickableSpan[] clickableSpanArr;
        boolean z4;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            clickableSpanArr = null;
            if (i5 >= list.size()) {
                break;
            }
            j0.g gVar = (j0.g) list.get(i5);
            if (gVar.a() == i4) {
                j0.v vVar = gVar.f5091d;
                if (vVar != null) {
                    Class cls = gVar.f5090c;
                    if (cls != null) {
                        try {
                            androidx.activity.j.f(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                            throw null;
                        } catch (Exception e4) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e4);
                        }
                    }
                    z4 = vVar.e(view);
                }
            } else {
                i5++;
            }
        }
        z4 = false;
        if (!z4) {
            z4 = b.b(this.f4912a, view, i4, bundle);
        }
        if (!z4 && i4 == R.id.accessibility_action_clickable_span && bundle != null) {
            int i6 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i6)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                if (text instanceof Spanned) {
                    clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                }
                int i7 = 0;
                while (true) {
                    if (clickableSpanArr == null || i7 >= clickableSpanArr.length) {
                        break;
                    } else if (clickableSpan.equals(clickableSpanArr[i7])) {
                        clickableSpan.onClick(view);
                        z5 = true;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            return z5;
        }
        return z4;
    }

    public void h(View view, int i4) {
        this.f4912a.sendAccessibilityEvent(view, i4);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f4912a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f4912a = accessibilityDelegate;
        this.f4913b = new a(this);
    }
}