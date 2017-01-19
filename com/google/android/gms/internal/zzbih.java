package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.BuildConfig;
import com.github.paolorotolo.appintro.C0394R;
import com.google.ads.AdSize;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.util.Arrays;

public final class zzbih extends zzbun<zzbih> {
    public zza[] zzbTs;

    public static final class zza extends zzbun<zza> {
        private static volatile zza[] zzbTt;
        public String name;
        public zza zzbTu;

        public static final class zza extends zzbun<zza> {
            private static volatile zza[] zzbTv;
            public int type;
            public zza zzbTw;

            public static final class zza extends zzbun<zza> {
                public float zzbTA;
                public long zzbTB;
                public int zzbTC;
                public int zzbTD;
                public boolean zzbTE;
                public zza[] zzbTF;
                public zza[] zzbTG;
                public String[] zzbTH;
                public long[] zzbTI;
                public float[] zzbTJ;
                public long zzbTK;
                public byte[] zzbTx;
                public String zzbTy;
                public double zzbTz;

                public zza() {
                    zzTe();
                }

                public boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof zza)) {
                        return false;
                    }
                    zza com_google_android_gms_internal_zzbih_zza_zza_zza = (zza) obj;
                    if (!Arrays.equals(this.zzbTx, com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTx)) {
                        return false;
                    }
                    if (this.zzbTy == null) {
                        if (com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTy != null) {
                            return false;
                        }
                    } else if (!this.zzbTy.equals(com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTy)) {
                        return false;
                    }
                    return (Double.doubleToLongBits(this.zzbTz) == Double.doubleToLongBits(com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTz) && Float.floatToIntBits(this.zzbTA) == Float.floatToIntBits(com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTA) && this.zzbTB == com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTB && this.zzbTC == com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTC && this.zzbTD == com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTD && this.zzbTE == com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTE && zzbur.equals(this.zzbTF, com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTF) && zzbur.equals(this.zzbTG, com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTG) && zzbur.equals(this.zzbTH, com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTH) && zzbur.equals(this.zzbTI, com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTI) && zzbur.equals(this.zzbTJ, com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTJ) && this.zzbTK == com_google_android_gms_internal_zzbih_zza_zza_zza.zzbTK) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbih_zza_zza_zza.zzcrX == null || com_google_android_gms_internal_zzbih_zza_zza_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbih_zza_zza_zza.zzcrX) : false;
                }

                public int hashCode() {
                    int i = 0;
                    int hashCode = (this.zzbTy == null ? 0 : this.zzbTy.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbTx)) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.zzbTz);
                    hashCode = ((((((((((((((this.zzbTE ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzbTA)) * 31) + ((int) (this.zzbTB ^ (this.zzbTB >>> 32)))) * 31) + this.zzbTC) * 31) + this.zzbTD) * 31)) * 31) + zzbur.hashCode(this.zzbTF)) * 31) + zzbur.hashCode(this.zzbTG)) * 31) + zzbur.hashCode(this.zzbTH)) * 31) + zzbur.hashCode(this.zzbTI)) * 31) + zzbur.hashCode(this.zzbTJ)) * 31) + ((int) (this.zzbTK ^ (this.zzbTK >>> 32)))) * 31;
                    if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                        i = this.zzcrX.hashCode();
                    }
                    return hashCode + i;
                }

                public zza zzTe() {
                    this.zzbTx = zzbuw.zzcsp;
                    this.zzbTy = BuildConfig.FLAVOR;
                    this.zzbTz = 0.0d;
                    this.zzbTA = 0.0f;
                    this.zzbTB = 0;
                    this.zzbTC = 0;
                    this.zzbTD = 0;
                    this.zzbTE = false;
                    this.zzbTF = zza.zzTa();
                    this.zzbTG = zza.zzTc();
                    this.zzbTH = zzbuw.zzcsn;
                    this.zzbTI = zzbuw.zzcsj;
                    this.zzbTJ = zzbuw.zzcsk;
                    this.zzbTK = 0;
                    this.zzcrX = null;
                    this.zzcsg = -1;
                    return this;
                }

                public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
                    int i = 0;
                    if (!Arrays.equals(this.zzbTx, zzbuw.zzcsp)) {
                        com_google_android_gms_internal_zzbum.zzb(1, this.zzbTx);
                    }
                    if (!(this.zzbTy == null || this.zzbTy.equals(BuildConfig.FLAVOR))) {
                        com_google_android_gms_internal_zzbum.zzq(2, this.zzbTy);
                    }
                    if (Double.doubleToLongBits(this.zzbTz) != Double.doubleToLongBits(0.0d)) {
                        com_google_android_gms_internal_zzbum.zza(3, this.zzbTz);
                    }
                    if (Float.floatToIntBits(this.zzbTA) != Float.floatToIntBits(0.0f)) {
                        com_google_android_gms_internal_zzbum.zzc(4, this.zzbTA);
                    }
                    if (this.zzbTB != 0) {
                        com_google_android_gms_internal_zzbum.zzb(5, this.zzbTB);
                    }
                    if (this.zzbTC != 0) {
                        com_google_android_gms_internal_zzbum.zzF(6, this.zzbTC);
                    }
                    if (this.zzbTD != 0) {
                        com_google_android_gms_internal_zzbum.zzG(7, this.zzbTD);
                    }
                    if (this.zzbTE) {
                        com_google_android_gms_internal_zzbum.zzg(8, this.zzbTE);
                    }
                    if (this.zzbTF != null && this.zzbTF.length > 0) {
                        for (zzbut com_google_android_gms_internal_zzbut : this.zzbTF) {
                            if (com_google_android_gms_internal_zzbut != null) {
                                com_google_android_gms_internal_zzbum.zza(9, com_google_android_gms_internal_zzbut);
                            }
                        }
                    }
                    if (this.zzbTG != null && this.zzbTG.length > 0) {
                        for (zzbut com_google_android_gms_internal_zzbut2 : this.zzbTG) {
                            if (com_google_android_gms_internal_zzbut2 != null) {
                                com_google_android_gms_internal_zzbum.zza(10, com_google_android_gms_internal_zzbut2);
                            }
                        }
                    }
                    if (this.zzbTH != null && this.zzbTH.length > 0) {
                        for (String str : this.zzbTH) {
                            if (str != null) {
                                com_google_android_gms_internal_zzbum.zzq(11, str);
                            }
                        }
                    }
                    if (this.zzbTI != null && this.zzbTI.length > 0) {
                        for (long zzb : this.zzbTI) {
                            com_google_android_gms_internal_zzbum.zzb(12, zzb);
                        }
                    }
                    if (this.zzbTK != 0) {
                        com_google_android_gms_internal_zzbum.zzb(13, this.zzbTK);
                    }
                    if (this.zzbTJ != null && this.zzbTJ.length > 0) {
                        while (i < this.zzbTJ.length) {
                            com_google_android_gms_internal_zzbum.zzc(14, this.zzbTJ[i]);
                            i++;
                        }
                    }
                    super.zza(com_google_android_gms_internal_zzbum);
                }

                public zza zzaa(zzbul com_google_android_gms_internal_zzbul) throws IOException {
                    while (true) {
                        int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                        int zzc;
                        Object obj;
                        int zzqj;
                        switch (zzacu) {
                            case MessageApi.FILTER_LITERAL /*0*/:
                                break;
                            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                                this.zzbTx = com_google_android_gms_internal_zzbul.readBytes();
                                continue;
                            case ConnectionResult.SERVICE_UPDATING /*18*/:
                                this.zzbTy = com_google_android_gms_internal_zzbul.readString();
                                continue;
                            case C0394R.styleable.Toolbar_navigationContentDescription /*25*/:
                                this.zzbTz = com_google_android_gms_internal_zzbul.readDouble();
                                continue;
                            case C0394R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                                this.zzbTA = com_google_android_gms_internal_zzbul.readFloat();
                                continue;
                            case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                                this.zzbTB = com_google_android_gms_internal_zzbul.zzacx();
                                continue;
                            case C0394R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                                this.zzbTC = com_google_android_gms_internal_zzbul.zzacy();
                                continue;
                            case C0394R.styleable.AppCompatTheme_dividerVertical /*56*/:
                                this.zzbTD = com_google_android_gms_internal_zzbul.zzacB();
                                continue;
                            case C0394R.styleable.AppCompatTheme_editTextBackground /*64*/:
                                this.zzbTE = com_google_android_gms_internal_zzbul.zzacA();
                                continue;
                            case C0394R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                                zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 74);
                                zzacu = this.zzbTF == null ? 0 : this.zzbTF.length;
                                obj = new zza[(zzc + zzacu)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzbTF, 0, obj, 0, zzacu);
                                }
                                while (zzacu < obj.length - 1) {
                                    obj[zzacu] = new zza();
                                    com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                                    com_google_android_gms_internal_zzbul.zzacu();
                                    zzacu++;
                                }
                                obj[zzacu] = new zza();
                                com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                                this.zzbTF = obj;
                                continue;
                            case C0394R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                                zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 82);
                                zzacu = this.zzbTG == null ? 0 : this.zzbTG.length;
                                obj = new zza[(zzc + zzacu)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzbTG, 0, obj, 0, zzacu);
                                }
                                while (zzacu < obj.length - 1) {
                                    obj[zzacu] = new zza();
                                    com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                                    com_google_android_gms_internal_zzbul.zzacu();
                                    zzacu++;
                                }
                                obj[zzacu] = new zza();
                                com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                                this.zzbTG = obj;
                                continue;
                            case AdSize.LARGE_AD_HEIGHT /*90*/:
                                zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 90);
                                zzacu = this.zzbTH == null ? 0 : this.zzbTH.length;
                                obj = new String[(zzc + zzacu)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzbTH, 0, obj, 0, zzacu);
                                }
                                while (zzacu < obj.length - 1) {
                                    obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                                    com_google_android_gms_internal_zzbul.zzacu();
                                    zzacu++;
                                }
                                obj[zzacu] = com_google_android_gms_internal_zzbul.readString();
                                this.zzbTH = obj;
                                continue;
                            case C0394R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                                zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 96);
                                zzacu = this.zzbTI == null ? 0 : this.zzbTI.length;
                                obj = new long[(zzc + zzacu)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzbTI, 0, obj, 0, zzacu);
                                }
                                while (zzacu < obj.length - 1) {
                                    obj[zzacu] = com_google_android_gms_internal_zzbul.zzacx();
                                    com_google_android_gms_internal_zzbul.zzacu();
                                    zzacu++;
                                }
                                obj[zzacu] = com_google_android_gms_internal_zzbul.zzacx();
                                this.zzbTI = obj;
                                continue;
                            case C0394R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                                zzqj = com_google_android_gms_internal_zzbul.zzqj(com_google_android_gms_internal_zzbul.zzacD());
                                zzc = com_google_android_gms_internal_zzbul.getPosition();
                                zzacu = 0;
                                while (com_google_android_gms_internal_zzbul.zzacI() > 0) {
                                    com_google_android_gms_internal_zzbul.zzacx();
                                    zzacu++;
                                }
                                com_google_android_gms_internal_zzbul.zzql(zzc);
                                zzc = this.zzbTI == null ? 0 : this.zzbTI.length;
                                Object obj2 = new long[(zzacu + zzc)];
                                if (zzc != 0) {
                                    System.arraycopy(this.zzbTI, 0, obj2, 0, zzc);
                                }
                                while (zzc < obj2.length) {
                                    obj2[zzc] = com_google_android_gms_internal_zzbul.zzacx();
                                    zzc++;
                                }
                                this.zzbTI = obj2;
                                com_google_android_gms_internal_zzbul.zzqk(zzqj);
                                continue;
                            case C0394R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                                this.zzbTK = com_google_android_gms_internal_zzbul.zzacx();
                                continue;
                            case C0394R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                                zzacu = com_google_android_gms_internal_zzbul.zzacD();
                                zzc = com_google_android_gms_internal_zzbul.zzqj(zzacu);
                                zzqj = zzacu / 4;
                                zzacu = this.zzbTJ == null ? 0 : this.zzbTJ.length;
                                Object obj3 = new float[(zzqj + zzacu)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzbTJ, 0, obj3, 0, zzacu);
                                }
                                while (zzacu < obj3.length) {
                                    obj3[zzacu] = com_google_android_gms_internal_zzbul.readFloat();
                                    zzacu++;
                                }
                                this.zzbTJ = obj3;
                                com_google_android_gms_internal_zzbul.zzqk(zzc);
                                continue;
                            case 117:
                                zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 117);
                                zzacu = this.zzbTJ == null ? 0 : this.zzbTJ.length;
                                obj = new float[(zzc + zzacu)];
                                if (zzacu != 0) {
                                    System.arraycopy(this.zzbTJ, 0, obj, 0, zzacu);
                                }
                                while (zzacu < obj.length - 1) {
                                    obj[zzacu] = com_google_android_gms_internal_zzbul.readFloat();
                                    com_google_android_gms_internal_zzbul.zzacu();
                                    zzacu++;
                                }
                                obj[zzacu] = com_google_android_gms_internal_zzbul.readFloat();
                                this.zzbTJ = obj;
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
                    return zzaa(com_google_android_gms_internal_zzbul);
                }

                protected int zzv() {
                    int i;
                    int i2 = 0;
                    int zzv = super.zzv();
                    if (!Arrays.equals(this.zzbTx, zzbuw.zzcsp)) {
                        zzv += zzbum.zzc(1, this.zzbTx);
                    }
                    if (!(this.zzbTy == null || this.zzbTy.equals(BuildConfig.FLAVOR))) {
                        zzv += zzbum.zzr(2, this.zzbTy);
                    }
                    if (Double.doubleToLongBits(this.zzbTz) != Double.doubleToLongBits(0.0d)) {
                        zzv += zzbum.zzb(3, this.zzbTz);
                    }
                    if (Float.floatToIntBits(this.zzbTA) != Float.floatToIntBits(0.0f)) {
                        zzv += zzbum.zzd(4, this.zzbTA);
                    }
                    if (this.zzbTB != 0) {
                        zzv += zzbum.zzf(5, this.zzbTB);
                    }
                    if (this.zzbTC != 0) {
                        zzv += zzbum.zzH(6, this.zzbTC);
                    }
                    if (this.zzbTD != 0) {
                        zzv += zzbum.zzI(7, this.zzbTD);
                    }
                    if (this.zzbTE) {
                        zzv += zzbum.zzh(8, this.zzbTE);
                    }
                    if (this.zzbTF != null && this.zzbTF.length > 0) {
                        i = zzv;
                        for (zzbut com_google_android_gms_internal_zzbut : this.zzbTF) {
                            if (com_google_android_gms_internal_zzbut != null) {
                                i += zzbum.zzc(9, com_google_android_gms_internal_zzbut);
                            }
                        }
                        zzv = i;
                    }
                    if (this.zzbTG != null && this.zzbTG.length > 0) {
                        i = zzv;
                        for (zzbut com_google_android_gms_internal_zzbut2 : this.zzbTG) {
                            if (com_google_android_gms_internal_zzbut2 != null) {
                                i += zzbum.zzc(10, com_google_android_gms_internal_zzbut2);
                            }
                        }
                        zzv = i;
                    }
                    if (this.zzbTH != null && this.zzbTH.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.zzbTH) {
                            if (str != null) {
                                i4++;
                                i3 += zzbum.zzkc(str);
                            }
                        }
                        zzv = (zzv + i3) + (i4 * 1);
                    }
                    if (this.zzbTI != null && this.zzbTI.length > 0) {
                        i = 0;
                        while (i2 < this.zzbTI.length) {
                            i += zzbum.zzbb(this.zzbTI[i2]);
                            i2++;
                        }
                        zzv = (zzv + i) + (this.zzbTI.length * 1);
                    }
                    if (this.zzbTK != 0) {
                        zzv += zzbum.zzf(13, this.zzbTK);
                    }
                    return (this.zzbTJ == null || this.zzbTJ.length <= 0) ? zzv : (zzv + (this.zzbTJ.length * 4)) + (this.zzbTJ.length * 1);
                }
            }

            public zza() {
                zzTd();
            }

            public static zza[] zzTc() {
                if (zzbTv == null) {
                    synchronized (zzbur.zzcsf) {
                        if (zzbTv == null) {
                            zzbTv = new zza[0];
                        }
                    }
                }
                return zzbTv;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzbih_zza_zza = (zza) obj;
                if (this.type != com_google_android_gms_internal_zzbih_zza_zza.type) {
                    return false;
                }
                if (this.zzbTw == null) {
                    if (com_google_android_gms_internal_zzbih_zza_zza.zzbTw != null) {
                        return false;
                    }
                } else if (!this.zzbTw.equals(com_google_android_gms_internal_zzbih_zza_zza.zzbTw)) {
                    return false;
                }
                return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbih_zza_zza.zzcrX == null || com_google_android_gms_internal_zzbih_zza_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbih_zza_zza.zzcrX);
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzbTw == null ? 0 : this.zzbTw.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31;
                if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                    i = this.zzcrX.hashCode();
                }
                return hashCode + i;
            }

            public zza zzTd() {
                this.type = 1;
                this.zzbTw = null;
                this.zzcrX = null;
                this.zzcsg = -1;
                return this;
            }

            public zza zzZ(zzbul com_google_android_gms_internal_zzbul) throws IOException {
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
                                case Dimension.UNIT_IN /*4*/:
                                case Dimension.UNIT_MM /*5*/:
                                case BuyButtonText.LOGO_ONLY /*6*/:
                                case BuyButtonText.DONATE_WITH /*7*/:
                                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                case ConnectionResult.CANCELED /*13*/:
                                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                    this.type = zzacu;
                                    break;
                                default:
                                    continue;
                            }
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                            if (this.zzbTw == null) {
                                this.zzbTw = new zza();
                            }
                            com_google_android_gms_internal_zzbul.zza(this.zzbTw);
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

            public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
                com_google_android_gms_internal_zzbum.zzF(1, this.type);
                if (this.zzbTw != null) {
                    com_google_android_gms_internal_zzbum.zza(2, this.zzbTw);
                }
                super.zza(com_google_android_gms_internal_zzbum);
            }

            public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
                return zzZ(com_google_android_gms_internal_zzbul);
            }

            protected int zzv() {
                int zzv = super.zzv() + zzbum.zzH(1, this.type);
                return this.zzbTw != null ? zzv + zzbum.zzc(2, this.zzbTw) : zzv;
            }
        }

        public zza() {
            zzTb();
        }

        public static zza[] zzTa() {
            if (zzbTt == null) {
                synchronized (zzbur.zzcsf) {
                    if (zzbTt == null) {
                        zzbTt = new zza[0];
                    }
                }
            }
            return zzbTt;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzbih_zza = (zza) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzbih_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzbih_zza.name)) {
                return false;
            }
            if (this.zzbTu == null) {
                if (com_google_android_gms_internal_zzbih_zza.zzbTu != null) {
                    return false;
                }
            } else if (!this.zzbTu.equals(com_google_android_gms_internal_zzbih_zza.zzbTu)) {
                return false;
            }
            return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbih_zza.zzcrX == null || com_google_android_gms_internal_zzbih_zza.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbih_zza.zzcrX);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbTu == null ? 0 : this.zzbTu.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
                i = this.zzcrX.hashCode();
            }
            return hashCode + i;
        }

        public zza zzTb() {
            this.name = BuildConfig.FLAVOR;
            this.zzbTu = null;
            this.zzcrX = null;
            this.zzcsg = -1;
            return this;
        }

        public zza zzY(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            while (true) {
                int zzacu = com_google_android_gms_internal_zzbul.zzacu();
                switch (zzacu) {
                    case MessageApi.FILTER_LITERAL /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.name = com_google_android_gms_internal_zzbul.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzbTu == null) {
                            this.zzbTu = new zza();
                        }
                        com_google_android_gms_internal_zzbul.zza(this.zzbTu);
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

        public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
            com_google_android_gms_internal_zzbum.zzq(1, this.name);
            if (this.zzbTu != null) {
                com_google_android_gms_internal_zzbum.zza(2, this.zzbTu);
            }
            super.zza(com_google_android_gms_internal_zzbum);
        }

        public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
            return zzY(com_google_android_gms_internal_zzbul);
        }

        protected int zzv() {
            int zzv = super.zzv() + zzbum.zzr(1, this.name);
            return this.zzbTu != null ? zzv + zzbum.zzc(2, this.zzbTu) : zzv;
        }
    }

    public zzbih() {
        zzSZ();
    }

    public static zzbih zzR(byte[] bArr) throws zzbus {
        return (zzbih) zzbut.zza(new zzbih(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbih)) {
            return false;
        }
        zzbih com_google_android_gms_internal_zzbih = (zzbih) obj;
        return zzbur.equals(this.zzbTs, com_google_android_gms_internal_zzbih.zzbTs) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbih.zzcrX == null || com_google_android_gms_internal_zzbih.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbih.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzbur.hashCode(this.zzbTs)) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public zzbih zzSZ() {
        this.zzbTs = zza.zzTa();
        this.zzcrX = null;
        this.zzcsg = -1;
        return this;
    }

    public zzbih zzX(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 10);
                    zzacu = this.zzbTs == null ? 0 : this.zzbTs.length;
                    Object obj = new zza[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzbTs, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = new zza();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = new zza();
                    com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                    this.zzbTs = obj;
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

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.zzbTs != null && this.zzbTs.length > 0) {
            for (zzbut com_google_android_gms_internal_zzbut : this.zzbTs) {
                if (com_google_android_gms_internal_zzbut != null) {
                    com_google_android_gms_internal_zzbum.zza(1, com_google_android_gms_internal_zzbut);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzX(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.zzbTs != null && this.zzbTs.length > 0) {
            for (zzbut com_google_android_gms_internal_zzbut : this.zzbTs) {
                if (com_google_android_gms_internal_zzbut != null) {
                    zzv += zzbum.zzc(1, com_google_android_gms_internal_zzbut);
                }
            }
        }
        return zzv;
    }
}
