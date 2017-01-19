package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class zztu {
    private static final String[] zzagy;
    private static final Map<String, Integer> zzagz;

    static {
        int i = 0;
        zzagy = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
        zzagz = new HashMap(zzagy.length);
        while (i < zzagy.length) {
            zzagz.put(zzagy[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzaN(int i) {
        return (i < 0 || i >= zzagy.length) ? null : zzagy[i];
    }

    public static int zzcl(String str) {
        Integer num = (Integer) zzagz.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 44).append("[").append(str).append("] is not a valid global search section name").toString());
    }

    public static int zzqg() {
        return zzagy.length;
    }
}
