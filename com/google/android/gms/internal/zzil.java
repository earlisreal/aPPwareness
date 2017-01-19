package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzmb
public abstract class zzil implements Releasable {
    protected Context mContext;
    protected String zzHY;
    protected WeakReference<zzqp> zzHZ;

    /* renamed from: com.google.android.gms.internal.zzil.1 */
    class C13241 implements Runnable {
        final /* synthetic */ String zzIa;
        final /* synthetic */ int zzIb;
        final /* synthetic */ int zzIc;
        final /* synthetic */ boolean zzId;
        final /* synthetic */ zzil zzIe;
        final /* synthetic */ String zzsk;

        C13241(zzil com_google_android_gms_internal_zzil, String str, String str2, int i, int i2, boolean z) {
            this.zzIe = com_google_android_gms_internal_zzil;
            this.zzsk = str;
            this.zzIa = str2;
            this.zzIb = i;
            this.zzIc = i2;
            this.zzId = z;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "precacheProgress");
            hashMap.put("src", this.zzsk);
            hashMap.put("cachedSrc", this.zzIa);
            hashMap.put("bytesLoaded", Integer.toString(this.zzIb));
            hashMap.put("totalBytes", Integer.toString(this.zzIc));
            hashMap.put("cacheReady", this.zzId ? "1" : "0");
            this.zzIe.zza("onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzil.2 */
    class C13252 implements Runnable {
        final /* synthetic */ String zzIa;
        final /* synthetic */ int zzIc;
        final /* synthetic */ zzil zzIe;
        final /* synthetic */ String zzsk;

        C13252(zzil com_google_android_gms_internal_zzil, String str, String str2, int i) {
            this.zzIe = com_google_android_gms_internal_zzil;
            this.zzsk = str;
            this.zzIa = str2;
            this.zzIc = i;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "precacheComplete");
            hashMap.put("src", this.zzsk);
            hashMap.put("cachedSrc", this.zzIa);
            hashMap.put("totalBytes", Integer.toString(this.zzIc));
            this.zzIe.zza("onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzil.3 */
    class C13263 implements Runnable {
        final /* synthetic */ String zzIa;
        final /* synthetic */ zzil zzIe;
        final /* synthetic */ String zzIf;
        final /* synthetic */ String zzIg;
        final /* synthetic */ String zzsk;

        C13263(zzil com_google_android_gms_internal_zzil, String str, String str2, String str3, String str4) {
            this.zzIe = com_google_android_gms_internal_zzil;
            this.zzsk = str;
            this.zzIa = str2;
            this.zzIf = str3;
            this.zzIg = str4;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "precacheCanceled");
            hashMap.put("src", this.zzsk);
            if (!TextUtils.isEmpty(this.zzIa)) {
                hashMap.put("cachedSrc", this.zzIa);
            }
            hashMap.put("type", this.zzIe.zzaf(this.zzIf));
            hashMap.put("reason", this.zzIf);
            if (!TextUtils.isEmpty(this.zzIg)) {
                hashMap.put("message", this.zzIg);
            }
            this.zzIe.zza("onPrecacheEvent", hashMap);
        }
    }

    public zzil(zzqp com_google_android_gms_internal_zzqp) {
        this.mContext = com_google_android_gms_internal_zzqp.getContext();
        this.zzHY = zzv.zzcJ().zzh(this.mContext, com_google_android_gms_internal_zzqp.zzkY().zzaZ);
        this.zzHZ = new WeakReference(com_google_android_gms_internal_zzqp);
    }

    private void zza(String str, Map<String, String> map) {
        zzqp com_google_android_gms_internal_zzqp = (zzqp) this.zzHZ.get();
        if (com_google_android_gms_internal_zzqp != null) {
            com_google_android_gms_internal_zzqp.zza(str, (Map) map);
        }
    }

    private String zzaf(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals(MediaRouteProviderProtocol.SERVICE_DATA_ERROR)) {
                    obj = null;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return "internal";
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
                return "io";
            case BuyButtonText.LOGO_ONLY /*6*/:
            case BuyButtonText.DONATE_WITH /*7*/:
                return "network";
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return "policy";
            default:
                return str2;
        }
    }

    public abstract void abort();

    public void release() {
    }

    protected void zza(String str, String str2, int i) {
        zzpx.zzXU.post(new C13252(this, str, str2, i));
    }

    protected void zza(String str, String str2, int i, int i2, boolean z) {
        zzpx.zzXU.post(new C13241(this, str, str2, i, i2, z));
    }

    public void zza(String str, String str2, String str3, @Nullable String str4) {
        zzpx.zzXU.post(new C13263(this, str, str2, str3, str4));
    }

    public abstract boolean zzad(String str);

    protected String zzae(String str) {
        return zzeh.zzeO().zzbb(str);
    }
}
