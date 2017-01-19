package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.github.paolorotolo.appintro.BuildConfig;
import java.util.concurrent.Future;

@zzmb
public final class zzpg {

    public interface zzb {
        void zzh(Bundle bundle);
    }

    private static abstract class zza extends zzpd {
        private zza() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        AnonymousClass10(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", zzm.getBoolean("use_https", true));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.11 */
    class AnonymousClass11 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        AnonymousClass11(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", zzm.getInt("webview_cache_version", 0));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.12 */
    class AnonymousClass12 extends zza {
        final /* synthetic */ boolean zzWI;
        final /* synthetic */ Context zztd;

        AnonymousClass12(Context context, boolean z) {
            this.zztd = context;
            this.zzWI = z;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putBoolean("content_url_opted_out", this.zzWI);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.13 */
    class AnonymousClass13 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        AnonymousClass13(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", zzm.getBoolean("content_url_opted_out", true));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.14 */
    class AnonymousClass14 extends zza {
        final /* synthetic */ String zzWB;
        final /* synthetic */ Context zztd;

        AnonymousClass14(Context context, String str) {
            this.zztd = context;
            this.zzWB = str;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putString("content_url_hashes", this.zzWB);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.15 */
    class AnonymousClass15 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        AnonymousClass15(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", zzm.getString("content_url_hashes", BuildConfig.FLAVOR));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.1 */
    class C14551 extends zza {
        final /* synthetic */ boolean zzWA;
        final /* synthetic */ Context zztd;

        C14551(Context context, boolean z) {
            this.zztd = context;
            this.zzWA = z;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putBoolean("use_https", this.zzWA);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.2 */
    class C14562 extends zza {
        final /* synthetic */ String zzWB;
        final /* synthetic */ Context zztd;

        C14562(Context context, String str) {
            this.zztd = context;
            this.zzWB = str;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putString("content_vertical_hashes", this.zzWB);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.3 */
    class C14573 extends zza {
        final /* synthetic */ boolean zzWC;
        final /* synthetic */ Context zztd;

        C14573(Context context, boolean z) {
            this.zztd = context;
            this.zzWC = z;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putBoolean("auto_collect_location", this.zzWC);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.4 */
    class C14584 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        C14584(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", zzm.getBoolean("auto_collect_location", false));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.5 */
    class C14595 extends zza {
        final /* synthetic */ String zzWE;
        final /* synthetic */ long zzWF;
        final /* synthetic */ Context zztd;

        C14595(Context context, String str, long j) {
            this.zztd = context;
            this.zzWE = str;
            this.zzWF = j;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putString("app_settings_json", this.zzWE);
            edit.putLong("app_settings_last_update_ms", this.zzWF);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.6 */
    class C14606 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        C14606(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putString("app_settings_json", zzm.getString("app_settings_json", BuildConfig.FLAVOR));
            bundle.putLong("app_settings_last_update_ms", zzm.getLong("app_settings_last_update_ms", 0));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.7 */
    class C14617 extends zza {
        final /* synthetic */ long zzWG;
        final /* synthetic */ Context zztd;

        C14617(Context context, long j) {
            this.zztd = context;
            this.zzWG = j;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putLong("app_last_background_time_ms", this.zzWG);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.8 */
    class C14628 extends zza {
        final /* synthetic */ zzb zzWD;
        final /* synthetic */ Context zztd;

        C14628(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
            this.zztd = context;
            this.zzWD = com_google_android_gms_internal_zzpg_zzb;
            super();
        }

        public void zzcm() {
            SharedPreferences zzm = zzpg.zzm(this.zztd);
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", zzm.getLong("app_last_background_time_ms", 0));
            if (this.zzWD != null) {
                this.zzWD.zzh(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpg.9 */
    class C14639 extends zza {
        final /* synthetic */ int zzWH;
        final /* synthetic */ Context zztd;

        C14639(Context context, int i) {
            this.zztd = context;
            this.zzWH = i;
            super();
        }

        public void zzcm() {
            Editor edit = zzpg.zzm(this.zztd).edit();
            edit.putInt("request_in_session_count", this.zzWH);
            edit.apply();
        }
    }

    public static Future zza(Context context, int i) {
        return (Future) new C14639(context, i).zziw();
    }

    public static Future zza(Context context, long j) {
        return (Future) new C14617(context, j).zziw();
    }

    public static Future zza(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new AnonymousClass10(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zza(Context context, String str, long j) {
        return (Future) new C14595(context, str, j).zziw();
    }

    public static Future zzb(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new AnonymousClass11(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zzc(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new AnonymousClass13(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zzc(Context context, boolean z) {
        return (Future) new C14551(context, z).zziw();
    }

    public static Future zzd(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new AnonymousClass15(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zze(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new C14584(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zze(Context context, boolean z) {
        return (Future) new AnonymousClass12(context, z).zziw();
    }

    public static Future zzf(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new C14606(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zzf(Context context, String str) {
        return (Future) new AnonymousClass14(context, str).zziw();
    }

    public static Future zzf(Context context, boolean z) {
        return (Future) new C14573(context, z).zziw();
    }

    public static Future zzg(Context context, zzb com_google_android_gms_internal_zzpg_zzb) {
        return (Future) new C14628(context, com_google_android_gms_internal_zzpg_zzb).zziw();
    }

    public static Future zzg(Context context, String str) {
        return (Future) new C14562(context, str).zziw();
    }

    public static SharedPreferences zzm(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
