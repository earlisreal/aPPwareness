package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzwd implements Creator<zzwc> {
    static void zza(zzwc com_google_android_gms_internal_zzwc, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzwc.getVersionCode());
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzwc.zzrq());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzwc.zzrr());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbx(i);
    }

    public zzwc zzaf(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        double d = 0.0d;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    d = zzb.zzn(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzwc(i2, i, d);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzwc[] zzbx(int i) {
        return new zzwc[i];
    }
}
