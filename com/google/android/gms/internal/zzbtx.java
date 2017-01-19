package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.ads.AdSize;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.util.Arrays;

public interface zzbtx {

    public static final class zza extends zzbun<zza> {
        public int type;
        public long zzcrb;

        public zza() {
            this.type = 0;
            this.zzcrb = 0;
            this.zzcsg = -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbtx_zza = (zza) obj;
            return (this.type == com_google_android_gms_internal_zzbtx_zza.type && this.zzcrb == com_google_android_gms_internal_zzbtx_zza.zzcrb) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtx_zza.zzcrX == null || com_google_android_gms_internal_zzbtx_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtx_zza.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + ((int) (this.zzcrb ^ (this.zzcrb >>> 32)))) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.type != 0) {
                com_google_android_gms_internal_zzbum.zzF(1, this.type);
            }
            if (this.zzcrb != 0) {
                com_google_android_gms_internal_zzbum.zzb(2, this.zzcrb);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zza zzat(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                this.type = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.zzcrb = com_google_android_gms_internal_zzbul.zzacx();
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
            return zzat(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.type != 0) {
                zzv += zzbum.zzH(1, this.type);
            }
            return this.zzcrb != 0 ? zzv + zzbum.zzf(2, this.zzcrb) : zzv;
        }
    }

    public static final class zzb extends zzbun<zzb> {
        public int zzcqA;
        public long zzcrc;
        public zzc zzcrd;
        public zzd zzcre;
        public zze zzcrf;
        public zza zzcrg;
        public zza zzcrh;

        public static final class zza extends zzbun<zza> {
            public String moduleId;
            public String packageName;
            public String zzcri;

