package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbuh extends zzbun<zzbuh> {
    public String zzaIv;

    public zzbuh() {
        this.zzaIv = BuildConfig.FLAVOR;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbuh)) {
            return false;
        }
        zzbuh com_google_android_gms_internal_zzbuh = (zzbuh) obj;
        if (this.zzaIv == null) {
            if (com_google_android_gms_internal_zzbuh.zzaIv != null) {
                return false;
            }
        } else if (!this.zzaIv.equals(com_google_android_gms_internal_zzbuh.zzaIv)) {
            return false;
        }
        return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbuh.zzcrX == null || com_google_android_gms_internal_zzbuh.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbuh.zzcrX);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzaIv == null ? 0 : this.zzaIv.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
            i = this.zzcrX.hashCode();
        }
        return hashCode + i;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (!(this.zzaIv == null || this.zzaIv.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(1, this.zzaIv);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbuh zzaI(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    this.zzaIv = com_google_android_gms_internal_zzbul.readString();
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
        return zzaI(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        return (this.zzaIv == null || this.zzaIv.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(1, this.zzaIv);
    }
}
