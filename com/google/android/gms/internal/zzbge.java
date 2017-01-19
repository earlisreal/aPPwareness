package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public final class zzbge extends zzbfw<String> {
    private static final Map<String, zzazt> zzbKP;
    private final String mValue;

    /* renamed from: com.google.android.gms.internal.zzbge.1 */
    class C10621 implements Iterator<zzbfw<?>> {
        private int zzbKZ;
        final /* synthetic */ zzbge zzbLg;

        C10621(zzbge com_google_android_gms_internal_zzbge) {
            this.zzbLg = com_google_android_gms_internal_zzbge;
            this.zzbKZ = 0;
        }

        public boolean hasNext() {
            return this.zzbKZ < this.zzbLg.mValue.length();
        }

        public /* synthetic */ Object next() {
            return zzRH();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public zzbfw<?> zzRH() {
            if (this.zzbKZ >= this.zzbLg.mValue.length()) {
                throw new NoSuchElementException();
            }
            int i = this.zzbKZ;
            this.zzbKZ = i + 1;
            return new zzbfy(Double.valueOf((double) i));
        }
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("charAt", new zzbcg());
        hashMap.put("concat", new zzbch());
        hashMap.put("hasOwnProperty", zzbbr.zzbJy);
        hashMap.put("indexOf", new zzbci());
        hashMap.put("lastIndexOf", new zzbcj());
        hashMap.put("match", new zzbck());
        hashMap.put("replace", new zzbcl());
        hashMap.put("search", new zzbcm());
        hashMap.put("slice", new zzbcn());
        hashMap.put("split", new zzbco());
        hashMap.put("substring", new zzbcp());
        hashMap.put("toLocaleLowerCase", new zzbcq());
        hashMap.put("toLocaleUpperCase", new zzbcr());
        hashMap.put("toLowerCase", new zzbcs());
        hashMap.put("toUpperCase", new zzbcu());
        hashMap.put("toString", new zzbct());
        hashMap.put("trim", new zzbcv());
        zzbKP = Collections.unmodifiableMap(hashMap);
    }

    public zzbge(String str) {
        zzac.zzw(str);
        this.mValue = str;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : obj instanceof zzbge ? this.mValue.equals((String) ((zzbge) obj).zzRF()) : false;
    }

    public String toString() {
        return this.mValue.toString();
    }

    public String value() {
        return this.mValue;
    }

    public Iterator<zzbfw<?>> zzRE() {
        return new C10621(this);
    }

    public /* synthetic */ Object zzRF() {
        return value();
    }

    public boolean zzih(String str) {
        return zzbKP.containsKey(str);
    }

    public zzazt zzii(String str) {
        if (zzih(str)) {
            return (zzazt) zzbKP.get(str);
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 51).append("Native Method ").append(str).append(" is not defined for type ListWrapper.").toString());
    }

    public zzbfw<?> zznc(int i) {
        return (i < 0 || i >= this.mValue.length()) ? zzbga.zzbKV : new zzbge(String.valueOf(this.mValue.charAt(i)));
    }
}
