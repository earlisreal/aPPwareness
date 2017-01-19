package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtz extends zzbun<zzbtz> {
    public int zzcqk;
    public long zzcql;
    public long zzcrA;
    public int zzcrv;
    public int zzcrw;
    public int zzcrx;
    public double zzcry;
    public double zzcrz;

    public zzbtz() {
        this.zzcqk = 0;
        this.zzcrv = 0;
        this.zzcql = 0;
        this.zzcrw = 0;
        this.zzcrx = 0;
        this.zzcry = 0.0d;
        this.zzcrz = 0.0d;
        this.zzcrA = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbtz)) {
            return false;
        }
        zzbtz com_google_android_gms_internal_zzbtz = (zzbtz) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbtz.zzcqk && this.zzcrv == com_google_android_gms_internal_zzbtz.zzcrv && this.zzcql == com_google_android_gms_internal_zzbtz.zzcql && this.zzcrw == com_google_android_gms_internal_zzbtz.zzcrw && this.zzcrx == com_google_android_gms_internal_zzbtz.zzcrx && Double.doubleToLongBits(this.zzcry) == Double.doubleToLongBits(com_google_android_gms_internal_zzbtz.zzcry) && Double.doubleToLongBits(this.zzcrz) == Double.doubleToLongBits(com_google_android_gms_internal_zzbtz.zzcrz) && this.zzcrA == com_google_android_gms_internal_zzbtz.zzcrA) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtz.zzcrX == null || com_google_android_gms_internal_zzbtz.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtz.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = ((((((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + this.zzcrv) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + this.zzcrw) * 31) + this.zzcrx;
        long doubleToLongBits = Double.doubleToLongBits(this.zzcry);
        hashCode = (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.zzcrz);
        int i = ((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (this.zzcrA ^ (this.zzcrA >>> 32)))) * 31;
        hashCode = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode + i;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (this.zzcrv != 0) {
            com_google_android_gms_internal_zzbum.zzF(2, this.zzcrv);
        }
        if (this.zzcql != 0) {
            com_google_android_gms_internal_zzbum.zzb(3, this.zzcql);
        }
        if (this.zzcrw != 0) {
            com_google_android_gms_internal_zzbum.zzF(4, this.zzcrw);
        }
        if (this.zzcrx != 0) {
            com_google_android_gms_internal_zzbum.zzF(5, this.zzcrx);
        }
        if (Double.doubleToLongBits(this.zzcry) != Double.doubleToLongBits(0.0d)) {
            com_google_android_gms_internal_zzbum.zza(6, this.zzcry);
        }
        if (Double.doubleToLongBits(this.zzcrz) != Double.doubleToLongBits(0.0d)) {
            com_google_android_gms_internal_zzbum.zza(7, this.zzcrz);
        }
        if (this.zzcrA != 0) {
            com_google_android_gms_internal_zzbum.zzb(8, this.zzcrA);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtz zzaA(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                            this.zzcqk = zzacu;
                            break;
                        default:
                            continue;
                    }
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                            this.zzcrv = zzacu;
                            break;
                        default:
                            continue;
                    }
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    this.zzcrw = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.zzcrx = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case C0394R.styleable.AppCompatTheme_homeAsUpIndicator /*49*/:
                    this.zzcry = com_google_android_gms_internal_zzbul.readDouble();
                    continue;
                case C0394R.styleable.AppCompatTheme_dividerHorizontal /*57*/:
                    this.zzcrz = com_google_android_gms_internal_zzbul.readDouble();
                    continue;
                case C0394R.styleable.AppCompatTheme_editTextBackground /*64*/:
                    this.zzcrA = com_google_android_gms_internal_zzbul.zzacx();
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
        return zzaA(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcrv != 0) {
            zzv += zzbum.zzH(2, this.zzcrv);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(3, this.zzcql);
        }
        if (this.zzcrw != 0) {
            zzv += zzbum.zzH(4, this.zzcrw);
        }
        if (this.zzcrx != 0) {
            zzv += zzbum.zzH(5, this.zzcrx);
        }
        if (Double.doubleToLongBits(this.zzcry) != Double.doubleToLongBits(0.0d)) {
            zzv += zzbum.zzb(6, this.zzcry);
        }
        if (Double.doubleToLongBits(this.zzcrz) != Double.doubleToLongBits(0.0d)) {
            zzv += zzbum.zzb(7, this.zzcrz);
        }
        return this.zzcrA != 0 ? zzv + zzbum.zzf(8, this.zzcrA) : zzv;
    }
}
