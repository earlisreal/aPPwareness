package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.GamesStatusCodes;

public final class zzsq {
    public static zza<String> zzaeA;
    public static zza<String> zzaeB;
    public static zza<Integer> zzaeC;
    public static zza<String> zzaeD;
    public static zza<String> zzaeE;
    public static zza<Integer> zzaeF;
    public static zza<Integer> zzaeG;
    public static zza<Integer> zzaeH;
    public static zza<Integer> zzaeI;
    public static zza<String> zzaeJ;
    public static zza<Integer> zzaeK;
    public static zza<Long> zzaeL;
    public static zza<Integer> zzaeM;
    public static zza<Integer> zzaeN;
    public static zza<Long> zzaeO;
    public static zza<String> zzaeP;
    public static zza<Integer> zzaeQ;
    public static zza<Boolean> zzaeR;
    public static zza<Long> zzaeS;
    public static zza<Long> zzaeT;
    public static zza<Long> zzaeU;
    public static zza<Long> zzaeV;
    public static zza<Long> zzaeW;
    public static zza<Long> zzaeX;
    public static zza<Long> zzaeY;
    public static zza<Boolean> zzaei;
    public static zza<Boolean> zzaej;
    public static zza<String> zzaek;
    public static zza<Long> zzael;
    public static zza<Float> zzaem;
    public static zza<Integer> zzaen;
    public static zza<Integer> zzaeo;
    public static zza<Integer> zzaep;
    public static zza<Long> zzaeq;
    public static zza<Long> zzaer;
    public static zza<Long> zzaes;
    public static zza<Long> zzaet;
    public static zza<Long> zzaeu;
    public static zza<Long> zzaev;
    public static zza<Integer> zzaew;
    public static zza<Integer> zzaex;
    public static zza<String> zzaey;
    public static zza<String> zzaez;

    public static final class zza<V> {
        private final V zzaeZ;
        private final zzabs<V> zzafa;

        private zza(zzabs<V> com_google_android_gms_internal_zzabs_V, V v) {
            zzac.zzw(com_google_android_gms_internal_zzabs_V);
            this.zzafa = com_google_android_gms_internal_zzabs_V;
            this.zzaeZ = v;
        }

        static zza<Float> zza(String str, float f) {
            return zza(str, f, f);
        }

        static zza<Float> zza(String str, float f, float f2) {
            return new zza(zzabs.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza<Integer> zza(String str, int i, int i2) {
            return new zza(zzabs.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> zza(String str, long j, long j2) {
            return new zza(zzabs.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zza(String str, boolean z, boolean z2) {
            return new zza(zzabs.zzj(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzb(String str, long j) {
            return zza(str, j, j);
        }

        static zza<String> zzd(String str, String str2, String str3) {
            return new zza(zzabs.zzA(str, str3), str2);
        }

        static zza<Integer> zze(String str, int i) {
            return zza(str, i, i);
        }

        static zza<Boolean> zzf(String str, boolean z) {
            return zza(str, z, z);
        }

        static zza<String> zzq(String str, String str2) {
            return zzd(str, str2, str2);
        }

        public V get() {
            return this.zzaeZ;
        }
    }

    static {
        zzaei = zza.zzf("analytics.service_enabled", false);
        zzaej = zza.zzf("analytics.service_client_enabled", true);
        zzaek = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
        zzael = zza.zzb("analytics.max_tokens", 60);
        zzaem = zza.zza("analytics.tokens_per_sec", 0.5f);
        zzaen = zza.zza("analytics.max_stored_hits", (int) GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, 20000);
        zzaeo = zza.zze("analytics.max_stored_hits_per_app", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
        zzaep = zza.zze("analytics.max_stored_properties_per_app", 100);
        zzaeq = zza.zza("analytics.local_dispatch_millis", 1800000, 120000);
        zzaer = zza.zza("analytics.initial_local_dispatch_millis", 5000, 5000);
        zzaes = zza.zzb("analytics.min_local_dispatch_millis", 120000);
        zzaet = zza.zzb("analytics.max_local_dispatch_millis", 7200000);
        zzaeu = zza.zzb("analytics.dispatch_alarm_millis", 7200000);
        zzaev = zza.zzb("analytics.max_dispatch_alarm_millis", 32400000);
        zzaew = zza.zze("analytics.max_hits_per_dispatch", 20);
        zzaex = zza.zze("analytics.max_hits_per_batch", 20);
        zzaey = zza.zzq("analytics.insecure_host", "http://www.google-analytics.com");
        zzaez = zza.zzq("analytics.secure_host", "https://ssl.google-analytics.com");
        zzaeA = zza.zzq("analytics.simple_endpoint", "/collect");
        zzaeB = zza.zzq("analytics.batching_endpoint", "/batch");
        zzaeC = zza.zze("analytics.max_get_length", 2036);
        zzaeD = zza.zzd("analytics.batching_strategy.k", zzsd.BATCH_BY_COUNT.name(), zzsd.BATCH_BY_COUNT.name());
        zzaeE = zza.zzq("analytics.compression_strategy.k", zzsg.GZIP.name());
        zzaeF = zza.zze("analytics.max_hits_per_request.k", 20);
        zzaeG = zza.zze("analytics.max_hit_length.k", AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        zzaeH = zza.zze("analytics.max_post_length.k", AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        zzaeI = zza.zze("analytics.max_batch_post_length", AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        zzaeJ = zza.zzq("analytics.fallback_responses.k", "404,502");
        zzaeK = zza.zze("analytics.batch_retry_interval.seconds.k", 3600);
        zzaeL = zza.zzb("analytics.service_monitor_interval", 86400000);
        zzaeM = zza.zze("analytics.http_connection.connect_timeout_millis", 60000);
        zzaeN = zza.zze("analytics.http_connection.read_timeout_millis", 61000);
        zzaeO = zza.zzb("analytics.campaigns.time_limit", 86400000);
        zzaeP = zza.zzq("analytics.first_party_experiment_id", BuildConfig.FLAVOR);
        zzaeQ = zza.zze("analytics.first_party_experiment_variant", 0);
        zzaeR = zza.zzf("analytics.test.disable_receiver", false);
        zzaeS = zza.zza("analytics.service_client.idle_disconnect_millis", (long) NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, (long) NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        zzaeT = zza.zzb("analytics.service_client.connect_timeout_millis", 5000);
        zzaeU = zza.zzb("analytics.service_client.second_connect_delay_millis", 5000);
        zzaeV = zza.zzb("analytics.service_client.unexpected_reconnect_millis", 60000);
        zzaeW = zza.zzb("analytics.service_client.reconnect_throttle_millis", 1800000);
        zzaeX = zza.zzb("analytics.monitoring.sample_period_millis", 86400000);
        zzaeY = zza.zzb("analytics.initialization_warning_threshold", 5000);
    }
}
