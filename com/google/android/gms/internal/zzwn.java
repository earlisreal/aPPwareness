package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.awareness.state.Weather;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public class zzwn extends zza implements Weather {
    public static final Creator<zzwn> CREATOR;
    private final int mVersionCode;
    private final float zzalA;
    private final int zzalB;
    private final int[] zzalC;
    private final float zzaly;
    private final float zzalz;

    static {
        CREATOR = new zzwo();
    }

    zzwn(int i, float f, float f2, float f3, int i2, int[] iArr) {
        this.mVersionCode = i;
        this.zzaly = f;
        this.zzalz = f2;
        this.zzalA = f3;
        this.zzalB = i2;
        this.zzalC = iArr;
    }

    static float zza(int i, float f) {
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return f;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return zzc(f);
            default:
                zzcd.zza("WeatherImpl", "Invalid temperature unit %s", Integer.valueOf(i));
                throw new IllegalArgumentException("Invalid temperature unit");
        }
    }

    private static float zzc(float f) {
        return (5.0f * (f - 32.0f)) / 9.0f;
    }

    public int[] getConditions() {
        return this.zzalC;
    }

    public float getDewPoint(int i) {
        return zza(i, this.zzalA);
    }

    public float getFeelsLikeTemperature(int i) {
        return zza(i, this.zzalz);
    }

    public int getHumidity() {
        return this.zzalB;
    }

    public float getTemperature(int i) {
        return zza(i, this.zzaly);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Temp=").append(getTemperature(1)).append("F/").append(getTemperature(2)).append("C, Feels=").append(getFeelsLikeTemperature(1)).append("F/").append(getFeelsLikeTemperature(2)).append("C, Dew=").append(getDewPoint(1)).append("F/").append(getDewPoint(2)).append("C, Humidity=").append(getHumidity()).append(", Condition=");
        if (getConditions() == null) {
            stringBuilder.append(FitnessActivities.UNKNOWN);
        } else {
            stringBuilder.append("[");
            int[] conditions = getConditions();
            int length = conditions.length;
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = conditions[i2];
                if (i == 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(i3);
                i2++;
                i = 0;
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwo.zza(this, parcel, i);
    }

    public float zzrE() {
        return this.zzalA;
    }

    public float zzrF() {
        return this.zzalz;
    }

    public float zzrG() {
        return this.zzaly;
    }
}
