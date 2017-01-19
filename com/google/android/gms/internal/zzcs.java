package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzcs implements zzcu {
    private final zzhx zzwA;
    private final zzhx zzwB;
    private final zzcq zzwx;
    private final zzjb zzwy;
    private final zzhx zzwz;

    /* renamed from: com.google.android.gms.internal.zzcs.1 */
    class C12471 implements zzhx {
        final /* synthetic */ zzcs zzwC;

        C12471(zzcs com_google_android_gms_internal_zzcs) {
            this.zzwC = com_google_android_gms_internal_zzcs;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            this.zzwC.zzwx.zzb(com_google_android_gms_internal_zzqp, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcs.2 */
    class C12482 implements zzhx {
        final /* synthetic */ zzcs zzwC;

        C12482(zzcs com_google_android_gms_internal_zzcs) {
            this.zzwC = com_google_android_gms_internal_zzcs;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            this.zzwC.zzwx.zza(this.zzwC, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcs.3 */
    class C12493 implements zzhx {
        final /* synthetic */ zzcs zzwC;

        C12493(zzcs com_google_android_gms_internal_zzcs) {
            this.zzwC = com_google_android_gms_internal_zzcs;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            this.zzwC.zzwx.zzc(map);
        }
    }

    public zzcs(zzcq com_google_android_gms_internal_zzcq, zzjb com_google_android_gms_internal_zzjb) {
        this.zzwz = new C12471(this);
        this.zzwA = new C12482(this);
        this.zzwB = new C12493(this);
        this.zzwx = com_google_android_gms_internal_zzcq;
        this.zzwy = com_google_android_gms_internal_zzjb;
        zzc(this.zzwy);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwx.zzdN().zzdy());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjb com_google_android_gms_internal_zzjb) {
        com_google_android_gms_internal_zzjb.zza("/updateActiveView", this.zzwz);
        com_google_android_gms_internal_zzjb.zza("/untrackActiveViewUnit", this.zzwA);
        com_google_android_gms_internal_zzjb.zza("/visibilityChanged", this.zzwB);
    }

    public void zzc(JSONObject jSONObject, boolean z) {
        if (z) {
            this.zzwx.zzb((zzcu) this);
        } else {
            this.zzwy.zza("AFMA_updateActiveView", jSONObject);
        }
    }

    void zzd(zzjb com_google_android_gms_internal_zzjb) {
        com_google_android_gms_internal_zzjb.zzb("/visibilityChanged", this.zzwB);
        com_google_android_gms_internal_zzjb.zzb("/untrackActiveViewUnit", this.zzwA);
        com_google_android_gms_internal_zzjb.zzb("/updateActiveView", this.zzwz);
    }

    public boolean zzdR() {
        return true;
    }

    public void zzdS() {
        zzd(this.zzwy);
    }
}
