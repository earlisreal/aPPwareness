package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

class zzcw implements ActivityLifecycleCallbacks {
    private final Application zzwI;
    private final WeakReference<ActivityLifecycleCallbacks> zzxc;

    public interface zza {
        void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks);
    }

    /* renamed from: com.google.android.gms.internal.zzcw.1 */
    class C12591 implements zza {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Bundle zzxd;

        C12591(zzcw com_google_android_gms_internal_zzcw, Activity activity, Bundle bundle) {
            this.val$activity = activity;
            this.zzxd = bundle;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzxd);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.2 */
    class C12602 implements zza {
        final /* synthetic */ Activity val$activity;

        C12602(zzcw com_google_android_gms_internal_zzcw, Activity activity) {
            this.val$activity = activity;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityStarted(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.3 */
    class C12613 implements zza {
        final /* synthetic */ Activity val$activity;

        C12613(zzcw com_google_android_gms_internal_zzcw, Activity activity) {
            this.val$activity = activity;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityResumed(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.4 */
    class C12624 implements zza {
        final /* synthetic */ Activity val$activity;

        C12624(zzcw com_google_android_gms_internal_zzcw, Activity activity) {
            this.val$activity = activity;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityPaused(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.5 */
    class C12635 implements zza {
        final /* synthetic */ Activity val$activity;

        C12635(zzcw com_google_android_gms_internal_zzcw, Activity activity) {
            this.val$activity = activity;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityStopped(this.val$activity);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.6 */
    class C12646 implements zza {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Bundle zzxd;

        C12646(zzcw com_google_android_gms_internal_zzcw, Activity activity, Bundle bundle) {
            this.val$activity = activity;
            this.zzxd = bundle;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzxd);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcw.7 */
    class C12657 implements zza {
        final /* synthetic */ Activity val$activity;

        C12657(zzcw com_google_android_gms_internal_zzcw, Activity activity) {
            this.val$activity = activity;
        }

        public void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
        }
    }

    public zzcw(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxc = new WeakReference(activityLifecycleCallbacks);
        this.zzwI = application;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new C12591(this, activity, bundle));
    }

    public void onActivityDestroyed(Activity activity) {
        zza(new C12657(this, activity));
    }

    public void onActivityPaused(Activity activity) {
        zza(new C12624(this, activity));
    }

    public void onActivityResumed(Activity activity) {
        zza(new C12613(this, activity));
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new C12646(this, activity, bundle));
    }

    public void onActivityStarted(Activity activity) {
        zza(new C12602(this, activity));
    }

    public void onActivityStopped(Activity activity) {
        zza(new C12635(this, activity));
    }

    protected void zza(zza com_google_android_gms_internal_zzcw_zza) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.zzxc.get();
            if (activityLifecycleCallbacks != null) {
                com_google_android_gms_internal_zzcw_zza.zza(activityLifecycleCallbacks);
            } else {
                this.zzwI.unregisterActivityLifecycleCallbacks(this);
            }
        } catch (Throwable e) {
            zzpy.zzb("Error while dispatching lifecycle callback.", e);
        }
    }
}
