package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.internal.zzbly.zza;
import com.google.android.gms.internal.zzbly.zzb;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import java.util.concurrent.ScheduledExecutorService;

public class zzbkv implements zzbly {
    private final ScheduledExecutorService zzbYl;
    private final FirebaseApp zzbYm;

    /* renamed from: com.google.android.gms.internal.zzbkv.1 */
    class C10821 implements OnFailureListener {
        final /* synthetic */ zza zzbYn;

        C10821(zzbkv com_google_android_gms_internal_zzbkv, zza com_google_android_gms_internal_zzbly_zza) {
            this.zzbYn = com_google_android_gms_internal_zzbly_zza;
        }

        private boolean zza(Exception exception) {
            return (exception instanceof FirebaseApiNotAvailableException) || (exception instanceof zzbqn);
        }

        public void onFailure(@NonNull Exception exception) {
            if (zza(exception)) {
                this.zzbYn.zziM(null);
            } else {
                this.zzbYn.onError(exception.getMessage());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbkv.2 */
    class C10832 implements OnSuccessListener<GetTokenResult> {
        final /* synthetic */ zza zzbYn;

        C10832(zzbkv com_google_android_gms_internal_zzbkv, zza com_google_android_gms_internal_zzbly_zza) {
            this.zzbYn = com_google_android_gms_internal_zzbly_zza;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            zza((GetTokenResult) obj);
        }

        public void zza(GetTokenResult getTokenResult) {
            this.zzbYn.zziM(getTokenResult.getToken());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbkv.3 */
    class C10853 implements FirebaseApp.zza {
        final /* synthetic */ zzb zzbYo;
        final /* synthetic */ zzbkv zzbYp;

        /* renamed from: com.google.android.gms.internal.zzbkv.3.1 */
        class C10841 implements Runnable {
            final /* synthetic */ zzbqm zzbVF;
            final /* synthetic */ C10853 zzbYq;

            C10841(C10853 c10853, zzbqm com_google_android_gms_internal_zzbqm) {
                this.zzbYq = c10853;
                this.zzbVF = com_google_android_gms_internal_zzbqm;
            }

            public void run() {
                this.zzbYq.zzbYo.zziV(this.zzbVF.getToken());
            }
        }

        C10853(zzbkv com_google_android_gms_internal_zzbkv, zzb com_google_android_gms_internal_zzbly_zzb) {
            this.zzbYp = com_google_android_gms_internal_zzbkv;
            this.zzbYo = com_google_android_gms_internal_zzbly_zzb;
        }

        public void zzb(@NonNull zzbqm com_google_android_gms_internal_zzbqm) {
            this.zzbYp.zzbYl.execute(new C10841(this, com_google_android_gms_internal_zzbqm));
        }
    }

    public zzbkv(@NonNull FirebaseApp firebaseApp, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.zzbYm = firebaseApp;
        this.zzbYl = scheduledExecutorService;
    }

    private FirebaseApp.zza zzb(zzb com_google_android_gms_internal_zzbly_zzb) {
        return new C10853(this, com_google_android_gms_internal_zzbly_zzb);
    }

    public void zza(zzb com_google_android_gms_internal_zzbly_zzb) {
        this.zzbYm.zza(zzb(com_google_android_gms_internal_zzbly_zzb));
    }

    public void zza(boolean z, @NonNull zza com_google_android_gms_internal_zzbly_zza) {
        this.zzbYm.getToken(z).addOnSuccessListener(this.zzbYl, new C10832(this, com_google_android_gms_internal_zzbly_zza)).addOnFailureListener(this.zzbYl, new C10821(this, com_google_android_gms_internal_zzbly_zza));
    }
}
