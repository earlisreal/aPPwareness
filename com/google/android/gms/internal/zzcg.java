package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.Looper;
import java.util.HashMap;

public class zzcg<L, W extends IInterface> {
    private final Looper zzrx;
    private final zza<L, W> zzry;
    private final HashMap<L, W> zzrz;

    public interface zza<L, W extends IInterface> {
        W zza(L l, Looper looper);
    }

    public zzcg(Looper looper, zza<L, W> com_google_android_gms_internal_zzcg_zza_L__W) {
        this.zzrx = looper;
        this.zzry = com_google_android_gms_internal_zzcg_zza_L__W;
        this.zzrz = new HashMap();
    }

    public W zzc(L l) {
        IInterface iInterface = (IInterface) this.zzrz.get(l);
        if (iInterface != null) {
            return iInterface;
        }
        W zza = this.zzry.zza(l, this.zzrx);
        this.zzrz.put(l, zza);
        return zza;
    }
}
