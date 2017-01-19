package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzvu implements Creator<zzvt> {
    static void zza(zzvt com_google_android_gms_internal_zzvt, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzvt.getVersionCode());
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzvt.zzrn(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzab(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbq(i);
    }

    public zzvt zzab(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    iArr = zzb.zzw(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzvt(i, iArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzvt[] zzbq(int i) {
        return new zzvt[i];
    }
}
