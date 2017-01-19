package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzqq.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzlv {
    private final Context mContext;
    private final zzr zzGl;
    private final zzav zzGr;
    private final zza zzPo;
    private OnGlobalLayoutListener zzQA;
    private OnScrollChangedListener zzQB;
    private final Object zzrN;
    private final zzgf zzsr;
    private int zzvI;
    private int zzvJ;
    private zzpt zzvK;

    /* renamed from: com.google.android.gms.internal.zzlv.1 */
    class C14201 implements Runnable {
        final /* synthetic */ JSONObject zzQC;
        final /* synthetic */ zzqc zzQD;
        final /* synthetic */ zzlv zzQE;

        /* renamed from: com.google.android.gms.internal.zzlv.1.1 */
        class C14181 implements zzb {
            final /* synthetic */ C14201 zzQF;
            final /* synthetic */ zzqp zztP;

            C14181(C14201 c14201, zzqp com_google_android_gms_internal_zzqp) {
                this.zzQF = c14201;
                this.zztP = com_google_android_gms_internal_zzqp;
            }

            public void zzk(zzqp com_google_android_gms_internal_zzqp) {
                this.zztP.zza("google.afma.nativeAds.renderVideo", this.zzQF.zzQC);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzlv.1.2 */
        class C14192 implements zzqq.zza {
            final /* synthetic */ C14201 zzQF;

            C14192(C14201 c14201) {
                this.zzQF = c14201;
            }

            public void zza(zzqp com_google_android_gms_internal_zzqp, boolean z) {
                this.zzQF.zzQE.zzGl.zzcu();
                this.zzQF.zzQD.zzh(com_google_android_gms_internal_zzqp);
            }
        }

        C14201(zzlv com_google_android_gms_internal_zzlv, JSONObject jSONObject, zzqc com_google_android_gms_internal_zzqc) {
            this.zzQE = com_google_android_gms_internal_zzlv;
            this.zzQC = jSONObject;
            this.zzQD = com_google_android_gms_internal_zzqc;
        }

        public void run() {
            try {
                zzqp zziU = this.zzQE.zziU();
                this.zzQE.zzGl.zzc(zziU);
                WeakReference weakReference = new WeakReference(zziU);
                zziU.zzkV().zza(this.zzQE.zza(weakReference), this.zzQE.zzb(weakReference));
                this.zzQE.zzj(zziU);
                zziU.zzkV().zza(new C14181(this, zziU));
                zziU.zzkV().zza(new C14192(this));
                zziU.loadUrl(zzlt.zza(this.zzQE.zzPo, (String) zzfx.zzDS.get()));
            } catch (Throwable e) {
                zzpy.zzc("Exception occurred while getting video view", e);
                this.zzQD.zzh(null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv.2 */
    class C14212 implements zzhx {
        final /* synthetic */ zzlv zzQE;

        C14212(zzlv com_google_android_gms_internal_zzlv) {
            this.zzQE = com_google_android_gms_internal_zzlv;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            this.zzQE.zzGl.zzcr();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv.3 */
    class C14223 implements OnGlobalLayoutListener {
        final /* synthetic */ zzlv zzQE;
        final /* synthetic */ WeakReference zzQG;

        C14223(zzlv com_google_android_gms_internal_zzlv, WeakReference weakReference) {
            this.zzQE = com_google_android_gms_internal_zzlv;
            this.zzQG = weakReference;
        }

        public void onGlobalLayout() {
            this.zzQE.zza(this.zzQG, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv.4 */
    class C14234 implements OnScrollChangedListener {
        final /* synthetic */ zzlv zzQE;
        final /* synthetic */ WeakReference zzQG;

        C14234(zzlv com_google_android_gms_internal_zzlv, WeakReference weakReference) {
            this.zzQE = com_google_android_gms_internal_zzlv;
            this.zzQG = weakReference;
        }

        public void onScrollChanged() {
            this.zzQE.zza(this.zzQG, true);
        }
    }

    public zzlv(Context context, zzav com_google_android_gms_internal_zzav, zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf, zzr com_google_android_gms_ads_internal_zzr) {
        this.zzrN = new Object();
        this.zzvI = -1;
        this.zzvJ = -1;
        this.mContext = context;
        this.zzGr = com_google_android_gms_internal_zzav;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzsr = com_google_android_gms_internal_zzgf;
        this.zzGl = com_google_android_gms_ads_internal_zzr;
        this.zzvK = new zzpt(200);
    }

    private OnGlobalLayoutListener zza(WeakReference<zzqp> weakReference) {
        if (this.zzQA == null) {
            this.zzQA = new C14223(this, weakReference);
        }
        return this.zzQA;
    }

    private void zza(WeakReference<zzqp> weakReference, boolean z) {
        if (weakReference != null) {
            zzqp com_google_android_gms_internal_zzqp = (zzqp) weakReference.get();
            if (com_google_android_gms_internal_zzqp != null && com_google_android_gms_internal_zzqp.getView() != null) {
                if (!z || this.zzvK.tryAcquire()) {
                    int[] iArr = new int[2];
                    com_google_android_gms_internal_zzqp.getView().getLocationOnScreen(iArr);
                    int zzc = zzeh.zzeO().zzc(this.mContext, iArr[0]);
                    int zzc2 = zzeh.zzeO().zzc(this.mContext, iArr[1]);
                    synchronized (this.zzrN) {
                        if (!(this.zzvI == zzc && this.zzvJ == zzc2)) {
                            this.zzvI = zzc;
                            this.zzvJ = zzc2;
                            com_google_android_gms_internal_zzqp.zzkV().zza(this.zzvI, this.zzvJ, !z);
                        }
                    }
                }
            }
        }
    }

    private OnScrollChangedListener zzb(WeakReference<zzqp> weakReference) {
        if (this.zzQB == null) {
            this.zzQB = new C14234(this, weakReference);
        }
        return this.zzQB;
    }

    private void zzj(zzqp com_google_android_gms_internal_zzqp) {
        zzqq zzkV = com_google_android_gms_internal_zzqp.zzkV();
        zzkV.zza("/video", zzhw.zzHq);
        zzkV.zza("/videoMeta", zzhw.zzHr);
        zzkV.zza("/precache", zzhw.zzHs);
        zzkV.zza("/delayPageLoaded", zzhw.zzHv);
        zzkV.zza("/instrument", zzhw.zzHt);
        zzkV.zza("/log", zzhw.zzHl);
        zzkV.zza("/videoClicked", zzhw.zzHm);
        zzkV.zza("/trackActiveViewUnit", new C14212(this));
    }

    public zzqf<zzqp> zzf(JSONObject jSONObject) {
        zzqf com_google_android_gms_internal_zzqc = new zzqc();
        zzv.zzcJ().runOnUiThread(new C14201(this, jSONObject, com_google_android_gms_internal_zzqc));
        return com_google_android_gms_internal_zzqc;
    }

    zzqp zziU() {
        return zzv.zzcK().zza(this.mContext, zzec.zzj(this.mContext), false, false, this.zzGr, this.zzPo.zzSF.zzvf, this.zzsr, null, this.zzGl.zzbz());
    }
}
