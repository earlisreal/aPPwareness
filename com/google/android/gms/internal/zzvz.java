package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.internal.zzp;
import java.util.ArrayList;
import java.util.List;

public final class zzvz extends zza {
    public static final Creator<zzvz> CREATOR;
    private final int mVersionCode;
    private final ArrayList<zzp> zzald;

    static {
        CREATOR = new zzwb();
    }

    zzvz(int i, ArrayList<zzp> arrayList) {
        this.mVersionCode = i;
        this.zzald = arrayList;
    }

    public List<PlaceLikelihood> getPlaceLikelihoods() {
        return this.zzald;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwb.zza(this, parcel, i);
    }

    ArrayList<zzp> zzrp() {
        return this.zzald;
    }
}
