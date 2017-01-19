package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

public abstract class zzcc<T1 extends Result, T2 extends Result> extends PendingResult<T1> {
    private PendingResult<T2> zzrt;

    /* renamed from: com.google.android.gms.internal.zzcc.1 */
    class C12441 implements ResultCallback<T2> {
        final /* synthetic */ ResultCallback zzru;
        final /* synthetic */ zzcc zzrv;

        C12441(zzcc com_google_android_gms_internal_zzcc, ResultCallback resultCallback) {
            this.zzrv = com_google_android_gms_internal_zzcc;
            this.zzru = resultCallback;
        }

        public void onResult(@NonNull T2 t2) {
            this.zzru.onResult(this.zzrv.zza(t2));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcc.2 */
    class C12452 implements ResultCallback<T2> {
        final /* synthetic */ ResultCallback zzru;
        final /* synthetic */ zzcc zzrv;

        C12452(zzcc com_google_android_gms_internal_zzcc, ResultCallback resultCallback) {
            this.zzrv = com_google_android_gms_internal_zzcc;
            this.zzru = resultCallback;
        }

        public void onResult(@NonNull T2 t2) {
            this.zzru.onResult(this.zzrv.zza(t2));
        }
    }

    protected zzcc(PendingResult<T2> pendingResult) {
        this.zzrt = null;
        this.zzrt = pendingResult;
    }

    @NonNull
    public T1 await() {
        return zza(this.zzrt.await());
    }

    @NonNull
    public T1 await(long j, @NonNull TimeUnit timeUnit) {
        return zza(this.zzrt.await(j, timeUnit));
    }

    public void cancel() {
        this.zzrt.cancel();
    }

    public boolean isCanceled() {
        return this.zzrt.isCanceled();
    }

    public void setResultCallback(@NonNull ResultCallback<? super T1> resultCallback) {
        this.zzrt.setResultCallback(new C12441(this, resultCallback));
    }

    public void setResultCallback(@NonNull ResultCallback<? super T1> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        this.zzrt.setResultCallback(new C12452(this, resultCallback), j, timeUnit);
    }

    protected abstract T1 zza(T2 t2);
}
