package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzto implements Creator<zztn> {
    static void zza(zztn com_google_android_gms_internal_zztn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zztn.zzagl, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zztn.zzagm, i, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zztn.zzagn);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zztn.zzago, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zztn.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaJ(i);
    }

    public zztn[] zzaJ(int i) {
        return new zztn[i];
    }

    public zztn zzz(Parcel parcel) {
        byte[] bArr = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        int i2 = -1;
        zztv com_google_android_gms_internal_zztv = null;
        String str = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zztv = (zztv) zzb.zza(parcel, zzaT, zztv.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zztn(i, str, com_google_android_gms_internal_zztv, i2, bArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
