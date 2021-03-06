package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbhb implements Creator<zzbha> {
    static void zza(zzbha com_google_android_gms_internal_zzbha, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzbha.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzbha.f18x);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzbha.f19y);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzbha.type);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznz(i);
    }

    public zzbha zzjj(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzaU = zzb.zzaU(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    f2 = zzb.zzl(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbha(i2, f2, f, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbha[] zznz(int i) {
        return new zzbha[i];
    }
}
