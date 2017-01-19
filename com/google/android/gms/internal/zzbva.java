package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public class zzbva extends CustomTabsServiceConnection {
    private WeakReference<zzbvb> zzcsV;

    public zzbva(zzbvb com_google_android_gms_internal_zzbvb) {
        this.zzcsV = new WeakReference(com_google_android_gms_internal_zzbvb);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbvb com_google_android_gms_internal_zzbvb = (zzbvb) this.zzcsV.get();
        if (com_google_android_gms_internal_zzbvb != null) {
            com_google_android_gms_internal_zzbvb.zza(customTabsClient);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzbvb com_google_android_gms_internal_zzbvb = (zzbvb) this.zzcsV.get();
        if (com_google_android_gms_internal_zzbvb != null) {
            com_google_android_gms_internal_zzbvb.zzfD();
        }
    }
}
