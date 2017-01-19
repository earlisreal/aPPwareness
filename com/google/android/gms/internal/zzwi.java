package com.google.android.gms.internal;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzwi implements Creator<zzwg> {
    static void zza(zzwg com_google_android_gms_internal_zzwg, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzwg.getVersionCode());
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzwg.getActivityRecognitionResult(), i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzwg.zzrt(), i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzwg.zzru(), i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzwg.getLocation(), i, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzwg.zzrv(), i, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzwg.zzrw(), i, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzwg.zzrx(), i, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzwg.zzry(), i, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzwg.zzrz(), i, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzwg.zzrA(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzah(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbz(i);
    }

    public zzwg zzah(Parcel parcel) {
        zzvt com_google_android_gms_internal_zzvt = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzwn com_google_android_gms_internal_zzwn = null;
        zzwe com_google_android_gms_internal_zzwe = null;
        zzwc com_google_android_gms_internal_zzwc = null;
        DataHolder dataHolder = null;
        zzvx com_google_android_gms_internal_zzvx = null;
        Location location = null;
        zzvv com_google_android_gms_internal_zzvv = null;
        zzvr com_google_android_gms_internal_zzvr = null;
        ActivityRecognitionResult activityRecognitionResult = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    activityRecognitionResult = (ActivityRecognitionResult) zzb.zza(parcel, zzaT, ActivityRecognitionResult.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zzvr = (zzvr) zzb.zza(parcel, zzaT, zzvr.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_internal_zzvv = (zzvv) zzb.zza(parcel, zzaT, zzvv.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    location = (Location) zzb.zza(parcel, zzaT, Location.CREATOR);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    com_google_android_gms_internal_zzvx = (zzvx) zzb.zza(parcel, zzaT, zzvx.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    com_google_android_gms_internal_zzwc = (zzwc) zzb.zza(parcel, zzaT, zzwc.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    com_google_android_gms_internal_zzwe = (zzwe) zzb.zza(parcel, zzaT, zzwe.CREATOR);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    com_google_android_gms_internal_zzwn = (zzwn) zzb.zza(parcel, zzaT, zzwn.CREATOR);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    com_google_android_gms_internal_zzvt = (zzvt) zzb.zza(parcel, zzaT, zzvt.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzwg(i, activityRecognitionResult, com_google_android_gms_internal_zzvr, com_google_android_gms_internal_zzvv, location, com_google_android_gms_internal_zzvx, dataHolder, com_google_android_gms_internal_zzwc, com_google_android_gms_internal_zzwe, com_google_android_gms_internal_zzwn, com_google_android_gms_internal_zzvt);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzwg[] zzbz(int i) {
        return new zzwg[i];
    }
}
