package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

class zzazo {

    private static class zza {
        private static final ExecutorService zzbJl;

        /* renamed from: com.google.android.gms.internal.zzazo.zza.1 */
        class C10431 implements ThreadFactory {
            C10431() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "google-tag-manager-background-thread");
            }
        }

        static {
            zzbJl = Executors.newSingleThreadExecutor(new C10431());
        }
    }

    private static class zzb {
        private static final ScheduledExecutorService zzbJm;

        /* renamed from: com.google.android.gms.internal.zzazo.zzb.1 */
        class C10441 implements ThreadFactory {
            C10441() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "google-tag-manager-scheduler-thread");
            }
        }

        static {
            zzbJm = Executors.newSingleThreadScheduledExecutor(new C10441());
        }
    }

    static ExecutorService zzQR() {
        return zza.zzbJl;
    }

    static ScheduledExecutorService zzQS() {
        return zzb.zzbJm;
    }
}
