package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzrs extends zzru {
    private final zzsc zzacF;

    /* renamed from: com.google.android.gms.internal.zzrs.1 */
    class C15031 implements Runnable {
        final /* synthetic */ int zzacG;
        final /* synthetic */ zzrs zzacH;

        C15031(zzrs com_google_android_gms_internal_zzrs, int i) {
            this.zzacH = com_google_android_gms_internal_zzrs;
            this.zzacG = i;
        }

        public void run() {
            this.zzacH.zzacF.zzw(((long) this.zzacG) * 1000);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrs.2 */
    class C15042 implements Runnable {
        final /* synthetic */ zzrs zzacH;
        final /* synthetic */ boolean zzacI;

        C15042(zzrs com_google_android_gms_internal_zzrs, boolean z) {
            this.zzacH = com_google_android_gms_internal_zzrs;
            this.zzacI = z;
        }

        public void run() {
            this.zzacH.zzacF.zzV(this.zzacI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrs.3 */
    class C15053 implements Runnable {
        final /* synthetic */ zzrs zzacH;
        final /* synthetic */ String zzacJ;
        final /* synthetic */ Runnable zzacK;

        C15053(zzrs com_google_android_gms_internal_zzrs, String str, Runnable runnable) {
            this.zzacH = com_google_android_gms_internal_zzrs;
            this.zzacJ = str;
            this.zzacK = runnable;
        }

        public void run() {
            this.zzacH.zzacF.zzbW(this.zzacJ);
            if (this.zzacK != null) {
                this.zzacK.run();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrs.4 */
    class C15064 implements Runnable {
        final /* synthetic */ zzrs zzacH;
        final /* synthetic */ zzst zzacL;

        C15064(zzrs com_google_android_gms_internal_zzrs, zzst com_google_android_gms_internal_zzst) {
            this.zzacH = com_google_android_gms_internal_zzrs;
            this.zzacL = com_google_android_gms_internal_zzst;
        }

        public void run() {
            this.zzacH.zzacF.zza(this.zzacL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrs.5 */
    class C15075 implements Runnable {
        final /* synthetic */ zzrs zzacH;

        C15075(zzrs com_google_android_gms_internal_zzrs) {
            this.zzacH = com_google_android_gms_internal_zzrs;
        }

        public void run() {
            this.zzacH.zzacF.zznj();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrs.6 */
    class C15086 implements Runnable {
        final /* synthetic */ zzrs zzacH;
        final /* synthetic */ zzso zzacM;

        C15086(zzrs com_google_android_gms_internal_zzrs, zzso com_google_android_gms_internal_zzso) {
            this.zzacH = com_google_android_gms_internal_zzrs;
            this.zzacM = com_google_android_gms_internal_zzso;
        }

        public void run() {
            this.zzacH.zzacF.zzb(this.zzacM);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrs.7 */
    class C15097 implements Callable<Void> {
        final /* synthetic */ zzrs zzacH;

        C15097(zzrs com_google_android_gms_internal_zzrs) {
            this.zzacH = com_google_android_gms_internal_zzrs;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbl();
        }

        public Void zzbl() throws Exception {
            this.zzacH.zzacF.zzof();
            return null;
        }
    }

    public zzrs(zzrw com_google_android_gms_internal_zzrw, zzrx com_google_android_gms_internal_zzrx) {
        super(com_google_android_gms_internal_zzrw);
        zzac.zzw(com_google_android_gms_internal_zzrx);
        this.zzacF = com_google_android_gms_internal_zzrx.zzj(com_google_android_gms_internal_zzrw);
    }

    void onServiceConnected() {
        zzmq();
        this.zzacF.onServiceConnected();
    }

    public void setLocalDispatchPeriod(int i) {
        zznA();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zznt().zzg(new C15031(this, i));
    }

    public void start() {
        this.zzacF.start();
    }

    public void zzV(boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zznt().zzg(new C15042(this, z));
    }

    public long zza(zzry com_google_android_gms_internal_zzry) {
        zznA();
        zzac.zzw(com_google_android_gms_internal_zzry);
        zzmq();
        long zza = this.zzacF.zza(com_google_android_gms_internal_zzry, true);
        if (zza == 0) {
            this.zzacF.zzc(com_google_android_gms_internal_zzry);
        }
        return zza;
    }

    public void zza(zzso com_google_android_gms_internal_zzso) {
        zznA();
        zznt().zzg(new C15086(this, com_google_android_gms_internal_zzso));
    }

    public void zza(zzst com_google_android_gms_internal_zzst) {
        zzac.zzw(com_google_android_gms_internal_zzst);
        zznA();
        zzb("Hit delivery requested", com_google_android_gms_internal_zzst);
        zznt().zzg(new C15064(this, com_google_android_gms_internal_zzst));
    }

    public void zza(String str, Runnable runnable) {
        zzac.zzh(str, "campaign param can't be empty");
        zznt().zzg(new C15053(this, str, runnable));
    }

    protected void zzmr() {
        this.zzacF.initialize();
    }

    public void zznj() {
        zznA();
        zznt().zzg(new C15075(this));
    }

    public void zznk() {
        zznA();
        Context context = getContext();
        if (zztb.zzT(context) && zztc.zzU(context)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            context.startService(intent);
            return;
        }
        zza(null);
    }

    public boolean zznl() {
        zznA();
        try {
            zznt().zzc(new C15097(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void zznm() {
        zznA();
        zzh.zzmq();
        this.zzacF.zznm();
    }

    public void zznn() {
        zzbO("Radio powered up");
        zznk();
    }

    void zzno() {
        zzmq();
        this.zzacF.zzno();
    }
}
