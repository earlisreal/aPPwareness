package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzbtx.zzb;

public class zzce extends zza {
    public static final Creator<zzce> CREATOR;
    private final int mVersionCode;
    private final zzb zzrw;

    static {
        CREATOR = new zzcf();
    }

    zzce(int i, byte[] bArr) {
        this.mVersionCode = i;
        zzb com_google_android_gms_internal_zzbtx_zzb = null;
        try {
            com_google_android_gms_internal_zzbtx_zzb = zzb.zzac(bArr);
        } catch (Throwable e) {
            Log.e("InterestRecordStub", "Could not deserialize interest bytes.", e);
        }
        this.zzrw = com_google_android_gms_internal_zzbtx_zzb;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzcf.zza(this, parcel, i);
    }

    byte[] zzbo() {
        return zzbut.zzf(this.zzrw);
    }
}
