package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtw extends zzbun<zzbtw> {
    public String packageName;
    public int zzcqk;

    public zzbtw() {
        this.zzcqk = 0;
        this.packageName = BuildConfig.FLAVOR;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbtw)) {
            return false;
        }
        zzbtw com_google_android_gms_internal_zzbtw = (zzbtw) obj;
        if (this.zzcqk != com_google_android_gms_internal_zzbtw.zzcqk) {
            return false;
        }
        if (this.packageName == null) {
            if (com_google_android_gms_internal_zzbtw.packageName != null) {
                return false;
            }
        } else if (!this.packageName.equals(com_google_android_gms_internal_zzbtw.packageName)) {
            return false;
        }
        return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtw.zzcrX == null || com_google_android_gms_internal_zzbtw.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtw.zzcrX);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.packageName == null ? 0 : this.packageName.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31)) * 31;
        if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
            i = this.zzcrX.hashCode();
        }
        return hashCode + i;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (!(this.packageName == null || this.packageName.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(2, this.packageName);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtw zzas(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    this.packageName = com_google_android_gms_internal_zzbul.readString();
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
        return zzas(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        return (this.packageName == null || this.packageName.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(2, this.packageName);
    }
}
