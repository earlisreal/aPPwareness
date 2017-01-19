package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.account.zzb;
import com.google.android.gms.auth.account.zzb.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzum extends zzl<zzb> {
    public zzum(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 120, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzb zzaA(IBinder iBinder) {
        return zza.zzaz(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    protected String zzev() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzaA(iBinder);
    }
}
