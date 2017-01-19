package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public interface zzbux {

    public static final class zza extends zzbun<zza> {
        public int score;
        public boolean zzcsq;
        public String zzcsr;

        public zza() {
            zzada();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbux_zza = (zza) obj;
            if (this.zzcsq != com_google_android_gms_internal_zzbux_zza.zzcsq || this.score != com_google_android_gms_internal_zzbux_zza.score) {
                return false;
            }
            if (this.zzcsr == null) {
                if (com_google_android_gms_internal_zzbux_zza.zzcsr != null) {
                    return false;
                }
            } else if (!this.zzcsr.equals(com_google_android_gms_internal_zzbux_zza.zzcsr)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbux_zza.zzcrX == null || com_google_android_gms_internal_zzbux_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbux_zza.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcsr == null ? 0 : this.zzcsr.hashCode()) + (((((this.zzcsq ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + this.score) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (this.zzcsq) {
                com_google_android_gms_internal_zzbum.zzg(1, this.zzcsq);
            }
            if (this.score != 0) {
                com_google_android_gms_internal_zzbum.zzF(2, this.score);
            }
            if (!(this.zzcsr == null || this.zzcsr.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(3, this.zzcsr);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zza zzaN(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        this.zzcsq = com_google_android_gms_internal_zzbul.zzacA();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.score = com_google_android_gms_internal_zzbul.zzacy();
                        continue;
                    case C0394R.styleable.Toolbar_logoDescription /*26*/:
                        this.zzcsr = com_google_android_gms_internal_zzbul.readString();
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

        public zza zzada() {
            this.zzcsq = false;
            this.score = 0;
            this.zzcsr = BuildConfig.FLAVOR;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzaN(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (this.zzcsq) {
                zzv += zzbum.zzh(1, this.zzcsq);
            }
            if (this.score != 0) {
                zzv += zzbum.zzH(2, this.score);
            }
            return (this.zzcsr == null || this.zzcsr.equals(BuildConfig.FLAVOR)) ? zzv : zzv + zzbum.zzr(3, this.zzcsr);
        }
    }
}
