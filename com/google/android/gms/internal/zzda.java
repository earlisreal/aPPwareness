package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzs;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzda {
    private final Object zzxv;
    private zza zzxw;
    private boolean zzxx;

    @TargetApi(14)
    static class zza implements ActivityLifecycleCallbacks {
        @Nullable
        private Activity mActivity;
        private Context mContext;
        private List<zzb> mListeners;
        private final Object zzrN;
        private boolean zztW;
        private Runnable zzxA;
        private long zzxB;
        private boolean zzxy;
        private boolean zzxz;

        /* renamed from: com.google.android.gms.internal.zzda.zza.1 */
        class C12661 implements Runnable {
            final /* synthetic */ zza zzxC;

            C12661(zza com_google_android_gms_internal_zzda_zza) {
                this.zzxC = com_google_android_gms_internal_zzda_zza;
            }

            public void run() {
                synchronized (this.zzxC.zzrN) {
                    if (this.zzxC.zzxy && this.zzxC.zzxz) {
                        this.zzxC.zzxy = false;
                        zzpy.zzbc("App went background");
                        for (zzb zzk : this.zzxC.mListeners) {
                            try {
                                zzk.zzk(false);
                            } catch (Throwable e) {
                                zzpy.zzb("OnForegroundStateChangedListener threw exception.", e);
                            }
                        }
                    } else {
                        zzpy.zzbc("App is still foreground");
                    }
                }
            }
        }

        zza() {
            this.zzrN = new Object();
            this.zzxy = true;
            this.zzxz = false;
            this.mListeners = new ArrayList();
            this.zztW = false;
        }

        private void setActivity(Activity activity) {
            synchronized (this.zzrN) {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.mActivity = activity;
                }
            }
        }

        @Nullable
        public Activity getActivity() {
            return this.mActivity;
        }

        @Nullable
        public Context getContext() {
            return this.mContext;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            synchronized (this.zzrN) {
                if (this.mActivity == null) {
                    return;
                }
                if (this.mActivity.equals(activity)) {
                    this.mActivity = null;
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            setActivity(activity);
            this.zzxz = true;
            if (this.zzxA != null) {
                zzpi.zzWR.removeCallbacks(this.zzxA);
            }
            Handler handler = zzpi.zzWR;
            Runnable c12661 = new C12661(this);
            this.zzxA = c12661;
            handler.postDelayed(c12661, this.zzxB);
        }

        public void onActivityResumed(Activity activity) {
            boolean z = false;
            setActivity(activity);
            this.zzxz = false;
            if (!this.zzxy) {
                z = true;
            }
            this.zzxy = true;
            if (this.zzxA != null) {
                zzpi.zzWR.removeCallbacks(this.zzxA);
            }
            synchronized (this.zzrN) {
                if (z) {
                    for (zzb zzk : this.mListeners) {
                        try {
                            zzk.zzk(true);
                        } catch (Throwable e) {
                            zzpy.zzb("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                } else {
                    zzpy.zzbc("App is still foreground.");
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            setActivity(activity);
        }

        public void onActivityStopped(Activity activity) {
        }

        public void zza(Application application, Context context) {
            if (!this.zztW) {
                application.registerActivityLifecycleCallbacks(this);
                if (context instanceof Activity) {
                    setActivity((Activity) context);
                }
                this.mContext = context;
                this.zzxB = ((Long) zzfx.zzCu.get()).longValue();
                this.zztW = true;
            }
        }

        public void zza(zzb com_google_android_gms_internal_zzda_zzb) {
            this.mListeners.add(com_google_android_gms_internal_zzda_zzb);
        }
    }

    public interface zzb {
        void zzk(boolean z);
    }

    public zzda() {
        this.zzxv = new Object();
        this.zzxw = null;
        this.zzxx = false;
    }

    @Nullable
    public Activity getActivity() {
        Activity activity = null;
        synchronized (this.zzxv) {
            if (!zzs.zzyA()) {
            } else if (this.zzxw != null) {
                activity = this.zzxw.getActivity();
            }
        }
        return activity;
    }

    @Nullable
    public Context getContext() {
        Context context = null;
        synchronized (this.zzxv) {
            if (!zzs.zzyA()) {
            } else if (this.zzxw != null) {
                context = this.zzxw.getContext();
            }
        }
        return context;
    }

    public void initialize(Context context) {
        synchronized (this.zzxv) {
            if (!this.zzxx) {
                if (!zzs.zzyA()) {
                    return;
                } else if (((Boolean) zzfx.zzCt.get()).booleanValue()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        zzpy.zzbe("Can not cast Context to Application");
                        return;
                    }
                    if (this.zzxw == null) {
                        this.zzxw = new zza();
                    }
                    this.zzxw.zza(application, context);
                    this.zzxx = true;
                } else {
                    return;
                }
            }
        }
    }

    public void zza(zzb com_google_android_gms_internal_zzda_zzb) {
        synchronized (this.zzxv) {
            if (!zzs.zzyA()) {
            } else if (((Boolean) zzfx.zzCt.get()).booleanValue()) {
                if (this.zzxw == null) {
                    this.zzxw = new zza();
                }
                this.zzxw.zza(com_google_android_gms_internal_zzda_zzb);
            }
        }
    }
}
