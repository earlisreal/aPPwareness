package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zznr.zza;

public class zzfi extends zza {
    private zznt zzAp;

    /* renamed from: com.google.android.gms.internal.zzfi.1 */
    class C12891 implements Runnable {
        final /* synthetic */ zzfi zzAq;

        C12891(zzfi com_google_android_gms_internal_zzfi) {
            this.zzAq = com_google_android_gms_internal_zzfi;
        }

        public void run() {
            if (this.zzAq.zzAp != null) {
                try {
                    this.zzAq.zzAp.onRewardedVideoAdFailedToLoad(1);
                } catch (Throwable e) {
                    zzpy.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void destroy() throws RemoteException {
    }

    public boolean isLoaded() throws RemoteException {
        return false;
    }

    public void pause() throws RemoteException {
    }

    public void resume() throws RemoteException {
    }

    public void setUserId(String str) throws RemoteException {
    }

    public void show() throws RemoteException {
    }

    public void zza(zznt com_google_android_gms_internal_zznt) throws RemoteException {
        this.zzAp = com_google_android_gms_internal_zznt;
    }

    public void zza(zznx com_google_android_gms_internal_zznx) throws RemoteException {
        zzpy.m28e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzpx.zzXU.post(new C12891(this));
    }

    public void zzf(zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
    }

    public void zzg(zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
    }

    public void zzh(zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
    }
}
