package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbue extends zzbun<zzbue> {
    public int zzcqk;
    public long zzcql;
    public double zzcrF;
    public double zzcrG;
    public int[] zzcrH;

    public zzbue() {
        this.zzcqk = 0;
        this.zzcrF = 0.0d;
        this.zzcrG = 0.0d;
        this.zzcql = 0;
        this.zzcrH = zzbuw.zzcsi;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbue)) {
            return false;
        }
        zzbue com_google_android_gms_internal_zzbue = (zzbue) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbue.zzcqk && Double.doubleToLongBits(this.zzcrF) == Double.doubleToLongBits(com_google_android_gms_internal_zzbue.zzcrF) && Double.doubleToLongBits(this.zzcrG) == Double.doubleToLongBits(com_google_android_gms_internal_zzbue.zzcrG) && this.zzcql == com_google_android_gms_internal_zzbue.zzcql && zzbur.equals(this.zzcrH, com_google_android_gms_internal_zzbue.zzcrH)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbue.zzcrX == null || com_google_android_gms_internal_zzbue.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbue.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + this.zzcqk;
        long doubleToLongBits = Double.doubleToLongBits(this.zzcrF);
        hashCode = (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.zzcrG);
        int hashCode2 = ((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + zzbur.hashCode(this.zzcrH)) * 31;
        hashCode = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode + hashCode2;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (Double.doubleToLongBits(this.zzcrF) != Double.doubleToLongBits(0.0d)) {
            com_google_android_gms_internal_zzbum.zza(2, this.zzcrF);
        }
        if (Double.doubleToLongBits(this.zzcrG) != Double.doubleToLongBits(0.0d)) {
            com_google_android_gms_internal_zzbum.zza(3, this.zzcrG);
        }
        if (this.zzcql != 0) {
            com_google_android_gms_internal_zzbum.zzb(4, this.zzcql);
        }
        if (this.zzcrH != null && this.zzcrH.length > 0) {
            for (int zzF : this.zzcrH) {
                com_google_android_gms_internal_zzbum.zzF(5, zzF);
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbue zzaF(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                        case Dimension.UNIT_IN /*4*/:
                        case Dimension.UNIT_MM /*5*/:
                        case BuyButtonText.LOGO_ONLY /*6*/:
                            this.zzcqk = zzacu;
                            break;
                        default:
                            continue;
                    }
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    this.zzcrF = com_google_android_gms_internal_zzbul.readDouble();
                    continue;
                case C0394R.styleable.Toolbar_navigationContentDescription /*25*/:
                    this.zzcrG = com_google_android_gms_internal_zzbul.readDouble();
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 40);
                    Object obj = new int[zzc];
                    i = 0;
                    i2 = 0;
                    while (i < zzc) {
                        if (i != 0) {
                            com_google_android_gms_internal_zzbul.zzacu();
                        }
                        int zzacy = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacy) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            case Dimension.UNIT_IN /*4*/:
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
                        zzacu = this.zzcrH == null ? 0 : this.zzcrH.length;
                        if (zzacu != 0 || i2 != obj.length) {
                            Object obj2 = new int[(zzacu + i2)];
                            if (zzacu != 0) {
                                System.arraycopy(this.zzcrH, 0, obj2, 0, zzacu);
                            }
                            System.arraycopy(obj, 0, obj2, zzacu, i2);
                            this.zzcrH = obj2;
                            break;
                        }
                        this.zzcrH = obj;
                        break;
                    }
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    i = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                    i2 = com_google_android_gms_internal_zzbul.getPosition();
                    zzacu = 0;
                    while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                        switch (com_google_android_gms_internal_zzbul.zzacy()) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            case Dimension.UNIT_IN /*4*/:
                                zzacu++;
                                break;
                            default:
                                break;
                        }
                    }
                    if (zzacu != 0) {
                        com_google_android_gms_internal_zzbul.zzql(i2);
                        i2 = this.zzcrH == null ? 0 : this.zzcrH.length;
                        Object obj3 = new int[(zzacu + i2)];
                        if (i2 != 0) {
                            System.arraycopy(this.zzcrH, 0, obj3, 0, i2);
                        }
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            int zzacy2 = com_google_android_gms_internal_zzbul.zzacy();
                            switch (zzacy2) {
                                case MessageApi.FILTER_LITERAL /*0*/:
                                case MessageApi.FILTER_PREFIX /*1*/:
                                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                case Dimension.UNIT_IN /*4*/:
                                    zzacu = i2 + 1;
                                    obj3[i2] = zzacy2;
                                    i2 = zzacu;
                                    break;
                                default:
                                    break;
                            }
                        }
                        this.zzcrH = obj3;
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
        return zzaF(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int i = 0;
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (Double.doubleToLongBits(this.zzcrF) != Double.doubleToLongBits(0.0d)) {
            zzv += zzbum.zzb(2, this.zzcrF);
        }
        if (Double.doubleToLongBits(this.zzcrG) != Double.doubleToLongBits(0.0d)) {
            zzv += zzbum.zzb(3, this.zzcrG);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(4, this.zzcql);
        }
        if (this.zzcrH == null || this.zzcrH.length <= 0) {
            return zzv;
        }
        int i2 = 0;
        while (i < this.zzcrH.length) {
            i2 += zzbum.zzqp(this.zzcrH[i]);
            i++;
        }
        return (zzv + i2) + (this.zzcrH.length * 1);
    }
}
