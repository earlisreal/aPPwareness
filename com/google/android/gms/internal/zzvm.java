package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzzv.zza;

abstract class zzvm extends zza<ProxyResult, zzvj> {
    public zzvm(GoogleApiClient googleApiClient) {
        super(com.google.android.gms.auth.api.zza.API, googleApiClient);
    }

    protected abstract void zza(Context context, zzvl com_google_android_gms_internal_zzvl) throws RemoteException;

    protected final void zza(zzvj com_google_android_gms_internal_zzvj) throws RemoteException {
        zza(com_google_android_gms_internal_zzvj.getContext(), (zzvl) com_google_android_gms_internal_zzvj.zzwW());
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzk(status);
    }

    protected ProxyResult zzk(Status status) {
        return new zzvo(status);
    }
}
