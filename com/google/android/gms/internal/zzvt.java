package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.FitnessActivities;

public class zzvt extends zza {
    public static final Creator<zzvt> CREATOR;
    private final int mVersionCode;
    private final int[] zzakZ;

    static {
        CREATOR = new zzvu();
    }

    zzvt(int i, int[] iArr) {
        this.mVersionCode = i;
        this.zzakZ = iArr;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attributes=");
        if (this.zzakZ == null) {
            stringBuilder.append(FitnessActivities.UNKNOWN);
        } else {
            stringBuilder.append("[");
            int[] iArr = this.zzakZ;
            int length = iArr.length;
            Object obj = 1;
            int i = 0;
            while (i < length) {
                int i2 = iArr[i];
                if (obj == null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(i2);
                i++;
                obj = null;
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzvu.zza(this, parcel, i);
    }

    public int[] zzrn() {
        return this.zzakZ;
    }
}
