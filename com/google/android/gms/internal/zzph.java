package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public final class zzph {
    private static final ThreadPoolExecutor zzWJ;
    private static final ThreadPoolExecutor zzWK;

    /* renamed from: com.google.android.gms.internal.zzph.1 */
    class C14641 implements Callable<Void> {
        final /* synthetic */ Runnable zzWL;

        C14641(Runnable runnable) {
            this.zzWL = runnable;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbl();
        }

        public Void zzbl() {
            this.zzWL.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph.2 */
    class C14652 implements Callable<Void> {
        final /* synthetic */ Runnable zzWL;

        C14652(Runnable runnable) {
            this.zzWL = runnable;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbl();
        }

        public Void zzbl() {
            this.zzWL.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph.3 */
    class C14663 implements Runnable {
        final /* synthetic */ zzqc zzWM;
        final /* synthetic */ Callable zzWN;

        C14663(zzqc com_google_android_gms_internal_zzqc, Callable callable) {
            this.zzWM = com_google_android_gms_internal_zzqc;
            this.zzWN = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.zzWM.zzh(this.zzWN.call());
            } catch (Throwable e) {
                zzv.zzcN().zza(e, "AdThreadPool.submit");
                this.zzWM.zze(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph.4 */
    class C14674 implements Runnable {
        final /* synthetic */ zzqc zzWM;
        final /* synthetic */ Future zzWO;

        C14674(zzqc com_google_android_gms_internal_zzqc, Future future) {
            this.zzWM = com_google_android_gms_internal_zzqc;
            this.zzWO = future;
        }

        public void run() {
            if (this.zzWM.isCancelled()) {
                this.zzWO.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph.5 */
    class C14685 implements ThreadFactory {
        private final AtomicInteger zzWP;
        final /* synthetic */ String zzWQ;

        C14685(String str) {
            this.zzWQ = str;
            this.zzWP = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            String str = this.zzWQ;
            return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.zzWP.getAndIncrement()).toString());
        }
    }

    static {
        zzWJ = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Default"));
        zzWK = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Loader"));
        zzWJ.allowCoreThreadTimeOut(true);
        zzWK.allowCoreThreadTimeOut(true);
    }

    public static zzqf<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza(zzWK, new C14641(runnable)) : zza(zzWJ, new C14652(runnable));
    }

    public static zzqf<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzqf<T> zza(Callable<T> callable) {
        return zza(zzWJ, (Callable) callable);
    }

    public static <T> zzqf<T> zza(ExecutorService executorService, Callable<T> callable) {
        Object com_google_android_gms_internal_zzqc = new zzqc();
        try {
            com_google_android_gms_internal_zzqc.zzd(new C14674(com_google_android_gms_internal_zzqc, executorService.submit(new C14663(com_google_android_gms_internal_zzqc, callable))));
        } catch (Throwable e) {
            zzpy.zzc("Thread execution is rejected.", e);
            com_google_android_gms_internal_zzqc.cancel(true);
        }
        return com_google_android_gms_internal_zzqc;
    }

    private static ThreadFactory zzaU(String str) {
        return new C14685(str);
    }
}
