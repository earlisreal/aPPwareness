package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzua.zza;

public class zzud extends zzl<zzua> {
    public zzud(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzua zzap(IBinder iBinder) {
        return zza.zzan(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzev() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzap(iBinder);
    }

    public zzua zzqj() throws DeadObjectException {
        return (zzua) zzwW();
    }
}
