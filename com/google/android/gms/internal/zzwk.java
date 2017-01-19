package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;

public class zzwk implements Creator<zzwj> {
    static void zza(zzwj com_google_android_gms_internal_zzwj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzwj.getVersionCode());
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzwj.zzrB());
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzwj.zzrC(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzai(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbA(i);
    }

    public zzwj zzai(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        ArrayList arrayList = null;
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
                    arrayList = zzb.zzc(parcel, zzaT, zzvr.zzb.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzwj(i2, i, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzwj[] zzbA(int i) {
        return new zzwj[i];
    }
}
