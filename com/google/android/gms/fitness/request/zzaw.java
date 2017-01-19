package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzaw implements Creator<zzav> {
    static void zza(zzav com_google_android_gms_fitness_request_zzav, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_fitness_request_zzav.getDataSource(), i, false);
        zzc.zza(parcel, 2, com_google_android_gms_fitness_request_zzav.getDataType(), i, false);
        zzc.zza(parcel, 3, com_google_android_gms_fitness_request_zzav.zzCt(), false);
        zzc.zzc(parcel, 4, com_google_android_gms_fitness_request_zzav.zzaVO);
        zzc.zzc(parcel, 5, com_google_android_gms_fitness_request_zzav.zzaVP);
        zzc.zza(parcel, 6, com_google_android_gms_fitness_request_zzav.zzBK());
        zzc.zza(parcel, 7, com_google_android_gms_fitness_request_zzav.zzCq());
        zzc.zzc(parcel, CardNetwork.OTHER, com_google_android_gms_fitness_request_zzav.getVersionCode());
        zzc.zza(parcel, 8, com_google_android_gms_fitness_request_zzav.getIntent(), i, false);
        zzc.zza(parcel, 9, com_google_android_gms_fitness_request_zzav.zzCp());
        zzc.zzc(parcel, 10, com_google_android_gms_fitness_request_zzav.getAccuracyMode());
        zzc.zzc(parcel, 11, com_google_android_gms_fitness_request_zzav.zzCr(), false);
        zzc.zza(parcel, 12, com_google_android_gms_fitness_request_zzav.zzCs());
        zzc.zza(parcel, 13, com_google_android_gms_fitness_request_zzav.getCallbackBinder(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhv(i);
    }

    public zzav zzeM(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    dataSource = (DataSource) zzb.zza(parcel, zzaT, DataSource.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    dataType = (DataType) zzb.zza(parcel, zzaT, DataType.CREATOR);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    list = zzb.zzc(parcel, zzaT, LocationRequest.CREATOR);
                    break;
                case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    j4 = zzb.zzi(parcel, zzaT);
                    break;
                case ConnectionResult.CANCELED /*13*/:
                    iBinder2 = zzb.zzr(parcel, zzaT);
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
            return new zzav(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4, iBinder2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzav[] zzhv(int i) {
        return new zzav[i];
    }
}
