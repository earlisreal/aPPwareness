package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zzmb
public class zzlr extends zzlm {
    private final zzqp zzGt;
    private zzjj zzKq;
    zzjh zzPL;
    protected zzjn zzPM;
    private boolean zzPN;
    private zzjs zzsD;
    private final zzgf zzsr;

    /* renamed from: com.google.android.gms.internal.zzlr.1 */
    class C14061 implements Runnable {
        final /* synthetic */ zzlr zzPO;
        final /* synthetic */ CountDownLatch zzsA;

        C14061(zzlr com_google_android_gms_internal_zzlr, CountDownLatch countDownLatch) {
            this.zzPO = com_google_android_gms_internal_zzlr;
            this.zzsA = countDownLatch;
        }

        public void run() {
            synchronized (this.zzPO.zzPr) {
                this.zzPO.zzPN = zzo.zza(this.zzPO.zzGt, this.zzPO.zzPM, this.zzsA);
            }
        }
    }

    zzlr(Context context, zza com_google_android_gms_internal_zzov_zza, zzjs com_google_android_gms_internal_zzjs, zzln.zza com_google_android_gms_internal_zzln_zza, zzgf com_google_android_gms_internal_zzgf, zzqp com_google_android_gms_internal_zzqp) {
        super(context, com_google_android_gms_internal_zzov_zza, com_google_android_gms_internal_zzln_zza);
        this.zzsD = com_google_android_gms_internal_zzjs;
        this.zzKq = com_google_android_gms_internal_zzov_zza.zzVr;
        this.zzsr = com_google_android_gms_internal_zzgf;
        this.zzGt = com_google_android_gms_internal_zzqp;
    }

    private static int zzR(int i) {
        switch (i) {
            case MessageApi.UNKNOWN_REQUEST_ID /*-1*/:
                return 4;
            case MessageApi.FILTER_LITERAL /*0*/:
                return 0;
            case MessageApi.FILTER_PREFIX /*1*/:
                return 1;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return 2;
            case Dimension.UNIT_IN /*4*/:
                return 3;
            case Dimension.UNIT_MM /*5*/:
                return 5;
            default:
                return 6;
        }
    }

    private static String zza(zzjn com_google_android_gms_internal_zzjn) {
        String str = com_google_android_gms_internal_zzjn.zzKA.zzJJ;
        int zzR = zzR(com_google_android_gms_internal_zzjn.zzKz);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(zzR).append(".").append(com_google_android_gms_internal_zzjn.zzKF).toString();
    }

    private static String zzg(List<zzjn> list) {
        String str = BuildConfig.FLAVOR;
        if (list == null) {
            return str.toString();
        }
        String str2 = str;
        for (zzjn com_google_android_gms_internal_zzjn : list) {
            if (!(com_google_android_gms_internal_zzjn == null || com_google_android_gms_internal_zzjn.zzKA == null || TextUtils.isEmpty(com_google_android_gms_internal_zzjn.zzKA.zzJJ))) {
                str2 = String.valueOf(str2);
                str = String.valueOf(zza(com_google_android_gms_internal_zzjn));
                str2 = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(str).length()).append(str2).append(str).append("_").toString();
            }
        }
        return str2.substring(0, Math.max(0, str2.length() - 1));
    }

    private void zziD() throws zza {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zzpi.zzWR.post(new C14061(this, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.zzPr) {
                if (!this.zzPN) {
                    throw new zza("View could not be prepared", 0);
                } else if (this.zzGt.isDestroyed()) {
                    throw new zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new zza(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    public void onStop() {
        synchronized (this.zzPr) {
            super.onStop();
            if (this.zzPL != null) {
                this.zzPL.cancel();
            }
        }
    }

    protected zzov zzP(int i) {
        zzmh com_google_android_gms_internal_zzmh = this.zzPo.zzSF;
        return new zzov(com_google_android_gms_internal_zzmh.zzRd, this.zzGt, this.zzPp.zzJY, i, this.zzPp.zzJZ, this.zzPp.zzRM, this.zzPp.orientation, this.zzPp.zzKe, com_google_android_gms_internal_zzmh.zzRg, this.zzPp.zzRK, this.zzPM != null ? this.zzPM.zzKA : null, this.zzPM != null ? this.zzPM.zzKB : null, this.zzPM != null ? this.zzPM.zzKC : AdMobAdapter.class.getName(), this.zzKq, this.zzPM != null ? this.zzPM.zzKD : null, this.zzPp.zzRL, this.zzPo.zzvj, this.zzPp.zzRJ, this.zzPo.zzVv, this.zzPp.zzRO, this.zzPp.zzRP, this.zzPo.zzVp, null, this.zzPp.zzRZ, this.zzPp.zzSa, this.zzPp.zzSb, this.zzKq != null ? this.zzKq.zzKj : false, this.zzPp.zzSd, this.zzPL != null ? zzg(this.zzPL.zzgB()) : null, this.zzPp.zzKb, this.zzPp.zzSg);
    }

    protected void zzh(long j) throws zza {
        boolean z;
        ListIterator listIterator;
        synchronized (this.zzPr) {
            this.zzPL = zzi(j);
        }
        List arrayList = new ArrayList(this.zzKq.zzJW);
        Bundle bundle = this.zzPo.zzSF.zzRd.zzyP;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((zzji) listIterator.next()).zzJI.contains(str)) {
                            listIterator.remove();
                        }
                    }
                }
                this.zzPM = this.zzPL.zzd(arrayList);
                switch (this.zzPM.zzKz) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        if (this.zzPM.zzKA != null && this.zzPM.zzKA.zzJR != null) {
                            zziD();
                            return;
                        }
                    case MessageApi.FILTER_PREFIX /*1*/:
                        throw new zza("No fill from any mediation ad networks.", 3);
                    default:
                        throw new zza("Unexpected mediation result: " + this.zzPM.zzKz, 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzji) listIterator.next()).zzJI.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        this.zzPM = this.zzPL.zzd(arrayList);
        switch (this.zzPM.zzKz) {
            case MessageApi.FILTER_LITERAL /*0*/:
                if (this.zzPM.zzKA != null) {
                }
            case MessageApi.FILTER_PREFIX /*1*/:
                throw new zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zza("Unexpected mediation result: " + this.zzPM.zzKz, 0);
        }
    }

    zzjh zzi(long j) {
        if (this.zzKq.zzKh != -1) {
            return new zzjp(this.mContext, this.zzPo.zzSF, this.zzsD, this.zzKq, this.zzPp.zzzn, this.zzPp.zzzp, j, ((Long) zzfx.zzDe.get()).longValue(), 2);
        }
        return new zzjq(this.mContext, this.zzPo.zzSF, this.zzsD, this.zzKq, this.zzPp.zzzn, this.zzPp.zzzp, j, ((Long) zzfx.zzDe.get()).longValue(), this.zzsr);
    }
}
