package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;

public final class zztc {
    private static Boolean zzaax;
    private final Context mContext;
    private final Handler mHandler;
    private final zza zzafI;

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    /* renamed from: com.google.android.gms.internal.zztc.1 */
    class C15241 implements zzso {
        final /* synthetic */ zzsx zzaay;
        final /* synthetic */ int zzaaz;
        final /* synthetic */ zzrw zzafJ;
        final /* synthetic */ zztc zzafK;

        /* renamed from: com.google.android.gms.internal.zztc.1.1 */
        class C15231 implements Runnable {
            final /* synthetic */ C15241 zzafL;

            C15231(C15241 c15241) {
                this.zzafL = c15241;
            }

            public void run() {
                if (this.zzafL.zzafK.zzafI.callServiceStopSelfResult(this.zzafL.zzaaz)) {
                    this.zzafL.zzaay.zzbO("Local AnalyticsService processed last dispatch request");
                }
            }
        }

        C15241(zztc com_google_android_gms_internal_zztc, int i, zzrw com_google_android_gms_internal_zzrw, zzsx com_google_android_gms_internal_zzsx) {
            this.zzafK = com_google_android_gms_internal_zztc;
            this.zzaaz = i;
            this.zzafJ = com_google_android_gms_internal_zzrw;
            this.zzaay = com_google_android_gms_internal_zzsx;
        }

        public void zzf(Throwable th) {
            this.zzafK.mHandler.post(new C15231(this));
        }
    }

    public zztc(zza com_google_android_gms_internal_zztc_zza) {
        this.mContext = com_google_android_gms_internal_zztc_zza.getContext();
        zzac.zzw(this.mContext);
        this.zzafI = com_google_android_gms_internal_zztc_zza;
        this.mHandler = new Handler();
    }

    public static boolean zzU(Context context) {
        zzac.zzw(context);
        if (zzaax != null) {
            return zzaax.booleanValue();
        }
        boolean zzr = zztg.zzr(context, "com.google.android.gms.analytics.AnalyticsService");
        zzaax = Boolean.valueOf(zzr);
        return zzr;
    }

    private void zzlS() {
        try {
            synchronized (zztb.zztU) {
                zzayd com_google_android_gms_internal_zzayd = zztb.zzaav;
                if (com_google_android_gms_internal_zzayd != null && com_google_android_gms_internal_zzayd.isHeld()) {
                    com_google_android_gms_internal_zzayd.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        zzrw.zzW(this.mContext).zznr().zzbO("Local AnalyticsService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzrw.zzW(this.mContext).zznr().zzbO("Local AnalyticsService is shutting down");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int i, int i2) {
        zzlS();
        zzrw zzW = zzrw.zzW(this.mContext);
        zzsx zznr = zzW.zznr();
        if (intent == null) {
            zznr.zzbR("AnalyticsService started with null intent");
        } else {
            String action = intent.getAction();
            zznr.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                zzW.zzlZ().zza(new C15241(this, i2, zzW, zznr));
            }
        }
        return 2;
    }
}
