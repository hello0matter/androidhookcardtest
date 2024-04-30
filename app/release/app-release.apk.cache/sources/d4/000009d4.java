package u2;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class b implements Closeable, Flushable {

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f6897h = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f6898i = new String[128];

    /* renamed from: a  reason: collision with root package name */
    public final Writer f6899a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f6900b;

    /* renamed from: c  reason: collision with root package name */
    public int f6901c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6902d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6903e;

    /* renamed from: f  reason: collision with root package name */
    public String f6904f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6905g;

    static {
        for (int i4 = 0; i4 <= 31; i4++) {
            f6898i[i4] = String.format("\\u%04x", Integer.valueOf(i4));
        }
        String[] strArr = f6898i;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(StringWriter stringWriter) {
        int[] iArr = new int[32];
        this.f6900b = iArr;
        this.f6901c = 0;
        if (iArr.length == 0) {
            this.f6900b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f6900b;
        int i4 = this.f6901c;
        this.f6901c = i4 + 1;
        iArr2[i4] = 6;
        this.f6902d = ":";
        this.f6905g = true;
        this.f6899a = stringWriter;
    }

    public final void A() {
        if (this.f6904f != null) {
            if (this.f6905g) {
                F();
            } else {
                this.f6904f = null;
                return;
            }
        }
        x();
        this.f6899a.write("null");
    }

    public final int B() {
        int i4 = this.f6901c;
        if (i4 != 0) {
            return this.f6900b[i4 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C(java.lang.String r8) {
        /*
            r7 = this;
            java.io.Writer r0 = r7.f6899a
            r1 = 34
            r0.write(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L3a
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1e
            java.lang.String[] r6 = u2.b.f6898i
            r5 = r6[r5]
            if (r5 != 0) goto L2b
            goto L37
        L1e:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L25
            java.lang.String r5 = "\\u2028"
            goto L2b
        L25:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L37
            java.lang.String r5 = "\\u2029"
        L2b:
            if (r4 >= r3) goto L32
            int r6 = r3 - r4
            r0.write(r8, r4, r6)
        L32:
            r0.write(r5)
            int r4 = r3 + 1
        L37:
            int r3 = r3 + 1
            goto Ld
        L3a:
            if (r4 >= r2) goto L40
            int r2 = r2 - r4
            r0.write(r8, r4, r2)
        L40:
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.b.C(java.lang.String):void");
    }

    public final void D(long j4) {
        F();
        x();
        this.f6899a.write(Long.toString(j4));
    }

    public final void E(String str) {
        if (str == null) {
            A();
            return;
        }
        F();
        x();
        C(str);
    }

    public final void F() {
        if (this.f6904f != null) {
            int B = B();
            if (B == 5) {
                this.f6899a.write(44);
            } else if (B != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            this.f6900b[this.f6901c - 1] = 4;
            C(this.f6904f);
            this.f6904f = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6899a.close();
        int i4 = this.f6901c;
        if (i4 <= 1 && (i4 != 1 || this.f6900b[i4 - 1] == 7)) {
            this.f6901c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // java.io.Flushable
    public final void flush() {
        if (this.f6901c != 0) {
            this.f6899a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void x() {
        int B = B();
        if (B != 1) {
            Writer writer = this.f6899a;
            if (B != 2) {
                if (B != 4) {
                    if (B != 6) {
                        if (B == 7) {
                            if (!this.f6903e) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    this.f6900b[this.f6901c - 1] = 7;
                    return;
                }
                writer.append((CharSequence) this.f6902d);
                this.f6900b[this.f6901c - 1] = 5;
                return;
            }
            writer.append(',');
            return;
        }
        this.f6900b[this.f6901c - 1] = 2;
    }

    public final void y(int i4, int i5, char c4) {
        int B = B();
        if (B != i5 && B != i4) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f6904f == null) {
            this.f6901c--;
            this.f6899a.write(c4);
            return;
        }
        throw new IllegalStateException("Dangling name: " + this.f6904f);
    }

    public final void z(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f6904f == null) {
            if (this.f6901c != 0) {
                this.f6904f = str;
                return;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }
}