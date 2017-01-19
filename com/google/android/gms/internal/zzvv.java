package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.state.HeadphoneState;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzvv extends zza implements HeadphoneState {
    public static final Creator<zzvv> CREATOR;
    private final int mVersionCode;
    private final int zzala;

    static {
        CREATOR = new zzvw();
    }

    zzvv(int i, int i2) {
        this.mVersionCode = i;
        this.zzala = i2;
    }

    public int getState() {
        return this.zzala;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return Integer.toString(this.zzala);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzvw.zza(this, parcel, i);
    }
}
