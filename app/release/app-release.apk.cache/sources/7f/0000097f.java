package s0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.widget.l3;
import androidx.emoji2.text.o;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class a extends l2.f {

    /* renamed from: c  reason: collision with root package name */
    public final EditText f6496c;

    /* renamed from: d  reason: collision with root package name */
    public final j f6497d;

    /* JADX WARN: Type inference failed for: r2v1, types: [android.text.Editable$Factory, s0.c] */
    public a(EditText editText) {
        super(10, 0);
        this.f6496c = editText;
        j jVar = new j(editText);
        this.f6497d = jVar;
        editText.addTextChangedListener(jVar);
        if (c.f6500b == null) {
            synchronized (c.f6499a) {
                try {
                    if (c.f6500b == null) {
                        ?? factory = new Editable.Factory();
                        try {
                            c.f6501c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, c.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        c.f6500b = factory;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(c.f6500b);
    }

    @Override // l2.f
    public final void r(boolean z4) {
        j jVar = this.f6497d;
        if (jVar.f6517d != z4) {
            if (jVar.f6516c != null) {
                o a5 = o.a();
                l3 l3Var = jVar.f6516c;
                a5.getClass();
                h0.e.c(l3Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a5.f1527a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a5.f1528b.remove(l3Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            jVar.f6517d = z4;
            if (z4) {
                j.a(jVar.f6514a, o.a().b());
            }
        }
    }

    public final KeyListener u(KeyListener keyListener) {
        if (keyListener instanceof g) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        return new g(keyListener);
    }

    public final InputConnection v(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection instanceof d) {
            return inputConnection;
        }
        return new d(this.f6496c, inputConnection, editorInfo);
    }
}