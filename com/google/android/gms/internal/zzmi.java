package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

public class zzmi implements Creator<zzmh> {
    static void zza(zzmh com_google_android_gms_internal_zzmh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzmh.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzmh.zzRc, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzmh.zzRd, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzmh.zzvj, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzmh.zzvd, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzmh.applicationInfo, i, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzmh.zzRe, i, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzmh.zzRf, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzmh.zzRg, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzmh.zzRh, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzmh.zzvf, i, false);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzmh.zzRi, false);
        zzc.zzc(parcel, 13, com_google_android_gms_internal_zzmh.zzRj);
        zzc.zzb(parcel, 14, com_google_android_gms_internal_zzmh.zzvB, false);
        zzc.zza(parcel, 15, com_google_android_gms_internal_zzmh.zzRk, false);
        zzc.zza(parcel, 16, com_google_android_gms_internal_zzmh.zzRl);
        zzc.zza(parcel, 17, com_google_android_gms_internal_zzmh.zzRm, i, false);
        zzc.zzc(parcel, 18, com_google_android_gms_internal_zzmh.zzRn);
        zzc.zzc(parcel, 19, com_google_android_gms_internal_zzmh.zzRo);
        zzc.zza(parcel, 20, com_google_android_gms_internal_zzmh.zzxa);
        zzc.zza(parcel, 21, com_google_android_gms_internal_zzmh.zzRp, false);
        zzc.zza(parcel, 25, com_google_android_gms_internal_zzmh.zzRq);
        zzc.zza(parcel, 26, com_google_android_gms_internal_zzmh.zzRr, false);
        zzc.zzb(parcel, 27, com_google_android_gms_internal_zzmh.zzRs, false);
        zzc.zza(parcel, 28, com_google_android_gms_internal_zzmh.zzvc, false);
        zzc.zza(parcel, 29, com_google_android_gms_internal_zzmh.zzvx, i, false);
        zzc.zzb(parcel, 30, com_google_android_gms_internal_zzmh.zzRt, false);
        zzc.zza(parcel, 31, com_google_android_gms_internal_zzmh.zzRu);
        zzc.zza(parcel, 32, com_google_android_gms_internal_zzmh.zzRv, i, false);
        zzc.zza(parcel, 33, com_google_android_gms_internal_zzmh.zzRw, false);
        zzc.zza(parcel, 34, com_google_android_gms_internal_zzmh.zzRx);
        zzc.zzc(parcel, 35, com_google_android_gms_internal_zzmh.zzRy);
        zzc.zzc(parcel, 36, com_google_android_gms_internal_zzmh.zzRz);
        zzc.zza(parcel, 37, com_google_android_gms_internal_zzmh.zzRA);
        zzc.zza(parcel, 38, com_google_android_gms_internal_zzmh.zzRB);
        zzc.zza(parcel, 39, com_google_android_gms_internal_zzmh.zzRC, false);
        zzc.zza(parcel, 40, com_google_android_gms_internal_zzmh.zzRD);
        zzc.zza(parcel, 41, com_google_android_gms_internal_zzmh.zzRE, false);
        zzc.zza(parcel, 42, com_google_android_gms_internal_zzmh.zzKc);
        zzc.zzc(parcel, 43, com_google_android_gms_internal_zzmh.zzRF);
        zzc.zza(parcel, 44, com_google_android_gms_internal_zzmh.zzRG, false);
        zzc.zza(parcel, 45, com_google_android_gms_internal_zzmh.zzRH, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzT(i);
    }

    public zzmh[] zzT(int i) {
        return new zzmh[i];
    }

    public zzmh zzm(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Bundle bundle = null;
        zzdy com_google_android_gms_internal_zzdy = null;
        zzec com_google_android_gms_internal_zzec = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzqa com_google_android_gms_internal_zzqa = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        zzgw com_google_android_gms_internal_zzgw = null;
        List list3 = null;
        long j2 = 0;
        zzmo com_google_android_gms_internal_zzmo = null;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        String str11 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com_google_android_gms_internal_zzdy = (zzdy) zzb.zza(parcel, zzaT, zzdy.CREATOR);
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com_google_android_gms_internal_zzec = (zzec) zzb.zza(parcel, zzaT, zzec.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    applicationInfo = (ApplicationInfo) zzb.zza(parcel, zzaT, ApplicationInfo.CREATOR);
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    packageInfo = (PackageInfo) zzb.zza(parcel, zzaT, PackageInfo.CREATOR);
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    com_google_android_gms_internal_zzqa = (zzqa) zzb.zza(parcel, zzaT, zzqa.CREATOR);
                    break;
                case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    bundle2 = zzb.zzs(parcel, zzaT);
                    break;
                case ConnectionResult.CANCELED /*13*/:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    bundle3 = zzb.zzs(parcel, zzaT);
                    break;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    messenger = (Messenger) zzb.zza(parcel, zzaT, Messenger.CREATOR);
                    break;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case C0394R.styleable.Toolbar_navigationContentDescription /*25*/:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case C0394R.styleable.Toolbar_logoDescription /*26*/:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case C0394R.styleable.Toolbar_titleTextColor /*27*/:
                    list2 = zzb.zzE(parcel, zzaT);
                    break;
                case C0394R.styleable.Toolbar_subtitleTextColor /*28*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    com_google_android_gms_internal_zzgw = (zzgw) zzb.zza(parcel, zzaT, zzgw.CREATOR);
                    break;
                case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                    list3 = zzb.zzE(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    com_google_android_gms_internal_zzmo = (zzmo) zzb.zza(parcel, zzaT, zzmo.CREATOR);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    f2 = zzb.zzl(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                    i6 = zzb.zzg(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    z4 = zzb.zzc(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    str9 = zzb.zzq(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    str10 = zzb.zzq(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    z5 = zzb.zzc(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    i7 = zzb.zzg(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    bundle4 = zzb.zzs(parcel, zzaT);
                    break;
                case C0394R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    str11 = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzmh(i, bundle, com_google_android_gms_internal_zzdy, com_google_android_gms_internal_zzec, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzqa, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, j, str6, list2, str7, com_google_android_gms_internal_zzgw, list3, j2, com_google_android_gms_internal_zzmo, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
