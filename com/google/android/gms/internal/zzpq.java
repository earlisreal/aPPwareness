package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

@zzmb
public class zzpq {
    private Handler mHandler;
    private HandlerThread zzXF;
    private int zzXG;
    private final Object zzrN;

    /* renamed from: com.google.android.gms.internal.zzpq.1 */
    class C14851 implements Runnable {
        final /* synthetic */ zzpq zzXH;

        C14851(zzpq com_google_android_gms_internal_zzpq) {
            this.zzXH = com_google_android_gms_internal_zzpq;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.zzXH;
            r1 = r0.zzrN;
            monitor-enter(r1);
            r0 = "Suspending the looper thread";
            com.google.android.gms.internal.zzpe.m29v(r0);	 Catch:{ all -> 0x002a }
        L_0x000c:
            r0 = r2.zzXH;	 Catch:{ all -> 0x002a }
            r0 = r0.zzXG;	 Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x002d;
        L_0x0014:
            r0 = r2.zzXH;	 Catch:{ InterruptedException -> 0x0023 }
            r0 = r0.zzrN;	 Catch:{ InterruptedException -> 0x0023 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0023 }
            r0 = "Looper thread resumed";
            com.google.android.gms.internal.zzpe.m29v(r0);	 Catch:{ InterruptedException -> 0x0023 }
            goto L_0x000c;
        L_0x0023:
            r0 = move-exception;
            r0 = "Looper thread interrupted.";
            com.google.android.gms.internal.zzpe.m29v(r0);	 Catch:{ all -> 0x002a }
            goto L_0x000c;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            throw r0;
        L_0x002d:
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpq.1.run():void");
        }
    }

    public zzpq() {
        this.zzXF = null;
        this.mHandler = null;
        this.zzXG = 0;
        this.zzrN = new Object();
    }

    public Looper zzkC() {
        Looper looper;
        synchronized (this.zzrN) {
            if (this.zzXG != 0) {
                zzac.zzb(this.zzXF, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzXF == null) {
                zzpe.m29v("Starting the looper thread.");
                this.zzXF = new HandlerThread("LooperProvider");
                this.zzXF.start();
                this.mHandler = new Handler(this.zzXF.getLooper());
                zzpe.m29v("Looper thread started.");
            } else {
                zzpe.m29v("Resuming the looper thread");
                this.zzrN.notifyAll();
            }
            this.zzXG++;
            looper = this.zzXF.getLooper();
        }
        return looper;
    }

    public void zzkD() {
        synchronized (this.zzrN) {
            zzac.zzb(this.zzXG > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.zzXG - 1;
            this.zzXG = i;
            if (i == 0) {
                this.mHandler.post(new C14851(this));
            }
        }
    }
}
