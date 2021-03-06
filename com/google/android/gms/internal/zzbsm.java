package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzbsm implements zzbse, Cloneable {
    public static final zzbsm zzcnn;
    private double zzcno;
    private int zzcnp;
    private boolean zzcnq;
    private List<zzbrh> zzcnr;
    private List<zzbrh> zzcns;

    /* renamed from: com.google.android.gms.internal.zzbsm.1 */
    class C12121 extends zzbsd<T> {
        private zzbsd<T> zzcmC;
        final /* synthetic */ boolean zzcnt;
        final /* synthetic */ boolean zzcnu;
        final /* synthetic */ zzbrl zzcnv;
        final /* synthetic */ zzbth zzcnw;
        final /* synthetic */ zzbsm zzcnx;

        C12121(zzbsm com_google_android_gms_internal_zzbsm, boolean z, boolean z2, zzbrl com_google_android_gms_internal_zzbrl, zzbth com_google_android_gms_internal_zzbth) {
            this.zzcnx = com_google_android_gms_internal_zzbsm;
            this.zzcnt = z;
            this.zzcnu = z2;
            this.zzcnv = com_google_android_gms_internal_zzbrl;
            this.zzcnw = com_google_android_gms_internal_zzbth;
        }

        private zzbsd<T> zzabG() {
            zzbsd<T> com_google_android_gms_internal_zzbsd_T = this.zzcmC;
            if (com_google_android_gms_internal_zzbsd_T != null) {
                return com_google_android_gms_internal_zzbsd_T;
            }
            com_google_android_gms_internal_zzbsd_T = this.zzcnv.zza(this.zzcnx, this.zzcnw);
            this.zzcmC = com_google_android_gms_internal_zzbsd_T;
            return com_google_android_gms_internal_zzbsd_T;
        }

        public void zza(zzbtk com_google_android_gms_internal_zzbtk, T t) throws IOException {
            if (this.zzcnu) {
                com_google_android_gms_internal_zzbtk.zzaca();
            } else {
                zzabG().zza(com_google_android_gms_internal_zzbtk, t);
            }
        }

        public T zzb(zzbti com_google_android_gms_internal_zzbti) throws IOException {
            if (!this.zzcnt) {
                return zzabG().zzb(com_google_android_gms_internal_zzbti);
            }
            com_google_android_gms_internal_zzbti.skipValue();
            return null;
        }
    }

    static {
        zzcnn = new zzbsm();
    }

    public zzbsm() {
        this.zzcno = -1.0d;
        this.zzcnp = 136;
        this.zzcnq = true;
        this.zzcnr = Collections.emptyList();
        this.zzcns = Collections.emptyList();
    }

    private boolean zza(zzbsh com_google_android_gms_internal_zzbsh) {
        return com_google_android_gms_internal_zzbsh == null || com_google_android_gms_internal_zzbsh.zzabI() <= this.zzcno;
    }

    private boolean zza(zzbsh com_google_android_gms_internal_zzbsh, zzbsi com_google_android_gms_internal_zzbsi) {
        return zza(com_google_android_gms_internal_zzbsh) && zza(com_google_android_gms_internal_zzbsi);
    }

    private boolean zza(zzbsi com_google_android_gms_internal_zzbsi) {
        return com_google_android_gms_internal_zzbsi == null || com_google_android_gms_internal_zzbsi.zzabI() > this.zzcno;
    }

    private boolean zzl(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzm(Class<?> cls) {
        return cls.isMemberClass() && !zzn(cls);
    }

    private boolean zzn(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzabK();
    }

    public <T> zzbsd<T> zza(zzbrl com_google_android_gms_internal_zzbrl, zzbth<T> com_google_android_gms_internal_zzbth_T) {
        Class zzacb = com_google_android_gms_internal_zzbth_T.zzacb();
        boolean zza = zza(zzacb, true);
        boolean zza2 = zza(zzacb, false);
        return (zza || zza2) ? new C12121(this, zza2, zza, com_google_android_gms_internal_zzbrl, com_google_android_gms_internal_zzbth_T) : null;
    }

    public zzbsm zza(zzbrh com_google_android_gms_internal_zzbrh, boolean z, boolean z2) {
        zzbsm zzabK = zzabK();
        if (z) {
            zzabK.zzcnr = new ArrayList(this.zzcnr);
            zzabK.zzcnr.add(com_google_android_gms_internal_zzbrh);
        }
        if (z2) {
            zzabK.zzcns = new ArrayList(this.zzcns);
            zzabK.zzcns.add(com_google_android_gms_internal_zzbrh);
        }
        return zzabK;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.zzcno != -1.0d && !zza((zzbsh) cls.getAnnotation(zzbsh.class), (zzbsi) cls.getAnnotation(zzbsi.class))) {
            return true;
        }
        if (!this.zzcnq && zzm(cls)) {
            return true;
        }
        if (zzl(cls)) {
            return true;
        }
        for (zzbrh zzg : z ? this.zzcnr : this.zzcns) {
            if (zzg.zzg(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.zzcnp & field.getModifiers()) != 0) {
            return true;
        }
        if (this.zzcno != -1.0d && !zza((zzbsh) field.getAnnotation(zzbsh.class), (zzbsi) field.getAnnotation(zzbsi.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.zzcnq && zzm(field.getType())) {
            return true;
        }
        if (zzl(field.getType())) {
            return true;
        }
        List<zzbrh> list = z ? this.zzcnr : this.zzcns;
        if (!list.isEmpty()) {
            zzbri com_google_android_gms_internal_zzbri = new zzbri(field);
            for (zzbrh zza : list) {
                if (zza.zza(com_google_android_gms_internal_zzbri)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected zzbsm zzabK() {
        try {
            return (zzbsm) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public zzbsm zzg(int... iArr) {
        int i = 0;
        zzbsm zzabK = zzabK();
        zzabK.zzcnp = 0;
        int length = iArr.length;
        while (i < length) {
            zzabK.zzcnp = iArr[i] | zzabK.zzcnp;
            i++;
        }
        return zzabK;
    }
}
