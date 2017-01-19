package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzbk;
import com.google.android.gms.fitness.request.zzbo;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzaow implements BleApi {

    /* renamed from: com.google.android.gms.internal.zzaow.1 */
    class C08651 extends zzc {
        final /* synthetic */ StartBleScanRequest zzaUc;

        C08651(zzaow com_google_android_gms_internal_zzaow, GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
            this.zzaUc = startBleScanRequest;
            super(googleApiClient);
        }

        protected void zza(zzanq com_google_android_gms_internal_zzanq) throws RemoteException {
            ((zzaof) com_google_android_gms_internal_zzanq.zzwW()).zza(new StartBleScanRequest(this.zzaUc, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaow.2 */
    class C08662 extends zzc {
        final /* synthetic */ BleScanCallback zzaUd;

        C08662(zzaow com_google_android_gms_internal_zzaow, GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
            this.zzaUd = bleScanCallback;
            super(googleApiClient);
        }

        protected void zza(zzanq com_google_android_gms_internal_zzanq) throws RemoteException {
            ((zzaof) com_google_android_gms_internal_zzanq.zzwW()).zza(new zzbk(this.zzaUd, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaow.3 */
    class C08673 extends zzc {
        final /* synthetic */ String zzaUe;

        C08673(zzaow com_google_android_gms_internal_zzaow, GoogleApiClient googleApiClient, String str) {
            this.zzaUe = str;
            super(googleApiClient);
        }

        protected void zza(zzanq com_google_android_gms_internal_zzanq) throws RemoteException {
            ((zzaof) com_google_android_gms_internal_zzanq.zzwW()).zza(new zzb(this.zzaUe, null, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaow.4 */
    class C08684 extends zzc {
        final /* synthetic */ BleDevice zzaUf;

        C08684(zzaow com_google_android_gms_internal_zzaow, GoogleApiClient googleApiClient, BleDevice bleDevice) {
            this.zzaUf = bleDevice;
            super(googleApiClient);
        }

        protected void zza(zzanq com_google_android_gms_internal_zzanq) throws RemoteException {
            ((zzaof) com_google_android_gms_internal_zzanq.zzwW()).zza(new zzb(this.zzaUf.getAddress(), this.zzaUf, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaow.5 */
    class C08695 extends zzc {
        final /* synthetic */ String zzaUe;

        C08695(zzaow com_google_android_gms_internal_zzaow, GoogleApiClient googleApiClient, String str) {
            this.zzaUe = str;
            super(googleApiClient);
        }

        protected void zza(zzanq com_google_android_gms_internal_zzanq) throws RemoteException {
            ((zzaof) com_google_android_gms_internal_zzanq.zzwW()).zza(new zzbo(this.zzaUe, new zzape(this)));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaow.6 */
    class C08706 extends zza<BleDevicesResult> {
        C08706(zzaow com_google_android_gms_internal_zzaow, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected BleDevicesResult zzT(Status status) {
            return BleDevicesResult.zzac(status);
        }

        protected void zza(zzanq com_google_android_gms_internal_zzanq) throws RemoteException {
            ((zzaof) com_google_android_gms_internal_zzanq.zzwW()).zza(new zzak(new zza(null)));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzT(status);
        }
    }

    private static class zza extends com.google.android.gms.internal.zzapg.zza {
        private final zzzv.zzb<BleDevicesResult> zzaFq;

        private zza(zzzv.zzb<BleDevicesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzaFq.setResult(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return googleApiClient.zzb(new C08684(this, googleApiClient, bleDevice));
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C08673(this, googleApiClient, str));
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C08706(this, googleApiClient));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        return googleApiClient.zza(new C08651(this, googleApiClient, startBleScanRequest));
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        return googleApiClient.zza(new C08662(this, googleApiClient, bleScanCallback));
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C08695(this, googleApiClient, str));
    }
}
