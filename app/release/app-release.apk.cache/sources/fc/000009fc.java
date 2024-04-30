package v3;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final d f6997a = new Handler();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int i4;
        int min;
        com.google.common.collect.c.F(logRecord, "record");
        CopyOnWriteArraySet copyOnWriteArraySet = c.f6995a;
        String loggerName = logRecord.getLoggerName();
        com.google.common.collect.c.E(loggerName, "record.loggerName");
        int intValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (intValue > level.intValue()) {
            i4 = 5;
        } else if (logRecord.getLevel().intValue() == level.intValue()) {
            i4 = 4;
        } else {
            i4 = 3;
        }
        String message = logRecord.getMessage();
        com.google.common.collect.c.E(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        String str = (String) c.f6996b.get(loggerName);
        if (str == null) {
            str = l3.h.D2(loggerName, 23);
        }
        if (Log.isLoggable(str, i4)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i5 = 0;
            while (i5 < length) {
                int t22 = kotlin.text.b.t2(message, '\n', i5, false, 4);
                if (t22 == -1) {
                    t22 = length;
                }
                while (true) {
                    min = Math.min(t22, i5 + 4000);
                    String substring = message.substring(i5, min);
                    com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i4, str, substring);
                    if (min >= t22) {
                        break;
                    }
                    i5 = min;
                }
                i5 = min + 1;
            }
        }
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}