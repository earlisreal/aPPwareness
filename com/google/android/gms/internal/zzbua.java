package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbua extends zzbun<zzbua> {
    public int zzcqk;
    public long zzcql;
    public int[] zzcrB;
    public int[] zzcrC;

    public zzbua() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcrB = zzbuw.zzcsi;
        this.zzcrC = zzbuw.zzcsi;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbua)) {
            return false;
        }
        zzbua com_google_android_gms_internal_zzbua = (zzbua) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbua.zzcqk && this.zzcql == com_google_android_gms_internal_zzbua.zzcql && zzbur.equals(this.zzcrB, com_google_android_gms_internal_zzbua.zzcrB) && zzbur.equals(this.zzcrC, com_google_android_gms_internal_zzbua.zzcrC)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbua.zzcrX == null || com_google_android_gms_internal_zzbua.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbua.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + zzbur.hashCode(this.zzcrB)) * 31) + zzbur.hashCode(this.zzcrC)) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        int i = 0;
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            com_google_android_gms_internal_zzbum.zzb(2, this.zzcql);
        }
        if (this.zzcrB != null && this.zzcrB.length > 0) {
            for (int zzF : this.zzcrB) {
                com_google_android_gms_internal_zzbum.zzF(3, zzF);
            }
        }
        if (this.zzcrC != null && this.zzcrC.length > 0) {
            while (i < this.zzcrC.length) {
                com_google_android_gms_internal_zzbum.zzF(4, this.zzcrC[i]);
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbua zzaB(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            int zzc;
            Object obj;
            int i;
            int i2;
            int zzacy;
            Object obj2;
            Object obj3;
            int zzacy2;
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
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 24);
                    obj = new int[zzc];
                    i = 0;
                    i2 = 0;
                    while (i < zzc) {
                        if (i != 0) {
                            com_google_android_gms_internal_zzbul.zzacu();
                        }
                        zzacy = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacy) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
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
                        zzacu = this.zzcrB == null ? 0 : this.zzcrB.length;
                        if (zzacu != 0 || i2 != obj.length) {
                            obj2 = new int[(zzacu + i2)];
                            if (zzacu != 0) {
                                System.arraycopy(this.zzcrB, 0, obj2, 0, zzacu);
                            }
                            System.arraycopy(obj, 0, obj2, zzacu, i2);
                            this.zzcrB = obj2;
                            break;
                        }
                        this.zzcrB = obj;
                        break;
                    }
                    continue;
                case C0394R.styleable.Toolbar_logoDescription /*26*/:
                    i = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                    i2 = com_google_android_gms_internal_zzbul.getPosition();
                    zzacu = 0;
                    while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                        switch (com_google_android_gms_internal_zzbul.zzacy()) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                zzacu++;
                                break;
                            default:
                                break;
                        }
                    }
                    if (zzacu != 0) {
                        com_google_android_gms_internal_zzbul.zzql(i2);
                        i2 = this.zzcrB == null ? 0 : this.zzcrB.length;
                        obj3 = new int[(zzacu + i2)];
                        if (i2 != 0) {
                            System.arraycopy(this.zzcrB, 0, obj3, 0, i2);
                        }
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            zzacy2 = com_google_android_gms_internal_zzbul.zzacy();
                            switch (zzacy2) {
                                case MessageApi.FILTER_LITERAL /*0*/:
                                case MessageApi.FILTER_PREFIX /*1*/:
                                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                                    zzacu = i2 + 1;
                                    obj3[i2] = zzacy2;
                                    i2 = zzacu;
                                    break;
                                default:
                                    break;
                            }
                        }
                        this.zzcrB = obj3;
                    }
                    com_google_android_gms_internal_zzbul.zzqk(i);
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 32);
                    obj = new int[zzc];
                    i = 0;
                    i2 = 0;
                    while (i < zzc) {
                        if (i != 0) {
                            com_google_android_gms_internal_zzbul.zzacu();
                        }
                        zzacy = com_google_android_gms_internal_zzbul.zzacy();
                        switch (zzacy) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
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
                        zzacu = this.zzcrC == null ? 0 : this.zzcrC.length;
                        if (zzacu != 0 || i2 != obj.length) {
                            obj2 = new int[(zzacu + i2)];
                            if (zzacu != 0) {
                                System.arraycopy(this.zzcrC, 0, obj2, 0, zzacu);
                            }
                            System.arraycopy(obj, 0, obj2, zzacu, i2);
                            this.zzcrC = obj2;
                            break;
                        }
                        this.zzcrC = obj;
                        break;
                    }
                    continue;
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    i = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                    i2 = com_google_android_gms_internal_zzbul.getPosition();
                    zzacu = 0;
                    while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                        switch (com_google_android_gms_internal_zzbul.zzacy()) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                            case MessageApi.FILTER_PREFIX /*1*/:
                            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                zzacu++;
                                break;
                            default:
                                break;
                        }
                    }
                    if (zzacu != 0) {
                        com_google_android_gms_internal_zzbul.zzql(i2);
                        i2 = this.zzcrC == null ? 0 : this.zzcrC.length;
                        obj3 = new int[(zzacu + i2)];
                        if (i2 != 0) {
                            System.arraycopy(this.zzcrC, 0, obj3, 0, i2);
                        }
                        while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                            zzacy2 = com_google_android_gms_internal_zzbul.zzacy();
                            switch (zzacy2) {
                                case MessageApi.FILTER_LITERAL /*0*/:
                                case MessageApi.FILTER_PREFIX /*1*/:
                                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                                    zzacu = i2 + 1;
                                    obj3[i2] = zzacy2;
                                    i2 = zzacu;
                                    break;
                                default:
                                    break;
                            }
                        }
                        this.zzcrC = obj3;
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
        return zzaB(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int i;
        int i2 = 0;
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(2, this.zzcql);
        }
        if (this.zzcrB != null && this.zzcrB.length > 0) {
            int i3 = 0;
            for (int zzqp : this.zzcrB) {
                i3 += zzbum.zzqp(zzqp);
            }
            zzv = (zzv + i3) + (this.zzcrB.length * 1);
        }
        if (this.zzcrC == null || this.zzcrC.length <= 0) {
            return zzv;
        }
        i = 0;
        while (i2 < this.zzcrC.length) {
            i += zzbum.zzqp(this.zzcrC[i2]);
            i2++;
        }
        return (zzv + i) + (this.zzcrC.length * 1);
    }
}
