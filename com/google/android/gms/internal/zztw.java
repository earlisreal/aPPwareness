package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zztw implements Creator<zztv> {
    static void zza(zztv com_google_android_gms_internal_zztv, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zztv.name, false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zztv.zzagA, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zztv.zzagB);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zztv.weight);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zztv.zzagC);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zztv.zzagD, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zztv.zzagE, i, false);
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_internal_zztv.mVersionCode);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zztv.zzagF, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zztv.zzagG, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaP(i);
    }

    public zztv zzD(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 1;
        int[] iArr = null;
        zztp[] com_google_android_gms_internal_zztpArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    com_google_android_gms_internal_zztpArr = (zztp[]) zzb.zzb(parcel, zzaT, zztp.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    iArr = zzb.zzw(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case CardNetwork.OTHER /*1000*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zztv(i2, str4, str3, z2, i, z, str2, com_google_android_gms_internal_zztpArr, iArr, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zztv[] zzaP(int i) {
        return new zztv[i];
    }
}
