package u2;

import androidx.annotation.VisibleForTesting;
import com.google.gson.stream.JsonToken;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final Reader f6882a;

    /* renamed from: i  reason: collision with root package name */
    public long f6890i;

    /* renamed from: j  reason: collision with root package name */
    public int f6891j;

    /* renamed from: k  reason: collision with root package name */
    public String f6892k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f6893l;

    /* renamed from: n  reason: collision with root package name */
    public String[] f6895n;

    /* renamed from: o  reason: collision with root package name */
    public int[] f6896o;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6883b = false;

    /* renamed from: c  reason: collision with root package name */
    public final char[] f6884c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    public int f6885d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6886e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f6887f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f6888g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f6889h = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f6894m = 1;

    public a(StringReader stringReader) {
        int[] iArr = new int[32];
        this.f6893l = iArr;
        iArr[0] = 6;
        this.f6895n = new String[32];
        this.f6896o = new int[32];
        this.f6882a = stringReader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0199, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0213, code lost:
        if (F(r1) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0216, code lost:
        if (r5 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0218, code lost:
        if (r14 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x021e, code lost:
        if (r9 != Long.MIN_VALUE) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0220, code lost:
        if (r16 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0223, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0227, code lost:
        if (r9 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0229, code lost:
        if (r16 != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x022b, code lost:
        if (r16 == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x022e, code lost:
        r9 = -r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x022f, code lost:
        r20.f6890i = r9;
        r20.f6885d += r8;
        r9 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0238, code lost:
        r20.f6889h = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x023b, code lost:
        if (r5 == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x023e, code lost:
        if (r5 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0241, code lost:
        if (r5 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0243, code lost:
        r20.f6891j = r8;
        r9 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0279 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A() {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.a.A():int");
    }

    public final void B() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 4) {
            int i5 = this.f6894m;
            this.f6894m = i5 - 1;
            int[] iArr = this.f6896o;
            int i6 = i5 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.f6889h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + P() + G());
    }

    public final void C() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 2) {
            int i5 = this.f6894m;
            int i6 = i5 - 1;
            this.f6894m = i6;
            this.f6895n[i6] = null;
            int[] iArr = this.f6896o;
            int i7 = i5 - 2;
            iArr[i7] = iArr[i7] + 1;
            this.f6889h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + P() + G());
    }

    public final boolean D(int i4) {
        int i5;
        int i6;
        int i7 = this.f6888g;
        int i8 = this.f6885d;
        this.f6888g = i7 - i8;
        int i9 = this.f6886e;
        char[] cArr = this.f6884c;
        if (i9 != i8) {
            int i10 = i9 - i8;
            this.f6886e = i10;
            System.arraycopy(cArr, i8, cArr, 0, i10);
        } else {
            this.f6886e = 0;
        }
        this.f6885d = 0;
        do {
            int i11 = this.f6886e;
            int read = this.f6882a.read(cArr, i11, cArr.length - i11);
            if (read == -1) {
                return false;
            }
            i5 = this.f6886e + read;
            this.f6886e = i5;
            if (this.f6887f == 0 && (i6 = this.f6888g) == 0 && i5 > 0 && cArr[0] == 65279) {
                this.f6885d++;
                this.f6888g = i6 + 1;
                i4++;
                continue;
            }
        } while (i5 < i4);
        return true;
    }

    public final String E(boolean z4) {
        StringBuilder sb = new StringBuilder("$");
        int i4 = 0;
        while (true) {
            int i5 = this.f6894m;
            if (i4 < i5) {
                int i6 = this.f6893l[i4];
                if (i6 != 1 && i6 != 2) {
                    if (i6 == 3 || i6 == 4 || i6 == 5) {
                        sb.append('.');
                        String str = this.f6895n[i4];
                        if (str != null) {
                            sb.append(str);
                        }
                    }
                } else {
                    int i7 = this.f6896o[i4];
                    if (z4 && i7 > 0 && i4 == i5 - 1) {
                        i7--;
                    }
                    sb.append('[');
                    sb.append(i7);
                    sb.append(']');
                }
                i4++;
            } else {
                return sb.toString();
            }
        }
    }

    public final boolean F(char c4) {
        if (c4 != '\t' && c4 != '\n' && c4 != '\f' && c4 != '\r' && c4 != ' ') {
            if (c4 != '#') {
                if (c4 != ',') {
                    if (c4 != '/' && c4 != '=') {
                        if (c4 != '{' && c4 != '}' && c4 != ':') {
                            if (c4 != ';') {
                                switch (c4) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            z();
            return false;
        }
        return false;
    }

    public final String G() {
        return " at line " + (this.f6887f + 1) + " column " + ((this.f6885d - this.f6888g) + 1) + " path " + E(false);
    }

    public final boolean H() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 5) {
            this.f6889h = 0;
            int[] iArr = this.f6896o;
            int i5 = this.f6894m - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i4 == 6) {
            this.f6889h = 0;
            int[] iArr2 = this.f6896o;
            int i6 = this.f6894m - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + P() + G());
        }
    }

    public final int I() {
        char c4;
        String M;
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 15) {
            long j4 = this.f6890i;
            int i5 = (int) j4;
            if (j4 == i5) {
                this.f6889h = 0;
                int[] iArr = this.f6896o;
                int i6 = this.f6894m - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.f6890i + G());
        }
        if (i4 == 16) {
            this.f6892k = new String(this.f6884c, this.f6885d, this.f6891j);
            this.f6885d += this.f6891j;
        } else if (i4 != 8 && i4 != 9 && i4 != 10) {
            throw new IllegalStateException("Expected an int but was " + P() + G());
        } else {
            if (i4 == 10) {
                M = O();
            } else {
                if (i4 == 8) {
                    c4 = '\'';
                } else {
                    c4 = '\"';
                }
                M = M(c4);
            }
            this.f6892k = M;
            try {
                int parseInt = Integer.parseInt(this.f6892k);
                this.f6889h = 0;
                int[] iArr2 = this.f6896o;
                int i7 = this.f6894m - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6889h = 11;
        double parseDouble = Double.parseDouble(this.f6892k);
        int i8 = (int) parseDouble;
        if (i8 == parseDouble) {
            this.f6892k = null;
            this.f6889h = 0;
            int[] iArr3 = this.f6896o;
            int i9 = this.f6894m - 1;
            iArr3[i9] = iArr3[i9] + 1;
            return i8;
        }
        throw new NumberFormatException("Expected an int but was " + this.f6892k + G());
    }

    public final String J() {
        char c4;
        String M;
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 14) {
            M = O();
        } else {
            if (i4 == 12) {
                c4 = '\'';
            } else if (i4 == 13) {
                c4 = '\"';
            } else {
                throw new IllegalStateException("Expected a name but was " + P() + G());
            }
            M = M(c4);
        }
        this.f6889h = 0;
        this.f6895n[this.f6894m - 1] = M;
        return M;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
        if (r1 == '/') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int K(boolean r10) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.a.K(boolean):int");
    }

    public final void L() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 7) {
            this.f6889h = 0;
            int[] iArr = this.f6896o;
            int i5 = this.f6894m - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + P() + G());
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00fe, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r11.f6885d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r1 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        r1.append(r7, r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r11.f6885d != r11.f6886e) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (D(1) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
        S("Unterminated escape sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        r2 = r11.f6885d;
        r3 = r2 + 1;
        r11.f6885d = r3;
        r6 = r7[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r6 == '\n') goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r6 == '\"') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r6 == '\'') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r6 == '/') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        if (r6 == '\\') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
        if (r6 == 'b') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
        if (r6 == 'f') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        if (r6 == 'n') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
        if (r6 == 'r') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
        if (r6 == 't') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r6 != 'u') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
        if ((r2 + 5) <= r11.f6886e) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0092, code lost:
        if (D(4) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
        S("Unterminated escape sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0098, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
        r2 = r11.f6885d;
        r4 = r2 + 4;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
        if (r2 >= r4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a1, code lost:
        r5 = r7[r2];
        r8 = (char) (r9 << 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
        if (r5 < '0') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ac, code lost:
        if (r5 > '9') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ae, code lost:
        r5 = r5 - '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b0, code lost:
        r9 = (char) (r5 + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
        if (r5 < 'a') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b8, code lost:
        if (r5 > 'f') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ba, code lost:
        r5 = r5 - 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bf, code lost:
        if (r5 < 'A') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c3, code lost:
        if (r5 > 'F') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c5, code lost:
        r5 = r5 - '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c8, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00dd, code lost:
        throw new java.lang.NumberFormatException("\\u".concat(new java.lang.String(r7, r11.f6885d, 4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00de, code lost:
        r11.f6885d += 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e4, code lost:
        S("Invalid escape sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e9, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ea, code lost:
        r9 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ed, code lost:
        r9 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f0, code lost:
        r9 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f3, code lost:
        r9 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f6, code lost:
        r11.f6887f++;
        r11.f6888g = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fd, code lost:
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0113, code lost:
        if (r1 != null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0115, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0123, code lost:
        r1.append(r7, r3, r2 - r3);
        r11.f6885d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String M(char r12) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.a.M(char):java.lang.String");
    }

    public final String N() {
        String str;
        char c4;
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 10) {
            str = O();
        } else {
            if (i4 == 8) {
                c4 = '\'';
            } else if (i4 == 9) {
                c4 = '\"';
            } else if (i4 == 11) {
                str = this.f6892k;
                this.f6892k = null;
            } else if (i4 == 15) {
                str = Long.toString(this.f6890i);
            } else if (i4 == 16) {
                str = new String(this.f6884c, this.f6885d, this.f6891j);
                this.f6885d += this.f6891j;
            } else {
                throw new IllegalStateException("Expected a string but was " + P() + G());
            }
            str = M(c4);
        }
        this.f6889h = 0;
        int[] iArr = this.f6896o;
        int i5 = this.f6894m - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        z();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String O() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f6885d
            int r4 = r3 + r2
            int r5 = r7.f6886e
            char[] r6 = r7.f6884c
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.z()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.D(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f6885d
            r0.append(r6, r3, r2)
            int r3 = r7.f6885d
            int r3 = r3 + r2
            r7.f6885d = r3
            r2 = 1
            boolean r2 = r7.D(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f6885d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f6885d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f6885d
            int r2 = r2 + r1
            r7.f6885d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.a.O():java.lang.String");
    }

    public final JsonToken P() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        switch (i4) {
            case 1:
                return JsonToken.f4225c;
            case 2:
                return JsonToken.f4226d;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return JsonToken.f4223a;
            case VisibleForTesting.PROTECTED /* 4 */:
                return JsonToken.f4224b;
            case VisibleForTesting.NONE /* 5 */:
            case 6:
                return JsonToken.f4230h;
            case 7:
                return JsonToken.f4231i;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.f4228f;
            case 12:
            case 13:
            case 14:
                return JsonToken.f4227e;
            case 15:
            case 16:
                return JsonToken.f4229g;
            case 17:
                return JsonToken.f4232j;
            default:
                throw new AssertionError();
        }
    }

    public final void Q(int i4) {
        int i5 = this.f6894m;
        int[] iArr = this.f6893l;
        if (i5 == iArr.length) {
            int i6 = i5 * 2;
            this.f6893l = Arrays.copyOf(iArr, i6);
            this.f6896o = Arrays.copyOf(this.f6896o, i6);
            this.f6895n = (String[]) Arrays.copyOf(this.f6895n, i6);
        }
        int[] iArr2 = this.f6893l;
        int i7 = this.f6894m;
        this.f6894m = i7 + 1;
        iArr2[i7] = i4;
    }

    public final void R() {
        char c4;
        do {
            if (this.f6885d < this.f6886e || D(1)) {
                int i4 = this.f6885d;
                int i5 = i4 + 1;
                this.f6885d = i5;
                c4 = this.f6884c[i4];
                if (c4 == '\n') {
                    this.f6887f++;
                    this.f6888g = i5;
                    return;
                }
            } else {
                return;
            }
        } while (c4 != '\r');
    }

    public final void S(String str) {
        throw new IOException(str + G());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6889h = 0;
        this.f6893l[0] = 8;
        this.f6894m = 1;
        this.f6882a.close();
    }

    public final String toString() {
        return a.class.getSimpleName() + G();
    }

    public final void x() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 3) {
            Q(1);
            this.f6896o[this.f6894m - 1] = 0;
            this.f6889h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + P() + G());
    }

    public final void y() {
        int i4 = this.f6889h;
        if (i4 == 0) {
            i4 = A();
        }
        if (i4 == 1) {
            Q(3);
            this.f6889h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + P() + G());
    }

    public final void z() {
        if (this.f6883b) {
            return;
        }
        S("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }
}