package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzij extends zzpd {
    final zzqp zzGt;
    final zzil zzHU;
    private final String zzHV;

    /* renamed from: com.google.android.gms.internal.zzij.1 */
    class C13231 implements Runnable {
        final /* synthetic */ zzij zzHW;

        C13231(zzij com_google_android_gms_internal_zzij) {
            this.zzHW = com_google_android_gms_internal_zzij;
        }

        public void run() {
            zzv.zzdg().zzb(this.zzHW);
        }
    }

    zzij(zzqp com_google_android_gms_internal_zzqp, zzil com_google_android_gms_internal_zzil, String str) {
        this.zzGt = com_google_android_gms_internal_zzqp;
        this.zzHU = com_google_android_gms_internal_zzil;
        this.zzHV = str;
        zzv.zzdg().zza(this);
    }

    public void onStop() {
        this.zzHU.abort();
    }

    public void zzcm() {
        try {
            this.zzHU.zzad(this.zzHV);
        } finally {
            zzpi.zzWR.post(new C13231(this));
        }
    }
}
