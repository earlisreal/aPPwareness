package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zztr.zzb;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zztt implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_internal_zztr_zzb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zztr_zzb.zzagv, i, false);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zztr_zzb.zzagw, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zztr_zzb.zzagx, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zztr_zzb.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaM(i);
    }

    public zzb zzC(Parcel parcel) {
        String[] strArr = null;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzaU) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            String[] strArr3;
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaT, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, zztx.CREATOR);
                    strArr2 = strArr3;
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    strArr2 = com.google.android.gms.common.internal.safeparcel.zzb.zzC(parcel, zzaT);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case CardNetwork.OTHER /*1000*/:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    strArr2 = strArr3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzb(i, status, list, strArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzb[] zzaM(int i) {
        return new zzb[i];
    }
}
