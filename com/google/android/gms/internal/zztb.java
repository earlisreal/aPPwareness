package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;

public final class zztb {
    static zzayd zzaav;
    static Boolean zzaaw;
    static Object zztU;

    static {
        zztU = new Object();
    }

    public static boolean zzT(Context context) {
        zzac.zzw(context);
        if (zzaaw != null) {
            return zzaaw.booleanValue();
        }
        boolean zza = zztg.zza(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzaaw = Boolean.valueOf(zza);
        return zza;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzsx zznr = zzrw.zzW(context).zznr();
        if (intent == null) {
            zznr.zzbR("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zznr.zza("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zzU = zztc.zzU(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (zztU) {
                context.startService(intent2);
                if (zzU) {
                    try {
                        if (zzaav == null) {
                            zzaav = new zzayd(context, 1, "Analytics WakeLock");
                            zzaav.setReferenceCounted(false);
                        }
                        zzaav.acquire(1000);
                    } catch (SecurityException e) {
                        zznr.zzbR("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
