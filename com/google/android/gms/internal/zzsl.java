package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

abstract class zzsl {
    private static volatile Handler zzaec;
    private final zzrw zzacN;
    private volatile long zzaed;
    private final Runnable zzv;

    /* renamed from: com.google.android.gms.internal.zzsl.1 */
    class C15211 implements Runnable {
        final /* synthetic */ zzsl zzaee;

        C15211(zzsl com_google_android_gms_internal_zzsl) {
            this.zzaee = com_google_android_gms_internal_zzsl;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.zzaee.zzacN.zznt().zzg(this);
                return;
            }
            boolean zzcv = this.zzaee.zzcv();
            this.zzaee.zzaed = 0;
            if (zzcv) {
                this.zzaee.run();
            }
        }
    }

    zzsl(zzrw com_google_android_gms_internal_zzrw) {
        zzac.zzw(com_google_android_gms_internal_zzrw);
        this.zzacN = com_google_android_gms_internal_zzrw;
        this.zzv = new C15211(this);
    }

    private Handler getHandler() {
        if (zzaec != null) {
            return zzaec;
        }
        Handler handler;
        synchronized (zzsl.class) {
            if (zzaec == null) {
                zzaec = new Handler(this.zzacN.getContext().getMainLooper());
            }
            handler = zzaec;
        }
        return handler;
    }

    public void cancel() {
        this.zzaed = 0;
        getHandler().removeCallbacks(this.zzv);
    }

    public abstract void run();

    public boolean zzcv() {
        return this.zzaed != 0;
    }

    public long zzpa() {
        return this.zzaed == 0 ? 0 : Math.abs(this.zzacN.zznq().currentTimeMillis() - this.zzaed);
    }

    public void zzx(long j) {
        cancel();
        if (j >= 0) {
            this.zzaed = this.zzacN.zznq().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzv, j)) {
                this.zzacN.zznr().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public void zzy(long j) {
        long j2 = 0;
        if (!zzcv()) {
            return;
        }
        if (j < 0) {
            cancel();
            return;
        }
        long abs = j - Math.abs(this.zzacN.zznq().currentTimeMillis() - this.zzaed);
        if (abs >= 0) {
            j2 = abs;
        }
        getHandler().removeCallbacks(this.zzv);
        if (!getHandler().postDelayed(this.zzv, j2)) {
            this.zzacN.zznr().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }
}
