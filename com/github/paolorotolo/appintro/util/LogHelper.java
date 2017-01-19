package com.github.paolorotolo.appintro.util;

import android.util.Log;

public class LogHelper {
    private static final String LOG_PREFIX = "Log: ";
    private static final int LOG_PREFIX_LENGTH;
    private static final int MAX_LOG_TAG_LENGTH = 23;

    static {
        LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    }

    private static String makeLogTag(String str) {
        if (str.length() > 23 - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(LOG_PREFIX_LENGTH, (23 - LOG_PREFIX_LENGTH) - 1);
        }
        return LOG_PREFIX + str;
    }

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    public static void m19v(String tag, Object... messages) {
    }

    public static void m15d(String tag, Object... messages) {
    }

    public static void m18i(String tag, Object... messages) {
        log(tag, 4, null, messages);
    }

    public static void m21w(String tag, Object... messages) {
        log(tag, 5, null, messages);
    }

    public static void m20w(String tag, Throwable t, Object... messages) {
        log(tag, 5, t, messages);
    }

    public static void m17e(String tag, Object... messages) {
        log(tag, 6, null, messages);
    }

    public static void m16e(String tag, Throwable t, Object... messages) {
        log(tag, 6, t, messages);
    }

    private static void log(String tag, int level, Throwable t, Object... messages) {
        String message;
        int i = LOG_PREFIX_LENGTH;
        if (t == null && messages != null && messages.length == 1) {
            message = messages[LOG_PREFIX_LENGTH].toString();
        } else {
            StringBuilder sb = new StringBuilder();
            if (messages != null) {
                int length = messages.length;
                while (i < length) {
                    sb.append(messages[i]);
                    i++;
                }
            }
            if (t != null) {
                sb.append("\n").append(Log.getStackTraceString(t));
            }
            message = sb.toString();
        }
        Log.println(level, tag, message);
    }
}
