package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public class zztn extends zza {
    public static final Creator<zztn> CREATOR;
    public static final int zzagj;
    private static final zztv zzagk;
    final int mVersionCode;
    public final String zzagl;
    final zztv zzagm;
    public final int zzagn;
    public final byte[] zzago;

    static {
        zzagj = Integer.parseInt("-1");
        CREATOR = new zzto();
        zzagk = new zztv.zza("SsbContext").zzY(true).zzcm("blob").zzqh();
    }

    zztn(int i, String str, zztv com_google_android_gms_internal_zztv, int i2, byte[] bArr) {
        boolean z = i2 == zzagj || zztu.zzaN(i2) != null;
        zzac.zzb(z, "Invalid section type " + i2);
        this.mVersionCode = i;
        this.zzagl = str;
        this.zzagm = com_google_android_gms_internal_zztv;
        this.zzagn = i2;
        this.zzago = bArr;
        String zzqf = zzqf();
        if (zzqf != null) {
            throw new IllegalArgumentException(zzqf);
        }
    }

    public zztn(String str, zztv com_google_android_gms_internal_zztv) {
        this(1, str, com_google_android_gms_internal_zztv, zzagj, null);
    }

    public zztn(String str, zztv com_google_android_gms_internal_zztv, String str2) {
        this(1, str, com_google_android_gms_internal_zztv, zztu.zzcl(str2), null);
    }

    public zztn(byte[] bArr, zztv com_google_android_gms_internal_zztv) {
        this(1, null, com_google_android_gms_internal_zztv, zzagj, bArr);
    }

    public static zztn zzl(byte[] bArr) {
        return new zztn(bArr, zzagk);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzto.zza(this, parcel, i);
    }

    public String zzqf() {
        if (this.zzagn == zzagj || zztu.zzaN(this.zzagn) != null) {
            return (this.zzagl == null || this.zzago == null) ? null : "Both content and blobContent set";
        } else {
            return "Invalid section type " + this.zzagn;
        }
    }
}
