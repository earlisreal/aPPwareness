package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbto extends zzbun<zzbto> {
    public int zzcqk;
    public long zzcql;
    public int zzcqn;
    public int zzcqo;
    public int zzcqp;
    public int zzcqq;
    public int zzcqr;
    public int zzcqs;

    public zzbto() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcqn = 0;
        this.zzcqo = 0;
        this.zzcqp = 0;
        this.zzcqq = 0;
        this.zzcqr = 0;
        this.zzcqs = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbto)) {
            return false;
        }
        zzbto com_google_android_gms_internal_zzbto = (zzbto) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbto.zzcqk && this.zzcql == com_google_android_gms_internal_zzbto.zzcql && this.zzcqn == com_google_android_gms_internal_zzbto.zzcqn && this.zzcqo == com_google_android_gms_internal_zzbto.zzcqo && this.zzcqp == com_google_android_gms_internal_zzbto.zzcqp && this.zzcqq == com_google_android_gms_internal_zzbto.zzcqq && this.zzcqr == com_google_android_gms_internal_zzbto.zzcqr && this.zzcqs == com_google_android_gms_internal_zzbto.zzcqs) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbto.zzcrX == null || com_google_android_gms_internal_zzbto.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbto.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((((((((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + this.zzcqn) * 31) + this.zzcqo) * 31) + this.zzcqp) * 31) + this.zzcqq) * 31) + this.zzcqr) * 31) + this.zzcqs) * 31;
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
        if (this.zzcqn != 0) {
            com_google_android_gms_internal_zzbum.zzF(3, this.zzcqn);
        }
        if (this.zzcqo != 0) {
            com_google_android_gms_internal_zzbum.zzF(4, this.zzcqo);
        }
        if (this.zzcqp != 0) {
            com_google_android_gms_internal_zzbum.zzF(5, this.zzcqp);
        }
        if (this.zzcqq != 0) {
            com_google_android_gms_internal_zzbum.zzF(6, this.zzcqq);
        }
        if (this.zzcqr != 0) {
            com_google_android_gms_internal_zzbum.zzF(7, this.zzcqr);
        }
        if (this.zzcqs != 0) {
            com_google_android_gms_internal_zzbum.zzF(8, this.zzcqs);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbto zzaj(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                            this.zzcqk = zzacu;
                            break;
                        default:
                            continue;
                    }
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            this.zzcqn = zzacu;
                            break;
                        default:
                            continue;
                    }
                case Message.MAX_TYPE_LENGTH /*32*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            this.zzcqo = zzacu;
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
                            this.zzcqp = zzacu;
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
                            this.zzcqq = zzacu;
                            break;
                        default:
                            continue;
                    }
                case C0394R.styleable.AppCompatTheme_dividerVertical /*56*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            this.zzcqr = zzacu;
                            break;
                        default:
                            continue;
                    }
                case C0394R.styleable.AppCompatTheme_editTextBackground /*64*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            this.zzcqs = zzacu;
                            break;
                        default:
                            continue;
                    }
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
        return zzaj(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(2, this.zzcql);
        }
        if (this.zzcqn != 0) {
            zzv += zzbum.zzH(3, this.zzcqn);
        }
        if (this.zzcqo != 0) {
            zzv += zzbum.zzH(4, this.zzcqo);
        }
        if (this.zzcqp != 0) {
            zzv += zzbum.zzH(5, this.zzcqp);
        }
        if (this.zzcqq != 0) {
            zzv += zzbum.zzH(6, this.zzcqq);
        }
        if (this.zzcqr != 0) {
            zzv += zzbum.zzH(7, this.zzcqr);
        }
        return this.zzcqs != 0 ? zzv + zzbum.zzH(8, this.zzcqs) : zzv;
    }
}
