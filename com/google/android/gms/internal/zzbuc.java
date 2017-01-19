package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbuc extends zzbun<zzbuc> {
    public int zzcqk;
    public long zzcql;
    public int zzcrD;

    public zzbuc() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcrD = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbuc)) {
            return false;
        }
        zzbuc com_google_android_gms_internal_zzbuc = (zzbuc) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbuc.zzcqk && this.zzcql == com_google_android_gms_internal_zzbuc.zzcql && this.zzcrD == com_google_android_gms_internal_zzbuc.zzcrD) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbuc.zzcrX == null || com_google_android_gms_internal_zzbuc.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbuc.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + this.zzcrD) * 31;
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
        if (this.zzcrD != 0) {
            com_google_android_gms_internal_zzbum.zzF(3, this.zzcrD);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbuc zzaD(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                            this.zzcrD = zzacu;
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
        return zzaD(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(2, this.zzcql);
        }
        return this.zzcrD != 0 ? zzv + zzbum.zzH(3, this.zzcrD) : zzv;
    }
}
