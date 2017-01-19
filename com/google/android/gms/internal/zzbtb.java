package com.google.android.gms.internal;

import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzbtb extends zzbsd<Object> {
    public static final zzbse zzcnX;
    private final zzbrl zzcmT;

    /* renamed from: com.google.android.gms.internal.zzbtb.1 */
    static class C12251 implements zzbse {
        C12251() {
        }

        public <T> zzbsd<T> zza(zzbrl com_google_android_gms_internal_zzbrl, zzbth<T> com_google_android_gms_internal_zzbth_T) {
            return com_google_android_gms_internal_zzbth_T.zzacb() == Object.class ? new zzbtb(null) : null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbtb.2 */
    static /* synthetic */ class C12262 {
        static final /* synthetic */ int[] zzcon;

        static {
            zzcon = new int[zzbtj.values().length];
            try {
                zzcon[zzbtj.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzcon[zzbtj.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzcon[zzbtj.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzcon[zzbtj.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzcon[zzbtj.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zzcon[zzbtj.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static {
        zzcnX = new C12251();
    }

    private zzbtb(zzbrl com_google_android_gms_internal_zzbrl) {
        this.zzcmT = com_google_android_gms_internal_zzbrl;
    }

    public void zza(zzbtk com_google_android_gms_internal_zzbtk, Object obj) throws IOException {
        if (obj == null) {
            com_google_android_gms_internal_zzbtk.zzaca();
            return;
        }
        zzbsd zzj = this.zzcmT.zzj(obj.getClass());
        if (zzj instanceof zzbtb) {
            com_google_android_gms_internal_zzbtk.zzabY();
            com_google_android_gms_internal_zzbtk.zzabZ();
            return;
        }
        zzj.zza(com_google_android_gms_internal_zzbtk, obj);
    }

    public Object zzb(zzbti com_google_android_gms_internal_zzbti) throws IOException {
        switch (C12262.zzcon[com_google_android_gms_internal_zzbti.zzabQ().ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                List arrayList = new ArrayList();
                com_google_android_gms_internal_zzbti.beginArray();
                while (com_google_android_gms_internal_zzbti.hasNext()) {
                    arrayList.add(zzb(com_google_android_gms_internal_zzbti));
                }
                com_google_android_gms_internal_zzbti.endArray();
                return arrayList;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                Map com_google_android_gms_internal_zzbsp = new zzbsp();
                com_google_android_gms_internal_zzbti.beginObject();
                while (com_google_android_gms_internal_zzbti.hasNext()) {
                    com_google_android_gms_internal_zzbsp.put(com_google_android_gms_internal_zzbti.nextName(), zzb(com_google_android_gms_internal_zzbti));
                }
                com_google_android_gms_internal_zzbti.endObject();
                return com_google_android_gms_internal_zzbsp;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return com_google_android_gms_internal_zzbti.nextString();
            case Dimension.UNIT_IN /*4*/:
                return Double.valueOf(com_google_android_gms_internal_zzbti.nextDouble());
            case Dimension.UNIT_MM /*5*/:
                return Boolean.valueOf(com_google_android_gms_internal_zzbti.nextBoolean());
            case BuyButtonText.LOGO_ONLY /*6*/:
                com_google_android_gms_internal_zzbti.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
