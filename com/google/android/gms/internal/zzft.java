package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public abstract class zzft<T> {
    private final int zzAG;
    private final String zzAH;
    private final T zzAI;

    /* renamed from: com.google.android.gms.internal.zzft.1 */
    class C12901 extends zzft<Boolean> {
        C12901(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzb(sharedPreferences);
        }

        public Boolean zzb(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzfm()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzft.2 */
    class C12912 extends zzft<Integer> {
        C12912(int i, String str, Integer num) {
            super(str, num, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzc(sharedPreferences);
        }

        public Integer zzc(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzfm()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzft.3 */
    class C12923 extends zzft<Long> {
        C12923(int i, String str, Long l) {
            super(str, l, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzd(sharedPreferences);
        }

        public Long zzd(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzfm()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzft.4 */
    class C12934 extends zzft<Float> {
        C12934(int i, String str, Float f) {
            super(str, f, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zze(sharedPreferences);
        }

        public Float zze(SharedPreferences sharedPreferences) {
            return Float.valueOf(sharedPreferences.getFloat(getKey(), ((Float) zzfm()).floatValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzft.5 */
    class C12945 extends zzft<String> {
        C12945(int i, String str, String str2) {
            super(str, str2, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzf(sharedPreferences);
        }

        public String zzf(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(getKey(), (String) zzfm());
        }
    }

    private zzft(int i, String str, T t) {
        this.zzAG = i;
        this.zzAH = str;
        this.zzAI = t;
        zzv.zzcU().zza(this);
    }

    public static zzft<String> zza(int i, String str) {
        zzft<String> zza = zza(i, str, null);
        zzv.zzcU().zzb(zza);
        return zza;
    }

    public static zzft<Float> zza(int i, String str, float f) {
        return new C12934(i, str, Float.valueOf(f));
    }

    public static zzft<Integer> zza(int i, String str, int i2) {
        return new C12912(i, str, Integer.valueOf(i2));
    }

    public static zzft<Long> zza(int i, String str, long j) {
        return new C12923(i, str, Long.valueOf(j));
    }

    public static zzft<Boolean> zza(int i, String str, Boolean bool) {
        return new C12901(i, str, bool);
    }

    public static zzft<String> zza(int i, String str, String str2) {
        return new C12945(i, str, str2);
    }

    public static zzft<String> zzb(int i, String str) {
        zzft<String> zza = zza(i, str, null);
        zzv.zzcU().zzc(zza);
        return zza;
    }

    public T get() {
        return zzv.zzcV().zzd(this);
    }

    public String getKey() {
        return this.zzAH;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzfm() {
        return this.zzAI;
    }
}
