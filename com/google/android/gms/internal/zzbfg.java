package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbfi.zza;
import org.json.JSONException;

public final class zzbfg {
    public static final zzbff zzbKf;
    public static final zzbff zzbKg;

    /* renamed from: com.google.android.gms.internal.zzbfg.1 */
    class C10491 implements zzbff {
        C10491() {
        }

        public zzbfi zzO(byte[] bArr) throws zzbfb {
            if (bArr == null) {
                throw new zzbfb("Cannot parse a null byte[]");
            } else if (bArr.length == 0) {
                throw new zzbfb("Cannot parse a 0 length byte[]");
            } else {
                try {
                    zzbfr zzhT = zzbfc.zzhT(new String(bArr));
                    if (zzhT != null) {
                        zzayx.m27v("The container was successfully parsed from the resource");
                    }
                    return new zzbfi(Status.zzayh, 0, new zza(zzhT), zzbfg.zzbKg.zzO(bArr).zzRj());
                } catch (JSONException e) {
                    throw new zzbfb("The resource data is corrupted. The container cannot be extracted from the JSON data");
                } catch (zzbfb e2) {
                    throw new zzbfb("The resource data is invalid. The container cannot be extracted from the JSON data");
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbfg.2 */
    class C10502 implements zzbff {
        C10502() {
        }

        public zzbfi zzO(byte[] bArr) throws zzbfb {
            if (bArr == null) {
                throw new zzbfb("Cannot parse a null byte[]");
            } else if (bArr.length == 0) {
                throw new zzbfb("Cannot parse a 0 length byte[]");
            } else {
                try {
                    zzbfu zzhU = zzbfc.zzhU(new String(bArr));
                    if (zzhU != null) {
                        zzayx.m27v("The runtime configuration was successfully parsed from the resource");
                    }
                    return new zzbfi(Status.zzayh, 0, null, zzhU);
                } catch (JSONException e) {
                    throw new zzbfb("The resource data is corrupted. The runtime configuration cannot be extracted from the JSON data");
                } catch (zzbfb e2) {
                    throw new zzbfb("The resource data is invalid. The runtime  configuration cannot be extracted from the JSON data");
                }
            }
        }
    }

    static {
        zzbKf = new C10491();
        zzbKg = new C10502();
    }
}
