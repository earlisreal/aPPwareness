package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.util.Arrays;

public final class zzbtp extends zzbun<zzbtp> {
    public int zzcqk;
    public long zzcql;
    public zza[] zzcqt;

    public static final class zza extends zzbun<zza> {
        private static volatile zza[] zzcqu;
        public byte[] content;
        public String type;
        public String zzaFs;

        public zza() {
            this.zzaFs = BuildConfig.FLAVOR;
            this.type = BuildConfig.FLAVOR;
            this.content = zzbuw.zzcsp;
            this.zzcsg = -1;
        }

        public static zza zzZ(byte[] bArr) throws zzbus {
            return (zza) zzbut.zza(new zza(), bArr);
        }

        public static zza[] zzacs() {
            if (zzcqu == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzcqu == null) {
                        zzcqu = new zza[0];
                    }
                }
            }
            return zzcqu;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbtp_zza = (zza) obj;
            if (this.zzaFs == null) {
                if (com_google_android_gms_internal_zzbtp_zza.zzaFs != null) {
                    return false;
                }
            } else if (!this.zzaFs.equals(com_google_android_gms_internal_zzbtp_zza.zzaFs)) {
                return false;
            }
            if (this.type == null) {
                if (com_google_android_gms_internal_zzbtp_zza.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzbtp_zza.type)) {
                return false;
            }
            return Arrays.equals(this.content, com_google_android_gms_internal_zzbtp_zza.content) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtp_zza.zzcrX == null || com_google_android_gms_internal_zzbtp_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtp_zza.zzcrX) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + (((this.zzaFs == null ? 0 : this.zzaFs.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + Arrays.hashCode(this.content)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            if (!(this.zzaFs == null || this.zzaFs.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(1, this.zzaFs);
            }
            if (!(this.type == null || this.type.equals(BuildConfig.FLAVOR))) {
                com_google_android_gms_internal_zzbum.zzq(2, this.type);
            }
            if (!Arrays.equals(this.content, zzbuw.zzcsp)) {
                com_google_android_gms_internal_zzbum.zzb(3, this.content);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public zza zzal(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.zzaFs = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.type = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case C0394R.styleable.Toolbar_logoDescription /*26*/:
                        this.content = com_google_android_gms_internal_zzbul.readBytes();
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
            return zzal(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv();
            if (!(this.zzaFs == null || this.zzaFs.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(1, this.zzaFs);
            }
            if (!(this.type == null || this.type.equals(BuildConfig.FLAVOR))) {
                zzv += zzbum.zzr(2, this.type);
            }
            return !Arrays.equals(this.content, zzbuw.zzcsp) ? zzv + zzbum.zzc(3, this.content) : zzv;
        }
    }

    public zzbtp() {
        this.zzcqk = 0;
        this.zzcql = 0;
        this.zzcqt = zza.zzacs();
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbtp)) {
            return false;
        }
        zzbtp com_google_android_gms_internal_zzbtp = (zzbtp) obj;
        return (this.zzcqk == com_google_android_gms_internal_zzbtp.zzcqk && this.zzcql == com_google_android_gms_internal_zzbtp.zzcql && zzbur.equals(this.zzcqt, com_google_android_gms_internal_zzbtp.zzcqt)) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtp.zzcrX == null || com_google_android_gms_internal_zzbtp.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtp.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.zzcqk) * 31) + ((int) (this.zzcql ^ (this.zzcql >>> 32)))) * 31) + zzbur.hashCode(this.zzcqt)) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzcqk != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            com_google_android_gms_internal_zzbum.zzb(3, this.zzcql);
        }
        if (this.zzcqt != null && this.zzcqt.length > 0) {
            for (zzbut com_google_android_gms_internal_zzbut : this.zzcqt) {
                if (com_google_android_gms_internal_zzbut != null) {
                    com_google_android_gms_internal_zzbum.zza(4, com_google_android_gms_internal_zzbut);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtp zzak(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    this.zzcql = com_google_android_gms_internal_zzbul.zzacx();
                    continue;
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 34);
                    zzacu = this.zzcqt == null ? 0 : this.zzcqt.length;
                    Object obj = new zza[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzcqt, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = new zza();
                    com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                    this.zzcqt = obj;
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
        return zzak(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzcqk != 0) {
            zzv += zzbum.zzH(1, this.zzcqk);
        }
        if (this.zzcql != 0) {
            zzv += zzbum.zzf(3, this.zzcql);
        }
        if (this.zzcqt == null || this.zzcqt.length <= 0) {
            return zzv;
        }
        int i = zzv;
        for (zzbut com_google_android_gms_internal_zzbut : this.zzcqt) {
            if (com_google_android_gms_internal_zzbut != null) {
                i += zzbum.zzc(4, com_google_android_gms_internal_zzbut);
            }
        }
        return i;
    }
}
