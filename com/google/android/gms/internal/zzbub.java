package com.google.android.gms.internal;

import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbub extends zzbun<zzbub> {
    public int zzcqk;

    public zzbub() {
        this.zzcqk = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbub)) {
            return false;
        }
        zzbub com_google_android_gms_internal_zzbub = (zzbub) obj;
        return this.zzcqk == com_google_android_gms_internal_zzbub.zzcqk ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbub.zzcrX == null || com_google_android_gms_internal_zzbub.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbub.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbub zzaC(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                            this.zzcqk = zzacu;
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
        return zzaC(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        return this.zzcqk != 0 ? zzv + zzbum.zzH(1, this.zzcqk) : zzv;
    }
}
