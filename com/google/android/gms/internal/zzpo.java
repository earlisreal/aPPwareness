package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzpo {
    private final String[] zzXl;
    private final double[] zzXm;
    private final double[] zzXn;
    private final int[] zzXo;
    private int zzXp;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzXq;
        public final double zzXr;
        public final double zzXs;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzXr = d;
            this.zzXq = d2;
            this.zzXs = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzpo_zza = (zza) obj;
            return zzaa.equal(this.name, com_google_android_gms_internal_zzpo_zza.name) && this.zzXq == com_google_android_gms_internal_zzpo_zza.zzXq && this.zzXr == com_google_android_gms_internal_zzpo_zza.zzXr && this.count == com_google_android_gms_internal_zzpo_zza.count && Double.compare(this.zzXs, com_google_android_gms_internal_zzpo_zza.zzXs) == 0;
        }

        public int hashCode() {
            return zzaa.hashCode(this.name, Double.valueOf(this.zzXq), Double.valueOf(this.zzXr), Double.valueOf(this.zzXs), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzaa.zzv(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzXr)).zzg("maxBound", Double.valueOf(this.zzXq)).zzg("percent", Double.valueOf(this.zzXs)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzXt;
        private final List<Double> zzXu;
        private final List<Double> zzXv;

        public zzb() {
            this.zzXt = new ArrayList();
            this.zzXu = new ArrayList();
            this.zzXv = new ArrayList();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.internal.zzpo.zzb zza(java.lang.String r7, double r8, double r10) {
            /*
            r6 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            r0 = r6.zzXt;
            r0 = r0.size();
            if (r1 >= r0) goto L_0x0026;
        L_0x000a:
            r0 = r6.zzXv;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r2 = r0.doubleValue();
            r0 = r6.zzXu;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r4 = r0.doubleValue();
            r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x003e;
        L_0x0026:
            r0 = r6.zzXt;
            r0.add(r1, r7);
            r0 = r6.zzXv;
            r2 = java.lang.Double.valueOf(r8);
            r0.add(r1, r2);
            r0 = r6.zzXu;
            r2 = java.lang.Double.valueOf(r10);
            r0.add(r1, r2);
            return r6;
        L_0x003e:
            r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r0 != 0) goto L_0x0046;
        L_0x0042:
            r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
            if (r0 < 0) goto L_0x0026;
        L_0x0046:
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0002;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.zzb.zza(java.lang.String, double, double):com.google.android.gms.internal.zzpo$zzb");
        }

        public zzpo zzkB() {
            return new zzpo();
        }
    }

    private zzpo(zzb com_google_android_gms_internal_zzpo_zzb) {
        int size = com_google_android_gms_internal_zzpo_zzb.zzXu.size();
        this.zzXl = (String[]) com_google_android_gms_internal_zzpo_zzb.zzXt.toArray(new String[size]);
        this.zzXm = zzn(com_google_android_gms_internal_zzpo_zzb.zzXu);
        this.zzXn = zzn(com_google_android_gms_internal_zzpo_zzb.zzXv);
        this.zzXo = new int[size];
        this.zzXp = 0;
    }

    private double[] zzn(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        List<zza> arrayList = new ArrayList(this.zzXl.length);
        for (int i = 0; i < this.zzXl.length; i++) {
            arrayList.add(new zza(this.zzXl[i], this.zzXn[i], this.zzXm[i], ((double) this.zzXo[i]) / ((double) this.zzXp), this.zzXo[i]));
        }
        return arrayList;
    }

    public void zza(double d) {
        this.zzXp++;
        int i = 0;
        while (i < this.zzXn.length) {
            if (this.zzXn[i] <= d && d < this.zzXm[i]) {
                int[] iArr = this.zzXo;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzXn[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
