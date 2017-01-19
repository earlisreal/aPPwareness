package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public class zzatu extends zzats {
    protected zza zzbtU;
    private zzb zzbtV;
    private final Set<zzc> zzbtW;
    private boolean zzbtX;
    private String zzbtY;
    private String zzbtZ;

    /* renamed from: com.google.android.gms.internal.zzatu.1 */
    class C09461 implements Runnable {
        final /* synthetic */ boolean zzahO;
        final /* synthetic */ zzatu zzbua;

        C09461(zzatu com_google_android_gms_internal_zzatu, boolean z) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzahO = z;
        }

        public void run() {
            this.zzbua.zzaH(this.zzahO);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatu.2 */
    class C09472 implements Runnable {
        final /* synthetic */ zzatu zzbua;
        final /* synthetic */ long zzbub;

        C09472(zzatu com_google_android_gms_internal_zzatu, long j) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzbub = j;
        }

        public void run() {
            this.zzbua.zzJu().zzbsp.set(this.zzbub);
            this.zzbua.zzJt().zzLf().zzj("Minimum session duration set", Long.valueOf(this.zzbub));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatu.3 */
    class C09483 implements Runnable {
        final /* synthetic */ zzatu zzbua;
        final /* synthetic */ long zzbub;

        C09483(zzatu com_google_android_gms_internal_zzatu, long j) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzbub = j;
        }

        public void run() {
            this.zzbua.zzJu().zzbsq.set(this.zzbub);
            this.zzbua.zzJt().zzLf().zzj("Session timeout duration set", Long.valueOf(this.zzbub));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatu.4 */
    class C09494 implements Runnable {
        final /* synthetic */ String val$name;
        final /* synthetic */ String zzbky;
        final /* synthetic */ zzatu zzbua;
        final /* synthetic */ String zzbuc;
        final /* synthetic */ long zzbud;
        final /* synthetic */ Bundle zzbue;
        final /* synthetic */ boolean zzbuf;
        final /* synthetic */ boolean zzbug;
        final /* synthetic */ boolean zzbuh;

        C09494(zzatu com_google_android_gms_internal_zzatu, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzbuc = str;
            this.val$name = str2;
            this.zzbud = j;
            this.zzbue = bundle;
            this.zzbuf = z;
            this.zzbug = z2;
            this.zzbuh = z3;
            this.zzbky = str3;
        }

        public void run() {
            this.zzbua.zzb(this.zzbuc, this.val$name, this.zzbud, this.zzbue, this.zzbuf, this.zzbug, this.zzbuh, this.zzbky);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatu.5 */
    class C09505 implements Runnable {
        final /* synthetic */ String val$name;
        final /* synthetic */ zzatu zzbua;
        final /* synthetic */ String zzbuc;
        final /* synthetic */ long zzbud;
        final /* synthetic */ Object zzbui;

        C09505(zzatu com_google_android_gms_internal_zzatu, String str, String str2, Object obj, long j) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzbuc = str;
            this.val$name = str2;
            this.zzbui = obj;
            this.zzbud = j;
        }

        public void run() {
            this.zzbua.zza(this.zzbuc, this.val$name, this.zzbui, this.zzbud);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatu.6 */
    class C09516 implements Runnable {
        final /* synthetic */ zzatu zzbua;
        final /* synthetic */ AtomicReference zzbuj;
        final /* synthetic */ boolean zzbuk;

        C09516(zzatu com_google_android_gms_internal_zzatu, AtomicReference atomicReference, boolean z) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzbuj = atomicReference;
            this.zzbuk = z;
        }

        public void run() {
            this.zzbua.zzJl().zza(this.zzbuj, this.zzbuk);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatu.7 */
    class C09527 implements Runnable {
        final /* synthetic */ zzatu zzbua;
        final /* synthetic */ AtomicReference zzbuj;

        C09527(zzatu com_google_android_gms_internal_zzatu, AtomicReference atomicReference) {
            this.zzbua = com_google_android_gms_internal_zzatu;
            this.zzbuj = atomicReference;
        }

        public void run() {
            this.zzbua.zzJl().zza(this.zzbuj);
        }
    }

    @MainThread
    @TargetApi(14)
    private class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzatu zzbua;

        private zza(zzatu com_google_android_gms_internal_zzatu) {
            this.zzbua = com_google_android_gms_internal_zzatu;
        }

        private boolean zzfT(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.zzbua.zzd("auto", "_ldl", str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.zzbua.zzJt().zzLg().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            Bundle zzu = this.zzbua.zzJp().zzu(data);
                            String str = this.zzbua.zzJp().zzD(intent) ? "gs" : "auto";
                            if (zzu != null) {
                                this.zzbua.zze(str, "_cmp", zzu);
                            }
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                            if (obj == null) {
                                this.zzbua.zzJt().zzLf().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                                return;
                            } else {
                                this.zzbua.zzJt().zzLf().zzj("Activity created with referrer", queryParameter);
                                zzfT(queryParameter);
                            }
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                this.zzbua.zzJt().zzLa().zzj("Throwable caught in onActivityCreated", th);
            }
            this.zzbua.zzJm().onActivityCreated(activity, bundle);
        }

        public void onActivityDestroyed(Activity activity) {
            this.zzbua.zzJm().onActivityDestroyed(activity);
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            this.zzbua.zzJm().onActivityPaused(activity);
            this.zzbua.zzJr().zzMe();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            this.zzbua.zzJm().onActivityResumed(activity);
            this.zzbua.zzJr().zzMc();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            this.zzbua.zzJm().onActivitySaveInstanceState(activity, bundle);
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzatu(zzatp com_google_android_gms_internal_zzatp) {
        super(com_google_android_gms_internal_zzatp);
        this.zzbtW = new CopyOnWriteArraySet();
        this.zzbtY = null;
        this.zzbtZ = null;
    }

    @WorkerThread
    private void zzLS() {
        try {
            zzf(Class.forName(zzLT()));
        } catch (ClassNotFoundException e) {
            zzJt().zzLe().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzLT() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zznq().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    @WorkerThread
    private void zza(String str, String str2, Object obj, long j) {
        zzac.zzdv(str);
        zzac.zzdv(str2);
        zzmq();
        zzJe();
        zznA();
        if (!this.zzbpw.isEnabled()) {
            zzJt().zzLf().log("User property not set since app measurement is disabled");
        } else if (this.zzbpw.zzLt()) {
            zzJt().zzLf().zze("Setting user property (FE)", str2, obj);
            zzJl().zzb(new zzaub(str2, j, obj, str));
        }
    }

    @WorkerThread
    private void zzaH(boolean z) {
        zzmq();
        zzJe();
        zznA();
        zzJt().zzLf().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzJu().setMeasurementEnabled(z);
        zzJl().zzLW();
    }

    @WorkerThread
    private void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzac.zzdv(str);
        zzac.zzdv(str2);
        zzac.zzw(bundle);
        zzmq();
        zznA();
        if (this.zzbpw.isEnabled()) {
            if (!this.zzbtX) {
                this.zzbtX = true;
                zzLS();
            }
            boolean equals = "am".equals(str);
            boolean zzgg = zzaue.zzgg(str2);
            if (z && this.zzbtV != null && !zzgg && !equals) {
                zzJt().zzLf().zze("Passing event to registered event handler (FE)", str2, bundle);
                this.zzbtV.zzb(str, str2, bundle, j);
                return;
            } else if (this.zzbpw.zzLt()) {
                int zzfY = zzJp().zzfY(str2);
                if (zzfY != 0) {
                    this.zzbpw.zzJp().zza(zzfY, "_ev", zzJp().zza(str2, zzJv().zzJU(), true), str2 != null ? str2.length() : 0);
                    return;
                }
                bundle.putString("_o", str);
                Bundle zza = zzJp().zza(str2, bundle, zzf.zzx("_o"), z3);
                if (!bundle.containsKey("_sc")) {
                    zzJv().zzKk();
                    AppMeasurement.zzf zzLU = zzJm().zzLU();
                    if (zzLU != null) {
                        zzLU.zzbuy = true;
                    }
                    zzatv.zza(zzLU, zza);
                }
                Bundle zzN = z2 ? zzN(zza) : zza;
                zzJt().zzLf().zze("Logging event (FE)", str2, zzN);
                zzJl().zzc(new zzatb(str2, new zzasz(zzN), str, j), str3);
                if (!equals) {
                    for (zzc zzc : this.zzbtW) {
                        zzc.zzc(str, str2, new Bundle(zzN), j);
                    }
                    return;
                }
                return;
            } else {
                return;
            }
        }
        zzJt().zzLf().log("Event not sent since app measurement is disabled");
    }

    @Nullable
    public String getAppInstanceIdOnPackageSide(String str) {
        zzJd();
        return this.zzbpw.zzfR(str);
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Nullable
    public String getGmpAppIdOnPackageSide(String str) {
        zzJd();
        return this.zzbpw.getGmpAppIdOnPackageSide(str);
    }

    public void setMeasurementEnabled(boolean z) {
        zznA();
        zzJe();
        zzJs().zzm(new C09461(this, z));
    }

    public void setMinimumSessionDuration(long j) {
        zzJe();
        zzJs().zzm(new C09472(this, j));
    }

    public void setSessionTimeoutDuration(long j) {
        zzJe();
        zzJs().zzm(new C09483(this, j));
    }

    public /* bridge */ /* synthetic */ void zzJd() {
        super.zzJd();
    }

    public /* bridge */ /* synthetic */ void zzJe() {
        super.zzJe();
    }

    public /* bridge */ /* synthetic */ void zzJf() {
        super.zzJf();
    }

    public /* bridge */ /* synthetic */ zzaso zzJg() {
        return super.zzJg();
    }

    public /* bridge */ /* synthetic */ zzass zzJh() {
        return super.zzJh();
    }

    public /* bridge */ /* synthetic */ zzatu zzJi() {
        return super.zzJi();
    }

    public /* bridge */ /* synthetic */ zzatf zzJj() {
        return super.zzJj();
    }

    public /* bridge */ /* synthetic */ zzasw zzJk() {
        return super.zzJk();
    }

    public /* bridge */ /* synthetic */ zzatw zzJl() {
        return super.zzJl();
    }

    public /* bridge */ /* synthetic */ zzatv zzJm() {
        return super.zzJm();
    }

    public /* bridge */ /* synthetic */ zzatg zzJn() {
        return super.zzJn();
    }

    public /* bridge */ /* synthetic */ zzasu zzJo() {
        return super.zzJo();
    }

    public /* bridge */ /* synthetic */ zzaue zzJp() {
        return super.zzJp();
    }

    public /* bridge */ /* synthetic */ zzatn zzJq() {
        return super.zzJq();
    }

    public /* bridge */ /* synthetic */ zzaty zzJr() {
        return super.zzJr();
    }

    public /* bridge */ /* synthetic */ zzato zzJs() {
        return super.zzJs();
    }

    public /* bridge */ /* synthetic */ zzati zzJt() {
        return super.zzJt();
    }

    public /* bridge */ /* synthetic */ zzatl zzJu() {
        return super.zzJu();
    }

    public /* bridge */ /* synthetic */ zzast zzJv() {
        return super.zzJv();
    }

    @TargetApi(14)
    public void zzLQ() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzbtU == null) {
                this.zzbtU = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzbtU);
            application.registerActivityLifecycleCallbacks(this.zzbtU);
            zzJt().zzLg().log("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzLR() {
        zzmq();
        zzJe();
        zznA();
        if (this.zzbpw.zzLt()) {
            zzJl().zzLR();
            String zzLp = zzJu().zzLp();
            if (!TextUtils.isEmpty(zzLp) && !zzLp.equals(zzJk().zzKU())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzLp);
                zze("auto", "_ou", bundle);
            }
        }
    }

    Bundle zzN(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzJp().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzJt().zzLc().zzj("Param value can't be null", str);
                } else {
                    zzJp().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
    }

    @WorkerThread
    public void zza(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        zzmq();
        zzJe();
        zznA();
        if (!(com_google_android_gms_measurement_AppMeasurement_zzb == null || com_google_android_gms_measurement_AppMeasurement_zzb == this.zzbtV)) {
            zzac.zza(this.zzbtV == null, (Object) "EventInterceptor already set.");
        }
        this.zzbtV = com_google_android_gms_measurement_AppMeasurement_zzb;
    }

    public void zza(zzc com_google_android_gms_measurement_AppMeasurement_zzc) {
        zzJe();
        zznA();
        zzac.zzw(com_google_android_gms_measurement_AppMeasurement_zzc);
        if (!this.zzbtW.add(com_google_android_gms_measurement_AppMeasurement_zzc)) {
            zzJt().zzLc().log("OnEventListener already registered");
        }
    }

    protected void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzJs().zzm(new C09494(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    void zza(String str, String str2, long j, Object obj) {
        zzJs().zzm(new C09505(this, str, str2, obj, j));
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzJe();
        boolean z2 = this.zzbtV == null || zzaue.zzgg(str2);
        zza(str, str2, bundle, true, z2, z, null);
    }

    public List<zzaub> zzaI(boolean z) {
        zzJe();
        zznA();
        zzJt().zzLf().log("Fetching user attributes (FE)");
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzbpw.zzJs().zzm(new C09516(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzJt().zzLc().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<zzaub> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzJt().zzLc().log("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzJe();
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public void zzd(String str, String str2, Object obj) {
        int i = 0;
        zzac.zzdv(str);
        long currentTimeMillis = zznq().currentTimeMillis();
        int zzga = zzJp().zzga(str2);
        String zza;
        if (zzga != 0) {
            zza = zzJp().zza(str2, zzJv().zzJV(), true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzbpw.zzJp().zza(zzga, "_ev", zza, i);
        } else if (obj != null) {
            zzga = zzJp().zzm(str2, obj);
            if (zzga != 0) {
                zza = zzJp().zza(str2, zzJv().zzJV(), true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzbpw.zzJp().zza(zzga, "_ev", zza, i);
                return;
            }
            Object zzn = zzJp().zzn(str2, obj);
            if (zzn != null) {
                zza(str, str2, currentTimeMillis, zzn);
            }
        } else {
            zza(str, str2, currentTimeMillis, null);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzJe();
        boolean z = this.zzbtV == null || zzaue.zzgg(str2);
        zza(str, str2, bundle, true, z, false, null);
    }

    @WorkerThread
    public void zzf(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzJt().zzLc().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    @Nullable
    @WorkerThread
    public synchronized String zzfS(String str) {
        String str2 = null;
        synchronized (this) {
            zznA();
            zzJe();
            if (zzJs().zzLr()) {
                zzJt().zzLa().log("Cannot retrieve app instance id from analytics worker thread");
            } else if (zzJs().zzbd()) {
                zzJt().zzLa().log("Cannot retrieve app instance id from main thread");
            } else {
                if (str != null) {
                    if (str.equals(this.zzbtZ)) {
                        str2 = this.zzbtY;
                    }
                }
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzbpw.zzJs().zzm(new C09527(this, atomicReference));
                    try {
                        atomicReference.wait(NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
                    } catch (InterruptedException e) {
                        zzJt().zzLc().log("Interrupted waiting for app instance id");
                    }
                }
                this.zzbtZ = str;
                this.zzbtY = (String) atomicReference.get();
                str2 = this.zzbtY;
            }
        }
        return str2;
    }

    public /* bridge */ /* synthetic */ void zzmq() {
        super.zzmq();
    }

    protected void zzmr() {
    }

    public /* bridge */ /* synthetic */ zze zznq() {
        return super.zznq();
    }
}
