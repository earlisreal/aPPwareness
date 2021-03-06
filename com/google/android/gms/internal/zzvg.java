package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzvg extends zza {
    public static final Creator<zzvg> CREATOR;
    final int mVersionCode;
    private final Credential zzaiH;

    static {
        CREATOR = new zzvh();
    }

    zzvg(int i, Credential credential) {
        this.mVersionCode = i;
        this.zzaiH = credential;
    }

    public zzvg(Credential credential) {
        this(1, credential);
    }

    public Credential getCredential() {
        return this.zzaiH;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzvh.zza(this, parcel, i);
    }
}
