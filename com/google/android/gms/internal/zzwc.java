package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzwc extends zza {
    public static final Creator<zzwc> CREATOR;
    private final int mVersionCode;
    private final int zzale;
    private final double zzalf;

    static {
        CREATOR = new zzwd();
    }

    zzwc(int i, int i2, double d) {
        this.mVersionCode = i;
        this.zzale = i2;
        this.zzalf = d;
    }

    public static String zzbw(int i) {
        return Integer.toString(i);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        String valueOf = String.valueOf(zzbw(this.zzale));
        return new StringBuilder(String.valueOf(valueOf).length() + 69).append("PowerConnectionState = ").append(valueOf).append(" Battery Percentage = ").append(this.zzalf).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwd.zza(this, parcel, i);
    }

    public int zzrq() {
        return this.zzale;
    }

    public double zzrr() {
        return this.zzalf;
    }
}
