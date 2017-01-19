package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzqq.zza;
import org.json.JSONObject;

@zzmb
public class zziz implements zzix {
    private final zzqp zzGt;

    /* renamed from: com.google.android.gms.internal.zziz.1 */
    class C13521 implements Runnable {
        final /* synthetic */ String zzIX;
        final /* synthetic */ JSONObject zzIY;
        final /* synthetic */ zziz zzIZ;

        C13521(zziz com_google_android_gms_internal_zziz, String str, JSONObject jSONObject) {
            this.zzIZ = com_google_android_gms_internal_zziz;
            this.zzIX = str;
            this.zzIY = jSONObject;
        }

        public void run() {
            this.zzIZ.zzGt.zza(this.zzIX, this.zzIY);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz.2 */
    class C13532 implements Runnable {
        final /* synthetic */ String zzIX;
        final /* synthetic */ zziz zzIZ;
        final /* synthetic */ String zzJa;

        C13532(zziz com_google_android_gms_internal_zziz, String str, String str2) {
            this.zzIZ = com_google_android_gms_internal_zziz;
            this.zzIX = str;
            this.zzJa = str2;
        }

        public void run() {
            this.zzIZ.zzGt.zzi(this.zzIX, this.zzJa);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz.3 */
    class C13543 implements Runnable {
        final /* synthetic */ zziz zzIZ;
        final /* synthetic */ String zzJb;

        C13543(zziz com_google_android_gms_internal_zziz, String str) {
            this.zzIZ = com_google_android_gms_internal_zziz;
            this.zzJb = str;
        }

        public void run() {
            this.zzIZ.zzGt.loadData(this.zzJb, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz.4 */
    class C13554 implements Runnable {
        final /* synthetic */ zziz zzIZ;
        final /* synthetic */ String zzJb;

        C13554(zziz com_google_android_gms_internal_zziz, String str) {
            this.zzIZ = com_google_android_gms_internal_zziz;
            this.zzJb = str;
        }

        public void run() {
            this.zzIZ.zzGt.loadData(this.zzJb, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz.5 */
    class C13565 implements Runnable {
        final /* synthetic */ String zzIU;
        final /* synthetic */ zziz zzIZ;

        C13565(zziz com_google_android_gms_internal_zziz, String str) {
            this.zzIZ = com_google_android_gms_internal_zziz;
            this.zzIU = str;
        }

        public void run() {
            this.zzIZ.zzGt.loadUrl(this.zzIU);
        }
    }

    /* renamed from: com.google.android.gms.internal.zziz.6 */
    class C13576 implements zza {
        final /* synthetic */ zzix.zza zzJc;

        C13576(zziz com_google_android_gms_internal_zziz, zzix.zza com_google_android_gms_internal_zzix_zza) {
            this.zzJc = com_google_android_gms_internal_zzix_zza;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, boolean z) {
            this.zzJc.zzgu();
        }
    }

    public zziz(Context context, zzqa com_google_android_gms_internal_zzqa, @Nullable zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_ads_internal_zzd) {
        this.zzGt = zzv.zzcK().zza(context, new zzec(), false, false, com_google_android_gms_internal_zzav, com_google_android_gms_internal_zzqa, null, null, com_google_android_gms_ads_internal_zzd);
        this.zzGt.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzeh.zzeO().zzkJ()) {
            runnable.run();
        } else {
            zzpi.zzWR.post(runnable);
        }
    }

    public void destroy() {
        this.zzGt.destroy();
    }

    public void zza(zzdt com_google_android_gms_internal_zzdt, zzh com_google_android_gms_ads_internal_overlay_zzh, zzht com_google_android_gms_internal_zzht, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, zzhz com_google_android_gms_internal_zzhz, zzib com_google_android_gms_internal_zzib, zze com_google_android_gms_ads_internal_zze, zzkp com_google_android_gms_internal_zzkp) {
        this.zzGt.zzkV().zza(com_google_android_gms_internal_zzdt, com_google_android_gms_ads_internal_overlay_zzh, com_google_android_gms_internal_zzht, com_google_android_gms_ads_internal_overlay_zzq, z, com_google_android_gms_internal_zzhz, com_google_android_gms_internal_zzib, new zze(this.zzGt.getContext(), false), com_google_android_gms_internal_zzkp, null);
    }

    public void zza(zzix.zza com_google_android_gms_internal_zzix_zza) {
        this.zzGt.zzkV().zza(new C13576(this, com_google_android_gms_internal_zzix_zza));
    }

    public void zza(String str, zzhx com_google_android_gms_internal_zzhx) {
        this.zzGt.zzkV().zza(str, com_google_android_gms_internal_zzhx);
    }

    public void zza(String str, JSONObject jSONObject) {
        runOnUiThread(new C13521(this, str, jSONObject));
    }

    public void zzal(String str) {
        runOnUiThread(new C13543(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public void zzam(String str) {
        runOnUiThread(new C13565(this, str));
    }

    public void zzan(String str) {
        runOnUiThread(new C13554(this, str));
    }

    public void zzb(String str, zzhx com_google_android_gms_internal_zzhx) {
        this.zzGt.zzkV().zzb(str, com_google_android_gms_internal_zzhx);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzGt.zzb(str, jSONObject);
    }

    public zzjc zzgt() {
        return new zzjd(this);
    }

    public void zzi(String str, String str2) {
        runOnUiThread(new C13532(this, str, str2));
    }
}
