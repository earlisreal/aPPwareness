package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzf extends zza {
    public static final Creator<zzf> CREATOR;
    private final int mVersionCode;
    private int zzamY;

    static {
        CREATOR = new zzg();
    }

    public zzf() {
        this(1, 0);
    }

    zzf(int i, int i2) {
        this.mVersionCode = i;
        this.zzamY = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzf)) {
            return false;
        }
        return this.zzamY == ((zzf) obj).zzamY;
    }

    public int getConnectionType() {
        return this.zzamY;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzamY));
    }

    public String toString() {
        String str;
        switch (this.zzamY) {
            case MessageApi.FILTER_LITERAL /*0*/:
                str = "STRONG";
                break;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                str = "INVISIBLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", new Object[]{str});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
