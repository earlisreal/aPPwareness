package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzwo implements Creator<zzwn> {
    static void zza(zzwn com_google_android_gms_internal_zzwn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzwn.getVersionCode());
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzwn.zzrG());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzwn.zzrF());
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzwn.zzrE());
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzwn.getHumidity());
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzwn.getConditions(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzak(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbC(i);
    }

    public zzwn zzak(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzaU = zzb.zzaU(parcel);
        int[] iArr = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    f3 = zzb.zzl(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    f2 = zzb.zzl(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    iArr = zzb.zzw(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzwn(i2, f3, f2, f, i, iArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzwn[] zzbC(int i) {
        return new zzwn[i];
    }
}
