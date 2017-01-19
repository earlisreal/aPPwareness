package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbuj extends zzbun<zzbuj> {
    public long zzaIZ;
    public int zzcqk;
    public String zzcrJ;
    public long zzcrK;
    public zzbtu zzcrL;

    public zzbuj() {
        this.zzcqk = 0;
        this.zzcrJ = BuildConfig.FLAVOR;
        this.zzaIZ = 0;
        this.zzcrK = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbuj)) {
            return false;
        }
        zzbuj com_google_android_gms_internal_zzbuj = (zzbuj) obj;
        if (this.zzcqk != com_google_android_gms_internal_zzbuj.zzcqk) {
            return false;
        }
        if (this.zzcrJ == null) {
            if (com_google_android_gms_internal_zzbuj.zzcrJ != null) {
                return false;
            }
        } else if (!this.zzcrJ.equals(com_google_android_gms_internal_zzbuj.zzcrJ)) {
            return false;
        }
        if (this.zzaIZ != com_google_android_gms_internal_zzbuj.zzaIZ || this.zzcrK != com_google_android_gms_internal_zzbuj.zzcrK) {
            return false;
        }
        if (this.zzcrL == null) {
            if (com_google_android_gms_internal_zzbuj.zzcrL != null) {
                return false;
            }
        } else if (!this.zzcrL.equals(com_google_android_gms_internal_zzbuj.zzcrL)) {
            return false;
        }
        return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbuj.zzcrX == null || com_google_android_gms_internal_zzbuj.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbuj.zzcrX);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcrL == null ? 0 : this.zzcrL.hashCode()) + (((((((this.zzcrJ == null ? 0 : this.zzcrJ.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31)) * 31) + ((int) (this.zzaIZ ^ (this.zzaIZ >>> 32)))) * 31) + ((int) (this.zzcrK ^ (this.zzcrK >>> 32)))) * 31)) * 31;
        if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
            i = this.zzcrX.hashCode();
        }
        return hashCode + i;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (!(this.zzcrJ == null || this.zzcrJ.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(2, this.zzcrJ);
        }
        if (this.zzaIZ != 0) {
            com_google_android_gms_internal_zzbum.zzb(3, this.zzaIZ);
        }
        if (this.zzcrK != 0) {
            com_google_android_gms_internal_zzbum.zzb(4, this.zzcrK);
        }
        if (this.zzcrL != null) {
            com_google_android_gms_internal_zzbum.zza(5, this.zzcrL);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbuj zzaK(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                            this.zzcqk = zzacu;
                            break;
                        default:
                            continue;
                    }
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    this.zzcrJ = com_google_android_gms_internal_zzbul.readString();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    this.zzaIZ = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    this.zzcrK = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    if (this.zzcrL == null) {
                        this.zzcrL = new zzbtu();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcrL);
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
        return zzaK(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (!(this.zzcrJ == null || this.zzcrJ.equals(BuildConfig.FLAVOR))) {
            zzv += zzbum.zzr(2, this.zzcrJ);
        }
        if (this.zzaIZ != 0) {
            zzv += zzbum.zzf(3, this.zzaIZ);
        }
        if (this.zzcrK != 0) {
            zzv += zzbum.zzf(4, this.zzcrK);
        }
        return this.zzcrL != null ? zzv + zzbum.zzc(5, this.zzcrL) : zzv;
    }
}
