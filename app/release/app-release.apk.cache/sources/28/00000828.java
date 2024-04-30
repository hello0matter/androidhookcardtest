package kotlin.text;

import com.google.common.collect.c;
import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0006\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "androidx/fragment/app/m0", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,396:1\n22#2,3:397\n1#3:400\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n102#1:397,3\n*E\n"})
/* loaded from: classes.dex */
public final class Regex implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Pattern f5200a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes.dex */
    public static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a  reason: collision with root package name */
        public final String f5201a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5202b;

        public Serialized(String str, int i4) {
            this.f5201a = str;
            this.f5202b = i4;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f5201a, this.f5202b);
            c.E(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    public Regex(String str) {
        Pattern compile = Pattern.compile(str);
        c.E(compile, "compile(pattern)");
        this.f5200a = compile;
    }

    private final Object writeReplace() {
        Pattern pattern = this.f5200a;
        String pattern2 = pattern.pattern();
        c.E(pattern2, "nativePattern.pattern()");
        return new Serialized(pattern2, pattern.flags());
    }

    public final String toString() {
        String pattern = this.f5200a.toString();
        c.E(pattern, "nativePattern.toString()");
        return pattern;
    }

    public Regex(Pattern pattern) {
        this.f5200a = pattern;
    }
}