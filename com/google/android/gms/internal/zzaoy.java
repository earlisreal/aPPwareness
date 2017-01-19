package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.GoalsApi;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;
import com.google.android.gms.internal.zzaoe.zza;

public class zzaoy implements GoalsApi {

    /* renamed from: com.google.android.gms.internal.zzaoy.1 */
    class C08751 extends zza<GoalsResult> {
        final /* synthetic */ GoalsReadRequest zzaUi;

        /* renamed from: com.google.android.gms.internal.zzaoy.1.1 */
        class C08741 extends zza {
            final /* synthetic */ C08751 zzaUj;

            C08741(C08751 c08751) {
                this.zzaUj = c08751;
            }

            public void zza(GoalsResult goalsResult) throws RemoteException {
                this.zzaUj.zzb(goalsResult);
            }
        }

        C08751(zzaoy com_google_android_gms_internal_zzaoy, GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
            this.zzaUi = goalsReadRequest;
            super(googleApiClient);
        }

        protected GoalsResult zzV(Status status) {
            return GoalsResult.zzaf(status);
        }

        protected void zza(zzans com_google_android_gms_internal_zzans) throws RemoteException {
            ((zzaoh) com_google_android_gms_internal_zzans.zzwW()).zza(new GoalsReadRequest(this.zzaUi, new C08741(this)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzV(status);
        }
    }

    public PendingResult<GoalsResult> readCurrentGoals(GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
        return googleApiClient.zza(new C08751(this, googleApiClient, goalsReadRequest));
    }
}
