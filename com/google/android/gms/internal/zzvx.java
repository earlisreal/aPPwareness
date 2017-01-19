package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzvx extends zza {
    public static final Creator<zzvx> CREATOR;
    private final int mVersionCode;
    private final int zzalb;
    private final int zzalc;

    static {
        CREATOR = new zzvy();
    }

    zzvx(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.zzalb = i2;
        this.zzalc = i3;
    }

    public static String zzbs(int i) {
        return Integer.toString(i);
    }

    public static String zzbt(int i) {
        return Integer.toString(i);
    }

    public int getConnectionState() {
        return this.zzalb;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        String valueOf = String.valueOf(zzbs(this.zzalb));
        String valueOf2 = String.valueOf(zzbt(this.zzalc));
        return new StringBuilder((String.valueOf(valueOf).length() + 41) + String.valueOf(valueOf2).length()).append("ConnectionState = ").append(valueOf).append(" NetworkMeteredState = ").append(valueOf2).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzvy.zza(this, parcel, i);
    }

    int zzro() {
        return this.zzalc;
    }
}
