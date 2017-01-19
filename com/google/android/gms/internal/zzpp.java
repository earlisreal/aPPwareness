package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzmb
public class zzpp {
    private static zzl zzXw;
    private static final Object zzXx;
    public static final zza<Void> zzXy;

    public interface zza<T> {
        T zzh(InputStream inputStream);

        T zziT();
    }

    /* renamed from: com.google.android.gms.internal.zzpp.1 */
    class C14811 implements zza<Void> {
        C14811() {
        }

        public /* bridge */ /* synthetic */ Object zzh(InputStream inputStream) {
            return null;
        }

        public /* bridge */ /* synthetic */ Object zziT() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpp.2 */
    class C14822 implements com.google.android.gms.internal.zzm.zza {
        final /* synthetic */ zzc zzXz;
        final /* synthetic */ String zzsk;

        C14822(zzpp com_google_android_gms_internal_zzpp, String str, zzc com_google_android_gms_internal_zzpp_zzc) {
            this.zzsk = str;
            this.zzXz = com_google_android_gms_internal_zzpp_zzc;
        }

        public void zze(zzr com_google_android_gms_internal_zzr) {
            String str = this.zzsk;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzr.toString());
            zzpy.zzbe(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
            this.zzXz.zzb(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpp.3 */
    class C14833 extends zzab {
        final /* synthetic */ byte[] zzXA;
        final /* synthetic */ Map zzXB;

        C14833(zzpp com_google_android_gms_internal_zzpp, int i, String str, com.google.android.gms.internal.zzm.zzb com_google_android_gms_internal_zzm_zzb, com.google.android.gms.internal.zzm.zza com_google_android_gms_internal_zzm_zza, byte[] bArr, Map map) {
            this.zzXA = bArr;
            this.zzXB = map;
            super(i, str, com_google_android_gms_internal_zzm_zzb, com_google_android_gms_internal_zzm_zza);
        }

        public Map<String, String> getHeaders() throws zza {
            return this.zzXB == null ? super.getHeaders() : this.zzXB;
        }

        public byte[] zzm() throws zza {
            return this.zzXA == null ? super.zzm() : this.zzXA;
        }
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzXC;
        private final com.google.android.gms.internal.zzm.zzb<T> zzaF;

        /* renamed from: com.google.android.gms.internal.zzpp.zzb.1 */
        class C14841 implements com.google.android.gms.internal.zzm.zza {
            final /* synthetic */ com.google.android.gms.internal.zzm.zzb zzXD;
            final /* synthetic */ zza zzXE;

            C14841(com.google.android.gms.internal.zzm.zzb com_google_android_gms_internal_zzm_zzb, zza com_google_android_gms_internal_zzpp_zza) {
                this.zzXD = com_google_android_gms_internal_zzm_zzb;
                this.zzXE = com_google_android_gms_internal_zzpp_zza;
            }

            public void zze(zzr com_google_android_gms_internal_zzr) {
                this.zzXD.zzb(this.zzXE.zziT());
            }
        }

        public zzb(String str, zza<T> com_google_android_gms_internal_zzpp_zza_T, com.google.android.gms.internal.zzm.zzb<T> com_google_android_gms_internal_zzm_zzb_T) {
            super(0, str, new C14841(com_google_android_gms_internal_zzm_zzb_T, com_google_android_gms_internal_zzpp_zza_T));
            this.zzXC = com_google_android_gms_internal_zzpp_zza_T;
            this.zzaF = com_google_android_gms_internal_zzm_zzb_T;
        }

        protected zzm<InputStream> zza(zzi com_google_android_gms_internal_zzi) {
            return zzm.zza(new ByteArrayInputStream(com_google_android_gms_internal_zzi.data), zzx.zzb(com_google_android_gms_internal_zzi));
        }

        protected /* synthetic */ void zza(Object obj) {
            zzj((InputStream) obj);
        }

        protected void zzj(InputStream inputStream) {
            this.zzaF.zzb(this.zzXC.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzqc<T> implements com.google.android.gms.internal.zzm.zzb<T> {
        private zzc(zzpp com_google_android_gms_internal_zzpp) {
        }

        public void zzb(@Nullable T t) {
            super.zzh(t);
        }
    }

    static {
        zzXx = new Object();
        zzXy = new C14811();
    }

    public zzpp(Context context) {
        zzN(context);
    }

    private static zzl zzN(Context context) {
        zzl com_google_android_gms_internal_zzl;
        synchronized (zzXx) {
            if (zzXw == null) {
                zzXw = zzac.zza(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzl = zzXw;
        }
        return com_google_android_gms_internal_zzl;
    }

    public zzqf<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        Object com_google_android_gms_internal_zzpp_zzc = new zzc();
        zzXw.zze(new C14833(this, i, str, com_google_android_gms_internal_zzpp_zzc, new C14822(this, str, com_google_android_gms_internal_zzpp_zzc), bArr, map));
        return com_google_android_gms_internal_zzpp_zzc;
    }

    public <T> zzqf<T> zza(String str, zza<T> com_google_android_gms_internal_zzpp_zza_T) {
        Object com_google_android_gms_internal_zzpp_zzc = new zzc();
        zzXw.zze(new zzb(str, com_google_android_gms_internal_zzpp_zza_T, com_google_android_gms_internal_zzpp_zzc));
        return com_google_android_gms_internal_zzpp_zzc;
    }

    public zzqf<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
