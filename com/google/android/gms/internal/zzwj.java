package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.zzvr.zzb;
import java.util.ArrayList;
import java.util.Iterator;

public class zzwj extends zza {
    public static final Creator<zzwj> CREATOR;
    private static final int[] zzalv;
    private final int mVersionCode;
    private final int zzalw;
    private final ArrayList<zzb> zzalx;

    static {
        zzalv = new int[]{GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, GamesActivityResultCodes.RESULT_LICENSE_FAILED, GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, GamesActivityResultCodes.RESULT_LEFT_ROOM, GamesActivityResultCodes.RESULT_NETWORK_FAILURE, GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, GamesActivityResultCodes.RESULT_INVALID_ROOM};
        CREATOR = new zzwk();
    }

    zzwj(int i, int i2, ArrayList<zzb> arrayList) {
        this.mVersionCode = i;
        this.zzalw = i2;
        this.zzalx = arrayList;
    }

    public zzwj(int i, ArrayList<zzb> arrayList) {
        this(1, i, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwj)) {
            return false;
        }
        zzwj com_google_android_gms_internal_zzwj = (zzwj) obj;
        if (this.zzalw != com_google_android_gms_internal_zzwj.zzrB()) {
            return false;
        }
        if (((this.zzalx == null ? 1 : 0) ^ (com_google_android_gms_internal_zzwj.zzrC() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.zzalx != null) {
            if (this.zzalx.size() != com_google_android_gms_internal_zzwj.zzrC().size()) {
                return false;
            }
            Iterator it = this.zzalx.iterator();
            while (it.hasNext()) {
                if (!com_google_android_gms_internal_zzwj.zzrC().contains((zzb) it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        int i;
        if (this.zzalx != null) {
            Iterator it = this.zzalx.iterator();
            i = 0;
            while (it.hasNext()) {
                i = (((zzb) it.next()).hashCode() * 13) + i;
            }
        } else {
            i = 0;
        }
        return zzaa.hashCode(Integer.valueOf(this.zzalw), Integer.valueOf(i));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwk.zza(this, parcel, i);
    }

    public int zzrB() {
        return this.zzalw;
    }

    public ArrayList<zzb> zzrC() {
        return this.zzalx;
    }
}
