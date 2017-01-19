package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzmb
public final class zzkf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzju zzKW;

    /* renamed from: com.google.android.gms.internal.zzkf.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzkf zzLc;
        final /* synthetic */ ErrorCode zzLd;

        AnonymousClass10(zzkf com_google_android_gms_internal_zzkf, ErrorCode errorCode) {
            this.zzLc = com_google_android_gms_internal_zzkf;
            this.zzLd = errorCode;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdFailedToLoad(zzkg.zza(this.zzLd));
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.1 */
    class C13811 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13811(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdClicked();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.2 */
    class C13822 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13822(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdOpened();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.3 */
    class C13833 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13833(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdLoaded();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.4 */
    class C13844 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13844(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdClosed();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.5 */
    class C13855 implements Runnable {
        final /* synthetic */ zzkf zzLc;
        final /* synthetic */ ErrorCode zzLd;

        C13855(zzkf com_google_android_gms_internal_zzkf, ErrorCode errorCode) {
            this.zzLc = com_google_android_gms_internal_zzkf;
            this.zzLd = errorCode;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdFailedToLoad(zzkg.zza(this.zzLd));
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.6 */
    class C13866 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13866(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdLeftApplication();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.7 */
    class C13877 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13877(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdOpened();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.8 */
    class C13888 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13888(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdLoaded();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf.9 */
    class C13899 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C13899(zzkf com_google_android_gms_internal_zzkf) {
            this.zzLc = com_google_android_gms_internal_zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdClosed();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
            }
        }
    }

    public zzkf(zzju com_google_android_gms_internal_zzju) {
        this.zzKW = com_google_android_gms_internal_zzju;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onClick.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClicked();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClicked.", e);
                return;
            }
        }
        zzpy.zzbe("onClick must be called on the main UI thread.");
        zzpx.zzXU.post(new C13811(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onDismissScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClosed();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
                return;
            }
        }
        zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C13844(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onDismissScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClosed();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
                return;
            }
        }
        zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C13899(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzpy.zzbc(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
        zzpx.zzXU.post(new C13855(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzpy.zzbc(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
        zzpx.zzXU.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onLeaveApplication.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
        zzpx.zzXU.post(new C13866(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onLeaveApplication.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
        zzpx.zzXU.post(new Runnable() {
            final /* synthetic */ zzkf zzLc;

            {
                this.zzLc = r1;
            }

            public void run() {
                try {
                    this.zzLc.zzKW.onAdLeftApplication();
                } catch (Throwable e) {
                    zzpy.zzc("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onPresentScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdOpened();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
                return;
            }
        }
        zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C13877(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onPresentScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdOpened();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
                return;
            }
        }
        zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C13822(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onReceivedAd.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
        zzpx.zzXU.post(new C13888(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onReceivedAd.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
        zzpx.zzXU.post(new C13833(this));
    }
}
