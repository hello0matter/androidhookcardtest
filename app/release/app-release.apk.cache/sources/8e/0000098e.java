package s2;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class c implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public d f6522a;

    /* renamed from: b  reason: collision with root package name */
    public d f6523b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f6524c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LinkedTreeMap f6525d;

    public c(LinkedTreeMap linkedTreeMap) {
        this.f6525d = linkedTreeMap;
        this.f6522a = linkedTreeMap.f4220f.f6529d;
        this.f6524c = linkedTreeMap.f4219e;
    }

    public final d a() {
        d dVar = this.f6522a;
        LinkedTreeMap linkedTreeMap = this.f6525d;
        if (dVar != linkedTreeMap.f4220f) {
            if (linkedTreeMap.f4219e == this.f6524c) {
                this.f6522a = dVar.f6529d;
                this.f6523b = dVar;
                return dVar;
            }
            throw new ConcurrentModificationException();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6522a != this.f6525d.f4220f) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final void remove() {
        d dVar = this.f6523b;
        if (dVar != null) {
            LinkedTreeMap linkedTreeMap = this.f6525d;
            linkedTreeMap.c(dVar, true);
            this.f6523b = null;
            this.f6524c = linkedTreeMap.f4219e;
            return;
        }
        throw new IllegalStateException();
    }
}