package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public final class zzti {
    public static final zzf<zzud> zzafW;
    private static final zza<zzud, NoOptions> zzafX;
    public static final Api<NoOptions> zzafY;
    public static final zztz zzafZ;

    /* renamed from: com.google.android.gms.internal.zzti.1 */
    class C15251 extends zza<zzud, NoOptions> {
        C15251() {
        }

        public zzud zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzud(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzafW = new zzf();
        zzafX = new C15251();
        zzafY = new Api("AppDataSearch.LIGHTWEIGHT_API", zzafX, zzafW);
        zzafZ = new zzuf();
    }
}
