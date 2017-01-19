package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbuk extends zzbun<zzbuk> {
    public int zzcqk;
    public long zzcql;
    public float zzcrM;
    public int zzcrq;

    public zzbuk() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcrM = 0.0f;
        this.zzcrq = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbuk)) {
            return false;
        }
        zzbuk com_google_android_gms_internal_zzbuk = (zzbuk) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbuk.zzcqk && this.zzcql == com_google_android_gms_internal_zzbuk.zzcql && Float.floatToIntBits(this.zzcrM) == Float.floatToIntBits(com_google_android_gms_internal_zzbuk.zzcrM) && this.zzcrq == com_google_android_gms_internal_zzbuk.zzcrq) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbuk.zzcrX == null || com_google_android_gms_internal_zzbuk.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbuk.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + Float.floatToIntBits(this.zzcrM)) * 31) + this.zzcrq) * 31;
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
        if (Float.floatToIntBits(this.zzcrM) != Float.floatToIntBits(0.0f)) {
            com_google_android_gms_internal_zzbum.zzc(3, this.zzcrM);
        }
        if (this.zzcrq != 0) {
            com_google_android_gms_internal_zzbum.zzF(4, this.zzcrq);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbuk zzaL(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                case C0394R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    this.zzcrM = com_google_android_gms_internal_zzbul.readFloat();
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    this.zzcrq = com_google_android_gms_internal_zzbul.zzacy();
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
        return zzaL(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(2, this.zzcql);
        }
        if (Float.floatToIntBits(this.zzcrM) != Float.floatToIntBits(0.0f)) {
            zzv += zzbum.zzd(3, this.zzcrM);
        }
        return this.zzcrq != 0 ? zzv + zzbum.zzH(4, this.zzcrq) : zzv;
    }
}
