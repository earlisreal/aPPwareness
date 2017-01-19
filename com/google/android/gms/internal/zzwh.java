package com.google.android.gms.internal;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.awareness.SnapshotApi;
import com.google.android.gms.awareness.snapshot.BeaconStateResult;
import com.google.android.gms.awareness.snapshot.DetectedActivityResult;
import com.google.android.gms.awareness.snapshot.HeadphoneStateResult;
import com.google.android.gms.awareness.snapshot.LocationResult;
import com.google.android.gms.awareness.snapshot.PlacesResult;
import com.google.android.gms.awareness.snapshot.WeatherResult;
import com.google.android.gms.awareness.state.BeaconState;
import com.google.android.gms.awareness.state.BeaconState.TypeFilter;
import com.google.android.gms.awareness.state.HeadphoneState;
import com.google.android.gms.awareness.state.Weather;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.zzaez.zzb;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.places.PlaceLikelihood;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class zzwh implements SnapshotApi {

    /* renamed from: com.google.android.gms.internal.zzwh.1 */
    class C15461 extends zzcc<DetectedActivityResult, zzwl> {

        /* renamed from: com.google.android.gms.internal.zzwh.1.1 */
        class C15451 implements DetectedActivityResult {
            final /* synthetic */ zzwl zzalq;

            C15451(C15461 c15461, zzwl com_google_android_gms_internal_zzwl) {
                this.zzalq = com_google_android_gms_internal_zzwl;
            }

            public ActivityRecognitionResult getActivityRecognitionResult() {
                return this.zzalq.zzrD() == null ? null : this.zzalq.zzrD().getActivityRecognitionResult();
            }

            public Status getStatus() {
                return this.zzalq.getStatus();
            }
        }

        C15461(zzwh com_google_android_gms_internal_zzwh, PendingResult pendingResult) {
            super(pendingResult);
        }

        protected DetectedActivityResult zza(zzwl com_google_android_gms_internal_zzwl) {
            return new C15451(this, com_google_android_gms_internal_zzwl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.2 */
    class C15482 extends zzcc<HeadphoneStateResult, zzwl> {

        /* renamed from: com.google.android.gms.internal.zzwh.2.1 */
        class C15471 implements HeadphoneStateResult {
            final /* synthetic */ zzwl zzalq;

            C15471(C15482 c15482, zzwl com_google_android_gms_internal_zzwl) {
                this.zzalq = com_google_android_gms_internal_zzwl;
            }

            public HeadphoneState getHeadphoneState() {
                return this.zzalq.zzrD() == null ? null : this.zzalq.zzrD().zzru();
            }

            public Status getStatus() {
                return this.zzalq.getStatus();
            }
        }

        C15482(zzwh com_google_android_gms_internal_zzwh, PendingResult pendingResult) {
            super(pendingResult);
        }

        protected /* synthetic */ Result zza(Result result) {
            return zzb((zzwl) result);
        }

        protected HeadphoneStateResult zzb(zzwl com_google_android_gms_internal_zzwl) {
            return new C15471(this, com_google_android_gms_internal_zzwl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.3 */
    class C15503 extends zzcc<LocationResult, zzwl> {

        /* renamed from: com.google.android.gms.internal.zzwh.3.1 */
        class C15491 implements LocationResult {
            final /* synthetic */ zzwl zzalq;

            C15491(C15503 c15503, zzwl com_google_android_gms_internal_zzwl) {
                this.zzalq = com_google_android_gms_internal_zzwl;
            }

            public Location getLocation() {
                return this.zzalq.zzrD() == null ? null : this.zzalq.zzrD().getLocation();
            }

            public Status getStatus() {
                return this.zzalq.getStatus();
            }
        }

        C15503(zzwh com_google_android_gms_internal_zzwh, PendingResult pendingResult) {
            super(pendingResult);
        }

        protected /* synthetic */ Result zza(Result result) {
            return zzc((zzwl) result);
        }

        protected LocationResult zzc(zzwl com_google_android_gms_internal_zzwl) {
            return new C15491(this, com_google_android_gms_internal_zzwl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.4 */
    class C15524 extends zzcc<PlacesResult, zzwl> {

        /* renamed from: com.google.android.gms.internal.zzwh.4.1 */
        class C15511 implements PlacesResult {
            final /* synthetic */ zzwl zzalq;
            private boolean zzalr;
            private List<PlaceLikelihood> zzals;

            C15511(C15524 c15524, zzwl com_google_android_gms_internal_zzwl) {
                this.zzalq = com_google_android_gms_internal_zzwl;
                this.zzalr = false;
                this.zzals = null;
            }

            public List<PlaceLikelihood> getPlaceLikelihoods() {
                if (this.zzalr) {
                    return this.zzals;
                }
                this.zzalr = true;
                if (this.zzalq.zzrD() == null) {
                    return null;
                }
                DataHolder zzrw = this.zzalq.zzrD().zzrw();
                if (zzrw == null) {
                    return null;
                }
                zzd com_google_android_gms_internal_zzwa = new zzwa(zzrw);
                try {
                    if (com_google_android_gms_internal_zzwa.getCount() <= 0) {
                        return null;
                    }
                    this.zzals = ((zzvz) ((SafeParcelable) com_google_android_gms_internal_zzwa.get(0))).getPlaceLikelihoods();
                    List<PlaceLikelihood> list = this.zzals;
                    com_google_android_gms_internal_zzwa.release();
                    return list;
                } finally {
                    com_google_android_gms_internal_zzwa.release();
                }
            }

            public Status getStatus() {
                return this.zzalq.getStatus();
            }
        }

        C15524(zzwh com_google_android_gms_internal_zzwh, PendingResult pendingResult) {
            super(pendingResult);
        }

        protected /* synthetic */ Result zza(Result result) {
            return zzd((zzwl) result);
        }

        protected PlacesResult zzd(zzwl com_google_android_gms_internal_zzwl) {
            return new C15511(this, com_google_android_gms_internal_zzwl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.5 */
    class C15545 extends zzcc<WeatherResult, zzwl> {

        /* renamed from: com.google.android.gms.internal.zzwh.5.1 */
        class C15531 implements WeatherResult {
            final /* synthetic */ zzwl zzalq;

            C15531(C15545 c15545, zzwl com_google_android_gms_internal_zzwl) {
                this.zzalq = com_google_android_gms_internal_zzwl;
            }

            public Status getStatus() {
                return this.zzalq.getStatus();
            }

            public Weather getWeather() {
                return this.zzalq.zzrD() == null ? null : this.zzalq.zzrD().zzrz();
            }
        }

        C15545(zzwh com_google_android_gms_internal_zzwh, PendingResult pendingResult) {
            super(pendingResult);
        }

        protected /* synthetic */ Result zza(Result result) {
            return zze((zzwl) result);
        }

        protected WeatherResult zze(zzwl com_google_android_gms_internal_zzwl) {
            return new C15531(this, com_google_android_gms_internal_zzwl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.6 */
    class C15566 extends zzcc<BeaconStateResult, zzwl> {

        /* renamed from: com.google.android.gms.internal.zzwh.6.1 */
        class C15551 implements BeaconStateResult {
            final /* synthetic */ zzwl zzalq;

            C15551(C15566 c15566, zzwl com_google_android_gms_internal_zzwl) {
                this.zzalq = com_google_android_gms_internal_zzwl;
            }

            public BeaconState getBeaconState() {
                return this.zzalq.zzrD() == null ? null : this.zzalq.zzrD().zzrt();
            }

            public Status getStatus() {
                return this.zzalq.getStatus();
            }
        }

        C15566(zzwh com_google_android_gms_internal_zzwh, PendingResult pendingResult) {
            super(pendingResult);
        }

        protected /* synthetic */ Result zza(Result result) {
            return zzf((zzwl) result);
        }

        protected BeaconStateResult zzf(zzwl com_google_android_gms_internal_zzwl) {
            return new C15551(this, com_google_android_gms_internal_zzwl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.7 */
    class C15577 extends zzb {
        final /* synthetic */ int zzalt;

        C15577(GoogleApiClient googleApiClient, int i) {
            this.zzalt = i;
            super(googleApiClient);
        }

        protected void zza(zzafa com_google_android_gms_internal_zzafa) throws RemoteException {
            com_google_android_gms_internal_zzafa.zza((zzzv.zzb) this, new zzwj(this.zzalt, null));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzwh.8 */
    class C15588 extends zzb {
        final /* synthetic */ int zzalt;
        final /* synthetic */ ArrayList zzalu;

        C15588(GoogleApiClient googleApiClient, int i, ArrayList arrayList) {
            this.zzalt = i;
            this.zzalu = arrayList;
            super(googleApiClient);
        }

        protected void zza(zzafa com_google_android_gms_internal_zzafa) throws RemoteException {
            com_google_android_gms_internal_zzafa.zza((zzzv.zzb) this, new zzwj(this.zzalt, this.zzalu));
        }
    }

    private PendingResult<BeaconStateResult> zza(GoogleApiClient googleApiClient, ArrayList<zzvr.zzb> arrayList) {
        return new C15566(this, googleApiClient.zza(zza(googleApiClient, GamesActivityResultCodes.RESULT_LICENSE_FAILED, arrayList)));
    }

    private static zzb zza(GoogleApiClient googleApiClient, int i) {
        return new C15577(googleApiClient, i);
    }

    private static zzb zza(GoogleApiClient googleApiClient, int i, ArrayList<zzvr.zzb> arrayList) {
        return new C15588(googleApiClient, i, arrayList);
    }

    private static ArrayList<zzvr.zzb> zza(TypeFilter... typeFilterArr) {
        int i = 0;
        zzac.zzb((Object) typeFilterArr, (Object) "beaconTypes cannot be null");
        zzac.zzb(typeFilterArr.length > 0, (Object) "beaconTypes must not be empty");
        ArrayList<zzvr.zzb> arrayList = new ArrayList();
        int length = typeFilterArr.length;
        while (i < length) {
            arrayList.add((zzvr.zzb) typeFilterArr[i]);
            i++;
        }
        return arrayList;
    }

    private static ArrayList<zzvr.zzb> zze(Collection<TypeFilter> collection) {
        zzac.zzb((Object) collection, (Object) "beaconTypes cannot be null");
        zzac.zzb(collection.size() > 0, (Object) "beaconTypes must not be empty");
        ArrayList<zzvr.zzb> arrayList = new ArrayList();
        for (TypeFilter typeFilter : collection) {
            arrayList.add((zzvr.zzb) typeFilter);
        }
        return arrayList;
    }

    public PendingResult<BeaconStateResult> getBeaconState(GoogleApiClient googleApiClient, Collection<TypeFilter> collection) {
        return zza(googleApiClient, zze(collection));
    }

    public PendingResult<BeaconStateResult> getBeaconState(GoogleApiClient googleApiClient, TypeFilter... typeFilterArr) {
        return zza(googleApiClient, zza(typeFilterArr));
    }

    public PendingResult<DetectedActivityResult> getDetectedActivity(GoogleApiClient googleApiClient) {
        return new C15461(this, googleApiClient.zza(zza(googleApiClient, (int) GamesActivityResultCodes.RESULT_SIGN_IN_FAILED)));
    }

    public PendingResult<HeadphoneStateResult> getHeadphoneState(GoogleApiClient googleApiClient) {
        return new C15482(this, googleApiClient.zza(zza(googleApiClient, (int) GamesActivityResultCodes.RESULT_APP_MISCONFIGURED)));
    }

    public PendingResult<LocationResult> getLocation(GoogleApiClient googleApiClient) {
        return new C15503(this, googleApiClient.zza(zza(googleApiClient, (int) GamesActivityResultCodes.RESULT_LEFT_ROOM)));
    }

    public PendingResult<PlacesResult> getPlaces(GoogleApiClient googleApiClient) {
        return new C15524(this, googleApiClient.zza(zza(googleApiClient, (int) GamesActivityResultCodes.RESULT_NETWORK_FAILURE)));
    }

    public PendingResult<WeatherResult> getWeather(GoogleApiClient googleApiClient) {
        return new C15545(this, googleApiClient.zza(zza(googleApiClient, (int) GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED)));
    }
}
