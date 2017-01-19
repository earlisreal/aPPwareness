package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbui extends zzbun<zzbui> {
    public int type;
    public long zzaIZ;
    public long zzaJa;

    public zzbui() {
        this.type = 3;
        this.zzaIZ = 0;
        this.zzaJa = 0;
        this.zzcsg = -1;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.type != 3) {
            com_google_android_gms_internal_zzbum.zzF(1, this.type);
        }
        if (this.zzaIZ != 0) {
            com_google_android_gms_internal_zzbum.zzb(2, this.zzaIZ);
        }
        if (this.zzaJa != 0) {
            com_google_android_gms_internal_zzbum.zzb(3, this.zzaJa);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbui zzaJ(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                            this.type = zzacu;
                            break;
                        default:
                            continue;
                    }
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzaIZ = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    this.zzaJa = com_google_android_gms_internal_zzbul.zzacx();
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
        return zzaJ(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.type != 3) {
            zzv += zzbum.zzH(1, this.type);
        }
        if (this.zzaIZ != 0) {
            zzv += zzbum.zzf(2, this.zzaIZ);
        }
        return this.zzaJa != 0 ? zzv + zzbum.zzf(3, this.zzaJa) : zzv;
    }
}
