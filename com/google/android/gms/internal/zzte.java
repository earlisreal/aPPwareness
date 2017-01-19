package com.google.android.gms.internal;

public class zzte extends zzsi<zztf> {

    private static class zza extends zzrt implements com.google.android.gms.internal.zzsi.zza<zztf> {
        private final zztf zzafM;

        public zza(zzrw com_google_android_gms_internal_zzrw) {
            super(com_google_android_gms_internal_zzrw);
            this.zzafM = new zztf();
        }

        public void zzd(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzafM.zzafO = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        public void zze(String str, boolean z) {
            int i = 1;
            zztf com_google_android_gms_internal_zztf;
            if ("ga_autoActivityTracking".equals(str)) {
                com_google_android_gms_internal_zztf = this.zzafM;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_internal_zztf.zzafP = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                com_google_android_gms_internal_zztf = this.zzafM;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_internal_zztf.zzafQ = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                com_google_android_gms_internal_zztf = this.zzafM;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_internal_zztf.zzafR = i;
            } else {
                zzd("bool configuration name not recognized", str);
            }
        }

        public void zzo(String str, String str2) {
            this.zzafM.zzafS.put(str, str2);
        }

        public /* synthetic */ zzsh zzov() {
            return zzpR();
        }

        public void zzp(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzafM.zzaar = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.zzafM.zzafN = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzc("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                zzd("string configuration name not recognized", str);
            }
        }

        public zztf zzpR() {
            return this.zzafM;
        }
    }

    public zzte(zzrw com_google_android_gms_internal_zzrw) {
        super(com_google_android_gms_internal_zzrw, new zza(com_google_android_gms_internal_zzrw));
    }
}
