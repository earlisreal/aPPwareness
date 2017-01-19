package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zztk implements Creator<zztj> {
    static void zza(zztj com_google_android_gms_internal_zztj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zztj.zzaga, i, false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zztj.zzagb, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zztj.zzagc);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zztj.account, i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zztj.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaH(i);
    }

    public zztj[] zzaH(int i) {
        return new zztj[i];
    }

    public zztj zzx(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        zztn[] com_google_android_gms_internal_zztnArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    com_google_android_gms_internal_zztnArr = (zztn[]) zzb.zzb(parcel, zzaT, zztn.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    account = (Account) zzb.zza(parcel, zzaT, Account.CREATOR);
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
            return new zztj(i, com_google_android_gms_internal_zztnArr, str, z, account);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
