package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzzv.zzb;

public final class zzuw implements CredentialsApi {

    /* renamed from: com.google.android.gms.internal.zzuw.1 */
    class C15381 extends zzux<CredentialRequestResult> {
        final /* synthetic */ CredentialRequest zzaiI;

        /* renamed from: com.google.android.gms.internal.zzuw.1.1 */
        class C15371 extends zzus {
            final /* synthetic */ C15381 zzaiJ;

            C15371(C15381 c15381) {
                this.zzaiJ = c15381;
            }

            public void zza(Status status, Credential credential) {
                this.zzaiJ.zzb(new zzuv(status, credential));
            }

            public void zzh(Status status) {
                this.zzaiJ.zzb(zzuv.zzi(status));
            }
        }

        C15381(zzuw com_google_android_gms_internal_zzuw, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
            this.zzaiI = credentialRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
            com_google_android_gms_internal_zzvf.zza(new C15371(this), this.zzaiI);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzj(status);
        }

        protected CredentialRequestResult zzj(Status status) {
            return zzuv.zzi(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzuw.2 */
    class C15392 extends zzux<Status> {
        final /* synthetic */ Credential zzaiK;

        C15392(zzuw com_google_android_gms_internal_zzuw, GoogleApiClient googleApiClient, Credential credential) {
            this.zzaiK = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
            com_google_android_gms_internal_zzvf.zza(new zza(this), new zzvg(this.zzaiK));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzuw.3 */
    class C15403 extends zzux<Status> {
        final /* synthetic */ Credential zzaiK;

        C15403(zzuw com_google_android_gms_internal_zzuw, GoogleApiClient googleApiClient, Credential credential) {
            this.zzaiK = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
            com_google_android_gms_internal_zzvf.zza(new zza(this), new zzva(this.zzaiK));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzuw.4 */
    class C15414 extends zzux<Status> {
        C15414(zzuw com_google_android_gms_internal_zzuw, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
            com_google_android_gms_internal_zzvf.zza(new zza(this));
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static class zza extends zzus {
        private zzb<Status> zzaiL;

        zza(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaiL = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzh(Status status) {
            this.zzaiL.setResult(status);
        }
    }

    private AuthCredentialsOptions zza(GoogleApiClient googleApiClient) {
        return ((zzuz) googleApiClient.zza(Auth.zzahR)).zzqC();
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential) {
        return googleApiClient.zzb(new C15403(this, googleApiClient, credential));
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C15414(this, googleApiClient));
    }

    public PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        zzac.zzb(googleApiClient.zza(Auth.CREDENTIALS_API), (Object) "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return zzuy.zza(googleApiClient.getContext(), zza(googleApiClient), hintRequest);
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        return googleApiClient.zza(new C15381(this, googleApiClient, credentialRequest));
    }

    public PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential) {
        return googleApiClient.zzb(new C15392(this, googleApiClient, credential));
    }
}
