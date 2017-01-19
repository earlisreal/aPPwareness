package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzug implements AppInviteApi {

    static class zza extends com.google.android.gms.internal.zzuj.zza {
        zza() {
        }

        public void zza(Status status, Intent intent) {
            throw new UnsupportedOperationException();
        }

        public void zzd(Status status) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class zzb<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzuh> {
        public zzb(GoogleApiClient googleApiClient) {
            super(AppInvite.API, googleApiClient);
        }
    }

    final class zzc extends zzb<Status> {
        private final String zzahi;

        /* renamed from: com.google.android.gms.internal.zzug.zzc.1 */
        class C15291 extends zza {
            final /* synthetic */ zzc zzahj;

            C15291(zzc com_google_android_gms_internal_zzug_zzc) {
                this.zzahj = com_google_android_gms_internal_zzug_zzc;
            }

            public void zzd(Status status) throws RemoteException {
                this.zzahj.zzb(status);
            }
        }

        public zzc(zzug com_google_android_gms_internal_zzug, GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzahi = str;
        }

        protected void zza(zzuh com_google_android_gms_internal_zzuh) throws RemoteException {
            com_google_android_gms_internal_zzuh.zzb(new C15291(this), this.zzahi);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    final class zzd extends zzb<Status> {
        private final String zzahi;

        /* renamed from: com.google.android.gms.internal.zzug.zzd.1 */
        class C15301 extends zza {
            final /* synthetic */ zzd zzahk;

            C15301(zzd com_google_android_gms_internal_zzug_zzd) {
                this.zzahk = com_google_android_gms_internal_zzug_zzd;
            }

            public void zzd(Status status) throws RemoteException {
                this.zzahk.zzb(status);
            }
        }

        public zzd(zzug com_google_android_gms_internal_zzug, GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzahi = str;
        }

        protected void zza(zzuh com_google_android_gms_internal_zzuh) throws RemoteException {
            com_google_android_gms_internal_zzuh.zza(new C15301(this), this.zzahi);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    final class zze extends zzb<AppInviteInvitationResult> {
        private final Activity zzahl;
        private final boolean zzahm;
        private final Intent zzahn;

        /* renamed from: com.google.android.gms.internal.zzug.zze.1 */
        class C15311 extends zza {
            final /* synthetic */ zze zzaho;

            C15311(zze com_google_android_gms_internal_zzug_zze) {
                this.zzaho = com_google_android_gms_internal_zzug_zze;
            }

            public void zza(Status status, Intent intent) {
                this.zzaho.zzb(new zzui(status, intent));
                if (AppInviteReferral.hasReferral(intent) && this.zzaho.zzahm && this.zzaho.zzahl != null) {
                    this.zzaho.zzahl.startActivity(intent);
                }
            }
        }

        public zze(zzug com_google_android_gms_internal_zzug, GoogleApiClient googleApiClient, Activity activity, boolean z) {
            super(googleApiClient);
            this.zzahl = activity;
            this.zzahm = z;
            this.zzahn = this.zzahl != null ? this.zzahl.getIntent() : null;
        }

        protected void zza(zzuh com_google_android_gms_internal_zzuh) throws RemoteException {
            if (AppInviteReferral.hasReferral(this.zzahn)) {
                zzb(new zzui(Status.zzayh, this.zzahn));
                com_google_android_gms_internal_zzuh.zza(null);
                return;
            }
            com_google_android_gms_internal_zzuh.zza(new C15311(this));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zze(status);
        }

        protected AppInviteInvitationResult zze(Status status) {
            return new zzui(status, new Intent());
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzd(this, googleApiClient, str));
    }

    public PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient googleApiClient, Activity activity, boolean z) {
        return googleApiClient.zza(new zze(this, googleApiClient, activity, z));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzc(this, googleApiClient, str));
    }
}
