package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedList;
import java.util.List;

@zzmb
class zziq {
    private final List<zza> zztf;

    interface zza {
        void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException;
    }

    /* renamed from: com.google.android.gms.internal.zziq.1 */
    class C13321 extends com.google.android.gms.internal.zzel.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq.1.1 */
        class C13271 implements zza {
            C13271(C13321 c13321) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdClosed();
                }
                zzv.zzcY().zzgj();
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.1.2 */
        class C13282 implements zza {
            final /* synthetic */ int zzIm;

            C13282(C13321 c13321, int i) {
                this.zzIm = i;
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdFailedToLoad(this.zzIm);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.1.3 */
        class C13293 implements zza {
            C13293(C13321 c13321) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.1.4 */
        class C13304 implements zza {
            C13304(C13321 c13321) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.1.5 */
        class C13315 implements zza {
            C13315(C13321 c13321) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzti != null) {
                    com_google_android_gms_internal_zzir.zzti.onAdOpened();
                }
            }
        }

        C13321(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onAdClosed() throws RemoteException {
            this.zzIl.zztf.add(new C13271(this));
        }

        public void onAdFailedToLoad(int i) throws RemoteException {
            this.zzIl.zztf.add(new C13282(this, i));
            zzpe.m29v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzIl.zztf.add(new C13293(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzIl.zztf.add(new C13304(this));
            zzpe.m29v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzIl.zztf.add(new C13315(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq.2 */
    class C13342 extends com.google.android.gms.internal.zzer.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq.2.1 */
        class C13331 implements zza {
            final /* synthetic */ String val$name;
            final /* synthetic */ String zzIn;

            C13331(C13342 c13342, String str, String str2) {
                this.val$name = str;
                this.zzIn = str2;
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIt != null) {
                    com_google_android_gms_internal_zzir.zzIt.onAppEvent(this.val$name, this.zzIn);
                }
            }
        }

        C13342(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onAppEvent(String str, String str2) throws RemoteException {
            this.zzIl.zztf.add(new C13331(this, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq.3 */
    class C13363 extends com.google.android.gms.internal.zzkz.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq.3.1 */
        class C13351 implements zza {
            final /* synthetic */ zzky zzIo;

            C13351(C13363 c13363, zzky com_google_android_gms_internal_zzky) {
                this.zzIo = com_google_android_gms_internal_zzky;
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIu != null) {
                    com_google_android_gms_internal_zzir.zzIu.zza(this.zzIo);
                }
            }
        }

        C13363(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void zza(zzky com_google_android_gms_internal_zzky) throws RemoteException {
            this.zzIl.zztf.add(new C13351(this, com_google_android_gms_internal_zzky));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq.4 */
    class C13384 extends com.google.android.gms.internal.zzgj.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq.4.1 */
        class C13371 implements zza {
            final /* synthetic */ zzgi zzIp;

            C13371(C13384 c13384, zzgi com_google_android_gms_internal_zzgi) {
                this.zzIp = com_google_android_gms_internal_zzgi;
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIv != null) {
                    com_google_android_gms_internal_zzir.zzIv.zza(this.zzIp);
                }
            }
        }

        C13384(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void zza(zzgi com_google_android_gms_internal_zzgi) throws RemoteException {
            this.zzIl.zztf.add(new C13371(this, com_google_android_gms_internal_zzgi));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq.5 */
    class C13405 extends com.google.android.gms.internal.zzek.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq.5.1 */
        class C13391 implements zza {
            C13391(C13405 c13405) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIw != null) {
                    com_google_android_gms_internal_zzir.zzIw.onAdClicked();
                }
            }
        }

        C13405(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onAdClicked() throws RemoteException {
            this.zzIl.zztf.add(new C13391(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq.6 */
    class C13486 extends com.google.android.gms.internal.zznt.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq.6.1 */
        class C13411 implements zza {
            C13411(C13486 c13486) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.6.2 */
        class C13422 implements zza {
            C13422(C13486 c13486) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdOpened();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.6.3 */
        class C13433 implements zza {
            C13433(C13486 c13486) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoStarted();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.6.4 */
        class C13444 implements zza {
            C13444(C13486 c13486) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdClosed();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.6.5 */
        class C13455 implements zza {
            final /* synthetic */ zznq zzIq;

            C13455(C13486 c13486, zznq com_google_android_gms_internal_zznq) {
                this.zzIq = com_google_android_gms_internal_zznq;
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.zza(this.zzIq);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.6.6 */
        class C13466 implements zza {
            C13466(C13486 c13486) {
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq.6.7 */
        class C13477 implements zza {
            final /* synthetic */ int zzIm;

            C13477(C13486 c13486, int i) {
                this.zzIm = i;
            }

            public void zzb(zzir com_google_android_gms_internal_zzir) throws RemoteException {
                if (com_google_android_gms_internal_zzir.zzIx != null) {
                    com_google_android_gms_internal_zzir.zzIx.onRewardedVideoAdFailedToLoad(this.zzIm);
                }
            }
        }

        C13486(zziq com_google_android_gms_internal_zziq) {
            this.zzIl = com_google_android_gms_internal_zziq;
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            this.zzIl.zztf.add(new C13444(this));
        }

        public void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
            this.zzIl.zztf.add(new C13477(this, i));
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            this.zzIl.zztf.add(new C13466(this));
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            this.zzIl.zztf.add(new C13411(this));
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            this.zzIl.zztf.add(new C13422(this));
        }

        public void onRewardedVideoStarted() throws RemoteException {
            this.zzIl.zztf.add(new C13433(this));
        }

        public void zza(zznq com_google_android_gms_internal_zznq) throws RemoteException {
            this.zzIl.zztf.add(new C13455(this, com_google_android_gms_internal_zznq));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq.7 */
    class C13497 implements Runnable {
        final /* synthetic */ zza zzIr;
        final /* synthetic */ zzir zzIs;

        C13497(zziq com_google_android_gms_internal_zziq, zza com_google_android_gms_internal_zziq_zza, zzir com_google_android_gms_internal_zzir) {
            this.zzIr = com_google_android_gms_internal_zziq_zza;
            this.zzIs = com_google_android_gms_internal_zzir;
        }

        public void run() {
            try {
                this.zzIr.zzb(this.zzIs);
            } catch (Throwable e) {
                zzpy.zzc("Could not propagate interstitial ad event.", e);
            }
        }
    }

    zziq() {
        this.zztf = new LinkedList();
    }

    void zza(zzir com_google_android_gms_internal_zzir) {
        Handler handler = zzpi.zzWR;
        for (zza c13497 : this.zztf) {
            handler.post(new C13497(this, c13497, com_google_android_gms_internal_zzir));
        }
        this.zztf.clear();
    }

    void zzc(zzl com_google_android_gms_ads_internal_zzl) {
        com_google_android_gms_ads_internal_zzl.zza(new C13321(this));
        com_google_android_gms_ads_internal_zzl.zza(new C13342(this));
        com_google_android_gms_ads_internal_zzl.zza(new C13363(this));
        com_google_android_gms_ads_internal_zzl.zza(new C13384(this));
        com_google_android_gms_ads_internal_zzl.zza(new C13405(this));
        com_google_android_gms_ads_internal_zzl.zza(new C13486(this));
    }
}
