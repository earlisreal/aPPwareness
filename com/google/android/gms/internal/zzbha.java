package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzbha extends zza {
    public static final Creator<zzbha> CREATOR;
    public final int type;
    public final int versionCode;
    public final float f18x;
    public final float f19y;

    static {
        CREATOR = new zzbhb();
    }

    public zzbha(int i, float f, float f2, int i2) {
        this.versionCode = i;
        this.f18x = f;
        this.f19y = f2;
        this.type = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbhb.zza(this, parcel, i);
    }
}
