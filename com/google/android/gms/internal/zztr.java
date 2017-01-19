package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public class zztr {

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR;
        final int mVersionCode;
        public final Account zzagq;
        public final boolean zzagr;
        public final boolean zzags;
        public final boolean zzagt;
        public final String zzagu;

        static {
            CREATOR = new zzts();
        }

        public zza() {
            this(null, false, false, false, null);
        }

        zza(int i, Account account, boolean z, boolean z2, boolean z3, String str) {
            this.mVersionCode = i;
            this.zzagq = account;
            this.zzagr = z;
            this.zzags = z2;
            this.zzagt = z3;
            this.zzagu = str;
        }

        public zza(Account account, boolean z, boolean z2, boolean z3, String str) {
            this(1, account, z, z2, z3, str);
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzts.zza(this, parcel, i);
        }
    }

    public static class zzb extends com.google.android.gms.common.internal.safeparcel.zza implements Result {
        public static final Creator<zzb> CREATOR;
        final int mVersionCode;
        public Status zzagv;
        public List<zztx> zzagw;
        @Deprecated
        public String[] zzagx;

        static {
            CREATOR = new zztt();
        }

        public zzb() {
            this.mVersionCode = 1;
        }

        zzb(int i, Status status, List<zztx> list, String[] strArr) {
            this.mVersionCode = i;
            this.zzagv = status;
            this.zzagw = list;
            this.zzagx = strArr;
        }

        public Status getStatus() {
            return this.zzagv;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zztt.zza(this, parcel, i);
        }
    }
}
