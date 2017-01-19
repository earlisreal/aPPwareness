package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.awareness.FenceApi;
import com.google.android.gms.awareness.fence.FenceQueryRequest;
import com.google.android.gms.awareness.fence.FenceQueryResult;
import com.google.android.gms.awareness.fence.FenceUpdateRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaez.zza;
import com.google.android.gms.internal.zzaez.zzc;
import com.google.android.gms.internal.zzzv.zzb;

public class zzadz implements FenceApi {

    /* renamed from: com.google.android.gms.internal.zzadz.1 */
    class C08181 extends zzc {
        final /* synthetic */ FenceUpdateRequest zzaHL;

        C08181(zzadz com_google_android_gms_internal_zzadz, GoogleApiClient googleApiClient, FenceUpdateRequest fenceUpdateRequest) {
            this.zzaHL = fenceUpdateRequest;
            super(googleApiClient);
        }

        protected void zza(zzafa com_google_android_gms_internal_zzafa) throws RemoteException {
            com_google_android_gms_internal_zzafa.zza((zzb) this, (zzaeo) this.zzaHL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzadz.2 */
    class C08192 extends zza {
        final /* synthetic */ FenceQueryRequest zzaHM;

        C08192(zzadz com_google_android_gms_internal_zzadz, GoogleApiClient googleApiClient, FenceQueryRequest fenceQueryRequest) {
            this.zzaHM = fenceQueryRequest;
            super(googleApiClient);
        }

        protected void zza(zzafa com_google_android_gms_internal_zzafa) throws RemoteException {
            com_google_android_gms_internal_zzafa.zza((zzb) this, (zzaeg) this.zzaHM);
        }
    }

    public PendingResult<FenceQueryResult> queryFences(GoogleApiClient googleApiClient, FenceQueryRequest fenceQueryRequest) {
        return googleApiClient.zza(new C08192(this, googleApiClient, fenceQueryRequest));
    }

    public PendingResult<Status> updateFences(GoogleApiClient googleApiClient, FenceUpdateRequest fenceUpdateRequest) {
        return googleApiClient.zza(new C08181(this, googleApiClient, fenceUpdateRequest));
    }
}
