package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzbsl {
    private final Map<Type, zzbrn<?>> zzcmG;

    /* renamed from: com.google.android.gms.internal.zzbsl.1 */
    class C12031 implements zzbsq<T> {
        final /* synthetic */ zzbrn zzcng;
        final /* synthetic */ Type zzcnh;
        final /* synthetic */ zzbsl zzcni;

        C12031(zzbsl com_google_android_gms_internal_zzbsl, zzbrn com_google_android_gms_internal_zzbrn, Type type) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
            this.zzcng = com_google_android_gms_internal_zzbrn;
            this.zzcnh = type;
        }

        public T zzabJ() {
            return this.zzcng.zza(this.zzcnh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.2 */
    class C12042 implements zzbsq<T> {
        final /* synthetic */ zzbsl zzcni;

        C12042(zzbsl com_google_android_gms_internal_zzbsl) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
        }

        public T zzabJ() {
            return new LinkedHashMap();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.3 */
    class C12053 implements zzbsq<T> {
        final /* synthetic */ zzbsl zzcni;

        C12053(zzbsl com_google_android_gms_internal_zzbsl) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
        }

        public T zzabJ() {
            return new zzbsp();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.4 */
    class C12064 implements zzbsq<T> {
        final /* synthetic */ Type zzcnh;
        final /* synthetic */ zzbsl zzcni;
        private final zzbst zzcnj;
        final /* synthetic */ Class zzcnk;

        C12064(zzbsl com_google_android_gms_internal_zzbsl, Class cls, Type type) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
            this.zzcnk = cls;
            this.zzcnh = type;
            this.zzcnj = zzbst.zzabO();
        }

        public T zzabJ() {
            try {
                return this.zzcnj.zze(this.zzcnk);
            } catch (Throwable e) {
                String valueOf = String.valueOf(this.zzcnh);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(valueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.5 */
    class C12075 implements zzbsq<T> {
        final /* synthetic */ Type zzcnh;
        final /* synthetic */ zzbsl zzcni;
        final /* synthetic */ zzbrn zzcnl;

        C12075(zzbsl com_google_android_gms_internal_zzbsl, zzbrn com_google_android_gms_internal_zzbrn, Type type) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
            this.zzcnl = com_google_android_gms_internal_zzbrn;
            this.zzcnh = type;
        }

        public T zzabJ() {
            return this.zzcnl.zza(this.zzcnh);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.6 */
    class C12086 implements zzbsq<T> {
        final /* synthetic */ zzbsl zzcni;
        final /* synthetic */ Constructor zzcnm;

        C12086(zzbsl com_google_android_gms_internal_zzbsl, Constructor constructor) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
            this.zzcnm = constructor;
        }

        public T zzabJ() {
            String valueOf;
            try {
                return this.zzcnm.newInstance(null);
            } catch (Throwable e) {
                valueOf = String.valueOf(this.zzcnm);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e);
            } catch (InvocationTargetException e2) {
                valueOf = String.valueOf(this.zzcnm);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e2.getTargetException());
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.7 */
    class C12097 implements zzbsq<T> {
        final /* synthetic */ zzbsl zzcni;

        C12097(zzbsl com_google_android_gms_internal_zzbsl) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
        }

        public T zzabJ() {
            return new TreeSet();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.8 */
    class C12108 implements zzbsq<T> {
        final /* synthetic */ Type zzcnh;
        final /* synthetic */ zzbsl zzcni;

        C12108(zzbsl com_google_android_gms_internal_zzbsl, Type type) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
            this.zzcnh = type;
        }

        public T zzabJ() {
            if (this.zzcnh instanceof ParameterizedType) {
                Type type = ((ParameterizedType) this.zzcnh).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    return EnumSet.noneOf((Class) type);
                }
                String str = "Invalid EnumSet type: ";
                String valueOf = String.valueOf(this.zzcnh.toString());
                throw new zzbrs(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
            str = "Invalid EnumSet type: ";
            valueOf = String.valueOf(this.zzcnh.toString());
            throw new zzbrs(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbsl.9 */
    class C12119 implements zzbsq<T> {
        final /* synthetic */ zzbsl zzcni;

        C12119(zzbsl com_google_android_gms_internal_zzbsl) {
            this.zzcni = com_google_android_gms_internal_zzbsl;
        }

        public T zzabJ() {
            return new LinkedHashSet();
        }
    }

    public zzbsl(Map<Type, zzbrn<?>> map) {
        this.zzcmG = map;
    }

    private <T> zzbsq<T> zzc(Type type, Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C12097(this) : EnumSet.class.isAssignableFrom(cls) ? new C12108(this, type) : Set.class.isAssignableFrom(cls) ? new C12119(this) : Queue.class.isAssignableFrom(cls) ? new zzbsq<T>() {
            final /* synthetic */ zzbsl zzcni;

            {
                this.zzcni = r1;
            }

            public T zzabJ() {
                return new LinkedList();
            }
        } : new zzbsq<T>() {
            final /* synthetic */ zzbsl zzcni;

            {
                this.zzcni = r1;
            }

            public T zzabJ() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(cls) ? SortedMap.class.isAssignableFrom(cls) ? new zzbsq<T>() {
            final /* synthetic */ zzbsl zzcni;

            {
                this.zzcni = r1;
            }

            public T zzabJ() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzbth.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).zzacb())) ? new C12053(this) : new C12042(this) : null;
    }

    private <T> zzbsq<T> zzd(Type type, Class<? super T> cls) {
        return new C12064(this, cls, type);
    }

    private <T> zzbsq<T> zzk(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C12086(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public String toString() {
        return this.zzcmG.toString();
    }

    public <T> zzbsq<T> zzb(zzbth<T> com_google_android_gms_internal_zzbth_T) {
        Type zzacc = com_google_android_gms_internal_zzbth_T.zzacc();
        Class zzacb = com_google_android_gms_internal_zzbth_T.zzacb();
        zzbrn com_google_android_gms_internal_zzbrn = (zzbrn) this.zzcmG.get(zzacc);
        if (com_google_android_gms_internal_zzbrn != null) {
            return new C12031(this, com_google_android_gms_internal_zzbrn, zzacc);
        }
        com_google_android_gms_internal_zzbrn = (zzbrn) this.zzcmG.get(zzacb);
        if (com_google_android_gms_internal_zzbrn != null) {
            return new C12075(this, com_google_android_gms_internal_zzbrn, zzacc);
        }
        zzbsq<T> zzk = zzk(zzacb);
        if (zzk != null) {
            return zzk;
        }
        zzk = zzc(zzacc, zzacb);
        return zzk == null ? zzd(zzacc, zzacb) : zzk;
    }
}
