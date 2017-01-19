package com.google.android.gms.internal;

import android.support.v4.app.NotificationManagerCompat;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtn extends zzbun<zzbtn> {
    public int zzcqk;
    public long zzcql;
    public int[] zzcqm;

    public zzbtn() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcqm = zzbuw.zzcsi;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbtn)) {
            return false;
        }
        zzbtn com_google_android_gms_internal_zzbtn = (zzbtn) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbtn.zzcqk && this.zzcql == com_google_android_gms_internal_zzbtn.zzcql && zzbur.equals(this.zzcqm, com_google_android_gms_internal_zzbtn.zzcqm)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtn.zzcrX == null || com_google_android_gms_internal_zzbtn.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtn.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + zzbur.hashCode(this.zzcqm)) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            com_google_android_gms_internal_zzbum.zzb(2, this.zzcql);
        }
        if (this.zzcqm != null && this.zzcqm.length > 0) {
            for (int zzF : this.zzcqm) {
                com_google_android_gms_internal_zzbum.zzF(3, zzF);
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtn zzai(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            int i;
            int i2;
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
                            this.zzcqk = zzacu;
                            break;
                        default:
                            continue;
                    }
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 24);
                    Object obj = new int[zzc];
                    i = 0;
                    i2 = 0;
                    while (i < zzc) {
                        if (i != 0) {
                            com_google_android_gms_internal_zzbul.zzacu();
                        }
                        int zzacy = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacy) {
                            case NotificationManagerCompat.IMPORTANCE_UNSPECIFIED /*-1000*/:
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
                                zzacu = i2 + 1;
                                obj[i2] = zzacy;
                                break;
                            default:
                                zzacu = i2;
                                break;
                        }
                        i++;
                        i2 = zzacu;
                    }
                    if (i2 != 0) {
                        zzacu = this.zzcqm == null ? 0 : this.zzcqm.length;
                        if (zzacu != 0 || i2 != obj.length) {
                            Object obj2 = new int[(zzacu + i2)];
                            if (zzacu != 0) {
                                System.arraycopy(this.zzcqm, 0, obj2, 0, zzacu);
                            }
                            System.arraycopy(obj, 0, obj2, zzacu, i2);
                            this.zzcqm = obj2;
                            break;
                        }
                        this.zzcqm = obj;
                        break;
                    }
                    continue;
                case C0394R.styleable.Toolbar_logoDescription /*26*/:
                    i = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                    i2 = com_google_android_gms_internal_zzbul.getPosition();
                    zzacu = 0;
                    while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                        switch (com_google_android_gms_internal_zzbul.zzacy()) {
                            case NotificationManagerCompat.IMPORTANCE_UNSPECIFIED /*-1000*/:
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
                                zzacu++;
                                break;
                            default:
                                break;
                        }
                    }
                    if (zzacu != 0) {
                        com_google_android_gms_internal_zzbul.zzql(i2);
                        i2 = this.zzcqm == null ? 0 : this.zzcqm.length;
                        Object obj3 = new int[(zzacu + i2)];
                        if (i2 != 0) {
                            System.arraycopy(this.zzcqm, 0, obj3, 0, i2);
                        }
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            int zzacy2 = com_google_android_gms_internal_zzbul.zzacy();
                            switch (zzacy2) {
                                case NotificationManagerCompat.IMPORTANCE_UNSPECIFIED /*-1000*/:
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
                                    zzacu = i2 + 1;
                                    obj3[i2] = zzacy2;
                                    i2 = zzacu;
                                    break;
                                default:
                                    break;
                            }
                        }
                        this.zzcqm = obj3;
                    }
                    com_google_android_gms_internal_zzbul.zzqk(i);
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
        return zzai(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int i = 0;
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(2, this.zzcql);
        }
        if (this.zzcqm == null || this.zzcqm.length <= 0) {
            return zzv;
        }
        int i2 = 0;
        while (i < this.zzcqm.length) {
            i2 += zzbum.zzqp(this.zzcqm[i]);
            i++;
        }
        return (zzv + i2) + (this.zzcqm.length * 1);
    }
}