            public zza() {
                this.packageName = BuildConfig.FLAVOR;
                this.moduleId = BuildConfig.FLAVOR;
                this.zzcri = BuildConfig.FLAVOR;
                this.zzcsg = -1;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzbtx_zzb_zza = (zza) obj;
                if (this.packageName == null) {
                    if (com_google_android_gms_internal_zzbtx_zzb_zza.packageName != null) {
                        return false;
                    }
                } else if (!this.packageName.equals(com_google_android_gms_internal_zzbtx_zzb_zza.packageName)) {
                    return false;
                }
                if (this.moduleId == null) {
                    if (com_google_android_gms_internal_zzbtx_zzb_zza.moduleId != null) {
                        return false;
                    }
                } else if (!this.moduleId.equals(com_google_android_gms_internal_zzbtx_zzb_zza.moduleId)) {
                    return false;
                }
                if (this.zzcri == null) {
                    if (com_google_android_gms_internal_zzbtx_zzb_zza.zzcri != null) {
                        return false;
                    }
                } else if (!this.zzcri.equals(com_google_android_gms_internal_zzbtx_zzb_zza.zzcri)) {
                    return false;
                }
                return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtx_zzb_zza.zzcrX == null || com_google_android_gms_internal_zzbtx_zzb_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtx_zzb_zza.zzcrX);
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzcri == null ? 0 : this.zzcri.hashCode()) + (((this.moduleId == null ? 0 : this.moduleId.hashCode()) + (((this.packageName == null ? 0 : this.packageName.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
                if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                    i = this.zzcrX.hashCode();
                }
                return hashCode + i;
            }

            public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
                if (!(this.packageName == null || this.packageName.equals(BuildConfig.FLAVOR))) {
                    com_google_android_gms_internal_zzbum.zzq(1, this.packageName);
                }
                if (!(this.moduleId == null || this.moduleId.equals(BuildConfig.FLAVOR))) {
                    com_google_android_gms_internal_zzbum.zzq(2, this.moduleId);
                }
                if (!(this.zzcri == null || this.zzcri.equals(BuildConfig.FLAVOR))) {
                    com_google_android_gms_internal_zzbum.zzq(3, this.zzcri);
                }
                super.zza(com_google_android_gms_internal_zzbum);
            }

            public zza zzav(zzbul com_google_android_gms_internal_zzbul) throws IOException {
                while (true) {
                    int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                            break;
                        case ConnectionResult.DEVELOPER_ERROR /*10*/:
                            this.packageName = com_google_android_gms_internal_zzbul.readString();
                            continue;
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                            this.moduleId = com_google_android_gms_internal_zzbul.readString();
                            continue;
                        case C0394R.styleable.Toolbar_logoDescription /*26*/:
                            this.zzcri = com_google_android_gms_internal_zzbul.readString();
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
                return zzav(com_google_android_gms_internal_zzbul);
            }

            protected int zzv() {
                int zzv = super.zzv();
                if (!(this.packageName == null || this.packageName.equals(BuildConfig.FLAVOR))) {
                    zzv += zzbum.zzr(1, this.packageName);
                }
                if (!(this.moduleId == null || this.moduleId.equals(BuildConfig.FLAVOR))) {
                    zzv += zzbum.zzr(2, this.moduleId);
                }
                return (this.zzcri == null || this.zzcri.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(3, this.zzcri);
            }
        }

        public zzb() {
            this.zzcrc = 0;
            this.zzcqA = 0;
            this.zzcsg = -1;
        }

        public static zzb zzac(byte[] bArr) throws zzbus {
            return (zzb) zzbut.zza(new zzb(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzbtx_zzb = (zzb) obj;
            if (this.zzcrc != com_google_android_gms_internal_zzbtx_zzb.zzcrc || this.zzcqA != com_google_android_gms_internal_zzbtx_zzb.zzcqA) {
                return false;
            }
            if (this.zzcrd == null) {
                if (com_google_android_gms_internal_zzbtx_zzb.zzcrd != null) {
                    return false;
                }
            } else if (!this.zzcrd.equals(com_google_android_gms_internal_zzbtx_zzb.zzcrd)) {
                return false;
            }
            if (this.zzcre == null) {
                if (com_google_android_gms_internal_zzbtx_zzb.zzcre != null) {
                    return false;
                }
            } else if (!this.zzcre.equals(com_google_android_gms_internal_zzbtx_zzb.zzcre)) {
                return false;
            }
            if (this.zzcrf == null) {
                if (com_google_android_gms_internal_zzbtx_zzb.zzcrf != null) {
                    return false;
                }
            } else if (!this.zzcrf.equals(com_google_android_gms_internal_zzbtx_zzb.zzcrf)) {
                return false;
            }
            if (this.zzcrg == null) {
                if (com_google_android_gms_internal_zzbtx_zzb.zzcrg != null) {
                    return false;
                }
            } else if (!this.zzcrg.equals(com_google_android_gms_internal_zzbtx_zzb.zzcrg)) {
                return false;
            }
            if (this.zzcrh == null) {
                if (com_google_android_gms_internal_zzbtx_zzb.zzcrh != null) {
                    return false;
                }
            } else if (!this.zzcrh.equals(com_google_android_gms_internal_zzbtx_zzb.zzcrh)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtx_zzb.zzcrX == null || com_google_android_gms_internal_zzbtx_zzb.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtx_zzb.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcrh == null ? 0 : this.zzcrh.hashCode()) + (((this.zzcrg == null ? 0 : this.zzcrg.hashCode()) + (((this.zzcrf == null ? 0 : this.zzcrf.hashCode()) + (((this.zzcre == null ? 0 : this.zzcre.hashCode()) + (((this.zzcrd == null ? 0 : this.zzcrd.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzcrc ^ (this.zzcrc >>> 32)))) * 31) + this.zzcqA) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzcrc != 0) {
                com_google_android_gms_internal_zzbum.zzb(1, this.zzcrc);
            }
            if (this.zzcqA != 0) {
                com_google_android_gms_internal_zzbum.zzF(2, this.zzcqA);
            }
            if (this.zzcrd != null) {
                com_google_android_gms_internal_zzbum.zza(3, this.zzcrd);
            }
            if (this.zzcre != null) {
                com_google_android_gms_internal_zzbum.zza(4, this.zzcre);
            }
            if (this.zzcrf != null) {
                com_google_android_gms_internal_zzbum.zza(5, this.zzcrf);
            }
            if (this.zzcrg != null) {
                com_google_android_gms_internal_zzbum.zza(6, this.zzcrg);
            }
            if (this.zzcrh != null) {
                com_google_android_gms_internal_zzbum.zza(7, this.zzcrh);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzb zzau(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.zzcrc = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
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
                    case C0394R.styleable.Toolbar_logoDescription /*26*/:
                        if (this.zzcrd == null) {
                            this.zzcrd = new zzc();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzcrd);
                        continue;
                    case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        if (this.zzcre == null) {
                            this.zzcre = new zzd();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzcre);
                        continue;
                    case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        if (this.zzcrf == null) {
                            this.zzcrf = new zze();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzcrf);
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        if (this.zzcrg == null) {
                            this.zzcrg = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzcrg);
                        continue;
                    case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        if (this.zzcrh == null) {
                            this.zzcrh = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzcrh);
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
            return zzau(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcrc != 0) {
                zzv += zzbum.zzf(1, this.zzcrc);
            }
            if (this.zzcqA != 0) {
                zzv += zzbum.zzH(2, this.zzcqA);
            }
            if (this.zzcrd != null) {
                zzv += zzbum.zzc(3, this.zzcrd);
            }
            if (this.zzcre != null) {
                zzv += zzbum.zzc(4, this.zzcre);
            }
            if (this.zzcrf != null) {
                zzv += zzbum.zzc(5, this.zzcrf);
            }
            if (this.zzcrg != null) {
                zzv += zzbum.zzc(6, this.zzcrg);
            }
            return this.zzcrh != null ? zzv + zzbum.zzc(7, this.zzcrh) : zzv;
        }
    }

    public static final class zzc extends zzbun<zzc> {
        public long durationMillis;
        public int type;

        public zzc() {
            this.type = 0;
            this.durationMillis = 0;
            this.zzcsg = -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzbtx_zzc = (zzc) obj;
            return (this.type == com_google_android_gms_internal_zzbtx_zzc.type && this.durationMillis == com_google_android_gms_internal_zzbtx_zzc.durationMillis) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtx_zzc.zzcrX == null || com_google_android_gms_internal_zzbtx_zzc.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtx_zzc.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + ((int) (this.durationMillis ^ (this.durationMillis >>> 32)))) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.type != 0) {
                com_google_android_gms_internal_zzbum.zzF(1, this.type);
            }
            if (this.durationMillis != 0) {
                com_google_android_gms_internal_zzbum.zzb(2, this.durationMillis);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzc zzaw(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            case Dimension.UNIT_IN /*4*/:
                                this.type = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.durationMillis = com_google_android_gms_internal_zzbul.zzacx();
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
            return zzaw(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.type != 0) {
                zzv += zzbum.zzH(1, this.type);
            }
            return this.durationMillis != 0 ? zzv + zzbum.zzf(2, this.durationMillis) : zzv;
        }
    }

    public static final class zzd extends zzbun<zzd> {
        public int priority;
        public int type;
        public long zzcrj;
        public String zzcrk;
        public String zzcrl;
        public byte[] zzcrm;
        public int[] zzcrn;
        public String[] zzcro;
        public long zzcrp;
        public int zzcrq;
        public String zzcrr;

        public zzd() {
            this.type = 0;
            this.zzcrj = 0;
            this.priority = 0;
            this.zzcrk = BuildConfig.FLAVOR;
            this.zzcrl = BuildConfig.FLAVOR;
            this.zzcrm = zzbuw.zzcsp;
            this.zzcrn = zzbuw.zzcsi;
            this.zzcro = zzbuw.zzcsn;
            this.zzcrp = -1;
            this.zzcrq = 0;
            this.zzcrr = BuildConfig.FLAVOR;
            this.zzcsg = -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzbtx_zzd = (zzd) obj;
            if (this.type != com_google_android_gms_internal_zzbtx_zzd.type || this.zzcrj != com_google_android_gms_internal_zzbtx_zzd.zzcrj || this.priority != com_google_android_gms_internal_zzbtx_zzd.priority) {
                return false;
            }
            if (this.zzcrk == null) {
                if (com_google_android_gms_internal_zzbtx_zzd.zzcrk != null) {
                    return false;
                }
            } else if (!this.zzcrk.equals(com_google_android_gms_internal_zzbtx_zzd.zzcrk)) {
                return false;
            }
            if (this.zzcrl == null) {
                if (com_google_android_gms_internal_zzbtx_zzd.zzcrl != null) {
                    return false;
                }
            } else if (!this.zzcrl.equals(com_google_android_gms_internal_zzbtx_zzd.zzcrl)) {
                return false;
            }
            if (!Arrays.equals(this.zzcrm, com_google_android_gms_internal_zzbtx_zzd.zzcrm) || !zzbur.equals(this.zzcrn, com_google_android_gms_internal_zzbtx_zzd.zzcrn) || !zzbur.equals(this.zzcro, com_google_android_gms_internal_zzbtx_zzd.zzcro) || this.zzcrp != com_google_android_gms_internal_zzbtx_zzd.zzcrp || this.zzcrq != com_google_android_gms_internal_zzbtx_zzd.zzcrq) {
                return false;
            }
            if (this.zzcrr == null) {
                if (com_google_android_gms_internal_zzbtx_zzd.zzcrr != null) {
                    return false;
                }
            } else if (!this.zzcrr.equals(com_google_android_gms_internal_zzbtx_zzd.zzcrr)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtx_zzd.zzcrX == null || com_google_android_gms_internal_zzbtx_zzd.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtx_zzd.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcrr == null ? 0 : this.zzcrr.hashCode()) + (((((((((((((this.zzcrl == null ? 0 : this.zzcrl.hashCode()) + (((this.zzcrk == null ? 0 : this.zzcrk.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + ((int) (this.zzcrj ^ (this.zzcrj >>> 32)))) * 31) + this.priority) * 31)) * 31)) * 31) + Arrays.hashCode(this.zzcrm)) * 31) + zzbur.hashCode(this.zzcrn)) * 31) + zzbur.hashCode(this.zzcro)) * 31) + ((int) (this.zzcrp ^ (this.zzcrp >>> 32)))) * 31) + this.zzcrq) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            int i = 0;
            if (this.type != 0) {
                com_google_android_gms_internal_zzbum.zzF(1, this.type);
            }
            if (this.zzcrj != 0) {
                com_google_android_gms_internal_zzbum.zzb(2, this.zzcrj);
            }
            if (this.priority != 0) {
                com_google_android_gms_internal_zzbum.zzF(3, this.priority);
            }
            if (!(this.zzcrk == null || this.zzcrk.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(4, this.zzcrk);
            }
            if (!(this.zzcrl == null || this.zzcrl.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(5, this.zzcrl);
            }
            if (!Arrays.equals(this.zzcrm, zzbuw.zzcsp)) {
                com_google_android_gms_internal_zzbum.zzb(6, this.zzcrm);
            }
            if (this.zzcrn != null && this.zzcrn.length > 0) {
                for (int zzF : this.zzcrn) {
                    com_google_android_gms_internal_zzbum.zzF(7, zzF);
                }
            }
            if (this.zzcro != null && this.zzcro.length > 0) {
                while (i < this.zzcro.length) {
                    String str = this.zzcro[i];
                    if (str != null) {
                        com_google_android_gms_internal_zzbum.zzq(8, str);
                    }
                    i++;
                }
            }
            if (this.zzcrp != -1) {
                com_google_android_gms_internal_zzbum.zzb(9, this.zzcrp);
            }
            if (this.zzcrq != 0) {
                com_google_android_gms_internal_zzbum.zzF(10, this.zzcrq);
            }
            if (!(this.zzcrr == null || this.zzcrr.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(11, this.zzcrr);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zzd zzax(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                int zzc;
                Object obj;
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
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
                                this.type = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.zzcrj = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MetadataChangeSet.MAX_TOTAL_PROPERTIES_PER_RESOURCE /*100*/:
                            case Quests.SELECT_ENDING_SOON /*102*/:
                            case C0394R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                            case C0394R.styleable.AppCompatTheme_checkedTextViewStyle /*105*/:
                                this.priority = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzcrk = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.zzcrl = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.zzcrm = com_google_android_gms_internal_zzbul.readBytes();
                        continue;
                    case C0394R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 56);
                        zzacu = this.zzcrn == null ? 0 : this.zzcrn.length;
                        obj = new int[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzcrn, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.zzacy();
                        this.zzcrn = obj;
                        continue;
                    case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        int zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                        zzc = com_google_android_gms_internal_zzbul.getPosition();
                        zzacu = 0;
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            com_google_android_gms_internal_zzbul.zzacy();
                            zzacu++;
                        }
                        com_google_android_gms_internal_zzbul.zzql(zzc);
                        zzc = this.zzcrn == null ? 0 : this.zzcrn.length;
                        Object obj2 = new int[(zzacu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzcrn, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzbul.zzacy();
                            zzc++;
                        }
                        this.zzcrn = obj2;
                        com_google_android_gms_internal_zzbul.zzqk(zzqj);
                        continue;
                    case C0394R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 66);
                        zzacu = this.zzcro == null ? 0 : this.zzcro.length;
                        obj = new String[(zzc + zzacu)];
                        if (zzacu != 0) {
                            System.arraycopy(this.zzcro, 0, obj, 0, zzacu);
                        }
                        while (zzacu < obj.length - 1) {
                            obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                            com_google_android_gms_internal_zzbul.zzacu();
                            zzacu++;
                        }
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        this.zzcro = obj;
                        continue;
                    case C0394R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.zzcrp = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case C0394R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        this.zzcrq = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        this.zzcrr = com_google_android_gms_internal_zzbul.readString();
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
            return zzax(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int i;
            int i2;
            int i3 = 0;
            int zzv = super.zzv();
            if (this.type != 0) {
                zzv += zzbum.zzH(1, this.type);
            }
            if (this.zzcrj != 0) {
                zzv += zzbum.zzf(2, this.zzcrj);
            }
            if (this.priority != 0) {
                zzv += zzbum.zzH(3, this.priority);
            }
            if (!(this.zzcrk == null || this.zzcrk.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(4, this.zzcrk);
            }
            if (!(this.zzcrl == null || this.zzcrl.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(5, this.zzcrl);
            }
            if (!Arrays.equals(this.zzcrm, zzbuw.zzcsp)) {
                zzv += zzbum.zzc(6, this.zzcrm);
            }
            if (this.zzcrn != null && this.zzcrn.length > 0) {
                i = 0;
                for (int zzqp : this.zzcrn) {
                    i += zzbum.zzqp(zzqp);
                }
                zzv = (zzv + i) + (this.zzcrn.length * 1);
            }
            if (this.zzcro != null && this.zzcro.length > 0) {
                i2 = 0;
                i = 0;
                while (i3 < this.zzcro.length) {
                    String str = this.zzcro[i3];
                    if (str != null) {
                        i++;
                        i2 += zzbum.zzkc(str);
                    }
                    i3++;
                }
                zzv = (zzv + i2) + (i * 1);
            }
            if (this.zzcrp != -1) {
                zzv += zzbum.zzf(9, this.zzcrp);
            }
            if (this.zzcrq != 0) {
                zzv += zzbum.zzH(10, this.zzcrq);
            }
            return (this.zzcrr == null || this.zzcrr.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(11, this.zzcrr);
        }
    }

    public static final class zze extends zzbun<zze> {
        public int count;
        public long durationMillis;
        public int type;

        public zze() {
            this.type = 0;
            this.durationMillis = 0;
            this.count = 0;
            this.zzcsg = -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzbtx_zze = (zze) obj;
            return (this.type == com_google_android_gms_internal_zzbtx_zze.type && this.durationMillis == com_google_android_gms_internal_zzbtx_zze.durationMillis && this.count == com_google_android_gms_internal_zzbtx_zze.count) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtx_zze.zzcrX == null || com_google_android_gms_internal_zzbtx_zze.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtx_zze.zzcrX) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + ((int) (this.durationMillis ^ (this.durationMillis >>> 32)))) * 31) + this.count) * 31;
            int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.type != 0) {
                com_google_android_gms_internal_zzbum.zzF(1, this.type);
            }
            if (this.durationMillis != 0) {
                com_google_android_gms_internal_zzbum.zzb(2, this.durationMillis);
            }
            if (this.count != 0) {
                com_google_android_gms_internal_zzbum.zzF(3, this.count);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zze zzay(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        zzacu = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacu) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                this.type = zzacu;
                                break;
                            default:
                                continue;
                        }
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.durationMillis = com_google_android_gms_internal_zzbul.zzacx();
                        continue;
                    case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                        this.count = com_google_android_gms_internal_zzbul.zzacy();
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
            return zzay(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.type != 0) {
                zzv += zzbum.zzH(1, this.type);
            }
            if (this.durationMillis != 0) {
                zzv += zzbum.zzf(2, this.durationMillis);
            }
            return this.count != 0 ? zzv + zzbum.zzH(3, this.count) : zzv;
        }
    }
}
