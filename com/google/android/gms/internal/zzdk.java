package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzda.zzb;

@zzmb
public class zzdk {
    @Nullable
    private Context mContext;
    private final Object zzrN;
    private final Runnable zzys;
    @Nullable
    private zzdn zzyt;
    @Nullable
    private zzdr zzyu;

    /* renamed from: com.google.android.gms.internal.zzdk.1 */
    class C12711 implements Runnable {
        final /* synthetic */ zzdk zzyv;

        C12711(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void run() {
            this.zzyv.disconnect();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdk.2 */
    class C12722 implements zzb {
        final /* synthetic */ zzdk zzyv;

        C12722(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void zzk(boolean z) {
            if (z) {
                this.zzyv.connect();
            } else {
                this.zzyv.disconnect();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdk.3 */
    class C12733 implements zzf.zzb {
        final /* synthetic */ zzdk zzyv;

        C12733(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void onConnected(@Nullable Bundle bundle) {
            synchronized (this.zzyv.zzrN) {
                try {
                    this.zzyv.zzyu = this.zzyv.zzyt.zzew();
                } catch (Throwable e) {
                    zzpy.zzb("Unable to obtain a cache service instance.", e);
                    this.zzyv.disconnect();
                }
                this.zzyv.zzrN.notifyAll();
            }
        }

        public void onConnectionSuspended(int i) {
            synchronized (this.zzyv.zzrN) {
                this.zzyv.zzyt = null;
                this.zzyv.zzyu = null;
                this.zzyv.zzrN.notifyAll();
                zzv.zzcZ().zzkD();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdk.4 */
    class C12744 implements zzc {
        final /* synthetic */ zzdk zzyv;

        C12744(zzdk com_google_android_gms_internal_zzdk) {
            this.zzyv = com_google_android_gms_internal_zzdk;
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            synchronized (this.zzyv.zzrN) {
                this.zzyv.zzyt = null;
                this.zzyv.zzyu = null;
                this.zzyv.zzrN.notifyAll();
                zzv.zzcZ().zzkD();
            }
        }
    }

    public zzdk() {
        this.zzys = new C12711(this);
        this.zzrN = new Object();
    }

    private void connect() {
        synchronized (this.zzrN) {
            if (this.mContext == null || this.zzyt != null) {
                return;
            }
            this.zzyt = zza(new C12733(this), new C12744(this));
            this.zzyt.zzwT();
        }
    }

    private void disconnect() {
        synchronized (this.zzrN) {
            if (this.zzyt == null) {
                return;
            }
            if (this.zzyt.isConnected() || this.zzyt.isConnecting()) {
                this.zzyt.disconnect();
            }
            this.zzyt = null;
            this.zzyu = null;
            Binder.flushPendingCommands();
            zzv.zzcZ().zzkD();
        }
    }

    public void initialize(Context context) {
        if (context != null) {
            synchronized (this.zzrN) {
                if (this.mContext != null) {
                    return;
                }
                this.mContext = context.getApplicationContext();
                if (((Boolean) zzfx.zzEL.get()).booleanValue()) {
                    connect();
                } else if (((Boolean) zzfx.zzEK.get()).booleanValue()) {
                    zza(new C12722(this));
                }
            }
        }
    }

    public zzdl zza(zzdo com_google_android_gms_internal_zzdo) {
        zzdl com_google_android_gms_internal_zzdl;
        synchronized (this.zzrN) {
            if (this.zzyu == null) {
                com_google_android_gms_internal_zzdl = new zzdl();
            } else {
                try {
                    com_google_android_gms_internal_zzdl = this.zzyu.zza(com_google_android_gms_internal_zzdo);
                } catch (Throwable e) {
                    zzpy.zzb("Unable to call into cache service.", e);
                    com_google_android_gms_internal_zzdl = new zzdl();
                }
            }
        }
        return com_google_android_gms_internal_zzdl;
    }

    protected zzdn zza(zzf.zzb com_google_android_gms_common_internal_zzf_zzb, zzc com_google_android_gms_common_internal_zzf_zzc) {
        return new zzdn(this.mContext, zzv.zzcZ().zzkC(), com_google_android_gms_common_internal_zzf_zzb, com_google_android_gms_common_internal_zzf_zzc);
    }

    protected void zza(zzb com_google_android_gms_internal_zzda_zzb) {
        zzv.zzcM().zza(com_google_android_gms_internal_zzda_zzb);
    }

    public void zzeq() {
        if (((Boolean) zzfx.zzEM.get()).booleanValue()) {
            synchronized (this.zzrN) {
                connect();
                zzv.zzcJ();
                zzpi.zzWR.removeCallbacks(this.zzys);
                zzv.zzcJ();
                zzpi.zzWR.postDelayed(this.zzys, ((Long) zzfx.zzEN.get()).longValue());
            }
        }
    }
}
