package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zztp extends zza {
    public static final Creator<zztp> CREATOR;
    public final int id;
    final int mVersionCode;
    final Bundle zzagp;

    static {
        CREATOR = new zztq();
    }

    zztp(int i, int i2, Bundle bundle) {
        this.mVersionCode = i;
        this.id = i2;
        this.zzagp = bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zztp)) {
            return false;
        }
        zztp com_google_android_gms_internal_zztp = (zztp) obj;
        return zzaa.equal(Integer.valueOf(com_google_android_gms_internal_zztp.id), Integer.valueOf(this.id)) && zzaa.equal(com_google_android_gms_internal_zztp.zzagp, this.zzagp);
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.id), this.zzagp);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zztq.zza(this, parcel, i);
    }
}
