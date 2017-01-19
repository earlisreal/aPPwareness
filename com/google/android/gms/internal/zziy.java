package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import java.util.concurrent.Future;

@zzmb
public class zziy {

    /* renamed from: com.google.android.gms.internal.zziy.1 */
    class C13501 implements Runnable {
        final /* synthetic */ zzqa zzIQ;
        final /* synthetic */ zza zzIR;
        final /* synthetic */ zzav zzIS;
        final /* synthetic */ zzd zzIT;
        final /* synthetic */ String zzIU;
        final /* synthetic */ zziy zzIV;
        final /* synthetic */ Context zztd;

        C13501(zziy com_google_android_gms_internal_zziy, Context context, zzqa com_google_android_gms_internal_zzqa, zza com_google_android_gms_internal_zziy_zza, zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_ads_internal_zzd, String str) {
            this.zzIV = com_google_android_gms_internal_zziy;
            this.zztd = context;
            this.zzIQ = com_google_android_gms_internal_zzqa;
            this.zzIR = com_google_android_gms_internal_zziy_zza;
            this.zzIS = com_google_android_gms_internal_zzav;
            this.zzIT = com_google_android_gms_ads_internal_zzd;
            this.zzIU = str;
        }

        public void run() {
            this.zzIV.zza(this.zztd, this.zzIQ, this.zzIR, this.zzIS, this.zzIT).zzam(this.zzIU);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziy.2 */
    class C13512 implements com.google.android.gms.internal.zzix.zza {
        final /* synthetic */ zza zzIR;

        C13512(zziy com_google_android_gms_internal_zziy, zza com_google_android_gms_internal_zziy_zza) {
            this.zzIR = com_google_android_gms_internal_zziy_zza;
        }

        public void zzgu() {
            this.zzIR.zzh((zzix) this.zzIR.zzIW);
        }
    }

    private static class zza<JavascriptEngine> extends zzqc<JavascriptEngine> {
        JavascriptEngine zzIW;

        private zza() {
        }
    }

    private zzix zza(Context context, zzqa com_google_android_gms_internal_zzqa, zza<zzix> com_google_android_gms_internal_zziy_zza_com_google_android_gms_internal_zzix, zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_ads_internal_zzd) {
        zzix com_google_android_gms_internal_zziz = new zziz(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzav, com_google_android_gms_ads_internal_zzd);
        com_google_android_gms_internal_zziy_zza_com_google_android_gms_internal_zzix.zzIW = com_google_android_gms_internal_zziz;
        com_google_android_gms_internal_zziz.zza(new C13512(this, com_google_android_gms_internal_zziy_zza_com_google_android_gms_internal_zzix));
        return com_google_android_gms_internal_zziz;
    }

    public Future<zzix> zza(Context context, zzqa com_google_android_gms_internal_zzqa, String str, zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_ads_internal_zzd) {
        Future com_google_android_gms_internal_zziy_zza = new zza();
        zzpi.zzWR.post(new C13501(this, context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zziy_zza, com_google_android_gms_internal_zzav, com_google_android_gms_ads_internal_zzd, str));
        return com_google_android_gms_internal_zziy_zza;
    }
}
