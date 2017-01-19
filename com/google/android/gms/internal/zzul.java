package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzul implements WorkAccountApi {
    private static final Status zzahN;

    /* renamed from: com.google.android.gms.internal.zzul.1 */
    class C15321 extends com.google.android.gms.internal.zzzv.zza<Result, zzum> {
        final /* synthetic */ boolean zzahO;

        C15321(zzul com_google_android_gms_internal_zzul, Api api, GoogleApiClient googleApiClient, boolean z) {
            this.zzahO = z;
            super(api, googleApiClient);
        }

        protected void zza(zzum com_google_android_gms_internal_zzum) throws RemoteException {
            ((com.google.android.gms.auth.account.zzb) com_google_android_gms_internal_zzum.zzwW()).zzac(this.zzahO);
        }

        protected Result zzc(Status status) {
            return null;
        }
    }

    static class zza extends com.google.android.gms.auth.account.zza.zza {
        zza() {
        }

        public void zzab(boolean z) {
            throw new UnsupportedOperationException();
        }

        public void zzd(Account account) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzul.2 */
    class C15342 extends com.google.android.gms.internal.zzzv.zza<AddAccountResult, zzum> {
        final /* synthetic */ String zzahD;

        /* renamed from: com.google.android.gms.internal.zzul.2.1 */
        class C15331 extends zza {
            final /* synthetic */ C15342 zzahP;

            C15331(C15342 c15342) {
                this.zzahP = c15342;
            }

            public void zzd(Account account) {
                this.zzahP.zzb(new zzb(account != null ? Status.zzayh : zzul.zzahN, account));
            }
        }

        C15342(zzul com_google_android_gms_internal_zzul, Api api, GoogleApiClient googleApiClient, String str) {
            this.zzahD = str;
            super(api, googleApiClient);
        }

        protected void zza(zzum com_google_android_gms_internal_zzum) throws RemoteException {
            ((com.google.android.gms.auth.account.zzb) com_google_android_gms_internal_zzum.zzwW()).zza(new C15331(this), this.zzahD);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzf(status);
        }

        protected AddAccountResult zzf(Status status) {
            return new zzb(status, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzul.3 */
    class C15363 extends com.google.android.gms.internal.zzzv.zza<Result, zzum> {
        final /* synthetic */ Account zzahB;

        /* renamed from: com.google.android.gms.internal.zzul.3.1 */
        class C15351 extends zza {
            final /* synthetic */ C15363 zzahQ;

            C15351(C15363 c15363) {
                this.zzahQ = c15363;
            }

            public void zzab(boolean z) {
                this.zzahQ.zzb(new zzc(z ? Status.zzayh : zzul.zzahN));
            }
        }

        C15363(zzul com_google_android_gms_internal_zzul, Api api, GoogleApiClient googleApiClient, Account account) {
            this.zzahB = account;
            super(api, googleApiClient);
        }

        protected void zza(zzum com_google_android_gms_internal_zzum) throws RemoteException {
            ((com.google.android.gms.auth.account.zzb) com_google_android_gms_internal_zzum.zzwW()).zza(new C15351(this), this.zzahB);
        }

        protected Result zzc(Status status) {
            return new zzc(status);
        }
    }

    static class zzb implements AddAccountResult {
        private final Account zzagg;
        private final Status zzahq;

        public zzb(Status status, Account account) {
            this.zzahq = status;
            this.zzagg = account;
        }

        public Account getAccount() {
            return this.zzagg;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static class zzc implements Result {
        private final Status zzahq;

        public zzc(Status status) {
            this.zzahq = status;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static {
        zzahN = new Status(13);
    }

    public PendingResult<AddAccountResult> addWorkAccount(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new C15342(this, WorkAccount.API, googleApiClient, str));
    }

    public PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, Account account) {
        return googleApiClient.zzb(new C15363(this, WorkAccount.API, googleApiClient, account));
    }

    public void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, boolean z) {
        googleApiClient.zzb(new C15321(this, WorkAccount.API, googleApiClient, z));
    }
}
