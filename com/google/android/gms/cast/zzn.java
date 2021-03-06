package com.google.android.gms.cast;

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

public class zzn implements Creator<TextTrackStyle> {
    static void zza(TextTrackStyle textTrackStyle, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, textTrackStyle.getVersionCode());
        zzc.zza(parcel, 2, textTrackStyle.getFontScale());
        zzc.zzc(parcel, 3, textTrackStyle.getForegroundColor());
        zzc.zzc(parcel, 4, textTrackStyle.getBackgroundColor());
        zzc.zzc(parcel, 5, textTrackStyle.getEdgeType());
        zzc.zzc(parcel, 6, textTrackStyle.getEdgeColor());
        zzc.zzc(parcel, 7, textTrackStyle.getWindowType());
        zzc.zzc(parcel, 8, textTrackStyle.getWindowColor());
        zzc.zzc(parcel, 9, textTrackStyle.getWindowCornerRadius());
        zzc.zza(parcel, 10, textTrackStyle.getFontFamily(), false);
        zzc.zzc(parcel, 11, textTrackStyle.getFontGenericFamily());
        zzc.zzc(parcel, 12, textTrackStyle.getFontStyle());
        zzc.zza(parcel, 13, textTrackStyle.zzalH, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzax(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbS(i);
    }

    public TextTrackStyle zzax(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        String str = null;
        int i9 = 0;
        int i10 = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    i6 = zzb.zzg(parcel, zzaT);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    i7 = zzb.zzg(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i8 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i9 = zzb.zzg(parcel, zzaT);
                    break;
                case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    i10 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.CANCELED /*13*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new TextTrackStyle(i, f, i2, i3, i4, i5, i6, i7, i8, str, i9, i10, str2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public TextTrackStyle[] zzbS(int i) {
        return new TextTrackStyle[i];
    }
}
