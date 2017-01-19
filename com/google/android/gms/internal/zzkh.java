package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.zzgl.zza;

@zzmb
public class zzkh implements MediationInterstitialAdapter {
    private Uri mUri;
    private Activity zzLg;
    private zzgl zzLh;
    private MediationInterstitialListener zzLi;

    /* renamed from: com.google.android.gms.internal.zzkh.1 */
    class C13911 implements zza {
        C13911(zzkh com_google_android_gms_internal_zzkh) {
        }

        public void zzfE() {
            zzpy.zzbc("Hinting CustomTabsService for the load of the new url.");
        }

        public void zzfF() {
            zzpy.zzbc("Disconnecting from CustomTabs service.");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkh.2 */
    class C13922 implements zzh {
        final /* synthetic */ zzkh zzLj;

        C13922(zzkh com_google_android_gms_internal_zzkh) {
            this.zzLj = com_google_android_gms_internal_zzkh;
        }

        public void onPause() {
            zzpy.zzbc("AdMobCustomTabsAdapter overlay is paused.");
        }

        public void onResume() {
            zzpy.zzbc("AdMobCustomTabsAdapter overlay is resumed.");
        }

        public void zzbN() {
            zzpy.zzbc("AdMobCustomTabsAdapter overlay is closed.");
            this.zzLj.zzLi.onAdClosed(this.zzLj);
            this.zzLj.zzLh.zzd(this.zzLj.zzLg);
        }

        public void zzbO() {
            zzpy.zzbc("Opening AdMobCustomTabsAdapter overlay.");
            this.zzLj.zzLi.onAdOpened(this.zzLj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkh.3 */
    class C13933 implements Runnable {
        final /* synthetic */ zzkh zzLj;
        final /* synthetic */ AdOverlayInfoParcel zztF;

        C13933(zzkh com_google_android_gms_internal_zzkh, AdOverlayInfoParcel adOverlayInfoParcel) {
            this.zzLj = com_google_android_gms_internal_zzkh;
            this.zztF = adOverlayInfoParcel;
        }

        public void run() {
            zzv.zzcH().zza(this.zzLj.zzLg, this.zztF);
        }
    }

    public static boolean zzo(Context context) {
        return zzgl.zzn(context);
    }

    public void onDestroy() {
        zzpy.zzbc("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.zzLh.zzd(this.zzLg);
        } catch (Throwable e) {
            zzpy.zzb("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        zzpy.zzbc("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        zzpy.zzbc("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzLi = mediationInterstitialListener;
        if (this.zzLi == null) {
            zzpy.zzbe("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzpy.zzbe("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzLi.onAdFailedToLoad(this, 0);
        } else if (zzo(context)) {
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzpy.zzbe("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzLi.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzLg = (Activity) context;
            this.mUri = Uri.parse(string);
            this.zzLh = new zzgl();
            this.zzLh.zza(new C13911(this));
            this.zzLh.zze(this.zzLg);
            this.zzLi.onAdLoaded(this);
        } else {
            zzpy.zzbe("Default browser does not support custom tabs. Bailing out.");
            this.zzLi.onAdFailedToLoad(this, 0);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new Builder(this.zzLh.zzfC()).build();
        build.intent.setData(this.mUri);
        zzpi.zzWR.post(new C13933(this, new AdOverlayInfoParcel(new zzc(build.intent), null, new C13922(this), null, new zzqa(0, 0, false))));
        zzv.zzcN().zzG(false);
    }
}
