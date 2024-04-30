package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements f.d {

    /* renamed from: g0  reason: collision with root package name */
    public static final androidx.appcompat.app.c f606g0;
    public final Rect A;
    public final int[] B;
    public final int[] C;
    public final ImageView D;
    public final Drawable E;
    public final int F;
    public final int G;
    public final Intent H;
    public final Intent I;
    public final CharSequence J;
    public View.OnFocusChangeListener K;
    public View.OnClickListener L;
    public boolean M;
    public boolean N;
    public m0.b O;
    public boolean P;
    public CharSequence Q;
    public boolean R;
    public boolean S;
    public int T;
    public boolean U;
    public CharSequence V;
    public boolean W;

    /* renamed from: a0  reason: collision with root package name */
    public int f607a0;

    /* renamed from: b0  reason: collision with root package name */
    public SearchableInfo f608b0;

    /* renamed from: c0  reason: collision with root package name */
    public Bundle f609c0;

    /* renamed from: d0  reason: collision with root package name */
    public final t2 f610d0;

    /* renamed from: e0  reason: collision with root package name */
    public final t2 f611e0;

    /* renamed from: f0  reason: collision with root package name */
    public final WeakHashMap f612f0;

    /* renamed from: p  reason: collision with root package name */
    public final SearchAutoComplete f613p;

    /* renamed from: q  reason: collision with root package name */
    public final View f614q;

    /* renamed from: r  reason: collision with root package name */
    public final View f615r;

    /* renamed from: s  reason: collision with root package name */
    public final View f616s;

    /* renamed from: t  reason: collision with root package name */
    public final ImageView f617t;

    /* renamed from: u  reason: collision with root package name */
    public final ImageView f618u;

    /* renamed from: v  reason: collision with root package name */
    public final ImageView f619v;

    /* renamed from: w  reason: collision with root package name */
    public final ImageView f620w;

    /* renamed from: x  reason: collision with root package name */
    public final View f621x;

    /* renamed from: y  reason: collision with root package name */
    public g3 f622y;

    /* renamed from: z  reason: collision with root package name */
    public final Rect f623z;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public boolean f624c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f624c = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f624c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeValue(Boolean.valueOf(this.f624c));
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: e  reason: collision with root package name */
        public int f625e;

        /* renamed from: f  reason: collision with root package name */
        public SearchView f626f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f627g;

        /* renamed from: h  reason: collision with root package name */
        public final f3 f628h;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i4 = configuration.screenWidthDp;
            int i5 = configuration.screenHeightDp;
            if (i4 < 960 || i5 < 720 || configuration.orientation != 2) {
                if (i4 < 600) {
                    return (i4 < 640 || i5 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                a3.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            androidx.appcompat.app.c cVar = SearchView.f606g0;
            cVar.getClass();
            androidx.appcompat.app.c.n();
            Object obj = cVar.f194c;
            if (((Method) obj) != null) {
                try {
                    ((Method) obj).invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f625e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f627g) {
                f3 f3Var = this.f628h;
                removeCallbacks(f3Var);
                post(f3Var);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z4, int i4, Rect rect) {
            super.onFocusChanged(z4, i4, rect);
            SearchView searchView = this.f626f;
            searchView.y(searchView.N);
            searchView.post(searchView.f610d0);
            if (searchView.f613p.hasFocus()) {
                searchView.n();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i4, KeyEvent keyEvent) {
            if (i4 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f626f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i4, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z4) {
            super.onWindowFocusChanged(z4);
            if (z4 && this.f626f.hasFocus() && getVisibility() == 0) {
                this.f627g = true;
                Context context = getContext();
                androidx.appcompat.app.c cVar = SearchView.f606g0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z4) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            f3 f3Var = this.f628h;
            if (!z4) {
                this.f627g = false;
                removeCallbacks(f3Var);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.f627g = true;
            } else {
                this.f627g = false;
                removeCallbacks(f3Var);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f626f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i4) {
            super.setThreshold(i4);
            this.f625e = i4;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i4) {
            super(context, attributeSet, i4);
            this.f628h = new f3(this);
            this.f625e = getThreshold();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.app.c, java.lang.Object] */
    static {
        androidx.appcompat.app.c cVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            ?? obj = new Object();
            obj.f192a = null;
            obj.f193b = null;
            obj.f194c = null;
            androidx.appcompat.app.c.n();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                obj.f192a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                obj.f193b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                obj.f194c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            cVar = obj;
        }
        f606g0 = cVar;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f613p;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // f.d
    public final void b() {
        if (this.W) {
            return;
        }
        this.W = true;
        SearchAutoComplete searchAutoComplete = this.f613p;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f607a0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.S = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f613p;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.S = false;
    }

    @Override // f.d
    public final void e() {
        setQuery("", false);
        clearFocus();
        y(true);
        this.f613p.setImeOptions(this.f607a0);
        this.W = false;
    }

    public int getImeOptions() {
        return this.f613p.getImeOptions();
    }

    public int getInputType() {
        return this.f613p.getInputType();
    }

    public int getMaxWidth() {
        return this.T;
    }

    public CharSequence getQuery() {
        return this.f613p.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f608b0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.J : getContext().getText(this.f608b0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.G;
    }

    public int getSuggestionRowLayout() {
        return this.F;
    }

    public m0.b getSuggestionsAdapter() {
        return this.O;
    }

    public final Intent l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.V);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f609c0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f608b0.getSearchActivity());
        return intent;
    }

    public final Intent m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f609c0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void n() {
        int i4 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f613p;
        if (i4 >= 29) {
            a3.a(searchAutoComplete);
            return;
        }
        androidx.appcompat.app.c cVar = f606g0;
        cVar.getClass();
        androidx.appcompat.app.c.n();
        Object obj = cVar.f192a;
        if (((Method) obj) != null) {
            try {
                ((Method) obj).invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        cVar.getClass();
        androidx.appcompat.app.c.n();
        Object obj2 = cVar.f193b;
        if (((Method) obj2) != null) {
            try {
                ((Method) obj2).invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.f613p;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.M) {
            clearFocus();
            y(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f610d0);
        post(this.f611e0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            int[] iArr = this.B;
            SearchAutoComplete searchAutoComplete = this.f613p;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.C;
            getLocationInWindow(iArr2);
            int i8 = iArr[1] - iArr2[1];
            int i9 = iArr[0] - iArr2[0];
            Rect rect = this.f623z;
            rect.set(i9, i8, searchAutoComplete.getWidth() + i9, searchAutoComplete.getHeight() + i8);
            int i10 = rect.left;
            int i11 = rect.right;
            int i12 = i7 - i5;
            Rect rect2 = this.A;
            rect2.set(i10, 0, i11, i12);
            g3 g3Var = this.f622y;
            if (g3Var == null) {
                g3 g3Var2 = new g3(rect2, rect, searchAutoComplete);
                this.f622y = g3Var2;
                setTouchDelegate(g3Var2);
                return;
            }
            g3Var.f752b.set(rect2);
            Rect rect3 = g3Var.f754d;
            rect3.set(rect2);
            int i13 = -g3Var.f755e;
            rect3.inset(i13, i13);
            g3Var.f753c.set(rect);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r0 <= 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.N
            if (r0 == 0) goto L8
            super.onMeasure(r4, r5)
            return
        L8:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2e
            if (r0 == 0) goto L24
            if (r0 == r2) goto L1b
            goto L38
        L1b:
            int r0 = r3.T
            if (r0 <= 0) goto L38
        L1f:
            int r4 = java.lang.Math.min(r0, r4)
            goto L38
        L24:
            int r4 = r3.T
            if (r4 <= 0) goto L29
            goto L38
        L29:
            int r4 = r3.getPreferredWidth()
            goto L38
        L2e:
            int r0 = r3.T
            if (r0 <= 0) goto L33
            goto L1f
        L33:
            int r0 = r3.getPreferredWidth()
            goto L1f
        L38:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L4a
            if (r0 == 0) goto L45
            goto L52
        L45:
            int r5 = r3.getPreferredHeight()
            goto L52
        L4a:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L52:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        y(savedState.f624c);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, androidx.appcompat.widget.SearchView$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f624c = this.N;
        return absSavedState;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        post(this.f610d0);
    }

    public final void p(int i4) {
        int i5;
        Uri parse;
        String h4;
        Cursor cursor = this.O.f5436c;
        if (cursor != null && cursor.moveToPosition(i4)) {
            Intent intent = null;
            try {
                int i6 = i3.f784x;
                String h5 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (h5 == null) {
                    h5 = this.f608b0.getSuggestIntentAction();
                }
                if (h5 == null) {
                    h5 = "android.intent.action.SEARCH";
                }
                String h6 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (h6 == null) {
                    h6 = this.f608b0.getSuggestIntentData();
                }
                if (h6 != null && (h4 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    h6 = h6 + "/" + Uri.encode(h4);
                }
                if (h6 == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(h6);
                }
                intent = l(h5, parse, i3.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), i3.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e4) {
                try {
                    i5 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i5 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i5 + " returned exception.", e4);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e5) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e5);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f613p;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void q(int i4) {
        String c4;
        Editable text = this.f613p.getText();
        Cursor cursor = this.O.f5436c;
        if (cursor != null) {
            if (cursor.moveToPosition(i4) && (c4 = this.O.c(cursor)) != null) {
                setQuery(c4);
            } else {
                setQuery(text);
            }
        }
    }

    public final void r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i4, Rect rect) {
        if (this.S || !isFocusable()) {
            return false;
        }
        if (!this.N) {
            boolean requestFocus = this.f613p.requestFocus(i4, rect);
            if (requestFocus) {
                y(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i4, rect);
    }

    public final void s() {
        SearchAutoComplete searchAutoComplete = this.f613p;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f608b0 != null) {
                getContext().startActivity(l("android.intent.action.SEARCH", null, null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setAppSearchData(Bundle bundle) {
        this.f609c0 = bundle;
    }

    public void setIconified(boolean z4) {
        if (z4) {
            o();
            return;
        }
        y(false);
        SearchAutoComplete searchAutoComplete = this.f613p;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z4) {
        if (this.M == z4) {
            return;
        }
        this.M = z4;
        y(z4);
        v();
    }

    public void setImeOptions(int i4) {
        this.f613p.setImeOptions(i4);
    }

    public void setInputType(int i4) {
        this.f613p.setInputType(i4);
    }

    public void setMaxWidth(int i4) {
        this.T = i4;
        requestLayout();
    }

    public void setOnCloseListener(b3 b3Var) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.K = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c3 c3Var) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setOnSuggestionListener(d3 d3Var) {
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.Q = charSequence;
        v();
    }

    public void setQueryRefinementEnabled(boolean z4) {
        int i4;
        this.R = z4;
        m0.b bVar = this.O;
        if (bVar instanceof i3) {
            i3 i3Var = (i3) bVar;
            if (z4) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            i3Var.f793p = i4;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        int i4;
        this.f608b0 = searchableInfo;
        Intent intent = null;
        boolean z4 = true;
        SearchAutoComplete searchAutoComplete = this.f613p;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.f608b0.getImeOptions());
            int inputType = this.f608b0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.f608b0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            m0.b bVar = this.O;
            if (bVar != null) {
                bVar.b(null);
            }
            if (this.f608b0.getSuggestAuthority() != null) {
                i3 i3Var = new i3(getContext(), this, this.f608b0, this.f612f0);
                this.O = i3Var;
                searchAutoComplete.setAdapter(i3Var);
                i3 i3Var2 = (i3) this.O;
                if (this.R) {
                    i4 = 2;
                } else {
                    i4 = 1;
                }
                i3Var2.f793p = i4;
            }
            v();
        }
        SearchableInfo searchableInfo2 = this.f608b0;
        boolean z5 = false;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.f608b0.getVoiceSearchLaunchWebSearch()) {
                intent = this.H;
            } else if (this.f608b0.getVoiceSearchLaunchRecognizer()) {
                intent = this.I;
            }
            if (intent != null) {
                if (getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
                    z4 = false;
                }
                z5 = z4;
            }
        }
        this.U = z5;
        if (z5) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        y(this.N);
    }

    public void setSubmitButtonEnabled(boolean z4) {
        this.P = z4;
        y(this.N);
    }

    public void setSuggestionsAdapter(m0.b bVar) {
        this.O = bVar;
        this.f613p.setAdapter(bVar);
    }

    public final void t() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f613p.getText());
        if (!z5 && (!this.M || this.W)) {
            z4 = false;
        }
        int i4 = z4 ? 0 : 8;
        ImageView imageView = this.f619v;
        imageView.setVisibility(i4);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(z5 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void u() {
        int[] iArr = this.f613p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f615r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f616s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void v() {
        Drawable drawable;
        SpannableStringBuilder queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z4 = this.M;
        SearchAutoComplete searchAutoComplete = this.f613p;
        if (z4 && (drawable = this.E) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void w() {
        int i4;
        if ((this.P || this.U) && !this.N && (this.f618u.getVisibility() == 0 || this.f620w.getVisibility() == 0)) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        this.f616s.setVisibility(i4);
    }

    public final void x(boolean z4) {
        int i4;
        boolean z5 = this.P;
        if (z5 && ((z5 || this.U) && !this.N && hasFocus() && (z4 || !this.U))) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        this.f618u.setVisibility(i4);
    }

    public final void y(boolean z4) {
        int i4;
        int i5;
        int i6;
        this.N = z4;
        int i7 = 8;
        if (z4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f613p.getText());
        this.f617t.setVisibility(i4);
        x(!isEmpty);
        if (z4) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        this.f614q.setVisibility(i5);
        ImageView imageView = this.D;
        if (imageView.getDrawable() != null && !this.M) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        imageView.setVisibility(i6);
        t();
        if (this.U && !this.N && isEmpty) {
            this.f618u.setVisibility(8);
            i7 = 0;
        }
        this.f620w.setVisibility(i7);
        w();
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public void setQuery(CharSequence charSequence, boolean z4) {
        SearchAutoComplete searchAutoComplete = this.f613p;
        searchAutoComplete.setText(charSequence);
        if (charSequence != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.V = charSequence;
        }
        if (!z4 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        s();
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f623z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.f610d0 = new t2(this, 0);
        this.f611e0 = new t2(this, 1);
        this.f612f0 = new WeakHashMap();
        w2 w2Var = new w2(this);
        x2 x2Var = new x2(this);
        y2 y2Var = new y2(this);
        z2 z2Var = new z2(0, this);
        z1 z1Var = new z1(1, this);
        s2 s2Var = new s2(this, 0);
        int[] iArr = c.a.f2565w;
        q3 f4 = q3.f(context, attributeSet, iArr, i4, 0);
        i0.y0.o(this, context, iArr, attributeSet, f4.f879b, i4);
        LayoutInflater from = LayoutInflater.from(context);
        TypedArray typedArray = f4.f879b;
        from.inflate(typedArray.getResourceId(19, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f613p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f614q = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.f615r = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.f616s = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f617t = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f618u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f619v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f620w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.D = imageView5;
        i0.g0.q(findViewById, f4.b(20));
        i0.g0.q(findViewById2, f4.b(25));
        imageView.setImageDrawable(f4.b(23));
        imageView2.setImageDrawable(f4.b(15));
        imageView3.setImageDrawable(f4.b(12));
        imageView4.setImageDrawable(f4.b(28));
        imageView5.setImageDrawable(f4.b(23));
        this.E = f4.b(22);
        com.google.common.collect.c.V1(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.F = typedArray.getResourceId(26, R.layout.abc_search_dropdown_item_icons_2line);
        this.G = typedArray.getResourceId(13, 0);
        imageView.setOnClickListener(w2Var);
        imageView3.setOnClickListener(w2Var);
        imageView2.setOnClickListener(w2Var);
        imageView4.setOnClickListener(w2Var);
        searchAutoComplete.setOnClickListener(w2Var);
        searchAutoComplete.addTextChangedListener(s2Var);
        searchAutoComplete.setOnEditorActionListener(y2Var);
        searchAutoComplete.setOnItemClickListener(z2Var);
        searchAutoComplete.setOnItemSelectedListener(z1Var);
        searchAutoComplete.setOnKeyListener(x2Var);
        searchAutoComplete.setOnFocusChangeListener(new u2(this));
        setIconifiedByDefault(typedArray.getBoolean(18, true));
        int dimensionPixelSize = typedArray.getDimensionPixelSize(2, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.J = typedArray.getText(14);
        this.Q = typedArray.getText(21);
        int i5 = typedArray.getInt(6, -1);
        if (i5 != -1) {
            setImeOptions(i5);
        }
        int i6 = typedArray.getInt(5, -1);
        if (i6 != -1) {
            setInputType(i6);
        }
        setFocusable(typedArray.getBoolean(1, true));
        f4.g();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f621x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new v2(0, this));
        }
        y(this.M);
        v();
    }
}