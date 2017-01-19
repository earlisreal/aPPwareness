package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzzv.zza;

abstract class zzux<R extends Result> extends zza<R, zzuz> {
    zzux(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    protected abstract void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws DeadObjectException, RemoteException;

    protected final void zza(zzuz com_google_android_gms_internal_zzuz) throws DeadObjectException, RemoteException {
        zza(com_google_android_gms_internal_zzuz.getContext(), (zzvf) com_google_android_gms_internal_zzuz.zzwW());
    }
}
