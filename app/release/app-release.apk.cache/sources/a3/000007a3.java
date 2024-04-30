package j0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: d  reason: collision with root package name */
    public static int f5092d;

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f5093a;

    /* renamed from: b  reason: collision with root package name */
    public int f5094b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f5095c = -1;

    public h(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5093a = accessibilityNodeInfo;
    }

    public final void a(int i4) {
        this.f5093a.addAction(i4);
    }

    public final void b(g gVar) {
        this.f5093a.addAction((AccessibilityNodeInfo.AccessibilityAction) gVar.f5088a);
    }

    public final ArrayList c(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5093a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public final void d(Rect rect) {
        this.f5093a.getBoundsInParent(rect);
    }

    public final CharSequence e() {
        boolean z4 = !c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5093a;
        if (z4) {
            ArrayList c4 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            ArrayList c5 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            ArrayList c6 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            ArrayList c7 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
            for (int i4 = 0; i4 < c4.size(); i4++) {
                spannableString.setSpan(new a(((Integer) c7.get(i4)).intValue(), this, accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) c4.get(i4)).intValue(), ((Integer) c5.get(i4)).intValue(), ((Integer) c6.get(i4)).intValue());
            }
            return spannableString;
        }
        return accessibilityNodeInfo.getText();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f5093a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        if (this.f5095c == hVar.f5095c && this.f5094b == hVar.f5094b) {
            return true;
        }
        return false;
    }

    public final void f(int i4, boolean z4) {
        Bundle extras = this.f5093a.getExtras();
        if (extras != null) {
            int i5 = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i4);
            if (!z4) {
                i4 = 0;
            }
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i4 | i5);
        }
    }

    public final void g(CharSequence charSequence) {
        this.f5093a.setClassName(charSequence);
    }

    public final void h(i0 i0Var) {
        this.f5093a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) i0Var.f2125a);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5093a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void i(String str) {
        int i4 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5093a;
        if (i4 >= 26) {
            accessibilityNodeInfo.setHintText(str);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", str);
        }
    }

    public final void j(boolean z4) {
        this.f5093a.setScrollable(z4);
    }

    public final void k(CharSequence charSequence) {
        this.f5093a.setText(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    public final String toString() {
        String string;
        ?? emptyList;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        d(rect);
        sb.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5093a;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        sb.append(e());
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; viewId: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        if (e0.a.a()) {
            string = accessibilityNodeInfo.getUniqueId();
        } else {
            string = accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        }
        sb.append(string);
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        sb.append(accessibilityNodeInfo.isChecked());
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList != null) {
            emptyList = new ArrayList();
            int size = actionList.size();
            for (int i4 = 0; i4 < size; i4++) {
                emptyList.add(new g(actionList.get(i4), 0, null, null, null));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        for (int i5 = 0; i5 < emptyList.size(); i5++) {
            g gVar = (g) emptyList.get(i5);
            int a5 = gVar.a();
            if (a5 != 1) {
                if (a5 != 2) {
                    switch (a5) {
                        case VisibleForTesting.PROTECTED /* 4 */:
                            str = "ACTION_SELECT";
                            break;
                        case 8:
                            str = "ACTION_CLEAR_SELECTION";
                            break;
                        case 16:
                            str = "ACTION_CLICK";
                            break;
                        case 32:
                            str = "ACTION_LONG_CLICK";
                            break;
                        case 64:
                            str = "ACTION_ACCESSIBILITY_FOCUS";
                            break;
                        case 128:
                            str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                            break;
                        case 256:
                            str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                            break;
                        case 512:
                            str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                            break;
                        case 1024:
                            str = "ACTION_NEXT_HTML_ELEMENT";
                            break;
                        case 2048:
                            str = "ACTION_PREVIOUS_HTML_ELEMENT";
                            break;
                        case 4096:
                            str = "ACTION_SCROLL_FORWARD";
                            break;
                        case 8192:
                            str = "ACTION_SCROLL_BACKWARD";
                            break;
                        case 16384:
                            str = "ACTION_COPY";
                            break;
                        case 32768:
                            str = "ACTION_PASTE";
                            break;
                        case 65536:
                            str = "ACTION_CUT";
                            break;
                        case 131072:
                            str = "ACTION_SET_SELECTION";
                            break;
                        case 262144:
                            str = "ACTION_EXPAND";
                            break;
                        case 524288:
                            str = "ACTION_COLLAPSE";
                            break;
                        case 2097152:
                            str = "ACTION_SET_TEXT";
                            break;
                        case 16908354:
                            str = "ACTION_MOVE_WINDOW";
                            break;
                        default:
                            switch (a5) {
                                case 16908342:
                                    str = "ACTION_SHOW_ON_SCREEN";
                                    break;
                                case 16908343:
                                    str = "ACTION_SCROLL_TO_POSITION";
                                    break;
                                case 16908344:
                                    str = "ACTION_SCROLL_UP";
                                    break;
                                case 16908345:
                                    str = "ACTION_SCROLL_LEFT";
                                    break;
                                case 16908346:
                                    str = "ACTION_SCROLL_DOWN";
                                    break;
                                case 16908347:
                                    str = "ACTION_SCROLL_RIGHT";
                                    break;
                                case 16908348:
                                    str = "ACTION_CONTEXT_CLICK";
                                    break;
                                case 16908349:
                                    str = "ACTION_SET_PROGRESS";
                                    break;
                                default:
                                    switch (a5) {
                                        case 16908356:
                                            str = "ACTION_SHOW_TOOLTIP";
                                            break;
                                        case 16908357:
                                            str = "ACTION_HIDE_TOOLTIP";
                                            break;
                                        case 16908358:
                                            str = "ACTION_PAGE_UP";
                                            break;
                                        case 16908359:
                                            str = "ACTION_PAGE_DOWN";
                                            break;
                                        case 16908360:
                                            str = "ACTION_PAGE_LEFT";
                                            break;
                                        case 16908361:
                                            str = "ACTION_PAGE_RIGHT";
                                            break;
                                        case 16908362:
                                            str = "ACTION_PRESS_AND_HOLD";
                                            break;
                                        default:
                                            switch (a5) {
                                                case 16908372:
                                                    str = "ACTION_IME_ENTER";
                                                    break;
                                                case 16908373:
                                                    str = "ACTION_DRAG_START";
                                                    break;
                                                case 16908374:
                                                    str = "ACTION_DRAG_DROP";
                                                    break;
                                                case 16908375:
                                                    str = "ACTION_DRAG_CANCEL";
                                                    break;
                                                default:
                                                    str = "ACTION_UNKNOWN";
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    str = "ACTION_CLEAR_FOCUS";
                }
            } else {
                str = "ACTION_FOCUS";
            }
            if (str.equals("ACTION_UNKNOWN")) {
                Object obj = gVar.f5088a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    str = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(str);
            if (i5 != emptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}