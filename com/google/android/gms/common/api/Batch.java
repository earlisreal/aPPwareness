package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.internal.zzzx;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzzx<BatchResult> {
    private boolean zzaxA;
    private boolean zzaxB;
    private final PendingResult<?>[] zzaxC;
    private int zzaxz;
    private final Object zzrN;

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C05421 implements zza {
        final /* synthetic */ Batch zzaxD;

        C05421(Batch batch) {
            this.zzaxD = batch;
        }

        public void zzx(Status status) {
            synchronized (this.zzaxD.zzrN) {
                if (this.zzaxD.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.zzaxD.zzaxB = true;
                } else if (!status.isSuccess()) {
                    this.zzaxD.zzaxA = true;
                }
                this.zzaxD.zzaxz = this.zzaxD.zzaxz - 1;
                if (this.zzaxD.zzaxz == 0) {
                    if (this.zzaxD.zzaxB) {
                        super.cancel();
                    } else {
                        this.zzaxD.zzb(new BatchResult(this.zzaxD.zzaxA ? new Status(13) : Status.zzayh, this.zzaxD.zzaxC));
                    }
                }
            }
        }
    }

    public static final class Builder {
        private GoogleApiClient zzamy;
        private List<PendingResult<?>> zzaxE;

        public Builder(GoogleApiClient googleApiClient) {
            this.zzaxE = new ArrayList();
            this.zzamy = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.zzaxE.size());
            this.zzaxE.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzamy, null);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzrN = new Object();
        this.zzaxz = list.size();
        this.zzaxC = new PendingResult[this.zzaxz];
        if (list.isEmpty()) {
            zzb(new BatchResult(Status.zzayh, this.zzaxC));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.zzaxC[i] = pendingResult;
            pendingResult.zza(new C05421(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.zzaxC) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zzaxC);
    }

    public /* synthetic */ Result zzc(Status status) {
        return createFailedResult(status);
    }
}
