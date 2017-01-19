package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzaib implements Creator<zzaia> {
    static void zza(zzaia com_google_android_gms_internal_zzaia, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaia.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaia.zzaMp, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzaia.zzaMq);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzaia.zzaKk, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzaia.zzaMr);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeN(i);
    }

    public zzaia zzcr(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zza com_google_android_gms_drive_zza = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_drive_zza = (zza) zzb.zza(parcel, zzaT, zza.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    list = zzb.zzc(parcel, zzaT, DriveSpace.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaia(i2, com_google_android_gms_drive_zza, i, list, z);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaia[] zzeN(int i) {
        return new zzaia[i];
    }
}
