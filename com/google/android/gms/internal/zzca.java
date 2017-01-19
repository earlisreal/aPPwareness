package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class zzca {
    public static final zzca zzrq;
    private static zza zzrr;
    private final String mName;

    public interface zza {
    }

    static {
        zzrq = new zzca("@@ContextManagerNullAccount@@");
        zzrr = null;
    }

    public zzca(String str) {
        this.mName = zzac.zzdv(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzca)) {
            return false;
        }
        return TextUtils.equals(this.mName, ((zzca) obj).getName());
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return zzaa.hashCode(this.mName);
    }

    public String toString() {
        return "#account#";
    }
}
