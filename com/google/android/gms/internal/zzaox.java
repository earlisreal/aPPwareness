package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzn;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zzzv.zzb;

public class zzaox implements ConfigApi {

    /* renamed from: com.google.android.gms.internal.zzaox.1 */
    class C08711 extends zza<DataTypeResult> {
        final /* synthetic */ DataTypeCreateRequest zzaUg;

        C08711(zzaox com_google_android_gms_internal_zzaox, GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
            this.zzaUg = dataTypeCreateRequest;
            super(googleApiClient);
        }

        protected DataTypeResult zzU(Status status) {
            return DataTypeResult.zzae(status);
        }

        protected void zza(zzanr com_google_android_gms_internal_zzanr) throws RemoteException {
            ((zzaog) com_google_android_gms_internal_zzanr.zzwW()).zza(new DataTypeCreateRequest(this.zzaUg, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzU(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaox.2 */
    class C08722 extends zza<DataTypeResult> {
        final /* synthetic */ String zzaUh;

        C08722(zzaox com_google_android_gms_internal_zzaox, GoogleApiClient googleApiClient, String str) {
            this.zzaUh = str;
            super(googleApiClient);
        }

        protected DataTypeResult zzU(Status status) {
            return DataTypeResult.zzae(status);
        }

        protected void zza(zzanr com_google_android_gms_internal_zzanr) throws RemoteException {
            ((zzaog) com_google_android_gms_internal_zzanr.zzwW()).zza(new zzn(this.zzaUh, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzU(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaox.3 */
    class C08733 extends zzc {
        C08733(zzaox com_google_android_gms_internal_zzaox, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzanr com_google_android_gms_internal_zzanr) throws RemoteException {
            ((zzaog) com_google_android_gms_internal_zzanr.zzwW()).zza(new zzw(new zzape(this)));
        }
    }

    private static class zza extends com.google.android.gms.internal.zzaob.zza {
        private final zzb<DataTypeResult> zzaFq;

        private zza(zzb<DataTypeResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzaFq.setResult(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
        return googleApiClient.zzb(new C08711(this, googleApiClient, dataTypeCreateRequest));
    }

    public PendingResult<Status> disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C08733(this, googleApiClient));
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new C08722(this, googleApiClient, str));
    }
}
