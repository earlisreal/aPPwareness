package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb.zza;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread {
    private static final boolean DEBUG;
    private final BlockingQueue<zzk<?>> zzg;
    private final BlockingQueue<zzk<?>> zzh;
    private final zzb zzi;
    private final zzn zzj;
    private volatile boolean zzk;

    /* renamed from: com.google.android.gms.internal.zzc.1 */
    class C12421 implements Runnable {
        final /* synthetic */ zzk zzl;
        final /* synthetic */ zzc zzm;

        C12421(zzc com_google_android_gms_internal_zzc, zzk com_google_android_gms_internal_zzk) {
            this.zzm = com_google_android_gms_internal_zzc;
            this.zzl = com_google_android_gms_internal_zzk;
        }

        public void run() {
            try {
                this.zzm.zzh.put(this.zzl);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        DEBUG = zzs.DEBUG;
    }

    public zzc(BlockingQueue<zzk<?>> blockingQueue, BlockingQueue<zzk<?>> blockingQueue2, zzb com_google_android_gms_internal_zzb, zzn com_google_android_gms_internal_zzn) {
        super("VolleyCacheDispatcher");
        this.zzk = false;
        this.zzg = blockingQueue;
        this.zzh = blockingQueue2;
        this.zzi = com_google_android_gms_internal_zzb;
        this.zzj = com_google_android_gms_internal_zzn;
    }

    public void quit() {
        this.zzk = true;
        interrupt();
    }

    public void run() {
        if (DEBUG) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzi.initialize();
        while (true) {
            try {
                zzk com_google_android_gms_internal_zzk = (zzk) this.zzg.take();
                com_google_android_gms_internal_zzk.zzc("cache-queue-take");
                zza zza = this.zzi.zza(com_google_android_gms_internal_zzk.zzg());
                if (zza == null) {
                    com_google_android_gms_internal_zzk.zzc("cache-miss");
                    this.zzh.put(com_google_android_gms_internal_zzk);
                } else if (zza.zza()) {
                    com_google_android_gms_internal_zzk.zzc("cache-hit-expired");
                    com_google_android_gms_internal_zzk.zza(zza);
                    this.zzh.put(com_google_android_gms_internal_zzk);
                } else {
                    com_google_android_gms_internal_zzk.zzc("cache-hit");
                    zzm zza2 = com_google_android_gms_internal_zzk.zza(new zzi(zza.data, zza.zzf));
                    com_google_android_gms_internal_zzk.zzc("cache-hit-parsed");
                    if (zza.zzb()) {
                        com_google_android_gms_internal_zzk.zzc("cache-hit-refresh-needed");
                        com_google_android_gms_internal_zzk.zza(zza);
                        zza2.zzag = true;
                        this.zzj.zza(com_google_android_gms_internal_zzk, zza2, new C12421(this, com_google_android_gms_internal_zzk));
                    } else {
                        this.zzj.zza(com_google_android_gms_internal_zzk, zza2);
                    }
                }
            } catch (InterruptedException e) {
                if (this.zzk) {
                    return;
                }
            }
        }
    }
}
