package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtq extends zzbun<zzbtq> {
    public static final zzbuo<Object, zzbtq> zzcqv;
    private static final zzbtq[] zzcqw;
    public int zzcqA;
    public int zzcqB;
    public zzbui zzcqC;
    public zzbtr zzcqD;
    public String[] zzcqE;
    public zzbty zzcqF;
    public String zzcqx;
    public zzbtt zzcqy;
    public int zzcqz;

    static {
        zzcqv = zzbuo.zza(11, zzbtq.class, 855033290);
        zzcqw = new zzbtq[0];
    }

    public zzbtq() {
        this.zzcqx = BuildConfig.FLAVOR;
        this.zzcqz = 0;
        this.zzcqA = 0;
        this.zzcqB = 0;
        this.zzcqE = zzbuw.zzcsn;
        this.zzcsg = -1;
    }

    public static zzbtq zzaa(byte[] bArr) throws zzbus {
        return (zzbtq) zzbut.zza(new zzbtq(), bArr);
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (!(this.zzcqx == null || this.zzcqx.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(1, this.zzcqx);
        }
        if (this.zzcqy != null) {
            com_google_android_gms_internal_zzbum.zza(2, this.zzcqy);
        }
        if (this.zzcqz != 0) {
            com_google_android_gms_internal_zzbum.zzF(4, this.zzcqz);
        }
        if (this.zzcqA != 0) {
            com_google_android_gms_internal_zzbum.zzF(5, this.zzcqA);
        }
        if (this.zzcqB != 0) {
            com_google_android_gms_internal_zzbum.zzF(6, this.zzcqB);
        }
        if (this.zzcqC != null) {
            com_google_android_gms_internal_zzbum.zza(7, this.zzcqC);
        }
        if (this.zzcqD != null) {
            com_google_android_gms_internal_zzbum.zza(8, this.zzcqD);
        }
        if (this.zzcqE != null && this.zzcqE.length > 0) {
            for (String str : this.zzcqE) {
                if (str != null) {
                    com_google_android_gms_internal_zzbum.zzq(9, str);
                }
            }
        }
        if (this.zzcqF != null) {
            com_google_android_gms_internal_zzbum.zza(10, this.zzcqF);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtq zzam(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    this.zzcqx = com_google_android_gms_internal_zzbul.readString();
                    continue;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    if (this.zzcqy == null) {
                        this.zzcqy = new zzbtt();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqy);
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        case Dimension.UNIT_IN /*4*/:
                        case Dimension.UNIT_MM /*5*/:
                        case BuyButtonText.LOGO_ONLY /*6*/:
                        case BuyButtonText.DONATE_WITH /*7*/:
                        case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                        case ConnectionResult.DEVELOPER_ERROR /*10*/:
                            this.zzcqz = zzacu;
                            break;
                        default:
                            continue;
                    }
                case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        case Dimension.UNIT_IN /*4*/:
                        case Dimension.UNIT_MM /*5*/:
                        case BuyButtonText.LOGO_ONLY /*6*/:
                        case BuyButtonText.DONATE_WITH /*7*/:
                        case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                        case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                        case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                        case ConnectionResult.CANCELED /*13*/:
                        case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                        case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                        case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        case ConnectionResult.SIGN_IN_FAILED /*17*/:
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                        case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                        case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                        case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                        case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                        case C0394R.styleable.Toolbar_collapseContentDescription /*23*/:
                        case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                        case C0394R.styleable.Toolbar_navigationContentDescription /*25*/:
                        case C0394R.styleable.Toolbar_logoDescription /*26*/:
                        case C0394R.styleable.Toolbar_titleTextColor /*27*/:
                        case C0394R.styleable.Toolbar_subtitleTextColor /*28*/:
                        case C0394R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                        case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                        case C0394R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                        case Message.MAX_TYPE_LENGTH /*32*/:
                        case C0394R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                        case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        case C0394R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                        case C0394R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                        case C0394R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                        case C0394R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                        case C0394R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                        case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        case C0394R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                        case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        case 10000:
                        case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                        case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                        case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                        case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                        case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /*10006*/:
                        case GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED /*10007*/:
                        case GamesActivityResultCodes.RESULT_INVALID_ROOM /*10008*/:
                        case 10009:
                        case 99999:
                            this.zzcqA = zzacu;
                            break;
                        default:
                            continue;
                    }
                case C0394R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            this.zzcqB = zzacu;
                            break;
                        default:
                            continue;
                    }
                case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    if (this.zzcqC == null) {
                        this.zzcqC = new zzbui();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqC);
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                    if (this.zzcqD == null) {
                        this.zzcqD = new zzbtr();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqD);
                    continue;
                case C0394R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 74);
                    zzacu = this.zzcqE == null ? 0 : this.zzcqE.length;
                    Object obj = new String[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzcqE, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                    this.zzcqE = obj;
                    continue;
                case C0394R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                    if (this.zzcqF == null) {
                        this.zzcqF = new zzbty();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqF);
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzbul, zzacu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzam(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int i = 0;
        int zzv = super.zzv();
        if (!(this.zzcqx == null || this.zzcqx.equals(BuildConfig.FLAVOR))) {
            zzv += zzbum.zzr(1, this.zzcqx);
        }
        if (this.zzcqy != null) {
            zzv += zzbum.zzc(2, this.zzcqy);
        }
        if (this.zzcqz != 0) {
            zzv += zzbum.zzH(4, this.zzcqz);
        }
        if (this.zzcqA != 0) {
            zzv += zzbum.zzH(5, this.zzcqA);
        }
        if (this.zzcqB != 0) {
            zzv += zzbum.zzH(6, this.zzcqB);
        }
        if (this.zzcqC != null) {
            zzv += zzbum.zzc(7, this.zzcqC);
        }
        if (this.zzcqD != null) {
            zzv += zzbum.zzc(8, this.zzcqD);
        }
        if (this.zzcqE != null && this.zzcqE.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i < this.zzcqE.length) {
                String str = this.zzcqE[i];
                if (str != null) {
                    i3++;
                    i2 += zzbum.zzkc(str);
                }
                i++;
            }
            zzv = (zzv + i2) + (i3 * 1);
        }
        return this.zzcqF != null ? zzv + zzbum.zzc(10, this.zzcqF) : zzv;
    }
}
