package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zzmb
public abstract class zzgc {
    @zzmb
    public static final zzgc zzFk;
    @zzmb
    public static final zzgc zzFl;
    @zzmb
    public static final zzgc zzFm;

    /* renamed from: com.google.android.gms.internal.zzgc.1 */
    class C12981 extends zzgc {
        C12981() {
        }

        public String zzf(@Nullable String str, String str2) {
            return str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgc.2 */
    class C12992 extends zzgc {
        C12992() {
        }

        public String zzf(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgc.3 */
    class C13003 extends zzgc {
        C13003() {
        }

        @Nullable
        private String zzW(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzf(@Nullable String str, String str2) {
            String zzW = zzW(str);
            String zzW2 = zzW(str2);
            return TextUtils.isEmpty(zzW) ? zzW2 : TextUtils.isEmpty(zzW2) ? zzW : new StringBuilder((String.valueOf(zzW).length() + 1) + String.valueOf(zzW2).length()).append(zzW).append(",").append(zzW2).toString();
        }
    }

    static {
        zzFk = new C12981();
        zzFl = new C12992();
        zzFm = new C13003();
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzf((String) map.get(str), str2));
    }

    public abstract String zzf(@Nullable String str, String str2);
}
