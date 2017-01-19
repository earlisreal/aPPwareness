package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja.zzc;
import com.google.android.gms.internal.zzqi.zza;
import com.google.android.gms.internal.zzqi.zzb;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzct implements zzcu {
    private final zzhx zzwA;
    private final zzhx zzwB;
    private zzc zzwD;
    private boolean zzwE;
    private final zzcq zzwx;
    private final zzhx zzwz;

    /* renamed from: com.google.android.gms.internal.zzct.1 */
    class C12501 implements zzqi.zzc<zzjb> {
        final /* synthetic */ zzct zzwF;

        C12501(zzct com_google_android_gms_internal_zzct) {
            this.zzwF = com_google_android_gms_internal_zzct;
        }

        public void zzb(zzjb com_google_android_gms_internal_zzjb) {
            this.zzwF.zzwE = true;
            this.zzwF.zzc(com_google_android_gms_internal_zzjb);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjb) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct.2 */
    class C12512 implements zza {
        final /* synthetic */ zzct zzwF;

        C12512(zzct com_google_android_gms_internal_zzct) {
            this.zzwF = com_google_android_gms_internal_zzct;
        }

        public void run() {
            this.zzwF.zzwx.zzb(this.zzwF);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct.3 */
    class C12523 implements zzqi.zzc<zzjb> {
        final /* synthetic */ JSONObject zzwG;

        C12523(zzct com_google_android_gms_internal_zzct, JSONObject jSONObject) {
            this.zzwG = jSONObject;
        }

        public void zzb(zzjb com_google_android_gms_internal_zzjb) {
            com_google_android_gms_internal_zzjb.zza("AFMA_updateActiveView", this.zzwG);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjb) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct.4 */
    class C12534 implements zzqi.zzc<zzjb> {
        final /* synthetic */ zzct zzwF;

        C12534(zzct com_google_android_gms_internal_zzct) {
            this.zzwF = com_google_android_gms_internal_zzct;
        }

        public void zzb(zzjb com_google_android_gms_internal_zzjb) {
            this.zzwF.zzd(com_google_android_gms_internal_zzjb);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjb) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct.5 */
    class C12545 implements zzhx {
        final /* synthetic */ zzct zzwF;

        C12545(zzct com_google_android_gms_internal_zzct) {
            this.zzwF = com_google_android_gms_internal_zzct;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            if (this.zzwF.zzwx.zzb((Map) map)) {
                this.zzwF.zzwx.zzb(com_google_android_gms_internal_zzqp, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct.6 */
    class C12556 implements zzhx {
        final /* synthetic */ zzct zzwF;

        C12556(zzct com_google_android_gms_internal_zzct) {
            this.zzwF = com_google_android_gms_internal_zzct;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            if (this.zzwF.zzwx.zzb((Map) map)) {
                this.zzwF.zzwx.zza(this.zzwF, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct.7 */
    class C12567 implements zzhx {
        final /* synthetic */ zzct zzwF;

        C12567(zzct com_google_android_gms_internal_zzct) {
            this.zzwF = com_google_android_gms_internal_zzct;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            if (this.zzwF.zzwx.zzb((Map) map)) {
                this.zzwF.zzwx.zzc(map);
            }
        }
    }

    public zzct(zzcq com_google_android_gms_internal_zzcq, zzja com_google_android_gms_internal_zzja) {
        this.zzwz = new C12545(this);
        this.zzwA = new C12556(this);
        this.zzwB = new C12567(this);
        this.zzwx = com_google_android_gms_internal_zzcq;
        this.zzwD = com_google_android_gms_internal_zzja.zzgv();
        this.zzwD.zza(new C12501(this), new C12512(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwx.zzdN().zzdy());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjb com_google_android_gms_internal_zzjb) {
        com_google_android_gms_internal_zzjb.zza("/updateActiveView", this.zzwz);
        com_google_android_gms_internal_zzjb.zza("/untrackActiveViewUnit", this.zzwA);
        com_google_android_gms_internal_zzjb.zza("/visibilityChanged", this.zzwB);
    }

    public void zzc(JSONObject jSONObject, boolean z) {
        this.zzwD.zza(new C12523(this, jSONObject), new zzb());
    }

    void zzd(zzjb com_google_android_gms_internal_zzjb) {
        com_google_android_gms_internal_zzjb.zzb("/visibilityChanged", this.zzwB);
        com_google_android_gms_internal_zzjb.zzb("/untrackActiveViewUnit", this.zzwA);
        com_google_android_gms_internal_zzjb.zzb("/updateActiveView", this.zzwz);
    }

    public boolean zzdR() {
        return this.zzwE;
    }

    public void zzdS() {
        this.zzwD.zza(new C12534(this), new zzb());
        this.zzwD.release();
    }
}
