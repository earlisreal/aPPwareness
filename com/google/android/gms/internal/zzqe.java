package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public class zzqe {

    public interface zza<D, R> {
        R apply(D d);
    }

    /* renamed from: com.google.android.gms.internal.zzqe.1 */
    class C14881 implements Runnable {
        final /* synthetic */ zzqc zzYi;
        final /* synthetic */ zza zzYj;
        final /* synthetic */ zzqf zzYk;

        C14881(zzqc com_google_android_gms_internal_zzqc, zza com_google_android_gms_internal_zzqe_zza, zzqf com_google_android_gms_internal_zzqf) {
            this.zzYi = com_google_android_gms_internal_zzqc;
            this.zzYj = com_google_android_gms_internal_zzqe_zza;
            this.zzYk = com_google_android_gms_internal_zzqf;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.zzYi;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r3.zzYj;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r3.zzYk;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r2.get();	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r1.apply(r2);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r0.zzh(r1);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
        L_0x0011:
            return;
        L_0x0012:
            r0 = move-exception;
        L_0x0013:
            r0 = r3.zzYi;
            r1 = 1;
            r0.cancel(r1);
            goto L_0x0011;
        L_0x001a:
            r0 = move-exception;
            goto L_0x0013;
        L_0x001c:
            r0 = move-exception;
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqe.1.run():void");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqe.2 */
    class C14892 implements Runnable {
        final /* synthetic */ AtomicInteger zzYl;
        final /* synthetic */ int zzYm;
        final /* synthetic */ zzqc zzYn;
        final /* synthetic */ List zzYo;

        C14892(AtomicInteger atomicInteger, int i, zzqc com_google_android_gms_internal_zzqc, List list) {
            this.zzYl = atomicInteger;
            this.zzYm = i;
            this.zzYn = com_google_android_gms_internal_zzqc;
            this.zzYo = list;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.zzYl;
            r0 = r0.incrementAndGet();
            r1 = r2.zzYm;
            if (r0 < r1) goto L_0x0015;
        L_0x000a:
            r0 = r2.zzYn;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = r2.zzYo;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = com.google.android.gms.internal.zzqe.zzp(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r0.zzh(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
        L_0x0017:
            r1 = "Unable to convert list of futures to a future of list";
            com.google.android.gms.internal.zzpy.zzc(r1, r0);
            goto L_0x0015;
        L_0x001d:
            r0 = move-exception;
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqe.2.run():void");
        }
    }

    public static <A, B> zzqf<B> zza(zzqf<A> com_google_android_gms_internal_zzqf_A, zza<A, B> com_google_android_gms_internal_zzqe_zza_A__B) {
        zzqf com_google_android_gms_internal_zzqc = new zzqc();
        com_google_android_gms_internal_zzqf_A.zzc(new C14881(com_google_android_gms_internal_zzqc, com_google_android_gms_internal_zzqe_zza_A__B, com_google_android_gms_internal_zzqf_A));
        return com_google_android_gms_internal_zzqc;
    }

    public static <V> zzqf<List<V>> zzo(List<zzqf<V>> list) {
        zzqf com_google_android_gms_internal_zzqc = new zzqc();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzqf zzc : list) {
            zzc.zzc(new C14892(atomicInteger, size, com_google_android_gms_internal_zzqc, list));
        }
        return com_google_android_gms_internal_zzqc;
    }

    private static <V> List<V> zzp(List<zzqf<V>> list) throws ExecutionException, InterruptedException {
        List<V> arrayList = new ArrayList();
        for (zzqf com_google_android_gms_internal_zzqf : list) {
            Object obj = com_google_android_gms_internal_zzqf.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
