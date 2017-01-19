package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.ads.AdSize;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbud extends zzbun<zzbud> {
    public int zzcqk;
    public long zzcql;
    public long zzcrA;
    public String[] zzcrE;
    public int[] zzcrn;
    public String[] zzcro;
    public String zzcrr;

    public zzbud() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcrn = zzbuw.zzcsi;
        this.zzcro = zzbuw.zzcsn;
        this.zzcrA = 0;
        this.zzcrE = zzbuw.zzcsn;
        this.zzcrr = BuildConfig.FLAVOR;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbud)) {
            return false;
        }
        zzbud com_google_android_gms_internal_zzbud = (zzbud) obj;
        if (this.zzcqk != com_google_android_gms_internal_zzbud.zzcqk || this.zzcql != com_google_android_gms_internal_zzbud.zzcql || !zzbur.equals(this.zzcrn, com_google_android_gms_internal_zzbud.zzcrn) || !zzbur.equals(this.zzcro, com_google_android_gms_internal_zzbud.zzcro) || this.zzcrA != com_google_android_gms_internal_zzbud.zzcrA || !zzbur.equals(this.zzcrE, com_google_android_gms_internal_zzbud.zzcrE)) {
            return false;
        }
        if (this.zzcrr == null) {
            if (com_google_android_gms_internal_zzbud.zzcrr != null) {
                return false;
            }
        } else if (!this.zzcrr.equals(com_google_android_gms_internal_zzbud.zzcrr)) {
            return false;
        }
        return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbud.zzcrX == null || com_google_android_gms_internal_zzbud.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbud.zzcrX);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcrr == null ? 0 : this.zzcrr.hashCode()) + ((((((((((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + zzbur.hashCode(this.zzcrn)) * 31) + zzbur.hashCode(this.zzcro)) * 31) + ((int) (this.zzcrA ^ (this.zzcrA >>> 32)))) * 31) + zzbur.hashCode(this.zzcrE)) * 31)) * 31;
        if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
            i = this.zzcrX.hashCode();
        }
        return hashCode + i;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        int i = 0;
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            com_google_android_gms_internal_zzbum.zzb(2, this.zzcql);
        }
        if (this.zzcrn != null && this.zzcrn.length > 0) {
            for (int zzF : this.zzcrn) {
                com_google_android_gms_internal_zzbum.zzF(3, zzF);
            }
        }
        if (this.zzcro != null && this.zzcro.length > 0) {
            for (String str : this.zzcro) {
                if (str != null) {
                    com_google_android_gms_internal_zzbum.zzq(4, str);
                }
            }
        }
        if (this.zzcrA != 0) {
            com_google_android_gms_internal_zzbum.zzb(5, this.zzcrA);
        }
        if (this.zzcrE != null && this.zzcrE.length > 0) {
            while (i < this.zzcrE.length) {
                String str2 = this.zzcrE[i];
                if (str2 != null) {
                    com_google_android_gms_internal_zzbum.zzq(6, str2);
                }
                i++;
            }
        }
        if (!(this.zzcrr == null || this.zzcrr.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(7, this.zzcrr);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbud zzaE(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                case C0394R.styleable.Toolbar_logoDescription /*26*/:
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
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 34);
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
                case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.zzcrA = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 50);
                    zzacu = this.zzcrE == null ? 0 : this.zzcrE.length;
                    obj = new String[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzcrE, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                    this.zzcrE = obj;
                    continue;
                case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
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
        return zzaE(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int i;
        int i2;
        int i3 = 0;
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(2, this.zzcql);
        }
        if (this.zzcrn != null && this.zzcrn.length > 0) {
            i = 0;
            for (int zzqp : this.zzcrn) {
                int zzqp2;
                i += zzbum.zzqp(zzqp2);
            }
            zzv = (zzv + i) + (this.zzcrn.length * 1);
        }
        if (this.zzcro != null && this.zzcro.length > 0) {
            i = 0;
            zzqp2 = 0;
            for (String str : this.zzcro) {
                if (str != null) {
                    zzqp2++;
                    i += zzbum.zzkc(str);
                }
            }
            zzv = (zzv + i) + (zzqp2 * 1);
        }
        if (this.zzcrA != 0) {
            zzv += zzbum.zzf(5, this.zzcrA);
        }
        if (this.zzcrE != null && this.zzcrE.length > 0) {
            i2 = 0;
            i = 0;
            while (i3 < this.zzcrE.length) {
                String str2 = this.zzcrE[i3];
                if (str2 != null) {
                    i++;
                    i2 += zzbum.zzkc(str2);
                }
                i3++;
            }
            zzv = (zzv + i2) + (i * 1);
        }
        return (this.zzcrr == null || this.zzcrr.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(7, this.zzcrr);
    }
}
