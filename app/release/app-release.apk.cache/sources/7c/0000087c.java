package m0;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.activity.j;
import androidx.appcompat.widget.c2;
import androidx.appcompat.widget.i3;

/* loaded from: classes.dex */
public abstract class b extends BaseAdapter implements Filterable, c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5434a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5435b;

    /* renamed from: c  reason: collision with root package name */
    public Cursor f5436c;

    /* renamed from: d  reason: collision with root package name */
    public int f5437d;

    /* renamed from: e  reason: collision with root package name */
    public a f5438e;

    /* renamed from: f  reason: collision with root package name */
    public c2 f5439f;

    /* renamed from: g  reason: collision with root package name */
    public d f5440g;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f5436c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f5438e;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                c2 c2Var = this.f5439f;
                if (c2Var != null) {
                    cursor2.unregisterDataSetObserver(c2Var);
                }
            }
            this.f5436c = cursor;
            if (cursor != null) {
                a aVar2 = this.f5438e;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                c2 c2Var2 = this.f5439f;
                if (c2Var2 != null) {
                    cursor.registerDataSetObserver(c2Var2);
                }
                this.f5437d = cursor.getColumnIndexOrThrow("_id");
                this.f5434a = true;
                notifyDataSetChanged();
            } else {
                this.f5437d = -1;
                this.f5434a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (this.f5434a && (cursor = this.f5436c) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        if (this.f5434a) {
            this.f5436c.moveToPosition(i4);
            if (view == null) {
                i3 i3Var = (i3) this;
                view = i3Var.f787j.inflate(i3Var.f786i, viewGroup, false);
            }
            a(view, this.f5436c);
            return view;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Filter, m0.d] */
    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f5440g == null) {
            ?? filter = new Filter();
            filter.f5441a = this;
            this.f5440g = filter;
        }
        return this.f5440g;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        Cursor cursor;
        if (this.f5434a && (cursor = this.f5436c) != null) {
            cursor.moveToPosition(i4);
            return this.f5436c;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        Cursor cursor;
        if (!this.f5434a || (cursor = this.f5436c) == null || !cursor.moveToPosition(i4)) {
            return 0L;
        }
        return this.f5436c.getLong(this.f5437d);
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (this.f5434a) {
            if (this.f5436c.moveToPosition(i4)) {
                if (view == null) {
                    view = d(viewGroup);
                }
                a(view, this.f5436c);
                return view;
            }
            throw new IllegalStateException(j.b("couldn't move cursor to position ", i4));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}