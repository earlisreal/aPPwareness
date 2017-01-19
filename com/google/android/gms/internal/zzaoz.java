package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.zzd;
import com.google.android.gms.fitness.request.zzg;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzzv.zzb;

public class zzaoz implements HistoryApi {

    /* renamed from: com.google.android.gms.internal.zzaoz.1 */
    class C08761 extends zzc {
        final /* synthetic */ DataSet zzaUk;
        final /* synthetic */ boolean zzaUl;

        C08761(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
            this.zzaUk = dataSet;
            this.zzaUl = z;
            super(googleApiClient);
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new zzg(this.zzaUk, new zzape(this), this.zzaUl));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoz.2 */
    class C08772 extends zzc {
        final /* synthetic */ DataDeleteRequest zzaUm;

        C08772(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
            this.zzaUm = dataDeleteRequest;
            super(googleApiClient);
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new DataDeleteRequest(this.zzaUm, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoz.3 */
    class C08783 extends zzc {
        final /* synthetic */ DataUpdateRequest zzaUn;

        C08783(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest) {
            this.zzaUn = dataUpdateRequest;
            super(googleApiClient);
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new DataUpdateRequest(this.zzaUn, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoz.4 */
    class C08794 extends zzc {
        final /* synthetic */ DataUpdateListenerRegistrationRequest zzaUo;

        C08794(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
            this.zzaUo = dataUpdateListenerRegistrationRequest;
            super(googleApiClient);
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new DataUpdateListenerRegistrationRequest(this.zzaUo, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoz.5 */
    class C08805 extends zzc {
        final /* synthetic */ PendingIntent zzaUp;

        C08805(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaUp = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new zzq(this.zzaUp, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoz.6 */
    class C08816 extends zza<DataReadResult> {
        final /* synthetic */ DataReadRequest zzaUq;

        C08816(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
            this.zzaUq = dataReadRequest;
            super(googleApiClient);
        }

        protected DataReadResult zzW(Status status) {
            return DataReadResult.zza(status, this.zzaUq.getDataTypes(), this.zzaUq.getDataSources());
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new DataReadRequest(this.zzaUq, new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzW(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoz.7 */
    class C08837 extends zza<DailyTotalResult> {
        final /* synthetic */ DataType zzaUr;
        final /* synthetic */ boolean zzaUs;

        /* renamed from: com.google.android.gms.internal.zzaoz.7.1 */
        class C08821 extends com.google.android.gms.internal.zzany.zza {
            final /* synthetic */ C08837 zzaUt;

            C08821(C08837 c08837) {
                this.zzaUt = c08837;
            }

            public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                this.zzaUt.zzb(dailyTotalResult);
            }
        }

        C08837(zzaoz com_google_android_gms_internal_zzaoz, GoogleApiClient googleApiClient, DataType dataType, boolean z) {
            this.zzaUr = dataType;
            this.zzaUs = z;
            super(googleApiClient);
        }

        protected DailyTotalResult zzX(Status status) {
            return DailyTotalResult.zza(status, this.zzaUr);
        }

        protected void zza(zzant com_google_android_gms_internal_zzant) throws RemoteException {
            ((zzaoi) com_google_android_gms_internal_zzant.zzwW()).zza(new zzd(new C08821(this), this.zzaUr, this.zzaUs));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzX(status);
        }
    }

    private static class zza extends com.google.android.gms.internal.zzanz.zza {
        private final zzb<DataReadResult> zzaFq;
        private int zzaUu;
        private DataReadResult zzaUv;

        private zza(zzb<DataReadResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzaUu = 0;
            this.zzaUv = null;
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.zzaUu);
                }
                if (this.zzaUv == null) {
                    this.zzaUv = dataReadResult;
                } else {
                    this.zzaUv.zzb(dataReadResult);
                }
                this.zzaUu++;
                if (this.zzaUu == this.zzaUv.zzCC()) {
                    this.zzaFq.setResult(this.zzaUv);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        zzac.zzb((Object) dataSet, (Object) "Must set the data set");
        zzac.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzac.zzb(dataSet.getDataSource().zzBs(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new C08761(this, googleApiClient, dataSet, z));
    }

    private PendingResult<DailyTotalResult> zza(GoogleApiClient googleApiClient, DataType dataType, boolean z) {
        return googleApiClient.zza(new C08837(this, googleApiClient, dataType, z));
    }

    public PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
        return googleApiClient.zza(new C08772(this, googleApiClient, dataDeleteRequest));
    }

    public PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet) {
        return zza(googleApiClient, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, dataType, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotalFromLocalDevice(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, dataType, true);
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        return googleApiClient.zza(new C08816(this, googleApiClient, dataReadRequest));
    }

    public PendingResult<Status> registerDataUpdateListener(GoogleApiClient googleApiClient, DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return googleApiClient.zza(new C08794(this, googleApiClient, dataUpdateListenerRegistrationRequest));
    }

    public PendingResult<Status> unregisterDataUpdateListener(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C08805(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> updateData(GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest) {
        zzac.zzb(dataUpdateRequest.getDataSet(), (Object) "Must set the data set");
        zzac.zza(dataUpdateRequest.zzpN(), (Object) "Must set a non-zero value for startTimeMillis/startTime");
        zzac.zza(dataUpdateRequest.zzzx(), (Object) "Must set a non-zero value for endTimeMillis/endTime");
        return googleApiClient.zza(new C08783(this, googleApiClient, dataUpdateRequest));
    }
}
