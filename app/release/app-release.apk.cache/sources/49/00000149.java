package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.msphone.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i3 extends m0.b implements View.OnClickListener {

    /* renamed from: x  reason: collision with root package name */
    public static final /* synthetic */ int f784x = 0;

    /* renamed from: h  reason: collision with root package name */
    public final int f785h;

    /* renamed from: i  reason: collision with root package name */
    public final int f786i;

    /* renamed from: j  reason: collision with root package name */
    public final LayoutInflater f787j;

    /* renamed from: k  reason: collision with root package name */
    public final SearchView f788k;

    /* renamed from: l  reason: collision with root package name */
    public final SearchableInfo f789l;

    /* renamed from: m  reason: collision with root package name */
    public final Context f790m;

    /* renamed from: n  reason: collision with root package name */
    public final WeakHashMap f791n;

    /* renamed from: o  reason: collision with root package name */
    public final int f792o;

    /* renamed from: p  reason: collision with root package name */
    public int f793p;

    /* renamed from: q  reason: collision with root package name */
    public ColorStateList f794q;

    /* renamed from: r  reason: collision with root package name */
    public int f795r;

    /* renamed from: s  reason: collision with root package name */
    public int f796s;

    /* renamed from: t  reason: collision with root package name */
    public int f797t;

    /* renamed from: u  reason: collision with root package name */
    public int f798u;

    /* renamed from: v  reason: collision with root package name */
    public int f799v;

    /* renamed from: w  reason: collision with root package name */
    public int f800w;

    public i3(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f5435b = true;
        this.f5436c = null;
        this.f5434a = false;
        this.f5437d = -1;
        this.f5438e = new m0.a(this);
        this.f5439f = new c2(1, this);
        this.f786i = suggestionRowLayout;
        this.f785h = suggestionRowLayout;
        this.f787j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f793p = 1;
        this.f795r = -1;
        this.f796s = -1;
        this.f797t = -1;
        this.f798u = -1;
        this.f799v = -1;
        this.f800w = -1;
        this.f788k = searchView;
        this.f789l = searchableInfo;
        this.f792o = searchView.getSuggestionCommitIconResId();
        this.f790m = context;
        this.f791n = weakHashMap;
    }

    public static String h(Cursor cursor, int i4) {
        if (i4 == -1) {
            return null;
        }
        try {
            return cursor.getString(i4);
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e4);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0142  */
    @Override // m0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r22, android.database.Cursor r23) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i3.a(android.view.View, android.database.Cursor):void");
    }

    @Override // m0.b
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f795r = cursor.getColumnIndex("suggest_text_1");
                this.f796s = cursor.getColumnIndex("suggest_text_2");
                this.f797t = cursor.getColumnIndex("suggest_text_2_url");
                this.f798u = cursor.getColumnIndex("suggest_icon_1");
                this.f799v = cursor.getColumnIndex("suggest_icon_2");
                this.f800w = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e4);
        }
    }

    @Override // m0.b
    public final String c(Cursor cursor) {
        String h4;
        String h5;
        if (cursor == null) {
            return null;
        }
        String h6 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (h6 != null) {
            return h6;
        }
        SearchableInfo searchableInfo = this.f789l;
        if (searchableInfo.shouldRewriteQueryFromData() && (h5 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return h5;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (h4 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return h4;
    }

    @Override // m0.b
    public final View d(ViewGroup viewGroup) {
        View inflate = this.f787j.inflate(this.f785h, viewGroup, false);
        inflate.setTag(new h3(inflate));
        ((ImageView) inflate.findViewById(R.id.edit_query)).setImageResource(this.f792o);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f790m.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size != 2) {
                throw new FileNotFoundException("More than two path segments: " + uri);
            } else {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable f(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i3.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f790m.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // m0.b, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View inflate = this.f787j.inflate(this.f786i, viewGroup, false);
            if (inflate != null) {
                ((h3) inflate.getTag()).f765a.setText(e4.toString());
            }
            return inflate;
        }
    }

    @Override // m0.b, android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View d4 = d(viewGroup);
            ((h3) d4.getTag()).f765a.setText(e4.toString());
            return d4;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.f5436c;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f5436c;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f788k.r((CharSequence) tag);
        }
    }
}