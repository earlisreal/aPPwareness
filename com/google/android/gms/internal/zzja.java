package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.Map;

@zzmb
public class zzja {
    private final Context mContext;
    private final String zzJd;
    private zzpn<zzix> zzJe;
    private zzpn<zzix> zzJf;
    @Nullable
    private zzd zzJg;
    private int zzJh;
    private final Object zzrN;
    private final zzqa zztr;

    /* renamed from: com.google.android.gms.internal.zzja.1 */
    class C13651 implements Runnable {
        final /* synthetic */ zzav zzJi;
        final /* synthetic */ zzd zzJj;
        final /* synthetic */ zzja zzJk;

        /* renamed from: com.google.android.gms.internal.zzja.1.1 */
        class C13601 implements com.google.android.gms.internal.zzix.zza {
            final /* synthetic */ zzix zzJl;
            final /* synthetic */ C13651 zzJm;

            /* renamed from: com.google.android.gms.internal.zzja.1.1.1 */
            class C13591 implements Runnable {
                final /* synthetic */ C13601 zzJn;

                /* renamed from: com.google.android.gms.internal.zzja.1.1.1.1 */
                class C13581 implements Runnable {
                    final /* synthetic */ C13591 zzJo;

                    C13581(C13591 c13591) {
                        this.zzJo = c13591;
                    }

                    public void run() {
                        this.zzJo.zzJn.zzJl.destroy();
                    }
                }

                C13591(C13601 c13601) {
                    this.zzJn = c13601;
                }

