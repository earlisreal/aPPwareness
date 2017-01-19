package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import com.google.firebase.crash.FirebaseCrash;

public class zzbkn {
    private final Context mContext;
    private boolean zzbWZ;
    private AppMeasurement zzbXa;
    final zzc zzbXb;

    /* renamed from: com.google.android.gms.internal.zzbkn.1 */
    class C10801 implements zzc {
        C10801(zzbkn com_google_android_gms_internal_zzbkn) {
        }

        public void zzc(String str, String str2, Bundle bundle, long j) {
            if (!str.equals("crash")) {
                FirebaseCrash.zza(str2, j, bundle);
            }
        }
    }

    public zzbkn(Context context) {
        this.zzbWZ = false;
        this.zzbXa = null;
        this.zzbXb = new C10801(this);
        this.mContext = context;
        try {
            this.zzbXa = AppMeasurement.getInstance(this.mContext);
        } catch (NoClassDefFoundError e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseCrashAnalytics", new StringBuilder(String.valueOf(valueOf).length() + 50).append("Unable to log event, missing measurement library: ").append(valueOf).toString());
        }
    }

    private void zzS(Bundle bundle) {
        if (this.zzbXa != null) {
            this.zzbXa.logEventInternal("crash", "_ae", bundle);
        }
    }

    public void zzUR() {
        try {
            if (!this.zzbWZ && this.zzbXa != null) {
                this.zzbXa.zza(this.zzbXb);
                this.zzbWZ = true;
            }
        } catch (IllegalStateException e) {
            Log.d("FirebaseCrashAnalytics", "Firebase Analytics breadcrumbs is not supported");
        }
    }

    public void zza(boolean z, long j) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("fatal", 1);
        } else {
            bundle.putInt("fatal", 0);
        }
        bundle.putLong("timestamp", j);
        zzS(bundle);
    }
}
