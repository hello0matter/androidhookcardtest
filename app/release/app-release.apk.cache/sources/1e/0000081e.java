package kotlin.jvm.internal;

import androidx.activity.j;
import androidx.activity.w;
import com.google.common.collect.c;
import f3.e;
import j3.b;

/* loaded from: classes.dex */
public abstract class FunctionReference extends CallableReference implements b {

    /* renamed from: g  reason: collision with root package name */
    public final int f5195g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5196h;

    public FunctionReference(w wVar) {
        super(wVar, false);
        this.f5195g = 0;
        this.f5196h = 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (this.f5191d.equals(functionReference.f5191d) && this.f5192e.equals(functionReference.f5192e) && this.f5196h == functionReference.f5196h && this.f5195g == functionReference.f5195g && c.n(this.f5189b, functionReference.f5189b) && c.n(b(), functionReference.b())) {
                return true;
            }
            return false;
        } else if (!(obj instanceof b)) {
            return false;
        } else {
            FunctionReference functionReference2 = this.f5188a;
            if (functionReference2 == null) {
                e.f4578a.getClass();
                this.f5188a = this;
                functionReference2 = this;
            }
            return obj.equals(functionReference2);
        }
    }

    public final int hashCode() {
        return this.f5192e.hashCode() + ((this.f5191d.hashCode() + (b() == null ? 0 : b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        FunctionReference functionReference = this.f5188a;
        if (functionReference == null) {
            e.f4578a.getClass();
            this.f5188a = this;
            functionReference = this;
        }
        if (functionReference != this) {
            return functionReference.toString();
        }
        String str = this.f5191d;
        if ("<init>".equals(str)) {
            return "constructor (Kotlin reflection is not available)";
        }
        return j.d("function ", str, " (Kotlin reflection is not available)");
    }
}