package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;

public interface zzcb {

    public interface zza {
        public static final zza zzrs;

        /* renamed from: com.google.android.gms.internal.zzcb.zza.1 */
        class C12431 implements zza {
            C12431() {
            }

            public Handler zza(Looper looper) {
                return new Handler(looper);
            }
        }

        static {
            zzrs = new C12431();
        }

        Handler zza(Looper looper);
    }
}
