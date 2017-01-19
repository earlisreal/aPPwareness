package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzwe extends zza {
    public static final Creator<zzwe> CREATOR;
    private final int mVersionCode;
    private final int zzalg;

    static {
        CREATOR = new zzwf();
    }

    zzwe(int i, int i2) {
        this.mVersionCode = i;
        this.zzalg = i2;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return this.zzalg == 1 ? "ScreenState: SCREEN_OFF" : this.zzalg == 2 ? "ScreenState: SCREEN_ON" : "ScreenState: UNKNOWN";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwf.zza(this, parcel, i);
    }

    public int zzrs() {
        return this.zzalg;
    }
}
