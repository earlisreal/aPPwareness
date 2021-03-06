package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public final class zznx extends zza {
    public static final Creator<zznx> CREATOR;
    public final int versionCode;
    public final zzdy zzRd;
    public final String zzvd;

    static {
        CREATOR = new zzny();
    }

    public zznx(int i, zzdy com_google_android_gms_internal_zzdy, String str) {
        this.versionCode = i;
        this.zzRd = com_google_android_gms_internal_zzdy;
        this.zzvd = str;
    }

    public zznx(zzdy com_google_android_gms_internal_zzdy, String str) {
        this(1, com_google_android_gms_internal_zzdy, str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzny.zza(this, parcel, i);
    }
}
