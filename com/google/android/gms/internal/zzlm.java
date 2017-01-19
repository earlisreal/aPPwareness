package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzmb
public abstract class zzlm extends zzpd {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzln.zza zzPn;
    protected final com.google.android.gms.internal.zzov.zza zzPo;
    protected zzmk zzPp;
    protected final Object zzPr;
    protected final Object zzrN;

    /* renamed from: com.google.android.gms.internal.zzlm.1 */
    class C14031 implements Runnable {
        final /* synthetic */ zzlm zzPE;

        C14031(zzlm com_google_android_gms_internal_zzlm) {
            this.zzPE = com_google_android_gms_internal_zzlm;
        }

        public void run() {
            this.zzPE.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlm.2 */
    class C14042 implements Runnable {
        final /* synthetic */ zzlm zzPE;
        final /* synthetic */ zzov zzsW;

        C14042(zzlm com_google_android_gms_internal_zzlm, zzov com_google_android_gms_internal_zzov) {
            this.zzPE = com_google_android_gms_internal_zzlm;
            this.zzsW = com_google_android_gms_internal_zzov;
        }

        public void run() {
            synchronized (this.zzPE.zzrN) {
                this.zzPE.zzn(this.zzsW);
            }
        }
    }

    protected static final class zza extends Exception {
        private final int zzPF;

        public zza(String str, int i) {
            super(str);
            this.zzPF = i;
        }

        public int getErrorCode() {
            return this.zzPF;
        }
    }

    protected zzlm(Context context, com.google.android.gms.internal.zzov.zza com_google_android_gms_internal_zzov_zza, com.google.android.gms.internal.zzln.zza com_google_android_gms_internal_zzln_zza) {
        super(true);
        this.zzrN = new Object();
        this.zzPr = new Object();
        this.mContext = context;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzPp = com_google_android_gms_internal_zzov_zza.zzVB;
        this.zzPn = com_google_android_gms_internal_zzln_zza;
    }

    public void onStop() {
    }

    protected abstract zzov zzP(int i);

    public void zzcm() {
        int errorCode;
        synchronized (this.zzrN) {
            zzpy.zzbc("AdRendererBackgroundTask started.");
            int i = this.zzPo.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzpy.zzbd(e.getMessage());
                } else {
                    zzpy.zzbe(e.getMessage());
                }
                if (this.zzPp == null) {
                    this.zzPp = new zzmk(errorCode);
                } else {
                    this.zzPp = new zzmk(errorCode, this.zzPp.zzKe);
                }
                zzpi.zzWR.post(new C14031(this));
                i = errorCode;
            }
            zzpi.zzWR.post(new C14042(this, zzP(i)));
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzn(zzov com_google_android_gms_internal_zzov) {
        this.zzPn.zzb(com_google_android_gms_internal_zzov);
    }
}
