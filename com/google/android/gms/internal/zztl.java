package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zztl extends zza {
    public static final Creator<zztl> CREATOR;
    final int mVersionCode;
    final String zzQL;
    final String zzagh;
    final String zzagi;

    static {
        CREATOR = new zztm();
    }

    zztl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzQL = str;
        this.zzagh = str2;
        this.zzagi = str3;
    }

    public zztl(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zzQL, this.zzagh, this.zzagi});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zztm.zza(this, parcel, i);
    }
}
