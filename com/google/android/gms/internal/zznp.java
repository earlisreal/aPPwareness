package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzov.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zznp extends zzb implements zzod {
    private static final zzjr zzUF;
    private final Map<String, zzoh> zzUG;
    private boolean zzUH;

    /* renamed from: com.google.android.gms.internal.zznp.1 */
    class C14471 implements Runnable {
        final /* synthetic */ zznp zzUI;

        C14471(zznp com_google_android_gms_internal_zznp) {
            this.zzUI = com_google_android_gms_internal_zznp;
        }

        public void run() {
            this.zzUI.zzh(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznp.2 */
    class C14482 implements Runnable {
        final /* synthetic */ zznp zzUI;
        final /* synthetic */ zza zzsI;

        C14482(zznp com_google_android_gms_internal_zznp, zza com_google_android_gms_internal_zzov_zza) {
            this.zzUI = com_google_android_gms_internal_zznp;
            this.zzsI = com_google_android_gms_internal_zzov_zza;
        }

        public void run() {
            this.zzUI.zzb(new zzov(this.zzsI, null, null, null, null, null, null, null));
        }
    }

    static {
        zzUF = new zzjr();
    }

    public zznp(Context context, zzd com_google_android_gms_ads_internal_zzd, zzec com_google_android_gms_internal_zzec, zzjs com_google_android_gms_internal_zzjs, zzqa com_google_android_gms_internal_zzqa) {
        super(context, com_google_android_gms_internal_zzec, null, com_google_android_gms_internal_zzjs, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd);
        this.zzUG = new HashMap();
    }

    private zza zzd(zza com_google_android_gms_internal_zzov_zza) {
        zzpe.m29v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzna.zzc(com_google_android_gms_internal_zzov_zza.zzVB).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, com_google_android_gms_internal_zzov_zza.zzSF.zzvd);
            zzji com_google_android_gms_internal_zzji = new zzji(jSONObject, null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            return new zza(com_google_android_gms_internal_zzov_zza.zzSF, com_google_android_gms_internal_zzov_zza.zzVB, new zzjj(Arrays.asList(new zzji[]{com_google_android_gms_internal_zzji}), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, BuildConfig.FLAVOR, -1, 0, 1, null, 0, -1, -1, false), com_google_android_gms_internal_zzov_zza.zzvj, com_google_android_gms_internal_zzov_zza.errorCode, com_google_android_gms_internal_zzov_zza.zzVv, com_google_android_gms_internal_zzov_zza.zzVw, com_google_android_gms_internal_zzov_zza.zzVp);
        } catch (Throwable e) {
            zzpy.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zze(com_google_android_gms_internal_zzov_zza);
        }
    }

    private zza zze(zza com_google_android_gms_internal_zzov_zza) {
        return new zza(com_google_android_gms_internal_zzov_zza.zzSF, com_google_android_gms_internal_zzov_zza.zzVB, null, com_google_android_gms_internal_zzov_zza.zzvj, 0, com_google_android_gms_internal_zzov_zza.zzVv, com_google_android_gms_internal_zzov_zza.zzVw, com_google_android_gms_internal_zzov_zza.zzVp);
    }

    public void destroy() {
        zzac.zzdn("destroy must be called on the main UI thread.");
        for (String str : this.zzUG.keySet()) {
            String str2;
            try {
                zzoh com_google_android_gms_internal_zzoh = (zzoh) this.zzUG.get(str2);
                if (!(com_google_android_gms_internal_zzoh == null || com_google_android_gms_internal_zzoh.zzjw() == null)) {
                    com_google_android_gms_internal_zzoh.zzjw().destroy();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to destroy adapter: ";
                str2 = String.valueOf(str2);
                zzpy.zzbe(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public boolean isLoaded() {
        zzac.zzdn("isLoaded must be called on the main UI thread.");
        return this.zzsw.zzvh == null && this.zzsw.zzvi == null && this.zzsw.zzvk != null && !this.zzUH;
    }

    public void onContextChanged(@NonNull Context context) {
        for (zzoh zzjw : this.zzUG.values()) {
            try {
                zzjw.zzjw().zzj(zze.zzA(context));
            } catch (Throwable e) {
                zzpy.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void onRewardedVideoAdClosed() {
        zzbH();
    }

    public void onRewardedVideoAdLeftApplication() {
        zzbI();
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzsw.zzvk, false);
        zzbJ();
    }

    public void onRewardedVideoStarted() {
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzKA == null)) {
            zzv.zzdc().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk, this.zzsw.zzvd, false, this.zzsw.zzvk.zzKA.zzJP);
        }
        zzbL();
    }

    public void pause() {
        zzac.zzdn("pause must be called on the main UI thread.");
        for (String str : this.zzUG.keySet()) {
            String str2;
            try {
                zzoh com_google_android_gms_internal_zzoh = (zzoh) this.zzUG.get(str2);
                if (!(com_google_android_gms_internal_zzoh == null || com_google_android_gms_internal_zzoh.zzjw() == null)) {
                    com_google_android_gms_internal_zzoh.zzjw().pause();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to pause adapter: ";
                str2 = String.valueOf(str2);
                zzpy.zzbe(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void resume() {
        zzac.zzdn("resume must be called on the main UI thread.");
        for (String str : this.zzUG.keySet()) {
            String str2;
            try {
                zzoh com_google_android_gms_internal_zzoh = (zzoh) this.zzUG.get(str2);
                if (!(com_google_android_gms_internal_zzoh == null || com_google_android_gms_internal_zzoh.zzjw() == null)) {
                    com_google_android_gms_internal_zzoh.zzjw().resume();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to resume adapter: ";
                str2 = String.valueOf(str2);
                zzpy.zzbe(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void zza(zznx com_google_android_gms_internal_zznx) {
        zzac.zzdn("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(com_google_android_gms_internal_zznx.zzvd)) {
            zzpy.zzbe("Invalid ad unit id. Aborting.");
            zzpi.zzWR.post(new C14471(this));
            return;
        }
        this.zzUH = false;
        this.zzsw.zzvd = com_google_android_gms_internal_zznx.zzvd;
        super.zzb(com_google_android_gms_internal_zznx.zzRd);
    }

    public void zza(zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf) {
        if (com_google_android_gms_internal_zzov_zza.errorCode != -2) {
            zzpi.zzWR.post(new C14482(this, com_google_android_gms_internal_zzov_zza));
            return;
        }
        this.zzsw.zzvl = com_google_android_gms_internal_zzov_zza;
        if (com_google_android_gms_internal_zzov_zza.zzVr == null) {
            this.zzsw.zzvl = zzd(com_google_android_gms_internal_zzov_zza);
        }
        this.zzsw.zzvF = 0;
        this.zzsw.zzvi = zzv.zzcI().zza(this.zzsw.zzqr, this.zzsw.zzvl, this);
    }

    protected boolean zza(zzdy com_google_android_gms_internal_zzdy, zzov com_google_android_gms_internal_zzov, boolean z) {
        return false;
    }

    public boolean zza(zzov com_google_android_gms_internal_zzov, zzov com_google_android_gms_internal_zzov2) {
        return true;
    }

    @Nullable
    public zzoh zzaM(String str) {
        zzoh com_google_android_gms_internal_zzoh;
        Throwable th;
        String str2;
        String valueOf;
        zzoh com_google_android_gms_internal_zzoh2 = (zzoh) this.zzUG.get(str);
        if (com_google_android_gms_internal_zzoh2 != null) {
            return com_google_android_gms_internal_zzoh2;
        }
        try {
            com_google_android_gms_internal_zzoh = new zzoh(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? zzUF : this.zzsD).zzar(str), this);
            try {
                this.zzUG.put(str, com_google_android_gms_internal_zzoh);
                return com_google_android_gms_internal_zzoh;
            } catch (Throwable e) {
                th = e;
                str2 = "Fail to instantiate adapter ";
                valueOf = String.valueOf(str);
                zzpy.zzc(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
                return com_google_android_gms_internal_zzoh;
            }
        } catch (Throwable e2) {
            th = e2;
            com_google_android_gms_internal_zzoh = com_google_android_gms_internal_zzoh2;
            str2 = "Fail to instantiate adapter ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
            }
            zzpy.zzc(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
            return com_google_android_gms_internal_zzoh;
        }
    }

    public void zzc(@Nullable zzok com_google_android_gms_internal_zzok) {
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzKA == null)) {
            zzv.zzdc().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk, this.zzsw.zzvd, false, this.zzsw.zzvk.zzKA.zzJQ);
        }
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzVr == null || TextUtils.isEmpty(this.zzsw.zzvk.zzVr.zzKf))) {
            com_google_android_gms_internal_zzok = new zzok(this.zzsw.zzvk.zzVr.zzKf, this.zzsw.zzvk.zzVr.zzKg);
        }
        zza(com_google_android_gms_internal_zzok);
    }

    public void zzjo() {
        zzac.zzdn("showAd must be called on the main UI thread.");
        if (isLoaded()) {
            this.zzUH = true;
            zzoh zzaM = zzaM(this.zzsw.zzvk.zzKC);
            if (zzaM != null && zzaM.zzjw() != null) {
                try {
                    zzaM.zzjw().showVideo();
                    return;
                } catch (Throwable e) {
                    zzpy.zzc("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        zzpy.zzbe("The reward video has not loaded.");
    }

    public void zzjp() {
        onAdClicked();
    }
}
