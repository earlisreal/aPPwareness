package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzsf implements Parcelable {
    @Deprecated
    public static final Creator<zzsf> CREATOR;
    private String mValue;
    private String zzGu;
    private String zzadT;

    /* renamed from: com.google.android.gms.internal.zzsf.1 */
    class C15201 implements Creator<zzsf> {
        C15201() {
        }

        @Deprecated
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzw(parcel);
        }

        @Deprecated
        public /* synthetic */ Object[] newArray(int i) {
            return zzaF(i);
        }

        @Deprecated
        public zzsf[] zzaF(int i) {
            return new zzsf[i];
        }

        @Deprecated
        public zzsf zzw(Parcel parcel) {
            return new zzsf(parcel);
        }
    }

    static {
        CREATOR = new C15201();
    }

    @Deprecated
    zzsf(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.zzGu = parcel.readString();
        this.zzadT = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzGu;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzGu);
        parcel.writeString(this.zzadT);
        parcel.writeString(this.mValue);
    }
}
