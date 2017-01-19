package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzarl implements FusedLocationProviderApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ PendingIntent zzbjT;

        AnonymousClass10(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzbjT = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjT, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.1 */
    class C09071 extends zza {
        final /* synthetic */ LocationRequest zzbjX;
        final /* synthetic */ LocationListener zzbjY;

        C09071(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            this.zzbjX = locationRequest;
            this.zzbjY = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjX, zzaba.zzb(this.zzbjY, zzasn.zzIx(), LocationListener.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.2 */
    class C09082 extends zza {
        final /* synthetic */ LocationCallback zzbjZ;

        C09082(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
            this.zzbjZ = locationCallback;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzb(zzaba.zza(this.zzbjZ, LocationCallback.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.3 */
    class C09093 extends zza {
        final /* synthetic */ boolean zzbka;

        C09093(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbka = z;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzaC(this.zzbka);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.4 */
    class C09104 extends zza {
        final /* synthetic */ Location zzbkb;

        C09104(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, Location location) {
            this.zzbkb = location;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zzd(this.zzbkb);
            zzb(Status.zzayh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.5 */
    class C09115 extends zza {
        C09115(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.6 */
    class C09126 extends zza {
        final /* synthetic */ LocationRequest zzbjX;
        final /* synthetic */ LocationListener zzbjY;
        final /* synthetic */ Looper zzbkc;

        C09126(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.zzbjX = locationRequest;
            this.zzbjY = locationListener;
            this.zzbkc = looper;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjX, zzaba.zzb(this.zzbjY, zzasn.zzb(this.zzbkc), LocationListener.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.7 */
    class C09137 extends zza {
        final /* synthetic */ LocationRequest zzbjX;
        final /* synthetic */ LocationCallback zzbjZ;
        final /* synthetic */ Looper zzbkc;

        C09137(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
            this.zzbjX = locationRequest;
            this.zzbjZ = locationCallback;
            this.zzbkc = looper;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(zzarv.zzb(this.zzbjX), zzaba.zzb(this.zzbjZ, zzasn.zzb(this.zzbkc), LocationCallback.class.getSimpleName()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.8 */
    class C09148 extends zza {
        final /* synthetic */ PendingIntent zzbjT;
        final /* synthetic */ LocationRequest zzbjX;

        C09148(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.zzbjX = locationRequest;
            this.zzbjT = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(this.zzbjX, this.zzbjT, new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzarl.9 */
    class C09159 extends zza {
        final /* synthetic */ LocationListener zzbjY;

        C09159(zzarl com_google_android_gms_internal_zzarl, GoogleApiClient googleApiClient, LocationListener locationListener) {
            this.zzbjY = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzaru com_google_android_gms_internal_zzaru) throws RemoteException {
            com_google_android_gms_internal_zzaru.zza(zzaba.zza(this.zzbjY, LocationListener.class.getSimpleName()), new zzb(this));
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzarp.zza {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;

        public zzb(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zza(zzarm com_google_android_gms_internal_zzarm) {
            this.zzaFq.setResult(com_google_android_gms_internal_zzarm.getStatus());
        }
    }

    public PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C09115(this, googleApiClient));
    }

    public Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzj(googleApiClient).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzj(googleApiClient).zzHB();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new AnonymousClass10(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.zzb(new C09082(this, googleApiClient, locationCallback));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.zzb(new C09159(this, googleApiClient, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C09148(this, googleApiClient, locationRequest, pendingIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.zzb(new C09137(this, googleApiClient, locationRequest, locationCallback, looper));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        zzac.zzb(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return googleApiClient.zzb(new C09071(this, googleApiClient, locationRequest, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.zzb(new C09126(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.zzb(new C09104(this, googleApiClient, location));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zzb(new C09093(this, googleApiClient, z));
    }
}
