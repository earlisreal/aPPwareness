package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.zze;
import java.util.concurrent.Callable;

@zzmb
public class zzfw {
    private final ConditionVariable zzAM;
    @Nullable
    private SharedPreferences zzAN;
    private final Object zzrN;
    private volatile boolean zztW;

    /* renamed from: com.google.android.gms.internal.zzfw.1 */
    class C12951 implements Callable<T> {
        final /* synthetic */ zzft zzAO;
        final /* synthetic */ zzfw zzAP;

        C12951(zzfw com_google_android_gms_internal_zzfw, zzft com_google_android_gms_internal_zzft) {
            this.zzAP = com_google_android_gms_internal_zzfw;
            this.zzAO = com_google_android_gms_internal_zzft;
        }

        public T call() {
            return this.zzAO.zza(this.zzAP.zzAN);
        }
    }

    public zzfw() {
        this.zzrN = new Object();
        this.zzAM = new ConditionVariable();
        this.zztW = false;
        this.zzAN = null;
    }

    public void initialize(Context context) {
        if (!this.zztW) {
            synchronized (this.zzrN) {
                if (this.zztW) {
                    return;
                }
                try {
                    Context remoteContext = zze.getRemoteContext(context);
                    if (remoteContext == null) {
                        return;
                    }
                    this.zzAN = zzv.zzcT().zzm(remoteContext);
                    this.zztW = true;
                    this.zzAM.open();
                } finally {
                    this.zzAM.open();
                }
            }
        }
    }

    public <T> T zzd(zzft<T> com_google_android_gms_internal_zzft_T) {
        if (this.zzAM.block(5000)) {
            if (!this.zztW) {
                synchronized (this.zzrN) {
                    if (this.zztW) {
                    } else {
                        T zzfm = com_google_android_gms_internal_zzft_T.zzfm();
                        return zzfm;
                    }
                }
            }
            return zzpv.zzb(new C12951(this, com_google_android_gms_internal_zzft_T));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }
}
