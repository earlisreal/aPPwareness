package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzavk implements Connections {
    public static final zzf<zzavj> zzahc;
    public static final com.google.android.gms.common.api.Api.zza<zzavj, NoOptions> zzahd;

    /* renamed from: com.google.android.gms.internal.zzavk.1 */
    class C09821 extends com.google.android.gms.common.api.Api.zza<zzavj, NoOptions> {
        C09821() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzs(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzavj zzs(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzavj(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzavj> {
        public zza(GoogleApiClient googleApiClient) {
            super(Nearby.CONNECTIONS_API, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {

        /* renamed from: com.google.android.gms.internal.zzavk.zzb.1 */
        class C09881 implements StartAdvertisingResult {
            final /* synthetic */ Status zzamf;

            C09881(zzb com_google_android_gms_internal_zzavk_zzb, Status status) {
                this.zzamf = status;
            }

            public String getLocalEndpointName() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public StartAdvertisingResult zzbx(Status status) {
            return new C09881(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbx(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavk.2 */
    class C09832 extends zzb {
        final /* synthetic */ String val$name;
        final /* synthetic */ AppMetadata zzbxg;
        final /* synthetic */ long zzbxh;
        final /* synthetic */ zzaaz zzbxi;

        C09832(zzavk com_google_android_gms_internal_zzavk, GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, zzaaz com_google_android_gms_internal_zzaaz) {
            this.val$name = str;
            this.zzbxg = appMetadata;
            this.zzbxh = j;
            this.zzbxi = com_google_android_gms_internal_zzaaz;
            super(null);
        }

        protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
            com_google_android_gms_internal_zzavj.zza(this, this.val$name, this.zzbxg, this.zzbxh, this.zzbxi);
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavk.3 */
    class C09843 extends zzc {
        final /* synthetic */ String zzbxf;
        final /* synthetic */ long zzbxh;
        final /* synthetic */ zzaaz zzbxj;

        C09843(zzavk com_google_android_gms_internal_zzavk, GoogleApiClient googleApiClient, String str, long j, zzaaz com_google_android_gms_internal_zzaaz) {
            this.zzbxf = str;
            this.zzbxh = j;
            this.zzbxj = com_google_android_gms_internal_zzaaz;
            super(null);
        }

        protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
            com_google_android_gms_internal_zzavj.zza((com.google.android.gms.internal.zzzv.zzb) this, this.zzbxf, this.zzbxh, this.zzbxj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavk.4 */
    class C09854 extends zzc {
        final /* synthetic */ String val$name;
        final /* synthetic */ String zzbwW;
        final /* synthetic */ byte[] zzbwX;
        final /* synthetic */ zzaaz zzbxk;
        final /* synthetic */ zzaaz zzbxl;

        C09854(zzavk com_google_android_gms_internal_zzavk, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, zzaaz com_google_android_gms_internal_zzaaz, zzaaz com_google_android_gms_internal_zzaaz2) {
            this.val$name = str;
            this.zzbwW = str2;
            this.zzbwX = bArr;
            this.zzbxk = com_google_android_gms_internal_zzaaz;
            this.zzbxl = com_google_android_gms_internal_zzaaz2;
            super(null);
        }

        protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
            com_google_android_gms_internal_zzavj.zza(this, this.val$name, this.zzbwW, this.zzbwX, this.zzbxk, this.zzbxl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavk.5 */
    class C09865 extends zzc {
        final /* synthetic */ String zzbwW;
        final /* synthetic */ byte[] zzbwX;
        final /* synthetic */ zzaaz zzbxl;

        C09865(zzavk com_google_android_gms_internal_zzavk, GoogleApiClient googleApiClient, String str, byte[] bArr, zzaaz com_google_android_gms_internal_zzaaz) {
            this.zzbwW = str;
            this.zzbwX = bArr;
            this.zzbxl = com_google_android_gms_internal_zzaaz;
            super(null);
        }

        protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
            com_google_android_gms_internal_zzavj.zza((com.google.android.gms.internal.zzzv.zzb) this, this.zzbwW, this.zzbwX, this.zzbxl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzavk.6 */
    class C09876 extends zzc {
        final /* synthetic */ String zzbwW;

        C09876(zzavk com_google_android_gms_internal_zzavk, GoogleApiClient googleApiClient, String str) {
            this.zzbwW = str;
            super(null);
        }

        protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
            com_google_android_gms_internal_zzavj.zzt(this, this.zzbwW);
        }
    }

    static {
        zzahc = new zzf();
        zzahd = new C09821();
    }

    public static zzavj zzd(GoogleApiClient googleApiClient, boolean z) {
        zzac.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzac.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzavj zze(GoogleApiClient googleApiClient, boolean z) {
        zzac.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zzavj) googleApiClient.zza(zzahc) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, MessageListener messageListener) {
        return googleApiClient.zzb(new C09865(this, googleApiClient, str, bArr, googleApiClient.zzr(messageListener)));
    }

    public void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzgo(str);
        }
    }

    public String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzMU();
    }

    public String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzMT();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C09876(this, googleApiClient, str));
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        return googleApiClient.zzb(new C09854(this, googleApiClient, str, str2, bArr, googleApiClient.zzr(connectionResponseCallback), googleApiClient.zzr(messageListener)));
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zza(new String[]{str}, bArr);
        }
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zza((String[]) list.toArray(new String[0]), bArr);
        }
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzb(new String[]{str}, bArr);
        }
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzb((String[]) list.toArray(new String[0]), bArr);
        }
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, ConnectionRequestListener connectionRequestListener) {
        return googleApiClient.zzb(new C09832(this, googleApiClient, str, appMetadata, j, googleApiClient.zzr(connectionRequestListener)));
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, EndpointDiscoveryListener endpointDiscoveryListener) {
        return googleApiClient.zzb(new C09843(this, googleApiClient, str, j, googleApiClient.zzr(endpointDiscoveryListener)));
    }

    public void stopAdvertising(GoogleApiClient googleApiClient) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzMV();
        }
    }

    public void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzMW();
        }
    }

    public void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzgn(str);
        }
    }
}
