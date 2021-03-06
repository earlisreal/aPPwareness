package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzbhl implements Creator<zzbhk> {
    static void zza(zzbhk com_google_android_gms_internal_zzbhk, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzbhk.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzbhk.zzbNB, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzbhk.zzbNC, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzbhk.zzbND, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzbhk.zzbNE, i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzbhk.zzbNF, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzbhk.zzbNG);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzbhk.zzbNw, false);
        zzc.zzc(parcel, 9, com_google_android_gms_internal_zzbhk.zzbNH);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzbhk.zzbNI);
        zzc.zzc(parcel, 11, com_google_android_gms_internal_zzbhk.zzbNJ);
        zzc.zzc(parcel, 12, com_google_android_gms_internal_zzbhk.zzbNK);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznD(i);
    }

    public zzbhk zzjm(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzbht[] com_google_android_gms_internal_zzbhtArr = null;
        zzbhg com_google_android_gms_internal_zzbhg = null;
        zzbhg com_google_android_gms_internal_zzbhg2 = null;
        zzbhg com_google_android_gms_internal_zzbhg3 = null;
        String str = null;
        float f = 0.0f;
        String str2 = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com_google_android_gms_internal_zzbhtArr = (zzbht[]) zzb.zzb(parcel, zzaT, zzbht.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zzbhg = (zzbhg) zzb.zza(parcel, zzaT, zzbhg.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_internal_zzbhg2 = (zzbhg) zzb.zza(parcel, zzaT, zzbhg.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com_google_android_gms_internal_zzbhg3 = (zzbhg) zzb.zza(parcel, zzaT, zzbhg.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzbhk(i, com_google_android_gms_internal_zzbhtArr, com_google_android_gms_internal_zzbhg, com_google_android_gms_internal_zzbhg2, com_google_android_gms_internal_zzbhg3, str, f, str2, i2, z, i3, i4);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzbhk[] zznD(int i) {
        return new zzbhk[i];
    }
}
