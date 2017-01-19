package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class zztv extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zztv> CREATOR;
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzagA;
    public final boolean zzagB;
    public final boolean zzagC;
    public final String zzagD;
    public final zztp[] zzagE;
    final int[] zzagF;
    public final String zzagG;

    public static final class zza {
        private final String mName;
        private String zzagH;
        private boolean zzagI;
        private int zzagJ;
        private boolean zzagK;
        private final List<zztp> zzagL;
        private BitSet zzagM;
        private String zzagN;

        public zza(String str) {
            this.mName = str;
            this.zzagJ = 1;
            this.zzagL = new ArrayList();
        }

        public zza zzY(boolean z) {
            this.zzagI = z;
            return this;
        }

        public zza zzZ(boolean z) {
            this.zzagK = z;
            return this;
        }

        public zza zzaO(int i) {
            if (this.zzagM == null) {
                this.zzagM = new BitSet();
            }
            this.zzagM.set(i);
            return this;
        }

        public zza zzcm(String str) {
            this.zzagH = str;
            return this;
        }

        public zza zzcn(String str) {
            this.zzagN = str;
            return this;
        }

        public zztv zzqh() {
            int[] iArr;
            int i = 0;
            if (this.zzagM != null) {
                iArr = new int[this.zzagM.cardinality()];
                int nextSetBit = this.zzagM.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.zzagM.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            } else {
                iArr = null;
            }
            return new zztv(this.mName, this.zzagH, this.zzagI, this.zzagJ, this.zzagK, null, (zztp[]) this.zzagL.toArray(new zztp[this.zzagL.size()]), iArr, this.zzagN);
        }
    }

    static {
        CREATOR = new zztw();
    }

    zztv(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, zztp[] com_google_android_gms_internal_zztpArr, int[] iArr, String str4) {
        this.mVersionCode = i;
        this.name = str;
        this.zzagA = str2;
        this.zzagB = z;
        this.weight = i2;
        this.zzagC = z2;
        this.zzagD = str3;
        this.zzagE = com_google_android_gms_internal_zztpArr;
        this.zzagF = iArr;
        this.zzagG = str4;
    }

    zztv(String str, String str2, boolean z, int i, boolean z2, String str3, zztp[] com_google_android_gms_internal_zztpArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, com_google_android_gms_internal_zztpArr, iArr, str4);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zztw.zza(this, parcel, i);
    }
}
