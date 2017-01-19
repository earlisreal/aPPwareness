package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzuk.zza;

public class zzuh extends zzl<zzuk> {
    private final String zzahp;

    public zzuh(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, 77, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzahp = com_google_android_gms_common_internal_zzg.zzxh();
    }

    private Bundle zzqm() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzahp);
        return bundle;
    }

    public void zza(zzuj com_google_android_gms_internal_zzuj) {
        try {
            ((zzuk) zzwW()).zza(com_google_android_gms_internal_zzuj);
        } catch (RemoteException e) {
        }
    }

    public void zza(zzuj com_google_android_gms_internal_zzuj, String str) {
        try {
            ((zzuk) zzwW()).zza(com_google_android_gms_internal_zzuj, str);
        } catch (RemoteException e) {
        }
    }

    protected zzuk zzaq(IBinder iBinder) {
        return zza.zzas(iBinder);
    }

    public void zzb(zzuj com_google_android_gms_internal_zzuj, String str) {
        try {
            ((zzuk) zzwW()).zzb(com_google_android_gms_internal_zzuj, str);
        } catch (RemoteException e) {
        }
    }

    protected String zzeu() {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzaq(iBinder);
    }

    protected Bundle zzql() {
        return zzqm();
    }
}
