package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbty extends zzbun<zzbty> {
    public String zzcrs;
    public String zzcrt;
    public String zzcru;

    public zzbty() {
        this.zzcrs = BuildConfig.FLAVOR;
        this.zzcrt = BuildConfig.FLAVOR;
        this.zzcru = BuildConfig.FLAVOR;
        this.zzcsg = -1;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (!(this.zzcrs == null || this.zzcrs.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(1, this.zzcrs);
        }
        if (!(this.zzcrt == null || this.zzcrt.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(2, this.zzcrt);
        }
        if (!(this.zzcru == null || this.zzcru.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(3, this.zzcru);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbty zzaz(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    this.zzcrs = com_google_android_gms_internal_zzbul.readString();
                    continue;
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    this.zzcrt = com_google_android_gms_internal_zzbul.readString();
                    continue;
                case C0394R.styleable.Toolbar_logoDescription /*26*/:
                    this.zzcru = com_google_android_gms_internal_zzbul.readString();
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
        return zzaz(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (!(this.zzcrs == null || this.zzcrs.equals(BuildConfig.FLAVOR))) {
            zzv += zzbum.zzr(1, this.zzcrs);
        }
        if (!(this.zzcrt == null || this.zzcrt.equals(BuildConfig.FLAVOR))) {
            zzv += zzbum.zzr(2, this.zzcrt);
        }
        return (this.zzcru == null || this.zzcru.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(3, this.zzcru);
    }
}
