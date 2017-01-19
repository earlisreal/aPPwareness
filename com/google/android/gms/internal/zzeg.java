package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzeg {
    private final Object zzrN;
    private zzes zzzs;
    private final zzdx zzzt;
    private final zzdw zzzu;
    private final zzfd zzzv;
    private final zzhn zzzw;
    private final zznv zzzx;
    private final zzlf zzzy;
    private final zzkq zzzz;

    @VisibleForTesting
    abstract class zza<T> {
        final /* synthetic */ zzeg zzzC;

        zza(zzeg com_google_android_gms_internal_zzeg) {
            this.zzzC = com_google_android_gms_internal_zzeg;
        }

        @Nullable
        protected abstract T zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException;

        @Nullable
        protected abstract T zzeE() throws RemoteException;

        @Nullable
        protected final T zzeL() {
            T t = null;
            zzes zza = this.zzzC.zzeC();
            if (zza == null) {
                zzpy.zzbe("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = zzb(zza);
                } catch (Throwable e) {
                    zzpy.zzc("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }

        @Nullable
        protected final T zzeM() {
            try {
                return zzeE();
            } catch (Throwable e) {
                zzpy.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.1 */
    class C12761 extends zza<zzep> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzec zzzA;
        final /* synthetic */ zzjs zzzB;
        final /* synthetic */ zzeg zzzC;

        C12761(zzeg com_google_android_gms_internal_zzeg, Context context, zzec com_google_android_gms_internal_zzec, String str, zzjs com_google_android_gms_internal_zzjs) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zztd = context;
            this.zzzA = com_google_android_gms_internal_zzec;
            this.zztb = str;
            this.zzzB = com_google_android_gms_internal_zzjs;
            super(com_google_android_gms_internal_zzeg);
        }

        public zzep zza(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createBannerAdManager(zze.zzA(this.zztd), this.zzzA, this.zztb, this.zzzB, 10084000);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zza(com_google_android_gms_internal_zzes);
        }

        public zzep zzeD() {
            zzep zza = this.zzzC.zzzt.zza(this.zztd, this.zzzA, this.zztb, this.zzzB, 1);
            if (zza != null) {
                return zza;
            }
            this.zzzC.zzc(this.zztd, "banner");
            return new zzff();
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeD();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.2 */
    class C12772 extends zza<zzep> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzec zzzA;
        final /* synthetic */ zzeg zzzC;

        C12772(zzeg com_google_android_gms_internal_zzeg, Context context, zzec com_google_android_gms_internal_zzec, String str) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zztd = context;
            this.zzzA = com_google_android_gms_internal_zzec;
            this.zztb = str;
            super(com_google_android_gms_internal_zzeg);
        }

        public zzep zza(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createSearchAdManager(zze.zzA(this.zztd), this.zzzA, this.zztb, 10084000);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zza(com_google_android_gms_internal_zzes);
        }

        public zzep zzeD() {
            zzep zza = this.zzzC.zzzt.zza(this.zztd, this.zzzA, this.zztb, null, 3);
            if (zza != null) {
                return zza;
            }
            this.zzzC.zzc(this.zztd, "search");
            return new zzff();
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeD();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.3 */
    class C12783 extends zza<zzep> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzec zzzA;
        final /* synthetic */ zzjs zzzB;
        final /* synthetic */ zzeg zzzC;

        C12783(zzeg com_google_android_gms_internal_zzeg, Context context, zzec com_google_android_gms_internal_zzec, String str, zzjs com_google_android_gms_internal_zzjs) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zztd = context;
            this.zzzA = com_google_android_gms_internal_zzec;
            this.zztb = str;
            this.zzzB = com_google_android_gms_internal_zzjs;
            super(com_google_android_gms_internal_zzeg);
        }

        public zzep zza(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createInterstitialAdManager(zze.zzA(this.zztd), this.zzzA, this.zztb, this.zzzB, 10084000);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zza(com_google_android_gms_internal_zzes);
        }

        public zzep zzeD() {
            zzep zza = this.zzzC.zzzt.zza(this.zztd, this.zzzA, this.zztb, this.zzzB, 2);
            if (zza != null) {
                return zza;
            }
            this.zzzC.zzc(this.zztd, "interstitial");
            return new zzff();
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeD();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.4 */
    class C12794 extends zza<zzen> {
        final /* synthetic */ String zztb;
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzjs zzzB;
        final /* synthetic */ zzeg zzzC;

        C12794(zzeg com_google_android_gms_internal_zzeg, Context context, String str, zzjs com_google_android_gms_internal_zzjs) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zztd = context;
            this.zztb = str;
            this.zzzB = com_google_android_gms_internal_zzjs;
            super(com_google_android_gms_internal_zzeg);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zzc(com_google_android_gms_internal_zzes);
        }

        public zzen zzc(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createAdLoaderBuilder(zze.zzA(this.zztd), this.zztb, this.zzzB, 10084000);
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeF();
        }

        public zzen zzeF() {
            zzen zza = this.zzzC.zzzu.zza(this.zztd, this.zztb, this.zzzB);
            if (zza != null) {
                return zza;
            }
            this.zzzC.zzc(this.zztd, "native_ad");
            return new zzfe();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.5 */
    class C12805 extends zza<zzeu> {
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzeg zzzC;

        C12805(zzeg com_google_android_gms_internal_zzeg, Context context) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zztd = context;
            super(com_google_android_gms_internal_zzeg);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zzd(com_google_android_gms_internal_zzes);
        }

        public zzeu zzd(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.getMobileAdsSettingsManagerWithClientJarVersion(zze.zzA(this.zztd), 10084000);
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeG();
        }

        public zzeu zzeG() {
            zzeu zzl = this.zzzC.zzzv.zzl(this.zztd);
            if (zzl != null) {
                return zzl;
            }
            this.zzzC.zzc(this.zztd, "mobile_ads_settings");
            return new zzfg();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.6 */
    class C12816 extends zza<zzhb> {
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzeg zzzC;
        final /* synthetic */ FrameLayout zzzD;
        final /* synthetic */ FrameLayout zzzE;

        C12816(zzeg com_google_android_gms_internal_zzeg, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zzzD = frameLayout;
            this.zzzE = frameLayout2;
            this.zztd = context;
            super(com_google_android_gms_internal_zzeg);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zze(com_google_android_gms_internal_zzes);
        }

        public zzhb zze(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createNativeAdViewDelegate(zze.zzA(this.zzzD), zze.zzA(this.zzzE));
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeH();
        }

        public zzhb zzeH() {
            zzhb zzb = this.zzzC.zzzw.zzb(this.zztd, this.zzzD, this.zzzE);
            if (zzb != null) {
                return zzb;
            }
            this.zzzC.zzc(this.zztd, "native_ad_view_delegate");
            return new zzfh();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.7 */
    class C12827 extends zza<zznr> {
        final /* synthetic */ Context zztd;
        final /* synthetic */ zzjs zzzB;
        final /* synthetic */ zzeg zzzC;

        C12827(zzeg com_google_android_gms_internal_zzeg, Context context, zzjs com_google_android_gms_internal_zzjs) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.zztd = context;
            this.zzzB = com_google_android_gms_internal_zzjs;
            super(com_google_android_gms_internal_zzeg);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zzf(com_google_android_gms_internal_zzes);
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeI();
        }

        public zznr zzeI() {
            zznr zzb = this.zzzC.zzzx.zzb(this.zztd, this.zzzB);
            if (zzb != null) {
                return zzb;
            }
            this.zzzC.zzc(this.zztd, "rewarded_video");
            return new zzfi();
        }

        public zznr zzf(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createRewardedVideoAd(zze.zzA(this.zztd), this.zzzB, 10084000);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.8 */
    class C12838 extends zza<zzla> {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ zzeg zzzC;

        C12838(zzeg com_google_android_gms_internal_zzeg, Activity activity) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.val$activity = activity;
            super(com_google_android_gms_internal_zzeg);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zzg(com_google_android_gms_internal_zzes);
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeJ();
        }

        public zzla zzeJ() {
            zzla zzg = this.zzzC.zzzy.zzg(this.val$activity);
            if (zzg != null) {
                return zzg;
            }
            this.zzzC.zzc(this.val$activity, "iap");
            return null;
        }

        public zzla zzg(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createInAppPurchaseManager(zze.zzA(this.val$activity));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzeg.9 */
    class C12849 extends zza<zzkr> {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ zzeg zzzC;

        C12849(zzeg com_google_android_gms_internal_zzeg, Activity activity) {
            this.zzzC = com_google_android_gms_internal_zzeg;
            this.val$activity = activity;
            super(com_google_android_gms_internal_zzeg);
        }

        public /* synthetic */ Object zzb(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return zzh(com_google_android_gms_internal_zzes);
        }

        public /* synthetic */ Object zzeE() throws RemoteException {
            return zzeK();
        }

        public zzkr zzeK() {
            zzkr zzf = this.zzzC.zzzz.zzf(this.val$activity);
            if (zzf != null) {
                return zzf;
            }
            this.zzzC.zzc(this.val$activity, "ad_overlay");
            return null;
        }

        public zzkr zzh(zzes com_google_android_gms_internal_zzes) throws RemoteException {
            return com_google_android_gms_internal_zzes.createAdOverlay(zze.zzA(this.val$activity));
        }
    }

    public zzeg(zzdx com_google_android_gms_internal_zzdx, zzdw com_google_android_gms_internal_zzdw, zzfd com_google_android_gms_internal_zzfd, zzhn com_google_android_gms_internal_zzhn, zznv com_google_android_gms_internal_zznv, zzlf com_google_android_gms_internal_zzlf, zzkq com_google_android_gms_internal_zzkq) {
        this.zzrN = new Object();
        this.zzzt = com_google_android_gms_internal_zzdx;
        this.zzzu = com_google_android_gms_internal_zzdw;
        this.zzzv = com_google_android_gms_internal_zzfd;
        this.zzzw = com_google_android_gms_internal_zzhn;
        this.zzzx = com_google_android_gms_internal_zznv;
        this.zzzy = com_google_android_gms_internal_zzlf;
        this.zzzz = com_google_android_gms_internal_zzkq;
    }

    private static boolean zza(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        zzpy.m28e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private void zzc(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzeh.zzeO().zza(context, null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzes zzeB() {
        try {
            Object newInstance = zzeg.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return com.google.android.gms.internal.zzes.zza.asInterface((IBinder) newInstance);
            }
            zzpy.zzbe("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            zzpy.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private zzes zzeC() {
        zzes com_google_android_gms_internal_zzes;
        synchronized (this.zzrN) {
            if (this.zzzs == null) {
                this.zzzs = zzeB();
            }
            com_google_android_gms_internal_zzes = this.zzzs;
        }
        return com_google_android_gms_internal_zzes;
    }

    public zzep zza(Context context, zzec com_google_android_gms_internal_zzec, String str) {
        return (zzep) zza(context, false, new C12772(this, context, com_google_android_gms_internal_zzec, str));
    }

    public zzep zza(Context context, zzec com_google_android_gms_internal_zzec, String str, zzjs com_google_android_gms_internal_zzjs) {
        return (zzep) zza(context, false, new C12761(this, context, com_google_android_gms_internal_zzec, str, com_google_android_gms_internal_zzjs));
    }

    public zzhb zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzhb) zza(context, false, new C12816(this, frameLayout, frameLayout2, context));
    }

    public zznr zza(Context context, zzjs com_google_android_gms_internal_zzjs) {
        return (zznr) zza(context, false, new C12827(this, context, com_google_android_gms_internal_zzjs));
    }

    @VisibleForTesting
    <T> T zza(Context context, boolean z, zza<T> com_google_android_gms_internal_zzeg_zza_T) {
        if (!(z || zzeh.zzeO().zzP(context))) {
            zzpy.zzbc("Google Play Services is not available");
            z = true;
        }
        T zzeL;
        if (z) {
            zzeL = com_google_android_gms_internal_zzeg_zza_T.zzeL();
            return zzeL == null ? com_google_android_gms_internal_zzeg_zza_T.zzeM() : zzeL;
        } else {
            zzeL = com_google_android_gms_internal_zzeg_zza_T.zzeM();
            return zzeL == null ? com_google_android_gms_internal_zzeg_zza_T.zzeL() : zzeL;
        }
    }

    public zzen zzb(Context context, String str, zzjs com_google_android_gms_internal_zzjs) {
        return (zzen) zza(context, false, new C12794(this, context, str, com_google_android_gms_internal_zzjs));
    }

    public zzep zzb(Context context, zzec com_google_android_gms_internal_zzec, String str, zzjs com_google_android_gms_internal_zzjs) {
        return (zzep) zza(context, false, new C12783(this, context, com_google_android_gms_internal_zzec, str, com_google_android_gms_internal_zzjs));
    }

    @Nullable
    public zzla zzb(Activity activity) {
        return (zzla) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new C12838(this, activity));
    }

    @Nullable
    public zzkr zzc(Activity activity) {
        return (zzkr) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new C12849(this, activity));
    }

    public zzeu zzk(Context context) {
        return (zzeu) zza(context, false, new C12805(this, context));
    }
}
