package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzmb
public class zzov {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzJY;
    public final List<String> zzJZ;
    @Nullable
    public final zzji zzKA;
    @Nullable
    public final zzjt zzKB;
    @Nullable
    public final String zzKC;
    @Nullable
    public final zzjl zzKD;
    @Nullable
    public final List<String> zzKb;
    public final long zzKe;
    @Nullable
    public final zzqp zzMZ;
    public final long zzRJ;
    public final boolean zzRK;
    public final long zzRL;
    public final List<String> zzRM;
    public final String zzRP;
    @Nullable
    public final zzok zzRZ;
    public final zzdy zzRd;
    public final String zzRg;
    @Nullable
    public final List<String> zzSb;
    public final boolean zzSc;
    public final zzmm zzSd;
    public final String zzSg;
    public boolean zzVA;
    public final JSONObject zzVp;
    public boolean zzVq;
    public final zzjj zzVr;
    @Nullable
    public final String zzVs;
    public final zzec zzVt;
    @Nullable
    public final List<String> zzVu;
    public final long zzVv;
    public final long zzVw;
    @Nullable
    public final com.google.android.gms.internal.zzgu.zza zzVx;
    public boolean zzVy;
    public boolean zzVz;

    @zzmb
    public static final class zza {
        public final int errorCode;
        public final zzmh zzSF;
        public final zzmk zzVB;
        @Nullable
        public final JSONObject zzVp;
        public final zzjj zzVr;
        public final long zzVv;
        public final long zzVw;
        @Nullable
        public final zzec zzvj;

        public zza(zzmh com_google_android_gms_internal_zzmh, zzmk com_google_android_gms_internal_zzmk, zzjj com_google_android_gms_internal_zzjj, zzec com_google_android_gms_internal_zzec, int i, long j, long j2, JSONObject jSONObject) {
            this.zzSF = com_google_android_gms_internal_zzmh;
            this.zzVB = com_google_android_gms_internal_zzmk;
            this.zzVr = com_google_android_gms_internal_zzjj;
            this.zzvj = com_google_android_gms_internal_zzec;
            this.errorCode = i;
            this.zzVv = j;
            this.zzVw = j2;
            this.zzVp = jSONObject;
        }
    }

    public zzov(zzdy com_google_android_gms_internal_zzdy, @Nullable zzqp com_google_android_gms_internal_zzqp, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zzji com_google_android_gms_internal_zzji, @Nullable zzjt com_google_android_gms_internal_zzjt, @Nullable String str2, zzjj com_google_android_gms_internal_zzjj, @Nullable zzjl com_google_android_gms_internal_zzjl, long j2, zzec com_google_android_gms_internal_zzec, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable com.google.android.gms.internal.zzgu.zza com_google_android_gms_internal_zzgu_zza, zzok com_google_android_gms_internal_zzok, List<String> list4, List<String> list5, boolean z2, zzmm com_google_android_gms_internal_zzmm, @Nullable String str4, List<String> list6, String str5) {
        this.zzVy = false;
        this.zzVz = false;
        this.zzVA = false;
        this.zzRd = com_google_android_gms_internal_zzdy;
        this.zzMZ = com_google_android_gms_internal_zzqp;
        this.zzJY = zzm(list);
        this.errorCode = i;
        this.zzJZ = zzm(list2);
        this.zzRM = zzm(list3);
        this.orientation = i2;
        this.zzKe = j;
        this.zzRg = str;
        this.zzRK = z;
        this.zzKA = com_google_android_gms_internal_zzji;
        this.zzKB = com_google_android_gms_internal_zzjt;
        this.zzKC = str2;
        this.zzVr = com_google_android_gms_internal_zzjj;
        this.zzKD = com_google_android_gms_internal_zzjl;
        this.zzRL = j2;
        this.zzVt = com_google_android_gms_internal_zzec;
        this.zzRJ = j3;
        this.zzVv = j4;
        this.zzVw = j5;
        this.zzRP = str3;
        this.zzVp = jSONObject;
        this.zzVx = com_google_android_gms_internal_zzgu_zza;
        this.zzRZ = com_google_android_gms_internal_zzok;
        this.zzVu = zzm(list4);
        this.zzSb = zzm(list5);
        this.zzSc = z2;
        this.zzSd = com_google_android_gms_internal_zzmm;
        this.zzVs = str4;
        this.zzKb = zzm(list6);
        this.zzSg = str5;
    }

    public zzov(zza com_google_android_gms_internal_zzov_zza, @Nullable zzqp com_google_android_gms_internal_zzqp, @Nullable zzji com_google_android_gms_internal_zzji, @Nullable zzjt com_google_android_gms_internal_zzjt, @Nullable String str, @Nullable zzjl com_google_android_gms_internal_zzjl, @Nullable com.google.android.gms.internal.zzgu.zza com_google_android_gms_internal_zzgu_zza, @Nullable String str2) {
        zzqp com_google_android_gms_internal_zzqp2 = com_google_android_gms_internal_zzqp;
        zzji com_google_android_gms_internal_zzji2 = com_google_android_gms_internal_zzji;
        zzjt com_google_android_gms_internal_zzjt2 = com_google_android_gms_internal_zzjt;
        String str3 = str;
        zzjl com_google_android_gms_internal_zzjl2 = com_google_android_gms_internal_zzjl;
        com.google.android.gms.internal.zzgu.zza com_google_android_gms_internal_zzgu_zza2 = com_google_android_gms_internal_zzgu_zza;
        String str4 = str2;
        this(com_google_android_gms_internal_zzov_zza.zzSF.zzRd, com_google_android_gms_internal_zzqp2, com_google_android_gms_internal_zzov_zza.zzVB.zzJY, com_google_android_gms_internal_zzov_zza.errorCode, com_google_android_gms_internal_zzov_zza.zzVB.zzJZ, com_google_android_gms_internal_zzov_zza.zzVB.zzRM, com_google_android_gms_internal_zzov_zza.zzVB.orientation, com_google_android_gms_internal_zzov_zza.zzVB.zzKe, com_google_android_gms_internal_zzov_zza.zzSF.zzRg, com_google_android_gms_internal_zzov_zza.zzVB.zzRK, com_google_android_gms_internal_zzji2, com_google_android_gms_internal_zzjt2, str3, com_google_android_gms_internal_zzov_zza.zzVr, com_google_android_gms_internal_zzjl2, com_google_android_gms_internal_zzov_zza.zzVB.zzRL, com_google_android_gms_internal_zzov_zza.zzvj, com_google_android_gms_internal_zzov_zza.zzVB.zzRJ, com_google_android_gms_internal_zzov_zza.zzVv, com_google_android_gms_internal_zzov_zza.zzVw, com_google_android_gms_internal_zzov_zza.zzVB.zzRP, com_google_android_gms_internal_zzov_zza.zzVp, com_google_android_gms_internal_zzgu_zza2, com_google_android_gms_internal_zzov_zza.zzVB.zzRZ, com_google_android_gms_internal_zzov_zza.zzVB.zzSa, com_google_android_gms_internal_zzov_zza.zzVB.zzSa, com_google_android_gms_internal_zzov_zza.zzVB.zzSc, com_google_android_gms_internal_zzov_zza.zzVB.zzSd, str4, com_google_android_gms_internal_zzov_zza.zzVB.zzKb, com_google_android_gms_internal_zzov_zza.zzVB.zzSg);
    }

    @Nullable
    private static <T> List<T> zzm(@Nullable List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public boolean zzdz() {
        return (this.zzMZ == null || this.zzMZ.zzkV() == null) ? false : this.zzMZ.zzkV().zzdz();
    }
}