                public void run() {
                    synchronized (this.zzJn.zzJm.zzJk.zzrN) {
                        if (this.zzJn.zzJm.zzJj.getStatus() == -1 || this.zzJn.zzJm.zzJj.getStatus() == 1) {
                            return;
                        }
                        this.zzJn.zzJm.zzJj.reject();
                        zzv.zzcJ().runOnUiThread(new C13581(this));
                        zzpe.m29v("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }

            C13601(C13651 c13651, zzix com_google_android_gms_internal_zzix) {
                this.zzJm = c13651;
                this.zzJl = com_google_android_gms_internal_zzix;
            }

            public void zzgu() {
                zzpi.zzWR.postDelayed(new C13591(this), (long) zza.zzJt);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.1.2 */
        class C13612 implements zzhx {
            final /* synthetic */ zzix zzJl;
            final /* synthetic */ C13651 zzJm;

            C13612(C13651 c13651, zzix com_google_android_gms_internal_zzix) {
                this.zzJm = c13651;
                this.zzJl = com_google_android_gms_internal_zzix;
            }

            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                synchronized (this.zzJm.zzJk.zzrN) {
                    if (this.zzJm.zzJj.getStatus() == -1 || this.zzJm.zzJj.getStatus() == 1) {
                        return;
                    }
                    this.zzJm.zzJk.zzJh = 0;
                    this.zzJm.zzJk.zzJe.zzd(this.zzJl);
                    this.zzJm.zzJj.zzg(this.zzJl);
                    this.zzJm.zzJk.zzJg = this.zzJm.zzJj;
                    zzpe.m29v("Successfully loaded JS Engine.");
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.1.3 */
        class C13623 implements zzhx {
            final /* synthetic */ zzix zzJl;
            final /* synthetic */ C13651 zzJm;
            final /* synthetic */ zzpu zzJp;

            C13623(C13651 c13651, zzix com_google_android_gms_internal_zzix, zzpu com_google_android_gms_internal_zzpu) {
                this.zzJm = c13651;
                this.zzJl = com_google_android_gms_internal_zzix;
                this.zzJp = com_google_android_gms_internal_zzpu;
            }

            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                synchronized (this.zzJm.zzJk.zzrN) {
                    zzpy.zzbd("JS Engine is requesting an update");
                    if (this.zzJm.zzJk.zzJh == 0) {
                        zzpy.zzbd("Starting reload.");
                        this.zzJm.zzJk.zzJh = 2;
                        this.zzJm.zzJk.zzb(this.zzJm.zzJi);
                    }
                    this.zzJl.zzb("/requestReload", (zzhx) this.zzJp.get());
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.1.4 */
        class C13644 implements Runnable {
            final /* synthetic */ zzix zzJl;
            final /* synthetic */ C13651 zzJm;

            /* renamed from: com.google.android.gms.internal.zzja.1.4.1 */
            class C13631 implements Runnable {
                final /* synthetic */ C13644 zzJq;

                C13631(C13644 c13644) {
                    this.zzJq = c13644;
                }

                public void run() {
                    this.zzJq.zzJl.destroy();
                }
            }

            C13644(C13651 c13651, zzix com_google_android_gms_internal_zzix) {
                this.zzJm = c13651;
                this.zzJl = com_google_android_gms_internal_zzix;
            }

            public void run() {
                synchronized (this.zzJm.zzJk.zzrN) {
                    if (this.zzJm.zzJj.getStatus() == -1 || this.zzJm.zzJj.getStatus() == 1) {
                        return;
                    }
                    this.zzJm.zzJj.reject();
                    zzv.zzcJ().runOnUiThread(new C13631(this));
                    zzpe.m29v("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }

        C13651(zzja com_google_android_gms_internal_zzja, zzav com_google_android_gms_internal_zzav, zzd com_google_android_gms_internal_zzja_zzd) {
            this.zzJk = com_google_android_gms_internal_zzja;
            this.zzJi = com_google_android_gms_internal_zzav;
            this.zzJj = com_google_android_gms_internal_zzja_zzd;
        }

        public void run() {
            zzix zza = this.zzJk.zza(this.zzJk.mContext, this.zzJk.zztr, this.zzJi);
            zza.zza(new C13601(this, zza));
            zza.zza("/jsLoaded", new C13612(this, zza));
            zzpu com_google_android_gms_internal_zzpu = new zzpu();
            zzhx c13623 = new C13623(this, zza, com_google_android_gms_internal_zzpu);
            com_google_android_gms_internal_zzpu.set(c13623);
            zza.zza("/requestReload", c13623);
            if (this.zzJk.zzJd.endsWith(".js")) {
                zza.zzal(this.zzJk.zzJd);
            } else if (this.zzJk.zzJd.startsWith("<html>")) {
                zza.zzan(this.zzJk.zzJd);
            } else {
                zza.zzam(this.zzJk.zzJd);
            }
            zzpi.zzWR.postDelayed(new C13644(this, zza), (long) zza.zzJs);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzja.2 */
    class C13662 implements com.google.android.gms.internal.zzqi.zzc<zzix> {
        final /* synthetic */ zzja zzJk;
        final /* synthetic */ zzd zzJr;

        C13662(zzja com_google_android_gms_internal_zzja, zzd com_google_android_gms_internal_zzja_zzd) {
            this.zzJk = com_google_android_gms_internal_zzja;
            this.zzJr = com_google_android_gms_internal_zzja_zzd;
        }

        public void zza(zzix com_google_android_gms_internal_zzix) {
            synchronized (this.zzJk.zzrN) {
                this.zzJk.zzJh = 0;
                if (!(this.zzJk.zzJg == null || this.zzJr == this.zzJk.zzJg)) {
                    zzpe.m29v("New JS engine is loaded, marking previous one as destroyable.");
                    this.zzJk.zzJg.zzgy();
                }
                this.zzJk.zzJg = this.zzJr;
            }
        }

        public /* synthetic */ void zzd(Object obj) {
            zza((zzix) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzja.3 */
    class C13673 implements com.google.android.gms.internal.zzqi.zza {
        final /* synthetic */ zzja zzJk;
        final /* synthetic */ zzd zzJr;

        C13673(zzja com_google_android_gms_internal_zzja, zzd com_google_android_gms_internal_zzja_zzd) {
            this.zzJk = com_google_android_gms_internal_zzja;
            this.zzJr = com_google_android_gms_internal_zzja_zzd;
        }

        public void run() {
            synchronized (this.zzJk.zzrN) {
                this.zzJk.zzJh = 1;
                zzpe.m29v("Failed loading new engine. Marking new engine destroyable.");
                this.zzJr.zzgy();
            }
        }
    }

    static class zza {
        static int zzJs;
        static int zzJt;

        static {
            zzJs = 60000;
            zzJt = 10000;
        }
    }

    public static class zzb<T> implements zzpn<T> {
        public void zzd(T t) {
        }
    }

    public static class zzc extends zzqj<zzjb> {
        private final zzd zzJu;
        private boolean zzJv;
        private final Object zzrN;

        /* renamed from: com.google.android.gms.internal.zzja.zzc.1 */
        class C13681 implements com.google.android.gms.internal.zzqi.zzc<zzjb> {
            C13681(zzc com_google_android_gms_internal_zzja_zzc) {
            }

            public void zzb(zzjb com_google_android_gms_internal_zzjb) {
                zzpe.m29v("Ending javascript session.");
                ((zzjc) com_google_android_gms_internal_zzjb).zzgA();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.zzc.2 */
        class C13692 implements com.google.android.gms.internal.zzqi.zzc<zzjb> {
            final /* synthetic */ zzc zzJw;

            C13692(zzc com_google_android_gms_internal_zzja_zzc) {
                this.zzJw = com_google_android_gms_internal_zzja_zzc;
            }

            public void zzb(zzjb com_google_android_gms_internal_zzjb) {
                zzpe.m29v("Releasing engine reference.");
                this.zzJw.zzJu.zzgx();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.zzc.3 */
        class C13703 implements com.google.android.gms.internal.zzqi.zza {
            final /* synthetic */ zzc zzJw;

            C13703(zzc com_google_android_gms_internal_zzja_zzc) {
                this.zzJw = com_google_android_gms_internal_zzja_zzc;
            }

            public void run() {
                this.zzJw.zzJu.zzgx();
            }
        }

        public zzc(zzd com_google_android_gms_internal_zzja_zzd) {
            this.zzrN = new Object();
            this.zzJu = com_google_android_gms_internal_zzja_zzd;
        }

        public void release() {
            synchronized (this.zzrN) {
                if (this.zzJv) {
                    return;
                }
                this.zzJv = true;
                zza(new C13681(this), new com.google.android.gms.internal.zzqi.zzb());
                zza(new C13692(this), new C13703(this));
            }
        }
    }

    public static class zzd extends zzqj<zzix> {
        private zzpn<zzix> zzJf;
        private boolean zzJx;
        private int zzJy;
        private final Object zzrN;

        /* renamed from: com.google.android.gms.internal.zzja.zzd.1 */
        class C13711 implements com.google.android.gms.internal.zzqi.zzc<zzix> {
            final /* synthetic */ zzc zzJz;

            C13711(zzd com_google_android_gms_internal_zzja_zzd, zzc com_google_android_gms_internal_zzja_zzc) {
                this.zzJz = com_google_android_gms_internal_zzja_zzc;
            }

            public void zza(zzix com_google_android_gms_internal_zzix) {
                zzpe.m29v("Getting a new session for JS Engine.");
                this.zzJz.zzg(com_google_android_gms_internal_zzix.zzgt());
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzix) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.zzd.2 */
        class C13722 implements com.google.android.gms.internal.zzqi.zza {
            final /* synthetic */ zzc zzJz;

            C13722(zzd com_google_android_gms_internal_zzja_zzd, zzc com_google_android_gms_internal_zzja_zzc) {
                this.zzJz = com_google_android_gms_internal_zzja_zzc;
            }

            public void run() {
                zzpe.m29v("Rejecting reference for JS Engine.");
                this.zzJz.reject();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja.zzd.3 */
        class C13743 implements com.google.android.gms.internal.zzqi.zzc<zzix> {
            final /* synthetic */ zzd zzJA;

            /* renamed from: com.google.android.gms.internal.zzja.zzd.3.1 */
            class C13731 implements Runnable {
                final /* synthetic */ zzix zzJB;
                final /* synthetic */ C13743 zzJC;

                C13731(C13743 c13743, zzix com_google_android_gms_internal_zzix) {
                    this.zzJC = c13743;
                    this.zzJB = com_google_android_gms_internal_zzix;
                }

                public void run() {
                    this.zzJC.zzJA.zzJf.zzd(this.zzJB);
                    this.zzJB.destroy();
                }
            }

            C13743(zzd com_google_android_gms_internal_zzja_zzd) {
                this.zzJA = com_google_android_gms_internal_zzja_zzd;
            }

            public void zza(zzix com_google_android_gms_internal_zzix) {
                zzv.zzcJ().runOnUiThread(new C13731(this, com_google_android_gms_internal_zzix));
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzix) obj);
            }
        }

        public zzd(zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix) {
            this.zzrN = new Object();
            this.zzJf = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix;
            this.zzJx = false;
            this.zzJy = 0;
        }

        public zzc zzgw() {
            zzc com_google_android_gms_internal_zzja_zzc = new zzc(this);
            synchronized (this.zzrN) {
                zza(new C13711(this, com_google_android_gms_internal_zzja_zzc), new C13722(this, com_google_android_gms_internal_zzja_zzc));
                zzac.zzar(this.zzJy >= 0);
                this.zzJy++;
            }
            return com_google_android_gms_internal_zzja_zzc;
        }

        protected void zzgx() {
            boolean z = true;
            synchronized (this.zzrN) {
                if (this.zzJy < 1) {
                    z = false;
                }
                zzac.zzar(z);
                zzpe.m29v("Releasing 1 reference for JS Engine");
                this.zzJy--;
                zzgz();
            }
        }

        public void zzgy() {
            boolean z = true;
            synchronized (this.zzrN) {
                if (this.zzJy < 0) {
                    z = false;
                }
                zzac.zzar(z);
                zzpe.m29v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzJx = true;
                zzgz();
            }
        }

        protected void zzgz() {
            synchronized (this.zzrN) {
                zzac.zzar(this.zzJy >= 0);
                if (this.zzJx && this.zzJy == 0) {
                    zzpe.m29v("No reference is left (including root). Cleaning up engine.");
                    zza(new C13743(this), new com.google.android.gms.internal.zzqi.zzb());
                } else {
                    zzpe.m29v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public static class zze extends zzqj<zzjb> {
        private zzc zzJD;

        public zze(zzc com_google_android_gms_internal_zzja_zzc) {
            this.zzJD = com_google_android_gms_internal_zzja_zzc;
        }

        public void finalize() {
            this.zzJD.release();
            this.zzJD = null;
        }

        public int getStatus() {
            return this.zzJD.getStatus();
        }

        public void reject() {
            this.zzJD.reject();
        }

        public void zza(com.google.android.gms.internal.zzqi.zzc<zzjb> com_google_android_gms_internal_zzqi_zzc_com_google_android_gms_internal_zzjb, com.google.android.gms.internal.zzqi.zza com_google_android_gms_internal_zzqi_zza) {
            this.zzJD.zza(com_google_android_gms_internal_zzqi_zzc_com_google_android_gms_internal_zzjb, com_google_android_gms_internal_zzqi_zza);
        }

        public void zzf(zzjb com_google_android_gms_internal_zzjb) {
            this.zzJD.zzg(com_google_android_gms_internal_zzjb);
        }

        public /* synthetic */ void zzg(Object obj) {
            zzf((zzjb) obj);
        }
    }

    public zzja(Context context, zzqa com_google_android_gms_internal_zzqa, String str) {
        this.zzrN = new Object();
        this.zzJh = 1;
        this.zzJd = str;
        this.mContext = context.getApplicationContext();
        this.zztr = com_google_android_gms_internal_zzqa;
        this.zzJe = new zzb();
        this.zzJf = new zzb();
    }

    public zzja(Context context, zzqa com_google_android_gms_internal_zzqa, String str, zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix, zzpn<zzix> com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix2) {
        this(context, com_google_android_gms_internal_zzqa, str);
        this.zzJe = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix;
        this.zzJf = com_google_android_gms_internal_zzpn_com_google_android_gms_internal_zzix2;
    }

    private zzd zza(@Nullable zzav com_google_android_gms_internal_zzav) {
        zzd com_google_android_gms_internal_zzja_zzd = new zzd(this.zzJf);
        zzv.zzcJ().runOnUiThread(new C13651(this, com_google_android_gms_internal_zzav, com_google_android_gms_internal_zzja_zzd));
        return com_google_android_gms_internal_zzja_zzd;
    }

    protected zzix zza(Context context, zzqa com_google_android_gms_internal_zzqa, @Nullable zzav com_google_android_gms_internal_zzav) {
        return new zziz(context, com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzav, null);
    }

    protected zzd zzb(@Nullable zzav com_google_android_gms_internal_zzav) {
        zzd zza = zza(com_google_android_gms_internal_zzav);
        zza.zza(new C13662(this, zza), new C13673(this, zza));
        return zza;
    }

    public zzc zzc(@Nullable zzav com_google_android_gms_internal_zzav) {
        zzc zzgw;
        synchronized (this.zzrN) {
            if (this.zzJg == null || this.zzJg.getStatus() == -1) {
                this.zzJh = 2;
                this.zzJg = zzb(com_google_android_gms_internal_zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 0) {
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 1) {
                this.zzJh = 2;
                zzb(com_google_android_gms_internal_zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 2) {
                zzgw = this.zzJg.zzgw();
            } else {
                zzgw = this.zzJg.zzgw();
            }
        }
        return zzgw;
    }

    public zzc zzgv() {
        return zzc(null);
    }
}
