package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtt extends zzbun<zzbtt> {
    public String moduleId;
    public int version;
    public String zzbwJ;
    public long zzcqY;
    public long zzcqZ;

    public zzbtt() {
        this.zzcqY = 0;
        this.zzcqZ = 0;
        this.version = 0;
        this.zzbwJ = BuildConfig.FLAVOR;
        this.moduleId = BuildConfig.FLAVOR;
        this.zzcsg = -1;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqY != 0) {
            com_google_android_gms_internal_zzbum.zzb(1, this.zzcqY);
        }
        if (this.zzcqZ != 0) {
            com_google_android_gms_internal_zzbum.zzb(2, this.zzcqZ);
        }
        if (this.version != 0) {
            com_google_android_gms_internal_zzbum.zzF(3, this.version);
        }
        if (!(this.zzbwJ == null || this.zzbwJ.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(4, this.zzbwJ);
        }
        if (!(this.moduleId == null || this.moduleId.equals(BuildConfig.FLAVOR))) {
            com_google_android_gms_internal_zzbum.zzq(5, this.moduleId);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtt zzap(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    this.zzcqY = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.zzcqZ = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    this.version = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.zzbwJ = com_google_android_gms_internal_zzbul.readString();
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    this.moduleId = com_google_android_gms_internal_zzbul.readString();
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
        return zzap(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqY != 0) {
            zzv += zzbum.zzf(1, this.zzcqY);
        }
        if (this.zzcqZ != 0) {
            zzv += zzbum.zzf(2, this.zzcqZ);
        }
        if (this.version != 0) {
            zzv += zzbum.zzH(3, this.version);
        }
        if (!(this.zzbwJ == null || this.zzbwJ.equals(BuildConfig.FLAVOR))) {
            zzv += zzbum.zzr(4, this.zzbwJ);
        }
        return (this.moduleId == null || this.moduleId.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(5, this.moduleId);
    }
}
