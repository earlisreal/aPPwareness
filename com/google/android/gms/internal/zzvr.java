package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.awareness.state.BeaconState;
import com.google.android.gms.awareness.state.BeaconState.BeaconInfo;
import com.google.android.gms.awareness.state.BeaconState.TypeFilter;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class zzvr extends com.google.android.gms.common.internal.safeparcel.zza implements BeaconState {
    public static final Creator<zzvr> CREATOR;
    private final int mVersionCode;
    private final ArrayList<zza> zzakV;

    public static final class zza extends com.google.android.gms.common.internal.safeparcel.zza implements BeaconInfo {
        public static final Creator<zza> CREATOR;
        private final int mVersionCode;
        private final String zzTW;
        private final String zzakW;
        private final byte[] zzakX;

        static {
            CREATOR = new zzvq();
        }

        zza(int i, String str, String str2, byte[] bArr) {
            this.mVersionCode = i;
            this.zzakW = str;
            this.zzTW = str2;
            this.zzakX = bArr;
        }

        public byte[] getContent() {
            return this.zzakX;
        }

        public String getNamespace() {
            return this.zzakW;
        }

        public String getType() {
            return this.zzTW;
        }

        int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            String str = this.zzakX == null ? "<null>" : new String(this.zzakX);
            String str2 = this.zzakW;
            String str3 = this.zzTW;
            return new StringBuilder(((String.valueOf(str2).length() + 6) + String.valueOf(str3).length()) + String.valueOf(str).length()).append("(").append(str2).append(", ").append(str3).append(", ").append(str).append(")").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzvq.zza(this, parcel, i);
        }
    }

    public static class zzb extends TypeFilter {
        public static final Creator<zzb> CREATOR;
        private final int mVersionCode;
        private final com.google.android.gms.internal.zzbtp.zza zzakY;

        static {
            CREATOR = new zzwm();
        }

        zzb(int i, byte[] bArr) {
            this.mVersionCode = i;
            com.google.android.gms.internal.zzbtp.zza com_google_android_gms_internal_zzbtp_zza = null;
            try {
                com_google_android_gms_internal_zzbtp_zza = com.google.android.gms.internal.zzbtp.zza.zzZ(bArr);
            } catch (zzbus e) {
                zzcd.zzd("BeaconStateImpl", "Could not deserialize BeaconFence.BeaconTypeFilter");
            }
            this.zzakY = com_google_android_gms_internal_zzbtp_zza;
        }

        public zzb(String str, String str2) {
            this.mVersionCode = 1;
            this.zzakY = new com.google.android.gms.internal.zzbtp.zza();
            this.zzakY.zzaFs = zzac.zzdv(str);
            this.zzakY.type = zzac.zzdv(str2);
        }

        public zzb(String str, String str2, byte[] bArr) {
            this.mVersionCode = 1;
            this.zzakY = new com.google.android.gms.internal.zzbtp.zza();
            this.zzakY.zzaFs = zzac.zzdv(str);
            this.zzakY.type = zzac.zzdv(str2);
            this.zzakY.content = (byte[]) zzac.zzw(bArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzvr_zzb = (zzb) obj;
            return TextUtils.equals(getNamespace(), com_google_android_gms_internal_zzvr_zzb.getNamespace()) && TextUtils.equals(getType(), com_google_android_gms_internal_zzvr_zzb.getType()) && Arrays.equals(getContent(), com_google_android_gms_internal_zzvr_zzb.getContent());
        }

        public byte[] getContent() {
            return (this.zzakY == null || this.zzakY.content == null || this.zzakY.content.length == 0) ? null : this.zzakY.content;
        }

        public String getNamespace() {
            return this.zzakY == null ? null : this.zzakY.zzaFs;
        }

        public String getType() {
            return this.zzakY == null ? null : this.zzakY.type;
        }

        int getVersionCode() {
            return this.mVersionCode;
        }

        public int hashCode() {
            int i = 0;
            Object[] objArr = new Object[3];
            objArr[0] = getNamespace();
            objArr[1] = getType();
            if (getContent() != null) {
                i = Arrays.hashCode(getContent());
            }
            objArr[2] = Integer.valueOf(i);
            return zzaa.hashCode(objArr);
        }

        public String toString() {
            String valueOf = String.valueOf(getNamespace());
            String valueOf2 = String.valueOf(getType());
            String str = getContent() == null ? "null" : new String(getContent());
            return new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()).append("(").append(valueOf).append(",").append(valueOf2).append(",").append(str).append(")").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzwm.zza(this, parcel, i);
        }

        public com.google.android.gms.internal.zzbtp.zza zzrl() {
            return this.zzakY;
        }

        byte[] zzrm() {
            return zzbut.zzf(this.zzakY);
        }
    }

    static {
        CREATOR = new zzvs();
    }

    zzvr(int i, ArrayList<zza> arrayList) {
        this.mVersionCode = i;
        this.zzakV = arrayList;
    }

    public List<BeaconInfo> getBeaconInfo() {
        return this.zzakV;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        if (this.zzakV == null || this.zzakV.isEmpty()) {
            return "BeaconState: empty";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BeaconState: ");
        Iterator it = this.zzakV.iterator();
        while (it.hasNext()) {
            stringBuilder.append((BeaconInfo) it.next());
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzvs.zza(this, parcel, i);
    }

    ArrayList<zza> zzrk() {
        return this.zzakV;
    }
}
