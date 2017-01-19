package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzawj implements People {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.zzawj.zza.1 */
        class C09981 implements LoadPeopleResult {
            final /* synthetic */ Status zzamf;

            C09981(zza com_google_android_gms_internal_zzawj_zza, Status status) {
                this.zzamf = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult zzbA(Status status) {
            return new C09981(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbA(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzawj.1 */
    class C09931 extends zza {
        final /* synthetic */ int zzbAg;
        final /* synthetic */ String zzbAh;

        C09931(zzawj com_google_android_gms_internal_zzawj, GoogleApiClient googleApiClient, int i, String str) {
            this.zzbAg = i;
            this.zzbAh = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zza(this, this.zzbAg, this.zzbAh));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzawj.2 */
    class C09942 extends zza {
        final /* synthetic */ String zzbAh;

        C09942(zzawj com_google_android_gms_internal_zzawj, GoogleApiClient googleApiClient, String str) {
            this.zzbAh = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zzu(this, this.zzbAh));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzawj.3 */
    class C09953 extends zza {
        C09953(zzawj com_google_android_gms_internal_zzawj, GoogleApiClient googleApiClient) {
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzv(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzawj.4 */
    class C09964 extends zza {
        final /* synthetic */ Collection zzbAi;

        C09964(zzawj com_google_android_gms_internal_zzawj, GoogleApiClient googleApiClient, Collection collection) {
            this.zzbAi = collection;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza(this, this.zzbAi);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzawj.5 */
    class C09975 extends zza {
        final /* synthetic */ String[] zzbAj;

        C09975(zzawj com_google_android_gms_internal_zzawj, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzbAj = strArr;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzd(this, this.zzbAj);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzNu();
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> collection) {
        return googleApiClient.zza(new C09964(this, googleApiClient, collection));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... strArr) {
        return googleApiClient.zza(new C09975(this, googleApiClient, strArr));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C09953(this, googleApiClient));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int i, String str) {
        return googleApiClient.zza(new C09931(this, googleApiClient, i, str));
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new C09942(this, googleApiClient, str));
    }
}
