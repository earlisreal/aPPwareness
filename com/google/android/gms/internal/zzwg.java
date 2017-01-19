package com.google.android.gms.internal;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.ActivityRecognitionResult;

public final class zzwg extends zza {
    public static final Creator<zzwg> CREATOR;
    private final int mVersionCode;
    private final ActivityRecognitionResult zzalh;
    private final zzvr zzali;
    private final zzvv zzalj;
    private final zzvx zzalk;
    private final DataHolder zzall;
    private final zzwc zzalm;
    private final zzwe zzaln;
    private final zzwn zzalo;
    private final zzvt zzalp;
    private final Location zzcU;

    static {
        CREATOR = new zzwi();
    }

    zzwg(int i, ActivityRecognitionResult activityRecognitionResult, zzvr com_google_android_gms_internal_zzvr, zzvv com_google_android_gms_internal_zzvv, Location location, zzvx com_google_android_gms_internal_zzvx, DataHolder dataHolder, zzwc com_google_android_gms_internal_zzwc, zzwe com_google_android_gms_internal_zzwe, zzwn com_google_android_gms_internal_zzwn, zzvt com_google_android_gms_internal_zzvt) {
        this.mVersionCode = i;
        this.zzalh = activityRecognitionResult;
        this.zzali = com_google_android_gms_internal_zzvr;
        this.zzalj = com_google_android_gms_internal_zzvv;
        this.zzcU = location;
        this.zzalk = com_google_android_gms_internal_zzvx;
        this.zzall = dataHolder;
        this.zzalm = com_google_android_gms_internal_zzwc;
        this.zzaln = com_google_android_gms_internal_zzwe;
        this.zzalo = com_google_android_gms_internal_zzwn;
        this.zzalp = com_google_android_gms_internal_zzvt;
    }

    public ActivityRecognitionResult getActivityRecognitionResult() {
        return this.zzalh;
    }

    public Location getLocation() {
        return this.zzcU;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwi.zza(this, parcel, i);
    }

    public zzvt zzrA() {
        return this.zzalp;
    }

    public zzvr zzrt() {
        return this.zzali;
    }

    public zzvv zzru() {
        return this.zzalj;
    }

    public zzvx zzrv() {
        return this.zzalk;
    }

    public DataHolder zzrw() {
        return this.zzall;
    }

    public zzwc zzrx() {
        return this.zzalm;
    }

    public zzwe zzry() {
        return this.zzaln;
    }

    public zzwn zzrz() {
        return this.zzalo;
    }
}
