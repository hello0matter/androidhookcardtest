package e1;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final l.b f4430a;

    /* renamed from: b  reason: collision with root package name */
    public final l.b f4431b;

    /* renamed from: c  reason: collision with root package name */
    public final l.b f4432c;

    public a(l.b bVar, l.b bVar2, l.b bVar3) {
        this.f4430a = bVar;
        this.f4431b = bVar2;
        this.f4432c = bVar3;
    }

    public abstract b a();

    public final Class b(Class cls) {
        String name = cls.getName();
        l.b bVar = this.f4432c;
        Class cls2 = (Class) bVar.getOrDefault(name, null);
        if (cls2 == null) {
            String name2 = cls.getPackage().getName();
            String simpleName = cls.getSimpleName();
            Class<?> cls3 = Class.forName(name2 + "." + simpleName + "Parcelizer", false, cls.getClassLoader());
            bVar.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public final Method c(String str) {
        l.b bVar = this.f4430a;
        Method method = (Method) bVar.getOrDefault(str, null);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
            bVar.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        l.b bVar = this.f4431b;
        Method method = (Method) bVar.getOrDefault(name, null);
        if (method == null) {
            Class b5 = b(cls);
            System.currentTimeMillis();
            Method declaredMethod = b5.getDeclaredMethod("write", cls, a.class);
            bVar.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public abstract boolean e(int i4);

    public final Parcelable f(Parcelable parcelable, int i4) {
        if (!e(i4)) {
            return parcelable;
        }
        return ((b) this).f4434e.readParcelable(b.class.getClassLoader());
    }

    public final c g() {
        String readString = ((b) this).f4434e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (c) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e7.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
        }
    }

    public abstract void h(int i4);

    public final void i(c cVar) {
        if (cVar == null) {
            ((b) this).f4434e.writeString(null);
            return;
        }
        try {
            ((b) this).f4434e.writeString(b(cVar.getClass()).getName());
            b a5 = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, a5);
                int i4 = a5.f4438i;
                if (i4 >= 0) {
                    int i5 = a5.f4433d.get(i4);
                    Parcel parcel = a5.f4434e;
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i5);
                    parcel.writeInt(dataPosition - i5);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
            } catch (InvocationTargetException e7) {
                if (e7.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e7.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e8);
        }
    }
}