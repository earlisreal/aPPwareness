package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzac;

public class zzvn implements ProxyApi {

    /* renamed from: com.google.android.gms.internal.zzvn.1 */
    class C15441 extends zzvm {
        final /* synthetic */ ProxyRequest zzaiS;

        /* renamed from: com.google.android.gms.internal.zzvn.1.1 */
        class C15431 extends zzvi {
            final /* synthetic */ C15441 zzaiT;

            C15431(C15441 c15441) {
                this.zzaiT = c15441;
            }

            public void zza(ProxyResponse proxyResponse) {
                this.zzaiT.zzb(new zzvo(proxyResponse));
            }
        }

        C15441(zzvn com_google_android_gms_internal_zzvn, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
            this.zzaiS = proxyRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzvl com_google_android_gms_internal_zzvl) throws RemoteException {
            com_google_android_gms_internal_zzvl.zza(new C15431(this), this.zzaiS);
        }
    }

    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        zzac.zzw(googleApiClient);
        zzac.zzw(proxyRequest);
        return googleApiClient.zzb(new C15441(this, googleApiClient, proxyRequest));
    }
}
