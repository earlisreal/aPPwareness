package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class zztj extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zztj> CREATOR;
    public final Account account;
    final int mVersionCode;
    final zztn[] zzaga;
    public final String zzagb;
    public final boolean zzagc;

    public static class zza {
        private List<zztn> zzagd;
        private String zzage;
        private boolean zzagf;
        private Account zzagg;

        public zza zzX(boolean z) {
            this.zzagf = z;
            return this;
        }

        public zza zza(zztn com_google_android_gms_internal_zztn) {
            if (this.zzagd == null && com_google_android_gms_internal_zztn != null) {
                this.zzagd = new ArrayList();
            }
            if (com_google_android_gms_internal_zztn != null) {
                this.zzagd.add(com_google_android_gms_internal_zztn);
            }
            return this;
        }

        public zza zzb(Account account) {
            this.zzagg = account;
            return this;
        }

        public zza zzck(String str) {
            this.zzage = str;
            return this;
        }

        public zztj zzqe() {
            return new zztj(this.zzage, this.zzagf, this.zzagg, this.zzagd != null ? (zztn[]) this.zzagd.toArray(new zztn[this.zzagd.size()]) : null);
        }
    }

    static {
        CREATOR = new zztk();
    }

    zztj(int i, zztn[] com_google_android_gms_internal_zztnArr, String str, boolean z, Account account) {
        this.mVersionCode = i;
        this.zzaga = com_google_android_gms_internal_zztnArr;
        this.zzagb = str;
        this.zzagc = z;
        this.account = account;
    }

    zztj(String str, boolean z, Account account, zztn... com_google_android_gms_internal_zztnArr) {
        this(1, com_google_android_gms_internal_zztnArr, str, z, account);
        if (com_google_android_gms_internal_zztnArr != null) {
            BitSet bitSet = new BitSet(zztu.zzqg());
            for (zztn com_google_android_gms_internal_zztn : com_google_android_gms_internal_zztnArr) {
                int i = com_google_android_gms_internal_zztn.zzagn;
                if (i != -1) {
                    if (bitSet.get(i)) {
                        String str2 = "Duplicate global search section type ";
                        String valueOf = String.valueOf(zztu.zzaN(i));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    }
                    bitSet.set(i);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zztj)) {
            return false;
        }
        zztj com_google_android_gms_internal_zztj = (zztj) obj;
        return zzaa.equal(this.zzagb, com_google_android_gms_internal_zztj.zzagb) && zzaa.equal(Boolean.valueOf(this.zzagc), Boolean.valueOf(com_google_android_gms_internal_zztj.zzagc)) && zzaa.equal(this.account, com_google_android_gms_internal_zztj.account) && Arrays.equals(zzqd(), com_google_android_gms_internal_zztj.zzqd());
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzagb, Boolean.valueOf(this.zzagc), this.account, Integer.valueOf(Arrays.hashCode(this.zzaga)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zztk.zza(this, parcel, i);
    }

    public zztn[] zzqd() {
        return this.zzaga;
    }
}
