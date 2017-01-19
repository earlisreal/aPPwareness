package com.google.android.gms.internal;

import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtv extends zzbun<zzbtv> {
    public int zzcqk;
    public int zzcra;

    public zzbtv() {
        this.zzcqk = 0;
        this.zzcra = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbtv)) {
            return false;
        }
        zzbtv com_google_android_gms_internal_zzbtv = (zzbtv) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbtv.zzcqk && this.zzcra == com_google_android_gms_internal_zzbtv.zzcra) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtv.zzcrX == null || com_google_android_gms_internal_zzbtv.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtv.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + this.zzcra) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (this.zzcra != 0) {
            com_google_android_gms_internal_zzbum.zzF(2, this.zzcra);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtv zzar(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        case Dimension.UNIT_IN /*4*/:
                        case Dimension.UNIT_MM /*5*/:
                        case BuyButtonText.LOGO_ONLY /*6*/:
                        case BuyButtonText.DONATE_WITH /*7*/:
                            this.zzcra = zzacu;
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
        return zzar(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        return this.zzcra != 0 ? zzv + zzbum.zzH(2, this.zzcra) : zzv;
    }
}
